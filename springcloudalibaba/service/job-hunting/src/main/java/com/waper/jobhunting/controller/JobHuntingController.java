package com.waper.jobhunting.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbitmq.client.*;
import com.waper.jobhunting.config.DelayedExchangeConfig;
import com.waper.common.entity.R;
import com.waper.common.test.MyThread;
import com.waper.jobhunting.service.*;
import com.waper.jobhuntingapi.entity.Hero;
import com.waper.jobhuntingapi.entity.Item;
import com.waper.jobhuntingapi.entity.JobHunting;
import com.waper.jobhuntingapi.entity.Summoner;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.http.Method;
import io.swagger.annotations.*;
import org.apache.commons.io.FileUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName JobHuntingController
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/11/7 16:06
 */
@Api(value = "找个勾八工作",tags = "找个勾八工作")
@RestController
@RequestMapping(value = "/jobHunting")
public class JobHuntingController {

    /**
     * 默认存储桶
     */
    @Value("${minio.bucketName}")
    private String bucketName;

    @Resource
    private MinioClient minioClient;
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private JobHuntingService jobHuntingService;

    @Autowired
    private HeroService heroService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private SummonerService summonerService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private DelayedMessageProducer delayedMessageProducer;

    @Value("${json.hero}")
    String hero ;

    @Value("${spring.rabbitmq:host}")
    String rabbitmqHost ;




    private  final static  String  QUEUE_NAME = "hello";

    public    void connection () {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitmqHost);
        try {
            // 连接
            Connection connection = factory.newConnection();
            // 管道
            Channel channel = connection.createChannel();
            // 队列声明
            channel.queueDeclare(QUEUE_NAME, false, false,false, null);
            // 发送内容
            String message = "Hello World!";
            //
            channel.basicPublish("", QUEUE_NAME, null , message.getBytes());

            System.out.println("[x]" +message);
            channel.basicAck(1,true);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping(value = "comsumer")
    public static void comsumer () {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.80.128");
        try {
            // 连接
            Connection connection = factory.newConnection();
            // 管道
            Channel channel = connection.createChannel();
            // 队列声明
            channel.queueDeclare(QUEUE_NAME, false, false,false, null);
            String s = channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel){
                // body：从队列中取出的消息
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    System.out.println("Message: " + new String(body));
                }

            });



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping(value = "/listJobHunting")
    @ApiOperation(value = "找工作列表")
    public R<List<JobHunting>> listJobHunting(){
       return R.success(jobHuntingService.list()) ;
    }

    @PostMapping(value = "/insertJobHunting")
    @ApiOperation(value = "新增找工作")
    public R insertJobHunting(@RequestBody JobHunting jobHunting){
        jobHunting.setCreateTime(LocalDateTime.now());
        return R.success(jobHuntingService.save(jobHunting)) ;
    }

    @PostMapping(value = "/updateJobHunting")
    @ApiOperation(value = "修改找工作")
    public R updateJobHunting(@RequestBody JobHunting jobHunting) {
        jobHunting.setUpdateTime(LocalDateTime.now());
        return R.success(jobHuntingService.updateById(jobHunting));
    }


    @PostMapping(value = "/getJobHuntingById")
    @ApiOperation(value = "根据id获取找到工作信息")
    public R<JobHunting> getJobHuntingById(Integer id) {
        return R.success(jobHuntingService.getById(id));
    }



        @GetMapping("/sendEmail")
    @ApiOperation(value = "发送邮件")
    public R sendEmail () {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("563667426@qq.com");
        message.setTo("563667426@qq.com");
        message.setSubject("fuck");
        message.setText("ok");
        try {
            javaMailSender.send(message);
            System.out.println("简单邮件已经发送");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发送简单邮件时发生异常");
        }
        return R.success("简单邮件已经发送");
    }

    public static void queueTest () {
        Queue<String> queue = new LinkedList<>();
        queue.offer("hello");
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System. out. println("获得锁");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System. out. println("释放锁");
            lock. unlock();
        }

    }
    @GetMapping(value = "getString")
    public String getString (@RequestHeader(value = "key", required = false)String key) {
        System.out.println("请求头"+key);
        return "请求头："+key;
    }

    @GetMapping(value = "rabbimqTest")
    public void rabbimqTest() {
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "hello";
        rabbitTemplate.convertAndSend(queueName ,message);


    }


    public static void multiThread () throws Exception {

    }

    public static void main(String[] args) throws Exception {
        Map<String,Object> map = new HashMap<>(16);
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
    }


    @ApiOperation(value = "读取王者荣耀英雄信息，并添加到数据库中")
    @GetMapping(value = "/readHeroJsonFileToDatabases")
    public R readHeroJsonFileToDatabases () {
        String jsonString = null;
        try {
            File file = ResourceUtils.getFile("classpath:herolist.json");
            jsonString = FileUtils.readFileToString(file, "utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }

        List<Hero> list = JSONObject.parseArray(jsonString, Hero.class);
        boolean b = heroService.saveBatch(list);
        return b ? R.success(list) :R.fail();

    }

    @ApiOperation(value = "读取王者荣耀武器信息，并添加到数据库中")
    @GetMapping(value = "/readItemJsonFileToDatabases")
    public R readItemJsonFileToDatabases () {
        String jsonString = null;
        try {
            File file = ResourceUtils.getFile("classpath:item.json");
            jsonString = FileUtils.readFileToString(file, "utf-8");
            System.out.println("jsonString = " + jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<Item> list = JSONObject.parseArray(jsonString, Item.class);
//        list.stream()
//                .map(m -> {
//                    m.setDes2( );
//                    if (m == null) {
//                        m.getDes1().replaceAll("<[^>]+>","")
//                    }
//                    return m;
//                }).collect(Collectors.toList());

        boolean b = itemService.saveBatch(list);
        return b ? R.success() :R.fail();

    }


    @ApiOperation(value = "读取王者荣耀召唤师信息，并添加到数据库中")
    @GetMapping(value = "/readSummonerJsonFileToDatabases")
    public R readSummonerJsonFileToDatabases () {
        String jsonString = null;
        try {
            File file = ResourceUtils.getFile("classpath:summoner.json");
            jsonString = FileUtils.readFileToString(file, "utf-8");
            System.out.println("jsonString = " + jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<Summoner> list = JSONObject.parseArray(jsonString, Summoner.class);

        boolean b = summonerService.saveBatch(list);
        return b ? R.success() :R.fail();

    }
    @ApiOperation(value = "英雄列表")
    @GetMapping(value = "/listHero")
    public R listHero(Hero hero) {
        QueryWrapper<Hero> heroQueryWrapper = new QueryWrapper<>();
        return R.success(heroService.listHero());
    }
    @ApiOperation(value = "装备列表")
    @GetMapping(value = "/listItem")
    public R listItem(Item item) {
        QueryWrapper<Item> itemQueryWrapper = new QueryWrapper<>();
        return R.success(itemService.listItem());
    }
    @ApiOperation(value = "召唤师列表")
    @GetMapping(value = "/listSummoner")
    public R listSummoner(Summoner summoner) {
        QueryWrapper<Summoner> queryWrapper = new QueryWrapper<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                10,
                1000,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );
        return R.success(summonerService.list(queryWrapper));
    }


    // 1、解析数据放入 es 索引中
    public Boolean parseContent(String keyword) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest("fuck").id("1").source(JSON.toJSONString("ffff"), XContentType.JSON));
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        restHighLevelClient.close();
        return !bulk.hasFailures();
    }


    // 2、根据keyword分页查询结果
    public List<Map<String, Object>> search(String keyword, Integer pageIndex, Integer pageSize) throws IOException {
        if (pageIndex < 0){
            pageIndex = 0;
        }
        SearchRequest jd_goods = new SearchRequest("jd_goods");
        // 创建搜索源建造者对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 条件采用：精确查询 通过keyword查字段name
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", keyword);
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));// 60s
        // 分页
        searchSourceBuilder.from(pageIndex);
        searchSourceBuilder.size(pageSize);
        // 高亮
        // ....
        // 搜索源放入搜索请求中
        jd_goods.source(searchSourceBuilder);
        // 执行查询，返回结果
        SearchResponse searchResponse = restHighLevelClient.search(jd_goods, RequestOptions.DEFAULT);
        restHighLevelClient.close();
        // 解析结果
        SearchHits hits = searchResponse.getHits();
        List<Map<String,Object>> results = new ArrayList<>();
        for (SearchHit documentFields : hits.getHits()) {
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
            results.add(sourceAsMap);
        }
        // 返回查询的结果
        return results;
    }


    public List<Map<String, Object>> parse(@PathVariable("keyword") String keyword,
                                           @PathVariable("pageIndex") Integer pageIndex,
                                           @PathVariable("pageSize") Integer pageSize) throws IOException {
        return search(keyword,pageIndex,pageSize);
    }


    @PostMapping("fileUpload")
    @ApiOperation(value = "图片上传接口")
    @ApiModelProperty(value = "图片",name = "file",required = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "文件",required = true),
            @ApiImplicitParam(name = "directory",value = "要上传的目录")
    })
    public R fileUpload(@NotNull MultipartFile file,String directory) {
            // 获取文件输入流
            String imgUrl = fileUploadService.uploadImgFile(file);
            return R.success(imgUrl);
    }


    @PostMapping("batchFileUpload")
    @ApiOperation(value = "批量图片上传接口")
    @ApiModelProperty(value = "图片",name = "files",required = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "文件",required = true),
            @ApiImplicitParam(name = "directory",value = "要上传的目录")
    })
    public R batchFileUpload(@RequestParam("files") MultipartFile files [],String bucketName) {

        boolean result = fileUploadService.batchUploadImgFile(files);
        return result ? R.success("上传成功") : R.fail("上传失败");
    }
    @GetMapping("getDownloadUrl")
    @ApiOperation("获取文件下载连接")
    public String getDownloadUrl (String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String hero1 = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket(bucketName).object(fileName).build());
        return hero1;
    }


    /**
     * 下载文件
     *
     * @param pathUrl 文件全路径
     * @return
     */
    @GetMapping("downLoadFile")
    @ApiOperation("下载文件")
    public byte[] downLoadFile(String pathUrl){
        return fileUploadService.downLoadFile(pathUrl);
    }


    /**
     * 下载文件
     *
     * @return
     */
    @GetMapping("downLoadFile2")
    @ApiOperation("下载文件")
    public void downLoadFile2(String fileName, HttpServletResponse response){
         fileUploadService.downLoadFile2(fileName,response);
    }

    /**
     * 发送延迟消息
     * @param message
     * @return
     */
    @GetMapping("/send")
    @ApiOperation("发送延迟消息")
    @ApiImplicitParam(name = "message",value = "消息")
    public String sendDirectMessage(@RequestParam String message) {
        delayedMessageProducer.sendDelayedMessage(message);
        return "Delayed message sent to Exchange: " + message;
    }

    /**
     * 监听延迟队列
     * @param message
     */
    @RabbitListener(queues = DelayedExchangeConfig.QUEUE_NAME)
    public void receiveDelayedMessage(String message) {
        System.out.println("Received delayed message: " + message);
    }

    /***
     * 发送延时消息2
     * @param data 消息
     * @param delay  时间
     */
    @GetMapping("/sendDelayedMessage")
    @ApiOperation("发送延迟消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message",value = "消息"),
            @ApiImplicitParam(name = "delay",value = "时间"),
    })
    public void syncSendDelayed(String data, Integer delay) {
        MessagePostProcessor postProcessor = postProcessMessage -> {
            // 设置过期时间
            postProcessMessage.getMessageProperties().setHeader("x-delay", delay == null ? 0 : 3000);
                return postProcessMessage;
        };
        // 发送延时消息
        rabbitTemplate.convertAndSend(DelayedExchangeConfig.EXCHANGE_NAME, DelayedExchangeConfig.ROUTING_KEY, data, postProcessor);
    }

    @GetMapping("/send-message")
    @ApiOperation("send-message")
    public void sendMessage() {
        String queueName = "myQueue";
        Object message = "Hello, RabbitMQ!";
        rabbitTemplate.convertAndSend(queueName,message);
    }
    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        // 处理接收到的消息
        System.out.println("Received message: " + message);
    }




}

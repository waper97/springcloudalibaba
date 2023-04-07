package com.waper.jobhunting.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbitmq.client.*;
import com.waper.common.entity.R;
import com.waper.common.test.MyThread;
import com.waper.jobhunting.mapper.JobHuntingMapper;
import com.waper.jobhunting.service.HeroService;
import com.waper.jobhunting.service.ItemService;
import com.waper.jobhunting.service.JobHuntingService;
import com.waper.jobhunting.service.SummonerService;
import com.waper.jobhuntingapi.entity.Hero;
import com.waper.jobhuntingapi.entity.Item;
import com.waper.jobhuntingapi.entity.JobHunting;
import com.waper.jobhuntingapi.entity.Summoner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
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
@Api(value = "找工作")
@RestController
@RequestMapping(value = "/jobHunting")
public class JobHuntingController {
    @Resource
    private JobHuntingMapper jobHuntingMapper;
    @Autowired()
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

    @Value("${json.hero}")
    String hero ;

    private  final static  String  QUEUE_NAME = "hello";

    public  static  void connection () {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.170.130");
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
        factory.setHost("192.168.170.130");
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
            System.out.println("jsonString = " + jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<Hero> list = JSONObject.parseArray(jsonString, Hero.class);
        boolean b = heroService.saveBatch(list);
        return b ? R.success(jsonString) :R.fail();

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
        return R.success(heroService.list(heroQueryWrapper));
    }
    @ApiOperation(value = "装备列表")
    @GetMapping(value = "/listItem")
    public R listItem(Item item) {
        QueryWrapper<Item> itemQueryWrapper = new QueryWrapper<>();
        return R.success(itemService.list(itemQueryWrapper));
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


}

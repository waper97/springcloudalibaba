package com.waper.dataanalysis.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.waper.common.entity.R;
import com.waper.dataanalysisapi.entity.Hero;
import com.waper.dataanalysisapi.entity.Props;
import com.waper.dataanalysis.service.HeroService;
import com.waper.dataanalysis.service.ItemService;
import com.waper.dataanalysis.util.AnalysisJsonUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @ClassName HeroController
 * @Description 英雄控制器
 * @Author wangpeng
 * @Date 2020/8/18 10:40
 */
@RestController
@RequestMapping("/waper/api/hero")
@Slf4j
public class HeroController extends BaseController {
//    @Value("${hero}")
    private String hero;
    @Autowired
    private HeroService heroService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    final private String HERO_LIST_KEY = "hero:list";
    @GetMapping("/index")
    public String index () {
        return "index";
    }

    /**
     * 根绝json文件获取英雄数据，并保存再数据库里
     * @param filePath
     * @return
     */
    @GetMapping("test")
    public  Object test(String filePath){
        System.out.println(hero);
        filePath = "C:\\Users\\Administrator\\Desktop\\herolist.json";
        String jsonStr = "";
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            // 读取文件
            Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while((ch = reader.read()) != -1){
                sb.append((char)ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();

            // json数组转数组
            JSONArray jsonArray =  JSONArray.parseArray(jsonStr);
            List<Hero> heroList = JSONArray.parseArray(jsonArray.toString(), Hero.class);
            List<Hero> all = heroService.findAll();
            if (all != null && all.size() > 0) {
                return successData(all);
            }else{
                heroService.saveAll(heroList);
                return successData(heroList);
            }

//            // 创建rabbit管理器
//            RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitTemplate.getConnectionFactory());
//            DirectExchange exchange = new DirectExchange("addhero");
//            rabbitAdmin.declareExchange(exchange);
//
//            // 创建消息队列queue
//            Queue queue =  new Queue("addhero",true);
//            Binding binding = BindingBuilder.bind(queue).to(exchange).with("1113");

//            rabbitTemplate.convertAndSend("addhero","添加英雄成功!");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 感觉参数查询英雄
     * @param hero
     * @return
     */
    @GetMapping("listHero")
    public Object listHero(Hero hero){

       String redisHeroList  = String.valueOf(redisTemplate.opsForValue().get(HERO_LIST_KEY));
       if (StringUtils.isEmpty(redisHeroList) || "null".equals(redisHeroList)) {
           Example<Hero> heroExample = Example.of(hero);
           List<Hero> heroList = heroService.findAll(heroExample);
           if (heroList !=null && heroList.size() > 0) {
               redisTemplate.opsForValue().set(HERO_LIST_KEY,heroList);
           }
           return successData(heroList);
       }else{
         return successData(redisHeroList);
       }

    }
    @GetMapping("findOne")
    public Object findOne(Hero hero){
        Example<Hero> heroExample = Example.of(hero);
       return  successData(heroService.findOne(heroExample));
    }

    /**
     * 保存武器列表到数据库
     * @return
     */
    @GetMapping("saveItems")
    public Object saveItems(){
        String jsonStr =  AnalysisJsonUtil.JsonStringToJsonArray();
        JSONArray jsonArray =  JSONArray.parseArray(jsonStr);
        List<Props> propsList = JSONArray.parseArray(jsonArray.toString(), Props.class);
        return successData(itemService.saveAll(propsList));
    }

    /**
     * 武器列表
     * @param props
     * @return
     */
    @GetMapping("listItems")
    public Object listItems(Props props){
        Example<Props> propsExample = Example.of(props);
        return  successData(itemService.findAll(propsExample));
    }


    /**
     * 上传英雄
     * @return
     */
    @ApiOperation(value = "上传英雄")
    @PostMapping(value = "uploadHero")
    public R uploadHero(MultipartFile multipartFile){
        return R.success();
    }

    @GetMapping(value = "sendMessageToRabbitMq")
    public void sendMessageToRabbitMq(){
        String exchange = "amqp.Exchange";
        String message ="{\"1\":\"倔强青铜III\",\"2\":\"倔强青铜II\",\"3\":\"倔强青铜I\",\"4\":\"秩序白银III\",\"5\":\"秩序白银II\",\"6\":\"秩序白银I\",\"17\":\"荣耀黄金IV\",\"7\":\"荣耀黄金III\",\"8\":\"荣耀黄金II\",\"9\":\"荣耀黄金I\",\"18\":\"尊贵铂金V\",\"19\":\"尊贵铂金IV\",\"10\":\"尊贵铂金III\",\"11\":\"尊贵铂金II\",\"12\":\"尊贵铂金I\",\"20\":\"永恒钻石V\",\"21\":\"永恒钻石IV\",\"13\":\"永恒钻石III\",\"14\":\"永恒钻石II\",\"15\":\"永恒钻石I\",\"22\":\"至尊星耀V\",\"23\":\"至尊星耀IV\",\"24\":\"至尊星耀III\",\"25\":\"至尊星耀II\",\"26\":\"至尊星耀I\"}";
        rabbitTemplate.convertAndSend(exchange, message);
    }

}


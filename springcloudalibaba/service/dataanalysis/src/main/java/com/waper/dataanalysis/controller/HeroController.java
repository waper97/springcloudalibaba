package com.waper.dataanalysis.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.waper.dataanalysis.entity.Hero;
import com.waper.dataanalysis.entity.Props;
import com.waper.dataanalysis.service.HeroService;
import com.waper.dataanalysis.service.ItemService;
import com.waper.dataanalysis.util.AnalysisJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;

/**
 * @ClassName HeroController
 * @Description 英雄控制器
 * @Author wangpeng
 * @Date 2020/8/18 10:40
 */
@RestController
@RequestMapping("waper/api/hero")
@Slf4j
public class HeroController extends BaseController {
    @Value("${hero}")
    private String url;
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
    /**
     * 根绝json文件获取英雄数据，并保存再数据库里
     * @param filePath
     * @return
     */
    @GetMapping("test")
    public  Object test(String filePath){
        System.out.println(url);
        filePath = "C:\\Users\\Administrator\\Desktop\\herolist.json";
        String jsonStr = "";
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            // 读取文件
            Reader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
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
            heroService.saveAll(heroList);
//            // 创建rabbit管理器
//            RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitTemplate.getConnectionFactory());
//            DirectExchange exchange = new DirectExchange("addhero");
//            rabbitAdmin.declareExchange(exchange);
//
//            // 创建消息队列queue
//            Queue queue =  new Queue("addhero",true);
//            Binding binding = BindingBuilder.bind(queue).to(exchange).with("1113");

//            rabbitTemplate.convertAndSend("addhero","添加英雄成功!");

            log.info("发送消息成功");
            return successData(jsonStr);
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
       if (StringUtils.isEmpty(redisHeroList) || redisHeroList == "null") {
           Example<Hero> heroExample = Example.of(hero);
           List<Hero> heroList = heroService.findAll(heroExample);
           if (heroList !=null && heroList.size() > 0) {
               redisTemplate.opsForValue().set(HERO_LIST_KEY,heroList);
           }
           return successData(heroList);
       }else{
         return successData(JSONObject.parseArray(redisHeroList,Hero.class));
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

}


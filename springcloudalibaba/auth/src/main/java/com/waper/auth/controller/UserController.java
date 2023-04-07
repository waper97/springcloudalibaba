package com.waper.auth.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.waper.auth.entity.User;
import com.waper.auth.service.UserService;
import com.waper.common.entity.R;
import com.waper.dataanalysisapi.entity.Hero;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.TimeUnit;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/2/9 18:53
 */
@RequestMapping("/auth")
@RestController
public class UserController {
    public static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    RedisTemplate redisTemplate;


    @PostMapping("/login")
    public R login(@RequestParam String userName, @RequestParam String password , HttpServletRequest request) {
        System.out.println("userName  = " + userName );
        System.out.println("password  = " + password );
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        User user = userService.getOne(userLambdaQueryWrapper.eq(User::getUserName, userName).eq(User::getPassword, password));
        if (user == null) {
            return R.fail();
        }
        redisTemplate.opsForValue().set(user.getUserName(),user);
        return R.success(user);
    }

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping(value = "/listUser")
    public List<User> listUser () {
        return userService.list();
    }


    @GetMapping("/insertGoodsByFeign")
    public String insertGoodsByFeign () {
       return  userService.insertGoodsByFeign();
    }

    public static void testForArrayList () {

        List<User> listUser1 = new ArrayList<>();
        List<User> listUser2 = new LinkedList<>();
        Set<User> hashSet = new HashSet<>();
        Map<String,Object> treeMap = new TreeMap<>();
        Map<String,Object> hashMap = new HashMap<>(16);
        treeMap.put("a","a");
        treeMap.put("b","b");
        treeMap.put("c","c");
        hashMap.put("b","b");
        hashMap.put("a","a");
        hashMap.put("c","c");
        LOGGER.info(treeMap);
        LOGGER.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        LOGGER.info(hashMap);
    }

    @GetMapping("/addHeroForRabbitMq")
    public void addHeroForRabbitMq () {
        String queueName = "hero-queue";
        Hero hero = new Hero();
        hero.setEname(1L);
        hero.setCname("李白");
        hero.setTitle("李白");
        hero.setNewType("1");
        hero.setHeroType("刺客");
        hero.setSkinName("凤求凰");
        rabbitTemplate.convertAndSend("queueName",hero);
        System.out.println("hero = " + hero);

    }


    @RequestMapping("/sentinel1")
    public String sentinel1(){
        //模拟一次网络延时
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sentinel1";
    }
    @RequestMapping("/sentinel2")
    public String sentinel2(){
        return "测试高并发下的问题";
    }


    public static void main(String[] args) {
        testForArrayList();
    }
}

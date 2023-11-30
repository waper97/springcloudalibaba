package com.waper.jobhunting.controller;

import com.alibaba.nacos.api.naming.pojo.healthcheck.impl.Http;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName Bilibli
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/3/4 20:18
 */
@RequestMapping("/test")
@RestController
public class BilibliController {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Value("${name}")
    String name;

    @GetMapping("/getName")
    public String  test  () {
        return name;
    }

}

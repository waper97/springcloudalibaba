package com.waper.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ServerController
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/3/31 14:23
 */
@RestController
@RequestMapping(value = "/server")
public class ServerController {
    @Value("${json}")
    String json;
    @GetMapping("/test/{id}")
    public Object test (@PathVariable String id ) {
        Map<String,Object> map = new HashMap<>(16);
        map.put("server",id);
        map.put("json",json);
        return map;
    }
}

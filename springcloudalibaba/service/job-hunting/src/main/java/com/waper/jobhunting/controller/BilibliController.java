package com.waper.jobhunting.controller;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

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
    public static  int sum(int n) {
        if (n == 1) {
            return 1;

        }
        return n* sum(n-1);
    }
    public static void main(String[] args) {
        String name =   "test";
        HashMap<String, Integer> map = new HashMap<String, Integer>(16);

        System.out.println(sum(3));
    }

}

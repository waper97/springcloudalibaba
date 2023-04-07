package com.waper.dobbocomsumer.controller;

import com.waper.dubboprovider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

/**
 * @ClassName ComsumerController
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/12/18 18:10
 */
@RestController
public class ComsumerController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/sayHello")
    public String SayHello() {
        String helloString = providerService.sayHello("Hello");
        return helloString;
    }
}

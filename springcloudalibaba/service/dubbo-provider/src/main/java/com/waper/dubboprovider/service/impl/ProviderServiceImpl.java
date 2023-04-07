package com.waper.dubboprovider.service.impl;

import com.waper.dubboprovider.service.ProviderService;

import javax.xml.ws.Provider;

/**
 * @ClassName ProviderServiceImpl
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/12/18 18:01
 */
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String words) {
        return words;
    }
}

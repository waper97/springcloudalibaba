package com.waper.goodsserviceapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "goods-service",fallback = GoodsFeignServiceException.class)
public interface GoodsFeignService {

    @GetMapping("/goods/inserGoods")
    String inserGoods();
}

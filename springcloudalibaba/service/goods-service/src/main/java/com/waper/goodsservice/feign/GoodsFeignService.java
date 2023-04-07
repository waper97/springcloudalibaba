package com.waper.goodsservice.feign;

import com.waper.goodsservice.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@FeignClient(value = "goods-service")
public interface GoodsFeignService {

    @GetMapping("/inserGoods")
    String inserGoods();
}

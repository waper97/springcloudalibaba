package com.waper.goodsservice.controller;

import com.waper.goodsservice.entity.Goods;
import com.waper.goodsservice.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName GoodsController
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/2/14 20:44
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @GetMapping("/inserGoods")
    public String inserGoods() {
        Goods goods = new Goods();
        goods.setName("Iphone 11");
        goods.setProductPlace("China");
        goods.setProductDate(new Date().toString());
        int i = 0;
        if (i == 0) {
            throw new NullPointerException();
        }
        boolean save = goodsService.save(goods);
        return save ? "添加成功" : "添加失败";
    }
}

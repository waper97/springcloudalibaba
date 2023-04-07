package com.waper.goodsservice.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waper.goodsservice.entity.Goods;
import com.waper.goodsservice.mapper.GoodsMapper;
import com.waper.goodsservice.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * @ClassName GoodsServiceImpl
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/2/14 20:42
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}

package com.waper.jobhunting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waper.jobhunting.mapper.ItemMapper;
import com.waper.jobhunting.mapper.JobHuntingMapper;
import com.waper.jobhunting.service.ItemService;
import com.waper.jobhunting.service.JobHuntingService;
import com.waper.jobhuntingapi.entity.Item;
import com.waper.jobhuntingapi.entity.JobHunting;
import org.springframework.stereotype.Service;

/**
 * @ClassName JobHuntingService
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/11/7 15:10
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {
}

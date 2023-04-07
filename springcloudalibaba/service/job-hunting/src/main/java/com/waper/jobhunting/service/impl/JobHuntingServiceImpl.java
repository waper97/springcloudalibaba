package com.waper.jobhunting.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waper.jobhunting.mapper.JobHuntingMapper;
import com.waper.jobhunting.service.JobHuntingService;
import com.waper.jobhuntingapi.entity.JobHunting;
import org.springframework.stereotype.Service;

/**
 * @ClassName JobHuntingService
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/11/7 15:10
 */
@Service
public class JobHuntingServiceImpl extends ServiceImpl<JobHuntingMapper,JobHunting> implements JobHuntingService {
}

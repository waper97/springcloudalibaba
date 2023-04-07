package com.waper.jobhunting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waper.jobhunting.mapper.JobHuntingMapper;
import com.waper.jobhunting.mapper.SummonerMapper;
import com.waper.jobhunting.service.JobHuntingService;
import com.waper.jobhunting.service.SummonerService;
import com.waper.jobhuntingapi.entity.JobHunting;
import com.waper.jobhuntingapi.entity.Summoner;
import org.springframework.stereotype.Service;

/**
 * @ClassName SummonerService
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/11/7 15:10
 */
@Service
public class SummonerServiceImpl extends ServiceImpl<SummonerMapper, Summoner> implements SummonerService {
}

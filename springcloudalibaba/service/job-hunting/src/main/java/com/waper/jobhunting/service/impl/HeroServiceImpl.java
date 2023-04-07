package com.waper.jobhunting.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waper.jobhunting.mapper.HeroMapper;
import com.waper.jobhunting.service.HeroService;
import com.waper.jobhuntingapi.entity.Hero;
import org.springframework.stereotype.Service;

/**
 * @ClassName HeroServiceImpl
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/3/26 19:52
 */
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero> implements HeroService {
}

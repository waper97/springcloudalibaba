package com.waper.jobhunting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waper.jobhuntingapi.entity.Hero;

import java.util.List;

public interface HeroService extends IService<Hero> {
    /**
     *
     * @return
     */
    List<Hero> listHero();
}

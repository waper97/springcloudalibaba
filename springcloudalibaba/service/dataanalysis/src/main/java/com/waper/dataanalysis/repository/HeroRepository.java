package com.waper.dataanalysis.repository;

import com.waper.dataanalysis.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName HeroRepository
 * @Description TODO
 * @Author wangpeng
 * @Date 2021/6/21 15:13
 */
public interface HeroRepository  extends JpaRepository<Hero,Long> {

}

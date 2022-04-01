package com.waper.dataanalysis.service;

import com.waper.dataanalysis.entity.Hero;
import com.waper.dataanalysis.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName HeroService
 * @Description TODO
 * @Author wangpeng
 * @Date 2021/6/21 15:14
 */
@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<Hero> findAll(Example<Hero> hero){
        return heroRepository.findAll(hero);
    }
    public List<Hero> findAll(){
        return heroRepository.findAll();
    }

    public Optional<Hero> findOne(Example<Hero> hero){

        return heroRepository.findOne(hero);
    }

    public Hero save(Hero hero){
        return (Hero) heroRepository.save(hero);
    }

    public Object saveAll(List<Hero> heroList){
        return heroRepository.saveAll(heroList);
    }
}

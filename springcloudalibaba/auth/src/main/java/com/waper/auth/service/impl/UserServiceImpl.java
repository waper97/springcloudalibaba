package com.waper.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waper.auth.entity.User;
import com.waper.auth.mapper.UserMapper;
import com.waper.auth.service.UserService;
import com.waper.goodsserviceapi.feign.GoodsFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/2/9 18:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private GoodsFeignService goodsFeignService;



    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public String insertGoodsByFeign() {
        System.out.println("auth--service coming");
        User user = new User();
        user.setName("王鹏");
        user.setUserName("waper");
        user.setAge(26);
        user.setPassword("123456");
        boolean result  = baseMapper.insert(user) > 0;
        return goodsFeignService.inserGoods();
    }
}

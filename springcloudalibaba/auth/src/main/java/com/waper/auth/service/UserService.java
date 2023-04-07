package com.waper.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waper.auth.entity.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/2/9 18:49
 */
public interface UserService extends IService<User> {
    String insertGoodsByFeign();
}

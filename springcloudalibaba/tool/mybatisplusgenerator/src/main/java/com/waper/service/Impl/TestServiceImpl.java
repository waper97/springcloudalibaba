package com.waper.service.Impl;

import com.waper.entity.Test;
import com.waper.mapper.TestMapper;
import com.waper.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @auther wangpeng
 * @create 2022-03-30
 * @describe 服务实现类
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}

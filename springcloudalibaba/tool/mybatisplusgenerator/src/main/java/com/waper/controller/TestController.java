package com.waper.controller;
import com.waper.entity.Test;
import com.waper.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import io.swagger.annotations.ApiOperation;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangpeng
 * @since 2022-03-30
 */

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ITestService testService;

    @GetMapping("/list")
    @ApiOperation(value = "列表查询",notes = "list")
    public List<Test> list(){
        return testService.list();
    }

    @GetMapping("/detail")
    @ApiOperation(value = "查看详情",notes = "Test")
    public Test getTestById(Long id){
            return testService.getById(id);
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增",notes = "Test")
    public boolean saveTest(Test test){
            return testService.save(test);
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "新增/修改",notes = "Test")
    public boolean saveOrUpdate(Test test){
            return testService.saveOrUpdate(test);
    }

    @PostMapping("/修改")
    @ApiOperation(value = "修改",notes = "Test")
    public boolean update(Test test){
        return testService.updateById(test);
    }

    @PostMapping("/remove")
    @ApiOperation(value = "删除",notes = "Test")
    public boolean remove(Long id){
        return testService.removeById(id);
    }

}

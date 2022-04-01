package com.waper.service;

import com.waper.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;import io.swagger.annotations.Api;

/**
 * @auther wangpeng
 * @create 2022-03-30
 * @describe 学生表服务类
 */
@Api(value = "Student服务类")
public interface IStudentService extends IService<Student> {

}

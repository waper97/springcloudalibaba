package com.waper.service.Impl;

import com.waper.entity.Student;
import com.waper.mapper.StudentMapper;
import com.waper.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @auther wangpeng
 * @create 2022-03-30
 * @describe 学生表服务实现类
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}

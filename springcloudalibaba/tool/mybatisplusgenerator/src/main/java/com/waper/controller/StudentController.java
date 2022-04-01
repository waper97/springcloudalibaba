package com.waper.controller;
import com.waper.entity.Student;
import com.waper.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import io.swagger.annotations.ApiOperation;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 学生表 前端控制器
 * </p>
 *
 * @author wangpeng
 * @since 2022-03-30
 */

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/list")
    @ApiOperation(value = "学生表列表查询",notes = "list")
    public List<Student> list(){
        return studentService.list();
    }

    @GetMapping("/detail")
    @ApiOperation(value = "学生表查看详情",notes = "Student")
    public Student getStudentById(Long id){
            return studentService.getById(id);
    }

    @PostMapping("/save")
    @ApiOperation(value = "学生表新增",notes = "Student")
    public boolean saveStudent(Student student){
            return studentService.save(student);
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "学生表新增/修改",notes = "Student")
    public boolean saveOrUpdate(Student student){
            return studentService.saveOrUpdate(student);
    }

    @PostMapping("/修改")
    @ApiOperation(value = "学生表修改",notes = "Student")
    public boolean update(Student student){
        return studentService.updateById(student);
    }

    @PostMapping("/remove")
    @ApiOperation(value = "学生表删除",notes = "Student")
    public boolean remove(Long id){
        return studentService.removeById(id);
    }

}

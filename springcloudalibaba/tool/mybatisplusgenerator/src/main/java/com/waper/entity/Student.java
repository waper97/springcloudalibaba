package com.waper.entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;


/**
 * @Package: com.waper.entity
 * @Author wangpeng
 * @CreateDate 2022-03-30
 * @describe 学生表实体类
 */


@Data
@TableName("student")
@ApiModel(value="Student对象", description="学生表")
    public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "学号")
    private String student_no;

    @ApiModelProperty(value = "班级id")
    private String class_id;

    @ApiModelProperty(value = "选修课程id")
    private String course_id;

    @ApiModelProperty(value = "创建人id")
    private String creator_id;

    @ApiModelProperty(value = "创建时间")
    private LocalDate create_time;

    @ApiModelProperty(value = "修改时间")
    private LocalDate update_time;


}
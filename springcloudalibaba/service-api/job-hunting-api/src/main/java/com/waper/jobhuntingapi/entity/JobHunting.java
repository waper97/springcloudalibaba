package com.waper.jobhuntingapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 找工作
 * @ClassName JobHunting
 * @Description 找工作
 * @Author wangpeng
 * @Date 2022/11/7 15:59
 */
@Data
@ApiModel(value = "找工作")
public class JobHunting implements Serializable {
    private static final long serialVersionUID = 1218435497791427828L;
    @ApiModelProperty(value = "id", name = "id")
    private Integer id;

    @ApiModelProperty(value = "name", name = "名称")
    private String name;

    @ApiModelProperty(value = "age", name = "年龄")
    private Integer age;

    @ApiModelProperty(value = "mobile", name = "电话")
    private String mobile;

    @ApiModelProperty(value = "salary", name = "薪资")
    private BigDecimal salary;

    @ApiModelProperty(value = "birthday", name = "生日")
    private String birthday;

}

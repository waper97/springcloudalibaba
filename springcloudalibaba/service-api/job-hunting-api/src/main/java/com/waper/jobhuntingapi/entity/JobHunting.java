package com.waper.jobhuntingapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @ApiModelProperty("id")
    private Integer id;
    @NotEmpty(message = "名称不能为空!")
    @ApiModelProperty("名称")
    private String name;

    @NotNull(message = "年龄不能为空!")
    @ApiModelProperty("年龄")
    private Integer age;

    @NotEmpty(message = "电话不能为空!")
    @ApiModelProperty("电话")
    private String mobile;

    @ApiModelProperty("薪资")
    private BigDecimal salary;

    @ApiModelProperty("生日")
    private String birthday;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

}

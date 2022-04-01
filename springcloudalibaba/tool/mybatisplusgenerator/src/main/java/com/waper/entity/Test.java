package com.waper.entity;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;


/**
 * @Package: com.waper.entity
 * @Author wangpeng
 * @CreateDate 2022-03-30
 * @describe 实体类
 */


@Data
@TableName("test")
@ApiModel(value="Test对象", description="")
    public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;


}
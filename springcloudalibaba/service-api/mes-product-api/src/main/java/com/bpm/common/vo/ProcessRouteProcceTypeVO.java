package com.bpm.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName ProcessRouteProcceTypeVO
 * @Description 工艺路线 分类
 * @Author wangpeng
 * @Date 2022/5/28 17:23
 */
@Data
@ApiModel(value = "工艺路线分类")
public class ProcessRouteProcceTypeVO {


    @ApiModelProperty(value = "分类名称")
    private String name;


    @ApiModelProperty(value = "值")
    private String value;




    public ProcessRouteProcceTypeVO setName(String name) {
        this.name = name;
        return this;
    }


    public ProcessRouteProcceTypeVO setValue(String value) {
        this.value = value;
        return this;
    }
}

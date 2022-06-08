package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.PlanScheme;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 *  计划方案(PlanScheme)实体类
 *
 * @author wangpeng
 * @since 2022-05-18 14:38:45
 */
@Data
//@ApiModel(value = " 计划方案")
public class PlanSchemeVO extends PlanScheme implements Serializable {
    private static final long serialVersionUID = 180684758162200102L;


    @ApiModelProperty(value = "运算周期 ")
    private String executionCycleName ;

    @ApiModelProperty(value = "计算范围")
    private String calculationRangeName;

    @ApiModelProperty(value = "需求来源")
    private String sourceOfDemandName;

    @ApiModelProperty(value = "计划类型名称")
    private String schemeTypeName;

    @ApiModelProperty(value = "状态名称")
    private String statusName;

}


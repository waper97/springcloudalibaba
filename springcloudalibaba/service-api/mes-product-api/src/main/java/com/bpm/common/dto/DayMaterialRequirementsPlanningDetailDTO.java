package com.bpm.common.dto;


import com.bpm.common.domain.DayMaterialRequirementsPlanningDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 日物料需求计划详情(DayMaterialRequirementsPlanningDetail)传输类
 *
 * @author wangpeng
 * @since 2022-05-27 16:40:18
 */
@Data
@ApiModel(value = "日物料需求计划详情")
public class DayMaterialRequirementsPlanningDetailDTO extends DayMaterialRequirementsPlanningDetail implements Serializable {
    private static final long serialVersionUID = -34700860294272696L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

}


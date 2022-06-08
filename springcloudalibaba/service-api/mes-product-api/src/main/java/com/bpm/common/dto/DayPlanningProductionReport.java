package com.bpm.common.dto;

import com.bpm.common.domain.DayPlanningDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName DayPlanningProductionReport
 * @Description 报工
 * @Author wangpeng
 * @Date 2022/6/1 9:44
 */
@Data
@ApiModel(value = "报工实体类")
public class DayPlanningProductionReport {

    @ApiModelProperty(value = "日计划详情")
    DayPlanningDetail dayPlanningDetail;
}

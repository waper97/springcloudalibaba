package com.bpm.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName MesProductDayBrokenForkliftFeedingPlanningIntegrate
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/6/7 14:28
 */
@Data
public class MesProductDayBrokenForkliftFeedingPlanningIntegrate {

    @ApiModelProperty(value = "日计划子集")
    List<DayPlanningVO> dayPlanningList;
}

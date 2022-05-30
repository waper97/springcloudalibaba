package com.bpm.common.dto;

import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanning;
import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanningDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 日破碎铲车投料计划新增修改dto
 *
 * @author zhangzheming
 * @since 2022-05-11
 */
@Data
@ApiModel(value = "日破碎铲车投料计划新增修改dto")
public class MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto {
    /**
     * 日破碎铲车投料计划
     */
    @ApiModelProperty(value = "日破碎铲车投料计划")
    private MesProductDayBrokenForkliftFeedingPlanning plan;
    /**
     * 日破碎铲车投料计划详情列表
     */
    @ApiModelProperty(value = "日破碎铲车投料计划详情列表")
    private List<MesProductDayBrokenForkliftFeedingPlanningDetail> planDetailList;
}
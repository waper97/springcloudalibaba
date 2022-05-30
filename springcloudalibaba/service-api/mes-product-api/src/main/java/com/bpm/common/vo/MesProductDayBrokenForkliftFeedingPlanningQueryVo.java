package com.bpm.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 日破碎铲车投料计划查单个vo
 * * @author zhangzheming
 * * @since 2022-05-13
 */
@Data
@ApiModel(value = "日破碎铲车投料计划查单个vo")
public class MesProductDayBrokenForkliftFeedingPlanningQueryVo {
    /**
     * 日破碎铲车投料计划vo
     */
    @ApiModelProperty(value = "日破碎铲车投料计划vo")
    private MesProductDayBrokenForkliftFeedingPlanningVo planVo;
    /**
     * 日破碎铲车投料计划详情vo列表
     */
    @ApiModelProperty(value = "日破碎铲车投料计划详情vo列表")
    private List<MesProductDayBrokenForkliftFeedingPlanningDetailVo> planDetailVoList;

}

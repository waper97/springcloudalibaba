package com.bpm.common.vo;

import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanning;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 日破碎铲车投料计划vo
 * * @author zhangzheming
 * * @since 2022-05-13
 */
@Data
@ApiModel(value = "日破碎铲车投料计划vo")
public class MesProductDayBrokenForkliftFeedingPlanningVo extends MesProductDayBrokenForkliftFeedingPlanning {
    /**
     * 工序名称
     */
    @ApiModelProperty(value = "工序名称")
    private String processName;
    /**
     * 碎石仓编码
     */
    @ApiModelProperty(value = "碎石仓编码")
    private String stockName;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialName;
}

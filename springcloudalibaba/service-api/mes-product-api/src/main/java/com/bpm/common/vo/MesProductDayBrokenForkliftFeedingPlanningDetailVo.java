package com.bpm.common.vo;

import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanningDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 日破碎铲车投料计划详情vo
 * * @author zhangzheming
 * * @since 2022-05-13
 */
@Data
@ApiModel(value = "日破碎铲车投料计划详情vo")
public class MesProductDayBrokenForkliftFeedingPlanningDetailVo extends MesProductDayBrokenForkliftFeedingPlanningDetail {
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
    /**
     * 堆场库位编码
     */
    @ApiModelProperty(value = "堆场库位编码")
    private String stockPlaceCode;
}

package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.DayPlanningDetail;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 日生产计划详情(DayPlanningDetail)实体类
 *
 * @author wangpeng
 * @since 2022-05-06 10:00:59
 */
@Data
//@ApiModel(value = "日生产计划详情")
public class DayPlanningDetailVO extends DayPlanningDetail implements Serializable {
    private static final long serialVersionUID = 905237482851736321L;

    @ApiModelProperty(value = "生产线名称")
    private String productLineName;

    @ApiModelProperty(value = "计量单位")
    private String unitName;

    @ApiModelProperty(value = "碎石仓库名称")
    private String brokenStoneWarehouseName;

    @ApiModelProperty(value = "碎石仓库名称")
    private String brokenStoneWarehouseCode;

    @ApiModelProperty("磨前仓名称")
    private String preGrindingBinName;

    @ApiModelProperty("磨前仓编号")
    private String preGrindingBinCode;

//    @ApiModelProperty("立磨机号")
//    private String verticalMillMachineNumber;

    @ApiModelProperty("半成品仓名")
    private String semiFinishedProductWarehouseName;

    @ApiModelProperty("半成品仓号")
    private String semiFinishedProductWarehouseCode;




}


package com.bpm.common.vo;

import com.bpm.common.domain.MesProductDayMineralArrivalOfTheDemandPlanning;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 日矿石到货需求计划分页查询视图类
 * * @author zhangzheming
 * * @since 2022-05-11
 */
@Data
@ApiModel(value = "日矿石到货需求计划分页查询视图类")
public class MesProductDayMineralArrivalOfTheDemandPlanningVo extends MesProductDayMineralArrivalOfTheDemandPlanning {
    /**
     * 计划周期
     */
    @ApiModelProperty(value = "计划周期")
    private String planningCycle;
    /**
     * 收货地点
     */
    @ApiModelProperty(value = "收货地点")
    private String receiptPlace;
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
    @ApiModelProperty
    private String planCycleName;
}
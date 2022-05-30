package com.bpm.common.dto;

import com.bpm.common.domain.MasterProductionPlan;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName MrpDTO
 * @Description Mrp计算
 * @Author wangpeng
 * @Date 2022/5/23 14:06
 */
@ApiModel(value = "Mrp计算")
@Data
public class MrpDTO {

    /**
     * 运算方案， 外键   计划方案表id
     */
    @ApiModelProperty(value = "运算方案， 外键   计划方案表id")
    private Integer planSchemeId;

    @ApiModelProperty(value = "计算范围")
    private Integer calculateRange;

    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 产品id(矿粉、矿石) 带出数据
     */
    @ApiModelProperty(value = "产品id(矿粉、矿石) 带出数据")
    private Integer productId;


    /**
     * 计算公式
     */
    @ApiModelProperty(value = "计算公式")
    private String calculationFormula;

    /**
     * 是否考虑损耗  （0否，1是）
     */
    @ApiModelProperty(value = "是否考虑损耗  （0否，1是）")
    private Integer isConsiderLoss;

    /**
     * 是否考虑现有库存 （0否，1是）
     */
    @ApiModelProperty(value = "是否考虑现有库存 （0否，1是）")
    private Integer isConsiderNowInventory;

    /**
     * 是否考虑安全库存（0否，1是）
     */
    @ApiModelProperty(value = "是否考虑安全库存（0否，1是）")
    private Integer isConsiderSafeInventory;

    /**
     * 是否过滤掉为0的物料 （0否，1是）
     */
    @ApiModelProperty(value = "是否过滤掉为0的物料 （0否，1是）")
    private Integer isFilterZeroMaterials;

    /**
     * 考虑损耗率（%），默认0
     */
    @ApiModelProperty(value = "考虑损耗率（%），默认0")
    private Integer isRatioscrap;

    /**
     * 考虑成品率（%），默认100
     */
    @ApiModelProperty(value = "考虑成品率（%），默认100")
    private Integer isYield;



    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endTime;


    /**
     * 开工时间 yyyy-mm-dd
     */
    @ApiModelProperty(value = "开工时间 yyyy-mm-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startWorkingDate;

    /**
     * 完工时间 yyyy-mm-dd
     */
    @ApiModelProperty(value = "完工时间 yyyy-mm-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completeWorkingDate;

    /**
     * 状态 下发、审核、新增
     数据字典
     */
    @ApiModelProperty(value = "状态 下发、审核、新增 数据字典")
    private Integer status;

    /**
     * 计划属性 数据字典
     */
    @ApiModelProperty(value = "计划属性 数据字典")
    private String planProperties;


    /**
     * 主生产计划子集
     */
    List<MasterProductionPlan> masterProductionPlanList;
}

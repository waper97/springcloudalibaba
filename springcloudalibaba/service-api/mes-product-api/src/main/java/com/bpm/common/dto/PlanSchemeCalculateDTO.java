package com.bpm.common.dto;


import com.bpm.common.domain.PlanScheme;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 *  计划方案 计算 传输类
 *
 * @author wangpeng
 * @since 2022-05-18 14:38:45
 */
@Data
@ApiModel(value = "计划方案")
public class PlanSchemeCalculateDTO extends PlanScheme implements Serializable {
    private static final long serialVersionUID = -98840137631724084L;

    @ApiModelProperty(value = "季度矿粉需求计划id")
    private Integer MineralPowderRequirementsPlanningId;

    /**
     * mrp运算， 外键   计划方案表id
     */
    @ApiModelProperty(value = "mrp运算， 外键   计划方案表id")
    private Integer planSchemeId;

    /**
     * 运算日期
     */
    @ApiModelProperty(value = "运算日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operationDate;

    /**
     * 运算编号
     */
    @ApiModelProperty(value = "运算编号")
    private String operationCode;


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


//
//    /**
//     * 主生产计划集合
//     */
//    @ApiModelProperty(value = "主生产计划集合")
//    List<MaterialRequirementsPlanningDTO> materialRequirementsPlanningList;
    /**
     * 主生产计划集合
     */
    @ApiModelProperty(value = "矿粉需求计划集合")
    List<MineralPowderRequirementsPlanningToInsertOrUpdateDTO> mineralPowderRequirementsPlanningList;


}


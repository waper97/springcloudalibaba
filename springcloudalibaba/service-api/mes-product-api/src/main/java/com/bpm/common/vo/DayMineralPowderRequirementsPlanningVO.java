package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.DayMineralPowderRequirementsPlanning;
import com.bpm.common.domain.DayMineralPowderRequirementsPlanningDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
/**
 * 日矿粉需求计划(DayMineralPowderRequirementsPlanning)实体类
 *
 * @author wangpeng
 * @since 2022-04-26 09:46:11
 */
@Data
@ApiModel(value = "日矿粉需求计划")
public class DayMineralPowderRequirementsPlanningVO extends DayMineralPowderRequirementsPlanning implements Serializable {
    private static final long serialVersionUID = 549974348572614025L;

    @ApiModelProperty(value = "筒仓名称")
    private String siloName;

    @ApiModelProperty(value = "发放方式名称")
    private String sendMethodName;

    @ApiModelProperty(value = "计划周期名称")
    private String planCycleName;

    @ApiModelProperty(value = "需求单位名称")
    private String demandOrganizationName;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * 矿粉需求详情 集合
     */
    @ApiModelProperty(value = "矿粉需求详情 集合")
    List<DayMineralPowderRequirementsPlanningDetail> dayMineralPowderRequirementsPlanningDetailList;


}


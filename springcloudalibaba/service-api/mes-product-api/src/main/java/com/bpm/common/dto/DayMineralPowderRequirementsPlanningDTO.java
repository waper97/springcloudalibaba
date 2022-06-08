package com.bpm.common.dto;


import com.bpm.common.domain.DayMineralPowderRequirementsPlanning;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 日矿粉需求计划(DayMineralPowderRequirementsPlanning)传输类
 *
 * @author wangpeng
 * @since 2022-04-26 09:46:11
 */
@Data
@ApiModel(value = "日矿粉需求计划")
public class DayMineralPowderRequirementsPlanningDTO extends DayMineralPowderRequirementsPlanning implements Serializable {
    private static final long serialVersionUID = 740400824080690417L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

    @ApiModelProperty(value = "矿粉名称")
    private String mineralPowderName;

    @ApiModelProperty(value = "矿粉编码")
    private String mineralPowderCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String beginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

    @ApiModelProperty(value = "筒仓名称")
    private String siloName;

    @ApiModelProperty(value = "发放方式名称")
    private String sendMethodName;

    @ApiModelProperty(value = "计划周期名称")
    private String planCycleName;

    @ApiModelProperty(value = "需求单位名称")
    private String demandOrganizationName;


}


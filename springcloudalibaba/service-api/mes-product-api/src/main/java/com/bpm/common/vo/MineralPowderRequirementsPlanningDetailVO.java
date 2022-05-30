package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.MineralPowderRequirementsPlanningDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 矿粉需求计划详情(MineralPowderRequirementsPlanningDetail)实体类
 *
 * @author wangpeng
 * @since 2022-04-24 10:26:31
 */
@Data
@ApiModel(value = "矿粉需求计划详情")
public class MineralPowderRequirementsPlanningDetailVO extends MineralPowderRequirementsPlanningDetail implements Serializable {
    private static final long serialVersionUID = 401331045569273895L;

    /**
     * 计划类型
     */
    @ApiModelProperty(value = "计划类型名称 正式、预排")
    private String planTypeName;

    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialName;
}


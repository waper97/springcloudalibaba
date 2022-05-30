package com.bpm.common.dto;
import com.bpm.common.domain.MineralPowderRequirementsPlanning;
import com.bpm.common.domain.MineralPowderRequirementsPlanningDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 矿粉需求计划 传输类
 *
 * @author wangpeng
 * @since 2022-04-24 09:39:58
 */
@Data
@ApiModel(value = "矿粉需求计划")
public class MineralPowderRequirementsPlanningToInsertOrUpdateDTO extends MineralPowderRequirementsPlanning implements Serializable {


    /**
     * 矿粉需求计划详情
     */
    @ApiModelProperty(value = "矿粉需求计划详情")
    List<MineralPowderRequirementsPlanningDetail> planningDetailList;

}


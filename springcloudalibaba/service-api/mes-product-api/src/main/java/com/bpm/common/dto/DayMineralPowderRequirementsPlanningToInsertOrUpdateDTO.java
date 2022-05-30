package com.bpm.common.dto;

import com.bpm.common.domain.DayMineralPowderRequirementsPlanning;
import com.bpm.common.domain.DayMineralPowderRequirementsPlanningDetail;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/4/26 10:08
 */
@Data
public class DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO extends DayMineralPowderRequirementsPlanning implements Serializable {


    /**
     * 矿粉需求详情 集合
     */
    @ApiModelProperty(value = "矿粉需求详情 集合")
    List<DayMineralPowderRequirementsPlanningDetail> dayMineralPowderRequirementsPlanningDetailList;
}

package com.bpm.common.dto;


import com.bpm.common.domain.MasterProductionPlan;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 主生产计划(MasterProductionPlan)传输类
 *
 * @author wangpeng
 * @since 2022-04-24 16:45:58
 */
@Data
@ApiModel(value = "主生产计划")
public class MasterProductionPlanSaveOrUpdateDTO extends MasterProductionPlan implements Serializable {
   

}


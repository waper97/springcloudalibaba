package com.bpm.common.dto;


import com.bpm.common.domain.MasterProductionPlan;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

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


package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.DayMaterialRequirementsPlanningDetail;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
/**
 * 日物料需求计划详情(DayMaterialRequirementsPlanningDetail)实体类
 *
 * @author wangpeng
 * @since 2022-05-27 16:40:18
 */
@Data
@ApiModel(value = "日物料需求计划详情")
public class DayMaterialRequirementsPlanningDetailVO extends DayMaterialRequirementsPlanningDetail implements Serializable {
    private static final long serialVersionUID = -36043711058069214L;


}


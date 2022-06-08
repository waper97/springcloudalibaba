package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.MaterialRequirementsPlanning;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 物料需求计划(MaterialRequirementsPlanning)实体类
 *
 * @author wangpeng
 * @since 2022-04-25 14:16:52
 */
@Data
@ApiModel(value = "物料需求计划")
public class MaterialRequirementsPlanningVO extends MaterialRequirementsPlanning implements Serializable {
    private static final long serialVersionUID = 869843862020169930L;



    /**
     * 计划编号
     */
    @ApiModelProperty(value = "计划编号")
    private String planCode;

    /**
     * 生产车间名称
     */
    @ApiModelProperty(value = "生产车间名称  部门")
    private String productionWorkshopName;

    @ApiModelProperty(value = "投料单据类型名称")
    private String documentTypeName;

    /**
     * 矿粉名称
     */
    @ApiModelProperty(value = "矿粉名称 ")
    private String materialName;

    /**
     * 矿粉编号
     */
    @ApiModelProperty(value = "矿粉编号 ")
    private String materialCode;

    /**
     * 状态名称
     */
    @ApiModelProperty(value = "状态名称 ")
    private String statusName;

    @ApiModelProperty(value="主生产计划编号")
    private String masterProductPlanCode;

}


package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.MineralPowderRequirementsPlanning;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 矿粉需求计划(MineralPowderRequirementsPlanning)实体类
 *
 * @author wangpeng
 * @since 2022-04-24 09:39:58
 */
@Data
//@ApiModel(value = "矿粉需求计划")
public class MineralPowderRequirementsPlanningVO extends MineralPowderRequirementsPlanning implements Serializable {
    private static final long serialVersionUID = -81566460471537081L;


    @ApiModelProperty(value = "物料名称")
    private String materialName;

    @ApiModelProperty(value = "物料编码")
    private String materialCode;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String beginTime;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;



    /**
     * 需求单位名称
     */
    @ApiModelProperty(value = "需求单位名称")
    private String demandOrganizatioName;


    /**
     * 筒仓名称
     */
    @ApiModelProperty(value = "筒仓名称(库位)")
    private String siloName;


    /**
     * 筒仓名称
     */
    @ApiModelProperty(value = "计划方式名称")
    private String planCycleName;
    /**
     * 筒仓名称
     */
    @ApiModelProperty(value = "状态名称")
    private String statusName;
    /**
     * 矿粉需求计划子集
     */
    @ApiModelProperty(value = "矿粉需求计划子集")
    List<MineralPowderRequirementsPlanningDetailVO> planningDetailList = new ArrayList<>();
}


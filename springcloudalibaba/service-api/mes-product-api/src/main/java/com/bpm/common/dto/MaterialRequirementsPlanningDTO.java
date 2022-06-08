package com.bpm.common.dto;


import com.bpm.common.domain.MaterialRequirementsPlanning;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
/**
 * 物料需求计划(MaterialRequirementsPlanning)传输类
 *
 * @author wangpeng
 * @since 2022-04-25 14:16:51
 */
@Data
@ApiModel(value = "物料需求计划")
public class MaterialRequirementsPlanningDTO extends MaterialRequirementsPlanning implements Serializable {
    private static final long serialVersionUID = 939264927311851384L;
    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间 yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    @ApiModelProperty(value = "结束时间 yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "矿粉编号 ")
    private String materialCode;

    @ApiModelProperty(value = "矿粉名称 ")
    private String materialName;

    /**
     * 物料需求计划集合
    */
    @ApiModelProperty(value = "物料需求计划集合")
    List<MaterialRequirementsPlanning> materialRequirementsPlanningList;
}


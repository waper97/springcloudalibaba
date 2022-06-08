package com.bpm.common.dto;

import com.bpm.common.domain.MineralPowderRequirementsPlanning;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 矿粉需求计划 传输类
 *
 * @author wangpeng
 * @since 2022-04-24 09:39:58
 */
@Data
//@ApiModel(value = "矿粉需求计划")
public class MineralPowderRequirementsPlanningDTO extends MineralPowderRequirementsPlanning implements Serializable {
    private static final long serialVersionUID = 184920567403360011L;




    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;



    @ApiModelProperty(value = "物料名称")
    private String materialName;

    @ApiModelProperty(value = "物料编码")
    private String materialCode;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}


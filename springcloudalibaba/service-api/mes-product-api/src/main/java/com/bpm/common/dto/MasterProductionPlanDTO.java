package com.bpm.common.dto;


import com.bpm.common.domain.MasterProductionPlan;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * 主生产计划(MasterProductionPlan)传输类
 *
 * @author wangpeng
 * @since 2022-04-24 16:45:58
 */
@Data
@ApiModel(value = "主生产计划")
public class MasterProductionPlanDTO extends MasterProductionPlan implements Serializable {
    private static final long serialVersionUID = -55509876354692844L;
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

}


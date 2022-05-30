package com.bpm.common.dto;



import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bpm.common.domain.DayPlanning;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 日生产计划(DayPlanning)传输类
 *
 * @author wangpeng
 * @since 2022-05-06 09:54:45
 */
@Data
@ApiModel(value = "日生产计划")
public class DayPlanningDTO extends DayPlanning implements Serializable {
    private static final long serialVersionUID = -88696962937818502L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;




    @ApiModelProperty(value = "碎石仓名称")
    private String brokenStoneWarehouseName;

    @ApiModelProperty(value = "碎石仓编码")
    private String brokenStoneWarehouseCode;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "物料名称")
    private String materialName;
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    @ApiModelProperty(value = "磨前仓名称")
    private String preGrindingBinName;



}


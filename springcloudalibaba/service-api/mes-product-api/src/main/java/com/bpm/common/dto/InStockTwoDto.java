package com.bpm.common.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InStockTwoDto {

    /**
     * 报工id
     */
    @ApiModelProperty(value = "报工id")
    private Integer workReportId;

    /**
     * 报工修改id
     */
    @ApiModelProperty(value = "报工修改id")
    private Integer updateWorkReportId;

    /**
     * 报工编码
     */
    @ApiModelProperty(value = "报工编码")
    private String workReportCode;

    /**
     * 报工时间
     */
    @ApiModelProperty(value = "报工时间")
    private LocalDateTime workReportTime;

    /**
     * 物料Id
     */
    @ApiModelProperty(value = "物料Id")
    private Integer materialId;

    /**
     * 入库主表id
     */
    @ApiModelProperty(value = "入库主表id")
    private List<Integer> stockInOutIds;

}


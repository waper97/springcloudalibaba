package com.bpm.common.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class InStockDTO {

    /**
     * 仓库id
     */
    @ApiModelProperty(value = "仓库id")
    private Integer stockId;

    /**
     * 物料id
     */
    @ApiModelProperty(value = "物料id")
    private Integer materialId;

    /**
     * 入库开始日期
     */
    @ApiModelProperty(value = "入库开始日期")
    private String inStartDate;
    /**
     * 入库结束日期
     */
    @ApiModelProperty(value = "入库结束日期")
    private String inEndDate;

    @ApiModelProperty(value = "入库报工id")
    private Integer workReportId;

    @ApiModelProperty(value = "出库结束日期-明细")
    private List<Integer> stockInOutIds;

}


package com.bpm.common.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OutStockDTO {

    /**
     * 出库开始日期
     */
    @ApiModelProperty(value = "bomId-出库-明细")
    private Integer bomId;
    /**
     * 出库开始日期
     */
    @ApiModelProperty(value = "出库开始日期-出库")
    private String outStartDate;
    /**
     * 出库结束日期
     */
    @ApiModelProperty(value = "出库结束日期-出库")
    private String outEndDate;

    @ApiModelProperty(value = "出库结束日期-明细")
    private List<Integer> outIds;

    @ApiModelProperty(value = "出库报工id")
    private Integer workReportId;

}


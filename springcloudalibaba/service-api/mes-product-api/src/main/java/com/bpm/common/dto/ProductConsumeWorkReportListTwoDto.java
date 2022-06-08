package com.bpm.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductConsumeWorkReportListTwoDto {

    /**
    * 主键id
    */    
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
    * 消耗报工主表id
    */    
    @ApiModelProperty(value = "消耗报工主表id")
    private Integer consumeId;

    /**
    * 报工单据编码
    */    
    @ApiModelProperty(value = "报工单据编码")
    private String workReportCode;

    /**
    * 物料id
    */    
    @ApiModelProperty(value = "物料id")
    private Integer materialId;

    /**
    * 实际数量
    */    
    @ApiModelProperty(value = "实际数量")
    private BigDecimal actualQty;

    /**
    * bom数量
    */    
    @ApiModelProperty(value = "bom数量")
    private BigDecimal bomQty;

    /**
    * 入库批次
    */    
    @ApiModelProperty(value = "入库批次")
    private String inBatchNo;

    /**
    * 仓库出库批次表
    */    
    @ApiModelProperty(value = "仓库出库批次表")
    private Integer stockInOutBatchId;

}


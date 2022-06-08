package com.bpm.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductConsumeWorkReportQueryDto extends PageDTO {

    /**
    * 主键id
    */    
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
    * 报工单据编码
    */    
    @ApiModelProperty(value = "报工单据编码")
    private String workReportCode;

    /**
    * 报工单据日期 年月日
    */    
    @ApiModelProperty(value = "报工单据日期 年月日")
    private String workReportDate;

    /**
    * 工作中心id
    */    
    @ApiModelProperty(value = "工作中心id")
    private Integer workEnterId;

    /**
    * bom主表id
    */    
    @ApiModelProperty(value = "bom主表id")
    private Integer bomId;

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
    * 数量
    */    
    @ApiModelProperty(value = "数量")
    private Integer qty;

    /**
    * 状态
    */    
    @ApiModelProperty(value = "状态")
    private String status;

    /**
    * 过账日期
    */    
    @ApiModelProperty(value = "过账日期")
    private String postingDate;

    /**
    * 出库类型：1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表
    */    
    @ApiModelProperty(value = "出库类型：1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表")
    private Integer sourceType;

    /**
    * 源单号ID（月生产订单）
    */    
    @ApiModelProperty(value = "源单号ID（月生产订单）")
    private Integer sourceId;

    /**
    * 源单号（月生产订单）
    */    
    @ApiModelProperty(value = "源单号（月生产订单）")
    private String sourceCode;

    /**
    * 出库开始日期
    */    
    @ApiModelProperty(value = "出库开始日期")
    private String outStartDate;

    /**
    * 出库结束日期
    */    
    @ApiModelProperty(value = "出库结束日期")
    private String outEndDate;

    /**
    * 部门id
    */    
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;

    /**
    * 入库报工id
    */    
    @ApiModelProperty(value = "入库报工id")
    private Integer inWorkReportId;

    /**
    * 批次号
    */    
    @ApiModelProperty(value = "批次号")
    private String batchNo;

    /**
    * 0无效，1有效，默认1
    */    
    @ApiModelProperty(value = "0无效，1有效，默认1")
    private String isValid;

    /**
     * 状态
     */
    @ApiModelProperty(value = "开始时间")
    private String startTime;

    /**
     * 状态
     */
    @ApiModelProperty(value = "结束时间")
    private String endTime;

    /**
     * 物料id
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;

    @ApiModelProperty(value = "物料名称")
    private String materialName;

}


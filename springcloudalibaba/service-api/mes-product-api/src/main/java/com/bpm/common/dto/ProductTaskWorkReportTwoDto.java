package com.bpm.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductTaskWorkReportTwoDto {

    /**
    * 主键id
    */    
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
    * 作业报工
    */    
    @ApiModelProperty(value = "作业报工")
    private String taskCode;

    /**
    * 工作报工单据日期 年月日
    */    
    @ApiModelProperty(value = "工作报工单据日期 年月日")
    private String taskDate;

    /**
    * 过账日期
    */    
    @ApiModelProperty(value = "过账日期")
    private String postingDate;

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
    * 客户id
    */    
    @ApiModelProperty(value = "客户id")
    private Integer clientId;

    /**
    * 部门id
    */    
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;

    /**
    * 源单类型：1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表
    */    
    @ApiModelProperty(value = "源单类型：1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表")
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
    * 质检批次
    */    
    @ApiModelProperty(value = "质检批次")
    private String checkBatchNo;

    /**
    * 开始日期
    */    
    @ApiModelProperty(value = "开始日期")
    private String startDate;

    /**
    * 结束日期
    */    
    @ApiModelProperty(value = "结束日期")
    private String endDate;

    /**
    * 批次号
    */    
    @ApiModelProperty(value = "批次号")
    private String batchNo;

    /**
    * 入库报工id
    */    
    @ApiModelProperty(value = "入库报工id")
    private Integer inWorkReportId;

    /**
    * 入库报工编码
    */    
    @ApiModelProperty(value = "入库报工编码")
    private String inWorkReportCode;

    /**
    * 人工工时
    */    
    @ApiModelProperty(value = "人工工时")
    private BigDecimal laborHours;

    /**
    * 机器工时
    */    
    @ApiModelProperty(value = "机器工时")
    private BigDecimal machineHours;

    /**
    * 维修费
    */
    @ApiModelProperty(value = "维修费")
    private BigDecimal repairCost;

    /**
    * 备注
    */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
    * 0无效，1有效，默认1
    */    
    @ApiModelProperty(value = "0无效，1有效，默认1")
    private String isValid;

    /**
     * 前登录人ID
     */
    @ApiModelProperty(value = "前登录人ID")
    private Integer currentloginId;

    /**
     * 当前登录人名称
     */
    @ApiModelProperty(value = "当前登录人名称")
    private String currentloginName;

    /**
    * 回写SapId
    */
    @ApiModelProperty(value = "回写SapId")
    private Integer sapId;

    /**
    * 回写Sap编码
    */
    @ApiModelProperty(value = "回写Sap编码")
    private String sapCode;

}


package com.bpm.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductConsumeWorkReportTwoDto {

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
    * 入库报工id
    */
    @ApiModelProperty(value = "入库报工id")
    private Integer inWorkReportId;

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
     * 源单类型：1生产订单
     */
    @ApiModelProperty(value = "源单类型：1生产订单")
    private Integer sourceType;

    /**
     * 出库类型：1生产领料
     */
    @ApiModelProperty(value = "出库类型：1生产领料")
    private Integer stockType;

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
    * 出库单据号
    */    
    @ApiModelProperty(value = "出库单据号id")
    private String outId;

    /**
    * 批次号
    */    
    @ApiModelProperty(value = "批次号")
    private String batchNo;

    /**
    * 备注
    */    
    @ApiModelProperty(value = "备注")
    private String remark;

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
     * 入库主表id
     */
    @ApiModelProperty(value = "出库单据id集合")
    private List<Integer> stockInOutIds;

    @ApiModelProperty(value = "备注")
    private List<ProductConsumeWorkReportListTwoDto> listTwoDtos;

}


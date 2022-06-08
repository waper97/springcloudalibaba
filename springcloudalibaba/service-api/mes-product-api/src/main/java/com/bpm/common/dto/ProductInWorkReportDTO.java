package com.bpm.common.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductInWorkReportDTO {

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

    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 计量单位（外键）
     */
    @ApiModelProperty(value = "计量单位（外键）")
    private Integer unitsId;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer qty;

    /**
     * 批次号
     */
    @ApiModelProperty(value = "批次号")
    private String batchNo;

    /**
     * 过账日期
     */
    @ApiModelProperty(value = "过账日期")
    private String postingDate;

    /**
     * 入库类型：1 成品入库
     */
    @ApiModelProperty(value = "入库类型：1 成品入库")
    private Integer stockType;

    /**
     * 源单类型：1 生产订单
     */
    @ApiModelProperty(value = "源单类型：1 生产订单")
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
     * 入库开始日期
     */
    @ApiModelProperty(value = "入库开始日期")
    private String inStartDate;

    /**
     * 入库结束日期
     */
    @ApiModelProperty(value = "入库结束日期")
    private String inEndDate;

    /**
     * 入库单据号
     */
    @ApiModelProperty(value = "入库单据号")
    private String inId;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;

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
     * 入库主表id
     */
    @ApiModelProperty(value = "入库主表id")
    private List<Integer> stockInOutIds;

}


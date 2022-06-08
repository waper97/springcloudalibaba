package com.bpm.common.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 生成入库报工(ProductInWorkReport)传输类
 *
 * @author wangpeng
 * @since 2022-05-23 14:49:40
 */
@Data
@ApiModel(value = "生成入库报工")
public class ProductInWorkReportQueryDTO extends PageDTO {

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
     * 仓库类型：1 原辅料仓、2线边仓、3半成品现场仓、4成品原辅料仓、5碎石仓、6磨前仓、7实体仓
     */
    @ApiModelProperty(value = "仓库类型：1 原辅料仓、2线边仓、3半成品现场仓、4成品原辅料仓、5碎石仓、6磨前仓、7实体仓")
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
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;

    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料名称")
    private String materialName;

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


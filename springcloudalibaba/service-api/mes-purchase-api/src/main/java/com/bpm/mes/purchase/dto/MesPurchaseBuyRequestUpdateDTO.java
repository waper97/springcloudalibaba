package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MesPurchaseBuyRequestUpdateDTO {
    /**
     * 单据编号（PB+8位年月日+0001）
     */
    @ApiModelProperty(value = "单据编号（PB+8位年月日+0001）")
    private String buyRequestCode;
    /**
     * 单据日期（YYYY-MM-DD）
     */
    @ApiModelProperty(value = "单据日期（YYYY-MM-DD）")
    private Date date;
    /**
     * 业务类型：1采购入库、2样品采购、3订单委外、(数据字典维护)
     */
    @ApiModelProperty(value = "业务类型：1采购入库、2样品采购、3订单委外、(数据字典维护)")
    private Integer bussinessType;
    /**
     * 源单类型：0无、1销售订单、2采购计划（MRP运算 ）
     */
    @ApiModelProperty(value = "源单类型：0无、1销售订单、2采购计划（MRP运算 ）")
    private Integer sourceType;
    /**
     * 状态：0草稿、1已申请，2已接收、3待审核、4已审核
     */
    @ApiModelProperty(value = "状态：0草稿、1已申请，2已接收、3待审核、4已审核")
    private Integer state;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Integer createId;
    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称")
    private String createName;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private Integer updateId;
    /**
     * 修改人名称
     */
    @ApiModelProperty(value = "修改人名称")
    private String updateName;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 0无效，1有效，默认1
     */
    @ApiModelProperty(value = "0无效，1有效，默认1")
    private Integer isValid;
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 源单号（生产订单号）
     */
    @ApiModelProperty(value = "源单号（生产订单号）")
    private String sourceCode;
    /**
     * 供应商全称
     */
    @ApiModelProperty(value = "供应商全称")
    private String supplierFullName;

    @ApiModelProperty(value = "供应商id")
    private Integer supplierId;
    /**
     * 明细表list
     */
    @ApiModelProperty("明细表")
    private List<MesPurchaseBuyRequestListUpdateDTO> list;
}

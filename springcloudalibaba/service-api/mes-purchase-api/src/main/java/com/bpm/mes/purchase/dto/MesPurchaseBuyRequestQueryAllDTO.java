package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MesPurchaseBuyRequestQueryAllDTO {
    /**
     * 单据编号（PB+8位年月日+0001）
     */
    @ApiModelProperty(value = "单据编号（PB+8位年月日+0001）")
    private String buyRequestCode;
    /**
     * 供应商全称
     */
    @ApiModelProperty(value = "供应商全称")
    private String supplierFullName;
    /**
     * 状态：0草稿、1已申请，2已接收、3待审核、4已审核
     */
    @ApiModelProperty(value = "状态：0草稿、1已申请，2已接收、3待审核、4已审核")
    private Integer state;
}

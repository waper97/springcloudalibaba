package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MesSupplierTypeQueryByPageDTO {
    /**
     * 供应商类型编码
     */
    @ApiModelProperty(value = "供应商类型编码")
    private String supplierTypeCode;
    /**
     * 供应商类型名称
     */
    @ApiModelProperty(value = "供应商类型名称 ")
    private String supplierTypeName;
}

package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MesSupplierQueryByPageDTO {
    /**
     * 供应商编码
     */
    @ApiModelProperty(value = "供应商编码 ")
    private String supplierCode;
    /**
     * 供应商全称
     */
    @ApiModelProperty(value = "供应商全称 ")
    private String supplierName;
}

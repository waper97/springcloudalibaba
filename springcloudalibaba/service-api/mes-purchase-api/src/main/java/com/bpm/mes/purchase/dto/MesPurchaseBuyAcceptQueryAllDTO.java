package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MesPurchaseBuyAcceptQueryAllDTO {
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码 ")
    private String materialCode;
    /**
     * 物料简称
     */
    @ApiModelProperty(value = "物料简称")
    private String materialShortName;
    /**
     * 单据日期YYYY-MM-DD
     */
    @ApiModelProperty(value = "单据日期YYYY-MM-DD")
    private Date date;
}

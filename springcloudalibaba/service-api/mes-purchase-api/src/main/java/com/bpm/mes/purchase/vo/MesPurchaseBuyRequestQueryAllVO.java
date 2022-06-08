package com.bpm.mes.purchase.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MesPurchaseBuyRequestQueryAllVO {


    @ApiModelProperty(value = "单据日期（YYYY-MM-DD）")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
//
    @ApiModelProperty(value = "业务类型：1采购入库、2样品采购、3订单委外、(数据字典维护)")
    private Integer bussinessType;
//
    @ApiModelProperty(value = "业务类型名称：1采购入库、2样品采购、3订单委外、(数据字典维护)")
    private String bussinessTypeName;

    @ApiModelProperty(value = "供应商全称")
    private String supplierFullName;

    @ApiModelProperty(value = "业务员ID")
    private Integer empId;

    @ApiModelProperty(value = "业务员编号")
    private String empNo;

//    @ApiModelProperty(value = "数量")
//    private Double qty;
//
//    @ApiModelProperty(value = "供应商ID(外键)")
//    private Integer supplierId;
//
    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
//
//    @ApiModelProperty(value = "建议采购日期（YYYY-MM-DD）")
//    private Date purchDate;
//
//    @ApiModelProperty(value = "到货日期")
//    private Date fetchDate;
//
//    @ApiModelProperty(value = "计量单位ID，外键")
//    private Integer unitsId;
//
//    @ApiModelProperty(value = "物料ID")
//    private Integer materialId;
//
//
    @ApiModelProperty(value = "物料编码")
    private String materialCode;

    @ApiModelProperty(value = "物料简称 ")
    private String materialShortName;
//
//    private Integer state;
//
    private Date createTime;

    @ApiModelProperty(value = "单据编号（PB+8位年月日+0001）")
    private String buyRequestCode;

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "明细")
    private List<MesPurchaseBuyRequestListQueryByIdVO> list;




}

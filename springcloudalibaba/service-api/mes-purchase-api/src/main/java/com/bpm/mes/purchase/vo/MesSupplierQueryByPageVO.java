package com.bpm.mes.purchase.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MesSupplierQueryByPageVO {
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
    /**
     * 供应商简称
     */
    @ApiModelProperty(value = "供应商简称")
    private String supplierShortName;
    /**
     * 供应商类型
     */
    @ApiModelProperty(value = "供应商类型")
    private String supplierType;
    /**
     * 联系人  ERP:FContact
     */
    @ApiModelProperty(value = "联系人  ERP:FContact")
    private String contact;
    /**
     * 联系电话1  ERP:Fphone
     */
    @ApiModelProperty(value = "联系电话1  ERP:Fphone")
    private String telphone1;
    /**
     * 联系地址（供应商地址）
     */
    @ApiModelProperty(value = "联系地址（供应商地址）")
    private String supplierAddress;
    /**
     * 传真    ERP:FFax
     */
    @ApiModelProperty(value = "传真    ERP:FFax")
    private String faxTel;
    /**
     * E-Mail  ERP:FEmail
     */
    @ApiModelProperty(value = "E-Mail  ERP:FEmail")
    private String email;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Integer createId;
    /**
     * 创建名称
     */
    @ApiModelProperty(value = "创建名称")
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
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private Integer companyId;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    /**
     * 开户银行
     */
    @ApiModelProperty(value = "开户银行")
    private String bank;
    /**
     * 银行账号
     */
    @ApiModelProperty(value = "银行账号")
    private String bankCount;
    /**
     * 税务登记号
     */
    @ApiModelProperty(value = "税务登记号")
    private String taxLoginCode;
    /**
     * 采购方式
     */
    @ApiModelProperty(value = "采购方式")
    private String purchaseWay;
    /**
     * 结算方式
     */
    @ApiModelProperty(value = "结算方式")
    private String endWay;

    @ApiModelProperty(value = "供应商类型id")
    private Integer supplierTypeId;
}

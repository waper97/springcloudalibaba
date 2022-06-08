package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MesPurchaseBuyAcceptUpdateDTO {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 收货单编号（SE+8位年月日+3位流水号）
     */
    @ApiModelProperty(value = "收货单编号（SE+8位年月日+3位流水号）")
    private String buyAcceptNo;
    /**
     * 单据日期YYYY-MM-DD
     */
    @ApiModelProperty(value = "单据日期YYYY-MM-DD")
    private Date date;
    /**
     * 源单类型：1交货通知单、2采购订单、3购货发票
     */
    @ApiModelProperty(value = "源单类型：1交货通知单、2采购订单、3购货发票")
    private Integer sourceType;
    /**
     * 源单号
     */
    @ApiModelProperty(value = "源单号")
    private String sourceCode;
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "仓库id")
    private Integer stockId;
    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String stockCode;
    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private String stockName;
    /**
     * 是否到破碎口
     */
    @ApiModelProperty(value = "是否到破碎口")
    private Integer toBreak;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 状态：1 新增、2报检、3检验中、4、评审中、5已检验、6已入库
     */
    @ApiModelProperty(value = "状态：1 新增、2报检、3检验中、4、评审中、5已检验、6已入库")
    private Integer state;
    /**
     * 供应商ID（主键）
     */
    @ApiModelProperty(value = "供应商ID（主键）")
    private Integer supplierId;
    /**
     * 供应商全称
     */
    @ApiModelProperty(value = "供应商全称  ")
    private String supplierFullName;
    /**
     * 收件人
     */
    @ApiModelProperty(value = "收件人")
    private String consigner;
    /**
     * 收件人地址
     */
    @ApiModelProperty(value = "收件人地址")
    private String receiveAddress;
    /**
     * 收件人联系电话
     */
    @ApiModelProperty(value = "收件人联系电话")
    private String phone;
    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String carCode;
    /**
     * 结算日期：有数据
     */
    @ApiModelProperty(value = "结算日期：有数据")
    private Date settleDate;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createId;
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
    private String updateId;
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
     * 明细表list
     */
    @ApiModelProperty(value = "明细表list")
    private List<MesPurchaseBuyAcceptListUpdateDTO> list;
}

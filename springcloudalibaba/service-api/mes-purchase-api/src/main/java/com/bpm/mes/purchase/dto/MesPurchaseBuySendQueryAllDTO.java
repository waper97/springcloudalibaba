package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MesPurchaseBuySendQueryAllDTO {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 配送单号
     */
    @ApiModelProperty(value = "配送单号")
    private String buySendCode;
    /**
     * 供应商全称
     */
    @ApiModelProperty(value = "供应商全称 ")
    private String supplierFullName;
    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private Date date;
    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String carNum;
    /**
     * 预计送达日期
     */
    @ApiModelProperty(value = "预计送达日期")
    private Date expectedDate;
    /**
     * 发货方式
     */
    @ApiModelProperty(value = "发货方式")
    private String consignMode;
    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String consigner;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String consignCode;
    /**
     * 快递单号
     */
    @ApiModelProperty(value = "快递单号")
    private String consignCarrier;
    /**
     * 承运商
     */
    @ApiModelProperty(value = "承运商")
    private String phone;
    /**
     * 交货地点
     */
    @ApiModelProperty(value = "交货地点")
    private String fetchAdd;
    /**
     * 预计收货人ID（登陆）
     */
    @ApiModelProperty(value = "预计收货人ID（登陆）")
    private String expectedAccepterId;
    /**
     * 预计收货人名称
     */
    @ApiModelProperty(value = "预计收货人名称")
    private String expectedAccepterName;
    /**
     * 预计收货人电话
     */
    @ApiModelProperty(value = "预计收货人电话")
    private String expectedAccepterPhone;
    /**
     * 发货日期
     */
    @ApiModelProperty(value = "发货日期  ")
    private Date sendDate;
    /**
     * 收货日期
     */
    @ApiModelProperty(value = "收货日期")
    private Date acceptDate;
    /**
     * 币别ID
     */
    @ApiModelProperty(value = "币别ID")
    private String currencyId;
    /**
     * 币别编码
     */
    @ApiModelProperty(value = "币别编码")
    private String currencyCode;
    /**
     * 汇率
     */
    @ApiModelProperty(value = "汇率")
    private String exchangeRate;
    /**
     * 源单类型（关联表单）
     * 1采购订单、2委外订单
     */
    @ApiModelProperty(value = "源单类型（关联表单） 1采购订单、2委外订单")
    private String sourceType;
    /**
     * 关单标志  0、1
     */
    @ApiModelProperty(value = "关单标志  0、1")
    private Integer closed;
    /**
     * 状态：1 新增，2已发货，3已收货
     */
    @ApiModelProperty(value = "状态：1 新增，2已发货，3已收货")
    private String state;
    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    private String departmentId;
    /**
     * 部门编号
     */
    @ApiModelProperty(value = "部门编号")
    private String departmentNo;
    /**
     * 业务员ID
     */
    @ApiModelProperty(value = "业务员ID")
    private String empId;
    /**
     * 业务员编号
     */
    @ApiModelProperty(value = "业务员编号")
    private String empNo;
    /**
     * 主管ID（外键）
     */
    @ApiModelProperty(value = "主管ID（外键）")
    private String managerId;
    /**
     * 主管编号
     */
    @ApiModelProperty(value = "主管编号")
    private String managerNo;
    /**
     * 收货人ID（登陆）
     */
    @ApiModelProperty(value = "收货人ID（登陆）")
    private String accepterId;
    /**
     * 收货人名称
     */
    @ApiModelProperty(value = "收货人名称")
    private String accepterName;
    /**
     * 收货时间
     */
    @ApiModelProperty(value = "收货时间")
    private Date accepterTime;
    /**
     * 审核人ID（登陆）
     */
    @ApiModelProperty(value = "审核人ID（登陆）")
    private String checkerId;
    /**
     * 审核人名称
     */
    @ApiModelProperty(value = "审核人名称")
    private String checkerName;
    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private Date checkTime;
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
     * 拣货条码
     */
    @ApiModelProperty(value = "拣货条码")
    private String pickCode;
    /**
     * 收货地址
     */
    @ApiModelProperty(value = "收货地址")
    private String accepterAddress;
    /**
     * 源单号
     */
    @ApiModelProperty(value = "源单号")
    private String sourceCode;
    /**
     * 批次号（PS+当前时间+流水号）
     */
    @ApiModelProperty(value = "批次号（PS+当前时间+流水号）")
    private String batchNo;
    /**
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private String companyId;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称 ")
    private String companyName;
}

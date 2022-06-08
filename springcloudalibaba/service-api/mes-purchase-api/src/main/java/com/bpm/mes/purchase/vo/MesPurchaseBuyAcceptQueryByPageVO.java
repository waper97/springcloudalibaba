package com.bpm.mes.purchase.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MesPurchaseBuyAcceptQueryByPageVO {
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
     * 单据类型：1收货通知单、2退货通知单、3采购检验申请单
     */
    @ApiModelProperty(value = "单据类型：1收货通知单、2退货通知单、3采购检验申请单")
    private Integer billType;
    /**
     * 采购范围：赊销、调拨
     */
    @ApiModelProperty(value = "采购范围：赊销、调拨")
    private Integer areaPs;
    /**
     * 业务类型：1采购入库、2样品采购、3订单委外、
     */
    @ApiModelProperty(value = "业务类型：1采购入库、2样品采购、3订单委外、")
    private Integer bizType;
    /**
     * 单据日期YYYY-MM-DD
     */
    @ApiModelProperty(value = "单据日期YYYY-MM-DD")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    /**
     * 币别ID
     */
    @ApiModelProperty(value = "币别ID")
    private Integer currencyId;
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
     * 采购方式：赊购、现购
     */
    @ApiModelProperty(value = "采购方式：赊购、现购")
    private Integer postyle;
    /**
     * 交货地点
     */
    @ApiModelProperty(value = "交货地点")
    private String fetchAdd;
    /**
     * 结算日期：有数据
     */
    @ApiModelProperty(value = "结算日期：有数据")
    private Date settleDate;
    /**
     * 结算方式：1信用天数 、1月结
     */
    @ApiModelProperty(value = "结算方式：1信用天数 、1月结")
    private Integer settleId;
    /**
     * 收货单位ID（交货地点）
     */
    @ApiModelProperty(value = "收货单位ID（交货地点）")
    private Integer clientIdReceive;
    /**
     * 收货单位全称
     */
    @ApiModelProperty(value = "收货单位全称")
    private String clientNameReceive;
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
     * 收货仓库ID（外键）
     */
    @ApiModelProperty(value = "收货仓库ID（外键）")
    private String stockId;
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
     * 更新库存：0不更新，1保存时更新，审核时更新
     * 单独维护参数
     */
    @ApiModelProperty(value = "更新库存：0不更新，1保存时更新，审核时更新 单独维护参数")
    private Integer upstockWhenSave;
    /**
     * 打印次数
     */
    @ApiModelProperty(value = "打印次数")
    private Integer printCount;
    /**
     * 源单类型：1交货通知单、2采购订单、3购货发票
     */
    @ApiModelProperty(value = "源单类型：1交货通知单、2采购订单、3购货发票")
    private Integer sourceType;
    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    private Integer departmentId;
    /**
     * 部门编号
     */
    @ApiModelProperty(value = "部门编号")
    private String departmentNo;
    /**
     * 业务员ID
     */
    @ApiModelProperty(value = "业务员ID")
    private Integer empId;
    /**
     * 业务员编号
     */
    @ApiModelProperty(value = "业务员编号")
    private String empNo;
    /**
     * 主管ID（外键）
     */
    @ApiModelProperty(value = "主管ID（外键）")
    private Integer managerId;
    /**
     * 主管编号
     */
    @ApiModelProperty(value = "主管编号")
    private String managerNo;
    /**
     * 状态：1 新增、2报检、3检验中、4、评审中、5已检验、6已入库
     */
    @ApiModelProperty(value = "状态：1 新增、2报检、3检验中、4、评审中、5已检验、6已入库")
    private Integer state;
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
     * 源单号
     */
    @ApiModelProperty(value = "源单号")
    private String sourceCode;
    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String carCode;
    /**
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private Integer companyId;
    /**
     * 是否到破碎口
     */
    @ApiModelProperty(value = "是否到破碎口")
    private Integer toBreak;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    /**
     * 源单ID
     */
    @ApiModelProperty(value = "源单ID")
    private Integer sourceId;
}

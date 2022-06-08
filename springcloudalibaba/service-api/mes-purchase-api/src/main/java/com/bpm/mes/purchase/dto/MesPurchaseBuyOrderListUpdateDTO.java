package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MesPurchaseBuyOrderListUpdateDTO {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 行号
     */
    @ApiModelProperty(value = "行号")
    private Integer lineNo;
    /**
     * 采购申请单ID（外键）
     */
    @ApiModelProperty(value = "采购申请单ID（外键）")
    private Integer buyOrderId;
    /**
     * 采购订单编号（PO+8位年月日+0001）
     */
    @ApiModelProperty(value = "采购订单编号（PO+8位年月日+0001）")
    private String buyOrderCode;
    /**
     * 物料ID（外键）
     */
    @ApiModelProperty(value = "物料ID（外键）")
    private Integer materielId;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码 ")
    private String materialCode;
    /**
     * 物料简称
     */
    @ApiModelProperty(value = "物料简称 ")
    private String materialShortName;
    /**
     * 物料规格
     */
    @ApiModelProperty(value = "物料规格 ")
    private String materialSpec;
    /**
     * 订单数量
     */
    @ApiModelProperty(value = "订单数量")
    private Float qty;
    /**
     * 收货数量
     */
    @ApiModelProperty(value = "收货数量")
    private Float commitQty;
    /**
     * 入库数量
     */
    @ApiModelProperty(value = "入库数量")
    private Float stockQty;
    /**
     * 开票数量（发票数量）
     */
    @ApiModelProperty(value = "开票数量（发票数量）")
    private Float invoiceQty;
    /**
     * 退货数量
     */
    @ApiModelProperty(value = "退货数量")
    private Float backQty;
    /**
     * 到货日期
     */
    @ApiModelProperty(value = "到货日期")
    private Date date;
    /**
     * 单价（不含税）
     */
    @ApiModelProperty(value = "单价（不含税）")
    private Float price;
    /**
     * 不含税金额
     */
    @ApiModelProperty(value = "不含税金额")
    private Float amount;
    /**
     * 税率
     */
    @ApiModelProperty(value = "税率")
    private Float taxRate;
    /**
     * 税额
     */
    @ApiModelProperty(value = "税额")
    private Float taxAmount;
    /**
     * 含税单价
     */
    @ApiModelProperty(value = "含税单价")
    private Float taxPrice;
    /**
     * 价税合计（含税金额）
     */
    @ApiModelProperty(value = "价税合计（含税金额）")
    private Float allAmount;
    /**
     * 计量单位ID（外键）
     */
    @ApiModelProperty(value = "计量单位ID（外键）")
    private Integer unitsId;
    /**
     * 源单类型（关联表单）
     * 0手工录入、1计划订单、2采购申请单、
     */
    @ApiModelProperty(value = "源单类型（关联表单） 0手工录入、1计划订单、2采购申请单、")
    private Integer sourceType;
    /**
     * 源单ID
     */
    @ApiModelProperty(value = "源单ID")
    private Integer sourceId;
    /**
     * 源单编码
     */
    @ApiModelProperty(value = "源单编码")
    private String sourceCode;
    /**
     * 源单明细ID
     */
    @ApiModelProperty(value = "源单明细ID")
    private Integer sourceListId;
    /**
     * 检验单主表（预检单外键）
     */
    @ApiModelProperty(value = "检验单主表（预检单外键）")
    private Integer iqcCheckId;
    /**
     * 检验单号
     */
    @ApiModelProperty(value = "检验单号")
    private Integer iqcCheckCode;
    /**
     * 业务关闭：0否，1是
     */
    @ApiModelProperty(value = "业务关闭：0否，1是")
    private Integer closed;
    /**
     * 检验方式：免检、抽检
     */
    @ApiModelProperty(value = "检验方式：免检、抽检")
    private Integer checkType;
    /**
     * 状态：1 新增，2已审核，3已下达，4已接收，5 已配送，6已入库，9已完成
     */
    @ApiModelProperty(value = "状态：1 新增，2已审核，3已下达，4已接收，5 已配送，6已入库，9已完成")
    private Integer state;
    /**
     * 供应商退回意见
     */
    @ApiModelProperty(value = "供应商退回意见")
    private String supplierMemo;
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
     * 供应商名称
     */
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
    /**
     * 发货数量
     */
    @ApiModelProperty(value = "发货数量")
    private Float finishQty;
    /**
     * 未发货数量
     */
    @ApiModelProperty(value = "未发货数量")
    private Integer noFinishQty;
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

}

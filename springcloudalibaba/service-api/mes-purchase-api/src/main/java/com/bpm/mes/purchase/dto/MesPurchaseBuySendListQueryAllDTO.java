package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MesPurchaseBuySendListQueryAllDTO {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 配送计划ID（外键）
     */
    @ApiModelProperty(value = "配送计划ID（外键）")
    private String buySendId;
    /**
     * 配送单号
     */
    @ApiModelProperty(value = "配送单号")
    private String buySendCode;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    /**
     * 物料简称
     */
    @ApiModelProperty(value = "物料简称")
    private String materialShortName;
    /**
     * 物料规格
     */
    @ApiModelProperty(value = "物料规格 ")
    private String materialSpec;
    /**
     * 计量单位ID（外键）
     */
    @ApiModelProperty(value = "计量单位ID（外键）")
    private String unitsId;
    /**
     * 订单数量（计划数量）
     */
    @ApiModelProperty(value = "订单数量（计划数量）")
    private String qty;
    /**
     * 实发数量
     */
    @ApiModelProperty(value = "实发数量")
    private String finishQty;
    /**
     * 到货数量
     */
    @ApiModelProperty(value = "到货数量")
    private String commitQty;
    /**
     * 收货数量
     */
    @ApiModelProperty(value = "收货数量")
    private String receiptQty;
    /**
     * 退回数量
     */
    @ApiModelProperty(value = "退回数量")
    private String returnQty;
    /**
     * 入库数量
     */
    @ApiModelProperty(value = "入库数量")
    private String stockQty;
    /**
     * 开票数量
     */
    @ApiModelProperty(value = "开票数量")
    private String qtyInvoice;
    /**
     * 交货日期
     */
    @ApiModelProperty(value = "交货日期")
    private Date date;
    /**
     * 不含税单价
     */
    @ApiModelProperty(value = "不含税单价")
    private String price;
    /**
     * 不含税金额
     */
    @ApiModelProperty(value = "不含税金额")
    private String amount;
    /**
     * 税率
     */
    @ApiModelProperty(value = "税率")
    private String taxRate;
    /**
     * 税额
     */
    @ApiModelProperty(value = "税额")
    private String taxAmount;
    /**
     * 含税单价
     */
    @ApiModelProperty(value = "含税单价")
    private String taxPrice;
    /**
     * 价税合计（含税金额）
     */
    @ApiModelProperty(value = "价税合计（含税金额）")
    private String allAmount;
    /**
     * 采购合同ID
     */
    @ApiModelProperty(value = "采购合同ID")
    private String buyContractId;
    /**
     * 采购合同号
     */
    @ApiModelProperty(value = "采购合同号")
    private String buyContractNo;
    /**
     * 采购合同明细ID
     */
    @ApiModelProperty(value = "采购合同明细ID")
    private Integer buyContractListId;
    /**
     * 源单类型（关联表单）
     * 1计划订单、采购申请单
     */
    @ApiModelProperty(value = "源单类型（关联表单） 1计划订单、采购申请单")
    private String sourceType;
    /**
     * 源单ID
     */
    @ApiModelProperty(value = "源单ID")
    private String sourceId;
    /**
     * 源单号
     */
    @ApiModelProperty(value = "源单号")
    private String sourceCode;
    /**
     * 源单明细ID
     */
    @ApiModelProperty(value = "源单明细ID")
    private String sourceListId;
    /**
     * 采购订单ID（外键）
     */
    @ApiModelProperty(value = "采购订单ID（外键）")
    private String buyOrderId;
    /**
     * 采购订单编号（PO+8位年月日+0001）
     */
    @ApiModelProperty(value = "采购订单编号（PO+8位年月日+0001）")
    private String buyOrderCode;
    /**
     * 采购订单明细表ID（主键）
     */
    @ApiModelProperty(value = "采购订单明细表ID（主键）")
    private String buyOrderListId;
    /**
     * 检验方式：0免检、1抽检
     */
    @ApiModelProperty(value = "检验方式：0免检、1抽检")
    private Integer checkType;
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
     * 物料ID（外键）
     */
    @ApiModelProperty(value = "物料ID（外键）")
    private String materialId;
    /**
     * 拣货条码
     */
    @ApiModelProperty(value = "拣货条码")
    private String pickCode;
    /**
     * 未发货数量
     */
    @ApiModelProperty(value = "未发货数量")
    private String noFinishQty;
    /**
     * 批次号
     */
    @ApiModelProperty(value = "批次号")
    private String batchNo;
    /**
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private String companyId;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
}

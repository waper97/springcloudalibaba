package com.bpm.mes.purchase.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 配送计划批次表(MesPurchaseBuySendBatch)实体类
 *
 * @author renruiling
 * @since 2022-04-28 16:42:16
 */
@Data
@ApiModel(value = "MesPurchaseBuySendBatch")
public class MesPurchaseBuySendBatch implements Serializable {
    private static final long serialVersionUID = 637590642392746847L;
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
    @ApiModelProperty(value = "物料编码 ")
    private String materialCode;
    /**
     * 物料简称
     */
    @ApiModelProperty(value = "物料简称")
    private String materialShortName;
    /**
     * 物料规格
     */
    @ApiModelProperty(value = "物料规格")
    private String materialSpec;
    /**
     * 计量单位ID（外键）
     */
    @ApiModelProperty(value = "计量单位ID（外键）")
    private String unitsId;
    /**
     * 唯一码
     */
    @ApiModelProperty(value = "唯一码")
    private String barCode;
    /**
     * 生产批次号（供应商）
     */
    @ApiModelProperty(value = "生产批次号（供应商）")
    private String batchNo;
    /**
     * 入库批次号（入库）
     */
    @ApiModelProperty(value = "入库批次号（入库）")
    private String inBatchNo;
    /**
     * 标签类型：1装箱，2装板
     * 对应物料信息中的装箱数量和装板数量
     */
    @ApiModelProperty(value = "标签类型：1装箱，2装板 对应物料信息中的装箱数量和装板数量")
    private Integer labelType;
    /**
     * 标准数量
     */
    @ApiModelProperty(value = "标准数量 ")
    private Integer standardPackQty;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量 ")
    private Integer qty;
    /**
     * 到货数量
     */
    @ApiModelProperty(value = "到货数量")
    private String commitQty;
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


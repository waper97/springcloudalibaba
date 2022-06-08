package com.bpm.mes.purchase.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 收货通知单明细表(MesPurchaseBuyAcceptList)实体类
 *
 * @author renruiling
 * @since 2022-04-28 16:43:13
 */
@Data
@ApiModel(value = "MesPurchaseBuyAcceptList")
public class MesPurchaseBuyAcceptList implements Serializable {
    private static final long serialVersionUID = -48319799811037742L;
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 收货通知单ID（外键）
     */
    @ApiModelProperty(value = "收货通知单ID（外键）")
    private Integer buyAcceptId;
    /**
     * 收货单编号（SE+8位年月日+3位流水号）
     */
    @ApiModelProperty(value = "收货单编号（SE+8位年月日+3位流水号）")
    private String buyAcceptNo;
    /**
     * 来料检验单号（IQC180102001）
     */
    @ApiModelProperty(value = "来料检验单号（IQC180102001）")
    private String iqcCheckCode;
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
    @ApiModelProperty(value = "物料简称")
    private String materialShortName;
    /**
     * 物料规格
     */
    @ApiModelProperty(value = "物料规格 ")
    private String materialSpec;
    /**
     * 计量单位ID
     */
    @ApiModelProperty(value = "计量单位ID")
    private Integer unitsId;
    /**
     * 计划数量
     */
    @ApiModelProperty(value = "计划数量")
    private Float qty;
    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String carNum;
    /**
     * 拒收数量（隐藏）
     */
    @ApiModelProperty(value = "拒收数量（隐藏）")
    private Float noCommitQty;
    /**
     * 实收数量（实收=整车-空车）
     * （实退数量+合格数量+特采数量+报废数量）
     */
    @ApiModelProperty(value = "实收数量（实收=整车-空车）（实退数量+合格数量+特采数量+报废数量）")
    private Float commitQty;
    /**
     * 合格数量（一次合格数量+特采数量）
     */
    @ApiModelProperty(value = "合格数量（一次合格数量+特采数量）")
    private Float passQty;
    /**
     * 空车重量
     */
    @ApiModelProperty(value = "空车重量")
    private Float emptyCarQty;
    /**
     * 整车重量
     */
    @ApiModelProperty(value = "整车重量")
    private Float wholeCarQty;
    /**
     * 特采数量（让步接收）
     */
    @ApiModelProperty(value = "特采数量（让步接收）")
    private Float conPassQty;
    /**
     * 不合格数量（特采数量+退货数量+报废数量）
     */
    @ApiModelProperty(value = "不合格数量（特采数量+退货数量+报废数量）")
    private Float noPassQty;
    /**
     * 退货数量
     */
    @ApiModelProperty(value = "退货数量")
    private Float returnCommitQty;
    /**
     * 保质期（天）
     */
    @ApiModelProperty(value = "保质期（天）")
    private Integer kfPeriod;
    /**
     * 生产/采购日期
     */
    @ApiModelProperty(value = "生产/采购日期")
    private Date kfDate;
    /**
     * 有效期至
     */
    @ApiModelProperty(value = "有效期至")
    private Date periodDate;
    /**
     * 交货日期
     */
    @ApiModelProperty(value = "交货日期")
    private Date fetchDate;
    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private Float price;
    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private Float amount;
    /**
     * 唯一码
     */
    @ApiModelProperty(value = "唯一码")
    private String barCode;
    /**
     * 入库批次号
     */
    @ApiModelProperty(value = "入库批次号")
    private String inBatchNo;
    /**
     * 生产批次号
     */
    @ApiModelProperty(value = "生产批次号")
    private String batchNo;
    /**
     * 仓库ID
     */
    @ApiModelProperty(value = "仓库ID")
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
     * 货区货位ID（外键）
     */
    @ApiModelProperty(value = "货区货位ID（外键）")
    private Integer stockPlaceId;
    /**
     * 货区货位编码
     */
    @ApiModelProperty(value = "货区货位编码")
    private String stockPlaceNo;
    /**
     * 源单类型（关联表单）
     * 1计划订单、采购申请单
     */
    @ApiModelProperty(value = "源单类型（关联表单） 1计划订单、采购申请单")
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
     * 采购订单ID
     */
    @ApiModelProperty(value = "采购订单ID")
    private Integer buyOrderId;
    /**
     * 采购订单编号（PO+8位年月日+0001）
     */
    @ApiModelProperty(value = "采购订单编号（PO+8位年月日+0001）")
    private String buyOrderCode;
    /**
     * 采购订单明细ID
     */
    @ApiModelProperty(value = "采购订单明细ID")
    private Integer buyOrderListId;
    /**
     * 状态：1 新增、2报检、3检验中、4、评审中、5已检验、6已入库
     */
    @ApiModelProperty(value = "状态：1 新增、2报检、3检验中、4、评审中、5已检验、6已入库")
    private Integer state;
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
     * 修改人id
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
     * 单据日期
     */
    @ApiModelProperty(value = "单据日期")
    private Date date;
    /**
     * 检验方式
     */
    @ApiModelProperty(value = "检验方式")
    private Integer checkType;
    /**
     * 过磅单号
     */
    @ApiModelProperty(value = "过磅单号")
    private String passBangCode;

    @ApiModelProperty(value = "检验数量")
    private Float checkQty;
}


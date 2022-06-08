package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MesPurchaseBuyAcceptListUpdateDTO {
    /**
     * 收货通知单ID（外键）
     */
    @ApiModelProperty(value = "收货通知单ID（外键）")
    private Integer buyAcceptId;
    /**
     * 主键id（行号）
     */
    @ApiModelProperty(value = "主键id（行号）")
    private Integer id;
    /**
     * 0无效，1有效，默认1
     */
    @ApiModelProperty(value = "0无效，1有效，默认1")
    private Integer isValid;
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
     * 实收数量（实收=整车-空车）
     * （实退数量+合格数量+特采数量+报废数量）
     */
    @ApiModelProperty(value = "实收数量（实收=整车-空车）（实退数量+合格数量+特采数量+报废数量） ")
    private Float commitQty;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号 ")
    private String carNum;
//    /**
//     * 检验方式
//     */
//    @ApiModelProperty(value = "检验方式")
//    private String checkType;
    /**
     * 合格数量
     */
    @ApiModelProperty(value = "合格数量")
    private Float passQty;
    /**
     * 不合格数量
     */
    @ApiModelProperty(value = "不合格数量")
    private Float noPassQty;
    /**
     * 让步接收（特采数量）
     */
    @ApiModelProperty(value = "让步接收（特采数量）")
    private Float conPassQty;
    /**
     * 生产批次号
     */
    @ApiModelProperty(value = "生产批次号")
    private String batchNo;
    /**
     * 检验数量
     */
    @ApiModelProperty(value = "检验数量")
    private Float checkQty;
    /**
     * 源单号
     */
    @ApiModelProperty(value = "源单号")
    private String sourceCode;
    /**
     * 采购单号
     */
    @ApiModelProperty(value = "采购单号")
    private String buyOrderCode;
    /**
     * 检验单号
     */
    @ApiModelProperty(value = "检验单号")
    private String iqcCheckCode;
    /**
     * 过磅单号
     */
    @ApiModelProperty(value = "过磅单号")
    private String passBangCode;

//    /**
//     * 仓库编码
//     */
//    @ApiModelProperty(value = "仓库编码")
//    private String stockCode;
    /**
     * 状态：1 新增、2报检、3检验中、4、评审中、5已检验、6已入库
     */
    @ApiModelProperty(value = "状态：1 新增、2报检、3检验中、4、评审中、5已检验、6已入库")
    private Integer state;
    /**
     * 收货单编号（SE+8位年月日+3位流水号）
     */
    @ApiModelProperty(value = "收货单编号（SE+8位年月日+3位流水号）")
    private String buyAcceptNo;
//    /**
//     * 空车重量
//     */
//    @ApiModelProperty(value = "空车重量")
//    private Float emptyCarQty;
//    /**
//     * 整车重量
//     */
//    @ApiModelProperty(value = "整车重量")
//    private Float wholeCarQty;
}

package com.bpm.mes.purchase.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  收货通知单批次表(MesPurchaseBuyAcceptBatch)实体类
 *
 * @author renruiling
 * @since 2022-04-28 16:43:30
 */
@Data
@ApiModel(value = "MesPurchaseBuyAcceptBatch")
public class MesPurchaseBuyAcceptBatch implements Serializable {
    private static final long serialVersionUID = -84785000063959156L;
        /**
         * 主键id
         */
        @ApiModelProperty(value = "主键id")
        private Integer id;
        /**
         * 收货通知单明细（外键）
         */
        @ApiModelProperty(value = "收货通知单明细（外键）")
        private String buyAcceptListId;
        /**
         * 收货通知单ID（外键）
         */
        @ApiModelProperty(value = "收货通知单ID（外键）")
        private String buyAcceptId;
        /**
         * 收货单编号（SE+8位年月日+3位流水号）
         */
        @ApiModelProperty(value = "收货单编号（SE+8位年月日+3位流水号）")
        private String buyAcceptNo;
        /**
         * 物料ID（外键）
         */
        @ApiModelProperty(value = "物料ID（外键）")
        private String materielId;
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
        @ApiModelProperty(value = "物料规格")
        private String materialSpec;
        /**
         * 计量单位ID（外键）
         */
        @ApiModelProperty(value = "计量单位ID（外键）")
        private String unitsId;
        /**
         * 唯一码（箱号）
         */
        @ApiModelProperty(value = "唯一码（箱号）")
        private String barCode;
        /**
         * 批次号（供应商）
         */
        @ApiModelProperty(value = "批次号（供应商）")
        private String batchNo;
        /**
         * 批次号（入库）
         */
        @ApiModelProperty(value = "批次号（入库）")
        private String inBatchNo;
        /**
         * 通知数量
         */
        @ApiModelProperty(value = "通知数量")
        private Integer qty;
        /**
         * 实收数量
         */
        @ApiModelProperty(value = "实收数量")
        private String commitQty;
        /**
         * 合格数量（一次合格数量+特采数量）
         */
        @ApiModelProperty(value = "合格数量（一次合格数量+特采数量）")
        private String passQty;
        /**
         * 实退数量
         */
        @ApiModelProperty(value = "实退数量")
        private String returnCommitQty;
        /**
         * 入库数量
         */
        @ApiModelProperty(value = "入库数量")
        private String stockQty;
        /**
         * 状态：1 新增、2报检、3检验中、4已检验、5已入库
         */
        @ApiModelProperty(value = "状态：1 新增、2报检、3检验中、4已检验、5已入库")
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


package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 库位绑定物料表(MesWmsStockplacebind)实体类
 *
 * @author makejava
 * @since 2022-04-15 15:29:56
 */
@Data
public class MesWmsStockPoPlaceListDto {

        @ApiModelProperty(value = "调拨明细表主键ID")
        private Integer id;

        /**
         * 发出仓库ID（外键）
         */
//        @ApiModelProperty(value = "发出仓库ID（外键）")
//        private Integer outStockId;
        /**
         * 仓库编码
         */
//        @ApiModelProperty(value = "仓库编码")
//        private String outStockCode;
        /**
         * 仓库名称
         */
//        @ApiModelProperty(value = "仓库名称")
//        private String outStockName;
        /**
         * 收入仓库ID（外键）
         */
//        @ApiModelProperty(value = "收入仓库ID（外键）")
//        private Integer inStockId;
        /**
         * 仓库编码
         */
//        @ApiModelProperty(value = "仓库编码")
//        private String inStockCode;
        /**
         * 仓库名称
         */
//        @ApiModelProperty(value = "仓库名称")
//        private String inStockName;

        /**
         * 存放物料ID（外键）
         */
        @ApiModelProperty(value = "存放物料ID（外键）")
        private Integer materialId;
        /**
         * 物料编码
         */
//        @ApiModelProperty(value = "物料编码")
//        private String materialCode;
        /**
         * 物料名称
         */
//        @ApiModelProperty(value = "物料名称  ")
//        private String materialShortName;
        /**
         * 物料规格
         */
//        @ApiModelProperty(value = "物料规格 ")
//        private String materialSpec;
        /**
         * 供应商id
         */
//        @ApiModelProperty(value = "供应商id")
//        private Integer suppliarId;
        /**
         * 供应商编码
         */
//        @ApiModelProperty(value = "供应商编码")
//        private String suppliarCode;
        /**
         * 供应商名称
         */
//        @ApiModelProperty(value = "供应商名称")
//        private String suppliarName;
        /**
         * 计量单位（外键）
         */
//        @ApiModelProperty(value = "计量单位（外键）")
//        private Integer unitsId;
        /**
         * 计量单位名称（外键）
         */
//        @ApiModelProperty(value = "计量单位名称（外键）")
//        private String unitsName;

        /**
         * 入库批次号
         */
//        @ApiModelProperty(value = "入库批次号")
//        private String inBatchNo;

        /**
         * 可用数量
         */
//        @ApiModelProperty(value = "可用数量")
//        private BigDecimal qtyUseable;

        /**
         * 即时库存主表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）
         */
//        @ApiModelProperty(value = "即时库存主表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）")
//        private Integer stockCurrentSumId;
        /**
         * 即时库存明细表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）
         */
//        @ApiModelProperty(value = "即时库存明细表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）")
//        private Integer stockCurrentId;

        /**
         * 调出库区库位ID（外键）
         */
        @ApiModelProperty(value = "调出库区库位ID（外键）")
        private Integer outStockPlaceId;
        /**
         * 调出库位编码
         */
//        @ApiModelProperty(value = "调出库位编码")
//        private String outStockPlaceCode;
        /**
         * 调出库位名称
         */
//        @ApiModelProperty(value = "调出库位名称")
//        private String outStockPlaceName;
        /**
         * 调入库区库位ID（外键）
         */
        @ApiModelProperty(value = "调入库区库位ID（外键）")
        private Integer inStockPlaceId;
        /**
         * 调入库位编码
         */
//        @ApiModelProperty(value = "调入库位编码")
//        private String inStockPlaceCode;
        /**
         * 调入库位名称
         */
//        @ApiModelProperty(value = "调入库位名称")
//        private String inStockPlaceName;

        /**
         * 计划数量
         */
        @ApiModelProperty(value = "计划数量")
        private BigDecimal fPallet;
}


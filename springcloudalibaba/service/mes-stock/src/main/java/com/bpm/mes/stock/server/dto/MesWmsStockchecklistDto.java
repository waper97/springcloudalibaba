package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 仓库盘点明细表(MesWmsStockchecklist)实体类
 *
 * @author makejava
 * @since 2022-04-29 11:41:38
 */
@Data
public class MesWmsStockchecklistDto{
        /**
         * 主键id（行号）
         */
        @ApiModelProperty(value = "主键id（行号）")
        private Integer id;
        /**
         * 存放物料ID（外键）
         */
        @ApiModelProperty(value = "存放物料ID（外键）")
        private Integer materialId;
        /**
         * 即时库存明细表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）
         */
        @ApiModelProperty(value = "即时库存明细表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）")
        private Integer stockCurrentId;
        /**
         * 库位ID
         */
        @ApiModelProperty(value = "库位ID")
        private Integer stockPlaceId;
        /**
         * 帐存数量，3位小数
         */
        @ApiModelProperty(value = "帐存数量，3位小数")
        private BigDecimal accountNum;
        /**
         * 实盘数量，3位小数
         */
        @ApiModelProperty(value = "实盘数量，3位小数")
        private BigDecimal checkNum;
        /**
         * 差异数量
         */
        @ApiModelProperty(value = "差异数量")
        private BigDecimal differentNum;

        /**
         * 供应商id
         */
        @ApiModelProperty(value = "供应商id")
        private Integer suppliarId;

        /**
         * 入库批次号
         */
        @ApiModelProperty(value = "入库批次号")
        private String inBatchNo;


}


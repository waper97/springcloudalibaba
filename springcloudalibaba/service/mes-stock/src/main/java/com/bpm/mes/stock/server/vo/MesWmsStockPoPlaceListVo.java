package com.bpm.mes.stock.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MesWmsStockPoPlaceListVo {

        /**
         * 库位id
         */
        @ApiModelProperty(value = "库位id")
        private Integer stockPlaceId;
        /**
         * 库位编码
         */
        @ApiModelProperty(value = "库位编码")
        private String stockPlaceCode;
        /**
         * 库位名称
         */
        @ApiModelProperty(value = "库位名称")
        private String stockPlaceName;

//        /**
//         * 存放物料ID（外键）
//         */
//        @ApiModelProperty(value = "存放物料ID（外键）")
//        private Integer materialId;
//        /**
//         * 物料编码
//         */
//        @ApiModelProperty(value = "物料编码")
//        private String materialCode;
//        /**
//         * 物料名称
//         */
//        @ApiModelProperty(value = "物料名称  ")
//        private String materialShortName;
//        /**
//         * 物料规格
//         */
//        @ApiModelProperty(value = "物料规格 ")
//        private String materialSpec;
//        /**
//         * 供应商id
//         */
//        @ApiModelProperty(value = "供应商id")
//        private Integer suppliarId;
//        /**
//         * 供应商编码
//         */
//        @ApiModelProperty(value = "供应商编码")
//        private String suppliarCode;
//        /**
//         * 供应商名称
//         */
//        @ApiModelProperty(value = "供应商名称")
//        private String suppliarName;
//        /**
//         * 计量单位（外键）
//         */
//        @ApiModelProperty(value = "计量单位（外键）")
//        private Integer unitsId;
//        /**
//         * 计量单位名称（外键）
//         */
//        @ApiModelProperty(value = "计量单位名称（外键）")
//        private String unitsName;

//        /**
//         * 入库批次号
//         */
//        @ApiModelProperty(value = "入库批次号")
//        private String inBatchNo;
//
//        /**
//         * 可用数量
//         */
//        @ApiModelProperty(value = "可用数量")
//        private BigDecimal qtyUseable;

//        /**
//         * 即时库存明细表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）
//         */
//        @ApiModelProperty(value = "即时库存明细表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）")
//        private Integer stockCurrentId;

}


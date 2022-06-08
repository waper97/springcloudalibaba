package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 库位绑定物料表(MesWmsStockplacebind)实体类
 *
 * @author makejava
 * @since 2022-04-15 15:29:56
 */
@Data
public class MesWmsStockPlaceMaterialListDto {

        /**
         * 存放物料ID（外键）
         */
        @ApiModelProperty(value = "存放物料ID（外键）")
        private Integer materialId;
        /**
         * 物料编码
         */
        @ApiModelProperty(value = "物料编码")
        private String materialCode;
        /**
         * 物料名称
         */
        @ApiModelProperty(value = "物料名称  ")
        private String materialShortName;

        @ApiModelProperty(value = "数量")
        private String qtyUseable;

        @ApiModelProperty(value = "即时库存明细表ID（外键）")
        private Integer stockCurrentId;
}


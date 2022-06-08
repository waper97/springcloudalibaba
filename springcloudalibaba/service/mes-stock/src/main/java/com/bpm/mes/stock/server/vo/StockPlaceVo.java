package com.bpm.mes.stock.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StockPlaceVo {

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
        /**
         * 唯一值
         */
        @ApiModelProperty(value = "唯一值")
        private Integer UniqueValue;
        /**
         * 层数
         */
        @ApiModelProperty(value = "层数")
        private Integer layersNumber;

}


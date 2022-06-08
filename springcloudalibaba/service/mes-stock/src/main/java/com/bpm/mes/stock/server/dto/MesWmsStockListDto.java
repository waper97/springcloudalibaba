package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
public class MesWmsStockListDto {

        /**
         * 仓库id
         */
        @ApiModelProperty(value = "仓库id")
        private Integer stockId;
        /**
         * 仓库id
         */
        @ApiModelProperty(value = "仓库编码")
        private String stockCode;
        /**
         * 仓库id
         */
        @ApiModelProperty(value = "仓库名称")
        private String stockName;

        /**
         * 库位集合
         */
        @ApiModelProperty(value = "库位集合")
        private List<MesWmsStockPlaceListDto> stockPlaceListDtos;

}


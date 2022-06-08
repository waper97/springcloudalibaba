package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 仓库库位转移表(MesWmsStockmoveplace)实体类
 *
 * @author makejava
 * @since 2022-04-18 15:50:52
 */
@Data
public class MesWmsStockmoveplaceNewstDto {

        /**
         * 仓库id
         */
        @ApiModelProperty(value = "仓库id")
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
         * 移出库位ID（外键）筒仓/库位
         */
        @ApiModelProperty(value = "库位ID（外键）筒仓/库位")
        private Integer stockPlaceId;
        /**
         * 移出库位编码
         */
        @ApiModelProperty(value = "库位编码")
        private String stockPlaceCode;
        /**
         * 移出库位名称
         */
        @ApiModelProperty(value = "库位名称")
        private String stockPlaceName;

}


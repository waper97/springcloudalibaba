package com.bpm.mes.stock.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 仓库即时库存明细表(MesWmsStockcurrent)实体类
 *
 * @author makejava
 * @since 2022-04-18 14:08:02
 */
@Data
public class MesWmsStockcurrentStockVo {

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
         * 仓库类型
         */
        @ApiModelProperty(value = "仓库类型")
        private String stockType;

}


package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
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
public class MesWmsStockplacebindQueryDto extends PageDTO {

        /**
         * 库位编码
         */
        @ApiModelProperty(value = "库位编码")
        private String stockPlaceCode;
        /**
         * 仓库编码
         */
        @ApiModelProperty(value = "仓库编码")
        private String stockCode;
}


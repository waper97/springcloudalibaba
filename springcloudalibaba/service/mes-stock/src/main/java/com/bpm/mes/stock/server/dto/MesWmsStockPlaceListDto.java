package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 库位绑定物料表(MesWmsStockplacebind)实体类
 *
 * @author makejava
 * @since 2022-04-15 15:29:56
 */
@Data
public class MesWmsStockPlaceListDto {

        /**
         * 库位id
         */
        @ApiModelProperty(value = "库位id")
        private Integer stockPlaceId;
        /**
         * 库位id
         */
        @ApiModelProperty(value = "库位编码")
        private String stockPlaceCode;
        /**
         * 库位id
         */
        @ApiModelProperty(value = "库位名称")
        private String stockPlaceName;

        /**
         * 子节点集合
         */
        @ApiModelProperty(value = "物料信息")
        private List<MesWmsStockPlaceMaterialListDto> materialListDtos;
}


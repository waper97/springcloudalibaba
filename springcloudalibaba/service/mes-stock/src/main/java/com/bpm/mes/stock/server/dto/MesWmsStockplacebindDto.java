package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 库位绑定物料表(MesWmsStockplacebind)实体类
 *
 * @author makejava
 * @since 2022-04-15 15:29:56
 */
@Data
public class MesWmsStockplacebindDto {

        private Integer id;
        /**
         * 库位id
         */
        @ApiModelProperty(value = "库位id")
        private Integer stockPlaceId;
        /**
         * 存放物料ID（外键）
         */
        @ApiModelProperty(value = "存放物料ID（外键）")
        private Integer materialId;
        /**
         * 仓库id
         */
        @ApiModelProperty(value = "仓库id")
        private Integer stockId;
        /**
         * 容量
         */
        @ApiModelProperty(value = "容量")
        private BigDecimal capacity;
        /**
         * 备注
         */
        @ApiModelProperty(value = "备注")
        private String remark;

        /**
         * 创建人ID
         */
        @ApiModelProperty(value = "创建人ID")
        private Integer currentloginId;
        /**
         * 创建人名称
         */
        @ApiModelProperty(value = "创建人名称")
        private String currentloginName;
        /**
         * 安全库存（最小库存）
         */
        @ApiModelProperty(value = "安全库存（最小库存）")
        private BigDecimal minStock;
        /**
         * 最大库存上限库存
         */
        @ApiModelProperty(value = "最大库存上限库存")
        private BigDecimal maxStock;
}


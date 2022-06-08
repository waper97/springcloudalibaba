package com.bpm.mes.stock.server.vo;

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
public class MaterialVo extends PageDTO {

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
        /**
         * 物料规格 
         */
        @ApiModelProperty(value = "物料规格 ")
        private String materialSpec;
        /**
         * 单品重量，从物料过来
         */
        @ApiModelProperty(value = "单品重量，从物料过来")
        private BigDecimal weightProduct;
        /**
         * 承受重量
         */
        @ApiModelProperty(value = "承受重量")
        private BigDecimal weight;

        /**
         * 计量单位（外键）
         */
        @ApiModelProperty(value = "计量单位（外键）")
        private Integer unitsId;
        /**
         * 计量单位名称（外键）
         */
        @ApiModelProperty(value = "计量单位名称（外键）")
        private String unitsName;
        /**
         * 物料属性：0委外、1外购、2自制半成品、3自制产成品
         */
        @ApiModelProperty(value = "物料属性：0委外、1外购、2自制半成品、3自制产成品")
        private String materialTrId;
        /**
         * 供应商id
         */
        @ApiModelProperty(value = "供应商id")
        private String suppliarId;
        /**
         * 物料属性：0委外、1外购、2自制半成品、3自制产成品
         */
        @ApiModelProperty(value = "供应商名称")
        private String suppliarName;
        /**
         * 物料属性：0委外、1外购、2自制半成品、3自制产成品
         */
        @ApiModelProperty(value = "供应商简称")
        private String suppliarShortName;
        /**
         * 物料属性：0委外、1外购、2自制半成品、3自制产成品
         */
        @ApiModelProperty(value = "供应商编码")
        private String suppliarCode;

}


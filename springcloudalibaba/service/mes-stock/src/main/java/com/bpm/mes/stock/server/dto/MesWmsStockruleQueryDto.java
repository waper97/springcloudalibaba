package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 仓库出入库规则(MesWmsStockrule)实体类
 *
 * @author makejava
 * @since 2022-04-18 09:33:17
 */
@Data
public class MesWmsStockruleQueryDto extends PageDTO {

        /**
         * 规则编码
         */
        @ApiModelProperty(value = "规则编码")
        private String ruleCode;
        /**
         * 规则名称
         */
        @ApiModelProperty(value = "规则名称")
        private String ruleName;
        /**
         * 规则属性 1入库、2出库
         */
        @ApiModelProperty(value = "规则属性 1入库、2出库")
        private String inOutPropert;


}


package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MesWmsStockpoListbatchDto {

        @ApiModelProperty(value = "仓库调拨明细表ID")
        private Integer stockPoListId;
        @ApiModelProperty(value = "仓库调拨明细表ID")
        private Integer stockPoId;
        @ApiModelProperty(value = "创建人ID")
        private Integer currentloginId;
        @ApiModelProperty(value = "创建人名称")
        private String currentloginName;

}


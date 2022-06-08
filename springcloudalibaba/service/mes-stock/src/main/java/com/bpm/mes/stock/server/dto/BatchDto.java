package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BatchDto {

        @ApiModelProperty(value = "ID")
        private Integer id;
        @ApiModelProperty(value = "创建人ID")
        private Integer currentloginId;
        @ApiModelProperty(value = "创建人名称")
        private String currentloginName;

}


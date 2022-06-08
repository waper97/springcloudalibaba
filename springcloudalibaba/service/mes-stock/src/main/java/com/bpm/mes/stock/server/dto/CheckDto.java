package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 仓库盘点主表(MesWmsStockcheck)实体类
 *
 * @author makejava
 * @since 2022-04-29 10:01:50
 */
@Data
public class CheckDto {
        /**
         * 前登录人ID
         */
        @ApiModelProperty(value = "前登录人ID")
        private Integer currentloginId;
        /**
         * 当前登录人名称
         */
        @ApiModelProperty(value = "当前登录人名称")
        private String currentloginName;

        @ApiModelProperty(value = "盘点主表id")
        private List<Integer> stockCheckIds;

}


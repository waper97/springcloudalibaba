package com.bpm.mes.stock.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class StockVo {

    /**
     * 仓库id
     */
    @ApiModelProperty(value = "仓库id")
    private Integer stockId;
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "仓库编码")
    private String stockCode;
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "仓库名称")
    private String stockName;

    @ApiModelProperty(value = "仓库类型：1 原辅料仓、2线边仓、3半成品现场仓、4成品原辅料仓")
    private String stockType;

    /**
     * 仓库状态：1在用，0停用，9盘点
     */
    @ApiModelProperty(value = "仓库状态：1在用，0停用，9盘点")
    private String state;

    /**
     * 层数
     */
    @ApiModelProperty(value = "层数")
    private Integer layersNumber;

    /**
     * 唯一值
     */
    @ApiModelProperty(value = "唯一值")
    private Integer UniqueValue;

    /**
     * 调拨单物料信息
     */
    @ApiModelProperty(value = "库位信息")
    private List<StockPlaceVo> placeVos;
}


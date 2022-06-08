package com.bpm.mes.stock.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MesWmsStockPoListVo {

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
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "调出仓库id")
    private Integer outStockId;
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "调出仓库编码")
    private String outStockCode;
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "调出仓库名称")
    private String outStockName;


    /**
     * 调拨单物料信息
     */
    @ApiModelProperty(value = "调拨单物料信息")
    private List<MesWmsStockPoPlaceListVo> stockPoPlaceListVos;
}


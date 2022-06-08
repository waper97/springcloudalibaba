package com.bpm.mes.stock.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DataDictionaryVo {

    /**
     * 仓库id
     */
    @ApiModelProperty(value = "值id")
    private Integer dictId;
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "值")
    private String dictLabel;
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "值名称")
    private String dictValue;

    /**
     * 唯一值
     */
    @ApiModelProperty(value = "唯一值")
    private Integer UniqueValue;


    @ApiModelProperty(value = "层数")
    private Integer layersNumber;

    @ApiModelProperty(value = "仓库信息")
    private List<StockVo> stockVos;
}


package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MesWmsStockCheckCheckDTO {
    /**
     * 主键id（行号）
     */
    @ApiModelProperty(value = "主键id（行号）")
    private Integer id;
    /**
     * 盘点主表ID，外键
     */
    @ApiModelProperty(value = "盘点主表ID，外键")
    private Integer stockCheckId;
    /**
     * 帐存数量，3位小数
     */
    @ApiModelProperty(value = "帐存数量，3位小数")
    private Float accountNum;
    /**
     * 实盘数量，3位小数
     */
    @ApiModelProperty(value = "实盘数量，3位小数")
    private Float checkNum;
    /**
     * 差异数量
     */
    @ApiModelProperty(value = "差异数量")
    private Float differentNum;

}

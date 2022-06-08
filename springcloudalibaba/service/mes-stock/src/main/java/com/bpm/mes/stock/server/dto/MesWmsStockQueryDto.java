package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 仓库信息表(MesWmsStock)实体类
 *
 * @author makejava
 * @since 2022-04-13 14:45:52
 */
@Data
public class MesWmsStockQueryDto extends PageDTO {

    /**
     * 仓库编码
     */
    private String stockCode;
    /**
     * 仓库名称
     */
    private String stockName;
    /**
     *
     */
    @ApiModelProperty(value = "仓库类型：1 原辅料仓、2线边仓、3半成品现场仓、4成品原辅料仓、5碎石仓")
    private String stockType;

}


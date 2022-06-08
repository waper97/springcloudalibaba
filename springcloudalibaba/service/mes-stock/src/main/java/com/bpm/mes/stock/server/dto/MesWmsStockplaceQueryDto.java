package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 仓库库位表(MesWmsStockplace)实体类
 *
 * @author makejava
 * @since 2022-04-14 16:51:23
 */
@Data
@ApiModel(value = "MesWmsStockplace")
public class MesWmsStockplaceQueryDto extends PageDTO {
    /**
     * 库位编码
     */
    @ApiModelProperty(value = "库位编码")
    private String stockPlaceCode;
    /**
     * 父级库位编码
     */
    @ApiModelProperty(value = "父级库位编码")
    private String parentStockPlacenCode;
    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String stockCode;


}


package com.bpm.mes.stock.server.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.bpm.mes.stock.common.dto.PageDTO;
/**
 * 仓库即时库存主表(MesWmsStockcurrentsum)实体类
 *
 * @author makejava
 * @since 2022-04-18 14:05:05
 */
@Data
public class MesWmsStockcurrentsumQueryDto extends PageDTO {

    /**
     * 仓库id
     */
    @ApiModelProperty(value = "仓库id")
    private Integer stockId;
    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String stockCode;
    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private String stockName;
    /**
     * 仓库类型
     */
    @ApiModelProperty(value = "仓库类型")
    private String stockType;
    /**
     * 供应商id
     */
    @ApiModelProperty(value = "供应商id")
    private Integer suppliarId;
    /**
     * 供应商编码
     */
    @ApiModelProperty(value = "供应商编码")
    private String suppliarCode;
    /**
     * 供应商名称
     */
    @ApiModelProperty(value = "供应商名称")
    private String suppliarName;
}


package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 仓库即时库存明细表(MesWmsStockcurrent)实体类
 *
 * @author makejava
 * @since 2022-04-18 14:55:55
 */
@Data
public class MesWmsStockcurrentQueryDto extends PageDTO {

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
     * 库位id
     */
    @ApiModelProperty(value = "库位id")
    private Integer stockPlaceId;
    /**
     * 库位编码
     */
    @ApiModelProperty(value = "库位编码")
    private String stockPlaceCode;
    /**
     * 库位名称
     */
    @ApiModelProperty(value = "库位名称")
    private String stockPlaceName;
  
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

    /**
     * 仓库类型
     */
    @ApiModelProperty(value = "仓库类型")
    private String stockType;

    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;

    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称  ")
    private String materialShortName;


}


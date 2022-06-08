package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 仓库库位转移表(MesWmsStockmoveplace)实体类
 *
 * @author makejava
 * @since 2022-04-18 17:38:48
 */
@Data
public class MesWmsStockmoveplaceQueryDto extends PageDTO {

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
  


}


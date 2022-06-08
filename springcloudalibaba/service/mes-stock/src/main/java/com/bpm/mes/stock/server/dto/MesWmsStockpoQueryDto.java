package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 仓库调拨单主表(MesWmsStockpo)实体类
 *
 * @author makejava
 * @since 2022-04-20 18:13:02
 */
@Data
public class MesWmsStockpoQueryDto extends PageDTO {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 单据编号（PO+年月日+4流水号）
     */    
    @ApiModelProperty(value = "单据编号（PO+年月日+4流水号）")
    private String stockPoCode;
  

    /**
     * 调拨类型：1 普通调拨，2 销售调拨
     */    
    @ApiModelProperty(value = "调拨类型：1 普通调拨，2 销售调拨")
    private String poType;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;

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


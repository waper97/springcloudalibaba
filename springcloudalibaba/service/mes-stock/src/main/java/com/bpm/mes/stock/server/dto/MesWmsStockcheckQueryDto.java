package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 仓库盘点主表(MesWmsStockcheck)实体类
 *
 * @author makejava
 * @since 2022-04-28 19:16:22
 */
@Data
public class MesWmsStockcheckQueryDto extends PageDTO {

    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    @ApiModelProperty(value = "物料名称  ")
    private String materialShortName;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
  
}


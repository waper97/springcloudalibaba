package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 仓库出入库主表(MesWmsStockinout)实体类
 *
 * @author makejava
 * @since 2022-04-22 16:08:22
 */
@Data
public class MesWmsStockinoutQueryDto extends PageDTO {


    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    @ApiModelProperty(value = "物料名称  ")
    private String materialShortName;
    @ApiModelProperty(value = "执行状态")
    private String status;
    @ApiModelProperty(value = "出入库操作类型ID（外键）SAP：移动类型 入库类型")
    private Integer inOutTypeId;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
}


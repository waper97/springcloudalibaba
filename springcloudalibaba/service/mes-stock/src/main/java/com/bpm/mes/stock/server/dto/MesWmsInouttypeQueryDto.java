package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 仓库出入库类型表(MesWmsInouttype)实体类
 *
 * @author makejava
 * @since 2022-04-14 10:35:29
 */
@Data
public class MesWmsInouttypeQueryDto extends PageDTO {

    /**
     * 仓库出入库类型编码
     */
    @ApiModelProperty(value = "仓库出入库类型编码")
    private String inOutTypeCode;
    /**
     * 仓库出入库类型名称
     */
    @ApiModelProperty(value = "仓库出入库类型名称")
    private String inOutTypeName;

    /**
     * 操作属性：1入库、2出库 数据字典
     */
    @ApiModelProperty(value = "操作属性：1入库、2出库 数据字典")
    private String inOutPropert;
}


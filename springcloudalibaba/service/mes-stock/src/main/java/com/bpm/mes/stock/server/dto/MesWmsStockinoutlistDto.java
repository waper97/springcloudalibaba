package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 仓库出入库明细表(MesWmsStockinoutlist)实体类
 *
 * @author makejava
 * @since 2022-04-24 09:24:13
 */
@Data
public class MesWmsStockinoutlistDto {

    private Integer id;
    /**
     * 出入库ID（外键
     */
    @ApiModelProperty(value = "出入库ID（外键")
    private Integer stockInOutId;
    /**
     * 存放物料ID（外键）
     */
    @ApiModelProperty(value = "存放物料ID（外键）")
    private Integer materialId;

    @ApiModelProperty(value = "收货单明细id")
    private Integer buyAcceptListId;
    /**
     * 计划数量
     */
    @ApiModelProperty(value = "计划数量")
    private BigDecimal fPallet;
    /**
     * 库区库位ID（外键）
     */
    @ApiModelProperty(value = "库区库位ID（外键）")
    private Integer stockPlaceId;

    /**
     * 供应商id 采购（委外）入库时用
     */
    @ApiModelProperty(value = "供应商id 采购（委外）入库时用")
    private Integer suppliarId;

    @ApiModelProperty(value = "源单号ID（关联表单）")
    private Integer sourceId;
    @ApiModelProperty(value = "源单明细ID")
    private Integer sourceListId;

}


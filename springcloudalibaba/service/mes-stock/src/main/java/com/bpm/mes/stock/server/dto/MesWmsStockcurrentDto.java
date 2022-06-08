package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 仓库即时库存明细表(MesWmsStockcurrent)实体类
 *
 * @author makejava
 * @since 2022-04-18 14:24:17
 */
@Data
public class MesWmsStockcurrentDto {

    @ApiModelProperty(value = "主表ID")
    private Integer id;

    @ApiModelProperty(value = "即时库存明细表ID（外键）")
    private Integer stockCurrentId;
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "仓库id")
    private Integer stockId;
    /**
     * 库位id
     */
    @ApiModelProperty(value = "库位id")
    private Integer stockPlaceId;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 前登录人ID
     */
    @ApiModelProperty(value = "前登录人ID")
    private Integer currentloginId;
    /**
     * 当前登录人名称
     */
    @ApiModelProperty(value = "当前登录人名称")
    private String currentloginName;
    /**
     * 转移数量
     */
    @ApiModelProperty(value = "转移数量")
    private BigDecimal moveQty;
    /**
     * 目标库位ID（外键）筒仓/库位
     */
    @ApiModelProperty(value = "目标库位ID（外键）筒仓/库位")
    private Integer stockPlaceIdNew;

    @ApiModelProperty(value = "（单据日期）（YYYY-MM-DD")
    private String movePlaceDate;
    /**
     * 过账日期
     */
    @ApiModelProperty(value = "过账日期")
    private String postingPlaceDate;

    /**
     * 经办人
     */
    @ApiModelProperty(value = "经办人")
    private String disposer;
    @ApiModelProperty(value = "经办人id")
    private Integer disposerId;
    @ApiModelProperty(value = "移除类型")
    private String moveType;
}


package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 仓库库位表(MesWmsStockplace)实体类
 *
 * @author makejava
 * @since 2022-04-14 16:51:23
 */
@Data
public class MesWmsStockplaceDto{

    private Integer id;
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
     * 父级ID（外键）本表id
     */
    @ApiModelProperty(value = "父级ID（外键）本表id")
    private Integer parentId;
    /**
     * 层数(自动生成)
     */
    @ApiModelProperty(value = "层数(自动生成)")
    private Integer layerNum;
    /**
     * 存放物料ID（外键）
     */
    @ApiModelProperty(value = "存放物料ID（外键）")
    private Integer materialId;
    /**
     * 仓库id
     */
    @ApiModelProperty(value = "仓库id")
    private Integer stockId;
    /**
     * 状态：0闲置、1占用、2满仓
     */
    @ApiModelProperty(value = "状态：0闲置、1占用、2满仓")
    private String state;
    /**
     * 对应筒仓编号
     */
    @ApiModelProperty(value = "对应筒仓编号")
    private String siloCode;
    /**
     * 中控系统ID
     */
    @ApiModelProperty(value = "中控系统ID")
    private Integer zkSystemId;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建人ID
     */
    @ApiModelProperty(value = "创建人ID")
    private Integer currentloginId;
    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称")
    private String currentloginName;

    /**
     * 库区库位类型 1库区 2库位
     */
    @ApiModelProperty(value = "库区库位类型 1库区 2库位")
    private String stockPlaceType;
}


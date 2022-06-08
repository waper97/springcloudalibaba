package com.bpm.mes.stock.server.tree;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 仓库库位表(MesWmsStockplace)实体类
 *
 * @author makejava
 * @since 2022-04-14 16:51:23
 */
@Data
public class MesWmsStockplaceTree {
    /**
     * 行号唯一值
     */
    @ApiModelProperty(value = "行号唯一值")
    private Integer rowNumber;
    /**
     * 库位id
     */
    @ApiModelProperty(value = "库位id")
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
     * 父级库位编码
     */
    @ApiModelProperty(value = "父级库位编码")
    private String parentStockPlacenCode;
    /**
     * 父级库位名称
     */
    @ApiModelProperty(value = "父级库位名称")
    private String parentStockPlacenName;

    /**
     * 库位名称
     */
    @ApiModelProperty(value = "层数")
    protected Integer layerNum;

    /**
     * 是否叶结点（1是，0否）
     */
    @ApiModelProperty(value = "是否叶结点（1是，0否）")
    private String isLeaf;

    /**
     * 子节点集合
     */
    @ApiModelProperty(value = "子节点集合")
    protected List<MesWmsStockplaceTree> children = new ArrayList<MesWmsStockplaceTree>();


}


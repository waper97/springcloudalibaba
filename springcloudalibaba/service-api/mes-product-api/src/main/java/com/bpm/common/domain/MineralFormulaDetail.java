package com.bpm.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 矿石配方明细实体类
 *
 * @author zhangzheming
 * @since 2022-05-09 19:55:36
 */
@Data
@ApiModel(value = "矿石配方明细实体类")
public class MineralFormulaDetail implements Serializable {
    private static final long serialVersionUID = 201586867261698076L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 配方主表id 外键
     */
    @ApiModelProperty(value = "配方主表id 外键")
    private Integer mineralFormulaId;
    /**
     * 碎石仓id 外键
     */
    @ApiModelProperty(value = "碎石仓id 外键")
    private Integer brokenStoneWarehouseId;
    /**
     * 物料id
     */
    @ApiModelProperty(value = "物料id")
    private Integer varieties;
    /**
     * 比例(百分比)
     */
    @ApiModelProperty(value = "比例(百分比)")
    private BigDecimal percentage;
    /**
     * 状态 0新增 1关闭
     */
    @ApiModelProperty(value = "状态 0新增 1关闭")
    private Integer status;
    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
    private Integer createId;
    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称")
    private String createName;
    /**
     * 创建时间 yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "创建时间 yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改人id
     */
    @ApiModelProperty(value = "修改人id")
    private Integer updateId;
    /**
     * 修改人名称
     */
    @ApiModelProperty(value = "修改人名称")
    private String updateName;
    /**
     * 修改时间 yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "修改时间 yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除 0否 1是
     */
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Integer isDeleted;


}


package com.bpm.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 矿石配方实体类
 *
 * @author zhangzheming
 * @since 2022-05-09 15:15:56
 */
@Data
@ApiModel(value = "矿石配方实体类")
public class MineralFormula implements Serializable {
    private static final long serialVersionUID = -23120260917097042L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 配方名称
     */
    @ApiModelProperty(value = "配方名称")
    private String formulaName;
    /**
     * 磨前仓号id 外键
     */
    @ApiModelProperty(value = "磨前仓号id 外键")
    private Integer brokenStoneWarehouse;
    /**
     * 产品id 外键
     */
    @ApiModelProperty(value = "产品id 外键")
    private Integer varieties;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
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
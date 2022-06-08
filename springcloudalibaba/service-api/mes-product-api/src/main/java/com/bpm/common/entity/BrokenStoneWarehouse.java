package com.bpm.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 *
 * 碎石仓(BrokenStoneWarehouse)实体类
 * @author wangpeng
 * @since 2022-04-29 10:25:28
 */
@Data
@ApiModel(value = "碎石仓")
public class BrokenStoneWarehouse  implements Serializable {
    private static final long serialVersionUID = -30440013442803158L;

    /**
    * id
    */
    @ApiModelProperty(value = "id")
    private Integer id;


    /**
    * 碎石仓名称
    */
    @ApiModelProperty(value = "碎石仓名称")
    private String name;


    /**
    * 仓库id 外键关联仓库
    */
    @ApiModelProperty(value = "碎仓库id 外键关联仓库")
    private Integer warehouseId;


    /**
    * 生产品种  数据字典
    */
    @ApiModelProperty(value = "生产品种  数据字典")
    private String productionScores;


    /**
    * 物料id外键  关联物料表
    */
    @ApiModelProperty(value = "物料id外键  关联物料表")
    private Integer materialsId;


    /**
    * 物料名称
    */
    @ApiModelProperty(value = "物料名称")
    private String materialsName;


    /**
    * 矿石编号
    */
    @ApiModelProperty(value = "矿石编号")
    private String stoneCode;


    /**
    * 矿石名称
    */
    @ApiModelProperty(value = "矿石名称")
    private String stoneName;


    /**
    * 状态 0已关闭 1新增
    */
    @ApiModelProperty(value = "状态 0已关闭 1新增")
    private Integer status;


    /**
    * 备注
    */
    @ApiModelProperty(value = "备注")
    private String remark;


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
    * 创建时间  格式：yyyy-MM-dd HH:mm:ss
    */
    @ApiModelProperty(value = "创建时间  格式：yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


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
    * 修改时间 格式：yyyy-MM-dd HH:mm:ss
    */
    @ApiModelProperty(value = "修改时间 格式：yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


    /**
    * 是否删除 0否 1是
    */
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Integer isDeleted;


    /**
    * 碎石仓编号
    */
    @ApiModelProperty(value = "碎石仓编号")
    private String code;



}


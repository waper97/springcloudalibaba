package com.bpm.common.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.bpm.common.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 物料需求计划(MaterialRequirementsPlanning)实体类
 *
 * @author wangpeng
 * @since 2022-04-25 14:16:49
 */
@Data
@ApiModel(value = "物料需求计划")
public class MaterialRequirementsPlanning extends PageDTO implements Serializable {
    private static final long serialVersionUID = -95477938534947736L;

    /**
    * id 
    */
    @ApiModelProperty(value = "id ")
    private Integer id;


    /**
    * 计划运算类型：1 mps、2 mrp
    */
    @ApiModelProperty(value = "计划运算类型：1 mps、2 mrp")
    private String planningOperation;


    /**
    * 运算编号
    */
    @ApiModelProperty(value = "运算编号")
    private String operationCode;


    /**
    * 运算日期  数据字典
    */
    @ApiModelProperty(value = "运算日期  数据字典")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operationDate;


    /**
    * 展望期开始日期
    */
    @ApiModelProperty(value = "展望期开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime needBeginDate;


    /**
    * 展望期结束日期
    */
    @ApiModelProperty(value = "展望期结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime needEndDate;


    /**
    * 创建人id
    */
    @ApiModelProperty(value = "创建人id")
    private String createId;


    /**
    * 创建人名称
    */
    @ApiModelProperty(value = "创建人名称")
    private String createName;


    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


    /**
    * 创建人id
    */
    @ApiModelProperty(value = "创建人id")
    private Integer updateId;


    /**
    * 修改人名称
    */
    @ApiModelProperty(value = "修改人名称")
    private String updateName;


    /**
    * 修改时间
    */
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


    /**
    * 预计量计算有效开始日期
    */
    @ApiModelProperty(value = "预计量计算有效开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planningOperationEffective;


    /**
    * 运算方案id
    */
    @ApiModelProperty(value = "运算方案id")
    private String planSchemeId;


    /**
    * 审核人id
    */
    @ApiModelProperty(value = "审核人id")
    private String checkerId;


    /**
    * 审核人名称
    */
    @ApiModelProperty(value = "审核人名称")
    private String checkName;


    /**
    * 审核时间
    */
    @ApiModelProperty(value = "审核时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkTime;


    /**
    * 是否删除 0否，1是
    */
    @ApiModelProperty(value = "是否删除 0否，1是")
    private Integer isDeleted;


    /**
    * 下达人id
    */
    @ApiModelProperty(value = "下达人id")
    private Integer issueId;


    /**
    * 下达人名称
    */
    @ApiModelProperty(value = "下达人名称")
    private String issuerName;


    /**
    * 下达时间
    */
    @ApiModelProperty(value = "下达时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime issueTime;


    /**
    * 主生产计划id 外键
    */
    @ApiModelProperty(value = "主生产计划id 外键")
    private Integer masterProductionPlanId;


    /**
    * 状态： 0已下发、、1新增，2已审核
    */
    @ApiModelProperty(value = "状态： 0已下发、、1新增，2已审核")
    private Integer status;



}


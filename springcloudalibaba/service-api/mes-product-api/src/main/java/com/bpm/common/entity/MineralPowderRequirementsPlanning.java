package com.bpm.common.entity;

import com.bpm.common.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 矿粉需求计划 实体类
 *
 * @author wangpeng
 * @since 2022-04-24 09:40:20
 */
@Data
@ApiModel(value = "矿粉需求计划")
public class MineralPowderRequirementsPlanning extends PageDTO implements Serializable {
    private static final long serialVersionUID = 862766274938436114L;

    /**
    * id
    */
    @ApiModelProperty(value = "id")
    private Integer id;


    /**
    * 计划编号
    */
    @ApiModelProperty(value = "计划编号")
    private String planCode;


    /**
    * 计划日期开始 格式： yyyy-MM-dd hh:mm:ss
    */
    @ApiModelProperty(value = "计划日期开始 格式： yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planDateBegin;


    /**
    * 计划日期结束 格式：yyyy-MM-dd hh:mm:ss
    */
    @ApiModelProperty(value = "计划日期结束 格式：yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planDateEnd;


    /**
    * 计划周期  1.季度，2日 数据字典
    */
    @ApiModelProperty(value = "计划周期  1.季度，2日 数据字典")
    private String planCycle;


    /**
    * 需求筒仓
    */
    @ApiModelProperty(value = "需求筒仓")
    private String silo;


    /**
    * 备注
    */
    @ApiModelProperty(value = "备注")
    private String remark;


    /**
    * 状态：1新增，2已提交，3已审核
    */
    @ApiModelProperty(value = "状态：1新增，2已提交，3已审核")
    private Integer status;


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
    * 修改人id
    */
    @ApiModelProperty(value = "修改人id")
    private String updateId;


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
     * 需求单位名称
     */
    @ApiModelProperty(value = "需求单位id")
    private Integer demandOrganizatioId;

}


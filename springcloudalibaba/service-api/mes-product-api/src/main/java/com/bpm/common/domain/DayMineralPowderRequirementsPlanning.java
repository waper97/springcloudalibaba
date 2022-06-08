package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * 日矿粉需求计划(DayMineralPowderRequirementsPlanning)实体类
 *
 * @author wangpeng
 * @since 2022-04-26 09:46:11
 */
@Data
@ApiModel(value = "日矿粉需求计划")
public class DayMineralPowderRequirementsPlanning implements Serializable {
    private static final long serialVersionUID = -93473469771790243L;

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
    * 计划开始日期
    */    
    @ApiModelProperty(value = "计划开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planBeginDate;

    /**
    * 计划结束日期
    */    
    @ApiModelProperty(value = "计划结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planEndTime;

    /**
    * 计划周期  1.季度，2日
    */    
    @ApiModelProperty(value = "计划周期  1.季度，2日")
    private String planCycle;

    /**
    * 需求单位
    */    
    @ApiModelProperty(value = "需求单位")
    private Integer demandOrganization;

    /**
    * 需求日期 格式：yyyy-MM-dd hh:mm:ss
    */    
    @ApiModelProperty(value = "需求日期 格式：yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime demandDate;

    /**
    * 需求筒仓 外键
    */    
    @ApiModelProperty(value = "需求筒仓 外键")
    private Integer silo;

    /**
    *  发送方式  数据字典 罐车、袋装、直接线边仓
    */    
    @ApiModelProperty(value = " 发送方式  数据字典 罐车、袋装、直接线边仓")
    private String sendMethod;

    /**
    * 备注
    */    
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
    * 状态：1新增，2已提交，3已审核
    */    
    @ApiModelProperty(value = "状态：1新增，2已提交，3已审核  day_mineral_powder_requirements_planning")
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
    * 是否删除0否 1是
    */    
    @ApiModelProperty(value = "是否删除0否 1是")
    private Integer isDeleted;


}


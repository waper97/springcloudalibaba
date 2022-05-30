package com.bpm.common.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.bpm.common.dto.PageDTO;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 日生产计划(DayPlanning)实体类
 *
 * @author wangpeng
 * @since 2022-05-06 09:54:45
 */
@Data
@ApiModel(value = "日生产计划")
public class DayPlanning extends PageDTO implements Serializable {
    private static final long serialVersionUID = 363808385007382071L;

    /**
    * id
    */
    @ApiModelProperty(value = "id")
    private Integer id;


    /**
    * 计划编号 
    */
    @ApiModelProperty(value = "计划编号 ")
    private String planCode;


    /**
    * 工序
    */
    @ApiModelProperty(value = "工序")
    private Integer processe;


    /**
    * 计划日期 yyyy-mm-dd hh:mm ss
    */
    @ApiModelProperty(value = "计划日期 yyyy-mm-dd hh:mm ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planDate;


    /**
    * 计划开始时间 yyyy-mm-dd hh:mm ss
    */
    @ApiModelProperty(value = "计划开始时间 yyyy-mm-dd hh:mm ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planBeginTime;


    /**
    * 计划结束时间 yyyy-mm-dd hh:mm ss
    */
    @ApiModelProperty(value = "计划结束时间 yyyy-mm-dd hh:mm ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planEndTime;



    /**
    * 执行顺序
    */
    @ApiModelProperty(value = "执行顺序")
    private Integer executionSequence;


    /**
    *生产类型 数据类型：1.日破碎生产计划 2.日配料输送计划、3日立磨生产计划、4预均化记录、5 粉料配料计划 、 6均化记录 、7气力输送计划、 8缓存仓发放计划
    */
    @ApiModelProperty(value = "生产类型 数据类型：1.日破碎生产计划 2.日配料输送计划、3日立磨生产计划、4预均化记录、5 粉料配料计划 、 6均化记录 、7气力输送计划、 8缓存仓发放计划")
    private String productType;


    /**
    * 矿粉编号
    */
    @ApiModelProperty(value = "矿粉编号")
    private String mineralPowderCode;


    /**
    * 成品仓库id 外键id
    */
    @ApiModelProperty(value = "成品仓库id 外键id")
    private Integer finishedGoodsWarehouseId;


    /**
    * 成品仓号
    */
    @ApiModelProperty(value = "成品仓号")
    private Integer finishedGoodsWarehouseNumber;


    /**
    * 成品批次
    */
    @ApiModelProperty(value = "成品批次")
    private String finishedProductBatches;


    /**
    * 目标重量
    */
    @ApiModelProperty(value = "目标重量")
    private BigDecimal targetWeight;


    /**
    * 料位
    */
    @ApiModelProperty(value = "料位")
    private String materialLevel;


    /**
    * 均化时间
    */
    @ApiModelProperty(value = "均化时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime homogenizeTime;


    /**
    * 接收产线
    */
    @ApiModelProperty(value = "接收产线")
    private String receiveProductionLine;


    /**
    * 状态
    */
    @ApiModelProperty(value = "状态")
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
    * 是否删除:1是，0否
    */
    @ApiModelProperty(value = "是否删除:1是，0否")
    private Integer isDeleted;

    @ApiModelProperty(value = "计划分类")
    private Integer planType;

}


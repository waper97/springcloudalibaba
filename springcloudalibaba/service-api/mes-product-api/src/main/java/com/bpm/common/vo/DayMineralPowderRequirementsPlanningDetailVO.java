package com.bpm.common.vo;
// 设置后缀名称

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 日矿粉需求计划详情(DayMineralPowderRequirementsPlanningDetail)实体类
 *
 * @author wangpeng
 * @since 2022-04-26 10:14:46
 */
@Data
@ApiModel(value = "日矿粉需求计划详情")
public class DayMineralPowderRequirementsPlanningDetailVO implements Serializable {
    private static final long serialVersionUID = -84226169660703485L;

    /**
    * id

    */
    @ApiModelProperty(value = "id ")
    private Integer id;

    /**
    * 日矿粉需求主表id 外键
    */
    @ApiModelProperty(value = "日矿粉需求主表id 外键")
    private Integer dayMineralPowderRequirementsPlanningId;

    /**
    * 产品id  外键
    */
    @ApiModelProperty(value = "产品id  外键")
    private Integer productId;

    /**
    * 矿粉编号
    */
    @ApiModelProperty(value = "矿粉编号")
    private String mineralPowderCode;

    /**
    * 矿粉名称
    */
    @ApiModelProperty(value = "矿粉名称")
    private String mineralPowderName;

    /**
    * 计划数量
    */
    @ApiModelProperty(value = "计划数量")
    private BigDecimal plannedQuantity;

    /**
    * 计量单位
    */
    @ApiModelProperty(value = "计量单位")
    private String unitOfMeasurement;

    /**
    * 备注
    */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
    * 状态：1 新增、下达 数据字典
    */
    @ApiModelProperty(value = "状态：1 新增、下达 数据字典")
    private String status;

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


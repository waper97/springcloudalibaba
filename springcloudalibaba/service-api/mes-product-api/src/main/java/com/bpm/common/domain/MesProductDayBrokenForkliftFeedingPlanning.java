package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 日破碎铲车投料计划(MesProductDayBrokenForkliftFeedingPlanning)实体类
 *
 * @author zhangzheming
 * @since 2022-04-29 14:00:56
 */
@Data
@ApiModel(value = "日破碎铲车投料计划实体类")
public class MesProductDayBrokenForkliftFeedingPlanning implements Serializable {
    private static final long serialVersionUID = 817007219005565709L;
    /**
     * 主键 自增长
     */
    @ApiModelProperty(value = "主键 自增长")
    private Integer id;
    /**
     * 计划号
     */
    @ApiModelProperty(value = "计划号")
    private String planCode;
    /**
     * 计划日期
     */
    @ApiModelProperty(value = "计划日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planDate;
    /**
     * 碎石仓
     */
    @ApiModelProperty(value = "碎石仓")
    private Integer debrisStorehouse;
    /**
     * 执行顺序
     */
    @ApiModelProperty(value = "执行顺序")
    private Integer executionSequence;
    /**
     * 计划数量
     */
    @ApiModelProperty(value = "计划数量")
    private BigDecimal planQuantity;
    /**
     * 总计划数量
     */
    @ApiModelProperty(value = "总计划数量")
    private BigDecimal totalPlannedQuantity;
    /**
     * 投料单号
     */
    @ApiModelProperty(value = "投料单号")
    private String feedingNumber;
    /**
     * 破碎计划号
     */
    @ApiModelProperty(value = "破碎计划号")
    private String brokenPlanCode;
    /**
     * 工序 数据字典
     */
    @ApiModelProperty(value = "工序 数据字典")
    private Integer process;
    /**
     * 矿石id
     */
    @ApiModelProperty(value = "矿石id")
    private String mineralsCode;
    /**
     * 矿石名称
     */
    @ApiModelProperty(value = "矿石名称")
    private String mineralsName;
    /**
     * 状态 已关闭 新增
     */
    @ApiModelProperty(value = "状态 已关闭 新增")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
     * 修改时间 格式：yyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "修改时间 格式：yyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 是否删除 0否，1是
     */
    @ApiModelProperty(value = "是否删除 0否，1是")
    private Integer isDeleted;


    @ApiModelProperty(value = "矿石id")
    private Integer mineralsId;
}
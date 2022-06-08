package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 日矿石到货需求计划(MesProductDayMineralArrivalOfTheDemandPlanning)实体类
 *
 * @author zhangzheming
 * @since 2022-04-29 11:09:12
 */
@Data
@ApiModel(value = "日矿石到货需求计划实体类")
public class MesProductDayMineralArrivalOfTheDemandPlanning implements Serializable {
    private static final long serialVersionUID = -75400716402838560L;
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
     * 计划周期 数据字典planning_cycle
     */
    @ApiModelProperty(value = "计划周期 数据字典planning_cycle")
    private Integer planCycle;
    /**
     * 计划类型 数据字典plan_type
     */
    @ApiModelProperty(value = "计划类型 数据字典plan_type")
    private Integer planType;
    /**
     * 要货开始日期
     */
    @ApiModelProperty(value = "要货开始日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivalOfTheDemandBeginDate;
    /**
     * 要货结束日期
     */
    @ApiModelProperty(value = "要货结束日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivalOfTheDemandEndDate;
    /**
     * 到厂时间 格式：HH:mm:ss
     */
    @ApiModelProperty(value = "到厂时间 格式：HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date arrivalTime;
    /**
     * 收货地点  数据字典place_of_receipt
     */
    @ApiModelProperty(value = "收货地点 数据字典place_of_receipt")
    private Integer placeOfReceipt;
    /**
     * 物料id 外键
     */
    @ApiModelProperty(value = "物料id 外键")
    private Integer materialsId;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialsCode;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialsName;
    /**
     * 计划到货量
     */
    @ApiModelProperty(value = "计划到货量")
    private BigDecimal planArrivalQuantity;
    /**
     * 最大储存量
     */
    @ApiModelProperty(value = "最大储存量")
    private BigDecimal maximumStorage;
    /**
     * 用量
     */
    @ApiModelProperty(value = "用量")
    private BigDecimal dosage;
    /**
     * 要货数量
     */
    @ApiModelProperty(value = "要货数量")
    private BigDecimal arrivalOfTheDemandQuantity;
    /**
     * 行号
     */
    @ApiModelProperty(value = "行号")
    private Integer lineNumbers;
    /**
     * 品质项
     */
    @ApiModelProperty(value = "品质项")
    private String qualityItem;
    /**
     * 品质要求上限
     */
    @ApiModelProperty(value = "品质要求上限")
    private BigDecimal qualityRequirementsLimit;
    /**
     * 品质要求下限
     */
    @ApiModelProperty(value = "品质要求下限")
    private BigDecimal qualityRequirementsLower;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
     * 修改时间 格式：yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "修改时间 格式：yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除 0否 1是
     */
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Integer isDeleted;
    /**
     * 日主生产计划id
     */
    @ApiModelProperty(value = "日主生产计划id")
    private Integer dayMasterProductPlaningId;
}


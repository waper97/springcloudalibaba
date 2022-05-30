package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 预均化记录实体类
 *
 * @author zhangzheming
 * @since 2022-05-06 11:16:36
 */
@Data
@ApiModel(value = "预均化记录实体类")
public class MesProductPrehomogenizationRecord implements Serializable {
    private static final long serialVersionUID = -71842214820765118L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 计划编号 规则
     */
    @ApiModelProperty(value = "计划编号 规则")
    private String planCode;
    /**
     * 工序 数据字典
     */
    @ApiModelProperty(value = "工序 数据字典")
    private Integer process;
    /**
     * 半成品仓id 外键
     */
    @ApiModelProperty(value = "半成品仓id 外键")
    private Integer semiFinishedProductWarehouseId;
    /**
     * 产品id(物料/矿石) 外键 带出编号、名称、计量单位、批次
     */
    @ApiModelProperty(value = "产品id(物料/矿石) 外键 带出编号、名称、计量单位、批次")
    private Integer productionId;
    /**
     * 计划开始日期
     */
    @ApiModelProperty(value = "计划开始日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planBeginTime;
    /**
     * 计划结束日期
     */
    @ApiModelProperty(value = "计划结束日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planEndTime;
    /**
     * 实际开始时间(中控反馈时间)
     */
    @ApiModelProperty(value = "实际开始时间(中控反馈时间)")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date actualBeginTime;
    /**
     * 实际结束时间(中控反馈时间)
     */
    @ApiModelProperty(value = "实际结束时间(中控反馈时间)")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date actualEndTime;
    /**
     * 预处理单位
     */
    @ApiModelProperty(value = "预处理单位")
    private String pretreatmentUnit;
    /**
     * 入库仓库 外键id
     */
    @ApiModelProperty(value = "入库仓库 外键id")
    private Integer enteringArehouse;
    /**
     * 入库规则
     */
    @ApiModelProperty(value = "入库规则")
    private String enteringArehouseRule;
    /**
     * 物料id
     */
    @ApiModelProperty(value = "物料id")
    private Integer materialId;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialName;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    /**
     * 第一次配料重量
     */
    @ApiModelProperty(value = "第一次配料重量")
    private BigDecimal firstTimeBurdeningWeight;
    /**
     * 第二次配料重量
     */
    @ApiModelProperty(value = "第二次配料重量")
    private BigDecimal secondTimeBurdeningWeight;
    /**
     * 第三次配料重量
     */
    @ApiModelProperty(value = "第三次配料重量")
    private BigDecimal thirdTimeBurdeningWeight;
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
    private BigDecimal qualityRequirementsUpper;
    /**
     * 品质要求下限
     */
    @ApiModelProperty(value = "品质要求下限")
    private BigDecimal qualityRequirementsLower;
    /**
     * 目标值
     */
    @ApiModelProperty(value = "目标值")
    private BigDecimal targetValue;
    /**
     * 检测值
     */
    @ApiModelProperty(value = "检测值")
    private BigDecimal detectionValue;
    /**
     * 差异
     */
    @ApiModelProperty(value = "差异")
    private BigDecimal difference;
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
     * 创建时间 yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "创建时间 yyyy-MM-dd HH:mm:ss")
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
     * 修改时间 yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "修改时间 yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 是否删除 0否 1是
     */
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Integer isDeleted;
    /**
     * 批次
     */
    @ApiModelProperty(value = "批次")
    private Integer batch;
}
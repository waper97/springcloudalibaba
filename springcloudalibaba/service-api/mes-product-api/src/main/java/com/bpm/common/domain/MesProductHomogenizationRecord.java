package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 均化记录表实体类
 *
 * @author zhangzheming
 * @since 2022-05-05 17:14:58
 */
@Data
@ApiModel(value = "均化记录实体类")
public class MesProductHomogenizationRecord implements Serializable {
    private static final long serialVersionUID = -65315884105843112L;
    /**
     * 主键id 自增长
     */
    @ApiModelProperty(value = "主键id 自增长")
    private Integer id;
    /**
     * 计划编号/记录编号 规则
     */
    @ApiModelProperty(value = "计划编号/记录编号 规则")
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
     * 成品仓id 外键
     */
    @ApiModelProperty(value = "成品仓id 外键")
    private Integer finishedProductWarehouseId;
    /**
     * 产品id(物料/矿石) 外键 带出编号、名称、计量单位、批次
     */
    @ApiModelProperty(value = "产品id(物料/矿石) 外键 带出编号、名称、计量单位、批次")
    private Integer productId;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;
    /**
     * 目标重量
     */
    @ApiModelProperty(value = "目标重量")
    private BigDecimal targetWeight;
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
     * 实际开始时间
     */
    @ApiModelProperty(value = "实际开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date actualBeginTime;
    /**
     * 实际结束时间
     */
    @ApiModelProperty(value = "实际结束时间")
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
    private String enteringArehouse;
    /**
     * 入库规则
     */
    @ApiModelProperty(value = "入库规则")
    private String enteringArehouseRule;
    /**
     * 料位
     */
    @ApiModelProperty(value = "料位")
    private String materialLevel;
    /**
     * 均化时间 yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "均化时间 yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date homogenizationDate;
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
     * 修改时间 格式：yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "修改时间 格式：yyyy-MM-dd HH:mm:ss")
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


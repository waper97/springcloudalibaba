package com.bpm.common.entity;

import com.bpm.common.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 日生产计划详情(DayPlanningDetail)实体类
 *
 * @author wangpeng
 * @since 2022-05-06 10:00:54
 */
@Data
@ApiModel(value = "日生产计划详情")
public class DayPlanningDetail extends PageDTO implements Serializable {
    private static final long serialVersionUID = -26512209271609817L;

    /**
    * id
    */
    @ApiModelProperty(value = "id")
    private Integer id;


    /**
    * 生产品种 数据字典
    */
    @ApiModelProperty(value = "生产品种 数据字典")
    private BigDecimal productionVariety;


    /**
    * 碎石仓id 外键
    */
    @ApiModelProperty(value = "碎石仓id 外键")
    private Integer brokenStoneWarehouseId;


    /**
    * 产品id（物料/矿石）外键 带出编号、名称、计量单位、来源 
    */
    @ApiModelProperty(value = "产品id（物料/矿石）外键 带出编号、名称、计量单位、来源 ")
    private Integer productionId;


    /**
    * 产品名称 物料/矿粉
    */
    @ApiModelProperty(value = "产品名称 物料/矿粉")
    private String productName;


    /**
    * 执行顺序
    */
    @ApiModelProperty(value = "执行顺序")
    private Integer executionSequence;


    /**
    * 物料编号
    */
    @ApiModelProperty(value = "物料编号")
    private String materialCode;


    /**
    * 物料名称
    */
    @ApiModelProperty(value = "物料名称")
    private String materialName;


    /**
    * 成品仓id 外键
    */
    @ApiModelProperty(value = "成品仓id 外键")
    private Integer finishedProductWarehouseId;


    /**
    * 立磨机号
    */
    @ApiModelProperty(value = "立磨机号")
    private String verticalMillMachineNumber;


    /**
    * 计划数量
    */
    @ApiModelProperty(value = "计划数量")
    private String plannedQuantity;


    /**
    * 生产线  外键 关联生产线id
    */
    @ApiModelProperty(value = "生产线  外键 关联生产线id")
    private Integer productLineId;


    /**
    * 第一次配料重量
    */
    @ApiModelProperty(value = "第一次配料重量")
    private BigDecimal firstTimeBurdeningWeight;


    /**
    * 第二次配料重量
    */
    @ApiModelProperty(value = "第二次配料重量")
    private BigDecimal secendTimeBurdeningWeight;


    /**
    * 第三次配料重量
    */
    @ApiModelProperty(value = "第三次配料重量")
    private BigDecimal thirdTimeBurdeningWeight;


    /**
    * 发出仓库id
    */
    @ApiModelProperty(value = "发出仓库id")
    private Integer sendOutWarehouseId;


    /**
    * 发出仓库名称
    */
    @ApiModelProperty(value = "发出仓库名称")
    private Integer sendOutWarehouseName;


    /**
    * 接收仓id
    */
    @ApiModelProperty(value = "接收仓id")
    private Integer receivingWarehouseId;


    /**
    * 接收仓名称
    */
    @ApiModelProperty(value = "接收仓名称")
    private String receivingWarehouseName;


    /**
    * 发送数量
    */
    @ApiModelProperty(value = "发送数量")
    private BigDecimal quantityForwarded;


    /**
    * 成品批次
    */
    @ApiModelProperty(value = "成品批次")
    private String finishedProductBatches;


    /**
    * 发放开始时间 yyyy-mm-dd hh:mm:ss
    */
    @ApiModelProperty(value = "发放开始时间 yyyy-mm-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime issuedBeginTime;


    /**
    * 发放结束时间 yyyy-mm-dd hh:mm:ss
    */
    @ApiModelProperty(value = "发放结束时间 yyyy-mm-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime issuedEndTime;


    /**
    * 入库仓库id   外键
    */
    @ApiModelProperty(value = "入库仓库id   外键")
    private Integer bePutInStorageWarehouseId;


    /**
    * 入库规则
    */
    @ApiModelProperty(value = "入库规则")
    private String bePutInStorageWarehouseName;


    /**
    * 接收产线id
    */
    @ApiModelProperty(value = "接收产线id")
    private String receivingProductionLine;


    /**
    * 接收产线名称
    */
    @ApiModelProperty(value = "接收产线名称")
    private String receivingProductionLineName;


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


    /**
    * 日生产计划id
    */
    @ApiModelProperty(value = "日生产计划id")
    private Integer dayPlanningId;


    /**
    * 半成品仓id 外键
    */
    @ApiModelProperty(value = "半成品仓id 外键")
    private Integer semiFinishedProductWarehouseId;


    /**
    * 磨前仓id 外键
    */
    @ApiModelProperty(value = "磨前仓(立磨仓)id 外键")
    private String preGrindingBinId;



}


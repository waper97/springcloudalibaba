package com.bpm.common.dto;

// 设置后缀名称


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 矿粉需求计划详情(MineralPowderRequirementsPlanningDetail)传输类
 *
 * @author wangpeng
 * @since 2022-04-24 10:26:31
 */
@Data
@ApiModel(value = "矿粉需求计划详情")
public class MineralPowderRequirementsPlanningDetailDTO extends PageDTO implements Serializable {
    private static final long serialVersionUID = -36653149858533390L;

    /**
    * id
    */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
    * 季度计划主表id
    */
    @ApiModelProperty(value = "季度计划主表id")
    private Integer mesProductMineralPowderRequirementsPlanningId;

    /**
    * 计划数量
    */
    @ApiModelProperty(value = "计划数量")
    private BigDecimal planQuantity;

    /**
    * 月份
    */
    @ApiModelProperty(value = "月份")
    private Integer month;

    /**
    * 计划开始时间
    */
    @ApiModelProperty(value = "计划开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planDateBegin;

    /**
    * 计划结束时间
    */
    @ApiModelProperty(value = "计划结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planDateEnd;

    /**
    * 运算日期
    */
    @ApiModelProperty(value = "运算日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operationDate;

    /**
    * bom清单主表id（外键）
    */
    @ApiModelProperty(value = "bom清单主表id（外键）")
    private Integer billOfMaterialId;

    /**
    * 投放单据类型：0采购计划，1生产工单
    物料基础信息带入
    */
    @ApiModelProperty(value = "投放单据类型：0采购计划，1生产工单 物料基础信息带入")
    private Integer workType;

    /**
    * 计量单位id
    */
    @ApiModelProperty(value = "计量单位id")
    private Integer unitId;

    /**
    * 计量单位名称
    */
    @ApiModelProperty(value = "计量单位名称")
    private String unitName;

    /**
    * 供应商id(外键)
    */
    @ApiModelProperty(value = "供应商id(外键)")
    private Integer supplierId;

    /**
    * 供应商全称
    */
    @ApiModelProperty(value = "供应商全称")
    private String supplierFullName;

    /**
    * 物料id（外键）
    */
    @ApiModelProperty(value = "物料id（外键）")
    private Integer materialId;

    /**
    * 物料编码
    */
    @ApiModelProperty(value = "物料编码 ")
    private String materialCode;

    /**
    * 物料简称
    */
    @ApiModelProperty(value = "物料简称  ")
    private String materialShortName;

    /**
    * 物料规格
    */
    @ApiModelProperty(value = "物料规格 ")
    private String materialSpecification;

    /**
    * 产品id（外键）
    */
    @ApiModelProperty(value = "产品id（外键）")
    private Integer productId;

    /**
    * 产品编码
    */
    @ApiModelProperty(value = "产品编码 ")
    private String productCode;

    /**
    * 产品简称
    */
    @ApiModelProperty(value = "产品简称   ")
    private String productShortName;

    /**
    * 产品规格
    */
    @ApiModelProperty(value = "产品规格 ")
    private String productSpecification;

    /**
    * 客户件号
    */
    @ApiModelProperty(value = "客户件号")
    private String customerCode;

    /**
    * 订单数量/预测数量
    */
    @ApiModelProperty(value = "订单数量/预测数量")
    private BigDecimal forecastOrderQuantity;

    /**
    * 毛需求数量
    */
    @ApiModelProperty(value = "毛需求数量")
    private BigDecimal requireQuantity;

    /**
    * 计划接受量
    */
    @ApiModelProperty(value = "计划接受量")
    private BigDecimal planAccetpQuantity;

    /**
    * 初值（累计可用库存）
    */
    @ApiModelProperty(value = "初值（累计可用库存）")
    private BigDecimal projectedAvailableBalanceInitValue;

    /**
    * 净需求量
    */
    @ApiModelProperty(value = "净需求量")
    private BigDecimal netRequireQuantity;

    /**
    * 计划产出量
    */
    @ApiModelProperty(value = "计划产出量")
    private BigDecimal planOutputQuantity;

    /**
    * 预计可用库存
    */
    @ApiModelProperty(value = "预计可用库存")
    private BigDecimal projectedAvailableBalance;

    /**
    * 计划投入量
    */
    @ApiModelProperty(value = "计划投入量")
    private BigDecimal planInputQuantity;

    /**
    * 可供销售量
    */
    @ApiModelProperty(value = "可供销售量")
    private BigDecimal availableToPromise;

    /**
    * 建议采购/开工日期
    */
    @ApiModelProperty(value = "建议采购/开工日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planBeginDate;

    /**
    * 建议到货/完工日期
    */
    @ApiModelProperty(value = "建议到货/完工日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planEndDate;

    /**
    * 需要日期
    */
    @ApiModelProperty(value = "需要日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date needDate;

    /**
    * 销售订单id（外键）
    （mps原单）

    */
    @ApiModelProperty(value = "销售订单id（外键）（mps原单） ")
    private Integer saleorderId;

    /**
    * 销售订单编号
    */
    @ApiModelProperty(value = "销售订单编号")
    private String saleorderCode;

    /**
    * 销售计划id（外键）（mps原单）
    */
    @ApiModelProperty(value = "销售计划id（外键）（mps原单）")
    private Integer saleMonthPlanId;

    /**
    * 销售计划编号
    */
    @ApiModelProperty(value = "销售计划编号")
    private String saleMonthPlanCode;

    /**
    * 计划订单id
    */
    @ApiModelProperty(value = "计划订单id")
    private Integer planOrderId;

    /**
    * 计划订单号
    */
    @ApiModelProperty(value = "计划订单号")
    private String planOrderCode;

    /**
    * 生产订单id（主键）
    主生产计划、物料需求计划生成采购申请单和生产订单时回写

    */
    @ApiModelProperty(value = "生产订单id（主键） 主生产计划、物料需求计划生成采购申请单和生产订单时回写 ")
    private Integer manuOrderId;

    /**
    * 生产订单号
    */
    @ApiModelProperty(value = "生产订单号")
    private String manuOrderNo;

    /**
    * 执行部门id（外键）
    采购申请或生产部门

    */
    @ApiModelProperty(value = "执行部门id（外键） 采购申请或生产部门 ")
    private Integer departmentId;

    /**
    * 业务关闭状态：1是、0否 数据字典
    */
    @ApiModelProperty(value = "业务关闭状态：1是、0否 数据字典")
    private String businessCloseStatus;

    /**
    * 数据类型：1 mps、2mrp、3手工 数据字典
    */
    @ApiModelProperty(value = "数据类型：1 mps、2mrp、3手工 数据字典")
    private String type;

    /**
    * 状态：1 新增、下达 数据字典
    */
    @ApiModelProperty(value = "状态：1 新增、下达 数据字典")
    private String status;

    /**
    * 下达人id（登陆）
    */
    @ApiModelProperty(value = "下达人id（登陆）")
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
    private Date issueTime;

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


    private String isReceived;
    }


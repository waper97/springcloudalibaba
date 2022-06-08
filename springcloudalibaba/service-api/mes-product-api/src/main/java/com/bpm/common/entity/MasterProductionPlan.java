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
 * 主生产计划(MasterProductionPlan)实体类
 *
 * @author wangpeng
 * @since 2022-04-24 16:45:51
 */
@Data
@ApiModel(value = "主生产计划")
public class MasterProductionPlan extends PageDTO implements Serializable {
    private static final long serialVersionUID = 726747370598700821L;

    /**
    * id
    */
    @ApiModelProperty(value = "id")
    private Integer id;


    /**
    * 矿粉需求计划主表id 外键
    */
    @ApiModelProperty(value = "矿粉需求计划主表id 外键")
    private Integer mesProductMineralPowderRequirementsPlanningId;


    /**
    * mrp运算， 外键   计划方案表id
    */
    @ApiModelProperty(value = "mrp运算， 外键   计划方案表id")
    private Integer mesPlanSchemeId;


    /**
    * 运算日期
    */
    @ApiModelProperty(value = "运算日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operationDate;


    /**
    * 运算日期
    */
    @ApiModelProperty(value = "运算日期")
    private String operationCode;


    /**
    * 投放单据类型 数据字典？
    */
    @ApiModelProperty(value = "投放单据类型 数据字典？")
    private String documentType;


    /**
    * 产品id(矿粉、矿石) 带出数据
    */
    @ApiModelProperty(value = "产品id(矿粉、矿石) 带出数据")
    private Integer productId;


    /**
    * 计划投入量
    */
    @ApiModelProperty(value = "计划投入量")
    private BigDecimal planIntoQuantity;


    /**
    * 净需求量
    */
    @ApiModelProperty(value = "净需求量")
    private BigDecimal netDemand;


    /**
    * 毛需求量
    */
    @ApiModelProperty(value = "毛需求量")
    private BigDecimal quantityGross;


    /**
    * 仓库id  外键获取库存量
    */
    @ApiModelProperty(value = "仓库id  外键获取库存量")
    private Integer warehouseId;


    /**
    * 接收量
    */
    @ApiModelProperty(value = "接收量")
    private BigDecimal quantitiesReceived;


    /**
    * 生产车间 外键 生产线id
    */
    @ApiModelProperty(value = "生产车间 外键 生产线id")
    private Integer productionWorkshopId;


    /**
    * 开工时间 yyyy-mm-dd
    */
    @ApiModelProperty(value = "开工时间 yyyy-mm-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startWorkingDate;


    /**
    * 完工时间 yyyy-mm-dd
    */
    @ApiModelProperty(value = "完工时间 yyyy-mm-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completeWorkingDate;


    /**
    * 状态 下发、审核、新增 
数据字典
    */
    @ApiModelProperty(value = "状态 下发、审核、新增 数据字典")
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
    * 计划属性 数据字典
    */
    @ApiModelProperty(value = "计划属性 数据字典")
    private Integer planProperties;


    /**
     * 计划编号
     */
    @ApiModelProperty(value = "计划编号")
    private String planCode;
}


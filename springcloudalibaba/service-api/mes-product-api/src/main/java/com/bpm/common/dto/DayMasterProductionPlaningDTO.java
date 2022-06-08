package com.bpm.common.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 日主生产计划(DayMasterProductionPlaning)传输类
 *
 * @author wangpeng
 * @since 2022-04-26 16:14:18
 */
@Data
@ApiModel(value = "日主生产计划")
public class DayMasterProductionPlaningDTO extends PageDTO implements Serializable {
    private static final long serialVersionUID = -76753373440850719L;
    
    /**
    *  
    */    
    @ApiModelProperty(value = " ")
    private Integer id;

    /**
     * 日需求计划主表id   外键
     */
    @ApiModelProperty(value = "日需求计划主表id   外键")
    private Integer dayMineralPowderRequirementsPlanningId;

    /**
     * 日主生产计划编号
     */
    @ApiModelProperty(value = "日主生产计划编号")
    private String code;

    /**
    * mrp运算表id,外键,计划方案表id
    */    
    @ApiModelProperty(value = "mrp运算表id,外键,计划方案表id")
    private Integer mesPlanSchemeId;

    /**
    * 运算日期
    */    
    @ApiModelProperty(value = "运算日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operationDate;

    /**
    * 运算编号 格式
    */    
    @ApiModelProperty(value = "运算编号 格式")
    private String operationCode;

    /**
    * 投放单据类型 数据字典？生产..
    */    
    @ApiModelProperty(value = "投放单据类型 数据字典？生产..")
    private String documentType;

    /**
    * 产品id(矿粉、矿石) 外键 带出数据
    */    
    @ApiModelProperty(value = "产品id(矿粉、矿石) 外键 带出数据")
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
    * 库存量
    */    
    @ApiModelProperty(value = "库存量")
    private BigDecimal stocks;

    /**
    * 接收量
    */    
    @ApiModelProperty(value = "接收量")
    private BigDecimal quantitiesReceived;

    /**
    * 生产车间
    */    
    @ApiModelProperty(value = "生产车间")
    private Integer productionWorkshop;

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
    * 备注
    */    
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
    * 状态 下发、审核、新增
    */    
    @ApiModelProperty(value = "状态 下发、审核、新增 数据字典： dayMaster_Production_Planing_status")
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

    /**
     * 需求日期 格式：yyyy-MM-dd hh:mm:ss
     */
    @ApiModelProperty(value = "需求日期 格式：yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime demandDate;

    /**
     * 开始时间 格式：yyyy-MM-dd hh:mm:ss
     */
    @ApiModelProperty(value = "需求日期 格式：yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    /**
     * 结束时间 格式：yyyy-MM-dd hh:mm:ss
     */
    @ApiModelProperty(value = "需求日期 格式：yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;


    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialName;

    /**
     * 物料编号
     */
    @ApiModelProperty(value = "物料编号")
    private String materialCode;

}


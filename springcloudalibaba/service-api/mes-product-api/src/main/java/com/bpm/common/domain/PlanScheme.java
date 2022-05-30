package com.bpm.common.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 *  计划方案(PlanScheme)实体类
 *
 * @author wangpeng
 * @since 2022-05-18 15:26:26
 */
@Data
@ApiModel(value = " 计划方案")
public class PlanScheme implements Serializable {
    private static final long serialVersionUID = 362234191422254278L;

    /**
    * 主键 自增长
    */    
    @ApiModelProperty(value = "主键 自增长")
    private Integer id;

    /**
    * 方案名称
    */    
    @ApiModelProperty(value = "方案名称")
    private String schemeName;

    /**
    * 方案类型    1mps、2mrp
    */    
    @ApiModelProperty(value = "方案类型    1mps、2mrp")
    private String schemeType;

    /**
    * 运算周期   数据字典？季度，日
    */    
    @ApiModelProperty(value = "运算周期   数据字典？季度，日")
    private String executionCycle;

    /**
    * 计划计算范围：全部计划对象
    */    
    @ApiModelProperty(value = "计划计算范围：全部计划对象")
    private String calculationRange;

    /**
    * 需求来源：1销售订单、2销售订单+销售计划、3销售计划   数据字典
    */    
    @ApiModelProperty(value = "需求来源：1销售订单、2销售订单+销售计划、3销售计划   数据字典")
    private String sourceOfDemand;

    /**
    * 是否考虑损耗  （0否，1是）
    */    
    @ApiModelProperty(value = "是否考虑损耗  （0否，1是）")
    private Integer isConsiderLoss;

    /**
    * 是否考虑现有库存 （0否，1是）
    */    
    @ApiModelProperty(value = "是否考虑现有库存 （0否，1是）")
    private Integer isConsiderNowInventory;

    /**
    * 是否考虑安全库存（0否，1是）
    */    
    @ApiModelProperty(value = "是否考虑安全库存（0否，1是）")
    private Integer isConsiderSafeInventory;

    /**
    * 是否过滤掉为0的物料 （0否，1是）
    */    
    @ApiModelProperty(value = "是否过滤掉为0的物料 （0否，1是）")
    private Integer isFilterZeroMaterials;

    /**
    * 考虑损耗率（%），默认0
    */    
    @ApiModelProperty(value = "考虑损耗率（%），默认0")
    private Integer isRatioscrap;

    /**
    * 考虑成品率（%），默认100
    */    
    @ApiModelProperty(value = "考虑成品率（%），默认100")
    private Integer isYield;

    /**
    * 考虑最小库存（1是；0否）
    */    
    @ApiModelProperty(value = "考虑最小库存（1是；0否）")
    private Integer isMinstock;

    /**
    * 考虑预计入库数量和已分配数量（1是；0否）
    */    
    @ApiModelProperty(value = "考虑预计入库数量和已分配数量（1是；0否）")
    private Integer isEstimatPutInQuantityAndAlreadyAllotQuantity;

    /**
    * 净需求考虑订货策略和批量调整
（1是；0否）

    */    
    @ApiModelProperty(value = "净需求考虑订货策略和批量调整（1是；0否） ")
    private Integer isPolicyBat;

    /**
    * 物料汇总类型：外购、自制、全部 外键
    */    
    @ApiModelProperty(value = "物料汇总类型：外购、自制、全部 外键")
    private String materialSummaryType;

    /**
    * 物料汇总方式：1 物料、2物料+时间
    */    
    @ApiModelProperty(value = "物料汇总方式：1 物料、2物料+时间")
    private Integer materialSummaryWay;

    /**
    * 预计量有效提前期：默认90天，小于9999
    */    
    @ApiModelProperty(value = "预计量有效提前期：默认90天，小于9999")
    private String orderValidtime;

    /**
    * 计划属性： 采购
    */    
    @ApiModelProperty(value = "计划属性： 采购")
    private String planProperty;

    /**
    * 已关闭、新增
    */    
    @ApiModelProperty(value = "已关闭、新增")
    private Integer status;

    /**
    * 创建人
    */    
    @ApiModelProperty(value = "创建人")
    private Integer createId;

    /**
    * 创建人名称
    */    
    @ApiModelProperty(value = "创建人名称")
    private String createName;

    /**
    * 修改人id
    */    
    @ApiModelProperty(value = "修改人id")
    private Integer updateId;

    /**
    * 修改名称
    */    
    @ApiModelProperty(value = "修改名称")
    private String updateName;

    /**
    * 修改时间
    */    
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
    * 是否删除
    */    
    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;

    /**
    * 方案描述
    */    
    @ApiModelProperty(value = "方案描述")
    private String schemeDescription;

    /**
    * 计算公式
    */    
    @ApiModelProperty(value = "计算公式")
    private String computationalFormula;

    /**
    * 创建人时间
    */    
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "备注")
    private String remark;


}


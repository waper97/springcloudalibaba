package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 日物料需求计划详情(DayMaterialRequirementsPlanningDetail)实体类
 *
 * @author wangpeng
 * @since 2022-05-27 16:40:18
 */
@Data
@ApiModel(value = "日物料需求计划详情")
public class DayMaterialRequirementsPlanningDetail implements Serializable {
    private static final long serialVersionUID = -23664758811129769L;

    /**
    * id
    */    
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
    * 日物料需求计划id
    */    
    @ApiModelProperty(value = "日物料需求计划id")
    private Integer dayMaterialRequirementsPlanning;

    /**
    * 产品id 外键 查询带出名称、编号
    */    
    @ApiModelProperty(value = "产品id 外键 查询带出名称、编号")
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
    * 库存量
    */    
    @ApiModelProperty(value = "库存量")
    private BigDecimal inventory;

    /**
    * 接收量
    */    
    @ApiModelProperty(value = "接收量")
    private BigDecimal quantitiesReceived;

    /**
    * 生产车间
    */    
    @ApiModelProperty(value = "生产车间")
    private String productionWorkshop;

    /**
    * 采购/开工时间 yyyy-MM-dd hh:mm:ss
    */    
    @ApiModelProperty(value = "采购/开工时间 yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startWorkingDate;

    /**
    * 采购/完工时间yyyy-MM-dd hh:mm:ss
    */    
    @ApiModelProperty(value = "采购/完工时间yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completeWorkingDate;

    /**
    * 需要日期 yyyy-MM-dd hh:mm:ss
    */    
    @ApiModelProperty(value = "需要日期 yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime needDate;

    /**
    * 备注
    */    
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
    * 状态 下发、审核、新增
    */    
    @ApiModelProperty(value = "状态 下发、审核、新增")
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


}


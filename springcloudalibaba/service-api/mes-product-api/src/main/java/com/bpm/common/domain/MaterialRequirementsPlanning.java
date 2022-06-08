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
 * 物料需求计划(MaterialRequirementsPlanning)实体类
 *
 * @author wangpeng
 * @since 2022-05-12 11:32:28
 */
@Data
@ApiModel(value = "物料需求计划")
public class MaterialRequirementsPlanning implements Serializable {
    private static final long serialVersionUID = 575055699679775566L;

    /**
    * id 
    */    
    @ApiModelProperty(value = "id ")
    private Integer id;

    /**
    * 计划运算类型：1 mps、2 mrp
    */    
    @ApiModelProperty(value = "计划运算类型：1 mps、2 mrp")
    private String planningOperation;

    /**
    * 运算编号
    */    
    @ApiModelProperty(value = "运算编号")
    private String operationCode;

    /**
    * 运算日期  数据字典
    */    
    @ApiModelProperty(value = "运算日期  数据字典")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operationDate;

    /**
    * 展望期开始日期
    */    
    @ApiModelProperty(value = "展望期开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime needBeginDate;

    /**
    * 展望期结束日期
    */    
    @ApiModelProperty(value = "展望期结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime needEndDate;

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
    * 创建人id
    */    
    @ApiModelProperty(value = "创建人id")
    private Integer updateId;

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
    * 预计量计算有效开始日期
    */    
    @ApiModelProperty(value = "预计量计算有效开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planningOperationEffective;

    /**
    * 运算方案id
    */    
    @ApiModelProperty(value = "运算方案id")
    private String planSchemeId;

    /**
    * 审核人id
    */    
    @ApiModelProperty(value = "审核人id")
    private String checkerId;

    /**
    * 审核人名称
    */    
    @ApiModelProperty(value = "审核人名称")
    private String checkName;

    /**
    * 审核时间
    */    
    @ApiModelProperty(value = "审核时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkTime;

    /**
    * 是否删除 0否，1是
    */    
    @ApiModelProperty(value = "是否删除 0否，1是")
    private Integer isDeleted;

    /**
    * 下达人id
    */    
    @ApiModelProperty(value = "下达人id")
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
    private LocalDateTime issueTime;

    /**
    * 主生产计划id 外键
    */    
    @ApiModelProperty(value = "主生产计划id 外键")
    private Integer masterProductionPlanId;

    /**
    * 状态： 0已下发、、1新增，2已审核
    */    
    @ApiModelProperty(value = "状态： 0已下发、、1新增，2已审核")
    private Integer status;

    /**
    * 计划编号
    */    
    @ApiModelProperty(value = "计划编号")
    private String planCode;

    /**
    * 投放单据类型 数据字典？ release_document_type
    */    
    @ApiModelProperty(value = "投放单据类型 数据字典？ release_document_type")
    private String documentType;

    /**
    * 产品id(矿粉、矿石) 带出数据
    */    
    @ApiModelProperty(value = "产品id(矿粉、矿石) 带出数据")
    private Integer productId;

    /**
    * 生产车间 外键 (关联部门)
    */    
    @ApiModelProperty(value = "生产车间 外键 (关联部门)")
    private Integer productionWorkshopId;

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
    * 需求日期 格式：yyyy-MM-dd hh:mm:ss  (2022年5月9日16:01:53)
    */    
    @ApiModelProperty(value = "需求日期 格式：yyyy-MM-dd hh:mm:ss  (2022年5月9日16:01:53)")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime demandDate;

    /**
    * 库存量(2022年5月11日18:02:01)
    */    
    @ApiModelProperty(value = "库存量(2022年5月11日18:02:01)")
    private BigDecimal stockQuantity;

    /**
    * 接收量
    */    
    @ApiModelProperty(value = "接收量")
    private BigDecimal quantitiesReceived;

    /**
    * 采购/开工时间 yyyy-mm-dd
    */    
    @ApiModelProperty(value = "采购/开工时间 yyyy-mm-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startWorkingDate;

    /**
    * 采购/完工时间 yyyy-mm-dd
    */    
    @ApiModelProperty(value = "采购/完工时间 yyyy-mm-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completeWorkingDate;


}


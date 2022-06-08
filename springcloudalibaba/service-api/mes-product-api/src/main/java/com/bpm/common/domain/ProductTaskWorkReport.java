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
 * 作业报工(ProductTaskWorkReport)实体类
 *
 * @author wangpeng
 * @since 2022-05-25 14:07:44
 */
@Data
@ApiModel(value = "作业报工")
public class ProductTaskWorkReport implements Serializable {
    private static final long serialVersionUID = 212137486527018310L;

    /**
    * 主键id
    */    
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
    * 作业报工
    */    
    @ApiModelProperty(value = "作业报工")
    private String taskCode;

    /**
    * 工作报工单据日期 年月日
    */    
    @ApiModelProperty(value = "工作报工单据日期 年月日")
    private String taskDate;

    /**
    * 过账日期
    */    
    @ApiModelProperty(value = "过账日期")
    private String postingDate;

    /**
    * 工作中心id
    */    
    @ApiModelProperty(value = "工作中心id")
    private Integer workEnterId;

    /**
    * bom主表id
    */    
    @ApiModelProperty(value = "bom主表id")
    private Integer bomId;

    /**
    * 仓库id
    */    
    @ApiModelProperty(value = "仓库id")
    private Integer stockId;

    /**
    * 物料id
    */    
    @ApiModelProperty(value = "物料id")
    private Integer materialId;

    /**
    * 数量
    */    
    @ApiModelProperty(value = "数量")
    private Integer qty;

    /**
    * 状态
    */    
    @ApiModelProperty(value = "状态")
    private String status;

    /**
    * 客户id
    */    
    @ApiModelProperty(value = "客户id")
    private Integer clientId;

    /**
    * 部门id
    */    
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;

    /**
    * 源单类型：1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表
    */    
    @ApiModelProperty(value = "源单类型：1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表")
    private Integer sourceType;

    /**
    * 源单号ID（月生产订单）
    */    
    @ApiModelProperty(value = "源单号ID（月生产订单）")
    private Integer sourceId;

    /**
    * 源单号（月生产订单）
    */    
    @ApiModelProperty(value = "源单号（月生产订单）")
    private String sourceCode;

    /**
    * 质检批次
    */    
    @ApiModelProperty(value = "质检批次")
    private String checkBatchNo;

    /**
    * 开始日期
    */    
    @ApiModelProperty(value = "开始日期")
    private String startDate;

    /**
    * 结束日期
    */    
    @ApiModelProperty(value = "结束日期")
    private String endDate;

    /**
    * 批次号
    */    
    @ApiModelProperty(value = "批次号")
    private String batchNo;

    /**
    * 入库报工id
    */    
    @ApiModelProperty(value = "入库报工id")
    private Integer inWorkReportId;

    /**
    * 入库报工编码
    */    
    @ApiModelProperty(value = "入库报工编码")
    private String inWorkReportCode;

    /**
    * 人工工时
    */    
    @ApiModelProperty(value = "人工工时")
    private BigDecimal laborHours;

    /**
    * 机器工时
    */    
    @ApiModelProperty(value = "机器工时")
    private BigDecimal machineHours;

    /**
    * 维修费
    */
    @ApiModelProperty(value = "维修费")
    private BigDecimal repairCost;

    /**
    * 公司ID
    */    
    @ApiModelProperty(value = "公司ID")
    private Integer companyId;

    /**
    * 公司编码
    */    
    @ApiModelProperty(value = "公司编码")
    private String companyCode;

    /**
    * 公司简称
    */    
    @ApiModelProperty(value = "公司简称")
    private String companyName;

    /**
    * 创建人ID
    */    
    @ApiModelProperty(value = "创建人ID")
    private Integer createId;

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
    * 修改人人ID
    */    
    @ApiModelProperty(value = "修改人人ID")
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
    * 备注
    */    
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
    * 0无效，1有效，默认1
    */    
    @ApiModelProperty(value = "0无效，1有效，默认1")
    private String isValid;

    /**
    * 回写SapId
    */
    @ApiModelProperty(value = "回写SapId")
    private Integer sapId;

    /**
    * 回写Sap编码
    */
    @ApiModelProperty(value = "回写Sap编码")
    private String sapCode;

}


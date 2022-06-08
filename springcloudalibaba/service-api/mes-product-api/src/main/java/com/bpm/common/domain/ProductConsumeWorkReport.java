package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 消耗报工(ProductConsumeWorkReport)实体类
 *
 * @author wangpeng
 * @since 2022-05-25 14:11:30
 */
@Data
@ApiModel(value = "消耗报工")
public class ProductConsumeWorkReport implements Serializable {
    private static final long serialVersionUID = -90715568034331926L;

    /**
    * 主键id
    */    
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
    * 报工单据编码
    */    
    @ApiModelProperty(value = "报工单据编码")
    private String workReportCode;

    /**
    * 报工单据日期 年月日
    */    
    @ApiModelProperty(value = "报工单据日期 年月日")
    private String workReportDate;

    /**
    * 工作中心id
    */    
    @ApiModelProperty(value = "工作中心id")
    private Integer workEnterId;

    /**
    * 入库报工id
    */
    @ApiModelProperty(value = "入库报工id")
    private Integer inWorkReportId;

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
    private BigDecimal qty;

    /**
    * 状态
    */    
    @ApiModelProperty(value = "状态")
    private String status;

    /**
    * 过账日期
    */    
    @ApiModelProperty(value = "过账日期")
    private String postingDate;

    /**
    * 源单类型：1生产订单
    */    
    @ApiModelProperty(value = "源单类型：1生产订单")
    private Integer sourceType;

    /**
    * 出库类型：1生产领料
    */
    @ApiModelProperty(value = "出库类型：1生产领料")
    private Integer stockType;

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
    * 出库开始日期
    */    
    @ApiModelProperty(value = "出库开始日期")
    private String outStartDate;

    /**
    * 出库结束日期
    */    
    @ApiModelProperty(value = "出库结束日期")
    private String outEndDate;

    /**
    * 部门id
    */    
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;

    /**
    * 出库单据号
    */    
    @ApiModelProperty(value = "出库单据号id")
    private String outId;

    /**
    * 批次号
    */    
    @ApiModelProperty(value = "批次号")
    private String batchNo;

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


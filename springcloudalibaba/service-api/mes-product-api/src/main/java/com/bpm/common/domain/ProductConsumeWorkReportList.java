package com.bpm.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 消耗报工明细表(ProductConsumeWorkReportList)实体类
 *
 * @author wangpeng
 * @since 2022-05-25 14:12:05
 */
@Data
@ApiModel(value = "消耗报工明细表")
public class ProductConsumeWorkReportList implements Serializable {
    private static final long serialVersionUID = -27597742312237501L;

    /**
    * 主键id
    */    
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
    * 消耗报工主表id
    */    
    @ApiModelProperty(value = "消耗报工主表id")
    private Integer consumeId;

    /**
    * 报工单据编码
    */    
    @ApiModelProperty(value = "报工单据编码")
    private String workReportCode;

    /**
    * 物料id
    */    
    @ApiModelProperty(value = "物料id")
    private Integer materialId;

    /**
    * 实际数量
    */    
    @ApiModelProperty(value = "实际数量")
    private BigDecimal actualQty;

    /**
    * bom数量
    */    
    @ApiModelProperty(value = "bom数量")
    private BigDecimal bomQty;

    /**
    * 入库批次
    */    
    @ApiModelProperty(value = "入库批次")
    private String inBatchNo;

    /**
    * 仓库出库批次表
    */    
    @ApiModelProperty(value = "仓库出库批次表")
    private Integer stockInOutBatchId;

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


}


package com.bpm.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 月生产订单(MonthlyProductionOrder)实体类
 *
 * @author wangpeng
 * @since 2022-05-17 17:44:15
 */
@Data
public class MonthlyProductionOrderTwoDto {
    /**
    * id
    */    
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
    * 单据编号
    */    
    @ApiModelProperty(value = "单据编号")
    private String documentCode;

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
     * 物料id
     */
    @ApiModelProperty(value = "物料id")
    private Integer materialId;

    /**
    * 集团号
    */    
    @ApiModelProperty(value = "集团号")
    private String groupNumber;

    /**
    * 单据日 格式年月 
    */    
//    @ApiModelProperty(value = "单据日 格式年月 ")
//    private String documentDate;

    /**
    * 备注
    */    
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 前登录人ID
     */
    @ApiModelProperty(value = "前登录人ID")
    private Integer currentloginId;

    /**
     * 当前登录人名称
     */
    @ApiModelProperty(value = "当前登录人名称")
    private String currentloginName;
}


package com.bpm.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 月生产订单(MonthlyProductionOrder)实体类
 *
 * @author wangpeng
 * @since 2022-05-17 17:44:15
 */
@Data
public class BomMaterialVo {

    /**
    * bom主表id
    */    
    @ApiModelProperty(value = "bom主表id")
    private Integer bomId;

    /**
     * bom主表编码
     */
    @ApiModelProperty(value = "bom主表编码")
    private String bomCode;

    /**
    * bom版本
    */    
    @ApiModelProperty(value = "bom版本")
    private String bomVersion;

    /**
    * 物料id
    */    
    @ApiModelProperty(value = "物料id")
    private Integer materialId;

    /**
    * 物料编号
    */    
    @ApiModelProperty(value = "物料编号")
    private String materialCode;

    /**
    * 物料名称
    */    
    @ApiModelProperty(value = "物料名称")
    private String materialName;

}


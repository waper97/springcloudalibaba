package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 仓库出入库规则(MesWmsStockrule)实体类
 *
 * @author makejava
 * @since 2022-04-15 17:46:48
 */
@Data
public class MesWmsStockruleDto {

    private Integer id;
    /**
     * 规则编码
     */
    @ApiModelProperty(value = "规则编码")
    private String ruleCode;
    /**
     * 规则名称
     */
    @ApiModelProperty(value = "规则名称")
    private String ruleName;
    /**
     * 规则属性 1入库、2出库
     */
    @ApiModelProperty(value = "规则属性 1入库、2出库")
    private String inOutPropert;
    /**
     * 规则结论
     */
    @ApiModelProperty(value = "规则结论")
    private String ruleConclusion;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
//    /**
//     * 0无效，1有效，默认1
//     */
//    @ApiModelProperty(value = "0无效，1有效，默认1")
//    private String isValid;
    /**
     * 规则值
     */
    @ApiModelProperty(value = "规则值")
    private String ruleValue;

    /**
     * 创建人ID
     */
    @ApiModelProperty(value = "创建人ID")
    private Integer currentloginId;
    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称")
    private String currentloginName;

}


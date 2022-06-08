package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(description = "指间任务-发起报检-新增对象")
public class StockTasksMainAddDto {

    /**
     * 主表ID
     */
    @ApiModelProperty(value = "主表ID")
    private Integer id;
    /**
     * 质检场景编码
     */
    @ApiModelProperty(value = "质检场景编码")
    private String occasionsCode;
//    /**
//     * 质检单据编码
//     */
//    @ApiModelProperty(value = "质检单据编码")
//    private String qualityBillCode;
    /**
     * 计划质检日期
     */
    @ApiModelProperty(value = "计划质检日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date qualityTimePlan;
//    /**
//     * 检验原单号
//     */
//    @ApiModelProperty(value = "检验原单号")
//    private String checkTheOriginalOrderNumber;
    /**
     * 检验原类型
     */
    @ApiModelProperty(value = "检验原类型")
    private String checkTheOriginalType;
//    /**
//     * 检验源ID
//     */
//    @ApiModelProperty(value = "检验源ID")
//    private Integer checkTheOriginalId;
    /**
     * 样品物料编码
     */
    @ApiModelProperty(value = "样品物料编码")
    private String sampleMaterialsCode;
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

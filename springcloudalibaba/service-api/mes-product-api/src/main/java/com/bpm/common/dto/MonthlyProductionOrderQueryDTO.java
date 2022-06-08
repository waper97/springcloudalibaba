package com.bpm.common.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 月生产订单(MonthlyProductionOrder)传输类
 *
 * @author wangpeng
 * @since 2022-05-17 17:44:16
 */
@Data
public class MonthlyProductionOrderQueryDTO extends PageDTO {
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
     * 集团号
     */
    @ApiModelProperty(value = "集团号")
    private String groupNumber;

    /**
     * 单据日 格式年月
     */
    @ApiModelProperty(value = "单据日 格式年月 ")
    private String documentDate;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 是否删除:1是，0否
     */
    @ApiModelProperty(value = "是否删除:1是，0否")
    private Integer isDeleted;

    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialName;

    /**
     * 状态
     */
    @ApiModelProperty(value = "开始时间")
    private String startTime;

    /**
     * 状态
     */
    @ApiModelProperty(value = "结束时间")
    private String endTime;

}


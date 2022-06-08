package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.MonthlyProductionOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 月生产订单(MonthlyProductionOrder)实体类
 *
 * @author wangpeng
 * @since 2022-05-17 17:44:16
 */
@Data
@ApiModel(value = "月生产订单")
public class MonthlyProductionOrderVO extends MonthlyProductionOrder implements Serializable {
    private static final long serialVersionUID = 286384063702689906L;

    /**
     * bom主表编码
     */
    @ApiModelProperty(value = "bom主表编码")
    private String bomCode;
    /**
     * 状态名称
     */
    @ApiModelProperty(value = "状态名称")
    private String statusName;
    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
    private String unitsName;
    /**
     * 单位
     */
    @ApiModelProperty(value = "工作中心名称")
    private String workEnterName;

}


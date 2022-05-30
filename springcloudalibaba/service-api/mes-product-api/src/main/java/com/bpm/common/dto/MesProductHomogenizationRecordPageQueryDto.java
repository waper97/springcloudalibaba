package com.bpm.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 均化记录表传输类
 *
 * @author zhangzheming
 * @since 2022-05-05 17:14:58
 */
@Data
@ApiModel(value = "均化记录表传输类")
public class MesProductHomogenizationRecordPageQueryDto extends PageDTO {
    /**
     * 成品仓编码
     */
    @ApiModelProperty(value = "成品仓编码")
    private String finishedProductWarehouseCode;
    /**
     * 矿粉编码
     */
    @ApiModelProperty(value = "矿粉编码")
    private String mineralPowderCode;
    /**
     * 矿粉名称
     */
    @ApiModelProperty(value = "矿粉名称")
    private String mineralPowderName;
    /**
     * 开始日期
     */
    @ApiModelProperty(value = "开始日期")
    private Date startDate;
    /**
     * 结束日期
     */
    @ApiModelProperty(value = "结束日期")
    private String endDate;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String status;
}
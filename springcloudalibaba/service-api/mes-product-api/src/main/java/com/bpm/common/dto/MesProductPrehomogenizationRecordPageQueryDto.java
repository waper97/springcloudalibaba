package com.bpm.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 预均化记录传输类
 *
 * @author zhangzheming
 * @since 2022-05-06
 */
@Data
@ApiModel(value = "预均化记录传输类")
public class MesProductPrehomogenizationRecordPageQueryDto extends PageDTO {
    /**
     * 半成品仓编码
     */
    @ApiModelProperty(value = "半成品仓编码")
    private String semiFinishedProductWarehouseCode;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    /**
     * 结束日期
     */
    @ApiModelProperty(value = "结束日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;
}
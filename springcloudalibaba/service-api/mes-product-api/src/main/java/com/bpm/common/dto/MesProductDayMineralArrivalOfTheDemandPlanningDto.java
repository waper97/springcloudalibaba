package com.bpm.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 日矿石到货需求计划传输类
 *
 * @author zhangzheming
 * @since 2022-04-29 11:09:12
 */
@Data
@ApiModel(value = "日矿石到货需求计划传输类")
public class MesProductDayMineralArrivalOfTheDemandPlanningDto extends PageDTO {
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialsCode;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialsName;
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
     * 状态 0已关闭 1新增
     */
    @ApiModelProperty(value = "状态 0已关闭 1新增")
    private Integer status;
}


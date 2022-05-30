package com.bpm.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 日破碎铲车投料计划传输类
 *
 * @author zhangzheming
 * @since 2022-04-29 14:00:56
 */
@Data
@ApiModel(value = "日破碎铲车投料计划分页查传输类")
public class MesProductDayBrokenForkliftFeedingPlanningQueryDto extends PageDTO {
    /**
     * 矿石编码
     */
    @ApiModelProperty(value = "矿石编码")
    private String mineralsCode;
    /**
     * 矿石名称
     */
    @ApiModelProperty(value = "矿石名称")
    private String mineralsName;
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
     * 状态 已关闭 新增
     */
    @ApiModelProperty(value = "状态 已关闭 新增")
    private Integer status;
}
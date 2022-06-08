package com.bpm.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 工作中心表(MesProductWorkCenter)传输类
 *
 * @author zhangzheming
 * @since 2022-04-28 18:00:02
 */
@Data
@ApiModel(value = "工作中心表(MesProductWorkCenter)传输类")
public class MesProductWorkCenterDto extends PageDTO {
    /**
     * 工作中心编号
     */
    @ApiModelProperty(value = "工作中心编号")
    private String code;
    /**
     * 工作中心名称
     */
    @ApiModelProperty(value = "工作中心名称")
    private String name;
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


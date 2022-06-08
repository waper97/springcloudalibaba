package com.bpm.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 生产线表(MesProductProductionLine)传输类
 *
 * @author zhangzheming
 * @since 2022-04-25 14:09:19
 */
@Data
@ApiModel(value = "生产线表(MesProductProductionLine)传输类")
public class MesProductProductionLineDto extends PageDTO{
    /**
     * 生产线编号
     */
    @ApiModelProperty(value = "生产线编号")
    private String code;
    /**
     * 生产线名称
     */
    @ApiModelProperty(value = "生产线名称")
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


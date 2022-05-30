package com.bpm.common.dto;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.bpm.common.domain.DayPlanningDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 日生产计划详情(DayPlanningDetail)传输类
 *
 * @author wangpeng
 * @since 2022-05-06 10:00:58
 */
@Data
@ApiModel(value = "日生产计划详情")
public class DayPlanningDetailDTO extends DayPlanningDetail implements Serializable {
    private static final long serialVersionUID = 997618162225247979L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;




}


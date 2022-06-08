package com.bpm.common.dto;



import com.bpm.common.domain.DayPlanning;
import com.bpm.common.domain.DayPlanningDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 日生产计划(DayPlanning)传输类
 *
 * @author wangpeng
 * @since 2022-05-06 09:54:45
 */
@Data
@ApiModel(value = "日生产计划")
public class DayPlanningInserOrUpdateDTO extends DayPlanning implements Serializable {
    private static final long serialVersionUID = -88696962937818502L;



    @ApiModelProperty(value = "子集")
    List<DayPlanningDetail> detailList;
}


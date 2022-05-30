package com.bpm.common.dto;

import com.bpm.common.domain.MesProductHomogenizationRecord;
import com.bpm.common.domain.MesProductHomogenizationRecordDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 均化记录新增dto
 *
 * @author zhangzheming
 * @since 2022-05-11
 */
@Data
@ApiModel(value = "均化记录新增dto")
public class MesProductHomogenizationRecordAddUpdateDto {
    /**
     * 均化记录
     */
    @ApiModelProperty(value = "均化记录")
    private MesProductHomogenizationRecord record;
    /**
     * 均化记录详情
     */
    @ApiModelProperty(value = "均化记录详情list")
    private List<MesProductHomogenizationRecordDetail> recordDetailList;
}


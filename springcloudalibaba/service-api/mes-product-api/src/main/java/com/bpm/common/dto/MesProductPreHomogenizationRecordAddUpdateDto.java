package com.bpm.common.dto;

import com.bpm.common.domain.MesProductPrehomogenizationRecord;
import com.bpm.common.domain.MesProductPrehomogenizationRecordDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 预均化记录新增修改dto
 *
 * @author zhangzheming
 * @since 2022-05-11
 */
@Data
@ApiModel(value = "预均化记录新增修改dto")
public class MesProductPreHomogenizationRecordAddUpdateDto {
    /**
     * 预均化记录
     */
    @ApiModelProperty(value = "预均化记录")
    private MesProductPrehomogenizationRecord record;
    /**
     * 预均化记录详情
     */
    @ApiModelProperty(value = "预均化记录详情list")
    private List<MesProductPrehomogenizationRecordDetail> recordDetailList;
}


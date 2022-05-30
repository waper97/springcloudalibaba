package com.bpm.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 预均化记录查单个vo
 *
 * @author zhangzheming
 * @since 2022-05-12
 */
@Data
@ApiModel(value = "预均化记录查单个vo")
public class MesProductPreHomogenizationRecordQueryVo {
    /**
     * 预均化记录vo
     */
    @ApiModelProperty(value = "预均化记录vo")
    private MesProductPreHomogenizationRecordVo recordVo;
    /**
     * 预均化记录详情vo列表
     */
    @ApiModelProperty(value = "预均化记录详情vo列表")
    private List<MesProductPreHomogenizationRecordDetailVo> recordDetailVoList;
}
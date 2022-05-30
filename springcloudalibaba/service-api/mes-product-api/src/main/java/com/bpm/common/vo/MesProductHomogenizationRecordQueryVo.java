package com.bpm.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 均化记录查单个vo
 *
 * @author zhangzheming
 * @since 2022-05-11
 */
@Data
@ApiModel(value = "均化记录查单个vo")
public class MesProductHomogenizationRecordQueryVo {
    /**
     * 均化记录vo
     */
    @ApiModelProperty(value = "均化记录vo")
    private MesProductHomogenizationRecordVo recordVo;
    /**
     * 均化记录详情vo列表
     */
    @ApiModelProperty(value = "均化记录详情vo列表")
    private List<MesProductHomogenizationRecordDetailVo> recordDetailVoList;
}
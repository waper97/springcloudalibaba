package com.bpm.common.vo;

import com.bpm.common.domain.MesProductHomogenizationRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 均化记录vo
 *
 * @author zhangzheming
 * @since 2022-05-05 17:14:58
 */
@Data
@ApiModel(value = "均化记录vo")
public class MesProductHomogenizationRecordVo extends MesProductHomogenizationRecord implements Serializable {
    private static final long serialVersionUID = 435656444163459715L;
    /**
     * 工序
     */
    @ApiModelProperty(value = "工序")
    private String processName;
    /**
     * 成品仓编码
     */
    @ApiModelProperty(value = "成品仓编码")
    private String finishedProductWarehouseCode;
    /**
     * 矿粉编码
     */
    @ApiModelProperty(value = "矿粉编码")
    private String mineralPowderCode;
    /**
     * 矿粉名称
     */
    @ApiModelProperty(value = "矿粉名称")
    private String mineralPowderName;

    @ApiModelProperty(value = "状态名称")
    private String statusName;
}
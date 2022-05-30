package com.bpm.common.vo;

import com.bpm.common.domain.MesProductPrehomogenizationRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 预均化记录视图类
 *
 * @author zhangzheming
 * @since 2022-05-06
 */
@Data
@ApiModel(value = "预均化记录vo")
public class MesProductPreHomogenizationRecordVo extends MesProductPrehomogenizationRecord implements Serializable {
    private static final long serialVersionUID = 6448123044712821413L;
    /**
     * 工序
     */
    @ApiModelProperty(value = "工序")
    private String processName;
    /**
     * 半成品仓编码
     */
    @ApiModelProperty(value = "半成品仓编码")
    private String semiFinishedProductWarehouseCode;
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
}
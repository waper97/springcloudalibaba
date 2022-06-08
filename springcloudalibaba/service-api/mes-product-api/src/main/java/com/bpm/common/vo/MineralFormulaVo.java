package com.bpm.common.vo;

import com.bpm.common.domain.MineralFormula;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 矿石配方视图类
 *
 * @author zhangzheming
 * @since 2022-05-10
 */
@Data
@ApiModel(value = "矿石配方视图类")
public class MineralFormulaVo extends MineralFormula {
    /**
     * 磨前仓号
     */
    @ApiModelProperty(value = "磨前仓号")
    private String stockCode;
    /**
     * 产品编码
     */
    @ApiModelProperty(value = "产品编码")
    private String materialCode;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String materialName;
    @ApiModelProperty(value = "状态名称")
    private String statusName;
}
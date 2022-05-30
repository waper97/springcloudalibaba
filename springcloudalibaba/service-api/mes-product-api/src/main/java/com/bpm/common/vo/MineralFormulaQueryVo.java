package com.bpm.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 矿石配方查单个视图类
 *
 * @author zhangzheming
 * @since 2022-05-11
 */
@Data
@ApiModel(value = "矿石配方查单个vo")
public class MineralFormulaQueryVo {
    /**
     * 矿石配方vo
     */
    @ApiModelProperty(value = "矿石配方vo")
    private MineralFormulaVo mineralFormulaVo;
    /**
     * 矿石配方详情vo列表
     */
    @ApiModelProperty(value = "矿石配方详情vo列表")
    private List<MineralFormulaDetailVo> mineralFormulaDetailVoList;
}
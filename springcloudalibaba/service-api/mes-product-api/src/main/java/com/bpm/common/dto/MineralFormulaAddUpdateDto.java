package com.bpm.common.dto;

import com.bpm.common.domain.MineralFormula;
import com.bpm.common.domain.MineralFormulaDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 矿石配方新增传输类
 *
 * @author zhangzheming
 * @since 2022-05-10
 */
@Data
@ApiModel(value = "矿石配方新增传输类")
public class MineralFormulaAddUpdateDto {
    /**
     * 矿石配方
     */
    @ApiModelProperty(value = "矿石配方")
    private MineralFormula mineralFormula;
    /**
     * 矿石配方详情列表
     */
    @ApiModelProperty(value = "矿石配方详情列表")
    private List<MineralFormulaDetail> mineralFormulaDetailList;
}
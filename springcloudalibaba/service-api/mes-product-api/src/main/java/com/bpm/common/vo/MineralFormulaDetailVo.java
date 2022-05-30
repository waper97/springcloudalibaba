package com.bpm.common.vo;

import com.bpm.common.domain.MineralFormulaDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 矿石配方明细视图类
 *
 * @author zhangzheming
 * @since 2022-05-10
 */
@Data
@ApiModel(value = "矿石配方明细视图类")
public class MineralFormulaDetailVo extends MineralFormulaDetail {
    /**
     * 碎石仓编码
     */
    @ApiModelProperty(value = "碎石仓编码")
    private String warehouseCode;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialName;
}
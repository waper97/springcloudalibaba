package com.bpm.common.vo;

import com.bpm.common.domain.BrokenStoneWarehouse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 碎石仓视图类
 *
 * @author wangpeng
 * @since 2022-04-29 10:25:28
 */
@Data
@ApiModel(value = "碎石仓视图类")
public class BrokenStoneWarehouseVO extends BrokenStoneWarehouse {
    /**
     * 碎石仓编号
     */
    @ApiModelProperty(value = "碎石仓编号")
    private String stockCode;

    @ApiModelProperty(value = "碎石仓名称")
    private String stockName;
    /**
     * 生产品种
     */
    @ApiModelProperty(value = "生产品种")
    private String materialTypeName;
    /**
     * 矿石编码
     */
    @ApiModelProperty(value = "矿石编码")
    private String materialCode;
    /**
     * 矿石名称
     */
    @ApiModelProperty(value = "矿石名称")
    private String materialName;
}
package com.bpm.common.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OutStockVo {

    @ApiModelProperty(value = "仓库出入库id")
    private Integer outId;

    @ApiModelProperty(value = "仓库出入库编码")
    private String stockInOutCode;

    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料id")
    private Integer materialId;

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

    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量单位id")
    private Integer unitsId;
    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量单位名称")
    private String unitsName;

    @ApiModelProperty(value = "数量")
    private BigDecimal actualQty;


//    @ApiModelProperty(value = "消耗报工明细表数据")
//    private List<ProductConsumeWorkReportListVO> listVOS;

}


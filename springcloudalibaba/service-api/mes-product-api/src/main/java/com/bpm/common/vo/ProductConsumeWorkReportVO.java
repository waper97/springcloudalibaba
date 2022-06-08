package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.ProductConsumeWorkReport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 消耗报工(ProductConsumeWorkReport)实体类
 *
 * @author wangpeng
 * @since 2022-05-25 14:11:32
 */
@Data
@ApiModel(value = "消耗报工")
public class ProductConsumeWorkReportVO extends ProductConsumeWorkReport implements Serializable {
    private static final long serialVersionUID = 928013623874255629L;
    /**
     * 工作中心名称
     */
    @ApiModelProperty(value = "工作中心名称")
    private String workEnterName;

    /**
     * bom编码
     */
    @ApiModelProperty(value = "bom编码")
    private String bomCode;

    /**
     * bom版本
     */
    @ApiModelProperty(value = "bom版本")
    private String bomVersion;

    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String stockCode;

    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private String stockName;

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
    @ApiModelProperty(value = "计量单位名称")
    private String unitsName;

    /**
     * 状态名称
     */
    @ApiModelProperty(value = "状态名称")
    private String statusName;

    /**
     * 物料编码
     */
    @ApiModelProperty(value = "入库报工编码")
    private String inWorkReportCode;

    /**
     * 批次号
     */
    @ApiModelProperty(value = "入库批次号")
    private String inBatchNo;

    @ApiModelProperty(value = "出库单据id集合")
    private List<Integer> stockInOutIds;

    @ApiModelProperty(value = "消耗报工明细表数据")
    private List<ProductConsumeWorkReportListVO> listVOS;

}


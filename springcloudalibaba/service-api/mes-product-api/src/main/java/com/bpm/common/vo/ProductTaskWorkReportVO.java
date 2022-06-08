package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.ProductTaskWorkReport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 作业报工(ProductTaskWorkReport)实体类
 *
 * @author wangpeng
 * @since 2022-05-25 14:10:59
 */
@Data
@ApiModel(value = "作业报工")
public class ProductTaskWorkReportVO extends ProductTaskWorkReport implements Serializable {
    private static final long serialVersionUID = 617141282641077861L;

    /**
     * 工作中心名称
     */
    @ApiModelProperty(value = "工作中心名称")
    private Integer workEnterName;

    /**
     * bom编码
     */
    @ApiModelProperty(value = "bom编码")
    private Integer bomCode;

    /**
     * bom版本
     */
    @ApiModelProperty(value = "bom版本")
    private Integer bomVersion;

    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private Integer stockCode;

    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private Integer stockName;

    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private Integer materialCode;

    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private Integer materialName;

    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量单位名称")
    private Integer unitsName;

    /**
     * 状态名称
     */
    @ApiModelProperty(value = "状态名称")
    private String statusName;

    /**
     * 批次号
     */
    @ApiModelProperty(value = "入库批次号")
    private String inBatchNo;

}


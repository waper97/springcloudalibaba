package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.ProductInWorkReport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 生成入库报工(ProductInWorkReport)实体类
 *
 * @author wangpeng
 * @since 2022-05-23 14:51:47
 */
@Data
@ApiModel(value = "生成入库报工")
public class ProductInWorkReportVO extends ProductInWorkReport implements Serializable {

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
     * 状态名称
     */
    @ApiModelProperty(value = "入库类型名称")
    private String stockTypeName;
    /**
     * 状态名称
     */
    @ApiModelProperty(value = "源单类型名称")
    private String SourceTypeName;

    /**
     * 入库主表id
     */
    @ApiModelProperty(value = "入库主表id")
    private List<Integer> stockInOutIds;
    @ApiModelProperty(value = "入库主表id")
    private List<InStockVo> stockVos;

}


package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.ProductConsumeWorkReportList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 消耗报工明细表(ProductConsumeWorkReportList)实体类
 *
 * @author wangpeng
 * @since 2022-05-25 14:12:05
 */
@Data
@ApiModel(value = "消耗报工明细表")
public class ProductConsumeWorkReportListVO extends ProductConsumeWorkReportList implements Serializable {
    private static final long serialVersionUID = 543791470192519139L;

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

}


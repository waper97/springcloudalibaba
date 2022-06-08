package com.bpm.common.dto;


import com.bpm.common.domain.ProductConsumeWorkReport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 消耗报工(ProductConsumeWorkReport)传输类
 *
 * @author wangpeng
 * @since 2022-05-25 14:11:32
 */
@Data
@ApiModel(value = "消耗报工")
public class ProductConsumeWorkReportDTO extends ProductConsumeWorkReport implements Serializable {
    private static final long serialVersionUID = -20510240401692783L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

}


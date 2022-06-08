package com.bpm.common.dto;


import com.bpm.common.domain.ProductConsumeWorkReportList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 消耗报工明细表(ProductConsumeWorkReportList)传输类
 *
 * @author wangpeng
 * @since 2022-05-25 14:12:05
 */
@Data
@ApiModel(value = "消耗报工明细表")
public class ProductConsumeWorkReportListDTO extends ProductConsumeWorkReportList implements Serializable {
    private static final long serialVersionUID = 558659523526482681L;


    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

}


package com.bpm.common.dto;



import com.bpm.common.domain.ProductTaskWorkReport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 作业报工(ProductTaskWorkReport)传输类
 *
 * @author wangpeng
 * @since 2022-05-25 14:10:58
 */
@Data
@ApiModel(value = "作业报工")
public class ProductTaskWorkReportDTO extends ProductTaskWorkReport implements Serializable {
    private static final long serialVersionUID = 971160041369012525L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

}


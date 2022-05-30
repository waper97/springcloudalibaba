package com.bpm.common.dto;


import com.bpm.common.domain.MonthlyProductionOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 月生产订单(MonthlyProductionOrder)传输类
 *
 * @author wangpeng
 * @since 2022-05-17 17:44:16
 */
@Data
@ApiModel(value = "月生产订单")
public class MonthlyProductionOrderDTO extends MonthlyProductionOrder implements Serializable {
    private static final long serialVersionUID = 964073388339036983L;
    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;


}


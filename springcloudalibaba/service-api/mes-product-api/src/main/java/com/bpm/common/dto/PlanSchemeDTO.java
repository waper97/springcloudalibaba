package com.bpm.common.dto;


import com.bpm.common.domain.PlanScheme;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 *  计划方案(PlanScheme)传输类
 *
 * @author wangpeng
 * @since 2022-05-18 14:38:45
 */
@Data
@ApiModel(value = " 计划方案")
public class PlanSchemeDTO extends PlanScheme implements Serializable {
    private static final long serialVersionUID = -98840137631724084L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

}


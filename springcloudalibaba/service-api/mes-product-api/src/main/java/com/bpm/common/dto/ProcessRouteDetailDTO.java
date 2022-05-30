package com.bpm.common.dto;

// 设置后缀名称


import com.bpm.common.entity.MesProductProcessRouteDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 工艺路线详情表(ProcessRouteDetail)传输类
 *
 * @author wangpeng
 * @since 2022-04-19 13:45:01
 */
@Data
@ApiModel(value = "工艺路线详情表")
public class ProcessRouteDetailDTO extends MesProductProcessRouteDetail implements Serializable {
    private static final long serialVersionUID = 392801979814472340L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

}


package com.bpm.common.vo;

import com.bpm.common.domain.ProcessRouteDetail;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 工艺路线详情表(ProcessRouteDetail)实体类
 *
 * @author wangpeng
 * @since 2022-04-18 16:11:48
 */
@Data
@ApiModel(value = "工艺路线详情")
public class ProcessRouteDetailVO extends ProcessRouteDetail implements Serializable {
    private static final long serialVersionUID = 290692778603183058L;


    private String workCenterName;


}


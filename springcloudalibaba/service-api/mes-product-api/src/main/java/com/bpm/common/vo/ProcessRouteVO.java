package com.bpm.common.vo;

import com.bpm.common.domain.ProcessRoute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 工艺路线 传输类
 *
 * @author wangpeng
 * @since 2022-04-18 15:31:13
 */
@Data
@ApiModel(value = "工艺路线")
public class ProcessRouteVO extends ProcessRoute implements Serializable {
    private static final long serialVersionUID = -23996930417560047L;

    @ApiModelProperty(value = "属性名称")
    private String processTypeName;
    @ApiModelProperty(value = "状态名称")
    private String statusName;

    @ApiModelProperty(value = "工艺路线子集")
    List<ProcessRouteDetailVO> productProcessRouteDetailList;
}


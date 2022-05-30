package com.bpm.common.vo;

import com.bpm.common.domain.MesProductWorkCenter;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作中心视图类
 *
 * @author zhangzheming
 * @since 2022-05-09
 */
@Data
@ApiModel(value = "工作中心视图类")
public class MesProductWorkCenterVo extends MesProductWorkCenter {
    /**
     * 公司
     */
    @ApiModelProperty(value = "公司")
    private String company;
    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String department;
    /**
     * 资源类别
     */
    @ApiModelProperty(value = "资源类别")
    private String resourceAtegorieName;
}


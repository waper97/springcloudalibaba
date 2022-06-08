package com.bpm.common.vo;

import com.bpm.common.domain.MesProductWorkCenter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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


    @ApiModelProperty(value = "接收仓库名称")
    private String receiveWarehouseName;
    /**
     * 存放仓库
     */
    @ApiModelProperty(value = "存放仓库名称")
    private String storageWarehouseName;
    /**
     * 备用库位
     */
    @ApiModelProperty(value = "备用库位名称")
    private String substoreName;
}


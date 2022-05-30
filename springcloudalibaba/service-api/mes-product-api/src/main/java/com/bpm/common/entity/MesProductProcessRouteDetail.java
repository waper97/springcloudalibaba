package com.bpm.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 工艺路线详情表(ProcessRouteDetail)实体类
 *
 * @author wangpeng
 * @since 2022-04-18 16:11:48
 */
@Data
@ApiModel(value = "工艺路线详情")
public class MesProductProcessRouteDetail implements Serializable {
    private static final long serialVersionUID = 290692778603183058L;
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 工艺路线主表id
     */
    @ApiModelProperty(value = "工艺路线主表id")
    private Integer mesProductProcessRouteId;

    /**
     * 执行顺序号
     */
    @ApiModelProperty(value = "执行顺序号")
    private String executionSequenceNumber;

    /**
     * 工艺编码
     */
    @ApiModelProperty(value = "工艺编码")
    private String processCoding;

    /**
     * 工序名称
     */
    @ApiModelProperty(value = "工序名称")
    private String processName;

    /**
     * 工作中心
     */
    @ApiModelProperty(value = "工作中心")
    private String workCenter;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
    private String createId;

    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称")
    private String createName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改人id
     */
    @ApiModelProperty(value = "修改人id")
    private String updateId;

    /**
     * 修改人名称
     */
    @ApiModelProperty(value = "修改人名称")
    private String updateName;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 是否删除:1是，0否
     */
    @ApiModelProperty(value = "是否删除:1是，0否")
    private Integer isDeleted;



}


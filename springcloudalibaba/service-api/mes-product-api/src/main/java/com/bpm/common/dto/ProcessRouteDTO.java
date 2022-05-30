package com.bpm.common.dto;

// 设置后缀名称


import com.bpm.common.domain.ProcessRoute;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 工艺路线主表
(ProcessRoute)传输类
 *
 * @author wangpeng
 * @since 2022-04-19 13:44:13
 */
@Data
@ApiModel(value = "工艺路线主表 ")
public class ProcessRouteDTO  implements Serializable {
    private static final long serialVersionUID = 344899486401861418L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 流程卡号
     */
    @ApiModelProperty(value = "流程卡号")
    private String processCode;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private String versionNumber;

    /**
     * 矿粉编号
     */
    @ApiModelProperty(value = "矿粉编号")
    private String mineralPowderCode;

    /**
     * 矿粉名称
     */
    @ApiModelProperty(value = "矿粉名称")
    private String mineralPowderName;

    /**
     * 流程卡类型
     */
    @ApiModelProperty(value = "流程卡类型")
    private String processType;

    /**
     * 生效日期
     */
    @ApiModelProperty(value = "生效日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;

    /**
     * 失效日期
     */
    @ApiModelProperty(value = "失效日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime invalidDate;

    /**
     * 状态：0生效，1新增
     */
    @ApiModelProperty(value = "状态：0生效，1新增")
    private Integer status;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 是否删除:1是，0否
     */
    @ApiModelProperty(value = "是否删除:1是，0否")
    private Integer isDeleted;




    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape =JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createBeginTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape =JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createEndTime;

}


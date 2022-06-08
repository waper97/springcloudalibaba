package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 工艺路线主表
 * (ProcessRouteDTO)实体类
 *
 * @author wangpeng
 * @since 2022-04-18 15:31:13
 */
@Data
@ApiModel(value = "工艺路线")
public class ProcessRoute implements Serializable {
    private static final long serialVersionUID = -23996930417560047L;
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
     * 是否删除:1是，0否
     */
    @ApiModelProperty(value = "产品id(外键关联物料表)")
    private Integer productId;


}


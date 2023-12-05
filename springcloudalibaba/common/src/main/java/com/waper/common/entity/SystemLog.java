package com.waper.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author administrator
 * @since 2023-11-23 10:01:40
 */
@Data
@TableName("system_log")
@ApiModel(value = "SystemLog对象", description = "全局日志对象")
public class SystemLog implements Serializable {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("业务类型")
    @TableField("businessType")
    private String businessType;

    @ApiModelProperty("请求路径")
    @TableField("path")
    private String path;

    @ApiModelProperty("请求体")
    @TableField("request_body")
    private String requestBody;

    @ApiModelProperty("请求IP")
    @TableField("client_ip")
    private String clientIp;

    @ApiModelProperty("响应体")
    @TableField("response_body")
    private String responseBody;


    @ApiModelProperty("业务处理时间")
    @TableField("business_process_time")
    private Long businessProcessTime;

    @ApiModelProperty("请求时间")
    @TableField("request_time")
    private Long requestTime;

    @ApiModelProperty("响应时间")
    @TableField("response_time")
    private Long responseTime;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;
}

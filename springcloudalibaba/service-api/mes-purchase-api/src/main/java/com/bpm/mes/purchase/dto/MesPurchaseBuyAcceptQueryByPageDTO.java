package com.bpm.mes.purchase.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MesPurchaseBuyAcceptQueryByPageDTO {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id ")
    private Integer id;

    @ApiModelProperty(value = "物料编码 ")
    private String materialCode;

    @ApiModelProperty(value = "物料名称 ")
    private String materialName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间 ")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间 ")
    private Date endTime;
}

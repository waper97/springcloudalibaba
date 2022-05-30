package com.bpm.common.dto;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 碎石仓(BrokenStoneWarehouse)传输类
 *
 * @author wangpeng
 * @since 2022-04-29 10:25:28
 */
@Data
@ApiModel(value = "碎石仓")
public class BrokenStoneWarehouseDTO extends PageDTO implements Serializable {
    private static final long serialVersionUID = 646141935654484203L;
    /**
     * 碎石仓编码
     */
    @ApiModelProperty(value = "碎石仓编码")
    private String stockCode;
    /**
     * 矿石名称
     */
    @ApiModelProperty(value = "矿石名称")
    private String materialName;
    /**
     * 生产品种
     */
    @ApiModelProperty(value = "生产品种")
    private String materialTypeName;
}


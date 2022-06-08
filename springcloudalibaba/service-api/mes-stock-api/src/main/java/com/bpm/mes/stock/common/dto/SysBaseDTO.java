package com.bpm.mes.stock.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>Title: SysBaseDTO</p>
 * <p>Description: 底层DTO</p>
 * <p>Company: http://www.wootion.com/</p>
 * <p>create date: 2020/03/20</p>
 *
 * @author :tanhuan
 * @version :1.0
 */
@Data
@ApiModel(description = "底层DTO")
public class SysBaseDTO {

    @ApiModelProperty(value = "主键")
    protected Integer id;

    @ApiModelProperty(value = "创建时间")
    protected Date createTime;

    @ApiModelProperty(value = "更新时间")
    protected Date updateTime;

    @ApiModelProperty(value = "创建用户Id")
    protected Integer creatorId;

    @ApiModelProperty(value = "更新用户Id")
    protected Integer updaterId;

}

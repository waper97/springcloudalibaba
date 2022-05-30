package com.bpm.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 生产线编号视图类
 *
 * @author zhangzheming
 * @since 2022-05-06
 */
@Data
@ApiModel(description = "生产线编号视图类")
public class ProductionLineNumberVo {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 生产线编号
     */
    @ApiModelProperty(value = "生产线编号")
    private String code;
    /**
     * 生产线名称
     */
    @ApiModelProperty(value = "生产线名称")
    private String name;
}

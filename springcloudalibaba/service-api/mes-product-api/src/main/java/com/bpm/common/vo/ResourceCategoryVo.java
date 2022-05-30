package com.bpm.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 资源类别视图类
 *
 * @author zhangzheming
 * @since 2022-05-09
 */
@Data
@ApiModel(description = "资源类别视图类")
public class ResourceCategoryVo {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 资源类别
     */
    @ApiModelProperty(value = "资源类别")
    private String resourceCategory;
}

package com.bpm.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公司名称视图类
 *
 * @author zhangzheming
 * @since 2022-05-06
 */
@Data
@ApiModel(description = "公司名称视图类")
public class CompanyNameVo {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String name;
}

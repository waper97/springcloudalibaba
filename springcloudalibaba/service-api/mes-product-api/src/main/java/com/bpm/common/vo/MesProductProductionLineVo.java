package com.bpm.common.vo;

import com.bpm.common.domain.MesProductProductionLine;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 生产线视图类
 *
 * @author zhangzheming
 * @since 2022-05-06
 */
@Data
@ApiModel(value = "生产线视图类")
public class MesProductProductionLineVo extends MesProductProductionLine {
    /**
     * 父生产线号
     */
    @ApiModelProperty(value = "父生产线号")
    private String parentLineNumber;
    /**
     * 所属工厂
     */
    @ApiModelProperty(value = "所属工厂")
    private String factory;
}


package com.bpm.common.dto;

// 设置后缀名称


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * bom(物料清单)明细表(BillOfMaterialDetail)传输类
 *
 * @author wangpeng
 * @since 2022-04-19 11:42:42
 */
@Data
@ApiModel(value = "bom(物料清单)明细表")
public class BillOfMaterialDetailDTO extends BillOfMaterialDTO implements Serializable {

    private static final long serialVersionUID = -77139175803542804L;


    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;
}


package com.bpm.common.dto;

// 设置后缀名称


import com.bpm.common.domain.BillOfMaterial;
import com.bpm.common.domain.BillOfMaterialDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * bom(物料清单)传输类
 *
 * @author wangpeng
 * @since 2022-04-19 11:44:34
 */
@Data
@ApiModel(value = "bom(物料清单)主表",description = "bom(物料清单)主表")
public class BillOfMaterialInsertOrUpdateDTO extends BillOfMaterial implements Serializable {

    private static final long serialVersionUID = 437394434197599279L;

    /**
     * bom详情
     */
    @ApiModelProperty("bom详情")
    List<BillOfMaterialDetail> billOfMaterialDetailList;

}


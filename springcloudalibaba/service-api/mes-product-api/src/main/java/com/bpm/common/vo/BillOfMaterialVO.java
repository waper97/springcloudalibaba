package com.bpm.common.vo;



import com.bpm.common.domain.BillOfMaterial;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * bom(物料清单)主表(BillOfMaterial)实体类
 *
 * @author wangpeng
 * @since 2022-04-19 11:38:10
 */
@Data
//@ApiModel(value = "bom(物料清单)主表")
public class BillOfMaterialVO extends BillOfMaterial implements Serializable {
    private static final long serialVersionUID = 562869854502917035L;
    @ApiModelProperty(value = "产品编号")
    private String productCode;
    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "矿粉名称")
    private String mineralName;

    @ApiModelProperty(value = "矿粉编号")
    private String mineralCode;

    @ApiModelProperty(value = "计量单位")
    private String unitOfMeasurement;


    List<BillOfMaterialDetailVO> billOfMaterialDetailList = new ArrayList<>();
}


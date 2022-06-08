package com.bpm.common.vo;

import com.bpm.common.domain.BillOfMaterialDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * bom(物料清单)明细表(BillOfMaterialDetail)实体类
 *
 * @author wangpeng
 * @since 2022-04-19 10:38:22
 */
@Data
@ApiModel(value = "")
public class BillOfMaterialDetailVO  extends BillOfMaterialDetail implements Serializable {
    private static final long serialVersionUID = 170832680250405113L;

    @ApiModelProperty(value = "计量单位")
    private String unitOfMeasurement;
    @ApiModelProperty(value = "物料属性名称")
    private String materialPropertiesName;
    @ApiModelProperty(value = "物料编号")
    private String materialCode;
    @ApiModelProperty(value = "物料名称")
    private String materialName;

}


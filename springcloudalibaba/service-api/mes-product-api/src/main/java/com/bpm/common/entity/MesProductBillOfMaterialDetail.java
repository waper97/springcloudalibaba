package com.bpm.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * bom(物料清单)明细表(BillOfMaterialDetail)实体类
 *
 * @author wangpeng
 * @since 2022-04-19 10:38:22
 */
@Data
@ApiModel(value = "")
public class MesProductBillOfMaterialDetail  implements Serializable {
    private static final long serialVersionUID = 170832680250405113L;
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * bom(物料清单)主表id
     */
    @ApiModelProperty(value = "bom(物料清单)主表id")
    private String mesProductBillOfMaterialId;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private String seqnumber;

    /**
     * 可制产品基数，默认1
     */
    @ApiModelProperty(value = "可制产品基数，默认1")
    private String cardinality;

    /**
     * 产品id 外键 带出 计量单位、产品编号、产品名称
     */
    @ApiModelProperty(value = "产品id 外键 带出 计量单位、产品编号、产品名称")
    private String productId;

    /**
     * 物料属性id（外键），包括：1外购、2委外、3自制
     从物料基本信息带入，可修改，数据字典
     */
    @ApiModelProperty(value = "物料属性id（外键），包括：1外购、2委外、3自制 从物料基本信息带入，可修改，数据字典")
    private String materialPropertiesId;

    /**
     * bom(物料清单)明细表id  自关联
    */
    @ApiModelProperty(value = "bom(物料清单)明细表id  自关联")
    private String mesProductBillOfMaterialDetailId;


    private String subitemMaterielId;

    /**
     * 子项物料编码
    */
    @ApiModelProperty(value = "子项物料编码")
    private String subitemMaterialCode;

    /**
     * 子项物料名称
    */
    @ApiModelProperty(value = "子项物料名称")
    private String subitemMaterialName;

    /**
     * 子项数量，默认1
    */
    @ApiModelProperty(value = "子项数量，默认1")
    private Integer subitemMaterialQuantity;

    /**
     * 创建人id
    */
    @ApiModelProperty(value = "创建人id")
    private String createId;

    /**
     * 创建人名称
    */
    @ApiModelProperty(value = "创建人名称")
    private String createName;

    /**
     * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改人id
    */
    @ApiModelProperty(value = "修改人id")
    private String updateId;

    /**
     * 修改人名称
    */
    @ApiModelProperty(value = "修改人名称")
    private String updateName;

    /**
     * 修改时间
    */
    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 是否删除:1是，0否
    */
    @ApiModelProperty(value = "是否删除:1是，0否")
    private Integer isDeleted;

    @ApiModelProperty(value = "成本金额")
    private BigDecimal costAmount;
}


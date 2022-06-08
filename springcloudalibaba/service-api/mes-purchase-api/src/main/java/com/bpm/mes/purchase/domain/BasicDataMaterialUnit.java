package com.bpm.mes.purchase.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 物料单位表(BasicDataMaterialUnit)实体类
 *
 * @author renruiling
 * @since 2022-05-06 11:02:03
 */
@Data
@ApiModel(value = "BasicDataMaterialUnit")
public class BasicDataMaterialUnit implements Serializable {
    private static final long serialVersionUID = -26984263636627796L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer orderNum;
    /**
     * 物料单位编码
     */
    @ApiModelProperty(value = "物料单位编码")
    private String materialUnitCode;
    /**
     * 物料单位名称
     */
    @ApiModelProperty(value = "物料单位名称")
    private String materialUnitName;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
    private Integer createId;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private String updateTime;
    /**
     * 修改人id
     */
    @ApiModelProperty(value = "修改人id")
    private Integer updateId;
    /**
     * 公司id
     */
    @ApiModelProperty(value = "公司id")
    private Integer companyId;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
}


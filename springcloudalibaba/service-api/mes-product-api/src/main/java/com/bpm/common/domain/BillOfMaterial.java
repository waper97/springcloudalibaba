package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * bom(物料清单)主表(BillOfMaterialDTO)实体类
 *
 * @author wangpeng
 * @since 2022-04-18 17:46:31
 */
@Data
@ApiModel(value = "bom(物料清单)")
public class BillOfMaterial implements Serializable {
    private static final long serialVersionUID = -40536459963461722L;
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * bom编码
     */
    @ApiModelProperty(value = "bom编码")
    private String code;

    /**
     * bom类型:1制造bom，2设计bom
     */
    @ApiModelProperty(value = "bom类型:1制造bom，2设计bom")
    private String type;

    /**
     * 产品id(物料表外键） 关联带出编号、名称
     */
    @ApiModelProperty(value = "产品id(物料表外键） 关联带出编号、名称")
    private Integer productId;

    /**
     * 可制产品基数（矿粉基数），默认1
     */
    @ApiModelProperty(value = "可制产品基数（矿粉基数），默认1")
    private BigDecimal cardinality;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private String version;

    /**
     * 生效日期（新增或者启用时）（yyyy-mm-dd hh:mm ss）
     */
    @ApiModelProperty(value = "生效日期（新增或者启用时）（yyyy-mm-dd hh:mm ss）")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;

    /**
     * 失效时间  停用时yyyy-mm-dd hh:mm ss
     */
    @ApiModelProperty(value = "失效时间  停用时yyyy-mm-dd hh:mm ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime failureDate;

    /**
     * 成品率（%），默认100
     */
    @ApiModelProperty(value = "成品率（%），默认100")
    private BigDecimal yield;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 状态：1新增，2已提交，3已审核
     */
    @ApiModelProperty(value = "状态：1 新增 ，2生效、失效")
    private Integer status;

    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
    private Integer createId;

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
    private Integer updateId;

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

    @ApiModelProperty(value = "bom名称")
    private String bomName;

    @ApiModelProperty(value = "成本金额")
    private BigDecimal costAmount;

    @ApiModelProperty(value = "状态名称")
    private String  statusName;
}


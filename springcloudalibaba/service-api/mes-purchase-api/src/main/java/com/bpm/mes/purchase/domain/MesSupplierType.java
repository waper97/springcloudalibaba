package com.bpm.mes.purchase.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * (MesSupplierType)实体类
 *
 * @author renruiling
 * @since 2022-05-07 14:57:05
 */
@Data
@ApiModel(value = "MesSupplierType")
public class MesSupplierType implements Serializable {
    private static final long serialVersionUID = -76701560640454230L;
        /**
         * 供应商类型编码
         */
        @ApiModelProperty(value = "供应商类型编码")
        private String supplierTypeCode;
        /**
         * 供应商类型名称 
         */
        @ApiModelProperty(value = "供应商类型名称 ")
        private String supplierTypeName;
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
        private Date createTime;
        /**
         * 修改人
         */
        @ApiModelProperty(value = "修改人")
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
        private Date updateTime;
        /**
         * 备注
         */
        @ApiModelProperty(value = "备注")
        private String remark;
        /**
         * 0无效，1有效，默认1
         */
        @ApiModelProperty(value = "0无效，1有效，默认1")
        private Integer isValid;
        /**
         * 主键id
         */
        @ApiModelProperty(value = "主键id")
        private Integer id;
        /**
         * 公司ID
         */
        @ApiModelProperty(value = "公司ID")
        private Integer companyId;
        /**
         * 公司简称
         */
        @ApiModelProperty(value = "公司简称")
        private String companyName;
}


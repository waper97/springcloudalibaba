package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MesPurchaseBuyRequestListUpdateDTO {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 采购申请单ID（外键）
     */
    @ApiModelProperty(value = "采购申请单ID（外键）")
    private Integer buyRequestId;
    /**
     * 采购申请单编号
     */
    @ApiModelProperty(value = "采购申请单编号")
    private String buyRequestCode;
    /**
     * 物料ID
     */
    @ApiModelProperty(value = "物料ID")
    private Integer materialId;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    /**
     * 物料规格
     */
    @ApiModelProperty(value = "物料规格")
    private String materialSpec;
    /**
     * 计量单位ID，外键
     */
    @ApiModelProperty(value = "计量单位ID，外键")
    private Integer unitsId;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Double qty;
    /**
     * 供应商ID(外键)
     */
    @ApiModelProperty(value = "供应商ID(外键)")
    private Integer supplierId;
    /**
     * 建议采购日期（YYYY-MM-DD）
     */
    @ApiModelProperty(value = "建议采购日期（YYYY-MM-DD）")
    private Date purchDate;
    /**
     * 到货日期
     */
    @ApiModelProperty(value = "到货日期")
    private Date fetchDate;
    /**
     * 锁单标记 0
     */
    @ApiModelProperty(value = "锁单标记 0")
    private Integer mrpLockFlag;
    /**
     * 业务关闭：0，1
     */
    @ApiModelProperty(value = "业务关闭：0，1")
    private Integer mrpClosed;
    /**
     * 运输提前期
     */
    @ApiModelProperty(value = "运输提前期")
    private Date fixLeadTime;
    /**
     * 备货提前期
     */
    @ApiModelProperty(value = "备货提前期")
    private String changeLeadTime;
    /**
     * 收货处理时间(检验提前期)，可以有小数
     */
    @ApiModelProperty(value = "收货处理时间(检验提前期)，可以有小数 ")
    private Date checkLeadTime;
    /**
     * 业务员ID
     */
    @ApiModelProperty(value = "业务员ID")
    private Integer empId;
    /**
     * 业务员编号
     */
    @ApiModelProperty(value = "业务员编号")
    private String empNo;
    /**
     * 源单类型：0无、1销售订单、2采购计划
     */
    @ApiModelProperty(value = "源单类型：0无、1销售订单、2采购计划")
    private Integer sourceType;
    /**
     * 源单号ID（关联表单）
     */
    @ApiModelProperty(value = "源单号ID（关联表单）")
    private Integer sourceId;
    /**
     * 源单号（关联表单）
     */
    @ApiModelProperty(value = "源单号（关联表单）")
    private String sourceCode;
    /**
     * 源单明细ID
     */
    @ApiModelProperty(value = "源单明细ID")
    private Integer sourceListId;

    @ApiModelProperty(value = "创建人")
    private String createId;

    @ApiModelProperty(value = "创建名称")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private String updateId;

    @ApiModelProperty(value = "修改人名称")
    private String updateName;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "0无效，1有效，默认1")
    private Integer isValid;

    @ApiModelProperty(value = "物料简称 ")
    private String materialShortName;

    @ApiModelProperty(value = "供应商全称")
    private String supplierFullName;

    @ApiModelProperty(value = "公司ID")
    private Integer companyId;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "单价（不含税）")
    private Float price;
    @ApiModelProperty(value = "不含税金额")
    private Float amount;
    @ApiModelProperty(value = "税率")
    private Float taxRate;
    @ApiModelProperty(value = "税额")
    private Float taxAmount;
    @ApiModelProperty(value = "含税单价")
    private Float taxPrice;
    @ApiModelProperty(value = "价税合计（含税金额）")
    private Float allAmount;
}

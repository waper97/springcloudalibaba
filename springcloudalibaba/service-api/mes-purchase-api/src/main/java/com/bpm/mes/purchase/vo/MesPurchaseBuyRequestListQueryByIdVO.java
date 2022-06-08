package com.bpm.mes.purchase.vo;

import com.bpm.mes.purchase.common.dto.SysBaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MesPurchaseBuyRequestListQueryByIdVO extends SysBaseDTO {

    @ApiModelProperty(value = "采购申请单ID（外键）")
    private Integer buyRequestId;

    @ApiModelProperty(value = "采购申请单编号")
    private String buyRequestCode;

    @ApiModelProperty(value = "物料ID")
    private Integer materialId;

    @ApiModelProperty(value = "物料编码")
    private String materialCode;

    @ApiModelProperty(value = "物料规格")
    private String materialSpec;

    @ApiModelProperty(value = "计量单位ID，外键")
    private Integer unitsId;

    @ApiModelProperty(value = "计量单位名称")
    private String materialUnitName;

    @ApiModelProperty(value = "数量")
    private Double qty;

    @ApiModelProperty(value = "供应商ID(外键)")
    private Integer supplierId;

    @ApiModelProperty(value = "建议采购日期（YYYY-MM-DD）")
    private Date purchDate;

    @ApiModelProperty(value = "到货日期")
    private Date fetchDate;

    @ApiModelProperty(value = "锁单标记 0")
    private Integer mrpLockFlag;

    @ApiModelProperty(value = "业务关闭：0，1")
    private Integer mrpClosed;

    @ApiModelProperty(value = "运输提前期")
    private Date fixLeadTime;

    @ApiModelProperty(value = "备货提前期")
    private String changeLeadTime;

    @ApiModelProperty(value = "收货处理时间(检验提前期)，可以有小数 ")
    private Date checkLeadTime;

    @ApiModelProperty(value = "业务员ID")
    private Integer empId;

    @ApiModelProperty(value = "业务员编号")
    private String empNo;

    @ApiModelProperty(value = "源单类型：0无、1销售订单、2采购计划")
    private Integer sourceType;

    @ApiModelProperty(value = "源单号ID（关联表单）")
    private Integer sourceId;

    @ApiModelProperty(value = "源单号（关联表单）")
    private String sourceCode;

    @ApiModelProperty(value = "源单明细ID")
    private Integer sourceListId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "0无效，1有效，默认1")
    private Integer isValid;

    @ApiModelProperty(value = "物料简称 ")
    private String materialShortName;

    @ApiModelProperty(value = "供应商全称")
    private String supplierFullName;

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

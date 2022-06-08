package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MesPurchaseBuyRequestInsertDTO {

    @ApiModelProperty(value = "单据编号（PB+8位年月日+0001）")
    private String buyRequestCode;

    @ApiModelProperty(value = "单据日期（YYYY-MM-DD）")
    private Date date;

    @ApiModelProperty(value = "申请人ID（外键，员工） ")
    private Integer requesterId;

    @ApiModelProperty(value = "申请人ID姓名")
    private String requesterName;

    @ApiModelProperty(value = "业务类型：1采购入库、2样品采购、3订单委外、(数据字典维护)")
    private Integer bussinessType;

    @ApiModelProperty(value = "计划类别：1 标准")
    private Integer planType;

    @ApiModelProperty(value = "源单类型：0无、1销售订单、2采购计划（MRP运算 ）")
    private Integer sourceType;

    @ApiModelProperty(value = "状态：0草稿、1已申请，2已接收、3待审核、4已审核")
    private Integer state;

    @ApiModelProperty(value = "MRP类型：0 无、1 MPS，2 MRP")
    private Integer mrp;

    @ApiModelProperty(value = "业务关闭：0未关闭、1关闭")
    private Integer mrpClosed;

    @ApiModelProperty(value = "使用部门ID")
    private Integer departmentId;

    @ApiModelProperty(value = "使用部门编号")
    private String departmentCode;

    @ApiModelProperty(value = "业务员ID")
    private Integer empId;

    @ApiModelProperty(value = "业务员编号")
    private String empCode;

    @ApiModelProperty(value = "主管ID（外键）")
    private Integer managerId;

    @ApiModelProperty(value = "主管编号")
    private String managerCode;

    @ApiModelProperty(value = "审核人ID（登陆）")
    private Integer checkerId;

    @ApiModelProperty(value = "审核人名称")
    private String checkerName;

    @ApiModelProperty(value = "审核时间")
    private Date checkTime;

    @ApiModelProperty(value = "创建人")
    private Integer createId;

    @ApiModelProperty(value = "创建人名称")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private Integer updateId;

    @ApiModelProperty(value = "修改人名称")
    private String updateName;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "0无效，1有效，默认1")
    private Integer isValid;

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "源单号（生产订单号）")
    private String sourceCode;

    @ApiModelProperty(value = "公司ID")
    private Integer companyId;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "源单号ID（关联表单）")
    private String sourceId;

    @ApiModelProperty(value = "供应商全称")
    private String supplierFullName;

    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;

    @ApiModelProperty(value = "供应商id")
    private Integer supplierId;


    @ApiModelProperty("明细数据")
    private List<MesPurchaseBuyRequestListInsertDTO> list;


}

package com.bpm.mes.purchase.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购申请单主表(MesPurchaseBuyRequest)实体类
 *
 * @author renruiling
 * @since 2022-04-28 16:40:42
 */
@Data
@ApiModel(value = "MesPurchaseBuyRequest")
public class MesPurchaseBuyRequest implements Serializable {
    private static final long serialVersionUID = 990768901851200990L;
    /**
     * 单据编号（PB+8位年月日+0001）
     */
    @ApiModelProperty(value = "单据编号（PB+8位年月日+0001）")
    private String buyRequestCode;
    /**
     * 单据日期（YYYY-MM-DD）
     */
    @ApiModelProperty(value = "单据日期（YYYY-MM-DD）")
    private Date date;
    /**
     * 申请人ID（外键，员工）
     */
    @ApiModelProperty(value = "申请人ID（外键，员工） ")
    private Integer requesterId;
    /**
     * 申请人ID姓名
     */
    @ApiModelProperty(value = "申请人ID姓名")
    private String requesterName;
    /**
     * 业务类型：1采购入库、2样品采购、3订单委外、(数据字典维护)
     */
    @ApiModelProperty(value = "业务类型：1采购入库、2样品采购、3订单委外、(数据字典维护)")
    private String bussinessType;
    /**
     * 计划类别：1 标准
     */
    @ApiModelProperty(value = "计划类别：1 标准")
    private String planType;
    /**
     * 源单类型：0无、1销售订单、2采购计划（MRP运算 ）
     */
    @ApiModelProperty(value = "源单类型：0无、1销售订单、2采购计划（MRP运算 ）")
    private String sourceType;
    /**
     * 状态：0草稿、1已申请，2已接收、3待审核、4已审核
     */
    @ApiModelProperty(value = "状态：0草稿、1已申请，2已接收、3待审核、4已审核")
    private String state;
    /**
     * MRP类型：0 无、1 MPS，2 MRP
     */
    @ApiModelProperty(value = "MRP类型：0 无、1 MPS，2 MRP")
    private String mrp;
    /**
     * 业务关闭：0未关闭、1关闭
     */
    @ApiModelProperty(value = "业务关闭：0未关闭、1关闭")
    private String mrpClosed;
    /**
     * 使用部门ID
     */
    @ApiModelProperty(value = "使用部门ID")
    private Integer departmentId;
    /**
     * 使用部门编号
     */
    @ApiModelProperty(value = "使用部门编号")
    private Integer departmentCode;
    /**
     * 业务员ID
     */
    @ApiModelProperty(value = "业务员ID")
    private Integer empId;
    /**
     * 业务员编号
     */
    @ApiModelProperty(value = "业务员编号")
    private Integer empCode;
    /**
     * 主管ID（外键）
     */
    @ApiModelProperty(value = "主管ID（外键）")
    private Integer managerId;
    /**
     * 主管编号
     */
    @ApiModelProperty(value = "主管编号")
    private Integer managerCode;
    /**
     * 审核人ID（登陆）
     */
    @ApiModelProperty(value = "审核人ID（登陆）")
    private Integer checkerId;
    /**
     * 审核人名称
     */
    @ApiModelProperty(value = "审核人名称")
    private String checkerName;
    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private Date checkTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
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
     * 源单号（生产订单号）
     */
    @ApiModelProperty(value = "源单号（生产订单号）")
    private String sourceCode;
    /**
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private Integer companyId;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    /**
     * 源单号ID（关联表单）
     */
    @ApiModelProperty(value = "源单号ID（关联表单）")
    private String sourceId;
    /**
     * 供应商全称
     */
    @ApiModelProperty(value = "供应商全称")
    private String supplierFullName;
    /**
     * 供应商编码
     */
    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;

}


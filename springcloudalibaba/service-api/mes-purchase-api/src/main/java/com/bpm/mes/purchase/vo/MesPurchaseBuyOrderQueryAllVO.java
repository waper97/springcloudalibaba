package com.bpm.mes.purchase.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MesPurchaseBuyOrderQueryAllVO {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "采购订单编号（PO+8位年月日+0001）")
    private String buyOrderCode;

    @ApiModelProperty(value = "日期（YYYY-MM-DD）")
    private Date date;

    @ApiModelProperty(value = "供应商ID（主键）")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商全称")
    private String supplierFullName;

    @ApiModelProperty(value = "采购方式：赊购、现购、受托入库、直运采购")
    private Integer postyle;

    @ApiModelProperty(value = "采购范围：赊销、调拨")
    private Integer areaPs;

    @ApiModelProperty(value = "计划类型：1 标准")
    private Integer planCategory;

    @ApiModelProperty(value = "交货地点：空")
    private String fetchAdd;

    @ApiModelProperty(value = "结算日期：有数据")
    private Date settleDate;

    @ApiModelProperty(value = "结算方式：1信用天数 、1月结")
    private Integer settleId;

    @ApiModelProperty(value = "分销订单号")
    private String poordBillNo;

    @ApiModelProperty(value = "源单类型（关联表单） 0手工录入、1计划订单、2采购申请单")
    private String sourceType;

    @ApiModelProperty(value = "打印次数 0")
    private Integer printCount;

    @ApiModelProperty(value = "供应商退回意见")
    private String supplierMemo;

    @ApiModelProperty(value = "状态：1 新增，2已审核，3已下达，4已接收，5 已配送，6已入库，9已完成")
    private Integer state;

    @ApiModelProperty(value = "下达人ID（登陆）")
    private String issueId;

    @ApiModelProperty(value = "下达人名称")
    private String issuerName;

    @ApiModelProperty(value = "下达时间")
    private Date issueTime;

    @ApiModelProperty(value = "接收人ID（登陆）")
    private String accepterId;

    @ApiModelProperty(value = "接收人名称")
    private String accepterName;

    @ApiModelProperty(value = "接收时间")
    private Date acceptTime;

    @ApiModelProperty(value = "是否关闭：0否，1是")
    private Integer closed;

    @ApiModelProperty(value = "关闭时间")
    private Date closeDate;

    @ApiModelProperty(value = "关闭人")
    private String closerId;

    @ApiModelProperty(value = "关闭人姓名")
    private String closerName;
    /**
     * 关闭原因：系统自动关闭，手动关闭
     */
    @ApiModelProperty(value = "关闭原因：系统自动关闭，手动关闭")
    private String closeCauses;
    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    private String departmentId;
    /**
     * 部门编号
     */
    @ApiModelProperty(value = "部门编号")
    private String departmentNo;
    /**
     * 业务员ID
     */
    @ApiModelProperty(value = "业务员ID")
    private String empId;
    /**
     * 业务员编号
     */
    @ApiModelProperty(value = "业务员编号")
    private String empNo;
    /**
     * 主管ID（外键）
     */
    @ApiModelProperty(value = "主管ID（外键）")
    private String managerId;
    /**
     * 主管编号
     */
    @ApiModelProperty(value = "主管编号")
    private String managerNo;
    /**
     * 审核人ID（登陆）
     */
    @ApiModelProperty(value = "审核人ID（登陆）")
    private String checkerId;
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
    private String createId;
    /**
     * 创建名称
     */
    @ApiModelProperty(value = "创建名称")
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
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private String companyId;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "源单号")
    private String sourceCode;
    @ApiModelProperty(value = "明细表")
    private List<MesPurchaseBuyOrderListQueryByIdVO> list;
}

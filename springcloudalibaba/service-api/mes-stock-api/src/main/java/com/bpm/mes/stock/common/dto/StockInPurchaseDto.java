package com.bpm.mes.stock.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 仓库出入库主表(MesWmsStockinout)实体类
 *
 * @author makejava
 * @since 2022-04-22 16:12:51
 */
@Data
@ApiModel(value = "MesWmsStockinout")
public class StockInPurchaseDto {

//    /**
//     * 出入库操作类型ID（外键）SAP：移动类型 入库类型
//     */
//    @ApiModelProperty(value = "出入库操作类型ID（外键）SAP：移动类型 入库类型")
//    private Integer inOutTypeId;
//    /**
//     * 出入库操作类型编码
//     */
//    @ApiModelProperty(value = "出入库操作类型编码")
//    private String inOutTypeCode;
    /**
     * 单据标识（上面映射表，如:CIN）（出入库操作类型带入）
     */

    /**
     * 半成品入库：BIN
     * 成品入库：DIN
     * 领料出库：SOUT
     */
    @ApiModelProperty(value = "单据标识（上面映射表，如:CIN）（出入库操作类型带入）")
    private String billCode;
//    /**
//     * 供应商id 采购（委外）入库时用
//     */
    @ApiModelProperty(value = "供应商id 采购（委外）入库时用 -采购")
    private Integer suppliarId;
    /**
     * 供应商编码
     */
    @ApiModelProperty(value = "供应商编码-采购")
    private String suppliarCode;
    /**
     * 供应商名称
     */
    @ApiModelProperty(value = "供应商名称-采购")
    private String suppliarName;
    /**
     * 客户ID（外键）销售发货时用
     */
//    @ApiModelProperty(value = "客户ID（外键）销售发货时用")
//    private Integer clientId;
//    /**
//     * 客户Code
//     */
//    @ApiModelProperty(value = "客户Code")
//    private String clientCode;
//    /**
//     * 客户名称
//     */
//    @ApiModelProperty(value = "客户名称")
//    private String clientName;
//    /**
//     * 库管员ID（EMPID），多个用“，”分隔
//     */
//    @ApiModelProperty(value = "库管员ID（EMPID），多个用“，”分隔")
//    private String stockManagerId;
//    /**
//     * 库管员编号，多个用“，”分隔
//     */
//    @ApiModelProperty(value = "库管员编号，多个用“，”分隔")
//    private String stockManagerCode;
//    /**
//     * 库管员姓名多个用“，”分隔
//     */
//    @ApiModelProperty(value = "库管员姓名多个用“，”分隔")
//    private String stockManagerName;
//    /**
//     * 验收人ID
//     */
//    @ApiModelProperty(value = "验收人ID")
//    private Integer inspectId;
//    /**
//     * 验收人编码
//     */
//    @ApiModelProperty(value = "验收人编码")
//    private String inspectCode;
//    /**
//     * 验收人名称
//     */
//    @ApiModelProperty(value = "验收人名称")
//    private String inspectName;
//    /**
//     * 收付款日期
//     */
//    @ApiModelProperty(value = "收付款日期 ")
//    private LocalDateTime settleDate;
//    /**
//     * 会计年度YYYY
//     */
//    @ApiModelProperty(value = "会计年度YYYY")
//    private String year;
//    /**
//     * 会计周期MM 本系统存上，查询统计方便
//     */
//    @ApiModelProperty(value = "会计周期MM 本系统存上，查询统计方便")
//    private String period;
//    /**
//     * 币别ID
//     */
//    @ApiModelProperty(value = "币别ID")
//    private Integer currencyId;
//    /**
//     * 币别编码
//     */
//    @ApiModelProperty(value = "币别编码")
//    private String currencyCode;
//    /**
//     * 汇率
//     */
//    @ApiModelProperty(value = "汇率")
//    private BigDecimal exchangeRate;
    /**
     * 仓库id 调拨分成出入2条记录
     */
    @ApiModelProperty(value = "仓库id 调拨分成出入2条记录")
    private Integer stockId;
    /**
     * 库区库位ID（外键）
     */
    @ApiModelProperty(value = "库区库位ID（外键）")
    private Integer stockPlaceId;
//    /**
//     * 仓库编码
//     */
//    @ApiModelProperty(value = "仓库编码")
//    private String stockCode;
//    /**
//     * 仓库名称
//     */
//    @ApiModelProperty(value = "仓库名称")
//    private String stockName;
//    /**
//     * 倒冲标志   0 非倒冲、1倒冲
//     */
//    @ApiModelProperty(value = "倒冲标志   0 非倒冲、1倒冲")
//    private String backFlushed;
//    /**
//     * 收货单位ID
//     */
//    @ApiModelProperty(value = "收货单位ID")
//    private Integer clientIdReceive;
//    /**
//     * 收货单位编码
//     */
//    @ApiModelProperty(value = "收货单位编码")
//    private String clientCodeReceive;
//    /**
//     * 收货单位全称
//     */
//    @ApiModelProperty(value = "收货单位全称")
//    private String clientNameReceive;
//    /**
//     * 收件人地址
//     */
//    @ApiModelProperty(value = "收件人地址")
//    private String receiveAddress;
//    /**
//     * 联系电话
//     */
//    @ApiModelProperty(value = "联系电话")
//    private String phone;
//    /**
//     * 发货人ID（外键，员工）
//     */
//    @ApiModelProperty(value = "发货人ID（外键，员工）")
//    private Integer fManagerId;
//    /**
//     * 发货人编号
//     */
//    @ApiModelProperty(value = "发货人编号")
//    private String fManagerCode;
//    /**
//     * 发货人名称
//     */
//    @ApiModelProperty(value = "发货人名称")
//    private String fManagerName;
//    /**
//     * 销售方式：1现销、2赊销、3直运销售、4受托代销、5委托代销、6分期收款销售
//     */
//    @ApiModelProperty(value = "销售方式：1现销、2赊销、3直运销售、4受托代销、5委托代销、6分期收款销售")
//    private String saleType;
//    /**
//     * 采购方式：1 现购、2赊销
//     */
//    @ApiModelProperty(value = "采购方式：1 现购、2赊销")
//    private String postyle;
    /**
     * 源单类型（关联表单）1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表
     */
    @ApiModelProperty(value = "源单类型（关联表单）1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表")
    private String sourceType; // 2
    /**
     * 源单号ID（关联表单）
     */
    @ApiModelProperty(value = "源单号ID（关联表单）")
    private Integer sourceId; // 生产主键id
    /**
     * 源单号（关联表单）
     */
    @ApiModelProperty(value = "源单号（关联表单）")
    private String sourceCode; // 主键编号

//    // TODO:后面再问
//    /**
//     * 部门id
//     */
//    @ApiModelProperty(value = "部门id")
//    private Integer departmentId;
//    /**
//     * 部门编码
//     */
//    @ApiModelProperty(value = "部门编码")
//    private String departmentCode;
//    /**
//     * 部门名称
//     */
//    @ApiModelProperty(value = "部门名称")
//    private String departmentName;
//    /**
//     * 业务员id
//     */
//    @ApiModelProperty(value = "业务员id")
//    private Integer empId;
//    /**
//     * 业务员编号
//     */
//    @ApiModelProperty(value = "业务员编号")
//    private String empCode;
//    /**
//     * 业务员名称
//     */
//    @ApiModelProperty(value = "业务员名称")
//    private String empName;
//    /**
//     * 主管id
//     */
//    @ApiModelProperty(value = "主管id")
//    private Integer managerId;
//    /**
//     * 主管编号
//     */
//    @ApiModelProperty(value = "主管编号")
//    private String managerCode;
//    /**
//     * 主管名称
//     */
//    @ApiModelProperty(value = "主管名称")
//    private String managerName;
//    /**
//     * 采购（销售）订单ID（外键）
//     */
//    @ApiModelProperty(value = "采购（销售）订单ID（外键）")
//    private Integer orderId;
//    /**
//     * 采购（销售）订单编号
//     */
//    @ApiModelProperty(value = "采购（销售）订单编号")
//    private String orderCode;
//    /**
//     * 生产任务ID（外键）
//     */
//    @ApiModelProperty(value = "生产任务ID（外键）")
//    private Integer taskId;
//    /**
//     * 生产任务编码
//     */
//    @ApiModelProperty(value = "生产任务编码")
//    private String taskCode;
//    /**
//     * 组织编码ID（外键）
//     */
//    @ApiModelProperty(value = "组织编码ID（外键）")
//    private Integer organizationId;
//    /**
//     * 组织编码
//     */
//    @ApiModelProperty(value = "组织编码")
//    private String organizationCode;
//    /**
//     * 组织名称
//     */
//    @ApiModelProperty(value = "组织名称")
//    private String organizationName;
    /**
     * 创建人ID
     */
    @ApiModelProperty(value = "创建人ID")
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
    private LocalDateTime createTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 单据日期SAP：凭证日期，不集成
     */
    @ApiModelProperty(value = "单据日期SAP：凭证日期，不集成")
    private String inoutDate; // 当前日期 yyy-MM-dd
    /**
     * 过账日期
     */
    @ApiModelProperty(value = "过账日期")
    private String inoutPostingDate; // 当前日期 yyy-MM-dd
//    /**
//     * 出入库类型名称
//     */
//    @ApiModelProperty(value = "出入库类型名称")
//    private String inOutTypeName;
//    /**
//     * 公司ID
//     */
//    @ApiModelProperty(value = "公司ID")
//    private Integer companyId;
//    /**
//     * 公司编码
//     */
//    @ApiModelProperty(value = "公司编码")
//    private String companyCode;
//    /**
//     * 公司简称
//     */
//    @ApiModelProperty(value = "公司简称")
//    private String companyName;
//    /**
//     * 收件人
//     */
//    @ApiModelProperty(value = "收件人")
//    private String consigner;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private BigDecimal qty;

//    @ApiModelProperty(value = "收货单id")
//    private Integer buyAcceptId;

    @ApiModelProperty(value = "明细表数据")
    private List<StockInPurchaseListDto> listDtos;


}


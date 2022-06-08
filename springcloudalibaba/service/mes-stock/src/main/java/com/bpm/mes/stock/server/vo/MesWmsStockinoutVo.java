package com.bpm.mes.stock.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 仓库出入库主表(MesWmsStockinout)实体类
 *
 * @author makejava
 * @since 2022-04-22 16:12:51
 */
@Data
public class MesWmsStockinoutVo{

        @ApiModelProperty(value = "收货单id")
        private Integer buyAcceptId;
        @ApiModelProperty(value = "收货单编码")
        private String buyAcceptCode;
        @ApiModelProperty(value = "供应商id 采购（委外）入库时用")
        private Integer suppliarId;
        @ApiModelProperty(value = "供应商编码")
        private String suppliarCode;
        @ApiModelProperty(value = "供应商名称")
        private String suppliarName;
//        @ApiModelProperty(value = "客户ID（外键）销售发货时用")
//        private Integer clientId;
//        @ApiModelProperty(value = "客户Code")
//        private String clientCode;
//        @ApiModelProperty(value = "客户名称")
//        private String clientName;
//        @ApiModelProperty(value = "币别ID")
//        private Integer currencyId;
//        @ApiModelProperty(value = "币别编码")
//        private String currencyCode;
//        @ApiModelProperty(value = "汇率")
//        private BigDecimal exchangeRate;
        @ApiModelProperty(value = "仓库id 调拨分成出入2条记录")
        private Integer stockId;
        @ApiModelProperty(value = "仓库编码")
        private String stockCode;
        @ApiModelProperty(value = "仓库名称")
        private String stockName;
//        @ApiModelProperty(value = "收货单位ID")
//        private Integer clientIdReceive;
//        @ApiModelProperty(value = "收货单位编码")
//        private String clientCodeReceive;
//        @ApiModelProperty(value = "收货单位全称")
//        private String clientNameReceive;
//        @ApiModelProperty(value = "收件人")
//        private String consigner;
//        @ApiModelProperty(value = "收件人地址")
//        private String receiveAddress;
//        @ApiModelProperty(value = "联系电话")
//        private String phone;
//        @ApiModelProperty(value = "采购方式：1 现购、2赊销")
//        private String postyle;
        @ApiModelProperty(value = "源单类型（关联表单）1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表")
        private String sourceType;
        @ApiModelProperty(value = "源单类型名称")
        private String sourceTypeName;
        @ApiModelProperty(value = "源单号ID（关联表单）")
        private Integer sourceId;
        @ApiModelProperty(value = "源单号（关联表单）")
        private String sourceCode;
//        @ApiModelProperty(value = "部门id")
//        private Integer departmentId;
//        @ApiModelProperty(value = "部门编码")
//        private String departmentCode;
//        @ApiModelProperty(value = "部门名称")
//        private String departmentName;
//        @ApiModelProperty(value = "业务员id")
//        private Integer empId;
//        @ApiModelProperty(value = "业务员编号")
//        private String empCode;
//        @ApiModelProperty(value = "业务员名称")
//        private String empName;
//        @ApiModelProperty(value = "主管id")
//        private Integer managerId;
//        @ApiModelProperty(value = "主管编号")
//        private String managerCode;
//        @ApiModelProperty(value = "主管名称")
//        private String managerName;
//        @ApiModelProperty(value = "采购（销售）订单ID（外键）")
//        private Integer orderId;
//        @ApiModelProperty(value = "采购（销售）订单编号")
//        private String orderCode;
//        @ApiModelProperty(value = "生产任务ID（外键）")
//        private Integer taskId;
//        @ApiModelProperty(value = "生产任务编码")
//        private String taskCode;
        @ApiModelProperty(value = "明细表数据")
        private List<MesWmsStockinoutListVo> listVos;


}


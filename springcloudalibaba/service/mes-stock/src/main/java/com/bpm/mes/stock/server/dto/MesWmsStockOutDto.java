package com.bpm.mes.stock.server.dto;

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
public class MesWmsStockOutDto {
        private Integer id;
        /**
         * 出入库操作类型ID（外键）SAP：移动类型 入库类型
         */
        @ApiModelProperty(value = "出入库操作类型ID（外键）SAP：移动类型 入库类型")
        private Integer inOutTypeId;
        /**
         * 出入库操作类型编码
         */
//        @ApiModelProperty(value = "出入库操作类型编码")
//        private String inOutTypeCode;
        /**
         * 供应商id 采购（委外）入库时用
         */
        @ApiModelProperty(value = "供应商id 采购（委外）入库时用")
        private Integer suppliarId;
        /**
         * 供应商编码
         */
//        @ApiModelProperty(value = "供应商编码")
//        private String suppliarCode;
//        /**
//         * 供应商名称
//         */
//        @ApiModelProperty(value = "供应商名称")
//        private String suppliarName;
        /**
         * 收货单位ID
         */
//        @ApiModelProperty(value = "收货单位ID")
//        private Integer clientIdReceive;
//        /**
//         * 收货单位编码
//         */
//        @ApiModelProperty(value = "收货单位编码")
//        private String clientCodeReceive;
//        /**
//         * 收货单位全称
//         */
//        @ApiModelProperty(value = "收货单位全称")
//        private String clientNameReceive;
        /**
         * 源单类型（关联表单）1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表
         */
        @ApiModelProperty(value = "源单类型（关联表单）1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表")
        private String sourceType;
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
        /**
         * 部门id
         */
        @ApiModelProperty(value = "部门id")
        private Integer departmentId;
        /**
         * 客户id
         */
        @ApiModelProperty(value = "客户id")
        private Integer clientId;
        /**
         * 部门编码
         */
//        @ApiModelProperty(value = "部门编码")
//        private String departmentCode;
        /**
         * 采购（销售）订单ID（外键）
         */
//        @ApiModelProperty(value = "采购（销售）订单ID（外键）")
//        private Integer orderId;
        /**
         * 采购（销售）订单编号
         */
//        @ApiModelProperty(value = "采购（销售）订单编号")
//        private String orderCode;
        /**
         * 生产任务ID（外键）
         */
//        @ApiModelProperty(value = "生产任务ID（外键）")
//        private Integer taskId;
        /**
         * 生产任务编码
         */
//        @ApiModelProperty(value = "生产任务编码")
//        private String taskCode;
        /**
         * 单据日期SAP：凭证日期，不集成
         */
        @ApiModelProperty(value = "单据日期SAP：凭证日期，不集成")
        private String inoutDate;
        /**
         * 过账日期
         */
        @ApiModelProperty(value = "过账日期")
        private String inoutPostingDate;

        /**
         * 创建人ID
         */
        @ApiModelProperty(value = "创建人ID")
        private Integer currentloginId;
        /**
         * 创建人名称
         */
        @ApiModelProperty(value = "创建人名称")
        private String currentloginName;

        /**
         * 仓库id 调拨分成出入2条记录
         */
        @ApiModelProperty(value = "仓库id 调拨分成出入2条记录")
        private Integer stockId;

        @ApiModelProperty(value = "入库子表信息")
        private List<MesWmsStockinoutlistDto> listDtos;

}


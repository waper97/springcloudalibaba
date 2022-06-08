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
public class MesWmsStockinoutDto{
        private Integer id;
        /**
         * 出入库操作类型ID（外键）SAP：移动类型 入库类型
         */
        @ApiModelProperty(value = "出入库操作类型ID（外键）SAP：移动类型 入库类型")
        private Integer inOutTypeId;
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
         * 单据标识（上面映射表，如:CIN）（出入库操作类型带入）
         */
        @ApiModelProperty(value = "单据标识（上面映射表，如:CIN）（出入库操作类型带入）")
        private String billCode;
        /**
         * 供应商id 采购（委外）入库时用
         */
        @ApiModelProperty(value = "供应商id 采购（委外）入库时用")
        private Integer suppliarId;
        /**
         * 部门id
         */
        @ApiModelProperty(value = "部门id")
        private Integer departmentId;
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

        @ApiModelProperty(value = "收货单id")
        private Integer buyAcceptId;

        @ApiModelProperty(value = "入库子表信息")
        private List<MesWmsStockinoutlistDto> listDtos;

}


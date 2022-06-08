package com.bpm.mes.stock.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 仓库出入库主表(MesWmsStockinout)实体类
 *
 * @author makejava
 * @since 2022-04-22 16:12:51
 */
@Data
@ApiModel(value = "MesWmsStockinout")
public class MesWmsStockinoutListVo {

    @ApiModelProperty(value = "存放物料ID（外键）")
    private Integer materialId;
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    @ApiModelProperty(value = "物料名称  ")
    private String materialShortName;
    @ApiModelProperty(value = "物料规格 ")
    private String materialSpec;
    @ApiModelProperty(value = "计量单位（外键）")
    private Integer unitsId;
    @ApiModelProperty(value = "计量单位名称（外键）")
    private String unitsName;
    @ApiModelProperty(value = "仓库id 调拨分成出入2条记录")
    private Integer stockId;
    @ApiModelProperty(value = "仓库编码")
    private String stockCode;
    @ApiModelProperty(value = "仓库名称")
    private String stockName;
    @ApiModelProperty(value = "计划数量")
    private BigDecimal fPallet;
    @ApiModelProperty(value = "实际数量")
    private BigDecimal fFinished;
//    @ApiModelProperty(value = "退货数量")
//    private BigDecimal backQty;
//    @ApiModelProperty(value = "不含税单价")
//    private BigDecimal price;
//    @ApiModelProperty(value = "不含税金额")
//    private BigDecimal amount;
//    @ApiModelProperty(value = "保质期（天）")
//    private Integer kFPeriod;
//    @ApiModelProperty(value = "生产/采购日期 YYYY-MM-DD")
//    private String kFDate;
//    @ApiModelProperty(value = "有效期（到期日）YYYY-MM-DD")
//    private String periodDate;
    @ApiModelProperty(value = "源单类型（关联表单）1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表")
    private String sourceType;
    @ApiModelProperty(value = "源单号ID（关联表单）")
    private Integer sourceId;
    @ApiModelProperty(value = "源单号（关联表单）")
    private String sourceCode;
    @ApiModelProperty(value = "源单明细ID")
    private Integer sourceListId;
//    @ApiModelProperty(value = "采购（销售）订单ID（外键）")
//    private Integer orderId;
//    @ApiModelProperty(value = "采购（销售）订单编号")
//    private String orderCode;
//    @ApiModelProperty(value = "采购（销售）订单明细ID（ 外键）")
//    private Integer orderListId;
//    @ApiModelProperty(value = "生产任务ID（外键）")
//    private Integer taskId;
//    @ApiModelProperty(value = "生产任务编码")
//    private String taskCode;
//    @ApiModelProperty(value = "任务投料明细ID（ 外键）")
//    private Integer taskListId;
//    @ApiModelProperty(value = "备注")
//    private String remark;
//    @ApiModelProperty(value = "入库批次号")
//    private String inBatchNo;
//    @ApiModelProperty(value = "生产批次号")
//    private String batchNo;
    @ApiModelProperty(value = "库区库位ID（外键）")
    private Integer stockPlaceId;
    @ApiModelProperty(value = "库位编码")
    private String stockPlaceCode;
    @ApiModelProperty(value = "库位名称")
    private String stockPlaceName;
//    @ApiModelProperty(value = "唯一码 如果是一车一车， 如果是一天每个供应商分配")
//    private String barCode;
    @ApiModelProperty(value = "收货单明细id")
    private Integer buyAcceptListId;

}


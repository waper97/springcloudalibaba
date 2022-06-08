package com.bpm.mes.stock.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 仓库调拨明细表(MesWmsStockpolist)实体类
 *
 * @author makejava
 * @since 2022-04-21 15:07:24
 */
@Data
@ApiModel(value = "MesWmsStockpolist")
public class MesWmsStockpolist implements Serializable {
    private static final long serialVersionUID = -78518883122376982L;

    private Integer id;
    /**
     * 仓库调拨单主表ID（外键）
     */
    @ApiModelProperty(value = "仓库调拨单主表ID（外键）")
    private Integer stockPoId;
    /**
     * 调拨单号（PO+年月日+4流水号）
     */
    @ApiModelProperty(value = "调拨单号（PO+年月日+4流水号）")
    private String stockPoCode;
    /**
     * 发出仓库ID（外键）
     */
    @ApiModelProperty(value = "发出仓库ID（外键）")
    private Integer outStockId;
    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String outStockCode;
    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private String outStockName;
    /**
     * 收入仓库ID（外键）
     */
    @ApiModelProperty(value = "收入仓库ID（外键）")
    private Integer inStockId;
    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String inStockCode;
    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private String inStockName;
    /**
     * 存放物料ID（外键）
     */
    @ApiModelProperty(value = "存放物料ID（外键）")
    private Integer materialId;
    /**
     * 客户件号
     */
    @ApiModelProperty(value = "客户件号")
    private String customerCode;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称  ")
    private String materialShortName;
    /**
     * 物料规格
     */
    @ApiModelProperty(value = "物料规格 ")
    private String materialSpec;
    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String model;
    /**
     * 拨数量
     */
    @ApiModelProperty(value = "拨数量")
    private BigDecimal qty;
    /**
     * 调拨数量
     */
    @ApiModelProperty(value = "调拨数量")
    private BigDecimal allotQty;
    /**
     * 计划数量
     */
    @ApiModelProperty(value = "计划数量")
    private BigDecimal fPallet;
    /**
     * 实际数量
     */
    @ApiModelProperty(value = "实际数量")
    private BigDecimal fFinished;
    /**
     * 成功次数
     */
    @ApiModelProperty(value = "成功次数")
    private Integer fCount;
    /**
     * 计量单位（外键）
     */
    @ApiModelProperty(value = "计量单位（外键）")
    private Integer unitsId;
    /**
     * 状态：1新建；2部分分配；3完全分配；4部分拣货；5完全拣货；6部分收货；7完全收货；8完成；9关闭；
     */
    @ApiModelProperty(value = "状态：1新建；2部分分配；3完全分配；4部分拣货；5完全拣货；6部分收货；7完全收货；8完成；9关闭；")
    private String state;
    /**
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private Integer fCompanyId;
    /**
     * 公司编码
     */
    @ApiModelProperty(value = "公司编码")
    private String fEnCode;
    /**
     * 公司简称
     */
    @ApiModelProperty(value = "公司简称")
    private String fShortName;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 修改人人ID
     */
    @ApiModelProperty(value = "修改人人ID")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 0无效，1有效，默认1
     */
    @ApiModelProperty(value = "0无效，1有效，默认1")
    private String isValid;
    /**
     * 即时库存主表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）
     */
    @ApiModelProperty(value = "即时库存主表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）")
    private Integer stockCurrentSumId;
    /**
     * 即时库存明细表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）
     */
    @ApiModelProperty(value = "即时库存明细表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）")
    private Integer stockCurrentId;
    /**
     * 调出库区库位ID（外键）
     */
    @ApiModelProperty(value = "调出库区库位ID（外键）")
    private Integer outStockPlaceId;
    /**
     * 调出库位编码
     */
    @ApiModelProperty(value = "调出库位编码")
    private String outStockPlaceCode;
    /**
     * 调出库位名称
     */
    @ApiModelProperty(value = "调出库位名称")
    private String outStockPlaceName;
    /**
     * 调入库区库位ID（外键）
     */
    @ApiModelProperty(value = "调入库区库位ID（外键）")
    private Integer inStockPlaceId;
    /**
     * 调入库位编码
     */
    @ApiModelProperty(value = "调入库位编码")
    private String inStockPlaceCode;
    /**
     * 调入库位名称
     */
    @ApiModelProperty(value = "调入库位名称")
    private String inStockPlaceName;
    /**
     * 调入库位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String unitsName;
    /**
     * 调入库位名称
     */
    @ApiModelProperty(value = "批次")
    private String inBatchNo;
    /**
     * 调入库位名称
     */
    @ApiModelProperty(value = "生产批次")
    private String BatchNo;

    /**
     * 供应商id 采购（委外）入库时用
     */
    @ApiModelProperty(value = "供应商id 采购（委外）入库时用")
    private Integer suppliarId;
    /**
     * 供应商编码
     */
    @ApiModelProperty(value = "供应商编码")
    private String suppliarCode;
    /**
     * 供应商名称
     */
    @ApiModelProperty(value = "供应商名称")
    private String suppliarName;


}


package com.bpm.mes.stock.server.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 出入库批次记录表(MesWmsStockinoutbatch)实体类
 *
 * @author makejava
 * @since 2022-04-25 15:10:32
 */
@Data
public class StockCheeckExcel {

    /**
     * 盘点单号（PD+年月+4流水号）
     */
    @ApiModelProperty(value = "盘点单号")
    @Excel(name = "盘点单号")
    private String checkCode;
    /**
     * 盘点名称
     */
    @ApiModelProperty(value = "盘点名称")
    @Excel(name = "盘点名称")
    private String checkName;
    /**
     * 盘点日期，单据日期（YYYY-MM-DD）
     */
    @ApiModelProperty(value = "单据日期")
    @Excel(name = "单据日期")
    private String checkDate;
    /**
     * 过账日期
     */
    @ApiModelProperty(value = "过账日期")
    @Excel(name = "过账日期")
    private String checkPostingDate;
    /**
     * 盘点类型：1静态全面盘点、2动态库位盘点
     */
    @ApiModelProperty(value = "盘点类型")
    @Excel(name = "盘点类型")
    private String checkType;
    /**
     * 调账日期
     */
    @ApiModelProperty(value = "调账日期")
    @Excel(name = "调账日期")
    private String checkAccountDate;
    /**
     * 是否锁库
     */
    @ApiModelProperty(value = "是否锁库")
    @Excel(name = "是否锁库")
    private String isLock;
    /**
     * 仓库编码（盘点仓库）
     */
    @ApiModelProperty(value = "仓库编码")
    @Excel(name = "仓库编码")
    private String stockCode;
    /**
     * 仓库名称（盘点仓库）
     */
    @ApiModelProperty(value = "仓库名称")
    @Excel(name = "仓库名称")
    private String stockName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Excel(name = "备注")
    private String remark;
    /**
     * 状态：1新增 、2实盘 3、调账
     */
    @ApiModelProperty(value = "状态")
    @Excel(name = "状态")
    private String checkState;
    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称")
    @Excel(name = "创建人名称")
    private String createName;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间")
    private LocalDateTime createTime;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    @Excel(name = "物料编码")
    private String materialCode;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    @Excel(name = "物料名称")
    private String materialShortName;
    /**
     * 计量单位名称（外键）
     */
    @ApiModelProperty(value = "计量单位名称")
    @Excel(name = "单位")
    private String unitsName;
    /**
     * 供应商全称
     */
    @ApiModelProperty(value = "供应商")
    @Excel(name = "供应商")
    private String supplierName;
    /**
     * 入库批次号
     */
    @ApiModelProperty(value = "入库批次号")
    @Excel(name = "入库批次号")
    private String inBatchNo;
    /**
     * 库位编码
     */
    @ApiModelProperty(value = "库位编码")
    @Excel(name = "库位编码")
    private String stockPlaceCode;
    /**
     * 帐存数量，3位小数
     */
    @ApiModelProperty(value = "帐存数量")
    @Excel(name = "帐存数量")
    private BigDecimal accountNum;
    /**
     * 实盘数量，3位小数
     */
    @ApiModelProperty(value = "实盘数量")
    @Excel(name = "实盘数量")
    private BigDecimal checkNum;
    /**
     * 差异数量
     */
    @ApiModelProperty(value = "差异数量")
    @Excel(name = "差异数量")
    private BigDecimal differentNum;

    /**
     * 盘点单号（PD+年月+4流水号）
     */
    @ApiModelProperty(value = "盘点单号")
    @Excel(name = "盘点单明细id(不可删除)")
    private Integer stockCheckListId;

}


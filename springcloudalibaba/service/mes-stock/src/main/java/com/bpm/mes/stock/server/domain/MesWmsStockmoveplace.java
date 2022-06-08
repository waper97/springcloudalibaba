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
 * 仓库库位转移表(MesWmsStockmoveplace)实体类
 *
 * @author makejava
 * @since 2022-04-22 16:38:30
 */
@Data
@ApiModel(value = "MesWmsStockmoveplace")
public class MesWmsStockmoveplace implements Serializable {
    private static final long serialVersionUID = -99581994873005525L;

    private Integer id;
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
     * 仓库id
     */
    @ApiModelProperty(value = "仓库id")
    private Integer stockId;
    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String stockCode;
    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private String stockName;
    /**
     * 移出库位ID（外键）筒仓/库位
     */
    @ApiModelProperty(value = "移出库位ID（外键）筒仓/库位")
    private Integer stockPlaceIdSource;
    /**
     * 移出库位编码
     */
    @ApiModelProperty(value = "移出库位编码")
    private String stockPlaceCodeSource;
    /**
     * 移出库位名称
     */
    @ApiModelProperty(value = "移出库位名称")
    private String stockPlaceNameSource;
    /**
     * 目标库位ID（外键）筒仓/库位
     */
    @ApiModelProperty(value = "目标库位ID（外键）筒仓/库位")
    private Integer stockPlaceIdNew;
    /**
     * 目标库位编码
     */
    @ApiModelProperty(value = "目标库位编码")
    private String stockPlaceCodeNew;
    /**
     * 目标库位名称
     */
    @ApiModelProperty(value = "目标库位名称")
    private String stockPlaceNameNew;
    /**
     * 入库批次号
     */
    @ApiModelProperty(value = "入库批次号")
    private String inBatchNo;
    /**
     * 生产批次号
     */
    @ApiModelProperty(value = "生产批次号")
    private String batchNo;
    /**
     * 唯一码 如果是一车一车，如果是一天每个供应商分配
     */
    @ApiModelProperty(value = "唯一码 如果是一车一车，如果是一天每个供应商分配")
    private String barCode;
    /**
     * 存放物料ID（外键）
     */
    @ApiModelProperty(value = "存放物料ID（外键）")
    private Integer materialId;
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
     * 库存数量
     */
    @ApiModelProperty(value = "库存数量")
    private BigDecimal qty;
    /**
     * 分配数量
     */
    @ApiModelProperty(value = "分配数量")
    private BigDecimal qtyAllot;
    /**
     * 可用数量
     */
    @ApiModelProperty(value = "可用数量")
    private BigDecimal qtyUseable;
    /**
     * 冻结数量
     */
    @ApiModelProperty(value = "冻结数量")
    private BigDecimal qtyFreeze;
    /**
     * 供应商id
     */
    @ApiModelProperty(value = "供应商id")
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
    private String suppliarFullName;
    /**
     * 单据日期
     */
    @ApiModelProperty(value = "单据日期")
    private String movePlaceDate;
    /**
     * 经办人
     */
    @ApiModelProperty(value = "经办人")
    private String disposer;
    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;
    /**
     * 部门编码
     */
    @ApiModelProperty(value = "部门编码")
    private String departmentCode;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String departmentName;
    /**
     * 组织编码ID（外键）
     */
    @ApiModelProperty(value = "组织编码ID（外键）")
    private Integer organizationId;
    /**
     * 组织编码
     */
    @ApiModelProperty(value = "组织编码")
    private String organizationCode;
    /**
     * 组织名称
     */
    @ApiModelProperty(value = "组织名称")
    private String organizationName;
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
     * 过账日期
     */
    @ApiModelProperty(value = "过账日期")
    private String postingPlaceDate;
    /**
     * 仓库库位转移表状态 1新增 2审核
     */
    @ApiModelProperty(value = "仓库库位转移表状态 1新增 2审核")
    private String state;
    /**
     * 仓库库位转移类型 1不粮仓转
     */
    @ApiModelProperty(value = "仓库库位转移类型 1不粮仓转")
    private String moveType;
    /**
     * 移库单号
     */
    @ApiModelProperty(value = "移库单号")
    private String moveCode;
    /**
     * 计量单位（外键）
     */
    @ApiModelProperty(value = "计量单位（外键）")
    private String unitsId;
    /**
     * 计量单位名称（外键）
     */
    @ApiModelProperty(value = "计量单位名称（外键）")
    private String unitsName;
    /**
     * 经办人
     */
    @ApiModelProperty(value = "经办人id")
    private Integer disposerId;

}


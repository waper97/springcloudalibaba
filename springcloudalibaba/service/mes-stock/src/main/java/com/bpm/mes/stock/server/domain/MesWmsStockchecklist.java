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
 * 仓库盘点明细表(MesWmsStockchecklist)实体类
 *
 * @author makejava
 * @since 2022-04-29 15:04:46
 */
@Data
@ApiModel(value = "MesWmsStockchecklist")
public class MesWmsStockchecklist implements Serializable {
    private static final long serialVersionUID = -29680332462206699L;
    /**
     * 主键id（行号）
     */
    @ApiModelProperty(value = "主键id（行号）")
    private Integer id;
    /**
     * 盘点主表ID，外键
     */
    @ApiModelProperty(value = "盘点主表ID，外键")
    private Integer stockCheckId;
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
     * 库位ID
     */
    @ApiModelProperty(value = "库位ID")
    private Integer stockPlaceId;
    /**
     * 库位编码
     */
    @ApiModelProperty(value = "库位编码")
    private String stockPlaceCode;
    /**
     * 库位名称
     */
    @ApiModelProperty(value = "库位名称")
    private String stockPlaceName;
    /**
     * 入库批次号
     */
    @ApiModelProperty(value = "入库批次号")
    private String inBatchNo;
    /**
     * 生产批次号（批次）
     */
    @ApiModelProperty(value = "生产批次号（批次）")
    private String batchNo;
    /**
     * 唯一码（产品票）
     */
    @ApiModelProperty(value = "唯一码（产品票）")
    private String barCode;
    /**
     * 计量单位（外键）
     */
    @ApiModelProperty(value = "计量单位（外键）")
    private Integer unitsId;
    /**
     * 计量单位名称（外键）
     */
    @ApiModelProperty(value = "计量单位名称（外键）")
    private String unitsName;
    /**
     * 帐存数量，3位小数
     */
    @ApiModelProperty(value = "帐存数量，3位小数")
    private BigDecimal accountNum;
    /**
     * 实盘数量，3位小数
     */
    @ApiModelProperty(value = "实盘数量，3位小数")
    private BigDecimal checkNum;
    /**
     * 审核人ID（登陆人）
     */
    @ApiModelProperty(value = "审核人ID（登陆人）")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkerTime;
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
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private Integer companyId;
    /**
     * 公司编码
     */
    @ApiModelProperty(value = "公司编码")
    private String companyCode;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    /**
     * 供应商全称
     */
    @ApiModelProperty(value = "供应商全称")
    private String suppliarName;
    /**
     * 差异数量
     */
    @ApiModelProperty(value = "差异数量")
    private BigDecimal differentNum;
    /**
     * 供应商id
     */
    @ApiModelProperty(value = "供应商id")
    private Integer suppliarId;
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

}


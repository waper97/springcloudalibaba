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
 * 仓库即时库存明细表(MesWmsStockcurrent)实体类
 *
 * @author makejava
 * @since 2022-04-20 17:56:51
 */
@Data
@ApiModel(value = "MesWmsStockcurrent")
public class MesWmsStockcurrent implements Serializable {
    private static final long serialVersionUID = -17181566008335052L;
        
        private Integer id;
        /**
         * 即时库存主表ID（外键）
         */
        @ApiModelProperty(value = "即时库存主表ID（外键）")
        private Integer stockCurrentSumId;
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
         * 库位id
         */
        @ApiModelProperty(value = "库位id")
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
        private String suppliarName;
        /**
         * 存放物料ID（外键）
         */
        @ApiModelProperty(value = "存放物料ID（外键）")
        private Integer materialId;
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
         * 物料属性：0委外、1外购、2自制半成品、3自制产成品
         */
        @ApiModelProperty(value = "物料属性：0委外、1外购、2自制半成品、3自制产成品")
        private String materialTrId;
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
         * 入库/生产日期  本系统使用
         */
        @ApiModelProperty(value = "入库/生产日期  本系统使用")
        private String fkDate;
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
         * 唯一码 如果是一车一车， 如果是一天每个供应商分配
         */
        @ApiModelProperty(value = "唯一码 如果是一车一车， 如果是一天每个供应商分配")
        private String barCode;
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
         * 入库单ID
         */
        @ApiModelProperty(value = "入库单ID")
        private Integer stockInId;
        /**
         * 入库单明细ID
         */
        @ApiModelProperty(value = "入库单明细ID")
        private Integer stockInDetialId;
        /**
         * 出库单ID 多次出库时，最后一个出库单
         */
        @ApiModelProperty(value = "出库单ID 多次出库时，最后一个出库单")
        private Integer stockOutId;
        /**
         * 出库单明细ID 多次出库时，最后一个出库单
         */
        @ApiModelProperty(value = "出库单明细ID 多次出库时，最后一个出库单")
        private Integer stockOutDetialId;
        /**
         * 入库总数量
         */
        @ApiModelProperty(value = "入库总数量")
        private BigDecimal stockQty;
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
         * 物料编码
         */
        @ApiModelProperty(value = "物料编码")
        private String materialCode;
        /**
         * 仓库类型：1 原辅料仓、2线边仓、3半成品现场仓、4成品原辅料仓
         */
        @ApiModelProperty(value = "仓库类型：1 原辅料仓、2线边仓、3半成品现场仓、4成品原辅料仓")
        private String stockType;


}


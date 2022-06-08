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
 * 出入库批次记录表(MesWmsStockinoutbatch)实体类
 *
 * @author makejava
 * @since 2022-04-25 15:10:32
 */
@Data
@ApiModel(value = "MesWmsStockinoutbatch")
public class MesWmsStockinoutbatch implements Serializable {
    private static final long serialVersionUID = -87975919390695358L;
        
        private Integer id;
        /**
         * 出入库ID（外键
         */
        @ApiModelProperty(value = "出入库ID（外键")
        private Integer stockInOutId;
        /**
         * 单据编号
（Bill_Code +年月日+4流水）
         */
        @ApiModelProperty(value = "单据编号（Bill_Code +年月日+4流水）")
        private String stockInOutCode;
        /**
         * 出入库明细ID（外键）
         */
        @ApiModelProperty(value = "出入库明细ID（外键）")
        private Integer stockInOutDetailId;
        /**
         * 仓库id 调拨分成出入2条记录
         */
        @ApiModelProperty(value = "仓库id 调拨分成出入2条记录")
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
         * 分配id
         */
        @ApiModelProperty(value = "分配id")
        private Integer allotId;
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
         * 托盘ID
         */
        @ApiModelProperty(value = "托盘ID")
        private Integer trayId;
        /**
         * 托盘编码
         */
        @ApiModelProperty(value = "托盘编码")
        private String trayCode;
        /**
         * 物料ID（外键）
         */
        @ApiModelProperty(value = "物料ID（外键）")
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
         * 唯一码（设备备件出入库使用）
         */
        @ApiModelProperty(value = "唯一码（设备备件出入库使用）")
        private String barCode;
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
         * 数量
         */
        @ApiModelProperty(value = "数量")
        private BigDecimal qty;
        /**
         * 保质期（天）
         */
        @ApiModelProperty(value = "保质期（天）")
        private Integer kFPeriod;
        /**
         * 生产/采购日期 YYYY-MM-DD
         */
        @ApiModelProperty(value = "生产/采购日期 YYYY-MM-DD")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDateTime kFDate;
        /**
         * 有效期（到期日）YYYY-MM-DD
         */
        @ApiModelProperty(value = "有效期（到期日）YYYY-MM-DD")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDateTime periodDate;
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
        /**
         * 源单号（关联表单）
         */
        @ApiModelProperty(value = "源单号（关联表单）")
        private String sourceCode;
        /**
         * 入库单ID 出库时
         */
        @ApiModelProperty(value = "入库单ID 出库时")
        private Integer stockInId;
        /**
         * 入库单号        出库时
         */
        @ApiModelProperty(value = "入库单号        出库时")
        private String stockInCode;
        /**
         * 入库明细ID      出库时
         */
        @ApiModelProperty(value = "入库明细ID      出库时")
        private Integer stockInListId;
        /**
         * 出入库状态：1入库、2出库
         */
        @ApiModelProperty(value = "出入库状态：1入库、2出库")
        private String state;
        /**
         * 拣货状态：1未拣货，2已拣货
         */
        @ApiModelProperty(value = "拣货状态：1未拣货，2已拣货")
        private String pickingState;
        /**
         * 车牌号
         */
        @ApiModelProperty(value = "车牌号")
        private String carNum;
        /**
         * 客户id
         */
        @ApiModelProperty(value = "客户id")
        private Integer clientId;
        /**
         * 是否装车：1是、0否
         */
        @ApiModelProperty(value = "是否装车：1是、0否")
        private String isCar;
        /**
         * 采购开票申请单ID
         */
        @ApiModelProperty(value = "采购开票申请单ID")
        private Integer buyApplyInvoiceId;
        /**
         * 采购开票申请单明细ID
         */
        @ApiModelProperty(value = "采购开票申请单明细ID")
        private Integer buyApplyInvoiceListId;
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
         * 客户Code
         */
        @ApiModelProperty(value = "客户Code")
        private String clientCode;
        /**
         * 客户名称
         */
        @ApiModelProperty(value = "客户名称")
        private String clientName;
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


}


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
 * 仓库调拨批次表(MesWmsStockpobatch)实体类
 *
 * @author makejava
 * @since 2022-04-25 15:09:04
 */
@Data
@ApiModel(value = "MesWmsStockpobatch")
public class MesWmsStockpobatch implements Serializable {
    private static final long serialVersionUID = -84738018357974160L;
        
        private Integer id;
        /**
         * 仓库调拨单主表ID（外键）
         */
        @ApiModelProperty(value = "仓库调拨单主表ID（外键）")
        private Integer stockPoId;
        /**
         * 调拨单号
         */
        @ApiModelProperty(value = "调拨单号")
        private String stockPoCode;
        /**
         * 仓库调拨单明细ID
         */
        @ApiModelProperty(value = "仓库调拨单明细ID")
        private Integer stockPoListId;
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
         * 调出仓库ID（外键）
         */
        @ApiModelProperty(value = "调出仓库ID（外键）")
        private Integer outStockId;
        /**
         * 调出仓库编码
         */
        @ApiModelProperty(value = "调出仓库编码")
        private String outStockCode;
        /**
         * 调出仓库名称
         */
        @ApiModelProperty(value = "调出仓库名称")
        private String outStockName;
        /**
         * 调入仓库ID（外键）
         */
        @ApiModelProperty(value = "调入仓库ID（外键）")
        private Integer inStockId;
        /**
         * 调入仓库编码
         */
        @ApiModelProperty(value = "调入仓库编码")
        private String inStockCode;
        /**
         * 调入仓库名称
         */
        @ApiModelProperty(value = "调入仓库名称")
        private String inStockName;
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
         * 操作属性（1：入库；2：出库）
         */
        @ApiModelProperty(value = "操作属性（1：入库；2：出库）")
        private String inOutTypePropert;
        /**
         * 状态：出库，取消出库，入库，取消入库，
         */
        @ApiModelProperty(value = "状态：出库，取消出库，入库，取消入库，")
        private String state;
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
         * 客户ID（外键）销售发货时用
         */
        @ApiModelProperty(value = "客户ID（外键）销售发货时用")
        private Integer clientId;
        /**
         * 供应商Code
         */
        @ApiModelProperty(value = "供应商Code")
        private String clientCode;
        /**
         * 客户名称
         */
        @ApiModelProperty(value = "客户名称")
        private String clientName;
        /**
         * 收货单位ID（外键）
         */
        @ApiModelProperty(value = "收货单位ID（外键）")
        private Integer carrierId;
        /**
         * 收货单位名称
         */
        @ApiModelProperty(value = "收货单位名称")
        private String carrierName;
        /**
         * 车牌号
         */
        @ApiModelProperty(value = "车牌号")
        private String carNum;
        /**
         * 是否装车：1是、0否
         */
        @ApiModelProperty(value = "是否装车：1是、0否")
        private String isCar;
        /**
         * 公司ID
         */
        @ApiModelProperty(value = "公司ID")
        private String fCompanyId;
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


}


package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MesWmsStockPoListDto {

        @ApiModelProperty(value = "调拨主表主键ID")
        private Integer id;

        /**
         * 调拨类型：1 普通调拨，2 销售调拨
         */
        @ApiModelProperty(value = "调拨类型：1 普通调拨，2 销售调拨")
        private String poType;

        /**
         * 调出仓库ID（外键）
         */
        @ApiModelProperty(value = "调出仓库ID（外键）")
        private Integer outStockId;
        /**
         * 调出仓库编码
         */
//        @ApiModelProperty(value = "调出仓库编码")
//        private String outStockCode;
        /**
         * 调出仓库名称
         */
//        @ApiModelProperty(value = "调出仓库名称")
//        private String outStockName;
        /**
         * 调入仓库ID（外键）
         */
        @ApiModelProperty(value = "调入仓库ID（外键）")
        private Integer inStockId;
        /**
         * 调入仓库
         */
//        @ApiModelProperty(value = "调入仓库")
//        private String inStockCode;
        /**
         * 调入仓库
         */
//        @ApiModelProperty(value = "调入仓库")
//        private String inStockName;

        /**
         * 工单号
         */
        @ApiModelProperty(value = "工单号")
        private String workOrderCode;
        /**
         * 即时库存主表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）
         */
        @ApiModelProperty(value = "即时库存主表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）")
        private Integer stockCurrentSumId;

        /**
         * 日期（单据上的时间，所属会计期的依据（YYYY-MM-DD）
         */
        @ApiModelProperty(value = "单据日期（YYYY-MM-DD）")
        private String poBillDate;

        /**
         * 过账日期
         */
        @ApiModelProperty(value = "过账日期")
        private String poPostingDate;

        /**
         * 调出单位id
         */
        @ApiModelProperty(value = "调出单位id")
        private Integer outCompanyId;
        /**
         * 调出单位名称
         */
//        @ApiModelProperty(value = "调出单位名称")
//        private String outCompanyName;
        /**
         * 调入单位id
         */
        @ApiModelProperty(value = "调入单位id")
        private Integer inCompanyId;
        /**
         * 调入单位名称
         */
//        @ApiModelProperty(value = "调入单位名称")
//        private String inCompanyName;
        /**
         * 处理人
         */
        @ApiModelProperty(value = "处理人")
        private String disposer;

        @ApiModelProperty(value = "处理人id")
        private Integer disposerId;

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
         * 备注
         */
        @ApiModelProperty(value = "备注")
        private String remark;

        /**
         * 库位物料信息集合
         */
        @ApiModelProperty(value = "库位物料信息集合")
        private List<MesWmsStockPoPlaceListDto> stockPoPlaceListDtos;

}


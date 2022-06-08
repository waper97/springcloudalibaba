package com.bpm.mes.stock.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 仓库调拨单主表(MesWmsStockpo)实体类
 *
 * @author makejava
 * @since 2022-04-21 18:26:52
 */
@Data
@ApiModel(value = "MesWmsStockpo")
public class MesWmsStockpo implements Serializable {
    private static final long serialVersionUID = 619049108510084153L;

        private Integer id;
        /**
         * 单据编号（PO+年月日+4流水号）
         */
        @ApiModelProperty(value = "单据编号（PO+年月日+4流水号）")
        private String stockPoCode;
        /**
         * 会计年度YYYY
         */
        @ApiModelProperty(value = "会计年度YYYY")
        private String year;
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
         * 调入仓库
         */
        @ApiModelProperty(value = "调入仓库")
        private String inStockCode;
        /**
         * 调入仓库
         */
        @ApiModelProperty(value = "调入仓库")
        private String inStockName;
        /**
         * 客户ID（外键）销售发货时用
         */
        @ApiModelProperty(value = "客户ID（外键）销售发货时用")
        private Integer clientId;
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
         * 出库操作类型ID（外键）
         */
        @ApiModelProperty(value = "出库操作类型ID（外键）")
        private Integer outTypeId;
        /**
         * 出库单据编码（上面映射表，如:CIN）（仓库单据类型带入）
         */
        @ApiModelProperty(value = "出库单据编码（上面映射表，如:CIN）（仓库单据类型带入）")
        private String outBillCode;
        /**
         * 入库操作类型ID（外键）
         */
        @ApiModelProperty(value = "入库操作类型ID（外键）")
        private Integer inTypeId;
        /**
         * 入库单据编码（上面映射表，如:CIN）（仓库单据类型带入）
         */
        @ApiModelProperty(value = "入库单据编码（上面映射表，如:CIN）（仓库单据类型带入）")
        private String inBillCode;
        /**
         * 调拨类型：1 普通调拨，2 销售调拨
         */
        @ApiModelProperty(value = "调拨类型：1 普通调拨，2 销售调拨")
        private String poType;
        /**
         * 状态：1新建；2部分分配；3完全分配；4部分拣货；5完全拣货；6部分收货；7完全收货；8完成；9关闭；
         */
        @ApiModelProperty(value = "状态：1新建；2部分分配；3完全分配；4部分拣货；5完全拣货；6部分收货；7完全收货；8完成；9关闭；")
        private String state;
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
         * 业务员id
         */
        @ApiModelProperty(value = "业务员id")
        private Integer empId;
        /**
         * 业务员编号
         */
        @ApiModelProperty(value = "业务员编号")
        private String empCode;
        /**
         * 业务员名称
         */
        @ApiModelProperty(value = "业务员名称")
        private String empName;
        /**
         * 主管id
         */
        @ApiModelProperty(value = "主管id")
        private Integer managerId;
        /**
         * 主管编号
         */
        @ApiModelProperty(value = "主管编号")
        private String managerCode;
        /**
         * 主管名称
         */
        @ApiModelProperty(value = "主管名称")
        private String managerName;
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
         * 调出单位id
         */
        @ApiModelProperty(value = "调出单位id")
        private Integer outCompanyId;
        /**
         * 调出单位名称
         */
        @ApiModelProperty(value = "调出单位名称")
        private String outCompanyName;
        /**
         * 调入单位id
         */
        @ApiModelProperty(value = "调入单位id")
        private Integer inCompanyId;
        /**
         * 调入单位名称
         */
        @ApiModelProperty(value = "调入单位名称")
        private String inCompanyName;
        /**
         * 处理人
         */
        @ApiModelProperty(value = "处理人")
        private String disposer;
        /**
         * 会计周期MM
         */
        @ApiModelProperty(value = "会计周期MM")
        private String period;
        /**
         * 即时库存主表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）
         */
        @ApiModelProperty(value = "即时库存主表ID（外键），一个筒仓对应多条（每天一个批次，多天入一个筒仓）")
        private Integer stockCurrentSumId;
        /**
         * 工单号
         */
        @ApiModelProperty(value = "工单号")
        private String workOrderCode;
        /**
         * 日期（单据上的时间，所属会计期的依据（YYYYMM-DD）
         */
        @ApiModelProperty(value = "日期（单据上的时间，所属会计期的依据（YYYYMM-DD）")
        private String poBillDate;
        /**
         * 过账日期
         */
        @ApiModelProperty(value = "过账日期")
        private String poPostingDate;
        /**
         * 处理人
         */
        @ApiModelProperty(value = "处理人id")
        private Integer disposerId;
        /**
         * 回写SapId
         */
        @ApiModelProperty(value = "回写SapId")
        private Integer sapId;
        /**
         * 回写sap编码
         */
        @ApiModelProperty(value = "回写sap编码")
        private String sapCode;

}


package com.bpm.mes.stock.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 仓库盘点主表(MesWmsStockcheck)实体类
 *
 * @author makejava
 * @since 2022-04-29 16:17:15
 */
@Data
@ApiModel(value = "MesWmsStockcheck")
public class MesWmsStockcheck implements Serializable {
    private static final long serialVersionUID = 714572539340210915L;
        /**
         * 主表ID
         */
        @ApiModelProperty(value = "主表ID")
        private Integer id;
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
         * 仓库名称（盘点仓库）
         */
        @ApiModelProperty(value = "仓库名称（盘点仓库）")
        private String stockName;
        /**
         * 盘点单号（PD+年月+4流水号）
         */
        @ApiModelProperty(value = "盘点单号（PD+年月+4流水号）")
        private String checkCode;
        /**
         * 盘点名称
         */
        @ApiModelProperty(value = "盘点名称")
        private String checkName;
        /**
         * 盘点人姓名（多人用“，”分隔）
         */
        @ApiModelProperty(value = "盘点人姓名（多人用“，”分隔）")
        private String checker;
        /**
         * 盘点日期，单据日期（YYYY-MM-DD）
         */
        @ApiModelProperty(value = "盘点日期，单据日期（YYYY-MM-DD）")
        private String checkDate;
        /**
         * 所属年份（会计期间）
         */
        @ApiModelProperty(value = "所属年份（会计期间）")
        private String year;
        /**
         * 所属月份（会计期间）
         */
        @ApiModelProperty(value = "所属月份（会计期间）")
        private String month;
        /**
         * 计划开始日期（会计期间）
         */
        @ApiModelProperty(value = "计划开始日期（会计期间）")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime startDate;
        /**
         * 计划结束日期（会计期间）
         */
        @ApiModelProperty(value = "计划结束日期（会计期间）")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime endDate;
        /**
         * 盘点类型：1静态全面盘点、2动态库位盘点
         */
        @ApiModelProperty(value = "盘点类型：1静态全面盘点、2动态库位盘点")
        private String checkType;
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
         * 公司简称
         */
        @ApiModelProperty(value = "公司简称")
        private String companyName;
        /**
         * 是否锁库
         */
        @ApiModelProperty(value = "是否锁库")
        private String isLock;
        /**
         * 状态（备用）
         */
        @ApiModelProperty(value = "状态（备用）")
        private String state;
        /**
         * 状态：1新增 、2实盘 3、调账
         */
        @ApiModelProperty(value = "状态：1新增 、2实盘 3、调账")
        private String checkState;
        /**
         * 过账日期
         */
        @ApiModelProperty(value = "过账日期")
        private String checkPostingDate;
        /**
         * 调账日期
         */
        @ApiModelProperty(value = "调账日期")
        private String checkAccountDate;
        /**
         * 盘点库位ID(外键)要盘点的顶级库位
         */
        @ApiModelProperty(value = "盘点库位ID(外键)要盘点的顶级库位")
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


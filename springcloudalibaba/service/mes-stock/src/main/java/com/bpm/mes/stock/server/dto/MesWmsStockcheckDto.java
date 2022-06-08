package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 仓库盘点主表(MesWmsStockcheck)实体类
 *
 * @author makejava
 * @since 2022-04-29 10:01:50
 */
@Data
public class MesWmsStockcheckDto {
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
//        /**
//         * 盘点名称
//         */
//        @ApiModelProperty(value = "盘点名称")
//        private String checkName;
//        /**
//         * 盘点人姓名（多人用“，”分隔）
//         */
//        @ApiModelProperty(value = "盘点人id")
//        private String checker;
        /**
         * 盘点日期，单据日期（YYYY-MM-DD）
         */
        @ApiModelProperty(value = "盘点日期，单据日期（YYYY-MM-DD）")
        private String checkDate;
        /**
         * 计划开始日期（会计期间）
         */
        @ApiModelProperty(value = "计划开始日期（会计期间）")
        private LocalDateTime startDate;
        /**
         * 计划结束日期（会计期间）
         */
        @ApiModelProperty(value = "计划结束日期（会计期间）")
        private LocalDateTime endDate;
        /**
         * 盘点类型：1静态全面盘点、2动态库位盘点
         */
        @ApiModelProperty(value = "盘点类型：1静态全面盘点、2动态库位盘点")
        private String checkType;
        /**
         * 盘点库位ID(外键)要盘点的顶级库位
         */
        @ApiModelProperty(value = "盘点库位ID(外键)要盘点的顶级库位")
        private Integer stockPlaceId;
        /**
         * 备注
         */
        @ApiModelProperty(value = "备注")
        private String remark;
        /**
         * 是否锁库
         */
        @ApiModelProperty(value = "是否锁库")
        private String isLock;
        /**
         * 记账日期
         */
        @ApiModelProperty(value = "记账日期")
        private String checkPostingDate;
        /**
         * 盘点名称
         */
        @ApiModelProperty(value = "盘点名称")
        private String checkName;
        /**
         * 前登录人ID
         */
        @ApiModelProperty(value = "前登录人ID")
        private Integer currentloginId;
        /**
         * 当前登录人名称
         */
        @ApiModelProperty(value = "当前登录人名称")
        private String currentloginName;

        @ApiModelProperty(value = "盘点明细")
        private List<MesWmsStockchecklistDto> listDtos;

}


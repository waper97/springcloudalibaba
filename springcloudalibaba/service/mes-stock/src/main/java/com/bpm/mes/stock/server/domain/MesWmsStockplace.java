package com.bpm.mes.stock.server.domain;

import com.bpm.mes.stock.common.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 仓库库位表(MesWmsStockplace)实体类
 *
 * @author makejava
 * @since 2022-04-20 12:20:39
 */
@Data
@ApiModel(value = "MesWmsStockplace")
public class MesWmsStockplace extends PageDTO {
    private static final long serialVersionUID = -97446264706304662L;
        
        private Integer id;
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
         * 父级ID（外键）本表id
         */
        @ApiModelProperty(value = "父级ID（外键）本表id")
        private Integer parentId;
        /**
         * 父级库位编码
         */
        @ApiModelProperty(value = "父级库位编码")
        private String parentStockPlacenCode;
        /**
         * 父级库位名称
         */
        @ApiModelProperty(value = "父级库位名称")
        private String parentStockPlacenName;
        /**
         * 层数(自动生成)
         */
        @ApiModelProperty(value = "层数(自动生成)")
        private Integer layerNum;
        /**
         * 是否叶结点（1是，0否）
         */
        @ApiModelProperty(value = "是否叶结点（1是，0否）")
        private String isLeaf;
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
         * 承受重量（库位）
         */
        @ApiModelProperty(value = "承受重量（库位）")
        private BigDecimal weight;
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
         * 状态：0闲置、1占用、2满仓
         */
        @ApiModelProperty(value = "状态：0闲置、1占用、2满仓")
        private String state;
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
         * 安全库存（最小库存）
         */
        @ApiModelProperty(value = "安全库存（最小库存）")
        private BigDecimal minStock;
        /**
         * 最大库存
         */
        @ApiModelProperty(value = "最大库存")
        private BigDecimal maxStock;
        /**
         * 容量（最大库存）
         */
        @ApiModelProperty(value = "容量（最大库存）")
        private BigDecimal capacity;
        /**
         * 对应筒仓编号
         */
        @ApiModelProperty(value = "对应筒仓编号")
        private String siloCode;
        /**
         * 对应筒仓名称
         */
        @ApiModelProperty(value = "对应筒仓名称")
        private String siloName;
        /**
         * 中控系统ID
         */
        @ApiModelProperty(value = "中控系统ID")
        private Integer zkSystemId;
        /**
         * 中控系统编号
         */
        @ApiModelProperty(value = "中控系统编号")
        private String zkSystemCode;
        /**
         * 中控系统名称
         */
        @ApiModelProperty(value = "中控系统名称")
        private String zkSystemName;
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
         * 库区库位类型 1库区 2库位
         */
        @ApiModelProperty(value = "库区库位类型 1库区 2库位")
        private String stockPlaceType;
        /**
         * 物料编码
         */
        @ApiModelProperty(value = "物料编码")
        private String materialCode;


}


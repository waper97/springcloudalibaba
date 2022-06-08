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
 * 仓库即时库存主表(MesWmsStockcurrentsum)实体类
 *
 * @author makejava
 * @since 2022-04-18 16:12:51
 */
@Data
@ApiModel(value = "MesWmsStockcurrentsum")
public class MesWmsStockcurrentsum implements Serializable {
    private static final long serialVersionUID = 871542711525017246L;
        
        private Integer id;
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


}


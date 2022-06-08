package com.bpm.mes.stock.server.domain;

import com.bpm.mes.stock.common.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 仓库出入库规则(MesWmsStockrule)实体类
 *
 * @author makejava
 * @since 2022-04-18 09:33:17
 */
@Data
@ApiModel(value = "MesWmsStockrule")
public class MesWmsStockrule extends PageDTO {
    private static final long serialVersionUID = -80701475872230165L;
        
        private Integer id;
        /**
         * 规则编码
         */
        @ApiModelProperty(value = "规则编码")
        private String ruleCode;
        /**
         * 规则名称
         */
        @ApiModelProperty(value = "规则名称")
        private String ruleName;
        /**
         * 规则结论
         */
        @ApiModelProperty(value = "规则结论")
        private String ruleConclusion;
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
         * 规则值
         */
        @ApiModelProperty(value = "规则值")
        private String ruleValue;
        /**
         * 规则属性 1入库、2出库
         */
        @ApiModelProperty(value = "规则属性 1入库、2出库")
        private String inOutPropert;


}


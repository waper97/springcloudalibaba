package com.bpm.mes.stock.server.domain;

import com.bpm.mes.stock.common.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 仓库信息表(MesWmsStock)实体类
 *
 * @author makejava
 * @since 2022-04-18 14:26:30
 */
@Data
@ApiModel(value = "MesWmsStock")
public class MesWmsStock extends PageDTO {
    private static final long serialVersionUID = -69569521527569942L;
        /**
         * 仓库id
         */
        @ApiModelProperty(value = "仓库id")
        private Integer id;
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
         * 仓库类型：1 原辅料仓、2线边仓、3半成品现场仓、4成品原辅料仓
         */
        @ApiModelProperty(value = "仓库类型：1 原辅料仓、2线边仓、3半成品现场仓、4成品原辅料仓")
        private String stockType;
        /**
         * 物料属性：0委外、1外购、2自制半成品、3自制产成品
         */
        @ApiModelProperty(value = "物料属性：0委外、1外购、2自制半成品、3自制产成品")
        private String materialTrId;
        /**
         * 库管员ID（EMPID），多个用“，”分隔
         */
        @ApiModelProperty(value = "库管员ID（EMPID），多个用“，”分隔")
        private String stockManagerId;
        /**
         * 库管员编号，多个用“，”分隔
         */
        @ApiModelProperty(value = "库管员编号，多个用“，”分隔")
        private String stockManagerCode;
        /**
         * 库管员姓名多个用“，”分隔
         */
        @ApiModelProperty(value = "库管员姓名多个用“，”分隔")
        private String stockManagerName;
        /**
         * 仓库地址
         */
        @ApiModelProperty(value = "仓库地址")
        private String stockAddress;
        /**
         * 仓库电话
         */
        @ApiModelProperty(value = "仓库电话")
        private String stockPhone;
        /**
         * 所属部门ID（外键）
         */
        @ApiModelProperty(value = "所属部门ID（外键）")
        private Integer departmentId;
        /**
         * 所属部门编码
         */
        @ApiModelProperty(value = "所属部门编码")
        private String departmentCode;
        /**
         * 所属部门名称
         */
        @ApiModelProperty(value = "所属部门名称")
        private String departmentName;
        /**
         * 客户ID（外键） 
         */
        @ApiModelProperty(value = "客户ID（外键） ")
        private Integer clientId;
        /**
         * 客户编码（客户寄存仓或第三方物流仓）
         */
        @ApiModelProperty(value = "客户编码（客户寄存仓或第三方物流仓）")
        private String clientNo;
        /**
         * 客户名称（客户寄存仓或第三方物流仓）
         */
        @ApiModelProperty(value = "客户名称（客户寄存仓或第三方物流仓）")
        private String clientName;
        /**
         * ERP对应id
         */
        @ApiModelProperty(value = "ERP对应id")
        private Integer erpId;
        /**
         * 对应ERP仓库编码
         */
        @ApiModelProperty(value = "对应ERP仓库编码")
        private String erpCode;
        /**
         * 对应ERP仓库名称
         */
        @ApiModelProperty(value = "对应ERP仓库名称")
        private String erpName;
        /**
         * 是否预警：1是、0否
         */
        @ApiModelProperty(value = "是否预警：1是、0否")
        private String isWarn;
        /**
         * 仓库状态：1在用，0停用，9盘点
         */
        @ApiModelProperty(value = "仓库状态：1在用，0停用，9盘点")
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
         * 工厂编码
         */
        @ApiModelProperty(value = "工厂编码")
        private String plantCode;
        /**
         * 工厂名称
         */
        @ApiModelProperty(value = "工厂名称")
        private String plantName;
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
         * 是否叶结点（1是，0否）
         */
        @ApiModelProperty(value = "是否叶结点（1是，0否）")
        private String isLeaf;
        /**
         * 仓库属性：(1实仓；2虚仓)
         */
        @ApiModelProperty(value = "仓库属性：(1实仓；2虚仓)")
        private String stockProperty;
        /**
         * 请选择是/否   先进先出分配(1是，0否）
         */
        @ApiModelProperty(value = "请选择是/否   先进先出分配(1是，0否）")
        private String isDistribution;


}


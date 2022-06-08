package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 仓库信息表(MesWmsStock)实体类
 *
 * @author makejava
 * @since 2022-04-13 14:45:52
 */
@Data
public class MesWmsStockDto  {
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
     * 仓库类型：1 原辅料仓、成品原辅料仓、2线边仓、3半成品现场仓
     */
    @ApiModelProperty(value = "仓库类型：1 原辅料仓、成品原辅料仓、2线边仓、3半成品现场仓")
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


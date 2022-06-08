package com.bpm.mes.stock.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 仓库出入库类型表(MesWmsInouttype)实体类
 *
 * @author makejava
 * @since 2022-04-14 10:35:29
 */
@Data
@ApiModel(value = "MesWmsInouttypeDto")
public class MesWmsInouttypeDto implements Serializable {
    private static final long serialVersionUID = 145264911514639855L;

    private Integer id;
    /**
     * 仓库出入库类型编码
     */
    @ApiModelProperty(value = "仓库出入库类型编码")
    private String inOutTypeCode;
    /**
     * 仓库出入库类型名称
     */
    @ApiModelProperty(value = "仓库出入库类型名称")
    private String inOutTypeName;
    /**
     * 单据标识（上面映射表，如:CIN）有的是规定死了的
     */
    @ApiModelProperty(value = "单据标识（上面映射表，如:CIN）有的是规定死了的")
    private String billFlag;
    /**
     * 操作属性：1入库、2出库 数据字典
     */
    @ApiModelProperty(value = "操作属性：1入库、2出库 数据字典")
    private String inOutPropert;
    /**
     * 是否系统默认：1是、0否 默认的操作类型不在通用出入库功能上显示
     */
    @ApiModelProperty(value = "是否系统默认：1是、0否 默认的操作类型不在通用出入库功能上显示")
    private String defaultFlag;
    /**
     * ERP对应id
     */
    @ApiModelProperty(value = "ERP对应id")
    private Integer erpId;
    /**
     * ERP对应出入库类型编号，ERP：
     */
    @ApiModelProperty(value = "ERP对应出入库类型编号，ERP：")
    private String erpCode;
    /**
     * ERP对应出入库类型名称，ERP：
     */
    @ApiModelProperty(value = "ERP对应出入库类型名称，ERP：")
    private String erpName;
    /**
     * ERP单据标识
     */
    @ApiModelProperty(value = "ERP单据标识")
    private String erpBillCode;
    /**
     * 是否上传ERP，1是，0否
     */
    @ApiModelProperty(value = "是否上传ERP，1是，0否")
    private String isUpload;
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
     * 前登录人ID
     */
    @ApiModelProperty(value = "前登录人ID")
    private Integer currentloginId;
    /**
     * 当前登录人名称
     */
    @ApiModelProperty(value = "当前登录人名称")
    private String currentloginName;
}


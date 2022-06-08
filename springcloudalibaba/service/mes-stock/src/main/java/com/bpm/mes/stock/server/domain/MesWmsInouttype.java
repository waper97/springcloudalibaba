package com.bpm.mes.stock.server.domain;

import com.bpm.mes.stock.common.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 仓库出入库类型表(MesWmsInouttype)实体类
 *
 * @author makejava
 * @since 2022-04-14 10:35:29
 */
@Data
@ApiModel(value = "MesWmsInouttype")
public class MesWmsInouttype extends PageDTO {
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


}


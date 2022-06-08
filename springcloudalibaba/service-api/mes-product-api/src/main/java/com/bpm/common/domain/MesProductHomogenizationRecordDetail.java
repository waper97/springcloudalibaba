package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 均化记录详情表(MesProductHomogenizationRecordDetail)实体类
 *
 * @author zhangzheming
 * @since 2022-05-06 18:25:22
 */
@Data
@ApiModel(value = "均化记录详情")
public class MesProductHomogenizationRecordDetail implements Serializable {
    private static final long serialVersionUID = -78656666017652972L;
    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称")
    private String createName;
    /**
     * 创建时间 yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "创建时间 yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改人id
     */
    @ApiModelProperty(value = "修改人id")
    private Integer updateId;
    /**
     * 修改人名称
     */
    @ApiModelProperty(value = "修改人名称")
    private String updateName;
    /**
     * 修改时间 yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "修改时间 yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除 0否 1是
     */
    @ApiModelProperty(value = "是否删除 0否 1是")
    private Integer isDeleted;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 均化记录id 外键
     */
    @ApiModelProperty(value = "均化记录id 外键")
    private Integer homogenizationRecordId;
    /**
     * 物料id 外键
     */
    @ApiModelProperty(value = "物料id 外键")
    private Integer materialId;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialName;
    /**
     * 需求数量
     */
    @ApiModelProperty(value = "需求数量")
    private BigDecimal demandQuantity;
    /**
     * 物料来源id
     */
    @ApiModelProperty(value = "物料来源id")
    private Integer materialSourceId;
    /**
     * 物料来源
     */
    @ApiModelProperty(value = "物料来源")
    private String materialSource;
    /**
     * 碎石仓库id
     */
    @ApiModelProperty(value = "碎石仓库id")
    private Integer gravelWarehouseId;
    /**
     * 碎石仓库
     */
    @ApiModelProperty(value = "碎石仓库")
    private String gravelWarehouse;
    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer serialNumber;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
    private Integer createId;


}


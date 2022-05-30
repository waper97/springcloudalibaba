package com.bpm.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 日破碎铲车投料计划详情实体类
 *
 * @author zhangzheming
 * @since 2022-05-11 09:53:02
 */
@Data
@ApiModel(value = "日破碎铲车投料计划详情实体类")
public class MesProductDayBrokenForkliftFeedingPlanningDetail implements Serializable {
    private static final long serialVersionUID = 636554704694494227L;
    /**
     * 主键 自增长
     */
    @ApiModelProperty(value = "主键 自增长")
    private Integer id;
    /**
     * 日破碎铲车投料计划id 外键
     */
    @ApiModelProperty(value = "日破碎铲车投料计划id 外键")
    private Integer dayBrokenForkliftFeedingPlanningId;
    /**
     * 执行顺序
     */
    @ApiModelProperty(value = "执行顺序")
    private Integer executionSequence;
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String mineralsCode;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String mineralsName;
    /**
     * 比例
     */
    @ApiModelProperty(value = "比例")
    private BigDecimal ratio;
    /**
     * 计划数量
     */
    @ApiModelProperty(value = "计划数量")
    private BigDecimal planQuantity;
    /**
     * 状态 已关闭 新增
     */
    @ApiModelProperty(value = "状态 已关闭 新增")
    private Integer status;
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
    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称")
    private String createName;
    /**
     * 创建时间  格式：yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "创建时间  格式：yyyy-MM-dd HH:mm:ss")
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
     * 修改时间 格式：yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "修改时间 格式：yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除 0否，1是
     */
    @ApiModelProperty(value = "是否删除 0否，1是")
    private Integer isDeleted;
    /**
     * 堆场库位
     */
    @ApiModelProperty(value = "堆场库位")
    private String storageYardLocation;
    /**
     * 物料id
     */
    @ApiModelProperty(value = "物料id")
    private Integer materialId;
    /**
     * 堆场库位id
     */
    @ApiModelProperty(value = "堆场库位id")
    private Integer storageYardLocationId;
}
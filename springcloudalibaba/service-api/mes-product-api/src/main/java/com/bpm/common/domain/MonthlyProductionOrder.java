package com.bpm.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * 月生产订单(MonthlyProductionOrder)实体类
 *
 * @author wangpeng
 * @since 2022-05-17 17:44:15
 */
@Data
@ApiModel(value = "月生产订单")
public class MonthlyProductionOrder implements Serializable {
    private static final long serialVersionUID = -83691077558681654L;

    /**
    * id
    */    
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
    * 单据编号
    */    
    @ApiModelProperty(value = "单据编号")
    private String documentCode;

    /**
    * 工作中心id
    */    
    @ApiModelProperty(value = "工作中心id")
    private Integer workEnterId;

    /**
    * bom主表id
    */    
    @ApiModelProperty(value = "bom主表id")
    private Integer bomId;

    /**
    * bom版本
    */    
    @ApiModelProperty(value = "bom版本")
    private String bomVersion;

    /**
    * 物料id
    */    
    @ApiModelProperty(value = "物料id")
    private Integer materialId;

    /**
    * 物料编号
    */    
    @ApiModelProperty(value = "物料编号")
    private String materialCode;

    /**
    * 集团号
    */    
    @ApiModelProperty(value = "集团号")
    private String groupNumber;

    /**
    * 单据日 格式年月 
    */    
    @ApiModelProperty(value = "单据日 格式年月 ")
    private String documentDate;

    /**
    * 状态
    */    
    @ApiModelProperty(value = "状态")
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
    * 创建时间
    */    
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

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
    * 修改时间
    */    
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
    * 是否删除:1是，0否
    */    
    @ApiModelProperty(value = "是否删除:1是，0否")
    private Integer isDeleted;

    /**
    * 物料名称
    */    
    @ApiModelProperty(value = "物料名称")
    private String materialName;


}


package com.bpm.common.domain;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 生产线表(MesProductProductionLine)实体类
 *
 * @author zhangzheming
 * @since 2022-04-25 09:50:19
 */
@Data
@ApiModel(value = "生产线表(MesProductProductionLine)实体类")
public class MesProductProductionLine implements Serializable {
    private static final long serialVersionUID = 988595004118062560L;
    /**
     * 主键 自增长
     */
    @ApiModelProperty(value = "主键 自增长")
    private Integer id;
    /**
     * 生产线编号
     */
    @ApiModelProperty(value = "生产线编号")
    private String code;
    /**
     * 生产线名称
     */
    @ApiModelProperty(value = "生产线名称")
    private String name;
    /**
     * 父生产线id 自关联
     */
    @ApiModelProperty(value = "父生产线id 自关联")
    private Integer parentId;
    /**
     * 所属工厂id 外键
     */
    @ApiModelProperty(value = "所属工厂id 外键")
    private Integer factoryId;
    /**
     * 公司id 外键
     */
    @ApiModelProperty(value = "公司id 外键")
    private Integer companyId;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
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
     * 创建时间  格式：yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "创建时间  格式：yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否固定生产量
     */
    @ApiModelProperty(value = "是否固定生产量")
    private Integer isFixedProduction;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
}


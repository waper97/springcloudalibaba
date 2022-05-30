package com.bpm.common.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 工作中心表(MesProductWorkCenter)实体类
 *
 * @author zhangzheming
 * @since 2022-04-27 18:00:02
 */
@Data
@ApiModel(value = "工作中心表(MesProductWorkCenter)实体类")
public class MesProductWorkCenter implements Serializable {
    private static final long serialVersionUID = -10515197644324975L;
    /**
     * 主键 自增长
     */
    @ApiModelProperty(value = "主键 自增长")
    private Integer id;
    /**
     * 工作中心编号
     */
    @ApiModelProperty(value = "工作中心编号")
    private String code;
    /**
     * 工作中心名称
     */
    @ApiModelProperty(value = "工作中心名称")
    private String name;
    /**
     * 部门id键
     */
    @ApiModelProperty(value = "部门id键")
    private Integer deptId;
    /**
     * 所属工厂
     */
    @ApiModelProperty(value = "所属工厂")
    private Integer factoryId;
    /**
     * 公司id 外键
     */
    @ApiModelProperty(value = "公司id 外键")
    private Integer companyId;
    /**
     * 成本中心
     */
    @ApiModelProperty(value = "成本中心")
    private String costCenter;
    /**
     * 接收仓库
     */
    @ApiModelProperty(value = "接收仓库")
    private String receiveWarehouse;
    /**
     * 接收位置
     */
    @ApiModelProperty(value = "接收位置")
    private String receiveLocation;
    /**
     * 存放仓库
     */
    @ApiModelProperty(value = "存放仓库")
    private String storageWarehouse;
    /**
     * 备用库位
     */
    @ApiModelProperty(value = "备用库位")
    private String substore;
    /**
     * 资源类别 数据字典
     */
    @ApiModelProperty(value = "资源类别 数据字典")
    private Integer resourceAtegories;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除 0否，1是
     */
    @ApiModelProperty(value = "是否删除 0否，1是")
    private Integer isDeleted;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
}


package com.bpm.mes.purchase.dto;

import com.bpm.mes.purchase.common.dto.SysBaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(description = "质检任务-发起报检-新增对象")
public class TasksMainAddDto extends SysBaseDTO {

    /**
     * 主表ID
     */
    @ApiModelProperty(value = "主表ID")
    private Integer id;
    @ApiModelProperty(value = "备注")
    private String remark;

//    @ApiModelProperty(value = "收货单编码")
//    private String buyAcceptNo;

//    @ApiModelProperty(value = "质检场景编码")
//    private String occasionsCode;

//    @ApiModelProperty(value = "计划质检日期")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date qualityTimePlan;
//
//    @ApiModelProperty(value = "检验原类型")
//    private String checkTheOriginalType;
//
//    @ApiModelProperty(value = "样品物料编码")
//    private String sampleMaterialsCode;
//
//    @ApiModelProperty(value = "前登录人ID")
//    private Integer createId;
//
//    @ApiModelProperty(value = "当前登录人名称")
//    private String CreateName;

}

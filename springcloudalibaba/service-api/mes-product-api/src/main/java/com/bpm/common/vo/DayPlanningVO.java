package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.DayPlanning;
import com.bpm.common.domain.DayPlanningDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 日生产计划(DayPlanning)实体类
 *
 * @author wangpeng
 * @since 2022-05-06 09:54:45
 */
@Data
@ApiModel(value = "日生产计划")
public class DayPlanningVO extends DayPlanning implements  Serializable {
    private static final long serialVersionUID = 357817243187075402L;

    /**
     * 工序名称
     */
    @ApiModelProperty(value = "工序名称")
    private String processeName;
    @ApiModelProperty(value = "生产车间名称")
    private String productionWorkshopName;

    @ApiModelProperty(value = "日生产计划详情 子集")
    List<DayPlanningDetailVO> detailList = new ArrayList<>();

    @ApiModelProperty(value = "物料编号")
    private String materialCode;

    @ApiModelProperty(value = "物料名称")
    private String materialName;

    @ApiModelProperty(value = "成品仓名称")
    private String finishedGoodsWarehouseName;

    @ApiModelProperty(value = "接收仓名称")
    private String receivingWarehouseName;

    @ApiModelProperty(value = "发出仓名称")
    private String sendOutWarehouseName;

    @ApiModelProperty(value ="状态名称" )
    private String statusName;



}


package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.MasterProductionPlan;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * 主生产计划(MasterProductionPlan)实体类
 *
 * @author wangpeng
 * @since 2022-04-24 16:45:58
 */
@Data
public class MasterProductionPlanVO extends MasterProductionPlan implements Serializable {
    private static final long serialVersionUID = 824128315538219534L;

    /**
     * 物料需求计划编号
     */
    @ApiModelProperty(value ="物料需求计划编号")
        private String needCode;

    /**
     * 投放单据类型 release_document_type
     */
    @ApiModelProperty(value = "投放单据类型 release_document_type")
    private String documentTypeName;

    /**
     * 矿粉名称
     */
    @ApiModelProperty(value = "矿粉名称 ")
    private String materialName;

    /**
     * 矿粉编号
     */
    @ApiModelProperty(value = "矿粉编号 ")
    private String materialCode;

    /**
     * 状态名称
     */
    @ApiModelProperty(value = "状态名称 ")
    private String statusName;

    /**
     * 生产车间名称
     */
    @ApiModelProperty(value = "生产车间名称")
    private String productionWorkshopName;

//    /**
//     * 库存量
//     */
//    @ApiModelProperty(value = "库存量")
//    private String stockQuantity;
//    /**
//     * 需求日期
//     */
//    @ApiModelProperty(value = "需求日期")
//    private String demandDate;

}


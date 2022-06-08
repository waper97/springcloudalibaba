package com.bpm.mes.stock.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StockCheckResults {

    private Integer stockInOutListId;
    /**
     * 执行状态：1新建；2部分分配；3完全分配；4部分拣货；5完全拣货；6完成；7关闭；
     */
    @ApiModelProperty(value = "执行状态：7检验成功；8检验不合格")
    private String status;
    /**
     * 审核人ID（登陆人）
     */
    @ApiModelProperty(value = "审核人ID（登陆人）")
    private Integer checkerId;
    /**
     * 审核人名称
     */
    @ApiModelProperty(value = "审核人名称")
    private String checkerName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

}


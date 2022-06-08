package com.bpm.mes.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MesPurchaseBuySendSendDTO {
    private List<Integer> idList;
    @ApiModelProperty(value = "创建人")
    private Integer createId;
    @ApiModelProperty(value = "创建名称")
    private String createName;
}

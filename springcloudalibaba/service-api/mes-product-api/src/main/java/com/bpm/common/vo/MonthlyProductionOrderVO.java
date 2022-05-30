package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.MonthlyProductionOrder;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 月生产订单(MonthlyProductionOrder)实体类
 *
 * @author wangpeng
 * @since 2022-05-17 17:44:16
 */
@Data
@ApiModel(value = "月生产订单")
public class MonthlyProductionOrderVO extends MonthlyProductionOrder implements Serializable {
    private static final long serialVersionUID = 286384063702689906L;


}


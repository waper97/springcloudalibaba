package com.bpm.common.dto;

// 设置后缀名称


import com.bpm.common.entity.MesProductBillOfMaterial;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * bom(物料清单)主表(BillOfMaterial)传输类
 *
 * @author wangpeng
 * @since 2022-04-19 11:44:34
 */
@Data
//@ApiModel(value = "bom(物料清单)主表",description = "bom(物料清单)主表")
public class BillOfMaterialDTO extends MesProductBillOfMaterial implements Serializable {

    private static final long serialVersionUID = 437394434197599279L;

    @ApiModelProperty("当前页")
    private int pageNum = 1;

    @ApiModelProperty("每页条数")
    private int pageSize = 10;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape =JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("开始时间")
    private LocalDateTime beginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape =JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("产品编码")
    private String productCode;

    @ApiModelProperty("物料编号")
    private String mineralName;

    @ApiModelProperty("物料名称")
    private String mineralCode;






}


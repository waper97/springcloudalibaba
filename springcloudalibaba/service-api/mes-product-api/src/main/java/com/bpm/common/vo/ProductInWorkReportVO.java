package com.bpm.common.vo;
// 设置后缀名称

import com.bpm.common.domain.ProductInWorkReport;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
/**
 * 生成入库报工(ProductInWorkReport)实体类
 *
 * @author wangpeng
 * @since 2022-05-23 14:51:47
 */
@Data
@ApiModel(value = "生成入库报工")
public class ProductInWorkReportVO extends ProductInWorkReport implements Serializable {
    private static final long serialVersionUID = 700510601970306676L;


}


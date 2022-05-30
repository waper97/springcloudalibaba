package com.bpm.common.dto;



import com.bpm.common.domain.ProductInWorkReport;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 生成入库报工(ProductInWorkReport)传输类
 *
 * @author wangpeng
 * @since 2022-05-23 14:49:40
 */
@Data
@ApiModel(value = "生成入库报工")
public class ProductInWorkReportDTO extends ProductInWorkReport implements Serializable {
    private static final long serialVersionUID = 806662561486686385L;
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private int pageNum;

    /**
     * 每页的数量
     */
    @ApiModelProperty(value = "每页的数量")
    private int pageSize;


}


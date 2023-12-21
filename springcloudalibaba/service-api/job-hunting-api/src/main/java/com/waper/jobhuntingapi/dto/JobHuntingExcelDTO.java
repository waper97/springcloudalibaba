package com.waper.jobhuntingapi.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 *
 * @author wangpeng
 * @ClassName JobHuntingExcelDTO
 * @description TODO
 * @date 2023/12/21 15:01
 */
@Data
public class JobHuntingExcelDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    @ExcelProperty(value = "名称",index = 0)
    private String name;

    @ApiModelProperty("年龄")
    @ExcelProperty(value = "年龄",index = 1)
    private Integer age;

    @ExcelProperty(value = "电话",index = 2)
    @ApiModelProperty("电话")
    private String mobile;

    @ApiModelProperty("薪资")
    @ExcelProperty(value = "薪资",index = 3)
    private BigDecimal salary;

    @ApiModelProperty("生日")
    @ExcelProperty(value = "生日",index = 4)
    private String birthday;

    @ApiModelProperty("创建时间")
    @ExcelProperty(value = "创建时间",index = 5)
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @ExcelProperty(value = "修改时间",index = 6)
    private LocalDateTime updateTime;


}

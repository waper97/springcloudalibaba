package com.bpm.server.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ClassName TestExcel
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/4/18 11:04
 */
public class TestExcel {

    private Integer id;
    /**
     * 计划运算类型：1 mps、2 mrp
     */
    @ExcelProperty(value = "计划运算类型：1 mps、2 mrp")
    private String planningOperation;
    /**
     * 运算编号
     */
    @ExcelProperty(value = "运算编号")
    private String operationCode;
    /**
     * 运算日期  数据字典
     */
    @ExcelProperty(value = "运算日期  数据字典")
    private Date operationDate;
    /**
     * 展望期开始日期
     */
    @ExcelProperty(value = "展望期开始日期")
    private Date needBeginDate;
    /**
     * 展望期结束日期
     */
    @ExcelProperty(value = "展望期结束日期")
    private Date needEndDate;
}

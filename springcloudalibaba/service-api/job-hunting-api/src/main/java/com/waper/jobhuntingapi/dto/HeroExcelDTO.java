package com.waper.jobhuntingapi.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 英雄excel实体传输类
 * @author wangpeng
 * @ClassName HeroExcelDTO
 * @description TODO
 * @date 2023/12/21 15:11
 */
@Data
public class HeroExcelDTO {
    private static final long serialVersionUID = 1L;


    @ExcelProperty(value = "id",index = 0)
    private Integer id;
    /**
     * 英雄编号
     */
    @ApiModelProperty(value = "英雄编号")
    @ExcelProperty(value = "英雄编号",index = 1)
    private Long ename;
    /**
     * 英雄名称
     */
    @ApiModelProperty(value = "英雄名称")
    @ExcelProperty(value = "英雄名称",index = 2)
    private String cname;
    /**
     * 英雄全称
     */
    @ApiModelProperty(value = "英雄全称")
    @ExcelProperty(value = "英雄全称",index = 3)
    private String title;

    /**
     * 上线时间
     */
    @ApiModelProperty("上线时间")
    @ExcelProperty(value = "上线时间",index = 4)
    private String time;
    /**
     *类型
     */
    @ApiModelProperty(value = "类型")
    @ExcelProperty(value = "类型",index = 5)
    private String newType;
    /**
     * 英雄类型
     */
    @ApiModelProperty(value = "英雄类型")
    @ExcelProperty(value = "英雄类型",index = 6)
    private String heroType;
    /**
     * 皮肤
     */
    @ApiModelProperty(value = "皮肤")
    @ExcelProperty(value = "皮肤",index = 7)
    private String skinName;

    @ApiModelProperty(value = "未知")
    @ExcelProperty(value = "未知",index = 8)
    private String mossId;

    @ApiModelProperty(value = "照片路径")
    @ExcelProperty(value = "照片路径",index = 9)
    private String pictureUrl;
}

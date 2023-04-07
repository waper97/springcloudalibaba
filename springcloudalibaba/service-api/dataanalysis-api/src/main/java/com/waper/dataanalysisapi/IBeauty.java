package com.waper.dataanalysisapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName IBeauty
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/7/16 16:13
 */
@Data
@ApiModel
public class IBeauty implements Serializable {

    @ApiModelProperty(value = "日期")
    private String showDate;

    @ApiModelProperty(value = "页数")
    private Integer size;
    @ApiModelProperty(value = "连接地址")
    private String url;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "图片地址")
    private String pictureUrl;
    @ApiModelProperty(value = "浏览次数")
    private String views;

    // 子集
    List<IBeauty> children;


}

package com.waper.jobhuntingapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Item
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/3/26 20:17
 */
@Data
@NoArgsConstructor
@ApiModel(value = "武器")
public class Item implements Serializable {


    @ApiModelProperty(value = "id")
    private Long itemId;

    @ApiModelProperty(value = "名称")
    private String itemName;

    @ApiModelProperty(value = "名称")
    private String itemType;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "总价格")
    private String totalPrice;

    @ApiModelProperty(value = "描述（带标签")
    private String des1;

    @ApiModelProperty(value = "描述（文本)")
    private String des2;

    @ApiModelProperty(value = "照片路径")
    private String pictureUrl;
}

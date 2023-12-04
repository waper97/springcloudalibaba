package com.waper.jobhuntingapi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId("item_id")
    private Long itemId;

    @ApiModelProperty(value = "名称")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty(value = "类型")
    @TableField("item_type")
    private String itemType;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "总价格")
    @TableField("total_price")
    private String totalPrice;

    @ApiModelProperty(value = "描述（带标签）")
    private String des1;

    @ApiModelProperty(value = "描述（文本)")
    private String des2;

    @ApiModelProperty(value = "照片路径")
    @TableField("picture_url")
    private String pictureUrl;
}

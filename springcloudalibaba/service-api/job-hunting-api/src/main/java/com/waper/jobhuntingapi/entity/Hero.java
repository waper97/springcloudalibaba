package com.waper.jobhuntingapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Hero
 * @Description TODO
 * @Author wangpeng
 * @Date 2021/6/21 15:09
 */
@ApiModel(value = "英雄")
@Data
@NoArgsConstructor
public class Hero implements Serializable {
    /**
     * 英雄编号
     */
    @ApiModelProperty(value = "英雄编号")
    private Long ename;
    /**
     * 英雄名称
     */
    @ApiModelProperty(value = "英雄名称")
    private String cname;
    /**
     * 英雄全称
     */
    @ApiModelProperty(value = "英雄全称")
    private String title;
    /**
     *类型
     */
    @ApiModelProperty(value = "类型")
    private String newType;
    /**
     * 英雄类型
     */
    @ApiModelProperty(value = "英雄类型")
    private String heroType;
    /**
     * 皮肤
     */
    @ApiModelProperty(value = "皮肤")
    private String skinName;

    @ApiModelProperty(value = "未知")
    private String mossId;

    @ApiModelProperty(value = "照片路径")
    private String pictureUrl;
}
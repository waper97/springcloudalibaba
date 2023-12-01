package com.waper.jobhuntingapi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName Hero
 * @Description TODO
 * @Author wangpeng
 * @Date 2021/6/21 15:09
 */
@ApiModel(value = "英雄")
@Data
//@Entity
//@Table(name = "hero")
public class Hero implements Serializable {

    @TableId("id")
    private Integer id;
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
     * 上线时间
     */
    @ApiModelProperty("上线时间")
    private String time;
    /**
     *类型
     */
    @ApiModelProperty(value = "类型")
    private String newType;
    /**
     * 英雄类型
     */
    @ApiModelProperty(value = "英雄类型")
    @TableField("hero_type")
    private String heroType;
    /**
     * 皮肤
     */
    @ApiModelProperty(value = "皮肤")
    @TableField("skin_name")
    private String skinName;

    @ApiModelProperty(value = "未知")
    @TableField("moss_id")
    private String mossId;

    @ApiModelProperty(value = "照片路径")
    @TableField("picture_url")
    private String pictureUrl;
}

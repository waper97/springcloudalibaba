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
@ApiModel(value = "召唤师技能")
@Data
@NoArgsConstructor
public class Summoner implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long summonerId;
    /**
     * 召唤师技能名称
     */
    @ApiModelProperty(value = "召唤师技能名称")
    private String summonerName;
    /**
     * 限制
     */
    @ApiModelProperty(value = "限制")
    private String summonerRank;
    /**
     *描述
     */
    @ApiModelProperty(value = "描述")
    private String summonerDescription;

    @ApiModelProperty(value = "照片路径")
    private String pictureUrl;

}

package com.waper.common.constant;

import lombok.Getter;

/**
 * 英雄类型枚举
 * @author wangpeng
 * @ClassName HeroEnum
 * @description TODO
 * @date 2023/12/21 15:35
 */
@Getter
public enum HeroTypeEnum {
    WARRIOR("战士","1"),
    MASTER("法师","2"),
    TANK("坦克","3"),
    ASSASSIN("刺客","4"),
    SHOOTER("射手","5"),
    ASSIST("辅助","6"),
    FREE_IN_A_LIMITED_TIME("限免","10"),
    NEW_HAND("新手","11");

    private final String value;
    private final String name;


    HeroTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static String getValueByName(String name) {
        for (HeroTypeEnum heroTypeEnum : HeroTypeEnum.values()) {
            if (heroTypeEnum.getName().equals(name)) {
                return heroTypeEnum.getValue();
            }
        }
        throw new IllegalArgumentException("Invalid name:"+name);

    }

    public static String getNameByValue(String value) {
        for (HeroTypeEnum heroTypeEnum : HeroTypeEnum.values()) {
            if (heroTypeEnum.getValue().equals(value)) {
                return heroTypeEnum.getName();
            }
        }
        return null;
    }


}

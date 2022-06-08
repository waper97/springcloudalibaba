package com.bpm.common.domain;

/**
 * 工艺路线枚举类
 * @author wangpeng
 */
public enum ProcessRouteTypeEnum {

    /***破碎生产*/
    BROKEN("破碎生产","1"),
    /**配料输送*/
    DOSING_TRANSPORT ( "配料输送","2"),
    /**立磨生产**/
    VERTICAL_MILL_PRODUCT ( "立磨生产","3"),
    /**预均化**/
    PRE_HOMOGENIZE_RECORD_TYPE( "预均化","4"),
    /**粉料配送**/
    POWDER_DOSING("粉料配送","5"),
    /**均化仓均化**/
    HOMOGENIZATION_BIN_HOMOGENIZATION("均化仓均化","6"),
    /**气力输送**/
    PNEUMATIC_TRANSPORT("气力输送","7"),
    /**装车出库**/
    LOADING_AND_DELIVERY("装车出库","8");


    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    ProcessRouteTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProcessRouteTypeEnum{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

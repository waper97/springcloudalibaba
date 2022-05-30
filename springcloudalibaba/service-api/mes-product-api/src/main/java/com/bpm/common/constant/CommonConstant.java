package com.bpm.common.constant;

/**
 * @ClassName CommonConstant
 * @Description 通用常量
 * @Author wangpeng
 * @Date 2022/5/6 16:23
 */
public interface CommonConstant {


    // 生产begin
    /**
     * 1.日破碎计划
     */
    String DAY_BROKEN_PLANNING = "1";
    /**
     * 日配料输送计划
     */
    String DAY_DOSING_TRANSPORT_PLANNING = "2";
    /**
     * 日立磨生产计划
     */
    String DAY_VERTICAL_MILL_PRODUCT_PLANNING = "3";
    /**
     * 预均化记录
     */
    String PRE_HOMOGENIZE_RECORD = "4";

    /**
     * 粉料配料计划
     */
    String POWDER_DOSING_PLANNING = "5";

    /**
     * 均化记录
     */
    String HOMOGENIZE_RECORD = "6";
    /**
     * 气力运输计划
     */
    String PNEUMATIC_TRANSPORT_PLANNING = "7";
    /**
     * 缓存仓发放计划
     */
    String BUFFER_WAREHOUSE_GRANT_PLANNING = "8";

    // 生产end

}

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

    /**
     *工艺路线分类:1破碎生产 ,2配料输送,3立磨生产,4预均化,5粉料配送 6.均化仓均化,7气力输送,8装车出库
     */

    /***破碎生产*/
    String BROKEN = "1";
    /**配料输送*/
    String DOSING_TRANSPORT = "2";
    /**立磨生产**/
    String VERTICAL_MILL_PRODUCT = "3";
    /**预均化**/
    String PRE_HOMOGENIZE_RECORD_TYPE = "4";
    /**粉料配料**/
    String POWDER_DOSING = "5";
    /**均化仓均化(均化)**/
    String HOMOGENIZATION_BIN_HOMOGENIZATION = "6";
    /**气力输送**/
    String PNEUMATIC_TRANSPORT = "7";
    /**装车出库**/
    String LOADING_AND_DELIVERY = "8";


    /**
     *半成品入库
     */
    String BIN = "BIN";
    /**
     *成品入库
     */
    String DIN = "DIN";
    /**
     *领料出库
     */
    String SOUT = "SOUT";

}

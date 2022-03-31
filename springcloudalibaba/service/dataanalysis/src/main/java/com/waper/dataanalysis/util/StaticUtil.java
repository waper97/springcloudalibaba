package com.waper.dataanalysis.util;

/**
 * @ClassName StaticUtil
 * @Description 常量存放处
 * @Author wangpeng
 * @Date 2020/8/18 10:43
 */
public class StaticUtil {
    // debug
    public static  boolean DEBUG = false;
    /**
     *英雄列表json
     */
    public static  final  String HERO_LIST = "https://pvp.qq.com/web201605/js/herolist.json";
    /**
     *王者荣耀登录逻辑，以及段位信息 
     */
    public static final String HERO_LOGIC = "https://pvp.qq.com/web201605/js/logic.js";

    /**
     * 装备
     */
    public static final String HERO_EQUIPMENT = "https://pvp.qq.com/web201605/js/item.json";
    /**
     * 英雄对应id
     */
    public static final String HERO_MAPPER_ID = "https://game.gtimg.cn/images/yxzj/web201706/js/heroid.js";

    /**
     *英雄铭文
     */
    public static final String HERO_POSY  = "https://pvp.qq.com/web201605/js/ming.json";



    private static String ACCEPT = "accept";
    private static String ACCEPT_LANGUAGE = "accept-language";
    private static String CACHE_CONTROL = "cache-control";
    private static String COOKIE = "这块替换成你自己的cookie";
    private static String SEC_CH_UA = "sec-ch-ua";
    private static String SEC_CH_UA_MOBILE = "sec-ch-ua-mobile";
    private static String SEC_FETCH_DEST = "sec-fetch-dest";
    private static String SEC_FETCH_MODE = "sec-fetch-mode";
    private static String SEC_FETCH_SITE = "sec-fetch-site";
    private static String UPGRADE_INSECURE_REQUESTS = "upgrade-insecure-requests";
    private static String user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36";

}

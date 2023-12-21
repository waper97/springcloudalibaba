package com.waper.common.util;

/**
 * @author wangpeng
 * @ClassName commonUtil
 * @description 通用工具类
 * @date 2023/11/23 16:06
 */
public class CommonUtils {

    /**
     * 在指定字符串中添加目标字符串 比如： 源名称：愉快政用户新增查询接口_V2.pdf  想要添加的字符串：合并， 返回内容为:愉快政用户新增查询接口_V2合并.pdf
     * @param oringinString 源字符串
     * @param temp 指定位置
     * @param wannaInsertString 想要添加的字符串
     * @return
     */
    public static String insertStringToTargetString(String oringinString,String temp,String wannaInsertString) {
        String first = oringinString.substring(0, oringinString.lastIndexOf(temp));
        String renamedDocFileName = wannaInsertString+oringinString.substring(oringinString.lastIndexOf(temp));
        return first + renamedDocFileName;
    }
}

package com.waper.common.util;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    /**
     * 获取开始时间结束时间
     * @param timeType 类型 ：1.本周  2.月度，3.本季度   4.年度
     * @return
     */
    public static JSONObject getTime(Integer timeType) {
        JSONObject jsonObject = new JSONObject();
        Calendar calendar = Calendar.getInstance();
        if (timeType.equals(1)) {
            // 获取本周的起始时间和结束时间
            int firstDayOfWeek = calendar.getFirstDayOfWeek();
            calendar.setTimeInMillis(System.currentTimeMillis());
            while (calendar.get(Calendar.DAY_OF_WEEK) != firstDayOfWeek) {
                calendar.add(Calendar.DATE, -1);
            }
            Date startOfWeek = calendar.getTime();
            calendar.add(Calendar.DATE, 6);
            Date endOfWeek = calendar.getTime();

            System.out.println("本周起始时间：" + new SimpleDateFormat("yyyy-MM-dd").format(startOfWeek));
            System.out.println("本周结束时间：" + new SimpleDateFormat("yyyy-MM-dd").format(endOfWeek));
            jsonObject.put("startTime", new SimpleDateFormat("yyyy-MM-dd").format(startOfWeek) + " 00:00:00");
            jsonObject.put("endTime", new SimpleDateFormat("yyyy-MM-dd").format(endOfWeek) + " 23:59:59");

        } else if (timeType.equals(2)) {
            // 获取本月的起始时间和结束时间
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date startOfMonth = calendar.getTime();
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date endOfMonth = calendar.getTime();

            System.out.println("本月起始时间：" + new SimpleDateFormat("yyyy-MM-dd").format(startOfMonth));
            System.out.println("本月结束时间：" + new SimpleDateFormat("yyyy-MM-dd").format(endOfMonth));
            jsonObject.put("startTime", new SimpleDateFormat("yyyy-MM-dd").format(startOfMonth) + " 00:00:00");
            jsonObject.put("endTime", new SimpleDateFormat("yyyy-MM-dd").format(endOfMonth) + " 23:59:59");
        } else if (timeType.equals(3)) {
            // 获取本季度的起始时间和结束时间
            calendar.setTimeInMillis(System.currentTimeMillis());
            int month = (calendar.get(Calendar.MONTH) / 3) * 3;
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date startOfQuarter = calendar.getTime();
            calendar.add(Calendar.MONTH, 2);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date endOfQuarter = calendar.getTime();

            System.out.println("本季度起始时间：" + new SimpleDateFormat("yyyy-MM-dd").format(startOfQuarter));
            System.out.println("本季度结束时间：" + new SimpleDateFormat("yyyy-MM-dd").format(endOfQuarter));
            jsonObject.put("startTime", new SimpleDateFormat("yyyy-MM-dd").format(startOfQuarter) + " 00:00:00");
            jsonObject.put("endTime", new SimpleDateFormat("yyyy-MM-dd").format(endOfQuarter) + " 23:59:59");
        } else if (timeType.equals(4)) {
            // 获取本年的起始时间和结束时间
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date startOfYear = calendar.getTime();
            calendar.add(Calendar.YEAR, 1);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date endOfYear = calendar.getTime();

            System.out.println("本年起始时间：" + new SimpleDateFormat("yyyy-MM-dd").format(startOfYear));
            System.out.println("本年结束时间：" + new SimpleDateFormat("yyyy-MM-dd").format(endOfYear));
            jsonObject.put("startTime", new SimpleDateFormat("yyyy-MM-dd").format(startOfYear) + " 00:00:00");
            jsonObject.put("endTime", new SimpleDateFormat("yyyy-MM-dd").format(endOfYear) + " 23:59:59");
        } else if (timeType.equals(5)) {
            jsonObject.put("startTime", DateUtil.today() + " 00:00:00");
            jsonObject.put("endTime", DateUtil.today() + " 23:59:59");
        }
        return jsonObject;
    }
}

package com.waper.dataanalysis.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName SpiderUtil
 * @Description 爬虫帮助类
 * @Author wangpeng
 * @Date 2020/8/21 15:31
 */
public class SpiderUtil {

    /**
     * 获取英雄定位
     * @return
     */
    public static  Object getHeroPosition(){
        // 全部英雄页面
        String WZRY_OFFICIAL_WEBSITE = "https://pvp.qq.com/web201605/herolist.shtml";
        String line = null;
        try {
            URL url = new URL(WZRY_OFFICIAL_WEBSITE);
            // 打开连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            // 获取请求状态码
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                // 得到流
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"GBK"));
                while ((line = reader.readLine()) != null){
                    System.out.println(line);
                }
            }else {
                System.out.println("获取不到网页源码，服务器响应码为:"+responseCode);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void main(String[] args) {
        getHeroPosition();
    }
}

package com.waper.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * @ClassName ReadJsonFileUtils
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/12/26 20:59
 */
public class ReadJsonFileUtils {

//    public static String readJsonFile (MultipartFile fileName) {
//
//        System.out.println(hero);
//        filePath = "C:\\Users\\Administrator\\Desktop\\herolist.json";
//        String jsonStr = "";
//        try {
//            File file = new File(filePath);
//            FileReader fileReader = new FileReader(file);
//            // 读取文件
//            Reader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
//            int ch = 0;
//            StringBuffer sb = new StringBuffer();
//            while((ch = reader.read()) != -1){
//                sb.append((char)ch);
//            }
//            fileReader.close();
//            reader.close();
//            jsonStr = sb.toString();
//
//            // json数组转数组
//            JSONArray jsonArray =  JSONArray.parseArray(jsonStr);
//            List<Hero> heroList = JSONArray.parseArray(jsonArray.toString(), Hero.class);
//            List<Hero> all = heroService.findAll();
//            if (all != null && all.size() > 0) {
//                return successData(all);
//            }else{
//                heroService.saveAll(heroList);
//                return successData(heroList);
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}

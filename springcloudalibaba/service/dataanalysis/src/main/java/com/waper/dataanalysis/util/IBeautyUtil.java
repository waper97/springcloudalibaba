package com.waper.dataanalysis.util;

import com.waper.dataanalysisapi.IBeauty;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 爱美女帮助类
 * @ClassName IBeautyUtil
 * @Description 爱美女帮助类
 * @Author wangpeng
 * @Date 2022/7/16 13:14
 */
public class IBeautyUtil {


    public static String IBEAUTY_URL = "https://www.2meinv.com/";

    /**
     * 获取图片
     *
     * @return
     */
    public static List<IBeauty>  getMeiNvPicture (String url) {
        List<IBeauty> beautyList = new ArrayList<>();
        try {
            // 获取页面
            String body = Jsoup.connect(IBEAUTY_URL).execute().body();
            // 解析 html
            Document parse = Jsoup.parse(body);
            Elements detaiList = parse.getElementsByClass("detail-list");


            for (Element element : detaiList) {
                Elements li = element.getElementsByTag("li");
                for (Element child : li)
                {
                    IBeauty beauty = new IBeauty();
                    String title = child.getElementsByTag("a").text();
                    String href = child.select("a").attr("href");
                    String pirctureUrl = child.select("img").attr("src");
                    String date = child.select("span").text();
                    String views = child.getElementsByClass("spaneye").text();
                    beauty.setTitle(title);
                    beauty.setShowDate(date);
                    beauty.setViews(views);
                    beauty.setUrl(href);
                    beauty.setPictureUrl(pirctureUrl);
                    beautyList.add(beauty);
                    System.out.println(child);
                }
            }
            downLoadPicture(beautyList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return beautyList;
    }

    /**
     * 子页面
     * @param childrenUrl
     * @return
     */
    public  static  List<IBeauty> children  (String childrenUrl) {
        // 获取页面
        try {
            String body = Jsoup.connect(childrenUrl).execute().body();
            // 解析 html
            Document parse = Jsoup.parse(body);
            System.out.println(parse);
            Elements elements = parse.getElementsByClass("pp hh");
            String src = elements.select("img").attr("src");
            String alt = elements.select("img").attr("alt");
            System.out.println("src=" + src);
            System.out.println("alt = " + alt);
//            System.out.println(elements);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return new ArrayList<>();
    }

    /**
     * 下载图片
     * @param beautyList
     */
    public static  void downLoadPicture (List<IBeauty> beautyList ) {
        // 保存地址
        String saveImagePath = "C:\\Users\\waper\\Desktop\\images\\";
        for (IBeauty iBeauty : beautyList) {
            try {
                String pictureUrl = iBeauty.getPictureUrl();
                URL url = new URL(iBeauty.getPictureUrl());
                URLConnection uri = url.openConnection();
                // 获取数据流
                InputStream inputStream = uri.getInputStream();

                File file = new File(saveImagePath+"\\"+iBeauty.getTitle()+"\\");
                if (!file.exists()) {
                    file.mkdir();
                }
                String  fileName = saveImagePath+iBeauty.getTitle()+"\\";
                System.out.println("文件保存位置 = " + fileName);
                OutputStream outputStream = new FileOutputStream(new File(fileName+iBeauty.getTitle()+".jpg"));
            
                int len  = 0;
                byte [] buf  = new byte[1024];
                while ( (len = inputStream.read(buf) )!= -1 ) {
                    outputStream.write(buf, 0 , len);
                }
                outputStream.flush();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    public static void main(String[] args) {
        List<IBeauty> beautyList =  getMeiNvPicture(IBEAUTY_URL);
//        children("https://www.2meinv.com/article-5564.html");
    }
}


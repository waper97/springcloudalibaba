package com.waper.dataanalysis.controller;

import com.waper.dataanalysis.model.BaseInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/8/18 17:17
 */
public class BaseController {

//    @Autowired
//    private WmMapperingService wmMapperingService;

    public Object successMessage(){
        return new BaseInfo(true, BaseInfo.SUCCESS_MESSAGE, BaseInfo.SUCCESS_CODE);
    }

    public Object successData(Object data){
        return new BaseInfo(true, BaseInfo.SUCCESS_MESSAGE, BaseInfo.SUCCESS_CODE, data);
    }



//    public Object wmMappering(){
//        // 获取未名数据
//        List<Map<String,Object>> vmCateLog= wmMapperingService.listVmCatelog(null);
//        // 获取学科网数据
//        List<Map<String,Object>> xKCateLogwmMappering = wmMapperingService.listXKCatelog(null);
//
//        return null;
//    }

    public static void main(String[] args) {
        // 设定文档位置
        String excelFilePath = "C:\\Users\\waper\\Desktop\\未名教材_2(1).xlsx";
        File file = new File(excelFilePath);

        try {
            // 获取你个输入流

            BufferedInputStream in  = new BufferedInputStream(new FileInputStream(file));

            POIFSFileSystem  ps = new POIFSFileSystem(in);

            HSSFWorkbook hw = new HSSFWorkbook(ps);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

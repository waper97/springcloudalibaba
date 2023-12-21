package com.waper.common.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * excel工具类
 * @author wangpeng
 * @ClassName ExcelUtil
 * @description TODO
 * @date 2023/12/21 14:56
 */
@Slf4j
public class ExcelUtil {

    /**
     *
     * @param fileName 文件名称
     * @param sheetName excel sheet名称
     * @param list 数据
     * @param clazz
     * @param response
     */
    public static void exportExcel(String fileName, String sheetName, List list, Class clazz, HttpServletResponse response){
        ServletOutputStream outputStream;
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
            outputStream = response.getOutputStream();
            EasyExcel.write(outputStream)
                    .head(clazz)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet(sheetName)
                    .doWrite(list);
            outputStream.flush();
        } catch (Exception e) {
            log.error("导出excel异常：{}",e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * 设置响应结果
     *
     * @param response    响应结果对象
     * @param rawFileName 文件名
     * @throws UnsupportedEncodingException 不支持编码异常
     */
    private static void setExcelResponseProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
//        String fileName = URLEncoder.encode(rawFileName, "UTF-8").replaceAll("\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + rawFileName + ".xlsx");
    }


}

package com.bpm.server.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.bpm.server.excel.TestExcel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ExcelUtil
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/4/18 11:05
 */
public class ExcelUtil {
    public static void writeExcel(HttpServletResponse response, List<?> list ) throws IOException {
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0,"test").head(TestExcel.class).build();
        excelWriter.write(list, writeSheet);
        excelWriter.finish();
    }
}

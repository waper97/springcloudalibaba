package com.waper.jobhunting.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author wangpeng
 * @ClassName FileUploadUtil
 * @description TODO
 * @date 2023/12/1 16:08
 */

public interface FileUploadService {

    /**
     * 上传图片文件
     *
     * @param prefix      文件前缀
     * @param filename    文件名
     * @param inputStream 文件流
     * @return 文件全路径
     */
     String uploadImgFile(MultipartFile file);

    /**
     * 批量上传
     * @param files
     * @return
     */
    boolean batchUploadImgFile(MultipartFile[] files);

    /**
     * 上传html文件
     *
     * @param prefix      文件前缀
     * @param filename    文件名
     * @param inputStream 文件流
     * @return 文件全路径
     */
     String uploadHtmlFile(String prefix, String filename, InputStream inputStream);

    /**
     * 删除文件
     *
     * @param pathUrl 文件全路径
     */
     void delete(String pathUrl);

    /**
     * 下载文件
     *
     * @param pathUrl 文件全路径
     * @return
     */
     byte[] downLoadFile(String pathUrl);


     void downLoadFile2(String fileName, HttpServletResponse response);

}

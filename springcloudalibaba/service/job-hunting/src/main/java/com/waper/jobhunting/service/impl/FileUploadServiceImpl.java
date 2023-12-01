package com.waper.jobhunting.service.impl;

import com.waper.jobhunting.service.FileUploadService;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.StatObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.io.File.separator;

/**
 * @author wangpeng
 * @ClassName FileUploadServiceImpl
 * @description TODO
 * @date 2023/12/1 16:10
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
    @Resource
    private MinioClient minioClient;
    /**
     * 访问地址
     */
    @Value("${minio.endpoint}")
    private String endpoint;

    /**
     * accessKey类似于用户ID，用于唯一标识你的账户
     */
    @Value("${minio.accessKey}")
    private String accessKey;

    /**
     * secretKey是你账户的密码
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * 默认存储桶
     */
    @Value("${minio.bucketName}")
    private String bucketName;


    /**
     *读取路径
     */
    @Value("${minio.readPath}")
    private String readPath;

    /**
     * 构建文件的绝对路径
     *
     * @param dirPath  文件路径
     * @param filename 文件名  yyyy/mm/dd/file.jpg
     * @return /test
     */
    public String builderFilePath(String dirPath, String filename) {
        StringBuilder stringBuilder = new StringBuilder(50);
        if (!StringUtils.isEmpty(dirPath)) {
            stringBuilder.append(dirPath).append(separator);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String todayStr = sdf.format(new Date());
        stringBuilder.append(todayStr).append(separator);
        stringBuilder.append(filename);
        return stringBuilder.toString();
    }


    @Override
    public String uploadImgFile(String prefix, String filename, InputStream inputStream) {
        String filePath = builderFilePath(prefix, filename);
        try {
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object(filePath)
                    .contentType("image/jpg")
                    .bucket(bucketName).stream(inputStream, inputStream.available(), -1)
                    // 设置对象名称，后面下载用文件名称下载就ok了
                    .object(filename)
                    .build();
            minioClient.putObject(putObjectArgs);
            StringBuilder urlPath = new StringBuilder(readPath);
            urlPath.append(separator + bucketName);
            urlPath.append(separator);
            urlPath.append(filePath);
            return urlPath.toString();
        } catch (Exception ex) {
            log.error("minio put file error.", ex);
            throw new RuntimeException("上传文件失败");
        }

    }

    @Override
    public String uploadHtmlFile(String prefix, String filename, InputStream inputStream) {
        return null;
    }

    @Override
    public void delete(String pathUrl) {

    }

    @Override
    public byte[] downLoadFile(String pathUrl) {
        String key = pathUrl.replace(endpoint + "/", "");
        int index = key.indexOf(separator);
//        String bucket = key.substring(0, index);
//        String filePath = key.substring(index + 1);
        InputStream inputStream = null;
        try {
            inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(pathUrl).build());
        } catch (Exception e) {
            log.error("minio down file error. 0 pathUrl:{}", pathUrl);
            e.printStackTrace();
        }

        //字节数组输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while (true) {
            try {
                if (!((rc = inputStream.read(buff, 0, 100)) > 0)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            byteArrayOutputStream.write(buff, 0, rc);
        }
        return byteArrayOutputStream.toByteArray();

    }

    @Override
    public void downLoadFile2(String fileName, HttpServletResponse response) {
        // 创建输入流
        InputStream is = null;
        try {
            // 获取对象的元数据
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(fileName).build());
            // 响应 设置内容类型
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            // 响应 设置编码格式
            response.setCharacterEncoding("UTF-8");
            // 响应 设置头文件
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            // 输入流
            is = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(fileName).build());
            // 将字节从输入流复制到输出流
            IOUtils.copy(is, response.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException("下载文件异常", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

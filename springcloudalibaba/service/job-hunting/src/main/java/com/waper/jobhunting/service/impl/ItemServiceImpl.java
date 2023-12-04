package com.waper.jobhunting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waper.jobhunting.mapper.ItemMapper;
import com.waper.jobhunting.mapper.JobHuntingMapper;
import com.waper.jobhunting.service.ItemService;
import com.waper.jobhunting.service.JobHuntingService;
import com.waper.jobhuntingapi.entity.Hero;
import com.waper.jobhuntingapi.entity.Item;
import com.waper.jobhuntingapi.entity.JobHunting;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @ClassName JobHuntingService
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/11/7 15:10
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

    @Resource
    private MinioClient minioClient;
    final String stuffName = ".jpg";

    @Override
    public List<Item> listItem() {
        List<Item> list = this.list(new LambdaQueryWrapper<>());
        list.forEach(e ->{
            String itemPicture = null;
            try {
                 itemPicture = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket("item").object(e.getItemId()+stuffName).build());
            } catch (ErrorResponseException ex) {
                throw new RuntimeException(ex);
            } catch (InsufficientDataException ex) {
                throw new RuntimeException(ex);
            } catch (InternalException ex) {
                throw new RuntimeException(ex);
            } catch (InvalidKeyException ex) {
                throw new RuntimeException(ex);
            } catch (InvalidResponseException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            } catch (XmlParserException ex) {
                throw new RuntimeException(ex);
            } catch (ServerException ex) {
                throw new RuntimeException(ex);
            }
            e.setPictureUrl(itemPicture);
        });

        return list;
    }
}

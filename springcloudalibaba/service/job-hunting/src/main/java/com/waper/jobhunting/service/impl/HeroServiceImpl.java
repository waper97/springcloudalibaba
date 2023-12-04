package com.waper.jobhunting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waper.jobhunting.mapper.HeroMapper;
import com.waper.jobhunting.service.HeroService;
import com.waper.jobhuntingapi.entity.Hero;
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
 * @ClassName HeroServiceImpl
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/3/26 19:52
 */
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero> implements HeroService {
    @Resource
    private MinioClient minioClient;
    final String stuffName = ".jpg";
    @Override
    public List<Hero> listHero() {
        List<Hero> list = this.list(new LambdaQueryWrapper<>());
        list.forEach(e ->{
            String heroPic = null;
            try {
                heroPic = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket("hero").object(e.getEname()+stuffName).build());
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
            e.setPictureUrl(heroPic);
        });
        return list;
    }
}

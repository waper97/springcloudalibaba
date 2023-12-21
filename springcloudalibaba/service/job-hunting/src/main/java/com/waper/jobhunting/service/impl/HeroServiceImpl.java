package com.waper.jobhunting.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.waper.common.constant.HeroTypeEnum;
import com.waper.common.util.ExcelUtil;
import com.waper.jobhunting.config.HeroExcelListener;
import com.waper.jobhunting.mapper.HeroMapper;
import com.waper.jobhunting.service.HeroService;
import com.waper.jobhuntingapi.dto.HeroExcelDTO;
import com.waper.jobhuntingapi.entity.Hero;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
            } catch (Exception ex) {
            }
            e.setPictureUrl(heroPic);
        });
        return list;
    }

    @Override
    public void exportHeroList(HttpServletResponse response) {
        List<Hero> list = baseMapper.selectList(new LambdaQueryWrapper<>());
        list.forEach(e -> {
            try {
                String heroPicUrl = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket("hero").object(e.getEname() + stuffName).build());
                e.setPictureUrl(heroPicUrl);
                e.setHeroType(HeroTypeEnum.getNameByValue(e.getHeroType())  == null ? e.getHeroType() :HeroTypeEnum.getNameByValue(e.getHeroType()));
//                e.setNewType(HeroTypeEnum.getNameByValue(e.getNewType())  == null ? e.getNewType() :HeroTypeEnum.getNameByValue(e.getNewType()));
            } catch (Exception exception) {
                System.err.println(exception);
                exception.printStackTrace();
            }
        });
        ExcelUtil.exportExcel("hero数据","hero数据sheep",list, HeroExcelDTO.class,response);
    }

    @Override
    public void importUser(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), HeroExcelDTO.class,new HeroExcelListener(this))
                    .sheet(0)
                    .headRowNumber(1)
                    .doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

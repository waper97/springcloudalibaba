package com.waper.jobhunting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waper.jobhuntingapi.entity.Hero;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface HeroService extends IService<Hero> {
    /**
     *
     * @return
     */
    List<Hero> listHero();

    /**
     * 导出列表
     */
    void exportHeroList(HttpServletResponse response);

    /**
     * 导入
     * @param file
     */
    void importUser(MultipartFile file);
}

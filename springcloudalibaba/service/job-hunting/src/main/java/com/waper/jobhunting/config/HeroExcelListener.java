package com.waper.jobhunting.config;

import cn.hutool.core.util.IdUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.waper.common.constant.HeroTypeEnum;
import com.waper.common.entity.User;
import com.waper.jobhunting.service.HeroService;
import com.waper.jobhuntingapi.dto.HeroExcelDTO;
import com.waper.jobhuntingapi.entity.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangpeng
 * @ClassName HeroExcelListener
 * @description TODO
 * @date 2023/12/21 15:19
 */
@Slf4j
public class HeroExcelListener implements ReadListener<HeroExcelDTO> {

    /**
     * 每隔10条数据存储数据库，然后清理List,方便内存回收
     */
    private static final int BATCH_COUNT = 10;

    /**
     * 缓存的数据
     */
    private List<HeroExcelDTO> cacheList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    @Autowired
    private HeroService heroService;

    public HeroExcelListener(HeroService heroService) {
        this.heroService = heroService;
    }

    @Override
    public void invoke(HeroExcelDTO hero, AnalysisContext analysisContext) {
        log.info("解析到一条数据user:{}", JSON.toJSONString(hero));
        cacheList.add(hero);

        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cacheList.size() >= BATCH_COUNT) {
            // 保存数据

            // 存储完成清理list
            cacheList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }

    }

    /**
     * 所有数据解析完成后才会调用
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }

    /**
     * 保存数据
     */
    public void saveData() {
        log.info("一共{}条数据，开始存储数据库！", cacheList.size());
        if (CollectionUtils.isNotEmpty(cacheList)) {
            List<Hero> userList = cacheList.stream().map(item -> new Hero()
                            .setId(IdUtil.getSnowflakeNextId())
                            .setEname(item.getEname())
                            .setCname(item.getCname())
                            .setTitle(item.getTitle())
                            .setTime(item.getTime())
                            .setNewType(item.getNewType())
                            .setHeroType(HeroTypeEnum.getValueByName(item.getHeroType()))
                            .setSkinName(item.getSkinName())
                            .setMossId(item.getMossId())
                            .setPictureUrl(item.getPictureUrl()))
                    .collect(Collectors.toList());

            // 批量保存
            heroService.saveBatch(userList);
        }
        log.info("存储数据库成功！");
    }
}


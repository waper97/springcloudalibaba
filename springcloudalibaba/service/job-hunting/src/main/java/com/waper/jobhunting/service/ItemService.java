package com.waper.jobhunting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.waper.jobhuntingapi.entity.Hero;
import com.waper.jobhuntingapi.entity.Item;

import java.util.List;

public interface ItemService extends IService<Item> {

    /**
     *
     * @return
     */
    List<Item> listItem();
}

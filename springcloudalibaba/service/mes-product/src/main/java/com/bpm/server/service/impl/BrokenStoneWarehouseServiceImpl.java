package com.bpm.server.service.impl;

import com.bpm.common.dto.BrokenStoneWarehouseInsertOrUpdateDTO;
import com.bpm.common.vo.BrokenStoneWarehouseVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.BrokenStoneWarehouseMapper;
import com.bpm.server.service.BrokenStoneWarehouseService;
import com.bpm.common.domain.BrokenStoneWarehouse;
import com.bpm.common.dto.BrokenStoneWarehouseDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

/**
 * 碎石仓 服务实现类
 *
 * @author wangpeng
 * @since 2022-04-29 10:24:45
 */
@Service
public class BrokenStoneWarehouseServiceImpl implements BrokenStoneWarehouseService {
    @Resource
    private BrokenStoneWarehouseMapper brokenStoneWarehouseMapper;


    @Override
    public List<BrokenStoneWarehouseVO> queryAll(BrokenStoneWarehouseDTO brokenStoneWarehouse) {
        return this.brokenStoneWarehouseMapper.queryAll(brokenStoneWarehouse);
    }


    @Override
    public BrokenStoneWarehouse queryById(Integer id) {
        return this.brokenStoneWarehouseMapper.queryById(id);
    }


    @Override
    public PageInfoVO<BrokenStoneWarehouseVO> queryByPage(BrokenStoneWarehouseDTO brokenStoneWarehouse) {
        PageHelper.startPage(brokenStoneWarehouse.getPageNum(), brokenStoneWarehouse.getPageSize());
        List<BrokenStoneWarehouseVO> brokenStoneWarehouseVOList = this.brokenStoneWarehouseMapper.queryAll(brokenStoneWarehouse);

        PageInfo<BrokenStoneWarehouseVO> pageInfo = new PageInfo<>(brokenStoneWarehouseVOList);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;

    }


    @Override
    public boolean insert(BrokenStoneWarehouse brokenStoneWarehouse) {
        BrokenStoneWarehouse instance = new BrokenStoneWarehouse();
        BeanUtils.copyProperties(brokenStoneWarehouse, instance);
        return this.brokenStoneWarehouseMapper.insert(instance) > 0;
    }


    @Override
    public boolean update(BrokenStoneWarehouseInsertOrUpdateDTO brokenStoneWarehouse) {
        return this.brokenStoneWarehouseMapper.updateSelective(brokenStoneWarehouse) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.brokenStoneWarehouseMapper.deleteById(id) > 0;
    }


    @Override
    public boolean removeById(Integer id) {
        return this.brokenStoneWarehouseMapper.removeById(id) > 0;
    }

}

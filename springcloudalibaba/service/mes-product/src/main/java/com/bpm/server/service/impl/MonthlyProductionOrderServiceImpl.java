package com.bpm.server.service.impl;

import com.bpm.common.domain.MonthlyProductionOrder;
import com.bpm.common.dto.MonthlyProductionOrderDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.MonthlyProductionOrderMapper;
import com.bpm.server.service.MonthlyProductionOrderService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 月生产订单 服务实现类
 * @author wangpeng
 * @since 2022-05-17 17:21:07
 */
@Service
public class MonthlyProductionOrderServiceImpl implements MonthlyProductionOrderService {
    @Resource
    private MonthlyProductionOrderMapper monthlyProductionOrderMapper;

    @Autowired
    private NumberUtil numberUtil;
        
    @Override
    public List<MonthlyProductionOrder> queryAll(MonthlyProductionOrderDTO monthlyProductionOrder) {
 
        return this.monthlyProductionOrderMapper.queryAll(monthlyProductionOrder);
    }
        
 
    @Override
    public MonthlyProductionOrder queryById(Integer id) {
        return this.monthlyProductionOrderMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<MonthlyProductionOrder> queryByPage(MonthlyProductionOrderDTO monthlyProductionOrder) {
        PageHelper.startPage(monthlyProductionOrder.getPageNum(),monthlyProductionOrder.getPageSize());
        List<MonthlyProductionOrder> monthlyProductionOrderList = this.monthlyProductionOrderMapper.queryAll(monthlyProductionOrder);
         
        PageInfo<MonthlyProductionOrder> pageInfo = new PageInfo<>(monthlyProductionOrderList);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    public boolean insert(MonthlyProductionOrder monthlyProductionOrder) {
        String code = numberUtil.contextLoads("YSO");
        monthlyProductionOrder.setDocumentCode(code);
        monthlyProductionOrder.setCreateTime(LocalDateTime.now());
        monthlyProductionOrder.setStatus(1);
        return this.monthlyProductionOrderMapper.insert(monthlyProductionOrder) > 0;
    }

    
    @Override
    public boolean update(MonthlyProductionOrder monthlyProductionOrder) {
        monthlyProductionOrder.setUpdateTime(LocalDateTime.now());
        return this.monthlyProductionOrderMapper.update(monthlyProductionOrder) > 0 ;
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.monthlyProductionOrderMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.monthlyProductionOrderMapper.removeById(id) > 0;
    }
    
}

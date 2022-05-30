package com.bpm.server.service.impl;

import com.bpm.common.domain.PlanScheme;
import com.bpm.common.dto.PlanSchemeDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.PlanSchemeVO;
import com.bpm.server.mapper.PlanSchemeMapper;
import com.bpm.server.service.PlanSchemeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 *  计划方案 服务实现类
 * @author wangpeng
 * @since 2022-05-18 14:53:11
 */
@Service
public class PlanSchemeServiceImpl implements PlanSchemeService {
    @Resource
    private PlanSchemeMapper planSchemeMapper;
        
    @Override
    public List<PlanSchemeVO> queryAll(PlanSchemeDTO planScheme) {
 
        return this.planSchemeMapper.queryAll(planScheme);
    }
        
 
    @Override
    public PlanScheme queryById(Integer id) {
        return this.planSchemeMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<PlanSchemeVO> queryByPage(PlanSchemeDTO planScheme) {
        PageHelper.startPage(planScheme.getPageNum(),planScheme.getPageSize());
        List<PlanSchemeVO> planSchemeList = this.planSchemeMapper.queryAll(planScheme);
         
        PageInfo<PlanSchemeVO> pageInfo = new PageInfo<>(planSchemeList);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    public boolean insert(PlanScheme planScheme) {
        planScheme.setStatus(1);
        planScheme.setCreateTime(LocalDateTime.now());
        return this.planSchemeMapper.insert(planScheme) > 0;
    }

    
    @Override
    public boolean update(PlanScheme planScheme) {
        planScheme.setUpdateTime(LocalDateTime.now());
        return this.planSchemeMapper.update(planScheme) > 0 ;
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.planSchemeMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.planSchemeMapper.removeById(id) > 0;
    }
    
}

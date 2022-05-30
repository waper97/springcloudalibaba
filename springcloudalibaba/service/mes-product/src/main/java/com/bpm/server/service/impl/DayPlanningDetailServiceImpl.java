package com.bpm.server.service.impl;

import com.bpm.common.domain.DayPlanningDetail;
import com.bpm.common.dto.DayPlanningDetailDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.DayPlanningDetailMapper;
import com.bpm.server.service.DayPlanningDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日生产计划详情 服务实现类
 * @author wangpeng
 * @since 2022-05-06 10:00:24
 */
@Service
public class DayPlanningDetailServiceImpl implements DayPlanningDetailService {
    @Resource
    private DayPlanningDetailMapper dayPlanningDetailMapper;
        
    @Override
    public List<DayPlanningDetail> queryAll(DayPlanningDetailDTO dayPlanningDetail) {
 
        return this.dayPlanningDetailMapper.queryAll(dayPlanningDetail);
    }
        
 
    @Override
    public DayPlanningDetail queryById(Integer id) {
        return this.dayPlanningDetailMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<DayPlanningDetail> queryByPage(DayPlanningDetailDTO dayPlanningDetail) {
        PageHelper.startPage(dayPlanningDetail.getPageNum(),dayPlanningDetail.getPageSize());
        List<DayPlanningDetail> dayPlanningDetailList = this.dayPlanningDetailMapper.queryAll(dayPlanningDetail);
         
        PageInfo<DayPlanningDetail> pageInfo = new PageInfo<>(dayPlanningDetailList);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    public boolean insert(DayPlanningDetail dayPlanningDetail) {
        return this.dayPlanningDetailMapper.insert(dayPlanningDetail) > 0;
    }

    
    @Override
    public boolean update(DayPlanningDetail dayPlanningDetail) {
        return this.dayPlanningDetailMapper.update(dayPlanningDetail) > 0 ;
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.dayPlanningDetailMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.dayPlanningDetailMapper.removeById(id) > 0;
    }
    
}

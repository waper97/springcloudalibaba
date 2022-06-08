package com.bpm.server.service.impl;

import com.bpm.common.domain.DayMaterialRequirementsPlanningDetail;
import com.bpm.common.dto.DayMaterialRequirementsPlanningDetailDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.DayMaterialRequirementsPlanningDetailMapper;
import com.bpm.server.service.DayMaterialRequirementsPlanningDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日物料需求计划详情 服务实现类
 * @author wangpeng
 * @since 2022-05-27 16:40:50
 */
@Service
public class DayMaterialRequirementsPlanningDetailServiceImpl implements DayMaterialRequirementsPlanningDetailService {
    @Resource
    private DayMaterialRequirementsPlanningDetailMapper dayMaterialRequirementsPlanningDetailMapper;
        
    @Override
    public List<DayMaterialRequirementsPlanningDetail> queryAll(DayMaterialRequirementsPlanningDetailDTO dayMaterialRequirementsPlanningDetail) {
 
        return this.dayMaterialRequirementsPlanningDetailMapper.queryAll(dayMaterialRequirementsPlanningDetail);
    }
        
 
    @Override
    public DayMaterialRequirementsPlanningDetail queryById(Integer id) {
        return this.dayMaterialRequirementsPlanningDetailMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<DayMaterialRequirementsPlanningDetail> queryByPage(DayMaterialRequirementsPlanningDetailDTO dayMaterialRequirementsPlanningDetail) {
        PageHelper.startPage(dayMaterialRequirementsPlanningDetail.getPageNum(),dayMaterialRequirementsPlanningDetail.getPageSize());
        List<DayMaterialRequirementsPlanningDetail> dayMaterialRequirementsPlanningDetailList = this.dayMaterialRequirementsPlanningDetailMapper.queryAll(dayMaterialRequirementsPlanningDetail);
         
        PageInfo<DayMaterialRequirementsPlanningDetail> pageInfo = new PageInfo<>(dayMaterialRequirementsPlanningDetailList);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    public boolean insert(DayMaterialRequirementsPlanningDetail dayMaterialRequirementsPlanningDetail) {
        return this.dayMaterialRequirementsPlanningDetailMapper.insert(dayMaterialRequirementsPlanningDetail) > 0;
    }

    
    @Override
    public boolean update(DayMaterialRequirementsPlanningDetail dayMaterialRequirementsPlanningDetail) {
        return this.dayMaterialRequirementsPlanningDetailMapper.update(dayMaterialRequirementsPlanningDetail) > 0 ;
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.dayMaterialRequirementsPlanningDetailMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.dayMaterialRequirementsPlanningDetailMapper.removeById(id) > 0;
    }
    
}

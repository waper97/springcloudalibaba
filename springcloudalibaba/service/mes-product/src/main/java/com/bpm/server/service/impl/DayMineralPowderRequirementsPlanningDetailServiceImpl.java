package com.bpm.server.service.impl;

import com.bpm.common.domain.DayMineralPowderRequirementsPlanningDetail;
import com.bpm.common.dto.DayMineralPowderRequirementsPlanningDetailDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.DayMineralPowderRequirementsPlanningDetailMapper;
import com.bpm.server.service.DayMineralPowderRequirementsPlanningDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日矿粉需求计划详情 服务实现类
 *
 * @author wangpeng
 * @since 2022-04-26 10:13:14
 */
@Service
public class DayMineralPowderRequirementsPlanningDetailServiceImpl implements DayMineralPowderRequirementsPlanningDetailService {
    @Resource
    private DayMineralPowderRequirementsPlanningDetailMapper dayMineralPowderRequirementsPlanningDetailMapper;
        
    @Override
    public List<DayMineralPowderRequirementsPlanningDetail> queryAll(DayMineralPowderRequirementsPlanningDetailDTO dayMineralPowderRequirementsPlanningDetailDTO) {
        DayMineralPowderRequirementsPlanningDetail dayMineralPowderRequirementsPlanningDetail = new DayMineralPowderRequirementsPlanningDetail();
        BeanUtils.copyProperties(dayMineralPowderRequirementsPlanningDetailDTO, dayMineralPowderRequirementsPlanningDetail);
        return this.dayMineralPowderRequirementsPlanningDetailMapper.queryAll(dayMineralPowderRequirementsPlanningDetail);
    }
        
 
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DayMineralPowderRequirementsPlanningDetail queryById(Integer id) {
        return this.dayMineralPowderRequirementsPlanningDetailMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dayMineralPowderRequirementsPlanningDetailDTO 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<DayMineralPowderRequirementsPlanningDetail> queryByPage(DayMineralPowderRequirementsPlanningDetailDTO dayMineralPowderRequirementsPlanningDetailDTO) {
        PageHelper.startPage(dayMineralPowderRequirementsPlanningDetailDTO.getPageNum(),dayMineralPowderRequirementsPlanningDetailDTO.getPageSize());
        DayMineralPowderRequirementsPlanningDetail dayMineralPowderRequirementsPlanningDetail = new DayMineralPowderRequirementsPlanningDetail();
        BeanUtils.copyProperties(dayMineralPowderRequirementsPlanningDetailDTO, dayMineralPowderRequirementsPlanningDetail);
        List<DayMineralPowderRequirementsPlanningDetail> dayMineralPowderRequirementsPlanningDetailList = this.dayMineralPowderRequirementsPlanningDetailMapper.queryAll(dayMineralPowderRequirementsPlanningDetail);
        PageInfo<DayMineralPowderRequirementsPlanningDetail> pageInfo = new PageInfo<>(dayMineralPowderRequirementsPlanningDetailList);
        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

    /**
     * 新增数据
     *
     * @param dayMineralPowderRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(DayMineralPowderRequirementsPlanningDetail dayMineralPowderRequirementsPlanningDetail) {
        return this.dayMineralPowderRequirementsPlanningDetailMapper.insert(dayMineralPowderRequirementsPlanningDetail) > 0;
    }

    /**
     * 修改数据
     *
     * @param dayMineralPowderRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(DayMineralPowderRequirementsPlanningDetail dayMineralPowderRequirementsPlanningDetail) {
        return this.dayMineralPowderRequirementsPlanningDetailMapper.update(dayMineralPowderRequirementsPlanningDetail) > 0 ;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dayMineralPowderRequirementsPlanningDetailMapper.deleteById(id) > 0;
    }
    
      /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.dayMineralPowderRequirementsPlanningDetailMapper.removeById(id) > 0;
    }
    
}

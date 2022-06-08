package com.bpm.server.service.impl;

import com.bpm.common.domain.DayMasterProductionPlaning;
import com.bpm.common.dto.DayMasterProductionPlaningDTO;
import com.bpm.common.vo.DayMasterProductionPlaningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.DayMasterProductionPlaningMapper;
import com.bpm.server.service.DayMasterProductionPlaningService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 日主生产计划 服务实现类
 *
 * @author wangpeng
 * @since 2022-04-26 16:00:43
 */
@Service
public class DayMasterProductionPlaningServiceImpl implements DayMasterProductionPlaningService {
    @Resource
    private DayMasterProductionPlaningMapper dayMasterProductionPlaningMapper;
    @Resource
    private NumberUtil numberUtil;

    @Override
    public List<DayMasterProductionPlaningVO> queryAll(DayMasterProductionPlaningDTO dayMasterProductionPlaningDTO) {
        return this.dayMasterProductionPlaningMapper.queryAll(dayMasterProductionPlaningDTO);
    }
        
 
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DayMasterProductionPlaningVO queryById(Integer id) {
        return this.dayMasterProductionPlaningMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dayMasterProductionPlaningDTO 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<DayMasterProductionPlaningVO> queryByPage(DayMasterProductionPlaningDTO dayMasterProductionPlaningDTO) {
        PageHelper.startPage(dayMasterProductionPlaningDTO.getPageNum(),dayMasterProductionPlaningDTO.getPageSize());

        List<DayMasterProductionPlaningVO> dayMasterProductionPlaningList = this.dayMasterProductionPlaningMapper.queryAll(dayMasterProductionPlaningDTO);
        PageInfo<DayMasterProductionPlaningVO> pageInfo = new PageInfo<>(dayMasterProductionPlaningList);
        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo,pageInfoVO);

        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

    /**
     * 新增数据
     *
     * @param dayMasterProductionPlaning 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(DayMasterProductionPlaning dayMasterProductionPlaning) {
        dayMasterProductionPlaning.setCode(numberUtil.contextLoads("ms"));
        dayMasterProductionPlaning.setCreateTime(LocalDateTime.now());
        dayMasterProductionPlaning.setStatus(1);
        return this.dayMasterProductionPlaningMapper.insert(dayMasterProductionPlaning) > 0;
    }

    /**
     * 修改数据
     *
     * @param dayMasterProductionPlaning 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(DayMasterProductionPlaning dayMasterProductionPlaning) {
        dayMasterProductionPlaning.setUpdateTime(LocalDateTime.now());
        return this.dayMasterProductionPlaningMapper.update(dayMasterProductionPlaning) > 0 ;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dayMasterProductionPlaningMapper.deleteById(id) > 0;
    }
    
      /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.dayMasterProductionPlaningMapper.removeById(id) > 0;
    }
    
}

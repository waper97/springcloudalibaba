package com.bpm.server.service.impl;

import com.bpm.common.domain.DayMaterialRequirementsPlanning;
import com.bpm.common.dto.DayMaterialRequirementsPlanningDTO;
import com.bpm.common.vo.DayMaterialRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.DayMaterialRequirementsPlanningMapper;
import com.bpm.server.service.DayMaterialRequirementsPlanningService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日物料需求计划 服务实现类
 *
 * @author wangpeng
 * @since 2022-04-27 10:29:25
 */
@Service
public class DayMaterialRequirementsPlanningServiceImpl implements DayMaterialRequirementsPlanningService {
    @Resource
    private DayMaterialRequirementsPlanningMapper dayMaterialRequirementsPlanningMapper;

    @Autowired
    private NumberUtil numberUtil;
        
    @Override
    public List<DayMaterialRequirementsPlanningVO> queryAll(DayMaterialRequirementsPlanningDTO dayMaterialRequirementsPlanningDTO) {
        return this.dayMaterialRequirementsPlanningMapper.queryAll(dayMaterialRequirementsPlanningDTO);
    }
        
 
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DayMaterialRequirementsPlanningVO queryById(Integer id) {
        return this.dayMaterialRequirementsPlanningMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dayMaterialRequirementsPlanningDTO 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<DayMaterialRequirementsPlanningVO> queryByPage(DayMaterialRequirementsPlanningDTO dayMaterialRequirementsPlanningDTO) {
        PageHelper.startPage(dayMaterialRequirementsPlanningDTO.getPageNum(),dayMaterialRequirementsPlanningDTO.getPageSize());
        List<DayMaterialRequirementsPlanningVO> dayMaterialRequirementsPlanningList = this.dayMaterialRequirementsPlanningMapper.queryAll(dayMaterialRequirementsPlanningDTO);
        PageInfo<DayMaterialRequirementsPlanningVO> pageInfo = new PageInfo<>(dayMaterialRequirementsPlanningList);

        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());

        return pageInfoVO;
       
    }

    /**
     * 新增数据
     *
     * @param dayMaterialRequirementsPlanning 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning) {
        String code = numberUtil.contextLoads("DRP");
        dayMaterialRequirementsPlanning.setCode(code);
        return this.dayMaterialRequirementsPlanningMapper.insert(dayMaterialRequirementsPlanning) > 0;
    }

    /**
     * 修改数据
     *
     * @param dayMaterialRequirementsPlanning 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning) {
        return this.dayMaterialRequirementsPlanningMapper.update(dayMaterialRequirementsPlanning) > 0 ;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dayMaterialRequirementsPlanningMapper.deleteById(id) > 0;
    }
    
      /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.dayMaterialRequirementsPlanningMapper.removeById(id) > 0;
    }
    
}

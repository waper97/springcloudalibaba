package com.bpm.server.service;

import com.bpm.common.domain.DayMineralPowderRequirementsPlanningDetail;
import com.bpm.common.dto.DayMineralPowderRequirementsPlanningDetailDTO;
import com.bpm.common.vo.PageInfoVO;

import java.util.List;
/**
 * 日矿粉需求计划详情 表服务接口
 *
 * @author wangpeng
 * @since 2022-04-26 10:13:14
 */
public interface DayMineralPowderRequirementsPlanningDetailService {
       
     /**
     * 条件查询 日矿粉需求计划详情
     *
     * @param dayMineralPowderRequirementsPlanningDetailDTO
     * @param 
     * @return 
     */     
    List<DayMineralPowderRequirementsPlanningDetail> queryAll(DayMineralPowderRequirementsPlanningDetailDTO dayMineralPowderRequirementsPlanningDetailDTO);
       
     /**
     * 分页查询 日矿粉需求计划详情
     * @param dayMineralPowderRequirementsPlanningDetailDTO
     * @return 
     */ 
    PageInfoVO<DayMineralPowderRequirementsPlanningDetail> queryByPage(DayMineralPowderRequirementsPlanningDetailDTO dayMineralPowderRequirementsPlanningDetailDTO);
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DayMineralPowderRequirementsPlanningDetail queryById(Integer id);

    
    /**
     * 新增数据
     *
     * @param dayMineralPowderRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    boolean insert(DayMineralPowderRequirementsPlanningDetail dayMineralPowderRequirementsPlanningDetail);

    /**
     * 修改数据
     *
     * @param dayMineralPowderRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    boolean update(DayMineralPowderRequirementsPlanningDetail dayMineralPowderRequirementsPlanningDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
        /**
     * 根据id逻辑删除
     * @param id  id
     * @return
     */
    boolean removeById(Integer id);

}

package com.bpm.server.service;

import com.bpm.common.domain.DayMineralPowderRequirementsPlanning;
import com.bpm.common.dto.DayMineralPowderRequirementsPlanningDTO;
import com.bpm.common.dto.DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO;
import com.bpm.common.vo.DayMineralPowderRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;

import java.util.List;
/**
 * 日矿粉需求计划 表服务接口
 *
 * @author wangpeng
 * @since 2022-04-26 09:45:14
 */
public interface DayMineralPowderRequirementsPlanningService {
       
     /**
     * 条件查询 日矿粉需求计划
     *
     * @param dayMineralPowderRequirementsPlanningDTO
     * @param 
     * @return 
     */     
    List<DayMineralPowderRequirementsPlanningVO> queryAll(DayMineralPowderRequirementsPlanningDTO dayMineralPowderRequirementsPlanningDTO);
       
     /**
     * 分页查询 日矿粉需求计划
     * @param dayMineralPowderRequirementsPlanningDTO
     * @return 
     */ 
    PageInfoVO<DayMineralPowderRequirementsPlanningVO> queryByPage(DayMineralPowderRequirementsPlanningDTO dayMineralPowderRequirementsPlanningDTO);
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DayMineralPowderRequirementsPlanning queryById(Integer id);
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DayMineralPowderRequirementsPlanningVO getById(Integer id);

    
    /**
     * 新增数据
     *
     * @param dayMineralPowderRequirementsPlanning 传输对象
     * @return
     */
    boolean insert(DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO dayMineralPowderRequirementsPlanning);

    /**
     * 修改数据
     *
     * @param dayMineralPowderRequirementsPlanning 实例对象
     * @return 实例对象
     */
    boolean update(DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO dayMineralPowderRequirementsPlanning);

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

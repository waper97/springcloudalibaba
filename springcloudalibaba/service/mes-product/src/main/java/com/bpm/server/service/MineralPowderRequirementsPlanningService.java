package com.bpm.server.service;

import com.bpm.common.domain.MineralPowderRequirementsPlanning;
import com.bpm.common.dto.MineralPowderRequirementsPlanningDTO;
import com.bpm.common.dto.MineralPowderRequirementsPlanningToInsertOrUpdateDTO;
import com.bpm.common.vo.MineralPowderRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;

import java.util.List;
/**
 * 矿粉需求计划(MineralPowderRequirementsPlanning)表服务接口
 *
 * @author wangpeng
 * @since 2022-04-24 09:39:00
 */
public interface MineralPowderRequirementsPlanningService {
       
     /**
     * 条件查询 矿粉需求计划
     *
     * @param mineralPowderRequirementsPlanningDTO
     * @param 
     * @return 
     */     
    List<MineralPowderRequirementsPlanningVO> queryAll(MineralPowderRequirementsPlanningDTO mineralPowderRequirementsPlanningDTO);
       
     /**
     * 分页查询 矿粉需求计划
     * @param mineralPowderRequirementsPlanningDTO
     * @return 
     */ 
    PageInfoVO<MineralPowderRequirementsPlanningVO> queryByPage(MineralPowderRequirementsPlanningDTO mineralPowderRequirementsPlanningDTO);
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MineralPowderRequirementsPlanning queryById(Integer id);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MineralPowderRequirementsPlanningVO getById(Integer id);

    
    /**
     * 新增数据
     *
     * @param mineralPowderRequirementsPlanning 实例对象
     * @return 实例对象
     */
    boolean insert(MineralPowderRequirementsPlanningToInsertOrUpdateDTO mineralPowderRequirementsPlanning);

    /**
     * 修改数据
     *
     * @param mineralPowderRequirementsPlanning 实例对象
     * @return 实例对象
     */
    boolean update(MineralPowderRequirementsPlanningToInsertOrUpdateDTO mineralPowderRequirementsPlanning);

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

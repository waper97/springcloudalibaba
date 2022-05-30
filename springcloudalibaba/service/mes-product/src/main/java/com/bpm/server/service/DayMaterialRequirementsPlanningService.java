package com.bpm.server.service;

import com.bpm.common.domain.DayMaterialRequirementsPlanning;
import com.bpm.common.dto.DayMaterialRequirementsPlanningDTO;
import java.util.List;

import com.bpm.common.vo.DayMaterialRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
/**
 * 日物料需求计划 表服务接口
 *
 * @author wangpeng
 * @since 2022-04-27 10:29:25
 */
public interface DayMaterialRequirementsPlanningService {
       
     /**
     * 条件查询 日物料需求计划
     *
     * @param dayMaterialRequirementsPlanningDTO
     * @param 
     * @return 
     */     
    List<DayMaterialRequirementsPlanningVO> queryAll(DayMaterialRequirementsPlanningDTO dayMaterialRequirementsPlanningDTO);
       
     /**
     * 分页查询 日物料需求计划
     * @param dayMaterialRequirementsPlanningDTO
     * @return 
     */ 
    PageInfoVO<DayMaterialRequirementsPlanningVO> queryByPage(DayMaterialRequirementsPlanningDTO dayMaterialRequirementsPlanningDTO);
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DayMaterialRequirementsPlanningVO queryById(Integer id);

    
    /**
     * 新增数据
     *
     * @param dayMaterialRequirementsPlanning 实例对象
     * @return 实例对象
     */
    boolean insert(DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning);

    /**
     * 修改数据
     *
     * @param dayMaterialRequirementsPlanning 实例对象
     * @return 实例对象
     */
    boolean update(DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning);

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

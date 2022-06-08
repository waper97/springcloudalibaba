package com.bpm.server.service;

import com.bpm.common.domain.MaterialRequirementsPlanning;
import com.bpm.common.dto.MaterialRequirementsPlanningDTO;
import com.bpm.common.dto.MrpDTO;
import com.bpm.common.vo.MaterialRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;

import java.util.List;

/**
 * 物料需求计划 表服务接口
 *
 * @author wangpeng
 * @since 2022-04-25 11:36:58
 */
public interface MaterialRequirementsPlanningService {
       
     /**
     * 条件查询 物料需求计划
     *
     * @param materialRequirementsPlanningDTO
     * @param 
     * @return 
     */     
    List<MaterialRequirementsPlanningVO> queryAll(MaterialRequirementsPlanningDTO materialRequirementsPlanningDTO);
       
     /**
     * 分页查询 物料需求计划
     * @param materialRequirementsPlanningDTO
     * @return 
     */ 
    PageInfoVO<MaterialRequirementsPlanningVO> queryByPage(MaterialRequirementsPlanningDTO materialRequirementsPlanningDTO);
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MaterialRequirementsPlanning queryById(Integer id);

    
    /**
     * 新增数据
     *
     * @param materialRequirementsPlanning 实例对象
     * @return 实例对象
     */
    boolean insert(MaterialRequirementsPlanning materialRequirementsPlanning);

    /**
     * 修改数据
     *
     * @param materialRequirementsPlanning 实例对象
     * @return 实例对象
     */
    boolean update(MaterialRequirementsPlanning materialRequirementsPlanning);

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

    /**
     * 修改状态
     * @param ids
     * @param status
     * @return
     */
    boolean updateStatusById(List<Integer> ids, Integer status);


    /**
     * 下发
     * @param masterProductionPlan
     * @return
     */
    boolean issued(MaterialRequirementsPlanningDTO masterProductionPlan);

    /**
     * Mps
     * @param mrpDTO
     * @return
     */
    boolean mrp(MrpDTO mrpDTO);


}

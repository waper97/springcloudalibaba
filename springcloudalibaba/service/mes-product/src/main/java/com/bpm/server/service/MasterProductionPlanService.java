package com.bpm.server.service;

import com.bpm.common.domain.MasterProductionPlan;
import com.bpm.common.dto.MasterProductionPlanDTO;
import com.bpm.common.dto.MasterProductionPlanSaveOrUpdateDTO;
import com.bpm.common.dto.PlanSchemeCalculateDTO;
import com.bpm.common.vo.MasterProductionPlanVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;

import java.util.List;
/**
 * 主生产计划 表服务接口
 *
 * @author wangpeng
 * @since 2022-04-24 16:41:28
 */
public interface MasterProductionPlanService {
       
     /**
     * 条件查询 主生产计划
     *
     * @param masterProductionPlanDTO
     * @param 
     * @return 
     */     
    List<MasterProductionPlanVO> queryAll(MasterProductionPlanDTO masterProductionPlanDTO);
       
     /**
     * 分页查询 主生产计划
     * @param masterProductionPlanDTO
     * @return 
     */ 
    PageInfoVO<MasterProductionPlanVO> queryByPage(MasterProductionPlanDTO masterProductionPlanDTO);
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MasterProductionPlanVO queryById(Integer id);

    
    /**
     * 新增数据
     *
     * @param masterProductionPlan 实例对象
     * @return 实例对象
     */
    boolean insert(MasterProductionPlanSaveOrUpdateDTO masterProductionPlan);

    /**
     * 修改数据
     *
     * @param masterProductionPlan 实例对象
     * @return 实例对象
     */
    boolean update(MasterProductionPlanSaveOrUpdateDTO masterProductionPlan);

    /**
     * 修改状态
     * @param ids
     * @return
     */
    boolean updateStatusById(List<Integer> ids, Integer status);

    /**
     * 下发
     * @param masterProductionPlanList
     * @return
     */
    ResultVO issued( List<MasterProductionPlan> masterProductionPlanList);

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
     * mps运算
     * @param planSchemeCalculate
     * @return
     */
    ResultVO mps(PlanSchemeCalculateDTO planSchemeCalculate);

}

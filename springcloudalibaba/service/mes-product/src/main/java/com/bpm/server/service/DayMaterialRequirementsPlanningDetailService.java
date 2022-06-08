package com.bpm.server.service;

import com.bpm.common.domain.DayMaterialRequirementsPlanningDetail;
import com.bpm.common.dto.DayMaterialRequirementsPlanningDetailDTO;
import com.bpm.common.vo.PageInfoVO;

import java.util.List;
/**
 * 日物料需求计划详情 表服务接口
 * @author wangpeng
 * @since 2022-05-27 16:40:50
 */
public interface DayMaterialRequirementsPlanningDetailService {
       
     /**
     * 条件查询 日物料需求计划详情
     * @param dayMaterialRequirementsPlanningDetail
     * @param 
     * @return 
     */     
    List<DayMaterialRequirementsPlanningDetail> queryAll(DayMaterialRequirementsPlanningDetailDTO dayMaterialRequirementsPlanningDetail);
       
     /**
     * 分页查询 日物料需求计划详情
     * @param dayMaterialRequirementsPlanningDetail
     * @return 
     */ 
    PageInfoVO<DayMaterialRequirementsPlanningDetail> queryByPage(DayMaterialRequirementsPlanningDetailDTO dayMaterialRequirementsPlanningDetail);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DayMaterialRequirementsPlanningDetail queryById(Integer id);

    
    /**
     * 新增数据
     * @param dayMaterialRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    boolean insert(DayMaterialRequirementsPlanningDetail dayMaterialRequirementsPlanningDetail);

    /**
     * 修改数据
     * @param dayMaterialRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    boolean update(DayMaterialRequirementsPlanningDetail dayMaterialRequirementsPlanningDetail);

    /**
     * 通过主键删除数据
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

package com.bpm.server.mapper;

import com.bpm.common.domain.DayMaterialRequirementsPlanningDetail;
import com.bpm.common.dto.DayMaterialRequirementsPlanningDetailDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 日物料需求计划详情 数据库访问层
 * @author wangpeng
 * @since 2022-05-27 16:40:50
 */
public interface DayMaterialRequirementsPlanningDetailMapper {
    
     /**
     * 条件查询 日物料需求计划详情
     * @param dayMaterialRequirementsPlanningDetail
     * @return 
     */
   List<DayMaterialRequirementsPlanningDetail> queryAll(DayMaterialRequirementsPlanningDetailDTO dayMaterialRequirementsPlanningDetail);
    
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DayMaterialRequirementsPlanningDetail queryById(Integer id);


    /**
     * 新增数据
     * @param dayMaterialRequirementsPlanningDetail 实例对象
     * @return 影响行数
     */
    int insert(DayMaterialRequirementsPlanningDetail dayMaterialRequirementsPlanningDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<DayMaterialRequirementsPlanningDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DayMaterialRequirementsPlanningDetail> entities);


    /**
     * 修改数据
     * @param dayMaterialRequirementsPlanningDetail 实例对象
     * @return 影响行数
     */
    int update(DayMaterialRequirementsPlanningDetail dayMaterialRequirementsPlanningDetail);
    
   /**
     * 通过主键 选择性 修改数据  
     * @param dayMaterialRequirementsPlanningDetail 实例对象
     * @return 影响行数
     */
    int updateSelective(DayMaterialRequirementsPlanningDetail dayMaterialRequirementsPlanningDetail);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    
  /**
   * 根据id逻辑删除
   * @param id
   * @return
   */
  int removeById(Integer id);

}


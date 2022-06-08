package com.bpm.server.mapper;
import com.bpm.common.domain.DayMaterialRequirementsPlanning;
import com.bpm.common.dto.DayMaterialRequirementsPlanningDTO;
import com.bpm.common.vo.DayMaterialRequirementsPlanningVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 日物料需求计划 数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-27 10:29:25
 */
public interface DayMaterialRequirementsPlanningMapper {
    
     /**
     * 条件查询 日物料需求计划
     * @param dayMaterialRequirementsPlanning
     * @return 
     */
   List<DayMaterialRequirementsPlanningVO> queryAll(DayMaterialRequirementsPlanningDTO dayMaterialRequirementsPlanning);
    
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
     * @return 影响行数
     */
    int insert(DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DayMaterialRequirementsPlanning> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DayMaterialRequirementsPlanning> entities);



    /**
     * 修改数据
     *
     * @param dayMaterialRequirementsPlanning 实例对象
     * @return 影响行数
     */
    int update(DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning);

    int updateAll(DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning);

    /**
     * 通过主键删除数据
     *
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


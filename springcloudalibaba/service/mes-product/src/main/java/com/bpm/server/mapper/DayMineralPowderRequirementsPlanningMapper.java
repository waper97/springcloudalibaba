package com.bpm.server.mapper;

import com.bpm.common.domain.DayMineralPowderRequirementsPlanning;
import com.bpm.common.dto.DayMineralPowderRequirementsPlanningDTO;
import com.bpm.common.vo.DayMineralPowderRequirementsPlanningVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 日矿粉需求计划 数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-26 09:45:14
 */
public interface DayMineralPowderRequirementsPlanningMapper {
    
     /**
     * 条件查询 日矿粉需求计划
     * @param dayMineralPowderRequirementsPlanning
     * @return 
     */
   List<DayMineralPowderRequirementsPlanningVO> queryAll(DayMineralPowderRequirementsPlanningDTO dayMineralPowderRequirementsPlanning);
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DayMineralPowderRequirementsPlanning queryById(Integer id);

    /**
     * 通过ID查询单条数据
     * @param id
     * @return
     */
    DayMineralPowderRequirementsPlanningVO getById(Integer id);


    /**
     * 新增数据
     *
     * @param dayMineralPowderRequirementsPlanning 实例对象
     * @return 影响行数
     */
    int insert(DayMineralPowderRequirementsPlanning dayMineralPowderRequirementsPlanning);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DayMineralPowderRequirementsPlanning> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DayMineralPowderRequirementsPlanning> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DayMineralPowderRequirementsPlanning> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DayMineralPowderRequirementsPlanning> entities);

    /**
     * 修改数据
     *
     * @param dayMineralPowderRequirementsPlanning 实例对象
     * @return 影响行数
     */
    int update(DayMineralPowderRequirementsPlanning dayMineralPowderRequirementsPlanning);

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


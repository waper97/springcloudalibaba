package com.bpm.server.mapper;

import com.bpm.common.domain.MineralPowderRequirementsPlanning;
import com.bpm.common.dto.MineralPowderRequirementsPlanningDTO;
import com.bpm.common.vo.MineralPowderRequirementsPlanningVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 矿粉需求计划(MineralPowderRequirementsPlanning)表数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-24 09:39:00
 */
public interface MineralPowderRequirementsPlanningMapper {
    
     /**
     * 条件查询 矿粉需求计划
     * @param mineralPowderRequirementsPlanning
     * @return 
     */
   List<MineralPowderRequirementsPlanningVO> queryAll(MineralPowderRequirementsPlanningDTO mineralPowderRequirementsPlanning);
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MineralPowderRequirementsPlanningVO queryById(Integer id);


    /**
     * 新增数据
     *
     * @param mineralPowderRequirementsPlanning 实例对象
     * @return 影响行数
     */
    int insert(MineralPowderRequirementsPlanning mineralPowderRequirementsPlanning);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MineralPowderRequirementsPlanning> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MineralPowderRequirementsPlanning> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MineralPowderRequirementsPlanning> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MineralPowderRequirementsPlanning> entities);

    /**
     * 修改数据
     *
     * @param mineralPowderRequirementsPlanning 实例对象
     * @return 影响行数
     */
    int update(MineralPowderRequirementsPlanning mineralPowderRequirementsPlanning);

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


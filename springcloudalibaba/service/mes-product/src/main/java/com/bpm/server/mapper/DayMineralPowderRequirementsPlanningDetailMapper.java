package com.bpm.server.mapper;

import com.bpm.common.domain.DayMineralPowderRequirementsPlanningDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 日矿粉需求计划详情 数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-26 10:13:14
 */
public interface DayMineralPowderRequirementsPlanningDetailMapper {

     /**
     * 条件查询 日矿粉需求计划详情
     * @param dayMineralPowderRequirementsPlanningDetail
     * @return
     */
   List<DayMineralPowderRequirementsPlanningDetail> queryAll(DayMineralPowderRequirementsPlanningDetail dayMineralPowderRequirementsPlanningDetail);
    /**
     * 根据日需求计划id获取  日需求计划详信息
     * @param dayMineralPowderRequirementsPlanningId 日需求计划id
     * @return
     */
   List<DayMineralPowderRequirementsPlanningDetail> listByPowderRequirementsPlanningId(Integer dayMineralPowderRequirementsPlanningId);



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DayMineralPowderRequirementsPlanningDetail queryById(Integer id);


    /**
     * 新增数据
     *
     * @param dayMineralPowderRequirementsPlanningDetail 实例对象
     * @return 影响行数
     */
    int insert(DayMineralPowderRequirementsPlanningDetail dayMineralPowderRequirementsPlanningDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DayMineralPowderRequirementsPlanningDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DayMineralPowderRequirementsPlanningDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DayMineralPowderRequirementsPlanningDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DayMineralPowderRequirementsPlanningDetail> entities);

    /**
     * 修改数据
     *
     * @param dayMineralPowderRequirementsPlanningDetail 实例对象
     * @return 影响行数
     */
    int update(DayMineralPowderRequirementsPlanningDetail dayMineralPowderRequirementsPlanningDetail);

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


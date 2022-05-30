package com.bpm.server.mapper;

import com.bpm.common.domain.MasterProductionPlan;
import com.bpm.common.dto.MasterProductionPlanDTO;
import com.bpm.common.vo.MasterProductionPlanVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;


/**
 * 主生产计划 数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-24 16:41:28
 */
public interface MasterProductionPlanMapper {
    
     /**
     * 条件查询 主生产计划
     * @param masterProductionPlan
     * @return 
     */
   List<MasterProductionPlanVO> queryAll(MasterProductionPlanDTO masterProductionPlan);
    
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
     * @return 影响行数
     */
    int insert(MasterProductionPlan masterProductionPlan);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MasterProductionPlan> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MasterProductionPlan> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MasterProductionPlan> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MasterProductionPlan> entities);

    /**
     * 修改数据
     *
     * @param masterProductionPlan 实例对象
     * @return 影响行数
     */
    int update(MasterProductionPlan masterProductionPlan);

    /**
     * 修改状态
     * @param masterProductionPlan
     * @return
     */
    int updateStatusById(MasterProductionPlan masterProductionPlan);

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

    /**
     * 根据产品id获取即时库存
     * @param id
     * @return
     */
  BigDecimal getInventoryByProductId(Integer id);

}


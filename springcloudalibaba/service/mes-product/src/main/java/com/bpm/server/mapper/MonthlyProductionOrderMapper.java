package com.bpm.server.mapper;

import com.bpm.common.domain.MonthlyProductionOrder;
import com.bpm.common.dto.MonthlyProductionOrderDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 月生产订单 数据库访问层
 * @author wangpeng
 * @since 2022-05-17 17:21:07
 */
public interface MonthlyProductionOrderMapper {
    
     /**
     * 条件查询 月生产订单
     * @param monthlyProductionOrder
     * @return 
     */
   List<MonthlyProductionOrder> queryAll(MonthlyProductionOrderDTO monthlyProductionOrder);
    
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    MonthlyProductionOrder queryById(Integer id);


    /**
     * 新增数据
     * @param monthlyProductionOrder 实例对象
     * @return 影响行数
     */
    int insert(MonthlyProductionOrder monthlyProductionOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<MonthlyProductionOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MonthlyProductionOrder> entities);


    /**
     * 修改数据
     * @param monthlyProductionOrder 实例对象
     * @return 影响行数
     */
    int update(MonthlyProductionOrder monthlyProductionOrder);
    
   /**
     * 通过主键 选择性 修改数据  
     * @param monthlyProductionOrder 实例对象
     * @return 影响行数
     */
    int updateSelective(MonthlyProductionOrder monthlyProductionOrder);

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


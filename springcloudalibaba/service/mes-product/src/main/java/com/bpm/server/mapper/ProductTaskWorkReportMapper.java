package com.bpm.server.mapper;
import com.bpm.common.domain.ProductTaskWorkReport;
import com.bpm.common.dto.ProductTaskWorkReportDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 作业报工 数据库访问层
 * @author wangpeng
 * @since 2022-05-25 14:15:44
 */
public interface ProductTaskWorkReportMapper {
    
     /**
     * 条件查询 作业报工
     * @param productTaskWorkReport
     * @return 
     */
   List<ProductTaskWorkReport> queryAll(ProductTaskWorkReportDTO productTaskWorkReport);
    
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    ProductTaskWorkReport queryById(Integer id);


    /**
     * 新增数据
     * @param productTaskWorkReport 实例对象
     * @return 影响行数
     */
    int insert(ProductTaskWorkReport productTaskWorkReport);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<ProductTaskWorkReport> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProductTaskWorkReport> entities);


    /**
     * 修改数据
     * @param productTaskWorkReport 实例对象
     * @return 影响行数
     */
    int update(ProductTaskWorkReport productTaskWorkReport);
    
   /**
     * 通过主键 选择性 修改数据  
     * @param productTaskWorkReport 实例对象
     * @return 影响行数
     */
    int updateSelective(ProductTaskWorkReport productTaskWorkReport);

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


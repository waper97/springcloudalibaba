package com.bpm.server.mapper;
import com.bpm.common.domain.ProductConsumeWorkReport;
import com.bpm.common.dto.ProductConsumeWorkReportDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 消耗报工 数据库访问层
 * @author wangpeng
 * @since 2022-05-25 14:12:56
 */
public interface ProductConsumeWorkReportMapper {
    
     /**
     * 条件查询 消耗报工
     * @param productConsumeWorkReport
     * @return 
     */
   List<ProductConsumeWorkReport> queryAll(ProductConsumeWorkReportDTO productConsumeWorkReport);
    
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    ProductConsumeWorkReport queryById(Integer id);


    /**
     * 新增数据
     * @param productConsumeWorkReport 实例对象
     * @return 影响行数
     */
    int insert(ProductConsumeWorkReport productConsumeWorkReport);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<ProductConsumeWorkReport> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProductConsumeWorkReport> entities);


    /**
     * 修改数据
     * @param productConsumeWorkReport 实例对象
     * @return 影响行数
     */
    int update(ProductConsumeWorkReport productConsumeWorkReport);
    
   /**
     * 通过主键 选择性 修改数据  
     * @param productConsumeWorkReport 实例对象
     * @return 影响行数
     */
    int updateSelective(ProductConsumeWorkReport productConsumeWorkReport);

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


package com.bpm.server.mapper;
import com.bpm.common.domain.ProductInWorkReport;
import com.bpm.common.dto.ProductInWorkReportDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 生成入库报工 数据库访问层
 * @author wangpeng
 * @since 2022-05-23 14:53:17
 */
public interface ProductInWorkReportMapper {
    
     /**
     * 条件查询 生成入库报工
     * @param productInWorkReport
     * @return 
     */
   List<ProductInWorkReport> queryAll(ProductInWorkReportDTO productInWorkReport);
    
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    ProductInWorkReport queryById(Integer id);


    /**
     * 新增数据
     * @param productInWorkReport 实例对象
     * @return 影响行数
     */
    int insert(ProductInWorkReport productInWorkReport);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<ProductInWorkReport> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProductInWorkReport> entities);


    /**
     * 修改数据
     * @param productInWorkReport 实例对象
     * @return 影响行数
     */
    int update(ProductInWorkReport productInWorkReport);
    
   /**
     * 通过主键 选择性 修改数据  
     * @param productInWorkReport 实例对象
     * @return 影响行数
     */
    int updateSelective(ProductInWorkReport productInWorkReport);

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


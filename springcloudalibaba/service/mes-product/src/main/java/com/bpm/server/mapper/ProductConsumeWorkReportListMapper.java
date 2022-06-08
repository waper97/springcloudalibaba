package com.bpm.server.mapper;
import com.bpm.common.domain.ProductConsumeWorkReportList;
import com.bpm.common.dto.ProductConsumeWorkReportListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 消耗报工明细表 数据库访问层
 * @author wangpeng
 * @since 2022-05-25 14:14:43
 */
public interface ProductConsumeWorkReportListMapper {
    
     /**
     * 条件查询 消耗报工明细表
     * @param productConsumeWorkReportList
     * @return 
     */
   List<ProductConsumeWorkReportList> queryAll(ProductConsumeWorkReportListDTO productConsumeWorkReportList);
    
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    ProductConsumeWorkReportList queryById(Integer id);


    /**
     * 新增数据
     * @param productConsumeWorkReportList 实例对象
     * @return 影响行数
     */
    int insert(ProductConsumeWorkReportList productConsumeWorkReportList);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<ProductConsumeWorkReportList> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProductConsumeWorkReportList> entities);


    /**
     * 修改数据
     * @param productConsumeWorkReportList 实例对象
     * @return 影响行数
     */
    int update(ProductConsumeWorkReportList productConsumeWorkReportList);
    
   /**
     * 通过主键 选择性 修改数据  
     * @param productConsumeWorkReportList 实例对象
     * @return 影响行数
     */
    int updateSelective(ProductConsumeWorkReportList productConsumeWorkReportList);

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


package com.bpm.server.mapper;

import com.bpm.common.domain.PlanScheme;
import com.bpm.common.dto.PlanSchemeDTO;
import com.bpm.common.vo.PlanSchemeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *  计划方案 数据库访问层
 * @author wangpeng
 * @since 2022-05-18 14:53:11
 */
public interface PlanSchemeMapper {
    
     /**
     * 条件查询  计划方案
     * @param planScheme
     * @return 
     */
   List<PlanSchemeVO> queryAll(PlanSchemeDTO planScheme);
    
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    PlanScheme queryById(Integer id);


    /**
     * 新增数据
     * @param planScheme 实例对象
     * @return 影响行数
     */
    int insert(PlanScheme planScheme);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<PlanScheme> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PlanScheme> entities);


    /**
     * 修改数据
     * @param planScheme 实例对象
     * @return 影响行数
     */
    int update(PlanScheme planScheme);
    
   /**
     * 通过主键 选择性 修改数据  
     * @param planScheme 实例对象
     * @return 影响行数
     */
    int updateSelective(PlanScheme planScheme);

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


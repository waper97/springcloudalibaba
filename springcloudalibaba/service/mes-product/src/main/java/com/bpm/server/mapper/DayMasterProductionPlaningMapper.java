package com.bpm.server.mapper;

import com.bpm.common.domain.DayMasterProductionPlaning;
import com.bpm.common.dto.DayMasterProductionPlaningDTO;
import com.bpm.common.vo.DayMasterProductionPlaningVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 日主生产计划 数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-26 16:00:43
 */
public interface DayMasterProductionPlaningMapper {
    
     /**
     * 条件查询 日主生产计划
     * @param dayMasterProductionPlaning
     * @return 
     */
   List<DayMasterProductionPlaningVO> queryAll(DayMasterProductionPlaningDTO dayMasterProductionPlaning);
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DayMasterProductionPlaningVO queryById(Integer id);


    /**
     * 新增数据
     *
     * @param dayMasterProductionPlaning 实例对象
     * @return 影响行数
     */
    int insert(DayMasterProductionPlaning dayMasterProductionPlaning);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DayMasterProductionPlaning> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DayMasterProductionPlaning> entities);



    /**
     * 修改数据
     *
     * @param dayMasterProductionPlaning 实例对象
     * @return 影响行数
     */
    int update(DayMasterProductionPlaning dayMasterProductionPlaning);

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


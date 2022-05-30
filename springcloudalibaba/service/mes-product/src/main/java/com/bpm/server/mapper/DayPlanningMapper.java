package com.bpm.server.mapper;

import com.bpm.common.domain.DayPlanning;
import com.bpm.common.dto.DayPlanningDTO;
import com.bpm.common.dto.DayPlanningInserOrUpdateDTO;
import com.bpm.common.vo.DayPlanningVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 日生产计划 数据库访问层
 * @author wangpeng
 * @since 2022-05-06 09:52:26
 */
public interface DayPlanningMapper {
    
     /**
     * 条件查询 日生产计划
     * @param dayPlanning
     * @return 
     */
   List<DayPlanningVO> queryAll(DayPlanningDTO dayPlanning);
    
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DayPlanningVO queryById(Integer id);


    /**
     * 新增数据
     * @param dayPlanning 实例对象
     * @return 影响行数
     */
    int insert(DayPlanningInserOrUpdateDTO dayPlanning);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<DayPlanning> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DayPlanning> entities);


    /**
     * 修改数据
     * @param dayPlanning 实例对象
     * @return 影响行数
     */
    int update(DayPlanningInserOrUpdateDTO dayPlanning);
    
   /**
     * 通过主键 选择性 修改数据  
     * @param dayPlanning 实例对象
     * @return 影响行数
     */
    int updateSelective(DayPlanningInserOrUpdateDTO dayPlanning);

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


    /**
     * 日配料输送计划
     * @param dayPlanning
     * @return
     */
  List <DayPlanningVO> listDayDosingTransportPlanning(DayPlanningDTO dayPlanning);

    /**
     * 日立磨生产计划
     * @param dayPlanning
     * @return
     */
  List <DayPlanningVO> listDayVerticalMillProductPlanning(DayPlanningDTO dayPlanning);

    /**
     *粉料配料计划
     * @param dayPlanning
     * @return
     */
    // TODO: 成品仓号 没有返回
  List <DayPlanningVO> listPowderDosingPlanning(DayPlanningDTO dayPlanning);

    /**
     * 气力输送计划
     * @param dayPlanning
     * @return
     */
  List <DayPlanningVO> listPneumaticTransportPlanning(DayPlanningDTO dayPlanning);

}


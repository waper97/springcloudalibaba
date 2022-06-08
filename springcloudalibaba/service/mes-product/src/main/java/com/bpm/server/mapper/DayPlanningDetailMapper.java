package com.bpm.server.mapper;

import com.bpm.common.domain.DayPlanningDetail;
import com.bpm.common.dto.DayPlanningDetailDTO;
import com.bpm.common.vo.DayPlanningDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 日生产计划详情 数据库访问层
 * @author wangpeng
 * @since 2022-05-06 10:00:25
 */
public interface DayPlanningDetailMapper {
    
     /**
     * 条件查询 日生产计划详情
     * @param dayPlanningDetail
     * @return 
     */
   List<DayPlanningDetail> queryAll(DayPlanningDetailDTO dayPlanningDetail);

    /**
     * 根据主表id查询子表详情
     * @param dayPlanningId
     * @return
     */
   List<DayPlanningDetailVO> listByDayplaningId(Integer dayPlanningId);

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DayPlanningDetail queryById(Integer id);


    /**
     * 新增数据
     * @param dayPlanningDetail 实例对象
     * @return 影响行数
     */
    int insert(DayPlanningDetail dayPlanningDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<DayPlanningDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DayPlanningDetail> entities);


    /**
     * 修改数据
     * @param dayPlanningDetail 实例对象
     * @return 影响行数
     */
    int update(DayPlanningDetail dayPlanningDetail);
    
   /**
     * 通过主键 选择性 修改数据  
     * @param dayPlanningDetail 实例对象
     * @return 影响行数
     */
    int updateSelective(DayPlanningDetail dayPlanningDetail);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 日计划id
     * @param dayPlanningId
     * @return
     */
    int deleteByDayPlanningId(Integer dayPlanningId);
  /**
   * 根据id逻辑删除
   * @param id
   * @return
   */
  int removeById(Integer id);

    /**
     *  日配料输送计划
     * @return
     */
  List<DayPlanningDetailVO>  listDayDosingTransportPlanningDetail(Integer dayPlanningId);

    /**
     * 日立磨计划
     * @param dayPlanningId
     * @return
     */
  List<DayPlanningDetailVO>  listDayVerticalMillProductPlanning(Integer dayPlanningId);

    /**
     * 粉料投料计划
     * @return
     */
    List<DayPlanningDetailVO>  listPowderDosingPlanning(Integer dayPlanningId);

    /**
     * 气力输送计划
     * @param dayPlanningId
     * @return
     */
    List <DayPlanningDetailVO> listPneumaticTransportPlanning(Integer dayPlanningId);

}


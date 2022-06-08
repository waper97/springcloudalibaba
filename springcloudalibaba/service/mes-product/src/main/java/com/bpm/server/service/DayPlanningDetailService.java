package com.bpm.server.service;

import com.bpm.common.domain.DayPlanningDetail;
import com.bpm.common.dto.DayPlanningDetailDTO;
import com.bpm.common.vo.PageInfoVO;

import java.util.List;
/**
 * 日生产计划详情 表服务接口
 * @author wangpeng
 * @since 2022-05-06 10:00:24
 */
public interface DayPlanningDetailService {
       
     /**
     * 条件查询 日生产计划详情
     * @param dayPlanningDetail
     * @param 
     * @return 
     */     
    List<DayPlanningDetail> queryAll(DayPlanningDetailDTO dayPlanningDetail);
       
     /**
     * 分页查询 日生产计划详情
     * @param dayPlanningDetail
     * @return 
     */ 
    PageInfoVO<DayPlanningDetail> queryByPage(DayPlanningDetailDTO dayPlanningDetail);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DayPlanningDetail queryById(Integer id);

    
    /**
     * 新增数据
     * @param dayPlanningDetail 实例对象
     * @return 实例对象
     */
    boolean insert(DayPlanningDetail dayPlanningDetail);

    /**
     * 修改数据
     * @param dayPlanningDetail 实例对象
     * @return 实例对象
     */
    boolean update(DayPlanningDetail dayPlanningDetail);

    /**
     * 动态修改
     * @param dayPlanningDetail
     * @return
     */
    boolean updateSelective(DayPlanningDetail dayPlanningDetail);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
     /**
     * 根据id逻辑删除
     * @param id  id
     * @return
     */
    boolean removeById(Integer id);

}

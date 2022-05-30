package com.bpm.server.service;

import com.bpm.common.domain.DayMasterProductionPlaning;
import com.bpm.common.dto.DayMasterProductionPlaningDTO;
import java.util.List;

import com.bpm.common.vo.DayMasterProductionPlaningVO;
import com.bpm.common.vo.PageInfoVO;
/**
 * 日主生产计划 表服务接口
 *
 * @author wangpeng
 * @since 2022-04-26 16:00:43
 */
public interface DayMasterProductionPlaningService {
       
     /**
     * 条件查询 日主生产计划
     *
     * @param dayMasterProductionPlaningDTO
     * @param 
     * @return 
     */     
    List<DayMasterProductionPlaningVO> queryAll(DayMasterProductionPlaningDTO dayMasterProductionPlaningDTO);
       
     /**
     * 分页查询 日主生产计划
     * @param dayMasterProductionPlaningDTO
     * @return 
     */ 
    PageInfoVO<DayMasterProductionPlaningVO> queryByPage(DayMasterProductionPlaningDTO dayMasterProductionPlaningDTO);
 
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
     * @return 实例对象
     */
    boolean insert(DayMasterProductionPlaning dayMasterProductionPlaning);

    /**
     * 修改数据
     *
     * @param dayMasterProductionPlaning 实例对象
     * @return 实例对象
     */
    boolean update(DayMasterProductionPlaning dayMasterProductionPlaning);

    /**
     * 通过主键删除数据
     *
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

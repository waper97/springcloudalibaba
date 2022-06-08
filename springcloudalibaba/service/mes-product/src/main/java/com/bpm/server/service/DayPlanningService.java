package com.bpm.server.service;

import com.bpm.common.dto.DayPlanningDTO;
import com.bpm.common.dto.DayPlanningInserOrUpdateDTO;
import com.bpm.common.dto.DayPlanningProductionReport;
import com.bpm.common.vo.DayPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;

import java.util.List;
/**
 * 日生产计划 表服务接口
 * @author wangpeng
 * @since 2022-05-06 09:52:25
 */
public interface DayPlanningService {
       
     /**
     * 条件查询 日生产计划
     * @param dayPlanning
     * @param 
     * @return 
     */     
    List<DayPlanningVO> queryAll(DayPlanningDTO dayPlanning);
       
     /**
     * 分页查询 日生产计划
     * @param dayPlanning
     * @return 
     */ 
    PageInfoVO<DayPlanningVO> queryByPage(DayPlanningDTO dayPlanning);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DayPlanningVO queryById(Integer id);

    
    /**
     * 新增数据
     * @param dayPlanning 实例对象
     * @return 实例对象
     */
    boolean insert(DayPlanningInserOrUpdateDTO dayPlanning);

    /**
     * 修改数据
     * @param dayPlanning 实例对象
     * @return 实例对象
     */
    boolean update(DayPlanningInserOrUpdateDTO dayPlanning);

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

    /**
     * 通用报工接口 日破碎生产计划
     * @return
     */
    ResultVO commonProductionReport(DayPlanningInserOrUpdateDTO dayPlanning);
    // 日破碎 出库
    ResultVO brokenOutStock(DayPlanningProductionReport productionReport);
    //
    ResultVO brokenInStock(DayPlanningProductionReport productionReport);

    /**
     * 日配料工接口
     * @param productionReport
     * @return
     */
    ResultVO dosingTransportOutStock(DayPlanningProductionReport productionReport);


    ResultVO dosingTransportInStock(DayPlanningProductionReport productionReport);

    ResultVO dayVerticalMillProductPlanningOutStock(DayPlanningProductionReport dayPlanningProductionReport);

    ResultVO dayVerticalMillProductPlanningIntStock(DayPlanningProductionReport dayPlanningProductionReport);

    /**
     * 粉料配料
     * @param dayPlanning
     * @return
     */
    ResultVO powderDosingProductionInStock(DayPlanningProductionReport productionReport);

    /**
     * 分了了配料
     * @param dayPlanning
     * @return
     */
    ResultVO powderDosingProductionOutStock(DayPlanningProductionReport productionReport);

    /**
     * 气力运输计划入库
     * @param productionReport
     * @return
     */
    ResultVO pneumaticTransportInStock(DayPlanningProductionReport productionReport);
    /**
     * 气力运输计划出库
     * @param productionReport
     * @return
     */
    ResultVO pneumaticTransportOutStock(DayPlanningProductionReport productionReport);


}

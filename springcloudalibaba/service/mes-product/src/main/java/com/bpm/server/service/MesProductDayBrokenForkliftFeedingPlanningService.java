package com.bpm.server.service;

import com.bpm.common.dto.MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto;
import com.bpm.common.dto.MesProductDayBrokenForkliftFeedingPlanningQueryDto;
import com.bpm.common.vo.MesProductDayBrokenForkliftFeedingPlanningQueryVo;
import com.bpm.common.vo.MesProductDayBrokenForkliftFeedingPlanningVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;

import java.util.List;

/**
 * 日破碎铲车投料计划(MesProductDayBrokenForkliftFeedingPlanning)表服务接口
 *
 * @author zhangzheming
 * @since 2022-04-29 14:00:56
 */
public interface MesProductDayBrokenForkliftFeedingPlanningService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO queryAll();

    /**
     * 分页查
     *
     * @param queryDto 查询条件
     * @return 查询结果
     */
    ResultVO<PageInfoVO<List<MesProductDayBrokenForkliftFeedingPlanningVo>>> queryByPage(MesProductDayBrokenForkliftFeedingPlanningQueryDto queryDto);

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    ResultVO<MesProductDayBrokenForkliftFeedingPlanningQueryVo> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param addDto 实例对象
     * @return 新增结果
     */
    ResultVO insert(MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto addDto);

    /**
     * 修改数据
     *
     * @param planningDto 实例对象
     * @return 修改结果
     */
    ResultVO update(MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto planningDto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    ResultVO deleteById(Integer id);

    /**
     * 根据id逻辑删除
     *
     * @param id id
     * @return
     */
    boolean removeById(Integer id);

}

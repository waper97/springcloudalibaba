package com.bpm.server.service;

import com.bpm.common.domain.MesProductDayMineralArrivalOfTheDemandPlanning;
import com.bpm.common.dto.MesProductDayMineralArrivalOfTheDemandPlanningDto;
import com.bpm.common.vo.MesProductDayMineralArrivalOfTheDemandPlanningVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;

import java.util.List;

/**
 * 日矿石到货需求计划(MesProductDayMineralArrivalOfTheDemandPlanning)表服务接口
 *
 * @author zhangzheming
 * @since 2022-04-29 11:09:13
 */
public interface MesProductDayMineralArrivalOfTheDemandPlanningService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO queryAll();

    /**
     * 分页查询
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanningDto 查询条件
     * @return 查询结果
     */
    ResultVO<PageInfoVO<List<MesProductDayMineralArrivalOfTheDemandPlanningVo>>> queryByPage(MesProductDayMineralArrivalOfTheDemandPlanningDto mesProductDayMineralArrivalOfTheDemandPlanningDto);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 查询结果
     */
    ResultVO queryById(Integer id);


    /**
     * 新增数据
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 实例对象
     * @return 新增结果
     */
    ResultVO insert(MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning);

    /**
     * 修改数据
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 实例对象
     * @return 修改结果
     */
    ResultVO update(MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning);

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

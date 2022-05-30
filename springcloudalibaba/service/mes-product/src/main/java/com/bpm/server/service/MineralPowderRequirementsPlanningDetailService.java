package com.bpm.server.service;

import com.bpm.common.domain.MineralPowderRequirementsPlanningDetail;
import com.bpm.common.dto.MineralPowderRequirementsPlanningDetailDTO;
import com.bpm.common.vo.PageInfoVO;

import java.util.List;

/**
 * 矿粉需求计划详情 表服务接口
 *
 * @author wangpeng
 * @since 2022-04-24 10:20:52
 */
public interface MineralPowderRequirementsPlanningDetailService {

    /**
     * 条件查询 矿粉需求计划详情
     *
     * @param mineralPowderRequirementsPlanningDetailDTO
     * @param
     * @return
     */
    List<MineralPowderRequirementsPlanningDetail> queryAll(MineralPowderRequirementsPlanningDetailDTO mineralPowderRequirementsPlanningDetailDTO);

    /**
     * 分页查询 矿粉需求计划详情
     *
     * @param mineralPowderRequirementsPlanningDetailDTO
     * @return
     */
    PageInfoVO<MineralPowderRequirementsPlanningDetail> queryByPage(MineralPowderRequirementsPlanningDetailDTO mineralPowderRequirementsPlanningDetailDTO);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MineralPowderRequirementsPlanningDetail queryById(Integer id);


    /**
     * 新增数据
     *
     * @param mineralPowderRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    boolean insert(MineralPowderRequirementsPlanningDetail mineralPowderRequirementsPlanningDetail);

    /**
     * 修改数据
     *
     * @param mineralPowderRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    boolean update(MineralPowderRequirementsPlanningDetail mineralPowderRequirementsPlanningDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据id逻辑删除
     *
     * @param id id
     * @return
     */
    boolean removeById(Integer id);

}

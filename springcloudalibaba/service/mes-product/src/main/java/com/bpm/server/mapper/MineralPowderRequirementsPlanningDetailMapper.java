package com.bpm.server.mapper;

import com.bpm.common.domain.MineralPowderRequirementsPlanningDetail;
import com.bpm.common.vo.MineralPowderRequirementsPlanningDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 矿粉需求计划详情 数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-24 10:20:52
 */
public interface MineralPowderRequirementsPlanningDetailMapper {

    /**
     * 条件查询 矿粉需求计划详情
     *
     * @param mineralPowderRequirementsPlanningDetail
     * @return
     */
    List<MineralPowderRequirementsPlanningDetail> queryAll(MineralPowderRequirementsPlanningDetail mineralPowderRequirementsPlanningDetail);

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
     * @return 影响行数
     */
    int insert(MineralPowderRequirementsPlanningDetail mineralPowderRequirementsPlanningDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MineralPowderRequirementsPlanningDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MineralPowderRequirementsPlanningDetail> entities);



    /**
     * 修改数据
     *
     * @param mineralPowderRequirementsPlanningDetail 实例对象
     * @return 影响行数
     */
    int update(MineralPowderRequirementsPlanningDetail mineralPowderRequirementsPlanningDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 根据id逻辑删除
     *
     * @param id
     * @return
     */
    int removeById(Integer id);

    /**
     * 根据矿粉需求计划id 获取矿粉需求计划详情
     * @param mineralPowderRequirementsPlanningId 矿粉需求计划id
     * @return
     */
    List<MineralPowderRequirementsPlanningDetailVO> getByMineralPowderRequirementsPlanningId(Integer mineralPowderRequirementsPlanningId);

}


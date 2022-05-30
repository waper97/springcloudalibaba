package com.bpm.server.service;

import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanningDetail;
import com.bpm.common.dto.PageDTO;
import com.bpm.common.vo.MesProductDayBrokenForkliftFeedingPlanningDetailVo;
import com.bpm.common.vo.ResultVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 日破碎铲车投料计划详情(MesProductDayBrokenForkliftFeedingPlanningDetail)表服务接口
 *
 * @author zhangzheming
 * @since 2022-05-11 09:53:03
 */
public interface MesProductDayBrokenForkliftFeedingPlanningDetailService {

    /**
     * 条件查询
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail
     * @param
     * @return
     */
    List<MesProductDayBrokenForkliftFeedingPlanningDetail> queryAll(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail);

    /**
     * 分页查询
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail
     * @param pageDTO                                          分页查询类
     * @return
     */
    PageInfo<MesProductDayBrokenForkliftFeedingPlanningDetail> queryByPage(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail, PageDTO pageDTO);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MesProductDayBrokenForkliftFeedingPlanningDetail queryById(Integer id);


    /**
     * 新增数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 实体
     * @return 新增结果
     */
    ResultVO insert(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail);

    /**
     * 修改数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 实例对象
     * @return 实例对象
     */
    MesProductDayBrokenForkliftFeedingPlanningDetail update(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail);

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

    /**
     * 根据投料计划id查询所有投料计划详情
     *
     * @param planId 投料计划id
     * @return 投料计划详情vo列表
     */
    ResultVO<List<MesProductDayBrokenForkliftFeedingPlanningDetailVo>> queryByPlanId(Integer planId);
}

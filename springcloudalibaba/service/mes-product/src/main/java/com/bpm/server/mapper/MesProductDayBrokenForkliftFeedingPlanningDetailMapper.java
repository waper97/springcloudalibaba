package com.bpm.server.mapper;

import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanningDetail;
import com.bpm.common.vo.MesProductDayBrokenForkliftFeedingPlanningDetailVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 日破碎铲车投料计划详情(MesProductDayBrokenForkliftFeedingPlanningDetail)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-05-11 09:53:03
 */
public interface MesProductDayBrokenForkliftFeedingPlanningDetailMapper {

    /**
     * 条件查询
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail
     * @return
     */
    List<MesProductDayBrokenForkliftFeedingPlanningDetail> queryAll(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MesProductDayBrokenForkliftFeedingPlanningDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 查询条件
     * @param pageable                                         分页对象
     * @return 对象列表
     */
    List<MesProductDayBrokenForkliftFeedingPlanningDetail> queryAllByLimit(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 查询条件
     * @return 总行数
     */
    long count(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail);

    /**
     * 新增数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 实例对象
     * @return 影响行数
     */
    int insert(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductDayBrokenForkliftFeedingPlanningDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MesProductDayBrokenForkliftFeedingPlanningDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductDayBrokenForkliftFeedingPlanningDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MesProductDayBrokenForkliftFeedingPlanningDetail> entities);

    /**
     * 修改数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 实例对象
     * @return 影响行数
     */
    int update(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail);

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
    boolean removeById(Integer id);

    /**
     * 根据投料计划id删除所有原有投料计划详情
     *
     * @param planId 投料计划id
     * @return 影响行数
     */
    int deleteByPlanId(Integer planId);

    /**
     * 根据投料计划id查询所有投料计划详情
     *
     * @param planId 投料计划id
     * @return 投料计划详情vo列表
     */
    List<MesProductDayBrokenForkliftFeedingPlanningDetailVo> queryByPlanId(Integer planId);
}


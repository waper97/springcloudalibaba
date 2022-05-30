package com.bpm.server.mapper;

import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanning;
import com.bpm.common.dto.MesProductDayBrokenForkliftFeedingPlanningQueryDto;
import com.bpm.common.vo.MesProductDayBrokenForkliftFeedingPlanningVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 日破碎铲车投料计划(MesProductDayBrokenForkliftFeedingPlanning)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-04-29 14:00:56
 */
public interface MesProductDayBrokenForkliftFeedingPlanningMapper {

    /**
     * 条件查询
     *
     * @return 查询结果
     */
    List<MesProductDayBrokenForkliftFeedingPlanning> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MesProductDayBrokenForkliftFeedingPlanningVo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanning 查询条件
     * @param pageable                                   分页对象
     * @return 对象列表
     */
    List<MesProductDayBrokenForkliftFeedingPlanning> queryAllByLimit(MesProductDayBrokenForkliftFeedingPlanning mesProductDayBrokenForkliftFeedingPlanning, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mesProductDayBrokenForkliftFeedingPlanning 查询条件
     * @return 总行数
     */
    long count(MesProductDayBrokenForkliftFeedingPlanning mesProductDayBrokenForkliftFeedingPlanning);

    /**
     * 新增数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanning 实例对象
     * @return 影响行数
     */
    int insert(MesProductDayBrokenForkliftFeedingPlanning mesProductDayBrokenForkliftFeedingPlanning);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductDayBrokenForkliftFeedingPlanning> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MesProductDayBrokenForkliftFeedingPlanning> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductDayBrokenForkliftFeedingPlanning> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MesProductDayBrokenForkliftFeedingPlanning> entities);

    /**
     * 修改数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanning 实例对象
     * @return 影响行数
     */
    int update(MesProductDayBrokenForkliftFeedingPlanning mesProductDayBrokenForkliftFeedingPlanning);

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
     * 分页查询
     *
     * @param queryDto 筛选条件
     * @return 查询结果
     */
    List<MesProductDayBrokenForkliftFeedingPlanningVo> queryByPage(MesProductDayBrokenForkliftFeedingPlanningQueryDto queryDto);
}


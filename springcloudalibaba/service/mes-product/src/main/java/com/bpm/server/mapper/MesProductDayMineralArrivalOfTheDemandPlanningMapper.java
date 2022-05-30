package com.bpm.server.mapper;

import com.bpm.common.domain.MesProductDayMineralArrivalOfTheDemandPlanning;
import com.bpm.common.dto.MesProductDayMineralArrivalOfTheDemandPlanningDto;
import com.bpm.common.vo.MesProductDayMineralArrivalOfTheDemandPlanningVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 日矿石到货需求计划(MesProductDayMineralArrivalOfTheDemandPlanning)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-04-29 11:09:13
 */
public interface MesProductDayMineralArrivalOfTheDemandPlanningMapper {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    List<MesProductDayMineralArrivalOfTheDemandPlanning> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MesProductDayMineralArrivalOfTheDemandPlanning queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 查询条件
     * @param pageable                                       分页对象
     * @return 对象列表
     */
    List<MesProductDayMineralArrivalOfTheDemandPlanning> queryAllByLimit(MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 查询条件
     * @return 总行数
     */
    long count(MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning);

    /**
     * 新增数据
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 实例对象
     * @return 影响行数
     */
    int insert(MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductDayMineralArrivalOfTheDemandPlanning> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MesProductDayMineralArrivalOfTheDemandPlanning> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductDayMineralArrivalOfTheDemandPlanning> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MesProductDayMineralArrivalOfTheDemandPlanning> entities);

    /**
     * 修改数据
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 实例对象
     * @return 影响行数
     */
    int update(MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning);

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
     * 分页查
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanningDto 查询条件
     * @return 查询结果
     */
    List<MesProductDayMineralArrivalOfTheDemandPlanningVo> queryByPage(MesProductDayMineralArrivalOfTheDemandPlanningDto mesProductDayMineralArrivalOfTheDemandPlanningDto);
}


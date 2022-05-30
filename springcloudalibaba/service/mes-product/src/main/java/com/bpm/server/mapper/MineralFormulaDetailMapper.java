package com.bpm.server.mapper;

import com.bpm.common.domain.MineralFormulaDetail;
import com.bpm.common.vo.MineralFormulaDetailVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 矿石配方明细表(MineralFormulaDetail)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-05-09 19:55:37
 */
public interface MineralFormulaDetailMapper {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    List<MineralFormulaDetail> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MineralFormulaDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mineralFormulaDetail 查询条件
     * @param pageable                   分页对象
     * @return 对象列表
     */
    List<MineralFormulaDetail> queryAllByLimit(MineralFormulaDetail mineralFormulaDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mineralFormulaDetail 查询条件
     * @return 总行数
     */
    long count(MineralFormulaDetail mineralFormulaDetail);

    /**
     * 新增数据
     *
     * @param mineralFormulaDetail 实例对象
     * @return 影响行数
     */
    int insert(MineralFormulaDetail mineralFormulaDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MineralFormulaDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MineralFormulaDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MineralFormulaDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MineralFormulaDetail> entities);

    /**
     * 修改数据
     *
     * @param mineralFormulaDetail 实例对象
     * @return 影响行数
     */
    int update(MineralFormulaDetail mineralFormulaDetail);

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
     * 根据矿石配方id查询所有矿石配方详情
     *
     * @param mineralFormulaId 矿石配方id
     * @return 查询结果
     */
    List<MineralFormulaDetailVo> queryByMineralFormulaId(Integer mineralFormulaId);

    /**
     * 根据矿石配方id删除所有原有矿石配方详情
     * @param mineralFormulaId 矿石配方id
     * @return 影响行数
     */
    int deleteByMineralFormulaId(Integer mineralFormulaId);
}
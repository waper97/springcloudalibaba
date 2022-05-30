package com.bpm.server.mapper;

import com.bpm.common.domain.MineralFormula;
import com.bpm.common.dto.MineralFormulaQueryDto;
import com.bpm.common.vo.MineralFormulaVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 矿石配方mapper
 *
 * @author zhangzheming
 * @since 2022-05-09 15:15:57
 */
public interface MineralFormulaMapper {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    List<MineralFormula> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MineralFormulaVo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mineralFormula 查询条件
     * @param pageable       分页对象
     * @return 对象列表
     */
    List<MineralFormula> queryAllByLimit(MineralFormula mineralFormula, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mineralFormula 查询条件
     * @return 总行数
     */
    long count(MineralFormula mineralFormula);

    /**
     * 新增数据
     *
     * @param mineralFormula 实例对象
     * @return 影响行数
     */
    int insert(MineralFormula mineralFormula);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MineralFormula> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MineralFormula> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MineralFormula> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MineralFormula> entities);

    /**
     * 修改数据
     *
     * @param mineralFormula 实例对象
     * @return 影响行数
     */
    int update(MineralFormula mineralFormula);

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
     * @param mineralFormulaQueryDto 查询条件
     * @return 查询结果
     */
    List<MineralFormulaVo> queryByPage(MineralFormulaQueryDto mineralFormulaQueryDto);
}


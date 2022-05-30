package com.bpm.server.mapper;

import com.bpm.common.domain.MesProductPrehomogenizationRecord;
import com.bpm.common.dto.MesProductPrehomogenizationRecordPageQueryDto;
import com.bpm.common.vo.MesProductPreHomogenizationRecordVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 预均化记录表(MesProductPrehomogenizationRecord)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-05-06 11:16:37
 */
public interface MesProductPrehomogenizationRecordMapper {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    List<MesProductPrehomogenizationRecord> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MesProductPreHomogenizationRecordVo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mesProductPrehomogenizationRecord 查询条件
     * @param pageable                          分页对象
     * @return 对象列表
     */
    List<MesProductPrehomogenizationRecord> queryAllByLimit(MesProductPrehomogenizationRecord mesProductPrehomogenizationRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mesProductPrehomogenizationRecord 查询条件
     * @return 总行数
     */
    long count(MesProductPrehomogenizationRecord mesProductPrehomogenizationRecord);

    /**
     * 新增数据
     *
     * @param mesProductPrehomogenizationRecord 实例对象
     * @return 影响行数
     */
    int insert(MesProductPrehomogenizationRecord mesProductPrehomogenizationRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductPrehomogenizationRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MesProductPrehomogenizationRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductPrehomogenizationRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MesProductPrehomogenizationRecord> entities);

    /**
     * 修改数据
     *
     * @param mesProductPrehomogenizationRecord 实例对象
     * @return 影响行数
     */
    int update(MesProductPrehomogenizationRecord mesProductPrehomogenizationRecord);

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
     * @param mesProductPrehomogenizationRecordPageQueryDto 查询条件
     * @return 查询结果
     */
    List<MesProductPreHomogenizationRecordVo> queryByPage(MesProductPrehomogenizationRecordPageQueryDto mesProductPrehomogenizationRecordPageQueryDto);
}


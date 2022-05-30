package com.bpm.server.mapper;

import com.bpm.common.domain.MesProductHomogenizationRecord;
import com.bpm.common.dto.MesProductHomogenizationRecordPageQueryDto;
import com.bpm.common.vo.MesProductHomogenizationRecordVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 均化记录主表(MesProductHomogenizationRecord)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-05-05 17:14:59
 */
public interface MesProductHomogenizationRecordMapper {
    /**
     * 查全部
     *
     * @return 查询结果
     */
    List<MesProductHomogenizationRecord> queryAll();

    /**
     * 查单个
     *
     * @param id 主键
     * @return 实例对象
     */
    MesProductHomogenizationRecordVo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mesProductHomogenizationRecord 查询条件
     * @param pageable                       分页对象
     * @return 对象列表
     */
    List<MesProductHomogenizationRecord> queryAllByLimit(MesProductHomogenizationRecord mesProductHomogenizationRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mesProductHomogenizationRecord 查询条件
     * @return 总行数
     */
    long count(MesProductHomogenizationRecord mesProductHomogenizationRecord);

    /**
     * 新增数据
     *
     * @param mesProductHomogenizationRecord 实例对象
     * @return 影响行数
     */
    int insert(MesProductHomogenizationRecord mesProductHomogenizationRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductHomogenizationRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MesProductHomogenizationRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductHomogenizationRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MesProductHomogenizationRecord> entities);

    /**
     * 修改数据
     *
     * @param mesProductHomogenizationRecord 实例对象
     * @return 影响行数
     */
    int update(MesProductHomogenizationRecord mesProductHomogenizationRecord);

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
     * @param mesProductHomogenizationRecordPageQueryDto 查询条件
     * @return 查询结果
     */
    List<MesProductHomogenizationRecordVo> queryByPage(MesProductHomogenizationRecordPageQueryDto mesProductHomogenizationRecordPageQueryDto);
}


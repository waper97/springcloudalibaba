package com.bpm.server.mapper;

import com.bpm.common.domain.MesProductHomogenizationRecordDetail;
import com.bpm.common.vo.MesProductHomogenizationRecordDetailVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 均化记录详情表(MesProductHomogenizationRecordDetail)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-05-06 18:25:22
 */
public interface MesProductHomogenizationRecordDetailMapper {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    List<MesProductHomogenizationRecordDetail> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MesProductHomogenizationRecordDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mesProductHomogenizationRecordDetail 查询条件
     * @param pageable                             分页对象
     * @return 对象列表
     */
    List<MesProductHomogenizationRecordDetail> queryAllByLimit(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mesProductHomogenizationRecordDetail 查询条件
     * @return 总行数
     */
    long count(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail);

    /**
     * 新增数据
     *
     * @param mesProductHomogenizationRecordDetail 实例对象
     * @return 影响行数
     */
    int insert(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductHomogenizationRecordDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MesProductHomogenizationRecordDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductHomogenizationRecordDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MesProductHomogenizationRecordDetail> entities);

    /**
     * 修改数据
     *
     * @param mesProductHomogenizationRecordDetail 实例对象
     * @return 影响行数
     */
    int update(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail);

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
     * 根据均化记录id查询所有均化记录详情
     *
     * @param homogenizationRecordId 均化记录id
     * @return 查询结果
     */
    List<MesProductHomogenizationRecordDetailVo> queryByHomogenizationRecordId(Integer homogenizationRecordId);

    /**
     * 根据均化记录id删除所有原有均化记录详情
     *
     * @param recordId 均化记录id
     * @return 影响行数
     */
    int deleteByHomogenizationRecordId(Integer recordId);
}


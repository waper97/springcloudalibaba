package com.bpm.server.mapper;

import com.bpm.common.domain.MesProductPrehomogenizationRecordDetail;
import com.bpm.common.vo.MesProductPreHomogenizationRecordDetailVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 预均化记录详情表(MesProductPrehomogenizationRecordDetail)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-05-06 19:06:54
 */
public interface MesProductPrehomogenizationRecordDetailMapper {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    List<MesProductPrehomogenizationRecordDetail> queryAll();

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    MesProductPrehomogenizationRecordDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mesProductPrehomogenizationRecordDetail 查询条件
     * @param pageable                                分页对象
     * @return 对象列表
     */
    List<MesProductPrehomogenizationRecordDetail> queryAllByLimit(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mesProductPrehomogenizationRecordDetail 查询条件
     * @return 总行数
     */
    long count(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail);

    /**
     * 新增数据
     *
     * @param mesProductPrehomogenizationRecordDetail 实例对象
     * @return 影响行数
     */
    int insert(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductPrehomogenizationRecordDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MesProductPrehomogenizationRecordDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductPrehomogenizationRecordDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MesProductPrehomogenizationRecordDetail> entities);

    /**
     * 修改数据
     *
     * @param mesProductPrehomogenizationRecordDetail 实例对象
     * @return 影响行数
     */
    int update(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail);

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
     * 根据预均化记录id查询所有预均化记录详情
     *
     * @param preHomogenizationRecordId 预均化记录id
     * @return 查询结果
     */
    List<MesProductPreHomogenizationRecordDetailVo> queryByPreHomogenizationRecordId(Integer preHomogenizationRecordId);

    /**
     * 根据预均化记录id删除所有原有预均化记录详情
     *
     * @param recordId 预均化记录id
     * @return 影响行数
     */
    int deleteByPreHomogenizationRecordId(Integer recordId);
}


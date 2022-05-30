package com.bpm.server.mapper;

import com.bpm.common.domain.MesProductProductionLine;
import com.bpm.common.dto.MesProductProductionLineDto;
import com.bpm.common.vo.CompanyNameVo;
import com.bpm.common.vo.MesProductProductionLineVo;
import com.bpm.common.vo.ProductionLineNumberVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 生产线表(MesProductProductionLine)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-04-25 09:50:20
 */
public interface MesProductProductionLineMapper {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    List<MesProductProductionLine> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MesProductProductionLine queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mesProductProductionLine 查询条件
     * @param pageable                 分页对象
     * @return 对象列表
     */
    List<MesProductProductionLine> queryAllByLimit(MesProductProductionLine mesProductProductionLine, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mesProductProductionLine 查询条件
     * @return 总行数
     */
    long count(MesProductProductionLine mesProductProductionLine);

    /**
     * 新增数据
     *
     * @param mesProductProductionLine 实例对象
     * @return 影响行数
     */
    int insert(MesProductProductionLine mesProductProductionLine);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductProductionLine> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MesProductProductionLine> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductProductionLine> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MesProductProductionLine> entities);

    /**
     * 修改数据
     *
     * @param mesProductProductionLine 实例对象
     * @return 影响行数
     */
    int update(MesProductProductionLine mesProductProductionLine);

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
     * @param mesProductProductionLineDto 查询条件
     * @return 查询结果
     */
    List<MesProductProductionLineVo> queryByPage(MesProductProductionLineDto mesProductProductionLineDto);

    /**
     * 查询所有生产线编号
     *
     * @return 查询结果
     */
    List<ProductionLineNumberVo> queryAllLineNumbers();

    /**
     * 查询所有公司名称
     *
     * @return 查询结果
     */
    List<CompanyNameVo> queryAllCompanyNames();
}


package com.bpm.server.mapper;

import com.bpm.common.domain.MesProductWorkCenter;
import com.bpm.common.dto.MesProductWorkCenterDto;
import com.bpm.common.vo.MesProductWorkCenterVo;
import com.bpm.common.vo.ResourceCategoryVo;
import com.bpm.common.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 工作中心表(MesProductWorkCenter)表数据库访问层
 *
 * @author zhangzheming
 * @since 2022-04-27 18:00:03
 */
public interface MesProductWorkCenterMapper {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    List<MesProductWorkCenter> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MesProductWorkCenter queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param mesProductWorkCenter 查询条件
     * @param pageable             分页对象
     * @return 对象列表
     */
    List<MesProductWorkCenter> queryAllByLimit(MesProductWorkCenter mesProductWorkCenter, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mesProductWorkCenter 查询条件
     * @return 总行数
     */
    long count(MesProductWorkCenter mesProductWorkCenter);

    /**
     * 新增数据
     *
     * @param mesProductWorkCenter 实例对象
     * @return 影响行数
     */
    int insert(MesProductWorkCenter mesProductWorkCenter);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductWorkCenter> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MesProductWorkCenter> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MesProductWorkCenter> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MesProductWorkCenter> entities);

    /**
     * 修改数据
     *
     * @param mesProductWorkCenter 实例对象
     * @return 影响行数
     */
    int update(MesProductWorkCenter mesProductWorkCenter);

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
     * @param id 主键
     * @return 删除结果
     */
    boolean removeById(Integer id);

    /**
     * 分页查询
     *
     * @param mesProductWorkCenterDto 查询条件
     * @return 查询结果
     */
    List<MesProductWorkCenterVo> queryByPage(MesProductWorkCenterDto mesProductWorkCenterDto);

    /**
     * 查询所有资源类别
     *
     * @return 查询结果
     */
    List<ResourceCategoryVo> queryAllResourceCategories();
}


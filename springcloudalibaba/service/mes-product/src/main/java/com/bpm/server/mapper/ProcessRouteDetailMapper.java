package com.bpm.server.mapper;

import com.bpm.common.domain.ProcessRouteDetail;
import com.bpm.common.dto.ProcessRouteDetailDTO;
import com.bpm.common.vo.ProcessRouteDetailVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 工艺路线详情表(ProcessRouteDetail)表数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-18 16:11:49
 */
public interface ProcessRouteDetailMapper {

    /**
     * 条件查询
     *
     * @param mesProductProcessRouteDetail
     * @return
     */
    List<ProcessRouteDetail> queryAll(ProcessRouteDetailDTO mesProductProcessRouteDetail);

    /**
     * 通过ID查询单条数据
     *
     * @param mesProductProcessRouteId 主键
     * @return 实例对象
     */
    ProcessRouteDetail queryById(String mesProductProcessRouteId);

    /**
     * 查询指定行数据
     *
     * @param processRouteDetail 查询条件
     * @param pageable                     分页对象
     * @return 对象列表
     */
    List<ProcessRouteDetail> queryAllByLimit(ProcessRouteDetail processRouteDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param processRouteDetail 查询条件
     * @return 总行数
     */
    long count(ProcessRouteDetail processRouteDetail);

    /**
     * 新增数据
     *
     * @param processRouteDetail 实例对象
     * @return 影响行数
     */
    int insert(ProcessRouteDetail processRouteDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProcessRouteDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProcessRouteDetailVO> entities);


    /**
     * 修改数据
     *
     * @param processRouteDetail 实例对象
     * @return 影响行数
     */
    int update(ProcessRouteDetail processRouteDetail);

    /**
     * 通过主键删除数据
     *
     * @param mesProductProcessRouteId 主键
     * @return 影响行数
     */
    int deleteById(Integer mesProductProcessRouteId);


    /**
     * 根据id逻辑删除
     *
     * @param id
     * @return
     */
    int removeById(Integer id);

    /**
     *
     * @param productProcessRouteId 工艺路线id
     * @return
     */
    List<ProcessRouteDetail> listByproductProcessRouteId(Integer productProcessRouteId);

    /**
     * 根据工艺路线主表id 获取详情
     * @param productProcessRouteId
     * @return
     */
    List<ProcessRouteDetailVO> listByProcessRouteId(Integer productProcessRouteId);

}


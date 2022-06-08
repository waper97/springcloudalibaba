package com.bpm.server.mapper;

import com.bpm.common.domain.ProcessRoute;
import com.bpm.common.dto.ProcessRouteDTO;
import com.bpm.common.vo.ProcessRouteDetailVO;
import com.bpm.common.vo.ProcessRouteVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 工艺路线主表
 * (ProcessRouteDTO)表数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-18 15:31:14
 */
public interface ProcessRouteMapper {

    /**
     * 条件查询
     *
     * @param mesProductProcessRoute
     * @return
     */
    List<ProcessRouteVO> queryAll(ProcessRouteDTO mesProductProcessRoute);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProcessRoute queryById(Integer id);



    /**
     * 统计总行数
     *
     * @param processRoute 查询条件
     * @return 总行数
     */
    long count(ProcessRoute processRoute);

    /**
     * 新增数据
     *
     * @param processRoute 实例对象
     * @return 影响行数
     */
    int insert(ProcessRoute processRoute);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProcessRouteDTO> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProcessRoute> entities);


    /**
     * 修改数据
     *
     * @param processRoute 实例对象
     * @return 影响行数
     */
    int update(ProcessRoute processRoute);

    /**
     * 修改数据
     * @param processRoute
     * @return
     */
    int updateSelective(ProcessRoute processRoute);

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
    int removeById(Integer id);

    /**
     * 根据工艺路线id获取工艺路线详情
     * @param processRouteId
     * @return
     */
    List<ProcessRouteDetailVO> listProcessRouteDetailByProcessRouteId(Integer processRouteId);

    /**
     * 根据产品id（物料id） 获取工艺路线信息
     * @param processRouteId
     * @return
     */
    ProcessRouteVO getByProductId(Integer processRouteId);

}


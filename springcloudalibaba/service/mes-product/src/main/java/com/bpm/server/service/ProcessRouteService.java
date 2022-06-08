package com.bpm.server.service;

import com.bpm.common.domain.ProcessRoute;
import com.bpm.common.dto.ProcessRouteDTO;
import com.bpm.common.dto.ProcessRouteDetailDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ProcessRouteDetailVO;
import com.bpm.common.vo.ProcessRouteProcceTypeVO;
import com.bpm.common.vo.ProcessRouteVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 工艺路线主表
 * (ProcessRouteDTO)表服务接口
 *
 * @author wangpeng
 * @since 2022-04-18 15:31:13
 */
public interface ProcessRouteService {

    /**
     * 条件查询
     *
     * @param mesProductProcessRoute
     * @param
     * @return
     */
    List<ProcessRouteVO> queryAll(ProcessRouteDTO mesProductProcessRoute);

    /**
     * 分页查询
     *
     * @param mesProductProcessRoute
     * @return
     */
    PageInfoVO<ProcessRouteVO> queryByPage(ProcessRouteDTO mesProductProcessRoute);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProcessRoute queryById(Integer id);


    /**
     * 新增数据
     *
     * @param processRoute 实例对象
     * @return 实例对象
     */
    boolean insert(ProcessRouteVO processRoute);

    /**
     * 修改数据
     *
     * @param processRoute 实例对象
     * @return 实例对象
     */
    boolean update(ProcessRouteVO processRoute);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据id逻辑删除
     *
     * @param id id
     * @return
     */
    boolean removeById(Integer id);

    /**
     * 根据工艺路线id获取工艺路线详情
     * @param processRouteId
     * @return
     */
//    List<ProcessRouteDetail> listProcessRouteDetailByProcessRouteId(Integer processRouteId);
    /**
     * 根据工艺路线id获取工艺路线详情(分页)
     * @param mesProductProcessRouteDetail
     * @return
     */
    PageInfo<ProcessRouteDetailVO> listProcessRouteDetailByProcessRouteId(ProcessRouteDetailDTO mesProductProcessRouteDetail);
    /**
     * 根据工艺路线id获取工艺路线详情
     * @param productProcessRouteId
     * @return
     */
    ProcessRouteVO listProcessRouteDetailByProcessRouteId(Integer productProcessRouteId);

    /**
     * 批量新增 批量添加工艺路线详情信息
     * @param processRouteDetailList
     * @return
     */
    boolean batchSaveProceessRouteDetail(List<ProcessRouteDetailVO> processRouteDetailList);

    /**
     * 获取工艺路线分类列表
     * @return
     */
    List<ProcessRouteProcceTypeVO> listProceessRouteType();

}

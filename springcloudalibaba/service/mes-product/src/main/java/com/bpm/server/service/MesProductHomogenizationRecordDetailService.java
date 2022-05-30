package com.bpm.server.service;

import com.bpm.common.domain.MesProductHomogenizationRecordDetail;
import com.bpm.common.dto.PageDTO;
import com.bpm.common.vo.MesProductHomogenizationRecordDetailVo;
import com.bpm.common.vo.ResultVO;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 均化记录详情表(MesProductHomogenizationRecordDetail)表服务接口
 *
 * @author zhangzheming
 * @since 2022-05-06 18:25:22
 */
public interface MesProductHomogenizationRecordDetailService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO queryAll();

    /**
     * 分页查询
     *
     * @param mesProductHomogenizationRecordDetail
     * @param pageDTO                              分页查询类
     * @return
     */
    PageInfo<MesProductHomogenizationRecordDetail> queryByPage(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail, PageDTO pageDTO);

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    ResultVO queryById(Integer id);


    /**
     * 新增数据
     *
     * @param mesProductHomogenizationRecordDetail 实体
     * @return 新增结果
     */
    ResultVO insert(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail);

    /**
     * 修改数据
     *
     * @param mesProductHomogenizationRecordDetail 实体
     * @return 修改结果
     */
    ResultVO update(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail);

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    ResultVO deleteById(Integer id);

    /**
     * 根据id逻辑删除
     *
     * @param id id
     * @return
     */
    boolean removeById(Integer id);

    /**
     * 根据均化记录id查询所有均化记录详情
     *
     * @param homogenizationRecordId 均化记录id
     * @return 查询结果
     */
    ResultVO<List<MesProductHomogenizationRecordDetailVo>> queryByHomogenizationRecordId(Integer homogenizationRecordId);
}

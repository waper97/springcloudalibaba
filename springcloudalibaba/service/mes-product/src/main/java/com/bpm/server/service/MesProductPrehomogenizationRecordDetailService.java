package com.bpm.server.service;

import com.bpm.common.domain.MesProductPrehomogenizationRecordDetail;
import com.bpm.common.dto.PageDTO;
import com.bpm.common.vo.MesProductPreHomogenizationRecordDetailVo;
import com.bpm.common.vo.ResultVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 预均化记录详情表(MesProductPrehomogenizationRecordDetail)表服务接口
 *
 * @author zhangzheming
 * @since 2022-05-06 19:06:54
 */
public interface MesProductPrehomogenizationRecordDetailService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO queryAll();

    /**
     * 分页查询
     *
     * @param mesProductPrehomogenizationRecordDetail
     * @param pageDTO                                 分页查询类
     * @return
     */
    PageInfo<MesProductPrehomogenizationRecordDetail> queryByPage(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail, PageDTO pageDTO);

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
     * @param mesProductPrehomogenizationRecordDetail 实体
     * @return 新增结果
     */
    ResultVO insert(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail);

    /**
     * 修改数据
     *
     * @param mesProductPrehomogenizationRecordDetail 实体
     * @return 修改结果
     */
    ResultVO update(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail);

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
     * 根据预均化记录id查询所有预均化记录详情
     *
     * @param preHomogenizationRecordId 预均化记录id
     * @return 查询结果
     */
    ResultVO<List<MesProductPreHomogenizationRecordDetailVo>> queryByPreHomogenizationRecordId(Integer preHomogenizationRecordId);
}

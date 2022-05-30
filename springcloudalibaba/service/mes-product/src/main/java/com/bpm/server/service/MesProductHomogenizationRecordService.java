package com.bpm.server.service;

import com.bpm.common.dto.MesProductHomogenizationRecordAddUpdateDto;
import com.bpm.common.dto.MesProductHomogenizationRecordPageQueryDto;
import com.bpm.common.vo.MesProductHomogenizationRecordQueryVo;
import com.bpm.common.vo.MesProductHomogenizationRecordVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;

import java.util.List;

/**
 * 均化记录主表(MesProductHomogenizationRecord)表服务接口
 *
 * @author zhangzheming
 * @since 2022-05-05 17:14:58
 */
public interface MesProductHomogenizationRecordService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO queryAll();

    /**
     * 分页查询
     *
     * @param mesProductHomogenizationRecordPageQueryDto 查询条件
     * @return 查询结果
     */
    ResultVO<PageInfoVO<List<MesProductHomogenizationRecordVo>>> queryByPage(MesProductHomogenizationRecordPageQueryDto mesProductHomogenizationRecordPageQueryDto);

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    ResultVO<MesProductHomogenizationRecordQueryVo> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param recordAddDto 实例对象
     * @return 新增结果
     */
    ResultVO insert(MesProductHomogenizationRecordAddUpdateDto recordAddDto);

    /**
     * 修改数据
     *
     * @param updateDto 实例对象
     * @return 修改结果
     */
    ResultVO update(MesProductHomogenizationRecordAddUpdateDto updateDto);

    /**
     * 通过主键删除数据
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

}

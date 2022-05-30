package com.bpm.server.service;

import com.bpm.common.dto.MesProductPreHomogenizationRecordAddUpdateDto;
import com.bpm.common.dto.MesProductPrehomogenizationRecordPageQueryDto;
import com.bpm.common.vo.MesProductPreHomogenizationRecordQueryVo;
import com.bpm.common.vo.MesProductPreHomogenizationRecordVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;

import java.util.List;

/**
 * 预均化记录表(MesProductPrehomogenizationRecord)表服务接口
 *
 * @author zhangzheming
 * @since 2022-05-06 11:16:37
 */
public interface MesProductPrehomogenizationRecordService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO queryAll();

    /**
     * 分页查
     *
     * @param mesProductPrehomogenizationRecordPageQueryDto 查询条件
     * @return 查询结果
     */
    ResultVO<PageInfoVO<List<MesProductPreHomogenizationRecordVo>>> queryByPage(MesProductPrehomogenizationRecordPageQueryDto mesProductPrehomogenizationRecordPageQueryDto);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 查询结果
     */
    ResultVO<MesProductPreHomogenizationRecordQueryVo> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param addDto 实例对象
     * @return 新增结果
     */
    ResultVO insert(MesProductPreHomogenizationRecordAddUpdateDto addDto);

    /**
     * 修改数据
     *
     * @param updateDto 实例对象
     * @return 修改结果
     */
    ResultVO update(MesProductPreHomogenizationRecordAddUpdateDto updateDto);

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

package com.bpm.server.service;

import com.bpm.common.domain.MineralFormulaDetail;
import com.bpm.common.dto.PageDTO;
import com.bpm.common.vo.MineralFormulaDetailVo;
import com.bpm.common.vo.ResultVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 矿石配方明细表(MineralFormulaDetail)表服务接口
 *
 * @author zhangzheming
 * @since 2022-05-09 19:55:36
 */
public interface MineralFormulaDetailService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO queryAll();

    /**
     * 分页查询
     *
     * @param mineralFormulaDetail
     * @param pageDTO                    分页查询类
     * @return
     */
    PageInfo<MineralFormulaDetail> queryByPage(MineralFormulaDetail mineralFormulaDetail, PageDTO pageDTO);

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
     * @param mineralFormulaDetail 实体
     * @return 新增结果
     */
    ResultVO insert(MineralFormulaDetail mineralFormulaDetail);

    /**
     * 修改数据
     *
     * @param mineralFormulaDetail 实体
     * @return 修改结果
     */
    ResultVO update(MineralFormulaDetail mineralFormulaDetail);

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
     * 根据矿石配方id查询所有矿石配方详情
     *
     * @param mineralFormulaId 矿石配方id
     * @return 查询结果
     */
    ResultVO<List<MineralFormulaDetailVo>> queryByMineralFormulaId(Integer mineralFormulaId);
}

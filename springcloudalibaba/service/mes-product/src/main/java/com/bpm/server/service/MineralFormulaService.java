package com.bpm.server.service;

import com.bpm.common.dto.MineralFormulaAddUpdateDto;
import com.bpm.common.dto.MineralFormulaQueryDto;
import com.bpm.common.vo.MineralFormulaQueryVo;
import com.bpm.common.vo.ResultVO;

/**
 * 矿石配方service
 *
 * @author zhangzheming
 * @since 2022-05-09 15:15:57
 */
public interface MineralFormulaService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO<Object> queryAll();

    /**
     * 分页查
     *
     * @param mineralFormulaQueryDto 查询条件
     * @return 查询结果
     */
    ResultVO<Object> queryByPage(MineralFormulaQueryDto mineralFormulaQueryDto);

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    ResultVO<MineralFormulaQueryVo> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param mineralFormulaAddUpdateDto 实体
     * @return 新增结果
     */
    ResultVO<Object> insert(MineralFormulaAddUpdateDto mineralFormulaAddUpdateDto);

    /**
     * 修改数据
     *
     * @param mineralFormulaAddUpdateDto 实体
     * @return 修改结果
     */
    ResultVO<Object> update(MineralFormulaAddUpdateDto mineralFormulaAddUpdateDto);

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    ResultVO<Object> deleteById(Integer id);

    /**
     * 根据id逻辑删除
     *
     * @param id id
     * @return
     */
    boolean removeById(Integer id);

}

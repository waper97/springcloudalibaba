package com.bpm.server.service.impl;

import com.bpm.common.domain.MineralFormula;
import com.bpm.common.domain.MineralFormulaDetail;
import com.bpm.common.dto.MineralFormulaAddUpdateDto;
import com.bpm.common.dto.MineralFormulaQueryDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.*;
import com.bpm.server.mapper.MineralFormulaDetailMapper;
import com.bpm.server.mapper.MineralFormulaMapper;
import com.bpm.server.service.MineralFormulaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 矿石配方serviceImpl
 *
 * @author zhangzheming
 * @since 2022-05-09 15:15:57
 */
@Service
public class MineralFormulaServiceImpl implements MineralFormulaService {
    /**
     * 矿石配方mapper
     */
    @Resource
    private MineralFormulaMapper mineralFormulaMapper;
    /**
     * 矿石配方详情mapper
     */
    @Resource
    private MineralFormulaDetailMapper mineralFormulaDetailMapper;

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO<Object> queryAll() {
        List<MineralFormula> mineralFormulaList = this.mineralFormulaMapper.queryAll();
        if (mineralFormulaList == null || mineralFormulaList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mineralFormulaList);
    }

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @Override
    public ResultVO<MineralFormulaQueryVo> queryById(Integer id) {

        //查询矿石配方
        MineralFormulaVo formulaVo = this.mineralFormulaMapper.queryById(id);
        if (formulaVo == null) {
            return ResultUtil.error("查询矿石配方失败");
        }

        //查询矿石配方详情列表
        List<MineralFormulaDetailVo> formulaDetailVoList = mineralFormulaDetailMapper.queryByMineralFormulaId(id);
        if (formulaDetailVoList == null || formulaDetailVoList.isEmpty()) {
            return ResultUtil.error("查询矿石配方详情失败或无数据");
        }

        MineralFormulaQueryVo formulaQueryVo = new MineralFormulaQueryVo();
        formulaQueryVo.setMineralFormulaVo(formulaVo);
        formulaQueryVo.setMineralFormulaDetailVoList(formulaDetailVoList);
        return ResultUtil.success(formulaQueryVo);
    }

    /**
     * 分页查
     *
     * @param mineralFormulaQueryDto 查询条件
     * @return 查询结果
     */
    @Override
    public ResultVO<Object> queryByPage(MineralFormulaQueryDto mineralFormulaQueryDto) {
        PageHelper.startPage(mineralFormulaQueryDto.getPageNum(), mineralFormulaQueryDto.getPageSize());
        List<MineralFormulaVo> mineralFormulaVoList = this.mineralFormulaMapper.queryByPage(mineralFormulaQueryDto);
        PageInfo<MineralFormulaVo> pageInfo = new PageInfo<>(mineralFormulaVoList);
        PageInfoVO<Object> pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * 新增数据
     *
     * @param mineralFormulaAddUpdateDto 实体
     * @return 新增结果
     */
    @Override
    public ResultVO<Object> insert(MineralFormulaAddUpdateDto mineralFormulaAddUpdateDto) {

        //判断矿石配方详情比例总和是否为100%
        List<MineralFormulaDetail> mineralFormulaDetailList = mineralFormulaAddUpdateDto.getMineralFormulaDetailList();
        BigDecimal totalPercentage = new BigDecimal(0);
        for (MineralFormulaDetail mineralFormulaDetail : mineralFormulaDetailList) {
            totalPercentage = totalPercentage.add(mineralFormulaDetail.getPercentage());
        }
        if (totalPercentage.compareTo(new BigDecimal(100)) != 0) {
            return ResultUtil.error("矿石配方详情比例总和不为100%");
        }

        //新增矿石配方，获取自增后的id
        MineralFormula mineralFormula = mineralFormulaAddUpdateDto.getMineralFormula();
        mineralFormula.setStatus(0);
        boolean insertMineralFormulaResult = this.mineralFormulaMapper.insert(mineralFormula) > 0;
        if (!insertMineralFormulaResult) {
            return ResultUtil.error("新增矿石配方失败");
        }

        //新增矿石配方详情
        Integer mineralFormulaId = mineralFormula.getId();
        for (MineralFormulaDetail mineralFormulaDetail : mineralFormulaDetailList) {
            mineralFormulaDetail.setMineralFormulaId(mineralFormulaId);
            mineralFormulaDetail.setStatus(0);
            boolean insertMineralFormulaDetailResult = mineralFormulaDetailMapper.insert(mineralFormulaDetail) > 0;
            if (!insertMineralFormulaDetailResult) {
                return ResultUtil.error("新增矿石配方详情失败");
            }
        }

        //走到这一步说明所有矿石配方、矿石配方详情新增成功
        return ResultUtil.success("新增成功");
    }

    /**
     * 修改数据
     *
     * @param mineralFormulaAddUpdateDto 实体
     * @return 修改结果
     */
    @Override
    public ResultVO<Object> update(MineralFormulaAddUpdateDto mineralFormulaAddUpdateDto) {

        //判断矿石配方详情比例总和是否为100%
        List<MineralFormulaDetail> mineralFormulaDetailList = mineralFormulaAddUpdateDto.getMineralFormulaDetailList();
        BigDecimal totalPercentage = new BigDecimal(0);
        for (MineralFormulaDetail mineralFormulaDetail : mineralFormulaDetailList) {
            totalPercentage = totalPercentage.add(mineralFormulaDetail.getPercentage());
        }
        if (totalPercentage.compareTo(new BigDecimal(100)) != 0) {
            return ResultUtil.error("矿石配方详情比例总和不为100%");
        }

        //修改矿石配方
        MineralFormula mineralFormula = mineralFormulaAddUpdateDto.getMineralFormula();
        boolean result = this.mineralFormulaMapper.update(mineralFormula) > 0;
        if (!result) {
            return ResultUtil.error("修改矿石配方失败");
        }

        //根据矿石配方id删除所有原有矿石配方详情
        Integer mineralFormulaId = mineralFormula.getId();
        boolean deleteByMineralFormulaId = mineralFormulaDetailMapper.deleteByMineralFormulaId(mineralFormulaId) > 0;
        if (!deleteByMineralFormulaId) {
            return ResultUtil.error("删除原有均化记录详情失败");
        }

        //新增所有现有矿石配方详情
        for (MineralFormulaDetail mineralFormulaDetail : mineralFormulaDetailList) {
            mineralFormulaDetail.setMineralFormulaId(mineralFormulaId);
            boolean insertMineralFormulaDetailResult = mineralFormulaDetailMapper.insert(mineralFormulaDetail) > 0;
            if (!insertMineralFormulaDetailResult) {
                return ResultUtil.error("新增现有矿石配方详情失败");
            }
        }

        //走到这一步说明所有矿石配方、矿石配方详情修改成功
        return ResultUtil.success("修改成功");
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @Override
    public ResultVO<Object> deleteById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        boolean result = this.mineralFormulaMapper.deleteById(id) > 0;
        if (result) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.error("删除失败");
        }
    }

    /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.mineralFormulaMapper.removeById(id);
    }

}

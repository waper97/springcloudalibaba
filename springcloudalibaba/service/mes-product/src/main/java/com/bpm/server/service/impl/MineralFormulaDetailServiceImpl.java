package com.bpm.server.service.impl;

import com.bpm.common.domain.MineralFormulaDetail;
import com.bpm.common.dto.PageDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MineralFormulaDetailVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.mapper.MineralFormulaDetailMapper;
import com.bpm.server.service.MineralFormulaDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 矿石配方明细表(MineralFormulaDetail)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-05-09 19:55:37
 */
@Service
public class MineralFormulaDetailServiceImpl implements MineralFormulaDetailService {
    @Resource
    private MineralFormulaDetailMapper mineralFormulaDetailMapper;

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAll() {
        List<MineralFormulaDetail> mineralFormulaDetailList = this.mineralFormulaDetailMapper.queryAll();
        if (mineralFormulaDetailList == null || mineralFormulaDetailList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mineralFormulaDetailList);
    }


    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @Override
    public ResultVO queryById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        MineralFormulaDetail mineralFormulaDetail = this.mineralFormulaDetailMapper.queryById(id);
        if (mineralFormulaDetail == null) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mineralFormulaDetail);
    }

    /**
     * 分页查询
     *
     * @param mineralFormulaDetail 筛选条件
     * @param pageDTO              分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<MineralFormulaDetail> queryByPage(MineralFormulaDetail mineralFormulaDetail, PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        List<MineralFormulaDetail> mineralFormulaDetailList = this.mineralFormulaDetailMapper.queryAll();
        PageInfo<MineralFormulaDetail> pageInfo = new PageInfo<>(mineralFormulaDetailList);
        return pageInfo;

    }

    /**
     * 新增数据
     *
     * @param mineralFormulaDetail 实体
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MineralFormulaDetail mineralFormulaDetail) {
        if (mineralFormulaDetail == null || mineralFormulaDetail.getMineralFormulaId() == null) {
            return ResultUtil.error("矿石配方id不能为空");
        }
        boolean result = this.mineralFormulaDetailMapper.insert(mineralFormulaDetail) > 0;
        if (result) {
            return ResultUtil.success("新增成功");
        } else {
            return ResultUtil.error("新增失败");
        }
    }

    /**
     * 修改数据
     *
     * @param mineralFormulaDetail 实体
     * @return 修改结果
     */
    @Override
    public ResultVO update(MineralFormulaDetail mineralFormulaDetail) {
        if (mineralFormulaDetail == null || mineralFormulaDetail.getId() == null) {
            return ResultUtil.error("id不能为空");
        }
        boolean result = this.mineralFormulaDetailMapper.update(mineralFormulaDetail) > 0;
        if (result) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.error("修改失败");
        }
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @Override
    public ResultVO deleteById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        boolean result = this.mineralFormulaDetailMapper.deleteById(id) > 0;
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
        return this.mineralFormulaDetailMapper.removeById(id);
    }

    /**
     * 根据矿石配方id查询所有矿石配方详情
     *
     * @param mineralFormulaId 矿石配方id
     * @return 查询结果
     */
    public ResultVO<List<MineralFormulaDetailVo>> queryByMineralFormulaId(Integer mineralFormulaId) {
        if (mineralFormulaId == null) {
            return ResultUtil.error("矿石配方id不能为空");
        }
        List<MineralFormulaDetailVo> mineralFormulaDetailVoList = this.mineralFormulaDetailMapper.queryByMineralFormulaId(mineralFormulaId);
        if (mineralFormulaDetailVoList == null || mineralFormulaDetailVoList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mineralFormulaDetailVoList);
    }

}

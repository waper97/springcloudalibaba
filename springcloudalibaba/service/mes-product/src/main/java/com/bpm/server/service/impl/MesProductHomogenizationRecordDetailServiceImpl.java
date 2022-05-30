package com.bpm.server.service.impl;

import com.bpm.common.domain.MesProductHomogenizationRecordDetail;
import com.bpm.common.dto.PageDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductHomogenizationRecordDetailVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.mapper.MesProductHomogenizationRecordDetailMapper;
import com.bpm.server.service.MesProductHomogenizationRecordDetailService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

/**
 * 均化记录详情表(MesProductHomogenizationRecordDetail)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-05-06 18:25:22
 */
@Service
public class MesProductHomogenizationRecordDetailServiceImpl implements MesProductHomogenizationRecordDetailService {
    @Resource
    private MesProductHomogenizationRecordDetailMapper mesProductHomogenizationRecordDetailMapper;

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAll() {
        List<MesProductHomogenizationRecordDetail> mesProductHomogenizationRecordDetailList = this.mesProductHomogenizationRecordDetailMapper.queryAll();
        if (mesProductHomogenizationRecordDetailList == null || mesProductHomogenizationRecordDetailList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductHomogenizationRecordDetailList);
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
        MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail = this.mesProductHomogenizationRecordDetailMapper.queryById(id);
        if (mesProductHomogenizationRecordDetail == null) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductHomogenizationRecordDetail);
    }

    /**
     * 分页查询
     *
     * @param mesProductHomogenizationRecordDetail 筛选条件
     * @param pageDTO                              分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<MesProductHomogenizationRecordDetail> queryByPage(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail, PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        List<MesProductHomogenizationRecordDetail> mesProductHomogenizationRecordDetailList = this.mesProductHomogenizationRecordDetailMapper.queryAll();
        PageInfo<MesProductHomogenizationRecordDetail> pageInfo = new PageInfo<>(mesProductHomogenizationRecordDetailList);
        return pageInfo;

    }

    /**
     * 新增数据
     *
     * @param mesProductHomogenizationRecordDetail 实体
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail) {
        boolean result = this.mesProductHomogenizationRecordDetailMapper.insert(mesProductHomogenizationRecordDetail) > 0;
        if (result) {
            return ResultUtil.success("新增成功");
        } else {
            return ResultUtil.error("新增失败");
        }
    }

    /**
     * 修改数据
     *
     * @param mesProductHomogenizationRecordDetail 实体
     * @return 修改结果
     */
    @Override
    public ResultVO update(MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail) {
        boolean result = this.mesProductHomogenizationRecordDetailMapper.update(mesProductHomogenizationRecordDetail) > 0;
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
        boolean result = this.mesProductHomogenizationRecordDetailMapper.deleteById(id) > 0;
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
        return this.mesProductHomogenizationRecordDetailMapper.removeById(id);
    }

    /**
     * 根据均化记录id查询所有均化记录详情
     *
     * @param homogenizationRecordId 均化记录id
     * @return 查询结果
     */
    @Override
    public ResultVO<List<MesProductHomogenizationRecordDetailVo>> queryByHomogenizationRecordId(Integer homogenizationRecordId) {
        if (homogenizationRecordId == null) {
            return ResultUtil.error("均化记录id不能为空");
        }
        List<MesProductHomogenizationRecordDetailVo> detailVoList = this.mesProductHomogenizationRecordDetailMapper.queryByHomogenizationRecordId(homogenizationRecordId);
        if (detailVoList == null || detailVoList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(detailVoList);
    }

}

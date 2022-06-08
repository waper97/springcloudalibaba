package com.bpm.server.service.impl;

import com.bpm.common.domain.MesProductPrehomogenizationRecordDetail;
import com.bpm.common.dto.PageDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductPreHomogenizationRecordDetailVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.mapper.MesProductPrehomogenizationRecordDetailMapper;
import com.bpm.server.service.MesProductPrehomogenizationRecordDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 预均化记录详情表(MesProductPrehomogenizationRecordDetail)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-05-06 19:06:54
 */
@Service
public class MesProductPrehomogenizationRecordDetailServiceImpl implements MesProductPrehomogenizationRecordDetailService {
    @Resource
    private MesProductPrehomogenizationRecordDetailMapper mesProductPrehomogenizationRecordDetailMapper;

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAll() {
        List<MesProductPrehomogenizationRecordDetail> mesProductPrehomogenizationRecordDetailList = this.mesProductPrehomogenizationRecordDetailMapper.queryAll();
        if (mesProductPrehomogenizationRecordDetailList == null || mesProductPrehomogenizationRecordDetailList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductPrehomogenizationRecordDetailList);
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
        MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail = this.mesProductPrehomogenizationRecordDetailMapper.queryById(id);
        if (mesProductPrehomogenizationRecordDetail == null) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductPrehomogenizationRecordDetail);
    }

    /**
     * 分页查询
     *
     * @param mesProductPrehomogenizationRecordDetail 筛选条件
     * @param pageDTO                                 分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<MesProductPrehomogenizationRecordDetail> queryByPage(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail, PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        List<MesProductPrehomogenizationRecordDetail> mesProductPrehomogenizationRecordDetailList = this.mesProductPrehomogenizationRecordDetailMapper.queryAll();
        PageInfo<MesProductPrehomogenizationRecordDetail> pageInfo = new PageInfo<>(mesProductPrehomogenizationRecordDetailList);
        return pageInfo;

    }

    /**
     * 新增数据
     *
     * @param mesProductPrehomogenizationRecordDetail 实体
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail) {
        boolean result = this.mesProductPrehomogenizationRecordDetailMapper.insert(mesProductPrehomogenizationRecordDetail) > 0;
        if (result) {
            return ResultUtil.success("新增成功");
        } else {
            return ResultUtil.error("新增失败");
        }
    }

    /**
     * 修改数据
     *
     * @param mesProductPrehomogenizationRecordDetail 实体
     * @return 修改结果
     */
    @Override
    public ResultVO update(MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail) {
        boolean result = this.mesProductPrehomogenizationRecordDetailMapper.update(mesProductPrehomogenizationRecordDetail) > 0;
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
        boolean result = this.mesProductPrehomogenizationRecordDetailMapper.deleteById(id) > 0;
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
        return this.mesProductPrehomogenizationRecordDetailMapper.removeById(id);
    }

    /**
     * 根据预均化记录id查询所有预均化记录详情
     *
     * @param preHomogenizationRecordId 预均化记录id
     * @return 查询结果
     */
    @Override
    public ResultVO<List<MesProductPreHomogenizationRecordDetailVo>> queryByPreHomogenizationRecordId(Integer preHomogenizationRecordId) {
        if (preHomogenizationRecordId == null) {
            return ResultUtil.error("预均化记录id不能为空");
        }
        List<MesProductPreHomogenizationRecordDetailVo> voList = this.mesProductPrehomogenizationRecordDetailMapper.queryByPreHomogenizationRecordId(preHomogenizationRecordId);
        if (voList == null || voList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(voList);
    }

}

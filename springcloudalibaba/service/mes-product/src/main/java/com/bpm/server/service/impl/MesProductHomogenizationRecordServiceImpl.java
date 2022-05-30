package com.bpm.server.service.impl;

import com.bpm.common.domain.MesProductHomogenizationRecord;
import com.bpm.common.domain.MesProductHomogenizationRecordDetail;
import com.bpm.common.dto.MesProductHomogenizationRecordAddUpdateDto;
import com.bpm.common.dto.MesProductHomogenizationRecordPageQueryDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.*;
import com.bpm.server.mapper.MesProductHomogenizationRecordDetailMapper;
import com.bpm.server.mapper.MesProductHomogenizationRecordMapper;
import com.bpm.server.service.MesProductHomogenizationRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 均化记录主表(MesProductHomogenizationRecord)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-05-05 17:14:58
 */
@Service
public class MesProductHomogenizationRecordServiceImpl implements MesProductHomogenizationRecordService {
    /**
     * 均化记录mapper
     */
    @Resource
    private MesProductHomogenizationRecordMapper recordMapper;
    /**
     * 均化记录详情mapper
     */
    @Resource
    private MesProductHomogenizationRecordDetailMapper recordDetailMapper;

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAll() {
        List<MesProductHomogenizationRecord> mesProductHomogenizationRecordList = this.recordMapper.queryAll();
        if (mesProductHomogenizationRecordList == null || mesProductHomogenizationRecordList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductHomogenizationRecordList);
    }

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @Override
    public ResultVO<MesProductHomogenizationRecordQueryVo> queryById(Integer id) {
        //查询均化记录
        MesProductHomogenizationRecordVo recordVo = recordMapper.queryById(id);
        if (recordVo == null) {
            return ResultUtil.error("查询均化记录失败");
        }

        //根据均化记录id查询所有均化记录详情
        List<MesProductHomogenizationRecordDetailVo> detailVoList = recordDetailMapper.queryByHomogenizationRecordId(id);
        if (detailVoList == null) {
            return ResultUtil.error("根据均化记录id查询所有均化记录详情失败");
        }

        MesProductHomogenizationRecordQueryVo queryVo = new MesProductHomogenizationRecordQueryVo();
        queryVo.setRecordVo(recordVo);
        queryVo.setRecordDetailVoList(detailVoList);

        return ResultUtil.success(queryVo);
    }

    /**
     * 分页查
     *
     * @param queryDto 查询条件
     * @return 查询结果
     */
    @Override
    public ResultVO<PageInfoVO<List<MesProductHomogenizationRecordVo>>> queryByPage(MesProductHomogenizationRecordPageQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize());
        List<MesProductHomogenizationRecordVo> voList = this.recordMapper.queryByPage(queryDto);
        PageInfo<MesProductHomogenizationRecordVo> pageInfo = new PageInfo<>(voList);
        PageInfoVO<Object> pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;

    }

    /**
     * 新增数据
     *
     * @param recordAddDto 实例对象
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MesProductHomogenizationRecordAddUpdateDto recordAddDto) {

        //新增均化记录
        MesProductHomogenizationRecord record = recordAddDto.getRecord();
        //设置均化记录记录号
        record.setPlanCode("Re" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
        //设置均化记录批次
        record.setBatch(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())));
        //设置均化记录状态 0已关闭 1新增
        record.setStatus(1);
        boolean recordResult = recordMapper.insert(record) > 0;
        if (!recordResult) {
            return ResultUtil.error("新增均化记录失败");
        }

        //新增均化记录详情
        Integer recordId = record.getId();
        List<MesProductHomogenizationRecordDetail> recordDetailList = recordAddDto.getRecordDetailList();
        for (MesProductHomogenizationRecordDetail recordDetail : recordDetailList) {
            recordDetail.setHomogenizationRecordId(recordId);
            boolean recordDetailResult = recordDetailMapper.insert(recordDetail) > 0;
            if (!recordDetailResult) {
                return ResultUtil.error("新增均化记录详情失败");
            }
        }

        return ResultUtil.success("新增成功");
    }

    /**
     * 修改数据
     *
     * @param updateDto 实例对象
     * @return 修改结果
     */
    @Override
    public ResultVO update(MesProductHomogenizationRecordAddUpdateDto updateDto) {

        //修改均化记录
        MesProductHomogenizationRecord record = updateDto.getRecord();
        boolean recordResult = recordMapper.update(record) > 0;
        if (!recordResult) {
            return ResultUtil.error("修改均化记录失败");
        }

        //根据均化记录id删除所有原有均化记录详情
        Integer recordId = record.getId();
        boolean deleteByHomogenizationRecordId = recordDetailMapper.deleteByHomogenizationRecordId(recordId) > 0;
        if (!deleteByHomogenizationRecordId) {
            return ResultUtil.error("根据均化记录id删除所有原有均化记录详情失败");
        }

        //新增所有现有均化记录详情
        List<MesProductHomogenizationRecordDetail> recordDetailList = updateDto.getRecordDetailList();
        for (MesProductHomogenizationRecordDetail recordDetail : recordDetailList) {
            recordDetail.setHomogenizationRecordId(recordId);
            boolean recordDetailResult = this.recordDetailMapper.insert(recordDetail) > 0;
            if (!recordDetailResult) {
                return ResultUtil.error("新增所有现有均化记录详情失败");
            }
        }

        return ResultUtil.success("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @Override
    public ResultVO deleteById(Integer id) {
        boolean result = this.recordMapper.deleteById(id) > 0;
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
        return this.recordMapper.removeById(id);
    }

}

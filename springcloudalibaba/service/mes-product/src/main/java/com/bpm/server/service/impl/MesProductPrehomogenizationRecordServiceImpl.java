package com.bpm.server.service.impl;

import com.bpm.common.domain.MesProductPrehomogenizationRecord;
import com.bpm.common.domain.MesProductPrehomogenizationRecordDetail;
import com.bpm.common.dto.MesProductPreHomogenizationRecordAddUpdateDto;
import com.bpm.common.dto.MesProductPrehomogenizationRecordPageQueryDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.*;
import com.bpm.server.mapper.MesProductPrehomogenizationRecordDetailMapper;
import com.bpm.server.mapper.MesProductPrehomogenizationRecordMapper;
import com.bpm.server.service.MesProductPrehomogenizationRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 预均化记录表(MesProductPrehomogenizationRecord)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-05-06 11:16:37
 */
@Service
public class MesProductPrehomogenizationRecordServiceImpl implements MesProductPrehomogenizationRecordService {
    //预均化记录mapper
    @Resource
    private MesProductPrehomogenizationRecordMapper recordMapper;
    //预均化记录详情mapper
    @Resource
    private MesProductPrehomogenizationRecordDetailMapper recordDetailMapper;

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAll() {
        List<MesProductPrehomogenizationRecord> mesProductPrehomogenizationRecordList = this.recordMapper.queryAll();
        if (mesProductPrehomogenizationRecordList == null || mesProductPrehomogenizationRecordList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductPrehomogenizationRecordList);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 查询结果
     */
    @Override
    public ResultVO<MesProductPreHomogenizationRecordQueryVo> queryById(Integer id) {

        //查询预均化记录
        MesProductPreHomogenizationRecordVo recordVo = recordMapper.queryById(id);
        if (recordVo == null) {
            return ResultUtil.error("查询预均化记录失败");
        }

        //根据预均化记录id查询所有预均化记录详情
        List<MesProductPreHomogenizationRecordDetailVo> detailVoList = recordDetailMapper.queryByPreHomogenizationRecordId(id);
        if (detailVoList == null) {
            return ResultUtil.error("根据预均化记录id查询所有预均化记录详情失败");
        }

        MesProductPreHomogenizationRecordQueryVo queryVo = new MesProductPreHomogenizationRecordQueryVo();
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
    public ResultVO<PageInfoVO<List<MesProductPreHomogenizationRecordVo>>> queryByPage(MesProductPrehomogenizationRecordPageQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize());
        List<MesProductPreHomogenizationRecordVo> voList = this.recordMapper.queryByPage(queryDto);
        PageInfo<MesProductPreHomogenizationRecordVo> pageInfo = new PageInfo<>(voList);
        PageInfoVO<Object> pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * 新增数据
     *
     * @param addDto 实例对象
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MesProductPreHomogenizationRecordAddUpdateDto addDto) {

        //新增预均化记录
        MesProductPrehomogenizationRecord record = addDto.getRecord();
        //设置预均化记录记录号
        record.setPlanCode("Re" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
        //设置预均化记录批次
        record.setBatch(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())));
        //设置预均化记录状态 0已关闭 1新增
        record.setStatus(1);
        boolean recordResult = recordMapper.insert(record) > 0;
        if (!recordResult) {
            return ResultUtil.error("新增预均化记录失败");
        }

        //新增预均化记录详情
        Integer recordId = record.getId();
        List<MesProductPrehomogenizationRecordDetail> recordDetailList = addDto.getRecordDetailList();
        for (MesProductPrehomogenizationRecordDetail recordDetail : recordDetailList) {
            recordDetail.setPrehomogenizationRecordId(recordId);
            boolean recordDetailResult = recordDetailMapper.insert(recordDetail) > 0;
            if (!recordDetailResult) {
                return ResultUtil.error("新增预均化记录详情失败");
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
    public ResultVO update(MesProductPreHomogenizationRecordAddUpdateDto updateDto) {

        //修改预均化记录
        MesProductPrehomogenizationRecord record = updateDto.getRecord();
        boolean recordResult = recordMapper.update(record) > 0;
        if (!recordResult) {
            return ResultUtil.error("修改预均化记录失败");
        }

        //根据预均化记录id删除所有原有预均化记录详情
        Integer recordId = record.getId();
        boolean deleteByPreHomogenizationRecordId = recordDetailMapper.deleteByPreHomogenizationRecordId(recordId) > 0;
        if (!deleteByPreHomogenizationRecordId) {
            return ResultUtil.error("根据预均化记录id删除所有原有预均化记录详情失败");
        }

        //新增所有现有预均化记录详情
        List<MesProductPrehomogenizationRecordDetail> recordDetailList = updateDto.getRecordDetailList();
        for (MesProductPrehomogenizationRecordDetail recordDetail : recordDetailList) {
            recordDetail.setPrehomogenizationRecordId(recordId);
            boolean recordDetailResult = this.recordDetailMapper.insert(recordDetail) > 0;
            if (!recordDetailResult) {
                return ResultUtil.error("新增所有现有预均化记录详情失败");
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

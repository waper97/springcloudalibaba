package com.bpm.server.service.impl;

import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanning;
import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanningDetail;
import com.bpm.common.dto.MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto;
import com.bpm.common.dto.MesProductDayBrokenForkliftFeedingPlanningQueryDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.*;
import com.bpm.server.mapper.MesProductDayBrokenForkliftFeedingPlanningDetailMapper;
import com.bpm.server.mapper.MesProductDayBrokenForkliftFeedingPlanningMapper;
import com.bpm.server.service.MesProductDayBrokenForkliftFeedingPlanningService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 日破碎铲车投料计划(MesProductDayBrokenForkliftFeedingPlanning)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-04-29 14:00:56
 */
@Service
public class MesProductDayBrokenForkliftFeedingPlanningServiceImpl implements MesProductDayBrokenForkliftFeedingPlanningService {
    /**
     * 投料计划mapper
     */
    @Resource
    private MesProductDayBrokenForkliftFeedingPlanningMapper planMapper;
    /**
     * 投料计划详情mapper
     */
    @Resource
    private MesProductDayBrokenForkliftFeedingPlanningDetailMapper planDetailMapper;

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAll() {
        List<MesProductDayBrokenForkliftFeedingPlanning> mesProductDayBrokenForkliftFeedingPlanningList = this.planMapper.queryAll();
        if (mesProductDayBrokenForkliftFeedingPlanningList == null || mesProductDayBrokenForkliftFeedingPlanningList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductDayBrokenForkliftFeedingPlanningList);
    }

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @Override
    public ResultVO<MesProductDayBrokenForkliftFeedingPlanningQueryVo> queryById(Integer id) {

        //根据投料计划id查询投料计划
        MesProductDayBrokenForkliftFeedingPlanningVo planVo = planMapper.queryById(id);
        if (planVo == null) {
            return ResultUtil.error("根据投料计划id查询投料计划失败");
        }

        //根据投料计划id查询所有投料计划详情
        List<MesProductDayBrokenForkliftFeedingPlanningDetailVo> planDetailVoList = planDetailMapper.queryByPlanId(id);
        if (planDetailVoList == null || planDetailVoList.isEmpty()) {
            return ResultUtil.error("根据投料计划id查询所有投料计划详情失败");
        }

        MesProductDayBrokenForkliftFeedingPlanningQueryVo queryVo = new MesProductDayBrokenForkliftFeedingPlanningQueryVo();
        queryVo.setPlanVo(planVo);
        queryVo.setPlanDetailVoList(planDetailVoList);
        return ResultUtil.success(queryVo);
    }

    /**
     * 分页查询
     *
     * @param queryDto 筛选条件
     * @return 查询结果
     */
    @Override
    public ResultVO<PageInfoVO<List<MesProductDayBrokenForkliftFeedingPlanningVo>>> queryByPage(MesProductDayBrokenForkliftFeedingPlanningQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize());
        List<MesProductDayBrokenForkliftFeedingPlanningVo> planVoList = this.planMapper.queryByPage(queryDto);
        PageInfo<MesProductDayBrokenForkliftFeedingPlanningVo> pageInfo = new PageInfo<>(planVoList);
        PageInfoVO<Object> pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;

    }

    /**
     * 新增数据
     *
     * @param planningDto 实例对象
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto planningDto) {

        //设置投料单号
        MesProductDayBrokenForkliftFeedingPlanning plan = planningDto.getPlan();
        String todayStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
        plan.setFeedingNumber("DR" + todayStr);
        //设置计划号
        plan.setPlanCode(todayStr);

        //新增投料计划
        boolean planningResult = this.planMapper.insert(plan) > 0;
        if (!planningResult) {
            return ResultUtil.error("新增投料计划失败");
        }

        //新增投料计划详情
        Integer planId = plan.getId();
        List<MesProductDayBrokenForkliftFeedingPlanningDetail> planDetailList = planningDto.getPlanDetailList();
        for (MesProductDayBrokenForkliftFeedingPlanningDetail planDetail : planDetailList) {
            planDetail.setDayBrokenForkliftFeedingPlanningId(planId);
            boolean planDetailResult = planDetailMapper.insert(planDetail) > 0;
            if (!planDetailResult) {
                return ResultUtil.error("新增投料计划详情失败");
            }
        }

        return ResultUtil.success("新增投料计划成功");
    }

    /**
     * 修改数据
     *
     * @param planDto 实例对象
     * @return 修改结果
     */
    @Override
    public ResultVO update(MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto planDto) {

        //修改投料计划
        MesProductDayBrokenForkliftFeedingPlanning plan = planDto.getPlan();
        boolean planningResult = planMapper.update(plan) > 0;
        if (!planningResult) {
            return ResultUtil.error("修改投料计划失败");
        }

        //根据投料计划id删除所有原有投料计划详情
        Integer planId = plan.getId();
        boolean deleteByPlanId = planDetailMapper.deleteByPlanId(planId) > 0;
        if (!deleteByPlanId) {
            return ResultUtil.error("根据投料计划id删除所有原有投料计划详情失败");
        }

        //新增所有现有投料计划详情
        List<MesProductDayBrokenForkliftFeedingPlanningDetail> planDetailList = planDto.getPlanDetailList();
        for (MesProductDayBrokenForkliftFeedingPlanningDetail planDetail : planDetailList) {
            planDetail.setDayBrokenForkliftFeedingPlanningId(planId);
            boolean planDetailResult = planDetailMapper.insert(planDetail) > 0;
            if (!planDetailResult) {
                return ResultUtil.error("新增所有现有投料计划详情失败");
            }
        }

        return ResultUtil.success("修改投料计划成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @Override
    public ResultVO deleteById(Integer id) {
        boolean result = this.planMapper.deleteById(id) > 0;
        if (result) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
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
        return this.planMapper.removeById(id);
    }

    @Override
    public ResultVO integrated(MesProductDayBrokenForkliftFeedingPlanningIntegrate integrate) {
        MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto planningDto = new MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto();
        integrate.getDayPlanningList().stream().forEach(dayPlanning ->{

            dayPlanning.getDetailList().stream().forEach(detail ->{
                //设置投料单号
                MesProductDayBrokenForkliftFeedingPlanning plan = new MesProductDayBrokenForkliftFeedingPlanning();
                String todayStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
                plan.setFeedingNumber("DR" + todayStr);
                //设置计划号
                plan.setPlanCode(todayStr);
                plan.setMineralsId(detail.getProductionId());

                //新增投料计划
                boolean result = this.planMapper.insert(plan) > 0;
            });
        });
        return ResultUtil.success();
    }

}

package com.bpm.server.service.impl;

import com.bpm.common.domain.MesProductDayMineralArrivalOfTheDemandPlanning;
import com.bpm.common.dto.MesProductDayMineralArrivalOfTheDemandPlanningDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductDayMineralArrivalOfTheDemandPlanningVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.mapper.MesProductDayMineralArrivalOfTheDemandPlanningMapper;
import com.bpm.server.service.MesProductDayMineralArrivalOfTheDemandPlanningService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 日矿石到货需求计划(MesProductDayMineralArrivalOfTheDemandPlanning)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-04-29 11:09:13
 */
@Service
public class MesProductDayMineralArrivalOfTheDemandPlanningServiceImpl implements MesProductDayMineralArrivalOfTheDemandPlanningService {
    @Resource
    private MesProductDayMineralArrivalOfTheDemandPlanningMapper planningMapper;

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAll() {
        List<MesProductDayMineralArrivalOfTheDemandPlanning> mesProductDayMineralArrivalOfTheDemandPlanningList = this.planningMapper.queryAll();
        if (mesProductDayMineralArrivalOfTheDemandPlanningList == null || mesProductDayMineralArrivalOfTheDemandPlanningList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductDayMineralArrivalOfTheDemandPlanningList);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 查询结果
     */
    @Override
    public ResultVO queryById(Integer id) {
        MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning = this.planningMapper.queryById(id);
        if (mesProductDayMineralArrivalOfTheDemandPlanning == null) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductDayMineralArrivalOfTheDemandPlanning);
    }

    /**
     * 分页查
     *
     * @param planningDto 查询条件
     * @return 查询结果
     */
    @Override
    public ResultVO<PageInfoVO<List<MesProductDayMineralArrivalOfTheDemandPlanningVo>>> queryByPage(MesProductDayMineralArrivalOfTheDemandPlanningDto planningDto) {
        PageHelper.startPage(planningDto.getPageNum(), planningDto.getPageSize());
        List<MesProductDayMineralArrivalOfTheDemandPlanningVo> voList = this.planningMapper.queryByPage(planningDto);
        PageInfo<MesProductDayMineralArrivalOfTheDemandPlanningVo> pageInfo = new PageInfo<>(voList);
        PageInfoVO<Object> pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * 新增数据
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 实例对象
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning) {

        //设置计划号
        mesProductDayMineralArrivalOfTheDemandPlanning.setPlanCode("DRP" + new SimpleDateFormat("yyyyMMdd").format(new Date()));

        boolean result = this.planningMapper.insert(mesProductDayMineralArrivalOfTheDemandPlanning) > 0;
        if (result) {
            return ResultUtil.success("新增成功");
        } else {
            return ResultUtil.error("新增失败");
        }
    }

    /**
     * 修改数据
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 实例对象
     * @return 修改结果
     */
    @Override
    public ResultVO update(MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning) {
        boolean result = this.planningMapper.update(mesProductDayMineralArrivalOfTheDemandPlanning) > 0;
        if (result) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @Override
    public ResultVO deleteById(Integer id) {
        boolean result = this.planningMapper.deleteById(id) > 0;
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
        return this.planningMapper.removeById(id);
    }

}

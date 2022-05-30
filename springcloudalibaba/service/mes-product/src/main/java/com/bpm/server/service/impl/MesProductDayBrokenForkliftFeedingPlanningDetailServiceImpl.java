package com.bpm.server.service.impl;

import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanningDetail;
import com.bpm.common.dto.PageDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductDayBrokenForkliftFeedingPlanningDetailVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.mapper.MesProductDayBrokenForkliftFeedingPlanningDetailMapper;
import com.bpm.server.service.MesProductDayBrokenForkliftFeedingPlanningDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日破碎铲车投料计划详情(MesProductDayBrokenForkliftFeedingPlanningDetail)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-05-11 09:53:03
 */
@Service
public class MesProductDayBrokenForkliftFeedingPlanningDetailServiceImpl implements MesProductDayBrokenForkliftFeedingPlanningDetailService {
    @Resource
    private MesProductDayBrokenForkliftFeedingPlanningDetailMapper mesProductDayBrokenForkliftFeedingPlanningDetailMapper;

    @Override
    public List<MesProductDayBrokenForkliftFeedingPlanningDetail> queryAll(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail) {

        return this.mesProductDayBrokenForkliftFeedingPlanningDetailMapper.queryAll(mesProductDayBrokenForkliftFeedingPlanningDetail);
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MesProductDayBrokenForkliftFeedingPlanningDetail queryById(Integer id) {
        return this.mesProductDayBrokenForkliftFeedingPlanningDetailMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 筛选条件
     * @param pageDTO                                          分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<MesProductDayBrokenForkliftFeedingPlanningDetail> queryByPage(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail, PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        List<MesProductDayBrokenForkliftFeedingPlanningDetail> mesProductDayBrokenForkliftFeedingPlanningDetailList = this.mesProductDayBrokenForkliftFeedingPlanningDetailMapper.queryAll(mesProductDayBrokenForkliftFeedingPlanningDetail);
        PageInfo<MesProductDayBrokenForkliftFeedingPlanningDetail> pageInfo = new PageInfo<>(mesProductDayBrokenForkliftFeedingPlanningDetailList);
        return pageInfo;

    }

    /**
     * 新增数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 实体
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail) {
        boolean result = this.mesProductDayBrokenForkliftFeedingPlanningDetailMapper.insert(mesProductDayBrokenForkliftFeedingPlanningDetail) > 0;
        if (!result) {
            return ResultUtil.error("新增失败");
        }
        return ResultUtil.success("新增成功");
    }

    /**
     * 修改数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 实例对象
     * @return 实例对象
     */
    @Override
    public MesProductDayBrokenForkliftFeedingPlanningDetail update(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail) {
        this.mesProductDayBrokenForkliftFeedingPlanningDetailMapper.update(mesProductDayBrokenForkliftFeedingPlanningDetail);
        return this.queryById(mesProductDayBrokenForkliftFeedingPlanningDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.mesProductDayBrokenForkliftFeedingPlanningDetailMapper.deleteById(id) > 0;
    }

    /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.mesProductDayBrokenForkliftFeedingPlanningDetailMapper.removeById(id);
    }

    /**
     * 根据投料计划id查询所有投料计划详情
     *
     * @param planId 投料计划id
     * @return 投料计划详情vo列表
     */
    @Override
    public ResultVO<List<MesProductDayBrokenForkliftFeedingPlanningDetailVo>> queryByPlanId(Integer planId) {
        List<MesProductDayBrokenForkliftFeedingPlanningDetailVo> planDetailVoList = mesProductDayBrokenForkliftFeedingPlanningDetailMapper.queryByPlanId(planId);
        if (planDetailVoList == null || planDetailVoList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(planDetailVoList);
    }

}

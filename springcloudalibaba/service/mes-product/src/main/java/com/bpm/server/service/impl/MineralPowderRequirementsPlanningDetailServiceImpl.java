package com.bpm.server.service.impl;

import com.bpm.common.domain.MineralPowderRequirementsPlanningDetail;
import com.bpm.common.dto.MineralPowderRequirementsPlanningDetailDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.MineralPowderRequirementsPlanningDetailMapper;
import com.bpm.server.service.MineralPowderRequirementsPlanningDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 矿粉需求计划详情 服务实现类
 *
 * @author wangpeng
 * @since 2022-04-24 10:20:52
 */
@Service
public class MineralPowderRequirementsPlanningDetailServiceImpl implements MineralPowderRequirementsPlanningDetailService {
    @Resource
    private MineralPowderRequirementsPlanningDetailMapper mineralPowderRequirementsPlanningDetailMapper;

    @Override
    public List<MineralPowderRequirementsPlanningDetail> queryAll(MineralPowderRequirementsPlanningDetailDTO mineralPowderRequirementsPlanningDetailDTO) {
        MineralPowderRequirementsPlanningDetail mineralPowderRequirementsPlanningDetail = new MineralPowderRequirementsPlanningDetail();
        BeanUtils.copyProperties(mineralPowderRequirementsPlanningDetailDTO, mineralPowderRequirementsPlanningDetail);
        return this.mineralPowderRequirementsPlanningDetailMapper.queryAll(mineralPowderRequirementsPlanningDetail);
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MineralPowderRequirementsPlanningDetail queryById(Integer id) {
        return this.mineralPowderRequirementsPlanningDetailMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param mineralPowderRequirementsPlanningDetailDTO 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<MineralPowderRequirementsPlanningDetail> queryByPage(MineralPowderRequirementsPlanningDetailDTO mineralPowderRequirementsPlanningDetailDTO) {
        PageHelper.startPage(mineralPowderRequirementsPlanningDetailDTO.getPageNum(), mineralPowderRequirementsPlanningDetailDTO.getPageSize());
        MineralPowderRequirementsPlanningDetail mineralPowderRequirementsPlanningDetail = new MineralPowderRequirementsPlanningDetail();
        BeanUtils.copyProperties(mineralPowderRequirementsPlanningDetailDTO, mineralPowderRequirementsPlanningDetail);
        List<MineralPowderRequirementsPlanningDetail> mineralPowderRequirementsPlanningDetailList = this.mineralPowderRequirementsPlanningDetailMapper.queryAll(mineralPowderRequirementsPlanningDetail);
        PageInfo<MineralPowderRequirementsPlanningDetail> pageInfo = new PageInfo<>(mineralPowderRequirementsPlanningDetailList);
        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;

    }

    /**
     * 新增数据
     *
     * @param mineralPowderRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(MineralPowderRequirementsPlanningDetail mineralPowderRequirementsPlanningDetail) {
        return this.mineralPowderRequirementsPlanningDetailMapper.insert(mineralPowderRequirementsPlanningDetail) > 0;
    }

    /**
     * 修改数据
     *
     * @param mineralPowderRequirementsPlanningDetail 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(MineralPowderRequirementsPlanningDetail mineralPowderRequirementsPlanningDetail) {
        return this.mineralPowderRequirementsPlanningDetailMapper.update(mineralPowderRequirementsPlanningDetail) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.mineralPowderRequirementsPlanningDetailMapper.deleteById(id) > 0;
    }

    /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.mineralPowderRequirementsPlanningDetailMapper.removeById(id) > 0;
    }

}

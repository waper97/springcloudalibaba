package com.bpm.server.service.impl;

import com.bpm.common.domain.MesProductWorkCenter;
import com.bpm.common.dto.MesProductWorkCenterDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductWorkCenterVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResourceCategoryVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.mapper.MesProductWorkCenterMapper;
import com.bpm.server.service.MesProductWorkCenterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 工作中心表(MesProductWorkCenter)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-04-27 18:00:03
 */
@Service
public class MesProductWorkCenterServiceImpl implements MesProductWorkCenterService {
    @Resource
    private MesProductWorkCenterMapper mesProductWorkCenterMapper;

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAll() {
        List<MesProductWorkCenter> mesProductWorkCenterList = this.mesProductWorkCenterMapper.queryAll();
        if (mesProductWorkCenterList == null || mesProductWorkCenterList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductWorkCenterList);
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 查询结果
     */
    @Override
    public ResultVO queryById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        MesProductWorkCenter mesProductWorkCenter = this.mesProductWorkCenterMapper.queryById(id);
        if (mesProductWorkCenter == null) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductWorkCenter);
    }

    /**
     * 分页查询
     *
     * @param mesProductWorkCenterDto 查询条件
     * @return 查询结果
     */
    @Override
    public ResultVO<PageInfoVO<List<MesProductWorkCenterVo>>> queryByPage(MesProductWorkCenterDto mesProductWorkCenterDto) {
        PageHelper.startPage(mesProductWorkCenterDto.getPageNum(), mesProductWorkCenterDto.getPageSize());
        List<MesProductWorkCenterVo> mesProductWorkCenterVoList = this.mesProductWorkCenterMapper.queryByPage(mesProductWorkCenterDto);
        PageInfo<MesProductWorkCenterVo> pageInfo = new PageInfo<>(mesProductWorkCenterVoList);
        PageInfoVO<Object> pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * 新增数据
     *
     * @param mesProductWorkCenter 实例对象
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MesProductWorkCenter mesProductWorkCenter) {
//        mesProductWorkCenter.setCreateTime(LocalDateTime.now());
        boolean result = this.mesProductWorkCenterMapper.insert(mesProductWorkCenter) > 0;
        if (result) {
            return ResultUtil.success("新增成功");
        } else {
            return ResultUtil.error("新增失败");
        }
    }

    /**
     * 修改数据
     *
     * @param mesProductWorkCenter 实例对象
     * @return 修改结果
     */
    @Override
    public ResultVO update(MesProductWorkCenter mesProductWorkCenter) {
        boolean result = this.mesProductWorkCenterMapper.update(mesProductWorkCenter) > 0;
        if (result) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.error("修改失败");
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
        boolean result = this.mesProductWorkCenterMapper.deleteById(id) > 0;
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
        return this.mesProductWorkCenterMapper.removeById(id);
    }

    /**
     * 查询所有资源类别
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAllResourceCategories() {
        List<ResourceCategoryVo> resourceCategoryVoList = this.mesProductWorkCenterMapper.queryAllResourceCategories();
        if (resourceCategoryVoList == null || resourceCategoryVoList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(resourceCategoryVoList);
    }
}
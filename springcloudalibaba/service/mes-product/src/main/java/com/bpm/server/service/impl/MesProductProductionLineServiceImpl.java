package com.bpm.server.service.impl;

import com.bpm.common.domain.MesProductProductionLine;
import com.bpm.common.dto.MesProductProductionLineDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.*;
import com.bpm.server.mapper.MesProductProductionLineMapper;
import com.bpm.server.service.MesProductProductionLineService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生产线表(MesProductProductionLine)表服务实现类
 *
 * @author zhangzheming
 * @since 2022-04-25 09:50:19
 */
@Service
public class MesProductProductionLineServiceImpl implements MesProductProductionLineService {
    @Resource
    private MesProductProductionLineMapper mesProductProductionLineMapper;

    @Resource
    private NumberUtil numberUtil;
    /**
     * 查全部
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAll() {
        List<MesProductProductionLine> mesProductProductionLineList = this.mesProductProductionLineMapper.queryAll();
        if (mesProductProductionLineList == null || mesProductProductionLineList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductProductionLineList);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResultVO queryById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        MesProductProductionLine mesProductProductionLine = this.mesProductProductionLineMapper.queryById(id);
        if (mesProductProductionLine == null) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(mesProductProductionLine);
    }

    /**
     * 新增数据
     *
     * @param mesProductProductionLine 实例对象
     * @return 新增结果
     */
    @Override
    public ResultVO insert(MesProductProductionLine mesProductProductionLine) {
        mesProductProductionLine.setCode(numberUtil.contextLoads("Line"));
        boolean result = this.mesProductProductionLineMapper.insert(mesProductProductionLine) > 0;
        if (result) {
            return ResultVO.create().success("新增成功");
        } else {
            return ResultVO.create().error("新增失败");
        }
    }

    /**
     * 分页查询
     *
     * @param mesProductProductionLineDto 查询条件
     * @return 查询结果
     */
    @Override
    public ResultVO<PageInfoVO<List<MesProductProductionLineVo>>> queryByPage(MesProductProductionLineDto mesProductProductionLineDto) {
        PageHelper.startPage(mesProductProductionLineDto.getPageNum(), mesProductProductionLineDto.getPageSize());
        List<MesProductProductionLineVo> mesProductProductionLineVoList = this.mesProductProductionLineMapper.queryByPage(mesProductProductionLineDto);
        PageInfo<MesProductProductionLineVo> pageInfo = new PageInfo<>(mesProductProductionLineVoList);
        PageInfoVO<Object> pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;

    }

    /**
     * 修改数据
     *
     * @param mesProductProductionLine 实例对象
     * @return 修改结果
     */
    @Override
    public ResultVO update(MesProductProductionLine mesProductProductionLine) {
        boolean result = this.mesProductProductionLineMapper.update(mesProductProductionLine) > 0;
        if (result) {
            return ResultVO.create().success("修改成功");
        } else {
            return ResultVO.create().error("修改失败");
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
        boolean result = this.mesProductProductionLineMapper.deleteById(id) > 0;
        if (result) {
            return ResultVO.create().success("删除成功");
        } else {
            return ResultVO.create().error("删除失败");
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
        return this.mesProductProductionLineMapper.removeById(id);
    }

    /**
     * 查询所有生产线编号
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAllLineNumbers() {
        List<ProductionLineNumberVo> productionLineNumberVoList = mesProductProductionLineMapper.queryAllLineNumbers();
        if (productionLineNumberVoList == null || productionLineNumberVoList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(productionLineNumberVoList);
    }

    /**
     * 查询所有公司名称
     *
     * @return 查询结果
     */
    @Override
    public ResultVO queryAllCompanyNames() {
        List<CompanyNameVo> companyNameVoList = mesProductProductionLineMapper.queryAllCompanyNames();
        if (companyNameVoList == null || companyNameVoList.isEmpty()) {
            return ResultUtil.error("查询失败或无数据");
        }
        return ResultUtil.success(companyNameVoList);
    }

}

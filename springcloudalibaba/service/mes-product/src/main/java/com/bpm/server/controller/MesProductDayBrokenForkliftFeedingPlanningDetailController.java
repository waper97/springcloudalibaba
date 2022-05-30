package com.bpm.server.controller;

import com.bpm.common.domain.MesProductDayBrokenForkliftFeedingPlanningDetail;
import com.bpm.common.dto.PageDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductDayBrokenForkliftFeedingPlanningDetailVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MesProductDayBrokenForkliftFeedingPlanningDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日破碎铲车投料计划详情controller
 *
 * @author zhangzheming
 * @since 2022-05-11 09:53:02
 */
@RestController
@RequestMapping("mesProductDayBrokenForkliftFeedingPlanningDetail")
@Api(tags = "日破碎铲车投料计划详情")

public class MesProductDayBrokenForkliftFeedingPlanningDetailController {
    /**
     * 服务对象
     */
    @Resource
    private MesProductDayBrokenForkliftFeedingPlanningDetailService mesProductDayBrokenForkliftFeedingPlanningDetailService;

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("removeById")
    @ApiOperation(value = "删除")
    public ResultVO removeById(Integer id) {
        this.mesProductDayBrokenForkliftFeedingPlanningDetailService.removeById(id);
        return ResultVO.create().success("修改成功");
    }

    /**
     * 条件查询
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 筛选条件
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "条件查询")
    public ResultVO queryAll(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail) {
        return ResultVO.create().success(this.mesProductDayBrokenForkliftFeedingPlanningDetailService.queryAll(mesProductDayBrokenForkliftFeedingPlanningDetail));
    }

    /**
     * 新增数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail) {
        return this.mesProductDayBrokenForkliftFeedingPlanningDetailService.insert(mesProductDayBrokenForkliftFeedingPlanningDetail);
    }

    /**
     * 分页查询
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 筛选条件
     * @param pageDTO                                          分页对象
     * @return 查询结果
     */
    @GetMapping("queryByPage")
    @ApiOperation(value = "分页查询")
    public ResultVO Page(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail, PageDTO pageDTO) {

        return ResultVO.create().success(this.mesProductDayBrokenForkliftFeedingPlanningDetailService.queryByPage(mesProductDayBrokenForkliftFeedingPlanningDetail, pageDTO));
    }

    /**
     * 编辑数据
     *
     * @param mesProductDayBrokenForkliftFeedingPlanningDetail 实体
     * @return 编辑结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO edit(MesProductDayBrokenForkliftFeedingPlanningDetail mesProductDayBrokenForkliftFeedingPlanningDetail) {
        this.mesProductDayBrokenForkliftFeedingPlanningDetailService.update(mesProductDayBrokenForkliftFeedingPlanningDetail);
        return ResultVO.create().success("修改成功");
    }

    /**
     * 根据投料计划id查询所有投料计划详情
     *
     * @param planId 投料计划id
     * @return 投料计划详情vo列表
     */
    @GetMapping("queryByPlanId")
    @ApiOperation(value = "根据投料计划id查询所有投料计划详情")
    public ResultVO<List<MesProductDayBrokenForkliftFeedingPlanningDetailVo>> queryByPlanId(Integer planId) {
        if (planId == null) {
            return ResultUtil.error("投料计划id不能为空");
        }
        return mesProductDayBrokenForkliftFeedingPlanningDetailService.queryByPlanId(planId);
    }

}
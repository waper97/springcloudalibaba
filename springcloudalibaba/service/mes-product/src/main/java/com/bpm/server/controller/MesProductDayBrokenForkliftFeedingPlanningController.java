package com.bpm.server.controller;

import com.bpm.common.dto.MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto;
import com.bpm.common.dto.MesProductDayBrokenForkliftFeedingPlanningQueryDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductDayBrokenForkliftFeedingPlanningQueryVo;
import com.bpm.common.vo.MesProductDayBrokenForkliftFeedingPlanningVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MesProductDayBrokenForkliftFeedingPlanningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日破碎铲车投料计划controller
 *
 * @author zhangzheming
 * @since 2022-04-29 14:00:55
 */
@RestController
@RequestMapping("mesProductDayBrokenForkliftFeedingPlanning")
@Api(tags = "日破碎铲车投料计划")

public class MesProductDayBrokenForkliftFeedingPlanningController {
    /**
     * 服务对象
     */
    @Resource
    private MesProductDayBrokenForkliftFeedingPlanningService planService;

    /**
     * 新增数据
     *
     * @param addDto 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto addDto) {
        if (addDto == null || addDto.getPlan() == null || addDto.getPlanDetailList() == null || addDto.getPlanDetailList().isEmpty()) {
            return ResultUtil.error("日破碎铲车投料计划、日破碎铲车投料计划详情不能为空");
        }
        return this.planService.insert(addDto);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("deleteById")
    @ApiOperation(value = "删除")
    public ResultVO deleteById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        return this.planService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param updateDto 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO update(@RequestBody MesProductDayBrokenForkliftFeedingPlanningAddUpdateDto updateDto) {
        if (updateDto == null || updateDto.getPlan() == null || updateDto.getPlanDetailList() == null) {
            return ResultUtil.error("日破碎铲车投料计划、日破碎铲车投料计划详情不能为空");
        }
        return this.planService.update(updateDto);
    }

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @GetMapping("queryById")
    @ApiOperation(value = "查单个")
    public ResultVO<MesProductDayBrokenForkliftFeedingPlanningQueryVo> queryById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        return this.planService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO queryAll() {
        return this.planService.queryAll();
    }

    /**
     * 分页查
     *
     * @param queryDto 查询条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value = "分页查")
    public ResultVO<PageInfoVO<List<MesProductDayBrokenForkliftFeedingPlanningVo>>> queryByPage(@RequestBody MesProductDayBrokenForkliftFeedingPlanningQueryDto queryDto) {
        return this.planService.queryByPage(queryDto);
    }

    @PostMapping(value = "/integrated")
    @ApiOperation(value = "集成")
    public ResultVO integrated (@RequestBody MesProductDayBrokenForkliftFeedingPlanningIntegrate integrate) {
        if (integrate == null) {
            return ResultUtil.error("参数不能为空!");
        }
        if (CollectionUtils.isEmpty(integrate.getDayPlanningList())) {
            return ResultUtil.error("日破碎生产计划不能为空!");
        }
        return planService.integrated(integrate);
    }
}
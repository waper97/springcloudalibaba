package com.bpm.server.controller;

import com.bpm.common.domain.MesProductDayMineralArrivalOfTheDemandPlanning;
import com.bpm.common.dto.MesProductDayMineralArrivalOfTheDemandPlanningDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductDayMineralArrivalOfTheDemandPlanningVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MesProductDayMineralArrivalOfTheDemandPlanningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日矿石到货需求计划(MesProductDayMineralArrivalOfTheDemandPlanning)表控制层
 *
 * @author zhangzheming
 * @since 2022-04-29 11:09:12
 */
@RestController
@RequestMapping("mesProductDayMineralArrivalOfTheDemandPlanning")
@Api(tags = "日矿石到货需求计划")

public class MesProductDayMineralArrivalOfTheDemandPlanningController {
    /**
     * 服务对象
     */
    @Resource
    private MesProductDayMineralArrivalOfTheDemandPlanningService mesProductDayMineralArrivalOfTheDemandPlanningService;

    /**
     * 新增数据
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning) {

        // TODO ： 计划到货量字段应该为planArrivalQuantity 而不是 planIntoQuantity
        if (mesProductDayMineralArrivalOfTheDemandPlanning == null) {
            return ResultUtil.error("数据不能为空");
        }
        return this.mesProductDayMineralArrivalOfTheDemandPlanningService.insert(mesProductDayMineralArrivalOfTheDemandPlanning);
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
        return this.mesProductDayMineralArrivalOfTheDemandPlanningService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanning 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO update(@RequestBody MesProductDayMineralArrivalOfTheDemandPlanning mesProductDayMineralArrivalOfTheDemandPlanning) {
        return this.mesProductDayMineralArrivalOfTheDemandPlanningService.update(mesProductDayMineralArrivalOfTheDemandPlanning);
    }

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @GetMapping("queryById")
    @ApiOperation(value = "查单个")
    public ResultVO queryById(Integer id) {
        return this.mesProductDayMineralArrivalOfTheDemandPlanningService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO queryAll() {
        return this.mesProductDayMineralArrivalOfTheDemandPlanningService.queryAll();
    }

    /**
     * 分页查
     *
     * @param mesProductDayMineralArrivalOfTheDemandPlanningDto 查询条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value = "分页查")
    public ResultVO<PageInfoVO<List<MesProductDayMineralArrivalOfTheDemandPlanningVo>>> queryByPage(@RequestBody MesProductDayMineralArrivalOfTheDemandPlanningDto mesProductDayMineralArrivalOfTheDemandPlanningDto) {
        return this.mesProductDayMineralArrivalOfTheDemandPlanningService.queryByPage(mesProductDayMineralArrivalOfTheDemandPlanningDto);
    }


}


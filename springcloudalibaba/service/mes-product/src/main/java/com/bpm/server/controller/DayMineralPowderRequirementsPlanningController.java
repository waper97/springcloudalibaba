package com.bpm.server.controller;

import com.bpm.common.dto.DayMineralPowderRequirementsPlanningDTO;
import com.bpm.common.dto.DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.DayMineralPowderRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.DayMineralPowderRequirementsPlanningService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日矿粉需求计划 表控制层
 * @author wangpeng
 * @since 2022-04-26 09:45:14
 */
@ApiSupport(order = 6)
@Api(tags = "日矿粉需求计划")
@RestController
@RequestMapping("dayMineralPowderRequirementsPlanning")
//@CrossOrigin
public class DayMineralPowderRequirementsPlanningController {
    /**
     * 服务对象
     */
    @Resource
    private DayMineralPowderRequirementsPlanningService dayMineralPowderRequirementsPlanningService;
    
   
     /**
     * 条件查询 日矿粉需求计划
     * @param dayMineralPowderRequirementsPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<DayMineralPowderRequirementsPlanningVO>> queryAll(@RequestBody DayMineralPowderRequirementsPlanningDTO dayMineralPowderRequirementsPlanning) {
        return ResultUtil.success(this.dayMineralPowderRequirementsPlanningService.queryAll(dayMineralPowderRequirementsPlanning));
    }
      /**
     * 分页查询 日矿粉需求计划
     * @param dayMineralPowderRequirementsPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<DayMineralPowderRequirementsPlanningVO>> Page(@RequestBody DayMineralPowderRequirementsPlanningDTO dayMineralPowderRequirementsPlanning){
        return ResultUtil.success(this.dayMineralPowderRequirementsPlanningService.queryByPage(dayMineralPowderRequirementsPlanning));
    }

    @PostMapping(value = "saveOrUpdate")
    @ApiOperation(value = "新增/修改")
    public ResultVO saveOrUpdate (@RequestBody DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO dayMineralPowderRequirementsPlanning) {

        boolean result;
        if (dayMineralPowderRequirementsPlanning != null && dayMineralPowderRequirementsPlanning.getId() == null) {
            result = this.dayMineralPowderRequirementsPlanningService.insert(dayMineralPowderRequirementsPlanning);
        }else{
            result = this.dayMineralPowderRequirementsPlanningService.update(dayMineralPowderRequirementsPlanning);
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }



    /**
     * 新增数据
     * @param dayMineralPowderRequirementsPlanning 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO dayMineralPowderRequirementsPlanning) {
        boolean result = this.dayMineralPowderRequirementsPlanningService.insert(dayMineralPowderRequirementsPlanning);
        return result ? ResultUtil.success() : ResultUtil.error();
    }
    
     /**
     * 详情
     * @param id 主键id
     * @return 详情结果
     */
    @GetMapping("/detail")
    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO<DayMineralPowderRequirementsPlanningVO> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.dayMineralPowderRequirementsPlanningService.getById(id));
    }

    /**
     * 编辑数据
     * @param dayMineralPowderRequirementsPlanning 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO dayMineralPowderRequirementsPlanning) {
       this.dayMineralPowderRequirementsPlanningService.update(dayMineralPowderRequirementsPlanning);
       return ResultUtil.success("修改成功");
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("removeById")
    @ApiOperation(value = "删除" )
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO removeById(Integer id) {
        boolean result = this.dayMineralPowderRequirementsPlanningService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

}


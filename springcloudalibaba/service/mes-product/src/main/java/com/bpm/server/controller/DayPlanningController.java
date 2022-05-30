package com.bpm.server.controller;

import com.bpm.common.domain.DayPlanning;
import com.bpm.common.dto.DayPlanningDTO;
import com.bpm.common.dto.DayPlanningInserOrUpdateDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.DayPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.DayPlanningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日计划 表控制层
 * @author wangpeng
 * @since 2022-05-06 09:52:25
 */
@Api(tags = "日计划")
@RestController
@RequestMapping("dayPlanning")
public class DayPlanningController {
    /**
     * 服务对象
     */
    @Resource
    private DayPlanningService dayPlanningService;
    
   
     /**
     * 条件查询 日生产计划
     * @param dayPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<DayPlanningVO>> queryAll(@RequestBody DayPlanningDTO dayPlanning) {
        if (dayPlanning.getProductType() == null) {
            return ResultUtil.error("分类不能为空!");
        }
        return ResultUtil.success(this.dayPlanningService.queryAll(dayPlanning));
    }

      /**
     * 分页查询 日生产计划
     * @param dayPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<DayPlanningVO>> Page(@RequestBody DayPlanningDTO dayPlanning){
        if (dayPlanning.getProductType() == null) {
            return ResultUtil.error("分类不能为空!");
        }
        return ResultUtil.success(this.dayPlanningService.queryByPage(dayPlanning));
    }
  /**
     * 新增或修改
     * @param dayPlanning 实体
     * @return 新增或修改结果
     */
    @PostMapping("insertOrUpdate")
    @ApiOperation(value = "新增或修改")
    public ResultVO insertOrUpdate(@RequestBody DayPlanningInserOrUpdateDTO dayPlanning) {
        if (dayPlanning.getProductType() == null) {
            return ResultUtil.error("生产类型不能空!");
        }
        boolean result;
        if (dayPlanning.getId() == null) {
             result = this.dayPlanningService.insert(dayPlanning);
        }else{
             result = this.dayPlanningService.update(dayPlanning);
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 新增数据
     * @param dayPlanning 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody DayPlanningInserOrUpdateDTO dayPlanning) {
        boolean result = this.dayPlanningService.insert(dayPlanning);
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
    public ResultVO<DayPlanningVO> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.dayPlanningService.queryById(id));
    }

    /**
     * 编辑数据
     * @param
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody DayPlanningInserOrUpdateDTO dayPlanning) {
       boolean result = this.dayPlanningService.update(dayPlanning);
       return  result ? ResultUtil.success() : ResultUtil.error();
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
        boolean result = this.dayPlanningService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

}


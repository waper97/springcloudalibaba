package com.bpm.server.controller;

import com.bpm.common.domain.DayMasterProductionPlaning;
import com.bpm.common.dto.DayMasterProductionPlaningDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.DayMasterProductionPlaningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.DayMasterProductionPlaningService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日主生产计划 表控制层
 * @author wangpeng
 * @since 2022-04-26 16:00:43
 */
@ApiSupport(order = 7)
@Api(tags = "日主生产计划")
@RestController
@RequestMapping("dayMasterProductionPlaning")
//@CrossOrigin
public class DayMasterProductionPlaningController {
    /**
     * 服务对象
     */
    @Resource
    private DayMasterProductionPlaningService dayMasterProductionPlaningService;

    
   
     /**
     * 条件查询 日主生产计划
     * @param dayMasterProductionPlaning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<DayMasterProductionPlaningVO>> queryAll(@RequestBody DayMasterProductionPlaningDTO dayMasterProductionPlaning) {
        return ResultUtil.success(this.dayMasterProductionPlaningService.queryAll(dayMasterProductionPlaning));
    }
      /**
     * 分页查询 日主生产计划
     * @param dayMasterProductionPlaning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<DayMasterProductionPlaningVO>> Page(@RequestBody DayMasterProductionPlaningDTO dayMasterProductionPlaning){
        return ResultUtil.success(this.dayMasterProductionPlaningService.queryByPage(dayMasterProductionPlaning));
    }

    /**
     * 新增/修改
     * @param dayMasterProductionPlaning 实体
     * @return 结果
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation(value ="新增/修改")
    public ResultVO saveOrUpdate(@RequestBody DayMasterProductionPlaning dayMasterProductionPlaning) {
        boolean result ;
        if (dayMasterProductionPlaning.getId() == null) {
             result = this.dayMasterProductionPlaningService.insert(dayMasterProductionPlaning);
        }else{
             result = this.dayMasterProductionPlaningService.update(dayMasterProductionPlaning);
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }




    /**
     * 新增数据
     * @param dayMasterProductionPlaning 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody DayMasterProductionPlaning dayMasterProductionPlaning) {
        boolean result = this.dayMasterProductionPlaningService.insert(dayMasterProductionPlaning);
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
    public ResultVO<DayMasterProductionPlaningVO> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.dayMasterProductionPlaningService.queryById(id));
    }

    /**
     * 编辑数据
     * @param dayMasterProductionPlaning 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody DayMasterProductionPlaning dayMasterProductionPlaning) {
       boolean result = this.dayMasterProductionPlaningService.update(dayMasterProductionPlaning);
       return result ? ResultUtil.success() : ResultUtil.error();
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
        boolean result = this.dayMasterProductionPlaningService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }




    /**
     * 修改状态
     * @param ids 主键
     * @return 结果
     */
    @GetMapping("updateStatus")
    @ApiOperation(value = "修改状态" )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "主键id", required = true),
        @ApiImplicitParam(name = "status", value = "状态", required = true, example = "1,2,3")
    })
    public ResultVO updateStatus(List<Integer> ids, Integer status) {
        boolean result = false;
        if (ids != null && ids.size() > 0) {
            ids.stream().forEach(id ->{
                DayMasterProductionPlaning productionPlaning = new DayMasterProductionPlaning();
                productionPlaning.setId(id);
                productionPlaning.setStatus(status);

                DayMasterProductionPlaningVO older = dayMasterProductionPlaningService.queryById(id);
                if (older != null && (older.getStatus().equals(status)) ) {
                    throw new RuntimeException("状态不允许重复改变!");
                }
                this.dayMasterProductionPlaningService.update(productionPlaning);
            });
            result = true;
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }
}


package com.bpm.server.controller;

import com.bpm.common.domain.DayMaterialRequirementsPlanning;
import com.bpm.common.dto.DayMaterialRequirementsPlanningDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.DayMaterialRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.DayMaterialRequirementsPlanningService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日物料需求计划 表控制层
 * @author wangpeng
 * @since 2022-04-27 10:29:25
 */
@ApiSupport(order = 8)
@Api(tags = "日物料需求计划")
@RestController
@RequestMapping("dayMaterialRequirementsPlanning")
//@CrossOrigin
public class DayMaterialRequirementsPlanningController {
    /**
     * 服务对象
     */
    @Resource
    private DayMaterialRequirementsPlanningService dayMaterialRequirementsPlanningService;
    
   
     /**
     * 条件查询 日物料需求计划
     * @param dayMaterialRequirementsPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<DayMaterialRequirementsPlanningVO>> queryAll(@RequestBody DayMaterialRequirementsPlanningDTO dayMaterialRequirementsPlanning) {
        return ResultUtil.success(this.dayMaterialRequirementsPlanningService.queryAll(dayMaterialRequirementsPlanning));
    }
      /**
     * 分页查询 日物料需求计划
     * @param dayMaterialRequirementsPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<DayMaterialRequirementsPlanningVO>> Page(@RequestBody DayMaterialRequirementsPlanningDTO dayMaterialRequirementsPlanning){
        return ResultUtil.success(this.dayMaterialRequirementsPlanningService.queryByPage(dayMaterialRequirementsPlanning));
    }


    /**
     * 新增数据
     * @param dayMaterialRequirementsPlanning 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning) {
        boolean result = this.dayMaterialRequirementsPlanningService.insert(dayMaterialRequirementsPlanning);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 新增/修改
     * @param dayMaterialRequirementsPlanning 实体
     * @return 新增结果
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation(value ="新增/修改")
    public ResultVO saveOrUpdate(@RequestBody DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning) {
        boolean result ;
        if (dayMaterialRequirementsPlanning.getId() == null) {
             result = this.dayMaterialRequirementsPlanningService.insert(dayMaterialRequirementsPlanning);
        }else{
             result = this.dayMaterialRequirementsPlanningService.update(dayMaterialRequirementsPlanning);
        }

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
    public ResultVO<DayMaterialRequirementsPlanningVO> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.dayMaterialRequirementsPlanningService.queryById(id));
    }

    /**
     * 编辑数据
     * @param dayMaterialRequirementsPlanning 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning) {
       boolean result = this.dayMaterialRequirementsPlanningService.update(dayMaterialRequirementsPlanning);
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
        boolean result = this.dayMaterialRequirementsPlanningService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }



}


package com.bpm.server.controller;

import com.bpm.common.domain.MaterialRequirementsPlanning;
import com.bpm.common.domain.MineralPowderRequirementsPlanning;
import com.bpm.common.dto.MineralPowderRequirementsPlanningDTO;
import com.bpm.common.dto.MineralPowderRequirementsPlanningToInsertOrUpdateDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MineralPowderRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MineralPowderRequirementsPlanningService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 季度矿粉需求计划 控制层
 * @author wangpeng
 * @since 2022-04-24 09:39:00
 */
@ApiSupport(order = 1)
@Api(tags = "季度矿粉需求计划")
@RestController
@RequestMapping("mineralPowderRequirementsPlanning")
public class MineralPowderRequirementsPlanningController {
    /**
     * 服务对象
     */
    @Resource
    private MineralPowderRequirementsPlanningService mineralPowderRequirementsPlanningService;
    
   
     /**
     * 条件查询 矿粉需求计划
     * @param mineralPowderRequirementsPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<MineralPowderRequirementsPlanningVO>> queryAll(@RequestBody MineralPowderRequirementsPlanningDTO mineralPowderRequirementsPlanning) {
        return ResultUtil.success(this.mineralPowderRequirementsPlanningService.queryAll(mineralPowderRequirementsPlanning));
    }
      /**
     * 分页查询 矿粉需求计划
     * @param mineralPowderRequirementsPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<MineralPowderRequirementsPlanningVO>> Page(@RequestBody MineralPowderRequirementsPlanningDTO mineralPowderRequirementsPlanning){
        return ResultUtil.success(this.mineralPowderRequirementsPlanningService.queryByPage(mineralPowderRequirementsPlanning));
    }


    /**
     * 新增/修改
     * @param mineralPowderRequirementsPlanning 实体
     * @return 新增/修改
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation(value ="新增/修改")
    public ResultVO saveOrUpdate(@RequestBody MineralPowderRequirementsPlanningToInsertOrUpdateDTO mineralPowderRequirementsPlanning) {
        boolean result ;
        if (mineralPowderRequirementsPlanning.getId() == null) {
            result = this.mineralPowderRequirementsPlanningService.insert(mineralPowderRequirementsPlanning);
        }else{
            result =  this.mineralPowderRequirementsPlanningService.update(mineralPowderRequirementsPlanning);

        }
        return result ? ResultUtil.success(): ResultUtil.error();
    }




    /**
     * 新增数据
     * @param mineralPowderRequirementsPlanning 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody MineralPowderRequirementsPlanningToInsertOrUpdateDTO mineralPowderRequirementsPlanning) {
        this.mineralPowderRequirementsPlanningService.insert(mineralPowderRequirementsPlanning);
        return ResultUtil.success();
    }

    /**
     * 编辑数据
     * @param mineralPowderRequirementsPlanning 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody MineralPowderRequirementsPlanningToInsertOrUpdateDTO mineralPowderRequirementsPlanning) {
       this.mineralPowderRequirementsPlanningService.update(mineralPowderRequirementsPlanning);
       return ResultVO.create().success("修改成功");
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("removeById")
    @ApiOperation(value = "删除" )
    @ApiImplicitParam(name = "id",value = "物料需求主键id",required = true)
    public ResultVO removeById(Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
        boolean result = this.mineralPowderRequirementsPlanningService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }


    /**
     * 详情
     * @param id 主键
     * @return
     */
    @GetMapping("detail")
    @ApiOperation(value = "详情" )
    @ApiImplicitParam(name = "id",value = "矿粉需求计划id",required = true)
    @ApiParam(value = "矿粉需求计划id" ,name = "id",required = true)
    public ResultVO<MineralPowderRequirementsPlanningVO> detail(Integer id) {
        return ResultUtil.success( this.mineralPowderRequirementsPlanningService.getById(id));
    }



    // TODO:需求单位 下拉接口

    // TODO:需求筒仓 下拉接口


}


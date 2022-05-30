package com.bpm.server.controller;

import com.bpm.common.domain.MaterialRequirementsPlanning;
import com.bpm.common.dto.MaterialRequirementsPlanningDTO;
import com.bpm.common.dto.MrpDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MaterialRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MaterialRequirementsPlanningService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 物料需求计划 表控制层
 * @author wangpeng
 * @since 2022-04-25 11:36:58
 */
@ApiSupport(order = 5)
@Api(tags = "物料需求计划")
@RestController
@RequestMapping("materialRequirementsPlanning")
public class MaterialRequirementsPlanningController {

    @Resource
    private MaterialRequirementsPlanningService materialRequirementsPlanningService;
    
   
     /**
     * 条件查询 物料需求计划
     * @param materialRequirementsPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<MaterialRequirementsPlanningVO>> queryAll(@RequestBody MaterialRequirementsPlanningDTO materialRequirementsPlanning) {
        return ResultUtil.success(this.materialRequirementsPlanningService.queryAll(materialRequirementsPlanning));
    }
      /**
     * 分页查询 物料需求计划
     * @param materialRequirementsPlanning 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<MaterialRequirementsPlanningVO>> Page(@RequestBody MaterialRequirementsPlanningDTO materialRequirementsPlanning){
        return ResultUtil.success(this.materialRequirementsPlanningService.queryByPage(materialRequirementsPlanning));
    }

    /**
     * 新增/修改
     * @param materialRequirementsPlanning 实体
     * @return 结果
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation(value ="新增/修改")
    public ResultVO saveOrUpdate(@RequestBody @Valid MaterialRequirementsPlanning materialRequirementsPlanning) {
//        if (materialRequirementsPlanning.getMasterProductionPlanId() == null) {
//            return ResultUtil.error("主生产计划id不能为空!");
//        }
//        if (StringUtils.isEmpty(materialRequirementsPlanning.getPlanningOperation()))  {
//            return ResultUtil.error("运算类型不能为空!");
//        }
//        if (StringUtils.isEmpty(materialRequirementsPlanning.getOperationCode())) {
//            return ResultUtil.error("运算编号不能为空!");
//        }
        boolean result;
        if (materialRequirementsPlanning != null && materialRequirementsPlanning.getId() == null) {
            result = this.materialRequirementsPlanningService.insert(materialRequirementsPlanning);
        }else{
            result = this.materialRequirementsPlanningService.update(materialRequirementsPlanning);
        }
        return result ? ResultUtil.success() :  ResultUtil.error();
    }



    /**
     * 新增数据
     * @param materialRequirementsPlanning 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody @Valid MaterialRequirementsPlanning materialRequirementsPlanning) {
        if (materialRequirementsPlanning.getMasterProductionPlanId() == null) {
            return ResultUtil.error("主生产计划id不能为空!");
        }
        if (StringUtils.isEmpty(materialRequirementsPlanning.getPlanningOperation()))  {
            return ResultUtil.error("运算类型不能为空!");
        }
        if (StringUtils.isEmpty(materialRequirementsPlanning.getOperationCode())) {
            return ResultUtil.error("运算编号不能为空!");
        }
        boolean result = this.materialRequirementsPlanningService.insert(materialRequirementsPlanning);
        return result ? ResultUtil.success() :  ResultUtil.error();
    }
    
     /**
     * 详情
     * @param id 主键id
     * @return 详情结果
     */
    @GetMapping("/detail")
    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO<MaterialRequirementsPlanning> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.materialRequirementsPlanningService.queryById(id));
    }

    /**
     * 编辑数据
     * @param materialRequirementsPlanning 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody MaterialRequirementsPlanning materialRequirementsPlanning) {
        if (materialRequirementsPlanning == null) {
            ResultUtil.error("修改参数不能为空!");
        }
       boolean result = this.materialRequirementsPlanningService.update(materialRequirementsPlanning);
       return result ? ResultUtil.success() :  ResultUtil.error();
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
        boolean result = this.materialRequirementsPlanningService.deleteById(id);
        return result ? ResultUtil.success() :  ResultUtil.error();
    }

    /**
     * 审核
     * @param ids 主键
     */
    @PostMapping("audit")
    @ApiOperation(value = "审核" )
    @ApiImplicitParam(name = "ids",value = "id集合",required = true)
    public ResultVO audit (@RequestBody List<Integer> ids ) {
        if (ids != null && ids.isEmpty()) {
            return ResultUtil.error("ids集合不能为空");
        }
        final Integer status = 2;
        boolean result = materialRequirementsPlanningService.updateStatusById(ids ,status);
        return result ? ResultUtil.success() : ResultUtil.error() ;
    }

    /**
     * 下发
     * @return
     */
    @PostMapping("issue")
    @ApiOperation(value = "下发" )
    @ApiImplicitParam(name = "ids",value = "id集合",required = true)
    public ResultVO issue(@RequestBody List<Integer> ids) {
        if (ids != null && ids.isEmpty()) {
            return ResultUtil.error("ids集合不能为空");
        }
        final Integer status = 3;
        boolean result = materialRequirementsPlanningService.updateStatusById(ids ,status);
        return result ? ResultUtil.success() : ResultUtil.error() ;
    }



    @GetMapping(value = "/mrp")
    @PostMapping(value = "mrp")
    @ApiOperation(value = "mrp计算")
    public ResultVO mrp (MrpDTO mrpDTO) {
        if (mrpDTO != null) {
            return ResultUtil.error("参数不能为空!");
        }
        if (mrpDTO.getMasterProductionPlanList() == null  ) {
            return ResultUtil.error("主生产计划不能为空!");
        }

        materialRequirementsPlanningService.mrp(mrpDTO);
        return null;
    }



}


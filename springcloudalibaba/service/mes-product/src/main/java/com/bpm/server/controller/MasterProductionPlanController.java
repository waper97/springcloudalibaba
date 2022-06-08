package com.bpm.server.controller;

import com.bpm.common.domain.MasterProductionPlan;
import com.bpm.common.dto.MasterProductionPlanDTO;
import com.bpm.common.dto.MasterProductionPlanSaveOrUpdateDTO;
import com.bpm.common.dto.PlanSchemeCalculateDTO;
import com.bpm.common.util.BusinessException;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MasterProductionPlanVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.purchase.client.PurchaseClient;
import com.bpm.server.service.MasterProductionPlanService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 主生产计划(MasterProductionPlan)表控制层
 * @author wangpeng
 * @since 2022-04-24 16:41:28
 */
@ApiSupport(order = 2)
@Api(tags = "主生产计划")
@RestController
@RequestMapping("masterProductionPlan")
public class MasterProductionPlanController {
    /**
     * 服务对象
     */
    @Resource
    private MasterProductionPlanService masterProductionPlanService;

    @Autowired
    private PurchaseClient purchaseClient;
   
     /**
     * 条件查询 主生产计划
     * @param masterProductionPlan 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<MasterProductionPlanVO>> queryAll(@RequestBody MasterProductionPlanDTO masterProductionPlan) {
        return ResultUtil.success(this.masterProductionPlanService.queryAll(masterProductionPlan));
    }
      /**
     * 分页查询 主生产计划
     * @param masterProductionPlan 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<MasterProductionPlanVO>> Page(@RequestBody MasterProductionPlanDTO masterProductionPlan){
        return ResultUtil.success(this.masterProductionPlanService.queryByPage(masterProductionPlan));
    }

    /**
     * 新增/修改
     * @param masterProductionPlanSaveOrUpdateDTO
     * @return
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation(value ="新增/修改")
    public ResultVO saveOrUpdate(@RequestBody MasterProductionPlanSaveOrUpdateDTO masterProductionPlanSaveOrUpdateDTO) {
//        if (masterProductionPlanSaveOrUpdateDTO.getMesProductMineralPowderRequirementsPlanningId() == null) {
//            return ResultUtil.error("矿粉需求计划主表不能为空");
//        }
        boolean result;
        if (masterProductionPlanSaveOrUpdateDTO.getId() == null) {
            result  = this.masterProductionPlanService.insert(masterProductionPlanSaveOrUpdateDTO);
        }else{
            result  = this.masterProductionPlanService.update(masterProductionPlanSaveOrUpdateDTO);
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }


    /**
     * 新增数据
     * @param masterProductionPlan 实体
     * @return 新增结果
     @PostMapping("add")
     @ApiOperation(value ="新增")*/
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody MasterProductionPlanSaveOrUpdateDTO masterProductionPlan) {
        boolean result = this.masterProductionPlanService.insert(masterProductionPlan);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    @GetMapping("/detail")
    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "主生产计划id", required = true)
    public ResultVO<MasterProductionPlan> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(masterProductionPlanService.queryById(id));
    }

    /**
     * 编辑数据
     * @param masterProductionPlan 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody MasterProductionPlanSaveOrUpdateDTO masterProductionPlan) {
       boolean result = this.masterProductionPlanService.update(masterProductionPlan);
       return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("removeById")
    @ApiOperation(value = "删除" )
    @ApiImplicitParam(name = "id",value = "主生产计划id",required = true)
    public ResultVO removeById(Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
        boolean result = this.masterProductionPlanService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }
    /**
     * 审核
     * @param ids 主键集合
     */
    @PostMapping("audit")
    @ApiOperation(value = "审核" )
    @ApiImplicitParam(name = "ids",value = "id集合",required = true)
    public ResultVO audit (@RequestBody List<Integer> ids) {
        Integer status = 2;
        for (int id : ids) {
            MasterProductionPlanVO productionPlanVO = masterProductionPlanService.queryById(id);
            if (productionPlanVO != null) {
                if ( productionPlanVO.getStatus() == 3) {
                    return ResultUtil.error("当前数据已下发,不能审核!");
                }
            }
        }
        return ResultUtil.success( masterProductionPlanService.updateStatusById(ids, status)) ;
    }

    /**
     * 下发
     * @return
     */
    @PostMapping("issue")
    @ApiOperation(value = "下发" )
    @ExceptionHandler(BusinessException.class)
//    @ApiImplicitParam(name = "ids",value = "id集合",required = true)
    public ResultVO issue(@RequestBody MasterProductionPlanDTO masterProductionPlan) {
        if (masterProductionPlan != null && CollectionUtils.isEmpty(masterProductionPlan.getMasterProductionPlanList())) {
            return ResultUtil.error("主生产计划集合不能为空");
        }
        return masterProductionPlanService.issued(masterProductionPlan.getMasterProductionPlanList());
    }


    @PostMapping(value = "mps")
    @ApiOperation(value = "mps运算")
    public ResultVO mpr(@RequestBody PlanSchemeCalculateDTO planSchemeCalculate) {
        if (planSchemeCalculate == null) {
            return ResultUtil.error("计算参数不能为空!");
        }

        if (planSchemeCalculate.getMineralPowderRequirementsPlanningList() == null ) {
            return ResultUtil.error("季度矿粉需求计划集合不能为空!");
        }
        if (planSchemeCalculate.getMineralPowderRequirementsPlanningList() == null ) {
            return ResultUtil.error("矿粉产计划集合不能为空!");
        }

        return masterProductionPlanService.mps(planSchemeCalculate);
//        return result ? ResultUtil.success(): ResultUtil.error();
    }

    /**
     * feign测试用例
     *
     * @return
     */
//    @GetMapping("hello")
//    public String hello() {
//        MesPurchaseBuyRequestInsertDTO insert = new MesPurchaseBuyRequestInsertDTO();
//        com.bpm.mes.purchase.common.vo.ResultVO add = purchaseClient.add(insert);
//        return "success";
//    }

}


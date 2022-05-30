package com.bpm.server.controller;

import com.bpm.common.domain.MonthlyProductionOrder;
import com.bpm.common.dto.MonthlyProductionOrderDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MonthlyProductionOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 月生产订单 表控制层
 * @author wangpeng
 * @since 2022-05-17 17:21:07
 */
@Api(tags = "月生产订单")
@RestController
@RequestMapping("monthlyProductionOrder")
public class MonthlyProductionOrderController {
    /**
     * 服务对象
     */
    @Resource
    private MonthlyProductionOrderService monthlyProductionOrderService;
    
   
     /**
     * 条件查询 月生产订单
     * @param monthlyProductionOrder 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<MonthlyProductionOrder>> queryAll(@RequestBody MonthlyProductionOrderDTO monthlyProductionOrder) {
        return ResultUtil.success(this.monthlyProductionOrderService.queryAll(monthlyProductionOrder));
    }
      /**
     * 分页查询 月生产订单
     * @param monthlyProductionOrder 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<MonthlyProductionOrder>> Page(@RequestBody MonthlyProductionOrderDTO monthlyProductionOrder){
        return ResultUtil.success(this.monthlyProductionOrderService.queryByPage(monthlyProductionOrder));
    }
  /**
     * 新增或修改
     * @param monthlyProductionOrder 实体
     * @return 新增或修改结果
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "新增或修改")
    public ResultVO saveOrUpdate(@RequestBody MonthlyProductionOrder monthlyProductionOrder) {
        boolean result;
        if (monthlyProductionOrder.getId() == null) {
             result = this.monthlyProductionOrderService.insert(monthlyProductionOrder);
        }else{
             result = this.monthlyProductionOrderService.update(monthlyProductionOrder);
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 新增数据
     * @param monthlyProductionOrder 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody MonthlyProductionOrder monthlyProductionOrder) {
        boolean result = this.monthlyProductionOrderService.insert(monthlyProductionOrder);
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
    public ResultVO<MonthlyProductionOrder> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.monthlyProductionOrderService.queryById(id));
    }

    /**
     * 编辑数据
     * @param monthlyProductionOrder 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody MonthlyProductionOrder monthlyProductionOrder) {
       boolean result = this.monthlyProductionOrderService.update(monthlyProductionOrder);
       return  result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("deleteById")
    @ApiOperation(value = "删除" )
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO removeById(Integer id) {
        boolean result = this.monthlyProductionOrderService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

}


package com.bpm.server.controller;

import com.bpm.common.domain.MonthlyProductionOrder;
import com.bpm.common.dto.MonthlyProductionOrderQueryDTO;
import com.bpm.common.dto.MonthlyProductionOrderTwoDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MonthlyProductionOrderVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MonthlyProductionOrderService;
import com.bpm.server.util.CommonConstantUtils;
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
     * @param dto 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<MonthlyProductionOrderVO>> queryAll(@RequestBody MonthlyProductionOrderQueryDTO dto) {
        return ResultUtil.success(this.monthlyProductionOrderService.queryAll(dto));
    }
      /**
     * 分页查询 月生产订单
     * @param dto 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<MonthlyProductionOrderVO>> Page(@RequestBody MonthlyProductionOrderQueryDTO dto){
        return ResultUtil.success(this.monthlyProductionOrderService.queryByPage(dto));
    }
  /**
     * 新增或修改
     * @param dto 实体
     * @return 新增或修改结果
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "新增或修改")
    public ResultVO saveOrUpdate(@RequestBody MonthlyProductionOrderTwoDto dto) {
        boolean result;
        if (dto.getId() == null) {
             result = this.monthlyProductionOrderService.insert(dto);
        }else{
             result = this.monthlyProductionOrderService.update(dto);
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
    public ResultVO<MonthlyProductionOrder> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.monthlyProductionOrderService.queryById(id));
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
        MonthlyProductionOrder monthlyProductionOrder = monthlyProductionOrderService.queryById(id);
        if (!(CommonConstantUtils.MONTHLY_STATUS_ONE == monthlyProductionOrder.getStatus())){
            return ResultUtil.error("只有新建状态才能删除！");
        }
        boolean result = this.monthlyProductionOrderService.removeById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

}


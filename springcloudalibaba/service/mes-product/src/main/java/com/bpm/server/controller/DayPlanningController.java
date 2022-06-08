package com.bpm.server.controller;

import com.bpm.common.domain.DayPlanningDetail;
import com.bpm.common.dto.DayPlanningDTO;
import com.bpm.common.dto.DayPlanningInserOrUpdateDTO;
import com.bpm.common.dto.DayPlanningProductionReport;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.DayPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.mes.purchase.dto.MesPurchaseBuyRequestInsertDTO;
import com.bpm.mes.stock.client.StockInClient;
import com.bpm.purchase.client.PurchaseClient;
import com.bpm.server.service.DayPlanningDetailService;
import com.bpm.server.service.DayPlanningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    @Resource
    private DayPlanningDetailService dayPlanningDetailService;
    @Resource
    private StockInClient stockInClient;
    @Resource
    private PurchaseClient purchaseClient;

   
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

    @PostMapping(value = "dayBrokenPlanningProductionReport")
    @ApiOperation(value = "日破碎计划报工")
    public ResultVO dayBrokenPlanning(@RequestBody DayPlanningProductionReport dayPlanningProductionReport) {
        if (dayPlanningProductionReport == null || dayPlanningProductionReport.getDayPlanningDetail() == null) {
            return ResultUtil.error("报工参数不能为空!");
        }
        BigDecimal actualQuantity = dayPlanningProductionReport.getDayPlanningDetail().getActualQuantity();
        BigDecimal plannedQuantity = dayPlanningProductionReport.getDayPlanningDetail().getPlannedQuantity();
        if (actualQuantity == null || actualQuantity.compareTo(plannedQuantity) == 1) {
            return ResultUtil.error("实际数量不能为空或者实际数量不能大于计划数量!");
        }
        return  dayPlanningService.brokenOutStock(dayPlanningProductionReport);
    }



    /**
     *  修改状态为已报工
     * @param dayPlanningId 日生产计划id
     * @return
     */
    public boolean productionReport (Integer dayPlanningId, BigDecimal actualQuantity) {
        DayPlanningDetail dayPlanningDetail = new DayPlanningDetail();
        dayPlanningDetail.setId(dayPlanningId);
        dayPlanningDetail.setStatus(1);
        dayPlanningDetail.setActualQuantity(actualQuantity);
       return  dayPlanningDetailService.updateSelective(dayPlanningDetail);
    }

    @PostMapping(value = "dosingTransportProductionReport")
    @ApiOperation(value = "日配料计划报工")
    public ResultVO dosingTransportProductionReport(@RequestBody DayPlanningProductionReport dayPlanningProductionReport) {
        if (dayPlanningProductionReport == null || dayPlanningProductionReport.getDayPlanningDetail() == null) {
            return ResultUtil.error("报工参数不能为空!");
        }
        BigDecimal actualQuantity = dayPlanningProductionReport.getDayPlanningDetail().getActualQuantity();
        BigDecimal plannedQuantity = dayPlanningProductionReport.getDayPlanningDetail().getPlannedQuantity();
        if (actualQuantity == null || actualQuantity.compareTo(plannedQuantity) == 1) {
            return ResultUtil.error("实际数量不能为空或者实际数量不能大于计划数量!");
        }
       ResultVO resultVO  = dayPlanningService.dosingTransportOutStock(dayPlanningProductionReport);
       if (resultVO.getCode().equals(200)) {
           ResultVO inStockResult = dayPlanningService.dosingTransportInStock(dayPlanningProductionReport);
           if (inStockResult.getCode().equals(200)) {
              boolean result = productionReport(dayPlanningProductionReport.getDayPlanningDetail().getDayPlanningId(), dayPlanningProductionReport.getDayPlanningDetail().getActualQuantity());
              return result ? inStockResult : ResultUtil.error(resultVO.getMsg());
           }
       }
       return ResultUtil.error(resultVO.getMsg());
    }

    @PostMapping(value = "dayVerticalMillProductPlanningProductionReport")
    @ApiOperation(value = "日立磨生产计划报工")
    public ResultVO dayVerticalMillProductPlanningProductionReport(@RequestBody DayPlanningProductionReport dayPlanningProductionReport) {
        if (dayPlanningProductionReport == null || dayPlanningProductionReport.getDayPlanningDetail() == null) {
            return ResultUtil.error("报工参数不能为空!");
        }
        BigDecimal actualQuantity = dayPlanningProductionReport.getDayPlanningDetail().getActualQuantity();
        BigDecimal plannedQuantity = dayPlanningProductionReport.getDayPlanningDetail().getPlannedQuantity();
        if (actualQuantity == null || actualQuantity.compareTo(plannedQuantity) == 1) {
            return ResultUtil.error("实际数量不能为空或者实际数量不能大于计划数量!");
        }
        ResultVO resultVO  = dayPlanningService.dayVerticalMillProductPlanningOutStock(dayPlanningProductionReport);
        if (resultVO.getCode().equals(200)) {
            ResultVO inStockResult = dayPlanningService.dayVerticalMillProductPlanningIntStock(dayPlanningProductionReport);
            if (inStockResult.getCode().equals(200)) {
                boolean result = productionReport(dayPlanningProductionReport.getDayPlanningDetail().getDayPlanningId(),actualQuantity);
                return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());
            }
        }
        return resultVO;
    }


    @PostMapping(value = "powderDosingProductionReport")
    @ApiOperation(value = "粉料配料计划报工")
    public ResultVO powderDosingProductionReport(@RequestBody DayPlanningProductionReport dayPlanningProductionReport) {
        ResultVO resultVO  = dayPlanningService.powderDosingProductionOutStock(dayPlanningProductionReport);
        if (resultVO.getCode().equals(200)) {
            ResultVO inStockResult = dayPlanningService.powderDosingProductionInStock(dayPlanningProductionReport);
            BigDecimal actualQuantity = dayPlanningProductionReport.getDayPlanningDetail().getActualQuantity();
            BigDecimal plannedQuantity = dayPlanningProductionReport.getDayPlanningDetail().getPlannedQuantity();
            if (actualQuantity == null || actualQuantity.compareTo(plannedQuantity) == 1) {
                return ResultUtil.error("实际数量不能为空或者实际数量不能大于计划数量!");
            }
            if (inStockResult.getCode().equals(200)) {
                boolean result = productionReport(dayPlanningProductionReport.getDayPlanningDetail().getDayPlanningId(), actualQuantity);
                return result ? inStockResult : ResultUtil.error(inStockResult.getMsg());
            }
        }
        return resultVO;
    }


    @PostMapping(value = "pneumaticTransportProductionReport")
    @ApiOperation(value = "气力计划报工")
    public ResultVO pneumaticTransportProductionReport(@RequestBody DayPlanningProductionReport productionReport) {
        ResultVO resultVO  = dayPlanningService.pneumaticTransportOutStock(productionReport);
        if (resultVO.getCode().equals(200)) {
            return dayPlanningService.pneumaticTransportInStock(productionReport);
        }
        return resultVO;
    }



    @PostMapping(value = "test")
    @ApiOperation(value = "test")
    public void test() {
        MesPurchaseBuyRequestInsertDTO dto = new MesPurchaseBuyRequestInsertDTO();
//         purchaseClient.add(dto);
        System.out.println("fuck");
    }
}


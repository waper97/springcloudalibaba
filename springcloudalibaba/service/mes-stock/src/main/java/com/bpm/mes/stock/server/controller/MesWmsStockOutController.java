package com.bpm.mes.stock.server.controller;

import com.bpm.mes.stock.common.dto.StockCheckResults;
import com.bpm.mes.stock.common.dto.StockOutDto;
import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockinout;
import com.bpm.mes.stock.server.dto.BatchDto;
import com.bpm.mes.stock.server.dto.MesWmsStockOutDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.dto.StockTasksMainAddDto;
import com.bpm.mes.stock.server.service.MesWmsStockOutService;
import com.bpm.mes.stock.server.service.MesWmsStockinoutService;
import com.bpm.mes.stock.server.service.MesWmsStockpoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 仓库出出库主表(MesWmsStockinout)表控制层
 *
 * @author makejava
 * @since 2022-04-22 16:08:21
 */
@RestController
@RequestMapping("out")
@Api(value = "/仓库出库主表管理相关接口",tags = "仓库出库主表管理相关接口")
//@CrossOrigin
public class MesWmsStockOutController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockOutService mesWmsStockOutService;

    @Resource
    private MesWmsStockpoService mesWmsStockpoService;

    @Resource
    private MesWmsStockinoutService mesWmsStockinoutService;
    
    /**
     * 条件查询
     *
     * @param mesWmsStockinoutQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto) {
        return ResultVO.create().success(this.mesWmsStockOutService.queryAll(mesWmsStockinoutQueryDto));
    }
    
    /**
     * 分页查询
     *
     * @param mesWmsStockinoutQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<List<MesWmsStockinout>>> queryByPage(@RequestBody MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto){
        return this.mesWmsStockOutService.queryByPage(mesWmsStockinoutQueryDto);
    }
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @RequestMapping(value = {"/queryById"},method = {RequestMethod.GET})
    public ResultVO queryById(@PathVariable("id") Integer id) {
        return this.mesWmsStockOutService.queryById(id);
    }


    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/removeById")
    @ApiOperation(value = "删除主表")
    public ResultVO removeById(Integer id) {
        return this.mesWmsStockOutService.deleteById(id);
    }

    @DeleteMapping("/removeListById")
    @ApiOperation(value = "删除明细表主表")
    public ResultVO removeListById(Integer id) {
        return this.mesWmsStockOutService.deleteListById(id);
    }

    /**
     * 查询收货订单信息
     */
//    @GetMapping("/queryPurchase")
//    @ApiOperation(value = "查询收货订单信息")
//    public ResultVO queryPurchase(Integer inOutTypeId) {
//        return this.mesWmsStockOutService.queryPurchase(inOutTypeId);
//    }

    /**
     * 查询采购订单信息
     */
//    @PostMapping("/queryPurchase")
//    @ApiOperation(value = "查询收货订单明细信息")
//    public ResultVO queryPurchaseList(@RequestBody InoutPurchaseDto dto) {
//        return this.mesWmsStockOutService.queryPurchase(dto);
//    }

    /**
     * 仓库信息
     *
     * @return 调出仓库是否成功
     */
    @GetMapping("/queryStock")
    @ApiOperation(value = "仓库信息")
    public ResultVO queryStock() {
        return this.mesWmsStockpoService.inStock();
    }

    /**
     * 新增和编辑出库单
     * @param dto
     * @return
     */
    @PostMapping("/addAndEditIn")
    @ApiOperation(value = "新增和编辑出库单")
    public ResultVO addAndEditIn(@RequestBody MesWmsStockOutDto dto) {
        return this.mesWmsStockOutService.addAndEditIn(dto);
    }

    /**
     * 出库
     * @param batchDto
     * @return
     */
    @PostMapping("/ExWarehousing")
    @ApiOperation(value = "出库")
    public ResultVO addWarehousing(@RequestBody BatchDto batchDto) {
        return this.mesWmsStockOutService.addWarehousing(batchDto);
    }
    /**
     * 发起检验
     * @param dto
     * @return
     */
    @PostMapping("/isCheck")
    @ApiOperation(value = "发起检验")
    public ResultVO isCheck(@RequestBody StockTasksMainAddDto dto) {
        return this.mesWmsStockOutService.isCheck(dto);
    }

    /**
     * 上传Sap
     * @param ids 主键
     * @return 查询数量是否成功
     */
    @GetMapping("uploadSap")
    @ApiOperation(value = "上传Sap" )
    @ApiImplicitParam(name = "ids", value = "主键id", required = true)
    public ResultVO uploadSap(@RequestParam List<Integer> ids) {
        if (ids == null){
            return ResultUtil.error("查询条件不能为空！");
        }
        return mesWmsStockinoutService.uploadSap(ids);
    }

    /**
     * 取消上传Sap
     * @param ids 主键
     * @return 取消上传Sap是否成功
     */
    @GetMapping("cancelUploadSap")
    @ApiOperation(value = "取消上传Sap" )
    @ApiImplicitParam(name = "ids", value = "主键id", required = true)
    public ResultVO cancelUploadSap(@RequestParam List<Integer> ids) {
        if (ids == null){
            return ResultUtil.error("查询条件不能为空！");
        }
        return mesWmsStockinoutService.cancelUploadSap(ids);
    }

    /**
     * 新增生产出库
     * @param dto
     * @return
     */
    @PostMapping("/addProductionOut")
    @ApiOperation(value = "新增生产出库")
    public ResultVO addProductionOut(@RequestBody StockOutDto dto) {
        return this.mesWmsStockOutService.addProductionOut(dto);
    }

    /**
     * 条件查询
     *
     * @param stockInOutId 筛选条件
     * @return 查询结果
     */
    @GetMapping("/queryBatchAll")
    @ApiOperation(value="查询批次信息")
    public ResultVO queryBatchAll(Integer stockInOutId) {
        return this.mesWmsStockOutService.queryBatchAll(stockInOutId);
    }

    /**
     * 检验接收
     * @param stockCheckResults 主键
     * @return 检验接收是否成功
     */
    @PostMapping("checkReception")
    @ApiOperation(value = "检验接收" )
    public ResultVO checkReception(@RequestBody StockCheckResults stockCheckResults) {
        return mesWmsStockinoutService.checkReception(stockCheckResults);
    }

}


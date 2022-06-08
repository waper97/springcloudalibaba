package com.bpm.mes.stock.server.controller;

import com.bpm.mes.stock.common.dto.StockInPurchaseDto;
import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockinoutbatch;
import com.bpm.mes.stock.server.dto.BatchDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.dto.StockTasksMainAddDto;
import com.bpm.mes.stock.server.service.MesWmsStockOutService;
import com.bpm.mes.stock.server.service.MesWmsStockinoutService;
import com.bpm.mes.stock.server.service.MesWmsStockpoService;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutQueryVo;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutVo;
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
 * 仓库出入库主表(MesWmsStockinout)表控制层
 *
 * @author makejava
 * @since 2022-04-22 16:08:21
 */
@RestController
@RequestMapping("mesWmsStockin")
@Api(value = "/仓库入库主表管理相关接口",tags = "仓库入库主表管理相关接口")
//@CrossOrigin
public class MesWmsStockinoutController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockinoutService mesWmsStockinoutService;

    @Resource
    private MesWmsStockpoService mesWmsStockpoService;

    @Resource
    private MesWmsStockOutService mesWmsStockOutService;
    
    /**
     * 条件查询
     *
     * @param mesWmsStockinoutQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto) {
        return ResultVO.create().success(this.mesWmsStockinoutService.queryAll(mesWmsStockinoutQueryDto));
    }
    
    /**
     * 分页查询
     *
     * @param mesWmsStockinoutQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<List<MesWmsStockinoutQueryVo>>> queryByPage(@RequestBody MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto){
        return this.mesWmsStockinoutService.queryByPage(mesWmsStockinoutQueryDto);
    }

    /**
     * 查询入库记录批次
     *
     * @param stockinoutbatch 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryBatch")
    @ApiOperation(value="查询入库记录")
    public ResultVO queryAll(@RequestBody MesWmsStockinoutbatch stockinoutbatch) {
        List<MesWmsStockinoutbatch> stockinoutbatchs = this.mesWmsStockinoutService.queryBatch(stockinoutbatch);
        return ResultUtil.success(stockinoutbatchs);
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
        return this.mesWmsStockinoutService.queryById(id);
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
        return this.mesWmsStockinoutService.deleteById(id);
    }

    @DeleteMapping("/removeListById")
    @ApiOperation(value = "删除明细表主表")
    public ResultVO removeListById(Integer id) {
        return this.mesWmsStockinoutService.deleteListById(id);
    }

    /**
     * 查询收货订单信息
     */
    @PostMapping("/queryPurchase")
    @ApiOperation(value = "查询收货订单信息")
    public ResultVO queryPurchase(@RequestBody MesWmsStockinoutVo mesWmsStockinoutVo) {
        return this.mesWmsStockinoutService.queryPurchase(mesWmsStockinoutVo);
    }

    @PostMapping("/queryProduction")
    @ApiOperation(value = "查询生产订单信息")
    public ResultVO queryProduction(@RequestBody MesWmsStockinoutVo mesWmsStockinoutVo) {
        return this.mesWmsStockinoutService.queryProduction(mesWmsStockinoutVo);
    }

    /**
     * 查询收货订单明细信息
     */
//    @PostMapping("/queryPurchaseList")
//    @ApiOperation(value = "查询收货订单明细信息")
//    public ResultVO queryPurchaseList(@RequestBody InoutPurchaseDto dto) {
//        return this.mesWmsStockinoutService.queryPurchaseList(dto);
//    }

    /**
     * 仓库信息
     *
     * @return 仓库信息是否成功
     */
    @GetMapping("/inStock")
    @ApiOperation(value = "仓库信息")
    public ResultVO inStock() {
        return this.mesWmsStockpoService.inStock();
    }

    /**
     * 新增和编辑入库单
     * @param dto
     * @return
     */
    @PostMapping("/addAndEditIn")
    @ApiOperation(value = "新增和编辑入库单")
    public ResultVO addAndEditIn(@RequestBody MesWmsStockinoutDto dto) {
        return this.mesWmsStockinoutService.addAndEditIn(dto);
    }

    /**
     * 收货新增入库单
     * @param dto
     * @return
     */
    @PostMapping("/addPurchaseIn")
    @ApiOperation(value = "收货新增入库单")
    public ResultVO addPurchaseIn(@RequestBody StockInPurchaseDto dto) {
        return this.mesWmsStockinoutService.addPurchaseIn(dto);
    }

    /**
     * 生产新增入库单
     * @param dto
     * @return
     */
    @PostMapping("/addProductionIn")
    @ApiOperation(value = "生产新增入库单")
    public ResultVO addProductionIn(@RequestBody StockInPurchaseDto dto) {
        return this.mesWmsStockinoutService.addProductionIn(dto);
    }

    /**
     * 入库
     * @param batchDto
     * @return
     */
    @PostMapping("/addWarehousing")
    @ApiOperation(value = "入库")
    public ResultVO addWarehousing(@RequestBody BatchDto batchDto) {
        return this.mesWmsStockinoutService.addWarehousing(batchDto);
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
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
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
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO cancelUploadSap(@RequestParam List<Integer> ids) {
        if (ids == null){
            return ResultUtil.error("查询条件不能为空！");
        }
        return mesWmsStockinoutService.cancelUploadSap(ids);
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

}


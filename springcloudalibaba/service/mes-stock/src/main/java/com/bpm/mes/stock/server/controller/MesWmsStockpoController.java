package com.bpm.mes.stock.server.controller;

import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockpobatch;
import com.bpm.mes.stock.server.dto.MesWmsStockPoListDto;
import com.bpm.mes.stock.server.dto.MesWmsStockpoListbatchDto;
import com.bpm.mes.stock.server.dto.MesWmsStockpoQueryDto;
import com.bpm.mes.stock.server.service.MesWmsOtherService;
import com.bpm.mes.stock.server.service.MesWmsStockpoService;
import com.bpm.mes.stock.server.vo.MesWmsStockpoQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
 * 仓库调拨单主表(MesWmsStockpo)表控制层
 *
 * @author makejava
 * @since 2022-04-20 18:10:41
 */
@RestController
@RequestMapping("mesWmsStockpo")
@Api(value = "/仓库调拨单主表管理相关接口",tags = "仓库调拨单主表管理相关接口")
//@CrossOrigin
public class MesWmsStockpoController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockpoService mesWmsStockpoService;

    @Resource
    private MesWmsOtherService otherService;
    
    /**
     * 条件查询
     *
     * @param mesWmsStockpoQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockpoQueryDto mesWmsStockpoQueryDto) {
        return ResultVO.create().success(this.mesWmsStockpoService.queryAll(mesWmsStockpoQueryDto));
    }
    
    /**
     * 分页查询
     *
     * @param mesWmsStockpoQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<List<MesWmsStockpoQueryVo>>> queryByPage(@RequestBody MesWmsStockpoQueryDto mesWmsStockpoQueryDto){
        return this.mesWmsStockpoService.queryByPage(mesWmsStockpoQueryDto);
    }

    /**
     * 查询调拨记录批次
     *
     * @param stockinoutbatch 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryBatch")
    @ApiOperation(value="查询调拨记录批次")
    public ResultVO queryAll(@RequestBody MesWmsStockpobatch stockinoutbatch) {
        List<MesWmsStockpobatch> stockinoutbatchs = this.mesWmsStockpoService.queryBatch(stockinoutbatch);
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
        return this.mesWmsStockpoService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockpo 实体
     * @return 新增结果
     */
//    @PostMapping("/add")
//    @ApiOperation(value ="新增")
//    public ResultVO add(MesWmsStockpo mesWmsStockpo) {
//        return this.mesWmsStockpoService.insert(mesWmsStockpo);
//    }

    /**
     * 编辑数据
     *
     * @param mesWmsStockpo 实体
     * @return 编辑结果
     */
//    @PutMapping("/edit")
//    @ApiOperation(value= "修改")
//    public ResultVO edit(MesWmsStockpo mesWmsStockpo) {
//       return this.mesWmsStockpoService.update(mesWmsStockpo);
//    }
    
    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
//    @DeleteMapping("/removeById")
//    @ApiOperation(value = "删除")
//    public ResultVO removeById(Integer id) {
//        return this.mesWmsStockpoService.deleteById(id);
//    }
    
     /**
     * 逻辑删除数据(假删)
     *
     * @param id 主键
     * @return 辑删除是否成功
     */
    @GetMapping("/updateById")
    @ApiOperation(value = "逻辑删除-主表")
    public ResultVO updateById(Integer id) {
        return this.mesWmsStockpoService.updateById(id);
    }

    @GetMapping("/updateListById")
    @ApiOperation(value = "逻辑删除-明细表")
    public ResultVO updateListById(Integer id) {
        return this.mesWmsStockpoService.updateListById(id);
    }

     /**
     * 调出仓库
     *
     * @return 调出仓库是否成功
     */
    @GetMapping("/outStock")
    @ApiOperation(value = "调出仓库")
    public ResultVO outStock() {
        return this.mesWmsStockpoService.outStock();
    }

    /**
     * 调入仓库
     *
     * @return 调入仓库是否成功
     */
    @GetMapping("/inStock")
    @ApiOperation(value = "调出调入仓库")
    public ResultVO inStock() {
        return this.mesWmsStockpoService.inStock();
    }

    /**
     * 调入仓库
     *
     * @return 调入仓库是否成功
     */
//    @GetMapping("/queryWorkOrder")
//    @ApiOperation(value = "查询工单信息")
//    public ResultVO queryWorkOrder() {
//        return this.mesWmsStockpoService.queryWorkOrder();
//    }

    /**
     * 查询部门信息
     *
     * @return 查询结果
     */
//    @PostMapping("/queryDepartment")
//    @ApiOperation("查询部门(单位)信息")
//    public ResultVO queryByPage(@RequestBody StockOtherVo stockOtherVo) {
//        return otherService.queryDepartment(stockOtherVo);
//    }

    /**
     * 新增和修改调拨单
     *
     * @return 调新增和修改调拨单是否成功
     */
    @PostMapping("/addAndEdit")
    @ApiOperation(value = "新增和修改调拨单")
    public ResultVO addAndEdit(@RequestBody MesWmsStockPoListDto mesWmsStockPoListDto) {
        return this.mesWmsStockpoService.addAndEdit(mesWmsStockPoListDto);
    }

    /**
     * 确认调拨
     *
     * @return 确认调拨是否成功
     */
    @PostMapping("/confirm")
    @ApiOperation(value = "确认调拨")
    public ResultVO confirm(@RequestBody MesWmsStockpoListbatchDto dto) {
        return this.mesWmsStockpoService.confirm(dto);
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
        return mesWmsStockpoService.uploadSap(ids);
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
        return mesWmsStockpoService.cancelUploadSap(ids);
    }

    /**
     * 条件查询
     *
     * @param stockPoId 筛选条件
     * @return 查询结果
     */
    @GetMapping("/queryBatchAll")
    @ApiOperation(value="查询批次信息")
    public ResultVO queryBatchAll(Integer stockPoId) {
        return this.mesWmsStockpoService.queryBatchAll(stockPoId);
    }

}


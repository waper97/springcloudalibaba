package com.bpm.server.controller;

import com.bpm.common.domain.ProductConsumeWorkReport;
import com.bpm.common.dto.OutStockDTO;
import com.bpm.common.dto.ProductConsumeWorkReportDTO;
import com.bpm.common.dto.ProductConsumeWorkReportQueryDto;
import com.bpm.common.dto.ProductConsumeWorkReportTwoDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.*;
import com.bpm.server.service.ProductConsumeWorkReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消耗报工 表控制层
 * @author wangpeng
 * @since 2022-05-25 14:12:56
 */
@Api(tags = "消耗报工")
@RestController
@RequestMapping("productConsumeWorkReport")
public class ProductConsumeWorkReportController {
    /**
     * 服务对象
     */
    @Resource
    private ProductConsumeWorkReportService productConsumeWorkReportService;
    
   
     /**
     * 条件查询 消耗报工
     * @param productConsumeWorkReport 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<ProductConsumeWorkReport>> queryAll(@RequestBody ProductConsumeWorkReportDTO productConsumeWorkReport) {
        return ResultUtil.success(this.productConsumeWorkReportService.queryAll(productConsumeWorkReport));
    }
      /**
     * 分页查询 消耗报工
     * @param dto 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<ProductConsumeWorkReportVO>> Page(@RequestBody ProductConsumeWorkReportQueryDto dto){
        return this.productConsumeWorkReportService.queryByPage(dto);
    }
  /**
     * 新增或修改
     * @param dto 实体
     * @return 新增或修改结果
     */
    @PostMapping("insertOrUpdate")
    @ApiOperation(value = "新增或修改")
    public ResultVO insertOrUpdate(@RequestBody ProductConsumeWorkReportTwoDto dto) {
        if (dto.getId() == null) {
            return this.productConsumeWorkReportService.insert(dto);
        }else{
            return this.productConsumeWorkReportService.update(dto);
        }
    }

     /**
     * 详情
     * @param id 主键id
     * @return 详情结果
     */
    @GetMapping("/detail")
    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO<ProductConsumeWorkReport> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.productConsumeWorkReportService.queryById(id));
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
        return this.productConsumeWorkReportService.deleteById(id);
    }

    /**
     * 查询仓库物料出库信息
     * @param dto 主键
     * @return 查询仓库物料出库信息是否成功
     */
    @PostMapping("queryOutStock")
    @ApiOperation(value = "查询仓库物料出库信息" )
    public ResultVO queryInStock(@RequestBody OutStockDTO dto) {
        List<OutStockVo> vos = productConsumeWorkReportService.queryOutStock(dto);
        return ResultUtil.success(vos);
    }

    /**
     * 查询明细
     * @param dto 主键
     * @return 查询明细是否成功
     */
    @PostMapping("queryAty")
    @ApiOperation(value = "查询明细" )
    public ResultVO queryAty(@RequestBody OutStockDTO dto) {
        List<ProductConsumeWorkReportListVO> vos = productConsumeWorkReportService.queryAty(dto);
        return ResultUtil.success(vos);
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
        return productConsumeWorkReportService.uploadSap(ids);
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
        return productConsumeWorkReportService.cancelUploadSap(ids);
    }

}


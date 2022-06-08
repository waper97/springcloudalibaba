package com.bpm.server.controller;

import com.bpm.common.domain.ProductInWorkReport;
import com.bpm.common.dto.InStockDTO;
import com.bpm.common.dto.ProductInWorkReportDTO;
import com.bpm.common.dto.ProductInWorkReportQueryDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.InStockVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ProductInWorkReportVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.ProductInWorkReportService;
import com.bpm.server.util.CommonConstantUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 生成入库报工 表控制层
 * @author wangpeng
 * @since 2022-05-23 14:53:17
 */
@Api(tags = "生成入库报工")
@RestController
@RequestMapping("productInWorkReport")
public class ProductInWorkReportController {
    /**
     * 服务对象
     */
    @Resource
    private ProductInWorkReportService productInWorkReportService;
    
   
     /**
     * 条件查询 生成入库报工
     * @param productInWorkReport 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<ProductInWorkReportVO>> queryAll(@RequestBody ProductInWorkReportQueryDTO productInWorkReport) {
        return ResultUtil.success(this.productInWorkReportService.queryAll(productInWorkReport));
    }
      /**
     * 分页查询 生成入库报工
     * @param queryDTO 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<ProductInWorkReportVO>> Page(@RequestBody ProductInWorkReportQueryDTO queryDTO){
        return ResultUtil.success(this.productInWorkReportService.queryByPage(queryDTO));
    }
  /**
     * 新增或修改
     * @param dto 实体
     * @return 新增或修改结果
     */
    @PostMapping("insertOrUpdate")
    @ApiOperation(value = "新增或修改")
    public ResultVO insertOrUpdate(@RequestBody ProductInWorkReportDTO dto) {
        if (dto.getId() == null) {
            return this.productInWorkReportService.insert(dto);
        }else{
            return this.productInWorkReportService.update(dto);
        }
    }

     /**
     * 详情
     * @param id 主键id
     * @return 详情结果
     */
    @GetMapping("/detail")
    @ApiOperation("详情")
//    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO<ProductInWorkReport> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.productInWorkReportService.queryById(id));
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
        ProductInWorkReport inWorkReport = productInWorkReportService.queryById(id);
        if (!CommonConstantUtils.INWORKREPORT_STATUS_ONE.equals(inWorkReport.getStatus())){
            return  ResultUtil.error("只有新增状态才能删除！");
        }
        boolean result = this.productInWorkReportService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 查询最新批次数据
     * @param workReportDate 主键
     * @return 查询最新批次数据是否成功
     */
    @GetMapping("queryBatchNo")
    @ApiOperation(value = "查询最新批次数据" )
//    @ApiImplicitParam(name = "workReportDate", value = "单据日期", required = true)
    public ResultVO queryBatchNo(String workReportDate) {
        String batchNoatchNo = productInWorkReportService.queryBatchNo(workReportDate);
        ProductInWorkReport inWorkReport = new ProductInWorkReport();
        inWorkReport.setBatchNo(batchNoatchNo);
        return ResultUtil.success(inWorkReport);
    }

    /**
     * 查询仓库物料入库信息
     * @param dto 主键
     * @return 查询仓库物料入库信息是否成功
     */
    @PostMapping("queryInStock")
    @ApiOperation(value = "查询仓库物料入库信息" )
    public ResultVO queryInStock(@RequestBody InStockDTO dto) {
        List<InStockVo> stockCodes = productInWorkReportService.queryInStock(dto);
        return ResultUtil.success(stockCodes);
    }

    /**
     * 数量
     * @param dto 主键
     * @return 查询数量是否成功
     */
    @PostMapping("queryAty")
    @ApiOperation(value = "数量" )
    public ResultVO queryAty(@RequestBody InStockDTO dto) {
        if (dto.getStockInOutIds() == null || dto.getMaterialId() == null){
            return ResultUtil.error("查询条件不能为空！");
        }
        BigDecimal qty = productInWorkReportService.queryAty(dto);
        return ResultUtil.success(qty);
    }

    /**
     * 上传Sap
     * @param ids 主键
     * @return 查询数量是否成功
     */
    @GetMapping("uploadSap")
    @ApiOperation(value = "上传Sap" )
//    @ApiImplicitParam(name = "ids", value = "主键id", required = true)
    public ResultVO uploadSap(@RequestParam List<Integer> ids) {
        if (ids == null){
            return ResultUtil.error("查询条件不能为空！");
        }
        return productInWorkReportService.uploadSap(ids);
    }

    /**
     * 取消上传Sap
     * @param ids 主键
     * @return 取消上传Sap是否成功
     */
    @GetMapping("cancelUploadSap")
    @ApiOperation(value = "取消上传Sap" )
//    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO cancelUploadSap(@RequestParam List<Integer> ids) {
        if (ids == null){
            return ResultUtil.error("查询条件不能为空！");
        }
        return productInWorkReportService.cancelUploadSap(ids);
    }

}


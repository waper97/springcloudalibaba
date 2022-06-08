package com.bpm.server.controller;

import com.bpm.common.domain.ProductTaskWorkReport;
import com.bpm.common.dto.ProductTaskWorkReportDTO;
import com.bpm.common.dto.ProductTaskWorkReportQueryDto;
import com.bpm.common.dto.ProductTaskWorkReportTwoDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ProductTaskWorkReportVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.ProductTaskWorkReportService;
import com.bpm.server.util.CommonConstantUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作业报工 表控制层
 * @author wangpeng
 * @since 2022-05-25 14:15:44
 */
@Api(tags = "作业报工")
@RestController
@RequestMapping("productTaskWorkReport")
public class ProductTaskWorkReportController {
    /**
     * 服务对象
     */
    @Resource
    private ProductTaskWorkReportService productTaskWorkReportService;
    
   
     /**
     * 条件查询 作业报工
     * @param productTaskWorkReport 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<ProductTaskWorkReport>> queryAll(@RequestBody ProductTaskWorkReportDTO productTaskWorkReport) {
        return ResultUtil.success(this.productTaskWorkReportService.queryAll(productTaskWorkReport));
    }
      /**
     * 分页查询 作业报工
     * @param dto 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<ProductTaskWorkReportVO>> Page(@RequestBody ProductTaskWorkReportQueryDto dto){
        return ResultUtil.success(this.productTaskWorkReportService.queryByPage(dto));
    }
  /**
     * 新增或修改
     * @param dto 实体
     * @return 新增或修改结果
     */
    @PostMapping("insertOrUpdate")
    @ApiOperation(value = "新增或修改")
    public ResultVO insertOrUpdate(@RequestBody ProductTaskWorkReportTwoDto dto) {
        boolean result;
        if (dto.getId() == null) {
             result = this.productTaskWorkReportService.insert(dto);
        }else{
             result = this.productTaskWorkReportService.update(dto);
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
    public ResultVO<ProductTaskWorkReport> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.productTaskWorkReportService.queryById(id));
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
        ProductTaskWorkReport productTaskWorkReport = productTaskWorkReportService.queryById(id);
        if (!CommonConstantUtils.TASKWORKREPORT_STATUS_ONE.equals(productTaskWorkReport.getStatus())){
            return ResultUtil.error("只有新增状态才能删除！");
        }
        boolean result = this.productTaskWorkReportService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
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
        return productTaskWorkReportService.uploadSap(ids);
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
        return productTaskWorkReportService.cancelUploadSap(ids);
    }

}


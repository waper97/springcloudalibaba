package com.bpm.server.controller;
import java.util.List;
import io.swagger.annotations.ApiImplicitParam;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.dto.ProductInWorkReportDTO;
import com.bpm.common.domain.ProductInWorkReport;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.ProductInWorkReportService;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

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
    public ResultVO<List<ProductInWorkReport>> queryAll(@RequestBody ProductInWorkReportDTO productInWorkReport) {
        return ResultUtil.success(this.productInWorkReportService.queryAll(productInWorkReport));
    }
      /**
     * 分页查询 生成入库报工
     * @param productInWorkReport 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<ProductInWorkReport>> Page(@RequestBody ProductInWorkReportDTO productInWorkReport){
        return ResultUtil.success(this.productInWorkReportService.queryByPage(productInWorkReport));
    }
  /**
     * 新增或修改
     * @param productInWorkReport 实体
     * @return 新增或修改结果
     */
    @PostMapping("insertOrUpdate")
    @ApiOperation(value = "新增或修改")
    public ResultVO insertOrUpdate(@RequestBody ProductInWorkReport productInWorkReport) {
        boolean result;
        if (productInWorkReport.getId() == null) {
             result = this.productInWorkReportService.insert(productInWorkReport);
        }else{
             result = this.productInWorkReportService.update(productInWorkReport);
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 新增数据
     * @param productInWorkReport 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody ProductInWorkReport productInWorkReport) {
        boolean result = this.productInWorkReportService.insert(productInWorkReport);
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
    public ResultVO<ProductInWorkReport> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.productInWorkReportService.queryById(id));
    }

    /**
     * 编辑数据
     * @param productInWorkReport 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody ProductInWorkReport productInWorkReport) {
       boolean result = this.productInWorkReportService.update(productInWorkReport);
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
        boolean result = this.productInWorkReportService.removeById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

}


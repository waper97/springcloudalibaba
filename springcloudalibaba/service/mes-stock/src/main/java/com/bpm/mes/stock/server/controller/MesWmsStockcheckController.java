package com.bpm.mes.stock.server.controller;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.bpm.common.service.util.ExcelExportStyle;
import com.bpm.common.service.util.ExcelUtil;
import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.dto.CheckDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcheckDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcheckQueryDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.excel.StockCheeckExcel;
import com.bpm.mes.stock.server.service.MesWmsStockcheckService;
import com.bpm.mes.stock.server.service.MesWmsStockpoService;
import com.bpm.mes.stock.server.vo.MesWmsStockcheckVo;
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
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 仓库盘点主表(MesWmsStockcheck)表控制层
 *
 * @author makejava
 * @since 2022-04-28 19:16:22
 */
@RestController
@RequestMapping("/mesWmsStockcheck")
@Api(value = "仓库盘点主表管理相关接口",tags = "仓库盘点主表管理相关接口")
//@CrossOrigin
public class MesWmsStockcheckController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockcheckService mesWmsStockcheckService;

    @Resource
    private MesWmsStockpoService mesWmsStockpoService;
    
    /**
     * 条件查询
     *
     * @param mesWmsStockcheckQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockcheckQueryDto mesWmsStockcheckQueryDto) {
        return ResultVO.create().success(this.mesWmsStockcheckService.queryAll(mesWmsStockcheckQueryDto));
    }
    
    /**
     * 分页查询
     *
     * @param mesWmsStockcheckQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<List<MesWmsStockcheckVo>>> queryByPage(@RequestBody MesWmsStockcheckQueryDto mesWmsStockcheckQueryDto){
        return this.mesWmsStockcheckService.queryByPage(mesWmsStockcheckQueryDto);
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
        return this.mesWmsStockcheckService.queryById(id);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/removeById")
    @ApiOperation(value = "删除")
    public ResultVO removeById(Integer id) {
        return this.mesWmsStockcheckService.deleteById(id);
    }

    /**
     * 仓库信息
     *
     * @return 调出仓库是否成功
     */
    @GetMapping("/queryStock")
    @ApiOperation(value = "仓库信息")
    public ResultVO queryStock() {
        return this.mesWmsStockcheckService.queryStock();
    }

    /**
     * 新增和编辑数据
     *
     * @param dto 主键
     * @return 新增和编辑数据是否成功
     */
    @PostMapping("/addAndEdit")
    @ApiOperation(value = "新增和编辑数据")
    public ResultVO addAndEdit(@RequestBody MesWmsStockcheckDto dto) {
        return this.mesWmsStockcheckService.addAndEdit(dto);
    }

    /**
     * 盘点
     *
     * @param dto 主键
     * @return 盘点是否成功
     */
    @PostMapping("/inventory")
    @ApiOperation(value = "盘点")
    public ResultVO inventory(@RequestBody MesWmsStockcheckDto dto) {
        return this.mesWmsStockcheckService.inventory(dto);
    }

    /**
     * 调账
     *
     * @param dto 主键
     * @return 调账是否成功
     */
    @PostMapping("/account")
    @ApiOperation(value = "调账")
    public ResultVO account(@RequestBody CheckDto dto) {
        return this.mesWmsStockcheckService.account(dto);
    }

    /**
     * 导出
     */
    @PostMapping(value = "/exportExample")
    @ApiOperation(value = "导出")
    public void exportExample(HttpServletResponse response, @RequestBody MesWmsStockinoutQueryDto queryDto) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        List<StockCheeckExcel> excels = mesWmsStockcheckService.exportExample(queryDto);
        //设置样式参数
        ExportParams exportParams = new ExportParams();
        exportParams.setStyle(ExcelExportStyle.class);
        //导出操作  + System.currentTimeMillis()
        String fileName = "盘点导出excel数据";
//        fileName = new String(fileName.getBytes(),"UTF-8");
        ExcelUtil.exportExcel(excels, StockCheeckExcel.class, fileName, exportParams, response);
    }

    /**
     * 下载模板
     */
    @GetMapping(value = "/downloadExcel")
    @ApiOperation(value = "下载模板")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        List<StockCheeckExcel> excels = new ArrayList<>();

        //设置样式参数
        ExportParams exportParams = new ExportParams();
        exportParams.setStyle(ExcelExportStyle.class);
        String fileName = "盘点导入excel模板";
        //导出操作
        ExcelUtil.exportExcel(excels, StockCheeckExcel.class, fileName, exportParams, response);
    }

    /**
     * 盘点表导入excel数据
     *
     * @param file 导入文件
     * @return 导入结果
     * @throws IOException IO异常
     */
    @ApiOperation("盘点表导入excel数据")
    @RequestMapping(value = {"/importExcel"}, method = {RequestMethod.POST})
    public ResultVO importExcelBasicDataMaterialInfo(@RequestParam("file") MultipartFile file) throws IOException {
        //导入操作
        List<StockCheeckExcel> excels = ExcelUtil.importExcel(file, 0, 1, StockCheeckExcel.class);
        return mesWmsStockcheckService.importExcel(excels);
    }

    /**
     * 上传Sap
     * @param id 主键
     * @return 查询数量是否成功
     */
    @GetMapping("uploadSap")
    @ApiOperation(value = "上传Sap" )
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO uploadSap(@RequestParam Integer id) {
        if (id == null){
            return ResultUtil.error("查询条件不能为空！");
        }
        return mesWmsStockcheckService.uploadSap(id);
    }

    /**
     * 取消上传Sap
     * @param id 主键
     * @return 取消上传Sap是否成功
     */
    @GetMapping("cancelUploadSap")
    @ApiOperation(value = "取消上传Sap" )
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO cancelUploadSap(@RequestParam Integer id) {
        if (id == null){
            return ResultUtil.error("查询条件不能为空！");
        }
        return mesWmsStockcheckService.cancelUploadSap(id);
    }
}


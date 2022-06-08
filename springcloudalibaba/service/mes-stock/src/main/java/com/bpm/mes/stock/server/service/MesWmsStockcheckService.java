package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockcheck;
import com.bpm.mes.stock.server.dto.CheckDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcheckDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcheckQueryDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.excel.StockCheeckExcel;
import com.bpm.mes.stock.server.vo.MesWmsStockcheckVo;

import java.util.List;
/**
 * 仓库盘点主表(MesWmsStockcheck)表服务接口
 *
 * @author makejava
 * @since 2022-04-28 19:16:22
 */
public interface MesWmsStockcheckService {
       
     //条件查询  
    List<MesWmsStockcheck> queryAll(MesWmsStockcheckQueryDto mesWmsStockcheckQueryDto);
       
    //分页查询
    ResultVO<PageInfoVO<List<MesWmsStockcheckVo>>> queryByPage(MesWmsStockcheckQueryDto mesWmsStockcheckQueryDto);
 
    //通过ID查询单条数据
    ResultVO queryById(Integer id);
    
    //新增数据
    ResultVO insert(MesWmsStockcheck mesWmsStockcheck);

    //修改数据
    ResultVO update(MesWmsStockcheck mesWmsStockcheck);

    //通过主键删除数据
    ResultVO deleteById(Integer id);
    
    //通过主键逻辑删除数据
    ResultVO updateById(Integer id);

    //新增和编辑数据
    ResultVO addAndEdit(MesWmsStockcheckDto dto);

    //盘点
    ResultVO inventory(MesWmsStockcheckDto dto);

    //调账
    ResultVO account(CheckDto dto);

    //仓库信息
    ResultVO queryStock();

    //导出
    List<StockCheeckExcel> exportExample(MesWmsStockinoutQueryDto queryDto);

    //盘点表导入excel数据
    ResultVO importExcel(List<StockCheeckExcel> excels);

    //上传Sap
    ResultVO uploadSap(Integer id);

    //取消上传Sap
    ResultVO cancelUploadSap(Integer id);
}

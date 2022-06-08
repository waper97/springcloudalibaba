package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.common.dto.StockCheckResults;
import com.bpm.mes.stock.common.dto.StockInPurchaseDto;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockinout;
import com.bpm.mes.stock.server.domain.MesWmsStockinoutbatch;
import com.bpm.mes.stock.server.dto.BatchDto;
import com.bpm.mes.stock.server.dto.InoutPurchaseDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutQueryVo;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutVo;

import java.util.List;
/**
 * 仓库出入库主表(MesWmsStockinout)表服务接口
 *
 * @author makejava
 * @since 2022-04-22 16:08:22
 */
public interface MesWmsStockinoutService {
       
     //条件查询  
    List<MesWmsStockinoutQueryVo> queryAll(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto);
       
    //分页查询
    ResultVO<PageInfoVO<List<MesWmsStockinoutQueryVo>>> queryByPage(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto);
 
    //通过ID查询单条数据
    ResultVO queryById(Integer id);
    
    //新增数据
    ResultVO insert(MesWmsStockinout mesWmsStockinout);

    //修改数据
    ResultVO update(MesWmsStockinout mesWmsStockinout);

    //通过主键删除数据
    ResultVO deleteById(Integer id);
    
    //通过主键逻辑删除数据
    ResultVO updateById(Integer id);

    //新增和编辑入库单
    ResultVO addAndEditIn(MesWmsStockinoutDto dto);

    //查询采购订单信息
    ResultVO queryPurchase(MesWmsStockinoutVo mesWmsStockinoutVo);

    //删除明细表主表
    ResultVO deleteListById(Integer id);

    //查询收货订单明细信息
    ResultVO queryPurchaseList(InoutPurchaseDto dto);

    //生产新增入库单
    ResultVO addProductionIn(StockInPurchaseDto dto);

    //入库
    ResultVO addWarehousing(BatchDto batchDto);

    //收货新增入库单
    ResultVO addPurchaseIn(StockInPurchaseDto dto);

    //查询生产订单信息
    ResultVO queryProduction(MesWmsStockinoutVo mesWmsStockinoutVo);

    //查询入库记录
    List<MesWmsStockinoutbatch> queryBatch(MesWmsStockinoutbatch stockinoutbatch);

    //上传Sap
    ResultVO uploadSap(List<Integer> ids);

    //取消上传Sap
    ResultVO cancelUploadSap(List<Integer> ids);

    //检验接收
    ResultVO checkReception(StockCheckResults stockCheckResults);

}

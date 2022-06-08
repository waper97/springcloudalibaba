package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.common.dto.StockOutDto;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockinout;
import com.bpm.mes.stock.server.dto.BatchDto;
import com.bpm.mes.stock.server.dto.InoutPurchaseDto;
import com.bpm.mes.stock.server.dto.MesWmsStockOutDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.dto.StockTasksMainAddDto;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutQueryVo;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutVo;

import java.util.List;

/**
 * 仓库出入库主表(MesWmsStockinout)表服务接口
 *
 * @author makejava
 * @since 2022-04-22 16:08:22
 */
public interface MesWmsStockOutService {
       
     //条件查询  
    List<MesWmsStockinoutQueryVo> queryAll(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto);
       
    //分页查询
    ResultVO<PageInfoVO<List<MesWmsStockinout>>> queryByPage(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto);
 
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
    ResultVO addAndEditIn(MesWmsStockOutDto dto);

    //查询采购订单信息
    ResultVO queryPurchase(MesWmsStockinoutVo mesWmsStockinoutVo);

    //删除明细表主表
    ResultVO deleteListById(Integer id);

    //查询收货订单明细信息
//    ResultVO queryPurchase(InoutPurchaseDto dto);
    ResultVO queryPurchaseList(InoutPurchaseDto dto);

    //入库
    ResultVO addWarehousing(BatchDto batchDto);

    //发起检验
    ResultVO isCheck(StockTasksMainAddDto dto);

    //新增生产出库
    ResultVO addProductionOut(StockOutDto dto);

    //查询批次信息
    ResultVO queryBatchAll(Integer stockInOutId);
}

package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockpo;
import com.bpm.mes.stock.server.domain.MesWmsStockpobatch;
import com.bpm.mes.stock.server.dto.MesWmsStockPoListDto;
import com.bpm.mes.stock.server.dto.MesWmsStockpoListbatchDto;
import com.bpm.mes.stock.server.dto.MesWmsStockpoQueryDto;
import com.bpm.mes.stock.server.vo.MesWmsStockpoQueryVo;

import java.util.List;

/**
 * 仓库调拨单主表(MesWmsStockpo)表服务接口
 *
 * @author makejava
 * @since 2022-04-20 18:10:43
 */
public interface MesWmsStockpoService {
       
     //条件查询  
     ResultVO queryAll(MesWmsStockpoQueryDto mesWmsStockpoQueryDto);
       
    //分页查询
    ResultVO<PageInfoVO<List<MesWmsStockpoQueryVo>>> queryByPage(MesWmsStockpoQueryDto mesWmsStockpoQueryDto);
 
    //通过ID查询单条数据
    ResultVO queryById(Integer id);
    
    //新增数据
    ResultVO insert(MesWmsStockpo mesWmsStockpo);

    //修改数据
    ResultVO update(MesWmsStockpo mesWmsStockpo);

    //通过主键删除数据
    ResultVO deleteById(Integer id);
    
    //通过主键逻辑删除数据
    ResultVO updateById(Integer id);

    //调出仓库
    ResultVO outStock();

    //调入仓库
    ResultVO inStock();

    //新增和修改调拨单
    ResultVO addAndEdit(MesWmsStockPoListDto mesWmsStockPoListDto);

    //确认调拨
    ResultVO confirm(MesWmsStockpoListbatchDto dto);

    //逻辑删除-明细表
    ResultVO updateListById(Integer id);

    //查询调拨记录批次
    List<MesWmsStockpobatch> queryBatch(MesWmsStockpobatch stockinoutbatch);

    //上传Sap
    ResultVO uploadSap(List<Integer> ids);

    //取消上传Sap
    ResultVO cancelUploadSap(List<Integer> ids);

    //查询批次信息
    ResultVO queryBatchAll(Integer stockPoId);
}

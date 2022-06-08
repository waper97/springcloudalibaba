package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.domain.MesWmsStockchecklist;
import com.bpm.mes.stock.server.dto.MesWmsStockcheckQueryDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.excel.StockCheeckExcel;
import com.bpm.mes.stock.server.vo.MesWmsStockPoListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockPoPlaceListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockcheckVo;

import java.util.List;

public interface MesWmsStockcheckExtMapper {

    //查询所有
    List<MesWmsStockcheckVo> queryAll(MesWmsStockcheckQueryDto dto);

    //删除明细
    int deleteChecklist(Integer stockCheckId);

    //仓库信息
    List<MesWmsStockPoListVo> queryStock();

    //库区库位
    List<MesWmsStockPoPlaceListVo> queryStockPlace(Integer stockId);

    List<StockCheeckExcel> exportExample(MesWmsStockinoutQueryDto queryDto);

    List<MesWmsStockchecklist> queryState(Integer stockCheckId);
}

package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.dto.MesWmsStockmoveplaceNewstDto;
import com.bpm.mes.stock.server.vo.MesWmsStockcurrentStockVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MesWmsStockcurrentExtMapper {

    //查询仓库信息-用于查询条件
    List<MesWmsStockcurrentStockVo> selectStock();

    //查询仓库库位信息-用于库位转移查询条件
    List<MesWmsStockmoveplaceNewstDto> selectStockPlace(Integer stockId);

//    MesWmsStockcurrent querySome(MesWmsStockchecklistInsertDTO mesWmsStockchecklistInsertDTO);

}

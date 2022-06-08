package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.domain.MesWmsStockmoveplace;
import com.bpm.mes.stock.server.dto.MesWmsStockListDto;
import com.bpm.mes.stock.server.dto.MesWmsStockPlaceListDto;
import com.bpm.mes.stock.server.dto.MesWmsStockPlaceMaterialListDto;
import com.bpm.mes.stock.server.dto.MesWmsStockmoveplaceQueryDto;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MesWmsStockmoveplaceExtMapper {
    //获取仓库信息
    List<MesWmsStockListDto> selectStock(@Param("stockId") Integer stockId);

    //查询库区库位信息
    List<MesWmsStockPlaceListDto> selectStockPlace(@Param("stockId") Integer stockId, @Param("stockPlaceId") Integer stockPlaceId);

    //查询物料信息
    List<MesWmsStockPlaceMaterialListDto> selectStockPlaceMaterial(@Param("stockPlaceId") Integer stockPlaceId);

    //查询移除单据编码
    String queryMoveCode();

    //查询所有
    List<MesWmsStockmoveplace> queryAll(MesWmsStockmoveplaceQueryDto mesWmsStockmoveplaceQueryDto);
}

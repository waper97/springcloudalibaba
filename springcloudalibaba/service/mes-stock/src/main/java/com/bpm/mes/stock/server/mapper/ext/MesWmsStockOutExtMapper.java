package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.dto.InoutPurchaseDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutQueryVo;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutVo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MesWmsStockOutExtMapper {
    //查询所有
    List<MesWmsStockinoutQueryVo> queryAll(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto);

    //查询出入库编码
    String queryInOutCode(@Param("inOutPropert") String inOutPropert);

    //查询采购订单信息
    List<MesWmsStockinoutVo> queryPurchase();

    //查询采购订单明细数据
    List<MesWmsStockinoutListVo> queryPurchaseList(InoutPurchaseDto dto);

}
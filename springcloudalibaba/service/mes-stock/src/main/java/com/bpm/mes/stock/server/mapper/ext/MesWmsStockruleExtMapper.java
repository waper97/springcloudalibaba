package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.domain.MesWmsStockrule;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MesWmsStockruleExtMapper {

    //查询最新出入库编码
    String queryTypeCode(String inOutPropert);

    //查询所有
    List<MesWmsStockrule> queryAll(MesWmsStockrule mesWmsStockrule);
}

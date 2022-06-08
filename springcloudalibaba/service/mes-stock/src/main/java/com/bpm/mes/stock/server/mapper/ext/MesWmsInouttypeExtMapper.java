package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.domain.MesWmsInouttype;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MesWmsInouttypeExtMapper {

    //查询最新出入库类型编码
    String queryTypeCode(String erpBillCode);

    //查询所有
    List<MesWmsInouttype> queryAll(MesWmsInouttype mesWmsInouttype);
}

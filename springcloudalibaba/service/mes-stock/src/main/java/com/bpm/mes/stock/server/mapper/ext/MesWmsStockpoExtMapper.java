package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.domain.MesWmsStockpolist;
import com.bpm.mes.stock.server.dto.MesWmsStockpoQueryDto;
import com.bpm.mes.stock.server.vo.MesWmsStockPoListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockPoPlaceListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockpoQueryVo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MesWmsStockpoExtMapper {
    //查询所有
    List<MesWmsStockpoQueryVo> queryAll(MesWmsStockpoQueryDto mesWmsStockpoQueryDto);

    //仓库信息列表
    List<MesWmsStockPoListVo> outStock();

    //即时库存库位物料信息
    List<MesWmsStockPoPlaceListVo> outStockPlace(@Param("stockId") Integer stockId);

    //库存信息
    List<MesWmsStockPoListVo> inStock();

    List<MesWmsStockPoPlaceListVo> inStockPlace(@Param("stockId") Integer stockId);

    //查询单据信息
    String queryPoCode();

    //查询调拨单明细是不是最后一条
    List<MesWmsStockpolist> queryStockPo(Integer stockPoId);
}

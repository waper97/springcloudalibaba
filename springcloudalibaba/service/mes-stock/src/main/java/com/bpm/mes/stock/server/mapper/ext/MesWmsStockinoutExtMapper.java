package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.domain.MesWmsStockinoutlist;
import com.bpm.mes.stock.server.dto.InoutPurchaseDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutQueryVo;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutVo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MesWmsStockinoutExtMapper {

    //查询所有
    List<MesWmsStockinoutQueryVo> queryAll(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto);

    //查询出入库编码
    String queryInOutCode(@Param("inOutPropert") String inOutPropert);

    //查询采购订单信息
    List<MesWmsStockinoutVo> queryPurchase(MesWmsStockinoutVo mesWmsStockinoutVo);

    //查询采购订单明细数据
    List<MesWmsStockinoutListVo> queryPurchaseList(InoutPurchaseDto dto);

    //修改入库明细
    int  editINOutList(MesWmsStockinoutlist mesWmsStockinoutlist);

    //查询入库批次
    String queryInBatchNo(String inOutPropert);

    //质检标准
    Integer queryQualityTasks(@Param("materialCode") String materialCode, @Param("occasionsCode") String occasionsCode);

    int deletePoList(@Param("stockId") Integer stockId);

    int deleteInOutList(@Param("stcokInOutId") Integer stcokInOutId);

    //查询生产订单信息
    List<MesWmsStockinoutVo> queryProduction(MesWmsStockinoutVo mesWmsStockinoutVo);

    //查询生产订单明细信息
    List<MesWmsStockinoutListVo> queryProductionList(InoutPurchaseDto inoutPurchaseDto);
}
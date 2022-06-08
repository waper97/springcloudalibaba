package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.vo.StockDepartMentUserVo;
import com.bpm.mes.stock.server.vo.StockManagerUserVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MesWmsStockExtMapper {

    //查询库管员信息
    List<StockManagerUserVo> queryManager();

    //查询部门信息
    List<StockDepartMentUserVo> queryDepartment();

    //条件查询
    List<MesWmsStock> queryAll(MesWmsStock mesWmsStock);
}

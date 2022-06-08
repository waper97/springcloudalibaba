package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.tree.MesWmsStockplaceTree;
import com.bpm.mes.stock.server.vo.MesWmsStockplacebindMaterialVo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MesWmsStockplaceExtMapper {

    //树查询，仓库库位信息
    List<MesWmsStockplaceTree> queryTree(@Param("stockType") String stockType);

    //库位绑定物料表获取物料信息
    List<MesWmsStockplacebindMaterialVo> selectMaterial(@Param("materialId") Integer materialId);

    //条件查询
    List<MesWmsStockplace> queryAll(MesWmsStockplace mesWmsStockplace);

}

package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockmoveplace;
import com.bpm.mes.stock.server.dto.MesWmsStockcurrentDto;
import com.bpm.mes.stock.server.dto.MesWmsStockmoveplaceQueryDto;

import java.util.List;

/**
 * 仓库库位转移表(MesWmsStockmoveplace)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 17:38:48
 */
public interface MesWmsStockmoveplaceService {
       
     //条件查询  
    List<MesWmsStockmoveplace> queryAll(MesWmsStockmoveplaceQueryDto mesWmsStockmoveplaceQueryDto);
       
    //分页查询
    ResultVO<PageInfoVO<List<MesWmsStockmoveplace>>> queryByPage(MesWmsStockmoveplaceQueryDto mesWmsStockmoveplaceQueryDto);
 
    //通过ID查询单条数据
    ResultVO queryById(Integer id);
    
    //新增数据
    ResultVO insert(MesWmsStockmoveplace mesWmsStockmoveplace);

    //修改数据
    ResultVO update(MesWmsStockmoveplace mesWmsStockmoveplace);

    //通过主键删除数据
    ResultVO deleteById(Integer id);
    
    //通过主键逻辑删除数据
    ResultVO updateById(Integer id);

    //查询仓库-库区库位-物料
    ResultVO selectMaterial(Integer stockId,Integer stockPlaceId);

    //仓库库位转移新增和编辑接口
    ResultVO addAndEdit(MesWmsStockcurrentDto mesWmsStockcurrentDto);

    //审核
    ResultVO isCheck(Integer id);
}

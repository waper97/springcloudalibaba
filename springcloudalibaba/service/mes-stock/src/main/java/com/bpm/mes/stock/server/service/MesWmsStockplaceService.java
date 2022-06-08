package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.dto.MesWmsStockplaceDto;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * 仓库库位表(MesWmsStockplace)表服务接口
 *
 * @author makejava
 * @since 2022-04-14 16:51:23
 */
public interface MesWmsStockplaceService {
       
     //条件查询  
    List<MesWmsStockplace> queryAll(MesWmsStockplace mesWmsStockplace);
       
    //分页查询
    PageInfo<MesWmsStockplace> queryByPage(MesWmsStockplace mesWmsStockplace);
 
    //通过ID查询单条数据
    ResultVO queryById(Integer id);
    
    //新增数据
    ResultVO insert(MesWmsStockplace mesWmsStockplace);

    //修改数据
    ResultVO update(MesWmsStockplace mesWmsStockplace);

    //通过主键删除数据
    ResultVO deleteById(Integer id);

    //逻辑删除数据(假删)
    ResultVO updateById(Integer id);

    //树状查询
    ResultVO queryTree(String stockType);

    //仓库库位新增和编辑接口
    ResultVO addAndEdit(MesWmsStockplaceDto stockplaceDto);
}

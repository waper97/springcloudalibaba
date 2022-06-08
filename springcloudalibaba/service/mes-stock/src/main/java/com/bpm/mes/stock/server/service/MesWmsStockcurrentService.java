package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrent;
import com.bpm.mes.stock.server.dto.MesWmsStockcurrentDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcurrentQueryDto;
import com.bpm.mes.stock.common.vo.ResultVO;

import java.util.List;

/**
 * 仓库即时库存明细表(MesWmsStockcurrent)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 14:55:55
 */
public interface MesWmsStockcurrentService {
       
     //条件查询  
    List<MesWmsStockcurrent> queryAll(MesWmsStockcurrentQueryDto mesWmsStockcurrentQueryDto);
       
    //分页查询
    ResultVO<PageInfoVO<List<MesWmsStockcurrent>>> queryByPage(MesWmsStockcurrentQueryDto mesWmsStockcurrentQueryDto);
 
    //通过ID查询单条数据
    ResultVO queryById(Integer id);
    
    //新增数据
    ResultVO insert(MesWmsStockcurrent mesWmsStockcurrent);

    //修改数据
    ResultVO update(MesWmsStockcurrent mesWmsStockcurrent);

    //通过主键删除数据
    ResultVO deleteById(Integer id);
    
    //通过主键逻辑删除数据
    ResultVO updateById(Integer id);

    //查询仓库信息-用于查询条件
    ResultVO selectStock();

    //库位转移
    ResultVO stockMovePlace(MesWmsStockcurrentDto mesWmsStockcurrentDto);

    //查询仓库库位信息-用于库位转移查询条件
    ResultVO selectStockPlace(Integer stockId);
}

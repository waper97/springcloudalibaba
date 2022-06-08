package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.server.domain.MesWmsStockplacebind;
import com.bpm.mes.stock.server.dto.MesWmsStockplacebindDto;
import com.bpm.mes.stock.common.vo.ResultVO;

import java.util.List;
import com.github.pagehelper.PageInfo;
/**
 * 库位绑定物料表(MesWmsStockplacebind)表服务接口
 *
 * @author makejava
 * @since 2022-04-15 15:30:45
 */
public interface MesWmsStockplacebindService {
       
     //条件查询  
    List<MesWmsStockplacebind> queryAll(MesWmsStockplacebind mesWmsStockplacebind);
       
    //分页查询
    PageInfo<MesWmsStockplacebind> queryByPage(MesWmsStockplacebind mesWmsStockplacebind);
 
    //通过ID查询单条数据
    ResultVO queryById(Integer id);
    
    //新增数据
    ResultVO insert(MesWmsStockplacebind mesWmsStockplacebind);

    //修改数据
    ResultVO update(MesWmsStockplacebind mesWmsStockplacebind);

    //通过主键删除数据
    ResultVO deleteById(Integer id);
    
    //通过主键逻辑删除数据
    ResultVO updateById(Integer id);

    //库位绑定物料表新增和编辑接口
    ResultVO addAndEdit(MesWmsStockplacebindDto stockplacebindDto);

    //库位绑定物料表获取物料信息
    ResultVO selectMaterial();
}

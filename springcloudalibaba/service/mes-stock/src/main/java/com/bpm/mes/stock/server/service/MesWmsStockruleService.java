package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.server.domain.MesWmsStockrule;
import com.bpm.mes.stock.server.dto.MesWmsStockruleDto;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.common.dto.PageDTO;
import java.util.List;
import com.github.pagehelper.PageInfo;
/**
 * 仓库出入库规则(MesWmsStockrule)表服务接口
 *
 * @author makejava
 * @since 2022-04-15 17:46:48
 */
public interface MesWmsStockruleService {
       
     //条件查询  
    List<MesWmsStockrule> queryAll(MesWmsStockrule mesWmsStockrule);
       
    //分页查询
    PageInfo<MesWmsStockrule> queryByPage(MesWmsStockrule mesWmsStockrule);
 
    //通过ID查询单条数据
    ResultVO queryById(Integer id);
    
    //新增数据
    ResultVO insert(MesWmsStockrule mesWmsStockrule);

    //修改数据
    ResultVO update(MesWmsStockrule mesWmsStockrule);

    //通过主键删除数据
    ResultVO deleteById(Integer id);
    
    //通过主键逻辑删除数据
    ResultVO updateById(Integer id);

    //仓库出入库规则新增和编辑接口
    ResultVO addAndEdit(MesWmsStockruleDto stockruleDto);

}

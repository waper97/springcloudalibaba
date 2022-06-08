package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.domain.MesWmsStockrule;
import com.bpm.mes.stock.server.dto.MesWmsStockDto;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * 仓库信息表(MesWmsStock)表服务接口
 *
 * @author makejava
 * @since 2022-04-14 09:59:16
 */
public interface MesWmsStockService {
       
     //条件查询  
    List<MesWmsStock> queryAll(MesWmsStock mesWmsStock);
       
    //分页查询
    PageInfo<MesWmsStock> queryByPage(MesWmsStock mesWmsStock);
 
    //通过ID查询单条数据
    MesWmsStock queryById(Integer id);

    //新增数据
    ResultVO insert(MesWmsStock mesWmsStock);

    //修改数据
    ResultVO update(MesWmsStock mesWmsStock);

    //通过主键删除数据
    ResultVO deleteById(Integer id);

    //通过主键逻辑删除数据
    ResultVO updateById(Integer id);

    //查询库管员信息
    ResultVO queryManager();

    //查询部门信息
    ResultVO queryDepartment();

    //仓库信息新增和编辑接口
    ResultVO addAndEdit(MesWmsStockDto mesWmsStockDto);

    //仓库信息盘点
    ResultVO inventoryEdit(Integer id);

}

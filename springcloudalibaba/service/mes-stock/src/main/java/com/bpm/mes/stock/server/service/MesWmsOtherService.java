package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.vo.MaterialVo;
import com.bpm.mes.stock.server.vo.StockOtherVo;
import com.bpm.mes.stock.server.vo.StockVo;

/**
 * 仓库出入库类型表(MesWmsInouttype)表服务接口
 *
 * @author makejava
 * @since 2022-04-14 10:35:29
 */
public interface MesWmsOtherService {

    //查询部门信息
    ResultVO queryDepartment(StockOtherVo stockOtherVo);

    //数据字典
    ResultVO querydataDict(String dictType);

    //查询用户信息
    ResultVO queryUser(StockOtherVo stockOtherVo);

    //查询供应商信息
    ResultVO querySuppliar(StockOtherVo stockOtherVo);

    //查询物料信息
    ResultVO queryMaterial(MaterialVo vo);

    //查询当前登录人公司信息
    ResultVO queryCompany(Integer currentloginId);

    //查询客户信息
    ResultVO queryCustomer(StockOtherVo stockOtherVo);

    //查询仓库信息
    ResultVO queryStock(StockVo vo);

    //查询仓库树-三级
    ResultVO queryStockTree(String dictLabel);
}

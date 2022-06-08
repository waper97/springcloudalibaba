package com.bpm.mes.stock.server.mapper.ext;

import com.bpm.mes.stock.server.vo.DataDictionaryVo;
import com.bpm.mes.stock.server.vo.DictDataVo;
import com.bpm.mes.stock.server.vo.MaterialVo;
import com.bpm.mes.stock.server.vo.StockOtherVo;
import com.bpm.mes.stock.server.vo.StockPlaceVo;
import com.bpm.mes.stock.server.vo.StockVo;
import com.bpm.mes.stock.server.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MesWmsOtherMapper {

    //查询部门信息
    List<StockOtherVo> queryDepartment(StockOtherVo stockOtherVo);

    //数据字典
    List<DictDataVo> querydataDict(String dictType);

    //查询用户信息
    List<StockOtherVo> queryUser(StockOtherVo stockOtherVo);

    ////查询当前登录人基本信息：如公司等
    UserVo queryCompany(@Param("currentloginId") Integer currentloginId);

    //查询供应商信息
    List<StockOtherVo> querySuppliar(StockOtherVo stockOtherVo);

    //查询物料信息
    List<MaterialVo> queryMaterial(MaterialVo vo);

    //查询客户信息
    List<StockOtherVo> queryCustomer(StockOtherVo stockOtherVo);

    //仓库信息列表
    List<StockVo> queryStock(StockVo vo);

    ////库区库位
    List<StockPlaceVo> queryStockPlace(Integer stockId);

    //查询仓库树-三级
    List<DataDictionaryVo> queryDataDictionary(String dictLabel);
}

package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.service.MesWmsOtherService;
import com.bpm.mes.stock.server.vo.DataDictionaryVo;
import com.bpm.mes.stock.server.vo.MaterialVo;
import com.bpm.mes.stock.server.vo.StockOtherVo;
import com.bpm.mes.stock.server.vo.StockPlaceVo;
import com.bpm.mes.stock.server.vo.StockVo;
import com.bpm.mes.stock.server.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 仓库出入库类型表(MesWmsInouttype)表服务实现类
 *
 * @author makejava
 * @since 2022-04-14 10:35:29
 */
@Service
public class MesWmsOtherServiceImpl implements MesWmsOtherService {
    @Resource
    private MesWmsOtherMapper otherMapper;

    /**
     * 查询部门信息
     * @return
     */
    @Override
    public ResultVO queryDepartment(StockOtherVo stockOtherVo) {
        List<StockOtherVo> stockDepartMentUserVos = otherMapper.queryDepartment(stockOtherVo);
        return ResultVO.create().success(stockDepartMentUserVos);
    }

    /**
     * 数据字典
     * @param dictType
     * @return
     */
    @Override
    public ResultVO querydataDict(String dictType) {
        return ResultVO.create().success(otherMapper.querydataDict(dictType));
    }

    /**
     * 查询用户信息
     * @param stockOtherVo
     * @return
     */
    @Override
    public ResultVO queryUser(StockOtherVo stockOtherVo) {
        List<StockOtherVo> stockOtherVos = otherMapper.queryUser(stockOtherVo);
        return ResultVO.create().success(stockOtherVos);
    }

    /**
     * 查询供应商信息
     * @param stockOtherVo
     * @return
     */
    @Override
    public ResultVO querySuppliar(StockOtherVo stockOtherVo) {
        List<StockOtherVo> stockOtherVos = otherMapper.querySuppliar(stockOtherVo);
        return ResultVO.create().success(stockOtherVos);
    }

    /**
     * 查询物料信息
     * @param vo
     * @return
     */
    @Override
    public ResultVO queryMaterial(MaterialVo vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<MaterialVo> materialVos = otherMapper.queryMaterial(vo);
        PageInfo<MaterialVo> pageInfo = new PageInfo<>(materialVos);
        PageInfoVO pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * 查询当前登录人公司信息
     * @param currentloginId
     * @return
     */
    @Override
    public ResultVO queryCompany(Integer currentloginId) {
        UserVo userVo = otherMapper.queryCompany(currentloginId);
        return ResultVO.create().success(userVo);
    }

    /**
     * 查询客户信息
     * @param stockOtherVo
     * @return
     */
    @Override
    public ResultVO queryCustomer(StockOtherVo stockOtherVo) {
        List<StockOtherVo> stockOtherVos = otherMapper.queryCustomer(stockOtherVo);
        return ResultVO.create().success(stockOtherVos);
    }

    /**
     * 查询仓库信息
     * @param vo
     * @return
     */
    @Override
    public ResultVO queryStock(StockVo vo) {
        //仓库信息列表
        List<StockVo> stocks = otherMapper.queryStock(vo);
        stocks.forEach(stock -> {
            //库区库位
            List<StockPlaceVo> stockPlace = otherMapper.queryStockPlace(stock.getStockId());
            stock.setPlaceVos(stockPlace);
        });
        return ResultVO.create().success(stocks);
    }

    /**
     *查询仓库树-三级
     * @param dictLabel
     * @return
     */
    @Override
    public ResultVO queryStockTree(String dictLabel) {
        //查询数据字典
        List<DataDictionaryVo> dataDictionaryVos = otherMapper.queryDataDictionary(dictLabel);
        Integer UniqueValue = 0;
        for (int a =0;a < dataDictionaryVos.size();a++){
            UniqueValue++;
            dataDictionaryVos.get(a).setUniqueValue(UniqueValue);

            //仓库信息列表
            StockVo stockVo = new StockVo();
            stockVo.setStockType(dataDictionaryVos.get(a).getDictLabel());
            List<StockVo> stocks = otherMapper.queryStock(stockVo);
            for (int b = 0;b < stocks.size();b++){
                UniqueValue++;
                stocks.get(b).setUniqueValue(UniqueValue);

                //库区库位
                List<StockPlaceVo> stockPlace = otherMapper.queryStockPlace(stocks.get(b).getStockId());
                for (int c = 0;c < stockPlace.size();c++){
                    UniqueValue++;
                    stockPlace.get(c).setUniqueValue(UniqueValue);
                }
                stocks.get(b).setPlaceVos(stockPlace);
            }
            dataDictionaryVos.get(a).setStockVos(stocks);
        }
        return ResultUtil.success(dataDictionaryVos);
    }
}

package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrent;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrentsum;
import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.domain.MesWmsStockpo;
import com.bpm.mes.stock.server.domain.MesWmsStockpobatch;
import com.bpm.mes.stock.server.domain.MesWmsStockpolist;
import com.bpm.mes.stock.server.dto.MesWmsStockPoListDto;
import com.bpm.mes.stock.server.dto.MesWmsStockpoListbatchDto;
import com.bpm.mes.stock.server.dto.MesWmsStockpoQueryDto;
import com.bpm.mes.stock.server.mapper.base.MesWmsInouttypeMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentsumMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutbatchMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutlistMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplaceMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockpoMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockpobatchMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockpolistMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockinoutExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockplaceExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockpoExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockOutService;
import com.bpm.mes.stock.server.service.MesWmsStockinoutService;
import com.bpm.mes.stock.server.service.MesWmsStockpoService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.util.NumAddUtil;
import com.bpm.mes.stock.server.vo.MesWmsStockPoListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockPoPlaceListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockplacebindMaterialVo;
import com.bpm.mes.stock.server.vo.MesWmsStockpoQueryVo;
import com.bpm.mes.stock.server.vo.StockOtherVo;
import com.bpm.mes.stock.server.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ?????????????????????(MesWmsStockpo)??????????????????
 *
 * @author makejava
 * @since 2022-04-20 18:10:43
 */
@Service
public class MesWmsStockpoServiceImpl implements MesWmsStockpoService {
    @Resource
    private MesWmsStockpoMapper mesWmsStockpoMapper;
    @Resource
    private MesWmsStockpolistMapper PolistMapper;
    @Resource
    private MesWmsStockpobatchMapper pobatchMapper;
    @Resource
    private MesWmsStockpoExtMapper poExtMapper;
    @Resource
    private MesWmsStockplaceExtMapper placeExtMapper;
    @Resource
    private MesWmsStockMapper stockMapper;
    @Resource
    private MesWmsOtherMapper otherMapper;
    @Resource
    private MesWmsStockcurrentMapper currentMapper;
    @Resource
    private MesWmsStockplaceMapper placeMapper;
    @Resource
    private MesWmsStockcurrentsumMapper sumMapper;
    @Resource
    private MesWmsStockinoutExtMapper extMapper;
    @Resource
    private MesWmsStockinoutMapper inoutMapper;
    @Resource
    private MesWmsStockinoutlistMapper inoutlistMapper;
    @Resource
    private MesWmsInouttypeMapper inouttypeMapper;
    @Resource
    private MesWmsStockinoutService inoutService;
    @Resource
    private MesWmsStockOutService outService;
    @Resource
    private MesWmsStockinoutbatchMapper batchMapper;

    /**
     * ????????????
     *
     * @param mesWmsStockpoQueryDto ????????????
     * @return ????????????
     */
    @Override
    public ResultVO queryAll(MesWmsStockpoQueryDto mesWmsStockpoQueryDto) {
        List<MesWmsStockpoQueryVo> vos = poExtMapper.queryAll(mesWmsStockpoQueryDto);
        vos.forEach(vo -> {
            MesWmsStockpolist mesWmsStockpolist = new MesWmsStockpolist();
            mesWmsStockpolist.setStockPoId(vo.getId());
            List<MesWmsStockpolist> mesWmsStockpolists = PolistMapper.queryAll(mesWmsStockpolist);
            vo.setLists(mesWmsStockpolists);
        });
        return ResultVO.create().success(vos);
    }
//    @Override
//    public List<MesWmsStockpo> queryAll(MesWmsStockpoQueryDto mesWmsStockpoQueryDto) {
//        MesWmsStockpo mesWmsStockpo = new MesWmsStockpo();
//        BeanUtils.copyProperties(mesWmsStockpoQueryDto,mesWmsStockpo);
//        return this.mesWmsStockpoMapper.queryAll(mesWmsStockpo);
//    }

    /**
     * ??????ID??????????????????
     *
     * @param id ??????
     * @return ????????????
     */
    @Override
    public ResultVO queryById(Integer id) {
        return ResultVO.create().success(this.mesWmsStockpoMapper.queryById(id));
    }

    /**
     * ????????????
     *
     * @param mesWmsStockpoQueryDto ????????????
     * @return ????????????
     */
    @Override
    public ResultVO<PageInfoVO<List<MesWmsStockpoQueryVo>>> queryByPage(MesWmsStockpoQueryDto mesWmsStockpoQueryDto) {
//        MesWmsStockpo mesWmsStockpo = new MesWmsStockpo();
//        BeanUtils.copyProperties(mesWmsStockpoQueryDto,mesWmsStockpo);
        PageHelper.startPage(mesWmsStockpoQueryDto.getPageNum(), mesWmsStockpoQueryDto.getPageSize());
//        List<MesWmsStockpo> mesWmsStockpoList = this.mesWmsStockpoMapper.queryAll(mesWmsStockpo);
        List<MesWmsStockpoQueryVo> vos = poExtMapper.queryAll(mesWmsStockpoQueryDto);
        vos.forEach(vo -> {
            MesWmsStockpolist mesWmsStockpolist = new MesWmsStockpolist();
            mesWmsStockpolist.setStockPoId(vo.getId());
            List<MesWmsStockpolist> mesWmsStockpolists = PolistMapper.queryAll(mesWmsStockpolist);
            vo.setLists(mesWmsStockpolists);
        });
        PageInfo<MesWmsStockpoQueryVo> pageInfo = new PageInfo<>(vos);
        PageInfoVO pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * ????????????
     *
     * @param mesWmsStockpo ????????????
     * @return ????????????
     */
    @Override
    public ResultVO insert(MesWmsStockpo mesWmsStockpo) {
        if (this.mesWmsStockpoMapper.insert(mesWmsStockpo) > 0) {
            return ResultVO.create().success("??????????????????!");
        }
        return ResultVO.create().error("??????????????????!");
    }

    /**
     * ????????????
     *
     * @param mesWmsStockpo ????????????
     * @return ????????????
     */
    @Override
    public ResultVO update(MesWmsStockpo mesWmsStockpo) {
        if (this.mesWmsStockpoMapper.update(mesWmsStockpo) > 0) {
            return ResultVO.create().success("??????????????????!");
        }
        return ResultVO.create().error("??????????????????!");
    }

    /**
     * ????????????????????????
     *
     * @param id ??????
     * @return ????????????
     */
    @Override
    public ResultVO deleteById(Integer id) {
        if (this.mesWmsStockpoMapper.deleteById(id) > 0) {
            return ResultVO.create().success("??????????????????!");
        }
        return ResultVO.create().error("??????????????????!");
    }

    /**
     * ??????????????????????????????
     *
     * @param id ??????
     * @return ????????????
     */
    @Override
    public ResultVO updateById(Integer id) {
        MesWmsStockpo mesWmsStockpo = mesWmsStockpoMapper.queryById(id);
        if (!(CommonConstantUtils.STOCKPO_STATE_ONE.equals(mesWmsStockpo.getState()))){
            return ResultUtil.error("??????????????????????????????????????????");
        }
        MesWmsStockpolist stockpolist = new MesWmsStockpolist();
        stockpolist.setStockPoId(id);
        List<MesWmsStockpolist> mesWmsStockpolists = PolistMapper.queryAll(stockpolist);
        mesWmsStockpolists.forEach(polist -> {
            PolistMapper.deleteById(polist.getId());
        });
        if (this.mesWmsStockpoMapper.deleteById(id) > 0) {
            return ResultVO.create().success("??????????????????!");
        }
        return ResultVO.create().error("??????????????????!");
//        if (this.mesWmsStockpoMapper.updateById(id) > 0) {
//            return ResultVO.create().success("??????????????????!");
//        }
//        return ResultVO.create().error("??????????????????!");
    }

    /**
     * ????????????-?????????
     *
     * @param id
     * @return
     */
    @Override
    public ResultVO updateListById(Integer id) {
        if (this.PolistMapper.updateById(id) > 0) {
            return ResultVO.create().success("??????????????????!");
        }
        return ResultVO.create().error("??????????????????!");
    }

    /**
     * ????????????????????????
     * @param stockinoutbatch
     * @return
     */
    @Override
    public List<MesWmsStockpobatch> queryBatch(MesWmsStockpobatch stockinoutbatch) {
        MesWmsStockpobatch batch = new MesWmsStockpobatch();
        batch.setIsValid(CommonConstantUtils.NOT_DELETE);
        batch.setStockPoId(stockinoutbatch.getStockPoId());
        List<MesWmsStockpobatch> stockinoutbatchs = pobatchMapper.queryAll(batch);
        return stockinoutbatchs;
    }

    /**
     * ????????????
     *
     * @return
     */
    @Override
    public ResultVO outStock() {
        //??????????????????????????????
//        List<MesWmsStockPoListVo> stockListVos = poExtMapper.outStock();
//        stockListVos.forEach(stockListVo ->{
//            //??????????????????????????????
//            List<MesWmsStockPoPlaceListVo> stockPoPlaceListVos = poExtMapper.outStockPlace(stockListVo.getStockId());
//            stockListVo.setStockPoPlaceListVos(stockPoPlaceListVos);
//        });
        //????????????????????????
        List<MesWmsStockPoListVo> stockListVos = poExtMapper.inStock();
        stockListVos.forEach(stockListVo -> {
            //????????????
            List<MesWmsStockPoPlaceListVo> stockPoPlaceListVos = poExtMapper.inStockPlace(stockListVo.getStockId());
            stockListVo.setStockPoPlaceListVos(stockPoPlaceListVos);
        });
        return ResultVO.create().success(stockListVos);
    }

    /**
     * ????????????
     *
     * @return
     */
    @Override
    public ResultVO inStock() {
        //????????????????????????
        List<MesWmsStockPoListVo> stockListVos = poExtMapper.inStock();
        stockListVos.forEach(stockListVo -> {
            //????????????
            List<MesWmsStockPoPlaceListVo> stockPoPlaceListVos = poExtMapper.inStockPlace(stockListVo.getStockId());
            stockListVo.setStockPoPlaceListVos(stockPoPlaceListVos);
        });
        return ResultVO.create().success(stockListVos);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO confirm(MesWmsStockpoListbatchDto dto) {
        //????????????????????????
        MesWmsStockpolist polist = PolistMapper.queryById(dto.getStockPoListId());
        if (polist != null) {
            //?????????????????????
            UserVo userVo = otherMapper.queryCompany(dto.getCurrentloginId());
            //??????????????????
            MesWmsStockplace inPlace = placeMapper.queryById(polist.getInStockPlaceId());
            MesWmsStock inStock = stockMapper.queryById(inPlace.getStockId());
            if (!CommonConstantUtils.CTOCK_STATE_ISUSE.equals(inStock.getState())){
                return ResultUtil.error("??????????????????????????????");
            }
            //??????????????????
            MesWmsStockplace outPlace = placeMapper.queryById(polist.getOutStockPlaceId());
            MesWmsStock outStock = stockMapper.queryById(outPlace.getStockId());
            if (!CommonConstantUtils.CTOCK_STATE_ISUSE.equals(outStock.getState())){
                return ResultUtil.error("??????????????????????????????");
            }

            //??????????????????????????????
            MesWmsStockcurrentsum stockcurrentsum = new MesWmsStockcurrentsum();
            stockcurrentsum.setStockId(polist.getOutStockId());
            stockcurrentsum.setMaterialId(polist.getMaterialId());
            stockcurrentsum.setIsValid(CommonConstantUtils.NOT_DELETE);
            List<MesWmsStockcurrentsum> sums = sumMapper.queryAll(stockcurrentsum);
            if (sums.size() < 1) {
                return ResultUtil.error("??????????????????????????????????????????????????????");
            }
            MesWmsStockcurrentsum sum = sums.get(0);

            //??????????????????????????????
            MesWmsStockcurrent stockcurrent1 = new MesWmsStockcurrent();
            stockcurrent1.setStockCurrentSumId(sum.getId());
            stockcurrent1.setStockId(polist.getOutStockId());
            stockcurrent1.setStockPlaceId(polist.getOutStockPlaceId());
            stockcurrent1.setMaterialId(polist.getMaterialId());
            stockcurrent1.setIsValid(CommonConstantUtils.NOT_DELETE);
            List<MesWmsStockcurrent> currents = currentMapper.queryAll(stockcurrent1);
            if (currents.size() < 1) {
                return ResultVO.create().error("?????????????????????????????????????????????");
            }
            //            currents.stream().mapToDouble(MesWmsStockcurrent -> MesWmsStockcurrent.getQty().doubleValue()).sum();
            //?????????????????????
            BigDecimal reduce = currents.stream().map(MesWmsStockcurrent::getQty).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal pallent = polist.getFPallet().subtract(polist.getFFinished()==null?new BigDecimal(0):polist.getFFinished());
            BigDecimal qty = reduce.subtract(pallent);
            //?????????????????????????????????0,
            if (qty.compareTo(new BigDecimal("0")) > -1){
                BigDecimal finished = pallent.add(polist.getFFinished()==null?new BigDecimal(0):polist.getFFinished());
                polist.setFFinished(finished);
                polist.setQty(finished);
                polist.setState(CommonConstantUtils.STOCKPO_STATE_THREE);

                //????????????????????????????????????
                if (qty.compareTo(new BigDecimal("0")) == 0){
                    sum.setIsValid(CommonConstantUtils.DELETE);
                }
                sum.setQty(sum.getQty().subtract(finished));
                sum.setQtyUseable(sum.getQty().subtract(finished));
            }else {
                polist.setFFinished(reduce);
                polist.setQty(reduce);
                polist.setState(CommonConstantUtils.STOCKPO_STATE_TWO);

                //????????????????????????????????????
                qty = sum.getQty().subtract(pallent);
                if (qty.compareTo(new BigDecimal("0")) < 1){
                    sum.setIsValid(CommonConstantUtils.DELETE);
                    sum.setQty(new BigDecimal(0));
                    sum.setQtyUseable(new BigDecimal(0));
                }else {
                    sum.setQty(qty);
                    sum.setQtyUseable(qty);
                }

            }
            polist.setSuppliarId(currents.get(0).getSuppliarId());
            polist.setSuppliarCode(currents.get(0).getSuppliarCode());
            polist.setSuppliarName(currents.get(0).getSuppliarName());
            polist.setUpdateId(dto.getCurrentloginId());
            polist.setUpdateName(dto.getCurrentloginName());
            polist.setUpdateTime(LocalDateTime.now());
            PolistMapper.update(polist);

            sum.setUpdateId(dto.getCurrentloginId());
            sum.setUpdateName(dto.getCurrentloginName());
            sum.setUpdateTime(LocalDateTime.now());
            sumMapper.update(sum);

            //?????????????????????
            MesWmsStockpo po = mesWmsStockpoMapper.queryById(polist.getStockPoId());
            //??????????????????????????????????????????
            List<MesWmsStockpolist> mesWmsStockpolists = poExtMapper.queryStockPo(polist.getStockPoId());
            if (mesWmsStockpolists.size() > 0) {
                po.setState(CommonConstantUtils.STOCKPO_STATE_TWO);
            } else {
                po.setState(CommonConstantUtils.STOCKPO_STATE_THREE);
            }
            mesWmsStockpoMapper.update(po);

            BigDecimal qtyUseable = polist.getQty();
            for (MesWmsStockcurrent current:currents) {
                //??????????????????????????????????????????????????????0
                if ((qtyUseable.compareTo(current.getQty()) == 1) && (qtyUseable.compareTo(new BigDecimal(0)) == 1)){
                    BigDecimal qtyNub = current.getQty();
                    //???????????????????????????-??????
                    current.setIsValid(CommonConstantUtils.DELETE);
                    current.setStockQty(new BigDecimal(0));
                    current.setQtyUseable(new BigDecimal(0));
                    currentMapper.update(current);


                    //??????
                    getcurrent(dto, polist, userVo, inPlace, po, current,qtyNub);
                    qtyUseable = qtyUseable.subtract(current.getQty());
                }
                //????????????????????????????????????????????????????????????0
                if ((qtyUseable.compareTo(current.getQty()) < 1) && (qtyUseable.compareTo(new BigDecimal(0)) == 1)){
                    //???????????????????????????-??????
                    if (qtyUseable.compareTo(current.getQty()) == 0){
                        current.setIsValid(CommonConstantUtils.DELETE);
                    }
                    qty = current.getQty().subtract(qtyUseable);
                    current.setStockQty(qty);
                    current.setQtyUseable(qty);
                    current.setQty(qty);
                    currentMapper.update(current);

                    //??????
                    BigDecimal qtyNub = qtyUseable;
                    getcurrent(dto, polist, userVo, inPlace, po, current,qtyNub);
                    qtyUseable = new BigDecimal(0);
                }
            }

            return ResultVO.create().success("???????????????");
        }
        return ResultVO.create().error("????????????????????????");
    }

    private void getcurrent(MesWmsStockpoListbatchDto dto, MesWmsStockpolist polist, UserVo userVo, MesWmsStockplace inPlace, MesWmsStockpo po, MesWmsStockcurrent current,BigDecimal qtyNub) {
        BigDecimal qty;
        //????????????????????????-??????
        MesWmsStockpobatch pobatch = new MesWmsStockpobatch();
        BeanUtils.copyProperties(current, pobatch);
        BeanUtils.copyProperties(polist, pobatch);
        BeanUtils.copyProperties(userVo, pobatch);
        pobatch.setQty(qtyNub);
        pobatch.setInBatchNo(current.getInBatchNo());
        pobatch.setStockPoListId(polist.getId());
        pobatch.setCreateId(dto.getCurrentloginId());
        pobatch.setCreateName(dto.getCurrentloginName());
        pobatch.setIsValid(CommonConstantUtils.NOT_DELETE);
        pobatch.setCreateTime(LocalDateTime.now());
        pobatch.setCarrierId(po.getInCompanyId());
        pobatch.setCarrierName(po.getInCompanyName());
        pobatch.setUpdateId(null);
        pobatch.setUpdateName(null);
        pobatch.setUpdateTime(null);
        pobatch.setInOutTypePropert(CommonConstantUtils.PROPERT_IN);
        pobatchMapper.insert(pobatch);

        //????????????????????????-??????
        pobatch.setInOutTypePropert(CommonConstantUtils.PROPERT_OUT);
        pobatchMapper.insert(pobatch);

        //????????????????????????-??????
        MesWmsStockcurrentsum sum2 = new MesWmsStockcurrentsum();
        sum2.setStockId(inPlace.getStockId());
        sum2.setMaterialCode(current.getMaterialCode());
        List<MesWmsStockcurrentsum> mesWmsStockcurrentsums = sumMapper.queryAll(sum2);
        MesWmsStockcurrentsum sum1 = new MesWmsStockcurrentsum();
        if (mesWmsStockcurrentsums.size()<1){
            sum1.setStockCode(inPlace.getStockCode());
            sum1.setStockId(inPlace.getStockId());
            sum1.setStockName(inPlace.getStockName());
            sum1.setMaterialId(current.getMaterialId());
            sum1.setMaterialCode(current.getMaterialCode());
            sum1.setMaterialShortName(current.getMaterialShortName());
            sum1.setMaterialSpec(current.getMaterialSpec());
            sum1.setMaterialTrId(current.getMaterialTrId());
            sum1.setUnitsId(current.getUnitsId());
            sum1.setUnitsName(current.getUnitsName());
            sum1.setQty(qtyNub);
            sum1.setQtyUseable(qtyNub);
            sum1.setQtyAllot(qtyNub);
            sum1.setQtyFreeze(qtyNub);
            sum1.setStockQty(qtyNub);
            sum1.setCreateId(dto.getCurrentloginId());
            sum1.setCreateName(dto.getCurrentloginName());
            sum1.setCreateTime(LocalDateTime.now());
            sum1.setIsValid(CommonConstantUtils.NOT_DELETE);
            sumMapper.insert(sum1);
        }else{
            sum1 = mesWmsStockcurrentsums.get(0);
            qty = sum1.getQty().add(qtyNub);
            sum1.setQty(qty);
            sum1.setQtyUseable(qty);
            sum1.setUpdateId(dto.getCurrentloginId());
            sum1.setUpdateName(dto.getCurrentloginName());
            sum1.setUpdateTime(LocalDateTime.now());
            sumMapper.update(sum1);
        }

        //????????????????????????-??????
        MesWmsStockcurrent current1 = new MesWmsStockcurrent();
        current1.setInBatchNo(current.getInBatchNo());
        current1.setStockId(inPlace.getStockId());
        current1.setStockPlaceId(inPlace.getId());
        current1.setMaterialId(current.getMaterialId());
        List<MesWmsStockcurrent> mesWmsStockcurrents = currentMapper.queryAll(current1);
        if (mesWmsStockcurrents.size()>0){
            current1 = mesWmsStockcurrents.get(0);
            qty = current1.getQty().add(qtyNub);
            current1.setQty(qty);
            sum1.setQtyUseable(qty);
            current1.setUpdateId(dto.getCurrentloginId());
            current1.setUpdateName(dto.getCurrentloginName());
            current1.setUpdateTime(LocalDateTime.now());
            currentMapper.update(current1);
        }else {
            BeanUtils.copyProperties(current,current1);
            current1.setId(null);
            current1.setStockCode(inPlace.getStockCode());
            current1.setStockId(inPlace.getStockId());
            MesWmsStock mesWmsStock = stockMapper.queryById(inPlace.getStockId());
            current1.setStockType(mesWmsStock.getStockType());
            current1.setStockName(inPlace.getStockName());
            current1.setStockCurrentSumId(sum1.getId());
            current1.setStockPlaceId(inPlace.getId());
            current1.setStockPlaceCode(inPlace.getStockPlaceCode());
            current1.setStockPlaceName(inPlace.getStockPlaceName());
            current1.setCreateId(dto.getCurrentloginId());
            current1.setCreateName(dto.getCurrentloginName());
            current1.setCreateTime(LocalDateTime.now());
            current1.setQty(qtyNub);
            current1.setQtyUseable(qtyNub);
            current1.setQtyAllot(qtyNub);
            current1.setQtyFreeze(qtyNub);
            current1.setStockQty(qtyNub);
            current1.setIsValid(CommonConstantUtils.NOT_DELETE);
            current1.setUpdateId(null);
            current1.setUpdateName(null);
            current1.setUpdateTime(null);
            currentMapper.insert(current1);
        }
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public ResultVO confirm(MesWmsStockpoListbatchDto dto) {
//        //????????????????????????
//        MesWmsStockpolist polist = PolistMapper.queryById(dto.getStockPoListId());
//        if (polist != null){
//            //?????????????????????
//            UserVo userVo = otherMapper.queryCompany(dto.getCurrentloginId());
//
//            //????????????????????????
//            MesWmsStockcurrent stockcurrent1 = new MesWmsStockcurrent();
//            stockcurrent1.setStockId(polist.getOutStockId());
//            stockcurrent1.setStockPlaceId(polist.getOutStockPlaceId());
//            stockcurrent1.setMaterialId(polist.getMaterialId());
//            stockcurrent1.setIsValid(CommonConstantUtils.NOT_DELETE);
//            List<MesWmsStockcurrent> currents = currentMapper.queryAll(stockcurrent1);
//            if (currents.size() < 1){
//                return ResultVO.create().error("?????????????????????????????????????????????");
//            }
//            MesWmsStockcurrent current = currents.get(0);
//
//            //????????????????????????
//            MesWmsStockcurrentsum sum = sumMapper.queryById(current.getStockCurrentSumId());
//            BigDecimal qty = sum.getQty().subtract(current.getQty());
//            if (qty.compareTo(new BigDecimal("0")) == -1){
////                sum.setIsValid(CommonConstantUtils.DELETE);
//                return ResultVO.create().error("????????????????????????????????????????????????");
//            }
//            sum.setQty(qty);
//            sum.setQtyUseable(qty);
//            sum.setUpdateId(dto.getCurrentloginId());
//            sum.setUpdateName(dto.getCurrentloginName());
//            sum.setUpdateTime(LocalDateTime.now());
//            sumMapper.update(sum);
//
//            //???????????????????????????
//            current.setIsValid(CommonConstantUtils.DELETE);
//            currentMapper.update(current);
//
//            //????????????????????????
//            //??????????????????
//            MesWmsStockplace place = placeMapper.queryById(polist.getInStockPlaceId());
//
//            //??????????????????????????????????????????????????????
//            MesWmsStockcurrentsum sum2 = new MesWmsStockcurrentsum();
//            sum2.setStockCode(place.getStockCode());
//            sum2.setMaterialCode(current.getMaterialCode());
//            sum2.setIsValid(CommonConstantUtils.NOT_DELETE);
//            List<MesWmsStockcurrentsum> mesWmsStockcurrentsums = sumMapper.queryAll(sum2);
//            MesWmsStockcurrentsum sum1 = new MesWmsStockcurrentsum();
//            if (mesWmsStockcurrentsums.size()<1){
//                BeanUtils.copyProperties(userVo,sum1);
//                sum1.setStockCode(place.getStockCode());
//                sum1.setStockId(place.getStockId());
//                sum1.setStockName(place.getStockName());
//                sum1.setMaterialId(current.getMaterialId());
//                sum1.setMaterialCode(current.getMaterialCode());
//                sum1.setMaterialShortName(current.getMaterialShortName());
//                sum1.setMaterialSpec(current.getMaterialSpec());
//                sum1.setMaterialTrId(current.getMaterialTrId());
//                sum1.setUnitsId(current.getUnitsId());
//                sum1.setUnitsName(current.getUnitsName());
//                sum1.setQty(current.getQty());
//                sum1.setQtyUseable(current.getQtyUseable());
//                sum1.setQtyAllot(current.getQtyAllot());
//                sum1.setQtyFreeze(current.getQtyFreeze());
//                sum1.setStockQty(current.getStockQty());
//                sum1.setCreateId(dto.getCurrentloginId());
//                sum1.setCreateName(dto.getCurrentloginName());
//                sum1.setCreateTime(LocalDateTime.now());
//                sum1.setIsValid(CommonConstantUtils.NOT_DELETE);
//                sumMapper.insert(sum1);
//            }else{
//                sum1 = mesWmsStockcurrentsums.get(0);
//                qty = sum1.getQty().add(current.getQty());
//                sum1.setQty(qty);
//                qty = sum1.getQtyUseable().add(current.getQtyUseable());
//                sum1.setQtyUseable(qty);
//                sum1.setUpdateId(dto.getCurrentloginId());
//                sum1.setUpdateName(dto.getCurrentloginName());
//                sum1.setUpdateTime(LocalDateTime.now());
//                sumMapper.update(sum1);
//            }
//
//            //????????????????????????
////            MesWmsStockcurrent current2 = new MesWmsStockcurrent();
////            current2.setStockCurrentSumId(sum1.getId());
////            current2.setStockCode(sum1.getStockCode());
////            current2.setStockPlaceCode(place.getStockPlaceCode());
////            current2.setMaterialCode(place.getMaterialCode());
////            current2.setIsValid(CommonConstantUtils.NOT_DELETE);
////            List<MesWmsStockcurrent> mesWmsStockcurrents = currentMapper.queryAll(current2);
//            MesWmsStockcurrent current1 = new MesWmsStockcurrent();
////            if (mesWmsStockcurrents.size()<1){
//                BeanUtils.copyProperties(current,current1);
//                BeanUtils.copyProperties(userVo,current1);
//                current1.setId(null);
//                current1.setStockCurrentSumId(sum1.getId());
//                current1.setStockPlaceId(place.getId());
//                current1.setStockPlaceCode(place.getStockPlaceCode());
//                current1.setStockPlaceName(place.getStockPlaceName());
//                current1.setCreateId(dto.getCurrentloginId());
//                current1.setCreateName(dto.getCurrentloginName());
//                current1.setCreateTime(LocalDateTime.now());
//                current1.setQty(current.getQty());
//                current1.setQtyUseable(current.getQtyUseable());
//                current1.setQtyAllot(current.getQtyAllot());
//                current1.setQtyFreeze(current.getQtyFreeze());
//                current1.setStockQty(current.getStockQty());
//                current1.setIsValid(CommonConstantUtils.NOT_DELETE);
//                current1.setUpdateId(null);
//                current1.setUpdateName(null);
//                current1.setUpdateTime(null);
//                currentMapper.insert(current1);
////            }else {
////                current1 = mesWmsStockcurrents.get(0);
////                current1.setIsValid(CommonConstantUtils.DELETE);
////                qty = current1.getQty().add(current.getQty());
////                current1.setQty(qty);
////                qty = current1.getQtyUseable().add(current.getQtyUseable());
////                sum1.setQtyUseable(qty);
////                current1.setUpdateId(dto.getCurrentloginId());
////                current1.setUpdateName(dto.getCurrentloginName());
////                current1.setUpdateTime(LocalDateTime.now());
////                currentMapper.update(current1);
////            }
//
//            //?????????????????????
//            MesWmsStockpo po = mesWmsStockpoMapper.queryById(polist.getStockPoId());
//            MesWmsStockpolist stockpolist = new MesWmsStockpolist();
//            stockpolist.setStockPoId(polist.getOutStockId());
//            List<MesWmsStockpolist> mesWmsStockpolists = PolistMapper.queryAll(stockpolist);
//            if (mesWmsStockpolists.size() == 1){
//                po.setState(CommonConstantUtils.STOCKPO_STATE_THREE);
//            }else {
//                po.setState(CommonConstantUtils.STOCKPO_STATE_TWO);
//            }
//            mesWmsStockpoMapper.update(po);
//
//            //??????????????????????????????
//            polist.setInBatchNo(current.getInBatchNo());
//            polist.setBatchNo(current.getBatchNo());
//            polist.setSuppliarId(current.getSuppliarId());
//            polist.setSuppliarCode(current.getSuppliarCode());
//            polist.setSuppliarName(current.getSuppliarName());
//            polist.setFFinished(current.getQty());
//            polist.setStockCurrentSumId(current.getStockCurrentSumId());
//            polist.setStockCurrentId(current.getId());
//            polist.setState(CommonConstantUtils.STOCKPO_STATE_THREE);
//            PolistMapper.update(polist);
//
//            //????????????????????????
//            MesWmsStockcurrent stockcurrent = currentMapper.queryById(polist.getStockCurrentId());
//            MesWmsStockpobatch pobatch = new MesWmsStockpobatch();
//            BeanUtils.copyProperties(stockcurrent,pobatch);
//            BeanUtils.copyProperties(polist,pobatch);
//            BeanUtils.copyProperties(userVo,pobatch);
//            pobatch.setStockPoListId(polist.getId());
//            pobatch.setCreateId(dto.getCurrentloginId());
//            pobatch.setCreateName(dto.getCurrentloginName());
//            pobatch.setIsValid(CommonConstantUtils.NOT_DELETE);
//            pobatch.setCreateTime(LocalDateTime.now());
//            pobatch.setCarrierId(po.getInCompanyId());
//            pobatch.setCarrierName(po.getInCompanyName());
//            pobatch.setUpdateId(null);
//            pobatch.setUpdateName(null);
//            pobatch.setUpdateTime(null);
//            pobatchMapper.insert(pobatch);
//
//            //????????????????????????
//            MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
//
//            return ResultVO.create().success("???????????????");
//        }
//        return ResultVO.create().error("????????????????????????");
//    }


    /**
     * ????????????????????????
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEdit(MesWmsStockPoListDto mesWmsStockPoListDto) {
        if (mesWmsStockPoListDto.getStockPoPlaceListDtos().size() > 0) {
            if (mesWmsStockPoListDto.getId() == null) {
                MesWmsStockpo mesWmsStockpo = new MesWmsStockpo();
                //?????????????????????
                UserVo userVo = otherMapper.queryCompany(mesWmsStockPoListDto.getCurrentloginId());

                //??????????????????
                String recordCode = poExtMapper.queryPoCode();
                if (StringUtils.isEmpty(recordCode)) {
                    mesWmsStockpo.setStockPoCode(CommonConstantUtils.STOCKPO_CODE);
                } else {
                    mesWmsStockpo.setStockPoCode(NumAddUtil.addOrderNum(recordCode, 10));
                }
                mesWmsStockpo.getStockPoCode();

                //??????????????????
                MesWmsStock outStock = stockMapper.queryById(mesWmsStockPoListDto.getOutStockId());
                if (CommonConstantUtils.CHECK_STATE_INVENTORY.equals(outStock.getState())) {
                    return ResultVO.create().error("??????????????????????????????????????????");
                }
                mesWmsStockpo.setOutStockId(outStock.getId());
                mesWmsStockpo.setOutStockCode(outStock.getStockCode());
                mesWmsStockpo.setOutStockName(outStock.getStockName());

                //??????????????????
                MesWmsStock inStock = stockMapper.queryById(mesWmsStockPoListDto.getInStockId());
                if (CommonConstantUtils.CHECK_STATE_INVENTORY.equals(inStock.getState())) {
                    return ResultVO.create().error("??????????????????????????????????????????");
                }
                mesWmsStockpo.setInStockId(inStock.getId());
                mesWmsStockpo.setInStockCode(inStock.getStockCode());
                mesWmsStockpo.setInStockName(inStock.getStockName());

                //????????????
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(mesWmsStockPoListDto.getOutCompanyId());
                List<StockOtherVo> stockOtherVos = otherMapper.queryDepartment(stockOtherVo);
                mesWmsStockpo.setOutCompanyId(stockOtherVos.get(0).getId());
                mesWmsStockpo.setOutCompanyName(stockOtherVos.get(0).getName());

                //????????????
                stockOtherVo.setId(mesWmsStockPoListDto.getInCompanyId());
                List<StockOtherVo> inStockOtherVos = otherMapper.queryDepartment(stockOtherVo);
                mesWmsStockpo.setInCompanyId(inStockOtherVos.get(0).getId());
                mesWmsStockpo.setInCompanyName(inStockOtherVos.get(0).getName());

                //?????????
                stockOtherVo.setId(mesWmsStockPoListDto.getDisposerId());
                List<StockOtherVo> disposers = otherMapper.queryUser(stockOtherVo);
                if (disposers != null && disposers.size() > 0){
                    mesWmsStockpo.setDisposerId(disposers.get(0).getId());
                    mesWmsStockpo.setDisposer(disposers.get(0).getName());
                }

                BeanUtils.copyProperties(userVo, mesWmsStockpo);
                mesWmsStockpo.setRemark(mesWmsStockPoListDto.getRemark());
                mesWmsStockpo.setWorkOrderCode(mesWmsStockPoListDto.getWorkOrderCode());
                mesWmsStockpo.setPoBillDate(mesWmsStockPoListDto.getPoBillDate());
                mesWmsStockpo.setPoPostingDate(mesWmsStockPoListDto.getPoPostingDate());
                mesWmsStockpo.setPoType(mesWmsStockPoListDto.getPoType());
                mesWmsStockpo.setState(CommonConstantUtils.STOCKPO_STATE_ONE);
                mesWmsStockpo.setCreateId(mesWmsStockPoListDto.getCurrentloginId());
                mesWmsStockpo.setCreateName(mesWmsStockPoListDto.getCurrentloginName());
                mesWmsStockpo.setCreateTime(LocalDateTime.now());
                mesWmsStockpo.setIsValid(CommonConstantUtils.NOT_DELETE);
                mesWmsStockpoMapper.insert(mesWmsStockpo);

                getStock(mesWmsStockPoListDto, mesWmsStockpo);
            } else {
                MesWmsStockpo mesWmsStockpo = mesWmsStockpoMapper.queryById(mesWmsStockPoListDto.getId());
                //??????????????????
                MesWmsStock outStock = stockMapper.queryById(mesWmsStockPoListDto.getOutStockId());
                mesWmsStockpo.setOutStockId(outStock.getId());
                mesWmsStockpo.setOutStockCode(outStock.getStockCode());
                mesWmsStockpo.setOutStockName(outStock.getStockName());

                //??????????????????
                MesWmsStock inStock = stockMapper.queryById(mesWmsStockPoListDto.getInStockId());
                mesWmsStockpo.setInStockId(inStock.getId());
                mesWmsStockpo.setInStockCode(inStock.getStockCode());
                mesWmsStockpo.setInStockName(inStock.getStockName());

                //????????????
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(mesWmsStockPoListDto.getOutCompanyId());
                List<StockOtherVo> stockOtherVos = otherMapper.queryDepartment(stockOtherVo);
                mesWmsStockpo.setOutCompanyId(stockOtherVos.get(0).getId());
                mesWmsStockpo.setOutCompanyName(stockOtherVos.get(0).getName());

                //????????????
                stockOtherVo.setId(mesWmsStockPoListDto.getInCompanyId());
                List<StockOtherVo> inStockOtherVos = otherMapper.queryDepartment(stockOtherVo);
                mesWmsStockpo.setInCompanyId(inStockOtherVos.get(0).getId());
                mesWmsStockpo.setInCompanyName(inStockOtherVos.get(0).getName());

                //?????????
                stockOtherVo.setId(mesWmsStockPoListDto.getDisposerId());
                List<StockOtherVo> disposers = otherMapper.queryUser(stockOtherVo);
                if (disposers != null && disposers.size() > 0){
                    mesWmsStockpo.setDisposerId(disposers.get(0).getId());
                    mesWmsStockpo.setDisposer(disposers.get(0).getName());
                }

                mesWmsStockpo.setRemark(mesWmsStockPoListDto.getRemark());
                mesWmsStockpo.setWorkOrderCode(mesWmsStockPoListDto.getWorkOrderCode());
                mesWmsStockpo.setPoBillDate(mesWmsStockPoListDto.getPoBillDate());
                mesWmsStockpo.setPoPostingDate(mesWmsStockPoListDto.getPoPostingDate());
                mesWmsStockpo.setPoType(mesWmsStockPoListDto.getPoType());
                mesWmsStockpo.setState(CommonConstantUtils.STOCKPO_STATE_ONE);
                mesWmsStockpo.setUpdateId(mesWmsStockPoListDto.getCurrentloginId());
                mesWmsStockpo.setUpdateName(mesWmsStockPoListDto.getCurrentloginName());
                mesWmsStockpo.setUpdateTime(LocalDateTime.now());
                mesWmsStockpoMapper.edit(mesWmsStockpo);

                extMapper.deletePoList(mesWmsStockpo.getId());

                getStock(mesWmsStockPoListDto, mesWmsStockpo);
            }
            return ResultVO.create().success("?????????????????????");
        }
        return ResultVO.create().error("???????????????????????????");
    }

    /**
     * ????????????????????????
     *
     * @param mesWmsStockPoListDto
     */
    private void getStock(MesWmsStockPoListDto mesWmsStockPoListDto, MesWmsStockpo stockpo) {
        mesWmsStockPoListDto.getStockPoPlaceListDtos().forEach(dto -> {

            //?????????????????????????????????
            MesWmsStockpolist polist = new MesWmsStockpolist();
            BeanUtils.copyProperties(stockpo, polist);
            //?????????????????????
            UserVo userVo = otherMapper.queryCompany(mesWmsStockPoListDto.getCurrentloginId());
            BeanUtils.copyProperties(userVo, polist);

            polist.setId(null);
            polist.setStockPoId(stockpo.getId());

            //????????????
            MesWmsStockplace stockplace = placeMapper.queryById(dto.getOutStockPlaceId());
            polist.setOutStockPlaceId(stockplace.getId());
            polist.setOutStockPlaceCode(stockplace.getStockPlaceCode());
            polist.setOutStockPlaceName(stockplace.getStockPlaceName());
            //????????????
            stockplace = placeMapper.queryById(dto.getInStockPlaceId());
            polist.setInStockPlaceId(stockplace.getId());
            polist.setInStockPlaceCode(stockplace.getStockPlaceCode());
            polist.setInStockPlaceName(stockplace.getStockPlaceName());

            //????????????
            List<MesWmsStockplacebindMaterialVo> materialVos = placeExtMapper.selectMaterial(dto.getMaterialId());
            if (materialVos.size() > 0) {
                MesWmsStockplacebindMaterialVo vo = materialVos.get(0);
                polist.setMaterialCode(vo.getMaterialCode());
                polist.setMaterialId(vo.getMaterialId());
                polist.setMaterialShortName(vo.getMaterialShortName());
                polist.setMaterialSpec(vo.getMaterialSpec());
                polist.setUnitsId(vo.getUnitsId());
                polist.setUnitsName(vo.getUnitsName());
            }

            polist.setSuppliarId(null);
            polist.setSuppliarName(null);
            polist.setSuppliarCode(null);

            //??????
            polist.setFFinished(dto.getFPallet());
            polist.setFPallet(dto.getFPallet());

            polist.setIsValid(CommonConstantUtils.NOT_DELETE);
            polist.setState(CommonConstantUtils.STOCKPO_STATE_ONE);
            polist.setCreateId(mesWmsStockPoListDto.getCurrentloginId());
            polist.setCreateName(mesWmsStockPoListDto.getCurrentloginName());
            polist.setCreateTime(LocalDateTime.now());
            polist.setUpdateId(null);
            polist.setUpdateName(null);
            polist.setUpdateTime(null);
            PolistMapper.insert(polist);
        });
    }

    /**
     * ??????Sap
     * @param ids
     * @return
     */
    @Override
    public ResultVO uploadSap(List<Integer> ids) {
        for (Integer id: ids) {
            MesWmsStockpo stockpo = mesWmsStockpoMapper.queryById(id);
            if (!CommonConstantUtils.STOCKPO_STATE_THREE.equals(stockpo.getState())
                && !CommonConstantUtils.STOCKPO_STATE_FIVE.equals(stockpo.getState())){
                return ResultUtil.error("???????????????????????????????????????????????????");
            }
        }
        for (Integer id: ids) {
            MesWmsStockpo stockpo = mesWmsStockpoMapper.queryById(id);
            stockpo.setState(CommonConstantUtils.STOCKPO_STATE_FOUR);
            mesWmsStockpoMapper.update(stockpo);
        }
        return ResultUtil.success("???????????????");
    }

    /**
     * ????????????Sap
     * @param ids
     * @return
     */
    @Override
    public ResultVO cancelUploadSap(List<Integer> ids) {
        for (Integer id: ids) {
            MesWmsStockpo stockpo = mesWmsStockpoMapper.queryById(id);
            if (!CommonConstantUtils.STOCKPO_STATE_FOUR.equals(stockpo.getState())){
                return ResultUtil.error("???????????????Sap????????????????????????");
            }
        }

        for (Integer id: ids) {
            MesWmsStockpo stockpo = mesWmsStockpoMapper.queryById(id);
            stockpo.setState(CommonConstantUtils.STOCKPO_STATE_FIVE);
            mesWmsStockpoMapper.update(stockpo);
        }
        return ResultUtil.success("?????????????????????");
    }

    /**
     * ??????????????????
     * @param stockPoId
     * @return
     */
    @Override
    public ResultVO queryBatchAll(Integer stockPoId) {
        MesWmsStockpobatch stockpobatch = new MesWmsStockpobatch();
        stockpobatch.setStockPoId(stockPoId);
        List<MesWmsStockpobatch> mesWmsStockpobatches = pobatchMapper.queryAll(stockpobatch);
        return ResultUtil.success(mesWmsStockpobatches);
    }
}

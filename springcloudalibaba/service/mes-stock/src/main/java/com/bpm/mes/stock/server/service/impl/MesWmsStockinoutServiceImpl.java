package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.dto.StockCheckResults;
import com.bpm.mes.stock.common.dto.StockInPurchaseDto;
import com.bpm.mes.stock.common.dto.StockInPurchaseListDto;
import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsInouttype;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrent;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrentsum;
import com.bpm.mes.stock.server.domain.MesWmsStockinout;
import com.bpm.mes.stock.server.domain.MesWmsStockinoutbatch;
import com.bpm.mes.stock.server.domain.MesWmsStockinoutlist;
import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.dto.BatchDto;
import com.bpm.mes.stock.server.dto.InoutPurchaseDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.mapper.base.MesWmsInouttypeMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentsumMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutbatchMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutlistMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplaceMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockinoutExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockplaceExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockinoutService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.util.NumAddUtil;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutQueryVo;
import com.bpm.mes.stock.server.vo.MesWmsStockinoutVo;
import com.bpm.mes.stock.server.vo.MesWmsStockplacebindMaterialVo;
import com.bpm.mes.stock.server.vo.StockOtherVo;
import com.bpm.mes.stock.server.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ?????????????????????(MesWmsStockinout)??????????????????
 *
 * @author makejava
 * @since 2022-04-22 16:08:22
 */
@Service
public class MesWmsStockinoutServiceImpl implements MesWmsStockinoutService {

    @Resource
    private MesWmsStockinoutMapper mesWmsStockinoutMapper;
    @Resource
    private MesWmsStockinoutlistMapper listMapper;
    @Resource
    private MesWmsStockinoutbatchMapper batchMapper;
    @Resource
    private MesWmsStockinoutExtMapper extMapper;
    @Resource
    private MesWmsStockplaceExtMapper placeExtMapper;
    @Resource
    private MesWmsStockcurrentsumMapper sumMapper;
    @Resource
    private MesWmsStockcurrentMapper currentMapper;
    @Resource
    private MesWmsOtherMapper otherMapper;
    @Resource
    private MesWmsInouttypeMapper typeMapper;
    @Resource
    private MesWmsStockMapper stockMapper;
    @Resource
    private MesWmsStockplaceMapper placeMapper;

    /**
     * ????????????
     *
     * @param mesWmsStockinoutQueryDto ????????????
     * @return ????????????
     */
    @Override
    public List<MesWmsStockinoutQueryVo> queryAll(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto) {
//        MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
//        BeanUtils.copyProperties(mesWmsStockinoutQueryDto,mesWmsStockinout);
        //??????????????????
        List<MesWmsStockinoutQueryVo> mesWmsStockinoutList = extMapper.queryAll(mesWmsStockinoutQueryDto);
        return mesWmsStockinoutList;
    }

    /**
     * ??????ID??????????????????
     *
     * @param id ??????
     * @return ????????????
     */
    @Override
    public ResultVO queryById(Integer id) {
        return ResultVO.create().success(this.mesWmsStockinoutMapper.queryById(id));
    }

    /**
     * ????????????
     *
     * @param mesWmsStockinoutQueryDto ????????????
     * @return ????????????
     */
    @Override
    public ResultVO<PageInfoVO<List<MesWmsStockinoutQueryVo>>> queryByPage(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto) {
//        MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
//        BeanUtils.copyProperties(mesWmsStockinoutQueryDto,mesWmsStockinout);
        PageHelper.startPage(mesWmsStockinoutQueryDto.getPageNum(), mesWmsStockinoutQueryDto.getPageSize());
//        List<MesWmsStockinout> mesWmsStockinoutList = this.mesWmsStockinoutMapper.queryAll(mesWmsStockinout);
        List<MesWmsStockinoutQueryVo> mesWmsStockinoutList = extMapper.queryAll(mesWmsStockinoutQueryDto);
        mesWmsStockinoutList.forEach(inoutLists -> {
            MesWmsStockinoutlist mesWmsStockinout = new MesWmsStockinoutlist();
            mesWmsStockinout.setStockInOutId(inoutLists.getId());
            List<MesWmsStockinoutlist> mesWmsStockinoutlists = listMapper.queryAll(mesWmsStockinout);
            inoutLists.setInoutlists(mesWmsStockinoutlists);
        });
        PageInfo<MesWmsStockinoutQueryVo> pageInfo = new PageInfo<>(mesWmsStockinoutList);
        PageInfoVO pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * ????????????
     *
     * @param mesWmsStockinout ????????????
     * @return ????????????
     */
    @Override
    public ResultVO insert(MesWmsStockinout mesWmsStockinout) {
        if (this.mesWmsStockinoutMapper.insert(mesWmsStockinout) > 0) {
            return ResultVO.create().success("??????????????????!");
        }
        return ResultVO.create().error("??????????????????!");
    }

    /**
     * ????????????
     *
     * @param mesWmsStockinout ????????????
     * @return ????????????
     */
    @Override
    public ResultVO update(MesWmsStockinout mesWmsStockinout) {
        if (this.mesWmsStockinoutMapper.update(mesWmsStockinout) > 0) {
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
        if (this.mesWmsStockinoutMapper.deleteById(id) > 0) {
            return ResultVO.create().success("??????????????????!");
        }
        return ResultVO.create().error("??????????????????!");
    }

    /**
     * ?????????????????????
     *
     * @param id
     * @return
     */
    @Override
    public ResultVO deleteListById(Integer id) {
        if (this.listMapper.deleteById(id) > 0) {
            return ResultVO.create().success("??????????????????!");
        }
        return ResultVO.create().error("??????????????????!");
    }

    /**
     * ??????????????????????????????
     *
     * @param dto
     * @return
     */
    @Override
    public ResultVO queryPurchaseList(InoutPurchaseDto dto) {
        List<MesWmsStockinoutListVo> listVos = extMapper.queryPurchaseList(dto);
        return ResultVO.create().success(listVos);
    }

    /**
     * ?????????????????????
     *
     * @param dto
     * @return
     */
    @Override
    public ResultVO addProductionIn(StockInPurchaseDto dto) {
        //?????????????????????
        UserVo userVo = otherMapper.queryCompany(dto.getCreateId());
        //????????????
        Integer stockId = null;
        String stockCode = null;
        String stockName = null;
        if (dto.getStockPlaceId() != null) {
            MesWmsStockplace stockplace = placeMapper.queryById(dto.getStockPlaceId());
            stockId = stockplace.getStockId();
            stockCode = stockplace.getStockCode();
            stockName = stockplace.getStockName();
        }
        if (dto.getStockId() != null) {
            MesWmsStock stock = stockMapper.queryById(dto.getStockId());
            stockId = stock.getId();
            stockCode = stock.getStockCode();
            stockName = stock.getStockName();
        }

        List<StockInPurchaseListDto> listDtos = dto.getListDtos();

        //????????????????????????
        MesWmsStockinout mesWmsStockinout = getStockIns(dto, userVo, stockId, stockCode, stockName);

        //??????????????????
        String inOutPropert = CommonConstantUtils.PROPERT_IN;
        String inBatchNo = extMapper.queryInBatchNo(inOutPropert);
        if (StringUtils.isEmpty(inBatchNo)) {
            inBatchNo = CommonConstantUtils.STOCKINOUTCODE_INBATCHNO;
        } else {
            inBatchNo = NumAddUtil.addOrderNum(inBatchNo, 6);
        }
        String finalInBatchNo = inBatchNo;

        listDtos.forEach(listDto -> {

            //????????????
            MesWmsStockplace stockplace = placeMapper.queryById(listDto.getStockPlaceId());
            //????????????
            List<MesWmsStockplacebindMaterialVo> materialVos = placeExtMapper.selectMaterial(listDto.getMaterialId());
            MesWmsStockplacebindMaterialVo vo = materialVos.get(0);

            //??????????????????
            MesWmsStockinoutlist list = getStockIn(userVo, mesWmsStockinout, listDto, stockplace, vo, finalInBatchNo);

            //??????????????????????????????
            getcurrent(dto, finalInBatchNo, listDto, stockplace, materialVos, vo);

            //???????????????????????????
            getInBatch(dto, userVo, mesWmsStockinout, finalInBatchNo, listDto, list);

        });
        return ResultVO.create().success("????????????????????????");
    }

    private void getInBatch(StockInPurchaseDto dto, UserVo userVo, MesWmsStockinout mesWmsStockinout, String finalInBatchNo, StockInPurchaseListDto listDto, MesWmsStockinoutlist list) {
        MesWmsStockinoutbatch batch = new MesWmsStockinoutbatch();
        BeanUtils.copyProperties(mesWmsStockinout, batch);
        BeanUtils.copyProperties(list, batch);
        BeanUtils.copyProperties(userVo, batch);

        batch.setStockInOutId(mesWmsStockinout.getId());
        batch.setStockInOutCode(mesWmsStockinout.getStockInOutCode());
        batch.setStockInOutDetailId(list.getId());
        batch.setQty(listDto.getFPallet());
        batch.setStockInOutDetailId(list.getId());
        batch.setIsValid(CommonConstantUtils.NOT_DELETE);
        batch.setCreateId(dto.getCreateId());
        batch.setCreateName(dto.getCreateName());
        batch.setCreateTime(LocalDateTime.now());
        batch.setInBatchNo(finalInBatchNo);
        batch.setUpdateId(null);
        batch.setUpdateName(null);
        batch.setUpdateTime(null);
        batch.setState(CommonConstantUtils.STOCKINOUT_OUT);
        batchMapper.insert(batch);
    }

    private void getcurrent(StockInPurchaseDto dto, String finalInBatchNo, StockInPurchaseListDto listDto, MesWmsStockplace stockplace, List<MesWmsStockplacebindMaterialVo> materialVos, MesWmsStockplacebindMaterialVo vo) {
        MesWmsStockcurrentsum stockcurrentsum = new MesWmsStockcurrentsum();
        stockcurrentsum.setStockCode(stockplace.getStockCode());
        stockcurrentsum.setMaterialId(listDto.getMaterialId());
        stockcurrentsum.setIsValid(CommonConstantUtils.NOT_DELETE);
        List<MesWmsStockcurrentsum> mesWmsStockcurrentsums = sumMapper.queryAll(stockcurrentsum);
        MesWmsStockcurrentsum sum1 = new MesWmsStockcurrentsum();
        if (mesWmsStockcurrentsums.size() < 1) {
            sum1.setStockCode(stockplace.getStockCode());
            sum1.setStockId(stockplace.getStockId());
            sum1.setStockName(stockplace.getStockName());
            sum1.setMaterialId(vo.getMaterialId());
            sum1.setMaterialCode(vo.getMaterialCode());
            sum1.setMaterialShortName(vo.getMaterialShortName());
            sum1.setMaterialSpec(vo.getMaterialSpec());
            sum1.setMaterialTrId(vo.getMaterialTrId());
            sum1.setUnitsId(vo.getUnitsId());
            sum1.setUnitsName(vo.getUnitsName());
            sum1.setQty(listDto.getFPallet());
            sum1.setQtyUseable(listDto.getFPallet());
            sum1.setQtyAllot(listDto.getFPallet());
            sum1.setQtyFreeze(listDto.getFPallet());
            sum1.setStockQty(listDto.getFPallet());
            sum1.setCreateId(dto.getCreateId());
            sum1.setCreateName(dto.getCreateName());
            sum1.setCreateTime(LocalDateTime.now());
            sum1.setIsValid(CommonConstantUtils.NOT_DELETE);
            sumMapper.insert(sum1);
        } else {
            sum1 = mesWmsStockcurrentsums.get(0);
            BigDecimal qty = sum1.getQty().add(listDto.getFPallet());
            sum1.setQty(qty);
            sum1.setQtyUseable(qty);
            sum1.setUpdateId(dto.getCreateId());
            sum1.setUpdateName(dto.getCreateName());
            sum1.setUpdateTime(LocalDateTime.now());
            sumMapper.update(sum1);
        }

        //????????????????????????-??????
        //?????????????????????????????????
        MesWmsStockcurrent stockcurrent = new MesWmsStockcurrent();
        stockcurrent.setStockCurrentSumId(sum1.getId());
        stockcurrent.setStockCode(sum1.getStockCode());
        stockcurrent.setStockPlaceId(listDto.getStockPlaceId());
        stockcurrent.setMaterialId(listDto.getMaterialId());
        stockcurrent.setInBatchNo(finalInBatchNo);
        stockcurrent.setIsValid(CommonConstantUtils.NOT_DELETE);
        List<MesWmsStockcurrent> wmsStockcurrents = currentMapper.queryAll(stockcurrent);
        if (wmsStockcurrents.size() < 1) {
            MesWmsStockcurrent current1 = new MesWmsStockcurrent();
            MesWmsStock mesWmsStock = stockMapper.queryById(stockplace.getStockId());
            current1.setStockType(mesWmsStock.getStockType());
            current1.setStockCode(stockplace.getStockCode());
            current1.setStockId(stockplace.getStockId());
            current1.setStockName(stockplace.getStockName());
            current1.setStockCurrentSumId(sum1.getId());
            current1.setStockPlaceId(stockplace.getId());
            current1.setStockPlaceCode(stockplace.getStockPlaceCode());
            current1.setStockPlaceName(stockplace.getStockPlaceName());
            current1.setCreateId(dto.getCreateId());
            current1.setCreateName(dto.getCreateName());
            current1.setCreateTime(LocalDateTime.now());
            current1.setQty(listDto.getFPallet());
            current1.setQtyUseable(listDto.getFPallet());
            current1.setQtyAllot(listDto.getFPallet());
            current1.setQtyFreeze(listDto.getFPallet());
            current1.setStockQty(listDto.getFPallet());
            current1.setIsValid(CommonConstantUtils.NOT_DELETE);
            if (materialVos.size() > 0) {
                current1.setMaterialId(vo.getMaterialId());
                current1.setMaterialCode(vo.getMaterialCode());
                current1.setMaterialShortName(vo.getMaterialShortName());
                current1.setMaterialSpec(vo.getMaterialSpec());
                current1.setMaterialTrId(vo.getMaterialTrId());
                current1.setUnitsId(vo.getUnitsId());
                current1.setUnitsName(vo.getUnitsName());
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            current1.setFkDate(sdf.format(new Date()));
            current1.setInBatchNo(finalInBatchNo);
            currentMapper.insert(current1);
        } else {
            MesWmsStockcurrent wmsStockcurrent = wmsStockcurrents.get(0);
            BigDecimal qty = wmsStockcurrent.getQty().add(listDto.getFPallet());
            wmsStockcurrent.setIsValid(CommonConstantUtils.NOT_DELETE);
            wmsStockcurrent.setQty(qty);
            wmsStockcurrent.setQtyUseable(qty);
            wmsStockcurrent.setUpdateId(dto.getCreateId());
            wmsStockcurrent.setUpdateName(dto.getCreateName());
            wmsStockcurrent.setUpdateTime(LocalDateTime.now());
            currentMapper.update(wmsStockcurrent);
        }
    }

    private MesWmsStockinoutlist getStockIn(UserVo userVo, MesWmsStockinout mesWmsStockinout, StockInPurchaseListDto listDto, MesWmsStockplace stockplace,
                                            MesWmsStockplacebindMaterialVo vo, String finalInBatchNo) {
        MesWmsStockinoutlist list = new MesWmsStockinoutlist();
        BeanUtils.copyProperties(listDto, list);
        BeanUtils.copyProperties(userVo, list);

        list.setMaterialCode(vo.getMaterialCode());
        list.setMaterialId(vo.getMaterialId());
        list.setMaterialShortName(vo.getMaterialShortName());
        list.setMaterialSpec(vo.getMaterialSpec());
        list.setUnitsId(vo.getUnitsId());
        list.setUnitsName(vo.getUnitsName());

        list.setInBatchNo(finalInBatchNo);
        list.setStockId(stockplace.getStockId());
        list.setStockCode(stockplace.getStockCode());
        list.setStockName(stockplace.getStockName());
        list.setStockPlaceId(stockplace.getId());
        list.setStockPlaceCode(stockplace.getStockPlaceCode());
        list.setStockPlaceName(stockplace.getStockPlaceName());

        list.setStockInOutId(mesWmsStockinout.getId());
        list.setFFinished(listDto.getFPallet());
        list.setIsValid(CommonConstantUtils.NOT_DELETE);
        list.setStatus(CommonConstantUtils.STOCKINOUT_STATE_THREE);
        list.setCreateTime(LocalDateTime.now());
        listMapper.insert(list);
        return list;
    }

    private MesWmsStockinout getStockIns(StockInPurchaseDto dto, UserVo userVo, Integer stockId, String stockCode, String stockName) {
        MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
        BeanUtils.copyProperties(dto, mesWmsStockinout);
        BeanUtils.copyProperties(userVo, mesWmsStockinout);

        mesWmsStockinout.setStockId(stockId);
        mesWmsStockinout.setStockCode(stockCode);
        mesWmsStockinout.setStockName(stockName);
        mesWmsStockinout.setInOutTypePropert(CommonConstantUtils.PROPERT_IN);

        MesWmsInouttype inouttype = new MesWmsInouttype();
        inouttype.setBillFlag(dto.getBillCode());
        List<MesWmsInouttype> mesWmsInouttypes = typeMapper.queryAll(inouttype);
        if (mesWmsInouttypes.size()>0){
            mesWmsStockinout.setInOutTypeId(mesWmsInouttypes.get(0).getId());
            mesWmsStockinout.setInOutTypeCode(mesWmsInouttypes.get(0).getInOutTypeCode());
            mesWmsStockinout.setInOutTypeName(mesWmsInouttypes.get(0).getInOutTypeName());
        }

        //?????????????????????
        String inOutPropert = CommonConstantUtils.PROPERT_IN;
        String recordCode = extMapper.queryInOutCode(inOutPropert);
        if (StringUtils.isEmpty(recordCode)) {
            mesWmsStockinout.setStockInOutCode(CommonConstantUtils.STOCKINOUTCODE_IN);
        } else {
            mesWmsStockinout.setStockInOutCode(NumAddUtil.addOrderNum(recordCode, 10));
        }
        mesWmsStockinout.setFrob(CommonConstantUtils.STOCKINOUT_FROB_BLUE);
        mesWmsStockinout.setIsValid(CommonConstantUtils.NOT_DELETE);
        mesWmsStockinout.setInOutTypePropert(inOutPropert);
        mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_THREE);
        mesWmsStockinout.setCreateTime(LocalDateTime.now());
        mesWmsStockinoutMapper.insert(mesWmsStockinout);
        return mesWmsStockinout;
    }

    /**
     * ??????
     *
     * @param batchDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addWarehousing(BatchDto batchDto) {
        MesWmsStockinoutlist list = listMapper.queryById(batchDto.getId());
        if (!StringUtils.isEmpty(list)) {
            MesWmsStockinout inout = mesWmsStockinoutMapper.queryById(list.getStockInOutId());
            MesWmsStockinoutbatch batch = new MesWmsStockinoutbatch();
            BeanUtils.copyProperties(inout, batch);
            BeanUtils.copyProperties(list, batch);
            batch.setQty(list.getFPallet());
            batch.setStockInOutDetailId(list.getId());
            batch.setIsValid(CommonConstantUtils.NOT_DELETE);
            batch.setCreateId(batchDto.getCurrentloginId());
            batch.setCreateName(batchDto.getCurrentloginName());
            batch.setCreateTime(LocalDateTime.now());
            batch.setUpdateId(null);
            batch.setUpdateName(null);
            batch.setUpdateTime(null);
            batch.setState(CommonConstantUtils.STOCKINOUT_IN);
            batchMapper.insert(batch);

            //??????????????????
            MesWmsStockinout mesWmsStockinout = mesWmsStockinoutMapper.queryById(list.getStockInOutId());
            MesWmsStockinoutlist mesWmsStockinoutlist = new MesWmsStockinoutlist();
            mesWmsStockinoutlist.setStockInOutId(mesWmsStockinout.getId());
            mesWmsStockinoutlist.setStatus(CommonConstantUtils.STOCKINOUT_STATE_ONE);
            List<MesWmsStockinoutlist> mesWmsStockinoutlists = listMapper.queryAll(mesWmsStockinoutlist);
            if (mesWmsStockinoutlists.size() == 1) {
                mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_THREE);
            } else {
                mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_TWO);
            }
            mesWmsStockinoutMapper.update(mesWmsStockinout);

            //?????????????????????
            list.setStatus(CommonConstantUtils.STOCKINOUT_STATE_THREE);
            listMapper.update(list);

            //????????????
            List<MesWmsStockplacebindMaterialVo> materialVos = placeExtMapper.selectMaterial(list.getMaterialId());

            //??????????????????????????????????????????????????????
            MesWmsStockcurrentsum sum2 = new MesWmsStockcurrentsum();
            sum2.setStockCode(list.getStockCode());
            sum2.setMaterialCode(list.getMaterialCode());
            sum2.setIsValid(CommonConstantUtils.NOT_DELETE);
            List<MesWmsStockcurrentsum> mesWmsStockcurrentsums = sumMapper.queryAll(sum2);
            MesWmsStockcurrentsum sum1 = new MesWmsStockcurrentsum();
            if (mesWmsStockcurrentsums.size() < 1) {
                sum1.setStockCode(list.getStockCode());
                sum1.setStockId(list.getStockId());
                sum1.setStockName(list.getStockName());
                if (materialVos.size() > 0) {
                    MesWmsStockplacebindMaterialVo vo = materialVos.get(0);
                    sum1.setMaterialId(vo.getMaterialId());
                    sum1.setMaterialCode(vo.getMaterialCode());
                    sum1.setMaterialShortName(vo.getMaterialShortName());
                    sum1.setMaterialSpec(vo.getMaterialSpec());
                    sum1.setMaterialTrId(vo.getMaterialTrId());
                    sum1.setUnitsId(vo.getUnitsId());
                    sum1.setUnitsName(vo.getUnitsName());
                }

                sum1.setQty(batch.getQty());
                sum1.setQtyUseable(list.getFFinished());
                sum1.setQtyAllot(list.getFFinished());
                sum1.setQtyFreeze(list.getFFinished());
                sum1.setStockQty(list.getFFinished());
                sum1.setCreateId(batchDto.getCurrentloginId());
                sum1.setCreateName(batchDto.getCurrentloginName());
                sum1.setCreateTime(LocalDateTime.now());
                sum1.setIsValid(CommonConstantUtils.NOT_DELETE);
                sumMapper.insert(sum1);
            } else {
                sum1 = mesWmsStockcurrentsums.get(0);
                BigDecimal qty = sum1.getQty().add(list.getFPallet());
                sum1.setQty(qty);
                sum1.setQtyUseable(qty);
                sum1.setUpdateId(batchDto.getCurrentloginId());
                sum1.setUpdateName(batchDto.getCurrentloginName());
                sum1.setUpdateTime(LocalDateTime.now());
                sumMapper.update(sum1);
            }
            //?????????????????????????????????
            //?????????????????????????????????
//            MesWmsStockcurrent current2 = new MesWmsStockcurrent();
//            current2.setStockCurrentSumId(sum1.getId());
//            current2.setStockCode(sum1.getStockCode());
//            current2.setStockPlaceCode(list.getStockPlaceCode());
//            current2.setMaterialCode(list.getMaterialCode());
//            current2.setIsValid(CommonConstantUtils.NOT_DELETE);
//            List<MesWmsStockcurrent> mesWmsStockcurrents = currentMapper.queryAll(current2);
            MesWmsStockcurrent current1 = new MesWmsStockcurrent();
//            if (mesWmsStockcurrents.size() < 1) {
            MesWmsStock stock = stockMapper.queryById(list.getStockId());
            current1.setStockType(stock.getStockType());
            current1.setStockCode(list.getStockCode());
            current1.setStockId(list.getStockId());
            current1.setStockName(list.getStockName());
            current1.setStockCurrentSumId(sum1.getId());
            current1.setStockPlaceId(list.getStockPlaceId());
            current1.setStockPlaceCode(list.getStockPlaceCode());
            current1.setStockPlaceName(list.getStockPlaceName());
            current1.setCreateId(batchDto.getCurrentloginId());
            current1.setCreateName(batchDto.getCurrentloginName());
            current1.setCreateTime(LocalDateTime.now());
            current1.setQty(list.getFPallet());
            current1.setQtyUseable(list.getFPallet());
            current1.setQtyAllot(list.getFPallet());
            current1.setQtyFreeze(list.getFPallet());
            current1.setStockQty(list.getFPallet());
            current1.setIsValid(CommonConstantUtils.NOT_DELETE);
            if (materialVos.size() > 0) {
                MesWmsStockplacebindMaterialVo vo = materialVos.get(0);
                current1.setMaterialId(vo.getMaterialId());
                current1.setMaterialCode(vo.getMaterialCode());
                current1.setMaterialShortName(vo.getMaterialShortName());
                current1.setMaterialSpec(vo.getMaterialSpec());
                current1.setMaterialTrId(vo.getMaterialTrId());
                current1.setUnitsId(vo.getUnitsId());
                current1.setUnitsName(vo.getUnitsName());
            }
            current1.setSuppliarId(list.getSuppliarId());
            current1.setSuppliarCode(list.getSuppliarCode());
            current1.setSuppliarName(list.getSuppliarName());
            current1.setFkDate(list.getKFDate());
            current1.setBatchNo(list.getBatchNo());
            current1.setInBatchNo(list.getInBatchNo());
            current1.setBarCode(list.getBarCode());
            currentMapper.insert(current1);
//            } else {
//                current1 = mesWmsStockcurrents.get(0);
//                BigDecimal qty = current1.getQty().add(list.getFFinished());
//                current1.setIsValid(CommonConstantUtils.DELETE);
//                current1.setQty(qty);
//                current1.setQtyUseable(qty);
//                current1.setUpdateId(batchDto.getCurrentloginId());
//                current1.setUpdateName(batchDto.getCurrentloginName());
//                current1.setUpdateTime(LocalDateTime.now());
//                currentMapper.update(current1);
//            }
            return ResultVO.create().success("????????????!");
        }
        return ResultVO.create().error("????????????????????????????????????!");
    }

    /**
     * ?????????????????????
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addPurchaseIn(StockInPurchaseDto dto) {
        //?????????????????????
        UserVo userVo = otherMapper.queryCompany(dto.getCreateId());
        //????????????
        Integer stockId = null;
        String stockCode = null;
        String stockName = null;
        if (dto.getStockPlaceId() != null) {
            MesWmsStockplace stockplace = placeMapper.queryById(dto.getStockPlaceId());
            stockId = stockplace.getStockId();
            stockCode = stockplace.getStockCode();
            stockName = stockplace.getStockName();
        }
        if (dto.getStockId() != null) {
            MesWmsStock stock = stockMapper.queryById(dto.getStockId());
            stockId = stock.getId();
            stockCode = stock.getStockCode();
            stockName = stock.getStockName();
        }

        List<StockInPurchaseListDto> listDtos = dto.getListDtos();

        //????????????????????????
        MesWmsStockinout mesWmsStockinout = getStockIns(dto, userVo, stockId, stockCode, stockName);

        //??????????????????
        String inOutPropert = CommonConstantUtils.PROPERT_IN;
        String inBatchNo = extMapper.queryInBatchNo(inOutPropert);
        if (StringUtils.isEmpty(inBatchNo)) {
            inBatchNo = CommonConstantUtils.STOCKINOUTCODE_INBATCHNO;
        } else {
            inBatchNo = NumAddUtil.addOrderNum(inBatchNo, 6);
        }
        String finalInBatchNo = inBatchNo;

        listDtos.forEach(listDto -> {

            //????????????
            MesWmsStockplace stockplace = placeMapper.queryById(listDto.getStockPlaceId());
            //????????????
            List<MesWmsStockplacebindMaterialVo> materialVos = placeExtMapper.selectMaterial(listDto.getMaterialId());
            MesWmsStockplacebindMaterialVo vo = materialVos.get(0);

            //??????????????????
            MesWmsStockinoutlist list = getStockIn(userVo, mesWmsStockinout, listDto, stockplace, vo, finalInBatchNo);

            //??????????????????????????????
            getcurrent(dto, finalInBatchNo, listDto, stockplace, materialVos, vo);

            //???????????????????????????
            getInBatch(dto, userVo, mesWmsStockinout, finalInBatchNo, listDto, list);

        });
        return ResultVO.create().success("??????????????????????????????");
    }

    /**
     * ????????????????????????
     *
     * @param mesWmsStockinoutVo
     * @return
     */
    @Override
    public ResultVO queryProduction(MesWmsStockinoutVo mesWmsStockinoutVo) {
        //???????????????????????????
        List<MesWmsStockinoutVo> vos = extMapper.queryProduction(mesWmsStockinoutVo);
        vos.forEach(vo -> {
            //??????????????????????????????
            InoutPurchaseDto inoutPurchaseDto = new InoutPurchaseDto();
            BeanUtils.copyProperties(vo,inoutPurchaseDto);
            List<MesWmsStockinoutListVo> listVos = extMapper.queryProductionList(inoutPurchaseDto);
            vo.setListVos(listVos);
        });
        return ResultUtil.success(vos);
    }

    /**
     * ??????????????????
     *
     * @param stockinoutbatch
     * @return
     */
    @Override
    public List<MesWmsStockinoutbatch> queryBatch(MesWmsStockinoutbatch stockinoutbatch) {
        MesWmsStockinoutbatch batch = new MesWmsStockinoutbatch();
        batch.setIsValid(CommonConstantUtils.NOT_DELETE);
        batch.setStockInOutId(stockinoutbatch.getStockInOutId());
        List<MesWmsStockinoutbatch> mesWmsStockinoutbatches = batchMapper.queryAll(batch);
        return mesWmsStockinoutbatches;
    }

    /**
     * ??????Sap
     *
     * @param ids
     * @return
     */
    @Override
    public ResultVO uploadSap(List<Integer> ids) {
        for (Integer id : ids) {
            MesWmsStockinout stockinout = mesWmsStockinoutMapper.queryById(id);
            if (!CommonConstantUtils.STOCKINOUT_STATE_THREE.equals(stockinout.getStatus())
                    && !CommonConstantUtils.STOCKINOUT_STATE_FIVE.equals(stockinout.getStatus())
                    && !CommonConstantUtils.STOCKINOUT_STATE_TEN.equals(stockinout.getStatus())) {
                return ResultUtil.error("????????????????????????????????????????????????");
            }
        }

        for (Integer id : ids) {
            MesWmsStockinout stockinout = mesWmsStockinoutMapper.queryById(id);
            stockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_FOUR);
            mesWmsStockinoutMapper.update(stockinout);

            MesWmsStockinoutlist mesWmsStockinoutlist = new MesWmsStockinoutlist();
            mesWmsStockinoutlist.setStockInOutId(stockinout.getId());
            List<MesWmsStockinoutlist> stockinoutlists = listMapper.queryAll(mesWmsStockinoutlist);
            stockinoutlists.forEach(list -> {
                list.setStatus(CommonConstantUtils.STOCKINOUT_STATE_FOUR);
                listMapper.update(list);
            });
        }
        return ResultUtil.success("???????????????");
    }

    /**
     * ????????????Sap
     *
     * @param ids
     * @return
     */
    @Override
    public ResultVO cancelUploadSap(List<Integer> ids) {
        for (Integer id : ids) {
            MesWmsStockinout stockinout = mesWmsStockinoutMapper.queryById(id);
            if (CommonConstantUtils.STOCKINOUT_STATE_FOUR.equals(stockinout.getStatus())) {
                return ResultUtil.error("???????????????Sap????????????????????????");
            }
        }
        for (Integer id : ids) {
            MesWmsStockinout stockinout = mesWmsStockinoutMapper.queryById(id);
            stockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_FIVE);
            mesWmsStockinoutMapper.update(stockinout);
            MesWmsStockinoutlist mesWmsStockinoutlist = new MesWmsStockinoutlist();
            mesWmsStockinoutlist.setStockInOutId(stockinout.getId());
            List<MesWmsStockinoutlist> stockinoutlists = listMapper.queryAll(mesWmsStockinoutlist);
            stockinoutlists.forEach(list -> {
                list.setStatus(CommonConstantUtils.STOCKINOUT_STATE_FIVE);
                listMapper.update(list);
            });
        }
        return ResultUtil.success("?????????????????????");
    }

    /**
     * ????????????
     *
     * @param stockCheckResults
     * @return
     */
    @Override
    public ResultVO checkReception(StockCheckResults stockCheckResults) {
        //????????????????????????????????????
        MesWmsStockinoutlist mesWmsStockinoutlist = listMapper.queryById(stockCheckResults.getStockInOutListId());
        if (StringUtils.isEmpty(mesWmsStockinoutlist)) {
            return ResultUtil.error("??????????????????????????????");
        }
        BeanUtils.copyProperties(stockCheckResults, mesWmsStockinoutlist);
        mesWmsStockinoutlist.setCheckerTime(LocalDateTime.now());
        listMapper.update(mesWmsStockinoutlist);

        //?????????????????????????????????
        MesWmsStockinout mesWmsStockinout = mesWmsStockinoutMapper.queryById(mesWmsStockinoutlist.getStockInOutId());
        BeanUtils.copyProperties(stockCheckResults, mesWmsStockinout);
        MesWmsStockinoutlist stockinoutlist = new MesWmsStockinoutlist();
        stockinoutlist.setStockInOutId(mesWmsStockinoutlist.getStockInOutId());
        List<MesWmsStockinoutlist> mesWmsStockinoutlists = listMapper.queryAll(stockinoutlist);
        List<MesWmsStockinoutlist> collects = mesWmsStockinoutlists.stream().filter(list -> list.getStatus().equals(CommonConstantUtils.STOCKINOUT_STATE_EIGHT)).collect(Collectors.toList());
        if (collects.size() > 1) {
            mesWmsStockinoutlist.setStatus(CommonConstantUtils.STOCKINOUT_STATE_EIGHT);
            mesWmsStockinoutlist.setCheckerTime(LocalDateTime.now());
        }
        collects = mesWmsStockinoutlists.stream().filter(list -> list.getStatus().equals(CommonConstantUtils.STOCKINOUT_STATE_SIX)).collect(Collectors.toList());
        if (collects.size() > 1) {
            mesWmsStockinoutlist.setStatus(CommonConstantUtils.STOCKINOUT_STATE_SIX);
            mesWmsStockinoutlist.setCheckerTime(LocalDateTime.now());
        }
        mesWmsStockinoutMapper.update(mesWmsStockinout);
        return ResultUtil.success("????????????????????????????????????");
    }

    /**
     * ??????????????????????????????
     *
     * @param id ??????
     * @return ????????????
     */
    @Override
    public ResultVO updateById(Integer id) {
        if (this.mesWmsStockinoutMapper.updateById(id) > 0) {
            return ResultVO.create().success("??????????????????!");
        }
        return ResultVO.create().error("??????????????????!");
    }

    /**
     * ????????????????????????
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEditIn(MesWmsStockinoutDto dto) {
        MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
        MesWmsStockinoutVo inoutVo = new MesWmsStockinoutVo();
        //??????
        String inOutPropert = CommonConstantUtils.PROPERT_IN;
        UserVo userVo = otherMapper.queryCompany(dto.getCurrentloginId());
        if (dto.getId() == null) {
            BeanUtils.copyProperties(dto, mesWmsStockinout);
            mesWmsStockinout.setFrob(CommonConstantUtils.STOCKINOUT_FROB_BLUE);
            mesWmsStockinout.setInOutTypePropert(CommonConstantUtils.PROPERT_IN);
            mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_ONE);
            //????????????
            //????????????????????????????????????????????????

            BeanUtils.copyProperties(userVo, mesWmsStockinout);
            //???????????????
            MesWmsInouttype inouttype = typeMapper.queryById(dto.getInOutTypeId());
            if (!StringUtils.isEmpty(inouttype)) {
                if (dto.getSourceId() != null) {
                    //?????????????????????????????????
                    if (inouttype.getBillFlag().equals(CommonConstantUtils.INOUTTYPE_CIN)) {
                        MesWmsStockinoutVo vo1 = new MesWmsStockinoutVo();
//                    vo1.setBuyAcceptId(dto.getBuyAcceptId());
                        vo1.setSourceId(dto.getSourceId());
                        List<MesWmsStockinoutVo> vos = extMapper.queryPurchase(vo1);
                        if (vos.size() > 0) {
                            inoutVo = vos.get(0);
                            BeanUtils.copyProperties(inoutVo, mesWmsStockinout);
                        }
                    } else {//????????????????????????????????????
                        MesWmsStockinoutVo vo1 = new MesWmsStockinoutVo();
                        vo1.setSourceId(dto.getSourceId());
                        List<MesWmsStockinoutVo> vos = extMapper.queryProduction(vo1);
                        if (vos.size() > 0) {
                            inoutVo = vos.get(0);
                            BeanUtils.copyProperties(inoutVo, mesWmsStockinout);
                        }
                    }
                }
                mesWmsStockinout.setInOutTypeId(inouttype.getId());
                mesWmsStockinout.setInOutTypeCode(inouttype.getInOutTypeCode());
                mesWmsStockinout.setInOutTypeName(inouttype.getInOutTypeName());
                mesWmsStockinout.setBillCode(inouttype.getBillFlag());
            }

            //?????????????????????
            String recordCode = extMapper.queryInOutCode(inOutPropert);
            if (StringUtils.isEmpty(recordCode)) {
                mesWmsStockinout.setStockInOutCode(CommonConstantUtils.STOCKINOUTCODE_IN);
            } else {
                mesWmsStockinout.setStockInOutCode(NumAddUtil.addOrderNum(recordCode, 10));
            }

            //???????????????
            if (dto.getSuppliarId() != null && (CommonConstantUtils.INOUTTYPE_CIN.equals(inouttype.getBillFlag())
                    || CommonConstantUtils.INOUTTYPE_QIN.equals(inouttype.getBillFlag()))) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getSuppliarId());
                List<StockOtherVo> stockOtherVos = otherMapper.querySuppliar(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setSuppliarId(stockOtherVos.get(0).getId());
                    mesWmsStockinout.setSuppliarCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setSuppliarName(stockOtherVos.get(0).getName());
                }
            }
            //????????????
            if (dto.getDepartmentId() != null && !(CommonConstantUtils.INOUTTYPE_CIN.equals(inouttype.getBillFlag())
                    || CommonConstantUtils.INOUTTYPE_QIN.equals(inouttype.getBillFlag()))) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getDepartmentId());
                List<StockOtherVo> stockOtherVos = otherMapper.queryDepartment(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setDepartmentId(stockOtherVos.get(0).getId());
                    mesWmsStockinout.setDepartmentCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setDepartmentName(stockOtherVos.get(0).getName());
                }
            }
            //??????????????????
//            if (dto.getClientIdReceive() != null){
//                StockOtherVo stockOtherVo = new StockOtherVo();
//                stockOtherVo.setId(dto.getClientIdReceive());
//                List<StockOtherVo> stockOtherVos = otherMapper.queryDepartment(stockOtherVo);
//                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
//                    mesWmsStockinout.setClientIdReceive(stockOtherVos.get(0).getId());
//                    mesWmsStockinout.setClientCodeReceive(stockOtherVos.get(0).getCode());
//                    mesWmsStockinout.setClientNameReceive(stockOtherVos.get(0).getName());
//                }
//            }
            //??????????????????
            if (dto.getStockId() != null) {
                MesWmsStock stock = stockMapper.queryById(dto.getStockId());
                if (!StringUtils.isEmpty(stock)) {
                    mesWmsStockinout.setStockId(stock.getId());
                    mesWmsStockinout.setStockCode(stock.getStockCode());
                    mesWmsStockinout.setStockName(stock.getStockName());
                }
            }
            mesWmsStockinout.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockinout.setCreateId(dto.getCurrentloginId());
            mesWmsStockinout.setCreateName(dto.getCurrentloginName());
            mesWmsStockinout.setCreateTime(LocalDateTime.now());
            mesWmsStockinoutMapper.insert(mesWmsStockinout);
        } else {
            MesWmsStockinout mesWmsStockinout1 = mesWmsStockinoutMapper.queryById(dto.getId());
            BeanUtils.copyProperties(mesWmsStockinout1, mesWmsStockinout);
            BeanUtils.copyProperties(userVo, mesWmsStockinout);
            mesWmsStockinout.setInOutTypePropert(CommonConstantUtils.PROPERT_IN);
            //???????????????
            MesWmsInouttype inouttype = typeMapper.queryById(dto.getInOutTypeId());
            if (!StringUtils.isEmpty(inouttype)) {
                mesWmsStockinout.setInOutTypeId(inouttype.getId());
                mesWmsStockinout.setInOutTypeCode(inouttype.getInOutTypeCode());
                mesWmsStockinout.setInOutTypeName(inouttype.getInOutTypeName());
                mesWmsStockinout.setBillCode(inouttype.getBillFlag());

                if (dto.getSourceId() != null) {
                    //?????????????????????????????????
                    if (inouttype.getBillFlag().equals(CommonConstantUtils.INOUTTYPE_CIN)) {
                        MesWmsStockinoutVo vo1 = new MesWmsStockinoutVo();
//                    vo1.setBuyAcceptId(dto.getBuyAcceptId());
                        vo1.setSourceId(dto.getSourceId());
                        List<MesWmsStockinoutVo> vos = extMapper.queryPurchase(vo1);
                        if (vos.size() > 0) {
                            inoutVo = vos.get(0);
                            BeanUtils.copyProperties(inoutVo, mesWmsStockinout);
                        }
                    } else {//????????????????????????????????????
                        MesWmsStockinoutVo vo1 = new MesWmsStockinoutVo();
                        vo1.setSourceId(dto.getSourceId());
                        List<MesWmsStockinoutVo> vos = extMapper.queryProduction(vo1);
                        if (vos.size() > 0) {
                            inoutVo = vos.get(0);
                            BeanUtils.copyProperties(inoutVo, mesWmsStockinout);
                        }
                    }
                }
            }
            //???????????????
            if (dto.getSuppliarId() != null) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getSuppliarId());
                List<StockOtherVo> stockOtherVos = otherMapper.querySuppliar(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setSuppliarId(stockOtherVos.get(0).getId());
                    mesWmsStockinout.setSuppliarCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setSuppliarName(stockOtherVos.get(0).getName());
                    mesWmsStockinout.setDepartmentId(null);
                    mesWmsStockinout.setDepartmentCode(null);
                    mesWmsStockinout.setDepartmentName(null);
                }
            }
            //????????????
            if (dto.getDepartmentId() != null) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getDepartmentId());
                List<StockOtherVo> stockOtherVos = otherMapper.queryDepartment(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setDepartmentId(stockOtherVos.get(0).getId());
                    mesWmsStockinout.setDepartmentCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setDepartmentName(stockOtherVos.get(0).getName());
                    mesWmsStockinout.setSuppliarId(null);
                    mesWmsStockinout.setSuppliarCode(null);
                    mesWmsStockinout.setSuppliarName(null);
                }
            }
            //??????????????????
            if (dto.getStockId() != null) {
                MesWmsStock stock = stockMapper.queryById(dto.getStockId());
                if (!StringUtils.isEmpty(stock)) {
                    mesWmsStockinout.setStockId(stock.getId());
                    mesWmsStockinout.setStockCode(stock.getStockCode());
                    mesWmsStockinout.setStockName(stock.getStockName());
                }
            }
            mesWmsStockinout.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockinout.setUpdateId(dto.getCurrentloginId());
            mesWmsStockinout.setUpdateName(dto.getCurrentloginName());
            mesWmsStockinout.setUpdateTime(LocalDateTime.now());
            mesWmsStockinoutMapper.edit(mesWmsStockinout);
            extMapper.deleteInOutList(mesWmsStockinout.getId());
        }

        //??????????????????
        String inBatchNo = extMapper.queryInBatchNo(inOutPropert);
        if (StringUtils.isEmpty(inBatchNo)) {
            inBatchNo = CommonConstantUtils.STOCKINOUTCODE_INBATCHNO;
        } else {
            inBatchNo = NumAddUtil.addOrderNum(inBatchNo, 6);
        }
        String finalInBatchNo = inBatchNo;
        dto.getListDtos().forEach(listDto -> {
            MesWmsStockinoutlist list = new MesWmsStockinoutlist();
            BeanUtils.copyProperties(listDto, list);

            //???????????????????????????
            if (listDto.getSourceListId() != null){
                if (mesWmsStockinout.getBillCode().equals(CommonConstantUtils.INOUTTYPE_CIN)) {
                    InoutPurchaseDto inoutPurchaseDto = new InoutPurchaseDto();
//                    inoutPurchaseDto.setBuyAcceptId(mesWmsStockinout.getBuyAcceptId());
//                    inoutPurchaseDto.setBuyAcceptListId(listDto.getBuyAcceptListId());
                    inoutPurchaseDto.setSourceListId(listDto.getSourceListId());
                    List<MesWmsStockinoutListVo> listVos = extMapper.queryPurchaseList(inoutPurchaseDto);
                    if (listVos.size() > 0) {
                        MesWmsStockinoutListVo mesWmsStockinoutListVo = listVos.get(0);
                        BeanUtils.copyProperties(mesWmsStockinoutListVo, list);
                    }
                } else {//?????????????????????
                    InoutPurchaseDto inoutPurchaseDto = new InoutPurchaseDto();
                    inoutPurchaseDto.setSourceListId(listDto.getSourceListId());
                    List<MesWmsStockinoutListVo> listVos = extMapper.queryProductionList(inoutPurchaseDto);
                    if (listVos.size() > 0) {
                        MesWmsStockinoutListVo mesWmsStockinoutListVo = listVos.get(0);
                        BeanUtils.copyProperties(mesWmsStockinoutListVo, list);
                    }
                }
            }
            //???????????????
            if (listDto.getSuppliarId() != null) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(listDto.getSuppliarId());
                List<StockOtherVo> stockOtherVos = otherMapper.querySuppliar(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    list.setSuppliarId(stockOtherVos.get(0).getId());
                    list.setSuppliarCode(stockOtherVos.get(0).getCode());
                    list.setSuppliarName(stockOtherVos.get(0).getName());
                }
            }

            //??????????????????
            MesWmsStockplace place = placeMapper.queryById(listDto.getStockPlaceId());
            //????????????
            List<MesWmsStockplacebindMaterialVo> materialVos = placeExtMapper.selectMaterial(listDto.getMaterialId());

            list.setStockInOutId(mesWmsStockinout.getId());
            if (!StringUtils.isEmpty(place)) {
                list.setStockPlaceCode(place.getStockPlaceCode());
                list.setStockPlaceName(place.getStockPlaceName());
                list.setStockId(place.getStockId());
                list.setStockName(place.getStockName());
                list.setStockCode(place.getStockCode());
            }

            if (materialVos.size() > 0) {
                MesWmsStockplacebindMaterialVo vo = materialVos.get(0);
                list.setMaterialCode(vo.getMaterialCode());
                list.setMaterialId(vo.getMaterialId());
                list.setMaterialShortName(vo.getMaterialShortName());
                list.setMaterialSpec(vo.getMaterialSpec());
                list.setUnitsId(vo.getUnitsId());
                list.setUnitsName(vo.getUnitsName());
            }

            list.setFFinished(listDto.getFPallet());
            list.setIsValid(CommonConstantUtils.NOT_DELETE);
            list.setStatus(CommonConstantUtils.STOCKINOUT_STATE_ONE);
            list.setInBatchNo(finalInBatchNo);
            list.setCreateId(dto.getCurrentloginId());
            list.setCreateName(dto.getCurrentloginName());
            list.setCreateTime(LocalDateTime.now());
            BeanUtils.copyProperties(userVo, mesWmsStockinout);
            listMapper.insert(list);
        });
        return ResultUtil.successPageInfo();
    }

    /**
     * ????????????????????????
     *
     * @param mesWmsStockinoutVo
     * @return
     */
    @Override
    public ResultVO queryPurchase(MesWmsStockinoutVo mesWmsStockinoutVo) {
        List<MesWmsStockinoutVo> vos = extMapper.queryPurchase(mesWmsStockinoutVo);
        vos.forEach(vo -> {
            InoutPurchaseDto dto = new InoutPurchaseDto();
//            dto.setBuyAcceptId(vo.getBuyAcceptId());
            dto.setSourceId(vo.getSourceId());
            List<MesWmsStockinoutListVo> listVos = extMapper.queryPurchaseList(dto);
            vo.setListVos(listVos);
        });
        return ResultVO.create().success(vos);
    }

}

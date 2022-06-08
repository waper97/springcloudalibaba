package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.dto.StockOutDto;
import com.bpm.mes.stock.common.dto.StockOutList;
import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.*;
import com.bpm.mes.stock.server.dto.*;
import com.bpm.mes.stock.server.mapper.base.*;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockOutExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockinoutExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockplaceExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockOutService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.util.NumAddUtil;
import com.bpm.mes.stock.server.vo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 仓库出入库主表(MesWmsStockinout)表服务实现类
 *
 * @author makejava
 * @since 2022-04-22 16:08:22
 */
@Service
public class MesWmsStockOutServiceImpl implements MesWmsStockOutService {

    @Resource
    private MesWmsStockinoutMapper mesWmsStockinoutMapper;
    @Resource
    private MesWmsStockinoutlistMapper listMapper;
    @Resource
    private MesWmsStockinoutbatchMapper batchMapper;
    @Resource
    private MesWmsStockinoutExtMapper extMapper;
    @Resource
    private MesWmsStockOutExtMapper outExtMapper;
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
    @Autowired
//    private QualityInClient qualityInClient;

    /**
     * 条件查询
     *
     * @param mesWmsStockinoutQueryDto 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MesWmsStockinoutQueryVo> queryAll(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto) {
//        MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
//        BeanUtils.copyProperties(mesWmsStockinoutQueryDto,mesWmsStockinout);
        List<MesWmsStockinoutQueryVo> mesWmsStockinoutList = outExtMapper.queryAll(mesWmsStockinoutQueryDto);
        return mesWmsStockinoutList;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResultVO queryById(Integer id) {
        return ResultVO.create().success(this.mesWmsStockinoutMapper.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param mesWmsStockinoutQueryDto 筛选条件
     * @return 查询结果
     */
    @Override
    public ResultVO<PageInfoVO<List<MesWmsStockinout>>> queryByPage(MesWmsStockinoutQueryDto mesWmsStockinoutQueryDto) {
//        MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
//        BeanUtils.copyProperties(mesWmsStockinoutQueryDto,mesWmsStockinout);
        PageHelper.startPage(mesWmsStockinoutQueryDto.getPageNum(), mesWmsStockinoutQueryDto.getPageSize());
//        List<MesWmsStockinout> mesWmsStockinoutList = this.mesWmsStockinoutMapper.queryAll(mesWmsStockinout);
        List<MesWmsStockinoutQueryVo> mesWmsStockinoutList = outExtMapper.queryAll(mesWmsStockinoutQueryDto);
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
     * 新增数据
     *
     * @param mesWmsStockinout 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO insert(MesWmsStockinout mesWmsStockinout) {
        if (this.mesWmsStockinoutMapper.insert(mesWmsStockinout) > 0) {
            return ResultVO.create().success("新增数据成功!");
        }
        return ResultVO.create().error("新增数据失败!");
    }

    /**
     * 修改数据
     *
     * @param mesWmsStockinout 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO update(MesWmsStockinout mesWmsStockinout) {
        if (this.mesWmsStockinoutMapper.update(mesWmsStockinout) > 0) {
            return ResultVO.create().success("数据编辑成功!");
        }
        return ResultVO.create().error("数据编辑失败!");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public ResultVO deleteById(Integer id) {
        if (this.mesWmsStockinoutMapper.deleteById(id) > 0) {
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 删除明细表主表
     *
     * @param id
     * @return
     */
    @Override
    public ResultVO deleteListById(Integer id) {
        if (this.listMapper.deleteById(id) > 0) {
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 查询收货订单明细信息
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
     * 出库
     *
     * @param batchDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addWarehousing(BatchDto batchDto) {
        MesWmsStockinoutlist list = listMapper.queryById(batchDto.getId());
        if (!StringUtils.isEmpty(list)) {
            //当前登录人信息
            UserVo userVo = otherMapper.queryCompany(batchDto.getCurrentloginId());

            //查询即时库存信息
            //即时库存主表信息存在
            MesWmsStockcurrentsum sum2 = new MesWmsStockcurrentsum();
            sum2.setStockCode(list.getStockCode());
            sum2.setMaterialCode(list.getMaterialCode());
            sum2.setIsValid(CommonConstantUtils.NOT_DELETE);
            List<MesWmsStockcurrentsum> mesWmsStockcurrentsums = sumMapper.queryAll(sum2);
            if (mesWmsStockcurrentsums.size() > 0) {
                MesWmsStockcurrentsum sum1 = mesWmsStockcurrentsums.get(0);
                //修改即时库存主表信息
                BigDecimal qty = sum1.getQty().subtract(list.getFFinished());
                if (qty.compareTo(new BigDecimal(0)) == 0) {
                    sum1.setIsValid(CommonConstantUtils.DELETE);
                }
                if (qty.compareTo(new BigDecimal(0)) == -1) {
                    return ResultUtil.error("出库数量不能大于实际数量！");
                }
                sum1.setQty(qty);
                sum1.setQtyUseable(qty);
                sumMapper.update(sum1);

                //修改主表状态
                MesWmsStockinout mesWmsStockinout = mesWmsStockinoutMapper.queryById(list.getStockInOutId());
                MesWmsStockinoutlist mesWmsStockinoutlist = new MesWmsStockinoutlist();
                mesWmsStockinoutlist.setStockInOutId(mesWmsStockinout.getId());
                List<MesWmsStockinoutlist> mesWmsStockinoutlists = listMapper.queryAll(mesWmsStockinoutlist);
                if (mesWmsStockinoutlists.size() == 1) {
                    mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_TEN);
                } else {
                    mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_NINE);
                }
                mesWmsStockinoutMapper.update(mesWmsStockinout);

                //修改明细表数据
                list.setStatus(CommonConstantUtils.STOCKINOUT_STATE_TEN);
//                list.setInBatchNo(current1.getInBatchNo());
//                list.setBatchNo(current1.getBatchNo());
                listMapper.update(list);

                //修改即时库存明细表信息
                MesWmsStockcurrent current2 = new MesWmsStockcurrent();
                current2.setStockCurrentSumId(sum1.getId());
                current2.setStockCode(sum1.getStockCode());
                if (list.getStockPlaceCode() != null) {
                    current2.setStockPlaceCode(list.getStockPlaceCode());
                }
                current2.setMaterialCode(list.getMaterialCode());
                current2.setIsValid(CommonConstantUtils.NOT_DELETE);
                List<MesWmsStockcurrent> mesWmsStockcurrents = currentMapper.queryAll(current2);
                BigDecimal finished = list.getFFinished();
                for (MesWmsStockcurrent current : mesWmsStockcurrents) {
                    //当出库库存大于实时库存且出库库存大于0
                    if ((finished.compareTo(current.getQty()) == 1) && (finished.compareTo(new BigDecimal(0)) == 1)) {
                        BigDecimal qtyNub = current.getQty();
                        //即时库存明细表信息-出库
                        current.setIsValid(CommonConstantUtils.DELETE);
                        current.setQty(new BigDecimal(0));
                        current.setQtyUseable(new BigDecimal(0));
                        current.setStockOutId(list.getStockInOutId());
                        current.setStockOutDetialId(list.getId());
                        currentMapper.update(current);


                        //生成出库批次信息
                        getStcokOutBatch(batchDto, list, userVo, mesWmsStockinout, current, qtyNub);

                        finished = finished.subtract(current.getQty());
                    }
                    //当出库存小于等于实时库存且出库库存大于0
                    if ((finished.compareTo(current.getQty()) < 1) && (finished.compareTo(new BigDecimal(0)) == 1)) {
                        //即时库存明细表信息-出库
                        if (finished.compareTo(current.getQty()) == 0) {
                            current.setIsValid(CommonConstantUtils.DELETE);
                        }
                        qty = current.getQty().subtract(finished);
                        current.setQtyUseable(qty);
                        current.setQty(qty);
                        current.setStockOutId(list.getStockInOutId());
                        current.setStockOutDetialId(list.getId());
                        currentMapper.update(current);

                        //入库
                        BigDecimal qtyNub = finished;
                        //生成出库批次信息
                        getStcokOutBatch(batchDto, list, userVo, mesWmsStockinout, current, qtyNub);

                        finished = new BigDecimal(0);
                    }
                }
                return ResultVO.create().success("出库成功!");
            }
            return ResultVO.create().error("此仓库不存在相关物料!");
        }
        return ResultVO.create().error("出库物料不存在，不能出库!");
    }

    private void getStcokOutBatch(BatchDto batchDto, MesWmsStockinoutlist list, UserVo userVo, MesWmsStockinout mesWmsStockinout, MesWmsStockcurrent current, BigDecimal qtyNub) {
        MesWmsStockinout inout = mesWmsStockinoutMapper.queryById(list.getStockInOutId());
        MesWmsStockinoutbatch batch = new MesWmsStockinoutbatch();
        BeanUtils.copyProperties(inout, batch);
        BeanUtils.copyProperties(list, batch);
        BeanUtils.copyProperties(userVo, batch);

        batch.setStockInOutId(mesWmsStockinout.getId());
        batch.setStockInOutCode(mesWmsStockinout.getStockInOutCode());
        batch.setStockInOutDetailId(list.getId());
        batch.setStockInId(current.getStockInId());
        MesWmsStockinout wmsStockinout = mesWmsStockinoutMapper.queryById(current.getStockInId());
        if (!StringUtils.isEmpty(wmsStockinout)) {
            batch.setStockInCode(wmsStockinout.getStockInOutCode());
        }
        batch.setStockInListId(current.getStockInDetialId());

        batch.setQty(qtyNub);
        batch.setStockInOutDetailId(list.getId());
        batch.setIsValid(CommonConstantUtils.NOT_DELETE);
        batch.setCreateId(batchDto.getCurrentloginId());
        batch.setCreateName(batchDto.getCurrentloginName());
        batch.setCreateTime(LocalDateTime.now());
        batch.setInBatchNo(current.getInBatchNo());
        batch.setBatchNo(current.getBatchNo());
        batch.setUpdateId(null);
        batch.setUpdateName(null);
        batch.setUpdateTime(null);
        batch.setState(CommonConstantUtils.STOCKINOUT_OUT);
        batchMapper.insert(batch);
    }

    /**
     * 发起检验
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO isCheck(StockTasksMainAddDto dto) {
        MesWmsStockinout mesWmsStockinout = mesWmsStockinoutMapper.queryById(dto.getId());
        MesWmsStockinoutlist inoutlist = new MesWmsStockinoutlist();
        inoutlist.setStockInOutId(mesWmsStockinout.getId());
        inoutlist.setIsValid(CommonConstantUtils.NOT_DELETE);
        List<MesWmsStockinoutlist> mesWmsStockinoutlists = listMapper.queryAll(inoutlist);
        if (mesWmsStockinoutlists.size() < 1) {
            return ResultUtil.error("明细不存在！");
        }
        for (MesWmsStockinoutlist list : mesWmsStockinoutlists) {
            //查询质检标准
            Integer qualityBillId = extMapper.queryQualityTasks(list.getMaterialCode(), dto.getOccasionsCode());
            if (qualityBillId == null) {
                return ResultUtil.error("质检标准不存在！");
            }
        }

        if (!mesWmsStockinout.getStatus().equals(CommonConstantUtils.STOCKINOUT_STATE_ONE)) {
            return ResultUtil.error("只有新建状态的才能发起检验！");
        }

        for (MesWmsStockinoutlist list : mesWmsStockinoutlists) {
            //查询质检标准
//            Integer qualityBillId = extMapper.queryQualityTasks(list.getMaterialCode(), dto.getOccasionsCode());
//            TasksMainAddDTO tasksMainAddDTO = new TasksMainAddDTO();
//            tasksMainAddDTO.setCreateId(dto.getCurrentloginId());
//            tasksMainAddDTO.setCreateName(dto.getCurrentloginName());
//            tasksMainAddDTO.setOccasionsCode(dto.getOccasionsCode());
//            tasksMainAddDTO.setMaterialCode(list.getMaterialCode());
//            tasksMainAddDTO.setMaterialName(list.getMaterialShortName());
//            tasksMainAddDTO.setSampleMaterialsCode(list.getMaterialCode());
//            tasksMainAddDTO.setSampleMaterialsId(list.getMaterialId());
//            tasksMainAddDTO.setSampleMaterialsCode(list.getMaterialCode());
//            tasksMainAddDTO.setSampleMaterialsName(list.getMaterialShortName());
//            tasksMainAddDTO.setQualityBillId(qualityBillId);
//            tasksMainAddDTO.setCheckTheOriginalId(list.getId());
//            tasksMainAddDTO.setCheckTheOriginalOrderNumber(mesWmsStockinout.getStockInOutCode());
//            tasksMainAddDTO.setCheckTheOriginalType(dto.getCheckTheOriginalType());
//            tasksMainAddDTO.setQualityTimePlan(new Date());
//            com.bpm.mes.quality.common.vo.ResultVO resultVO = qualityInClient.addPurchaseIn(tasksMainAddDTO);
//            if (!resultVO.getCode().equals(200)){
//                return ResultUtil.error("发起检验失败！");
//            }
        }
        mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_SIX);
        mesWmsStockinoutMapper.update(mesWmsStockinout);
        MesWmsStockinoutlist mesWmsStockinoutlist = new MesWmsStockinoutlist();
        mesWmsStockinoutlist.setStatus(CommonConstantUtils.STOCKINOUT_STATE_SIX);
        mesWmsStockinoutlist.setStockInOutId(dto.getId());
        //修改入库明细
        extMapper.editINOutList(mesWmsStockinoutlist);
        return ResultUtil.success("发起检验成功！");
    }

    /**
     * 新增生产出库
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addProductionOut(StockOutDto dto) {
        //当前登录人信息
        UserVo userVo = otherMapper.queryCompany(dto.getCreateId());
        //仓库信息
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

        //生产物料明细数据
        List<StockOutList> outLists = dto.getOutLists();
        //判断即时库存物料是否存在
        for (StockOutList outList : outLists) {
            MesWmsStockplace stockplace = placeMapper.queryById(outList.getStockPlaceId());
            if (StringUtils.isEmpty(stockplace)){
                return ResultUtil.error("仓库库位不存在！");
            }
            List<MesWmsStockplacebindMaterialVo> materialVos = placeExtMapper.selectMaterial(outList.getMaterialId());
            if (materialVos.size()<1 || StringUtils.isEmpty(materialVos)){
                return ResultUtil.error("物料不存在！");
            }
            MesWmsInouttype inouttype = new MesWmsInouttype();
            inouttype.setBillFlag(dto.getBillCode());
            List<MesWmsInouttype> mesWmsInouttypes = typeMapper.queryAll(inouttype);
            if (mesWmsInouttypes.size()<1 || StringUtils.isEmpty(mesWmsInouttypes)){
                return ResultUtil.error("入库类型不存在！");
            }
            //即时库存主表信息存在
            MesWmsStockcurrentsum stockcurrentsum = new MesWmsStockcurrentsum();
            stockcurrentsum.setStockCode(stockplace.getStockCode());
            stockcurrentsum.setMaterialId(outList.getMaterialId());
            stockcurrentsum.setIsValid(CommonConstantUtils.NOT_DELETE);
            List<MesWmsStockcurrentsum> mesWmsStockcurrentsums = sumMapper.queryAll(stockcurrentsum);
            if (mesWmsStockcurrentsums.size() < 1 || StringUtils.isEmpty(mesWmsStockcurrentsums)) {
                return ResultUtil.error("仓库库存物料不存在！");
            }

            //修改即时库存明细表信息
            MesWmsStockcurrent stockcurrent = new MesWmsStockcurrent();
            stockcurrent.setStockCurrentSumId(stockcurrentsum.getId());
            stockcurrent.setStockCode(stockcurrentsum.getStockCode());
            stockcurrent.setStockPlaceCode(stockplace.getStockPlaceCode());
            stockcurrent.setMaterialId(outList.getMaterialId());
            stockcurrent.setIsValid(CommonConstantUtils.NOT_DELETE);
            List<MesWmsStockcurrent> stockcurrents = currentMapper.queryAll(stockcurrent);
            if (stockcurrents.size() < 1 || StringUtils.isEmpty(stockcurrents)) {
                return ResultUtil.error("库位库存物料不存在！");
            }
            BigDecimal qty = stockcurrents.stream().map(currentList -> currentList.getQty() == null ? new BigDecimal(0) : currentList.getQty()).reduce(BigDecimal.ZERO, BigDecimal::add);
            //实际库存小于出库数量
            if (qty.compareTo(outList.getFPallet()) == -1) {
                return ResultUtil.error("库存物料数量不足！");
            }

        }

        //新增出入库主表
        MesWmsStockinout mesWmsStockinout = getStockOut(dto, userVo, stockId, stockCode, stockName);

        outLists.forEach(outList -> {
            //库位信息
            MesWmsStockplace stockplace = placeMapper.queryById(outList.getStockPlaceId());
            //物料信息
            List<MesWmsStockplacebindMaterialVo> materialVos = placeExtMapper.selectMaterial(outList.getMaterialId());
            MesWmsStockplacebindMaterialVo vo = materialVos.get(0);

            //新增出库明细
            MesWmsStockinoutlist list = getStcokOutLists(dto, userVo, mesWmsStockinout, outList, stockplace, vo);

            //判断即时库存明细物料存在不同批次信息
            //即时库存主表信息存在
            MesWmsStockcurrentsum stockcurrentsum = new MesWmsStockcurrentsum();
            stockcurrentsum.setStockCode(stockplace.getStockCode());
            stockcurrentsum.setMaterialId(outList.getMaterialId());
            stockcurrentsum.setIsValid(CommonConstantUtils.NOT_DELETE);
            List<MesWmsStockcurrentsum> mesWmsStockcurrentsums = sumMapper.queryAll(stockcurrentsum);
            MesWmsStockcurrentsum sum = mesWmsStockcurrentsums.get(0);
            //修改即时库存主表信息
            BigDecimal qty = sum.getQty().subtract(outList.getFFinished());
            if (qty.compareTo(new BigDecimal(0)) == 0) {
                sum.setIsValid(CommonConstantUtils.DELETE);
            }
            sum.setQty(qty);
            sum.setQtyUseable(qty);
            sumMapper.update(sum);

            //修改即时库存明细表信息
            MesWmsStockcurrent stockcurrent = new MesWmsStockcurrent();
            stockcurrent.setStockCurrentSumId(stockcurrentsum.getId());
            stockcurrent.setStockCode(stockcurrentsum.getStockCode());
            stockcurrent.setStockPlaceCode(stockplace.getStockPlaceCode());
            stockcurrent.setMaterialId(outList.getMaterialId());
            stockcurrent.setIsValid(CommonConstantUtils.NOT_DELETE);
            List<MesWmsStockcurrent> stockcurrents = currentMapper.queryAll(stockcurrent);
            BigDecimal finished = outList.getFFinished();
            for (MesWmsStockcurrent detail : stockcurrents) {
                //当出库库存大于实时库存且出库库存大于0
                if ((finished.compareTo(detail.getQty()) == 1) && (finished.compareTo(new BigDecimal(0)) == 1)) {
                    BigDecimal qtyNub = detail.getQty();
                    //即时库存明细表信息-出库
                    detail.setIsValid(CommonConstantUtils.DELETE);
                    detail.setQty(new BigDecimal(0));
                    detail.setQtyUseable(new BigDecimal(0));
                    detail.setStockOutId(mesWmsStockinout.getId());
                    detail.setStockOutDetialId(list.getId());
                    currentMapper.update(detail);

                    //生成出库批次信息
                    getBatch(userVo, mesWmsStockinout, outList, list, detail, qtyNub);

                    finished = finished.subtract(detail.getQty());
                }
                //当调拨库存小于等于实时库存且调拨库存大于0
                if ((finished.compareTo(detail.getQty()) < 1) && (finished.compareTo(new BigDecimal(0)) == 1)) {
                    //即时库存明细表信息-出库
                    if (finished.compareTo(detail.getQty()) == 0) {
                        detail.setIsValid(CommonConstantUtils.DELETE);
                    }
                    qty = detail.getQty().subtract(finished);
                    detail.setStockQty(qty);
                    detail.setQtyUseable(qty);
                    detail.setQty(qty);
                    detail.setStockOutId(mesWmsStockinout.getId());
                    detail.setStockOutDetialId(list.getId());
                    currentMapper.update(detail);

                    //入库
                    BigDecimal qtyNub = finished;
                    //生成出库批次信息
                    getBatch(userVo, mesWmsStockinout, outList, list, detail, qtyNub);

                    finished = new BigDecimal(0);
                }
            }
        });
        return ResultUtil.success("出库成功！");
    }

    /**
     * 查询批次信息
     * @param stockInOutId
     * @return
     */
    @Override
    public ResultVO queryBatchAll(Integer stockInOutId) {
        MesWmsStockinoutbatch batch = new MesWmsStockinoutbatch();
        batch.setStockInOutId(stockInOutId);
        List<MesWmsStockinoutbatch> batchs = batchMapper.queryAll(batch);
        return ResultUtil.success(batchs);
    }

    private void getBatch(UserVo userVo, MesWmsStockinout mesWmsStockinout, StockOutList outList, MesWmsStockinoutlist list, MesWmsStockcurrent detail, BigDecimal qtyNub) {
        MesWmsStockinoutbatch batch = new MesWmsStockinoutbatch();
        BeanUtils.copyProperties(mesWmsStockinout, batch);
        BeanUtils.copyProperties(list, batch);
        BeanUtils.copyProperties(userVo, batch);

        batch.setStockInOutId(mesWmsStockinout.getId());
        batch.setStockInOutCode(mesWmsStockinout.getStockInOutCode());
        batch.setStockInOutDetailId(list.getId());
        batch.setStockInId(detail.getStockInId());
        MesWmsStockinout wmsStockinout = mesWmsStockinoutMapper.queryById(detail.getStockInId());
        if (!StringUtils.isEmpty(wmsStockinout)) {
            batch.setStockInCode(wmsStockinout.getStockInOutCode());
        }

        batch.setSuppliarId(detail.getSuppliarId());
        batch.setSuppliarCode(detail.getSuppliarCode());
        batch.setSuppliarName(detail.getSuppliarName());

        batch.setStockInListId(detail.getStockInDetialId());
        batch.setQty(qtyNub);
        batch.setStockInOutDetailId(list.getId());
        batch.setIsValid(CommonConstantUtils.NOT_DELETE);
        batch.setCreateId(outList.getCreateId());
        batch.setCreateName(outList.getCreateName());
        batch.setCreateTime(LocalDateTime.now());
        batch.setInBatchNo(detail.getInBatchNo());
        batch.setBatchNo(detail.getBatchNo());
        batch.setUpdateId(null);
        batch.setUpdateName(null);
        batch.setUpdateTime(null);
        batch.setState(CommonConstantUtils.STOCKINOUT_OUT);
        batchMapper.insert(batch);
    }

    private MesWmsStockinoutlist getStcokOutLists(StockOutDto dto, UserVo userVo, MesWmsStockinout mesWmsStockinout,
                                                  StockOutList outList, MesWmsStockplace stockplace, MesWmsStockplacebindMaterialVo vo) {
        MesWmsStockinoutlist list = new MesWmsStockinoutlist();

        BeanUtils.copyProperties(outList, list);
        BeanUtils.copyProperties(userVo, list);

        list.setMaterialCode(vo.getMaterialCode());
        list.setMaterialId(vo.getMaterialId());
        list.setMaterialShortName(vo.getMaterialShortName());
        list.setMaterialSpec(vo.getMaterialSpec());
        list.setUnitsId(vo.getUnitsId());
        list.setUnitsName(vo.getUnitsName());

        list.setStockId(stockplace.getStockId());
        list.setStockCode(stockplace.getStockCode());
        list.setStockName(stockplace.getStockName());
        list.setStockPlaceId(stockplace.getId());
        list.setStockPlaceCode(stockplace.getStockPlaceCode());
        list.setStockPlaceName(stockplace.getStockPlaceName());

        list.setStockInOutId(mesWmsStockinout.getId());
        list.setIsValid(CommonConstantUtils.NOT_DELETE);
        list.setStatus(CommonConstantUtils.STOCKINOUT_STATE_TEN);
        list.setCreateTime(LocalDateTime.now());
        listMapper.insert(list);
        return list;
    }

    private MesWmsStockinout getStockOut(StockOutDto dto, UserVo userVo, Integer stockId, String stockCode, String stockName) {
        MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
        BeanUtils.copyProperties(dto, mesWmsStockinout);
        BeanUtils.copyProperties(userVo, mesWmsStockinout);
        mesWmsStockinout.setFrob(CommonConstantUtils.STOCKINOUT_FROB_BLUE);
        mesWmsStockinout.setInOutTypePropert(CommonConstantUtils.PROPERT_OUT);
        mesWmsStockinout.setStockId(stockId);
        mesWmsStockinout.setStockCode(stockCode);
        mesWmsStockinout.setStockName(stockName);

        MesWmsInouttype inouttype = new MesWmsInouttype();
        inouttype.setBillFlag(dto.getBillCode());
        List<MesWmsInouttype> mesWmsInouttypes = typeMapper.queryAll(inouttype);
        mesWmsStockinout.setInOutTypeId(mesWmsInouttypes.get(0).getId());
        mesWmsStockinout.setInOutTypeCode(mesWmsInouttypes.get(0).getInOutTypeCode());
        mesWmsStockinout.setInOutTypeName(mesWmsInouttypes.get(0).getInOutTypeName());

        //出库
        String inOutPropert = CommonConstantUtils.PROPERT_OUT;
        //查询出出库编码
        String recordCode = extMapper.queryInOutCode(inOutPropert);
        if (StringUtils.isEmpty(recordCode)) {
            mesWmsStockinout.setStockInOutCode(CommonConstantUtils.STOCKINOUTCODE_OUT);
        } else {
            mesWmsStockinout.setStockInOutCode(NumAddUtil.addOrderNum(recordCode, 11));
        }
        mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_TEN);
        mesWmsStockinout.setIsValid(CommonConstantUtils.NOT_DELETE);
        mesWmsStockinout.setCreateTime(LocalDateTime.now());
        mesWmsStockinoutMapper.insert(mesWmsStockinout);
        return mesWmsStockinout;
    }


    /**
     * 通过主键逻辑删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public ResultVO updateById(Integer id) {
        if (this.mesWmsStockinoutMapper.updateById(id) > 0) {
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 新增和编辑出库单
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEditIn(MesWmsStockOutDto dto) {
        MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
        MesWmsStock stock = stockMapper.queryById(dto.getStockId());
        //当前登录人信息
        UserVo userVo = otherMapper.queryCompany(dto.getCurrentloginId());
        if (dto.getId() == null) {
            BeanUtils.copyProperties(dto, mesWmsStockinout);
            BeanUtils.copyProperties(userVo, mesWmsStockinout);
            mesWmsStockinout.setFrob(CommonConstantUtils.STOCKINOUT_FROB_BLUE);
            mesWmsStockinout.setInOutTypePropert(CommonConstantUtils.PROPERT_OUT);
            //单据编号
            //入库
            String inOutPropert = CommonConstantUtils.PROPERT_OUT;
            //查询出入库编码
            String recordCode = extMapper.queryInOutCode(inOutPropert);
            if (StringUtils.isEmpty(recordCode)) {
                mesWmsStockinout.setStockInOutCode(CommonConstantUtils.STOCKINOUTCODE_OUT);
            } else {
                mesWmsStockinout.setStockInOutCode(NumAddUtil.addOrderNum(recordCode, 11));
            }
            //出入库类型
            MesWmsInouttype inouttype = typeMapper.queryById(dto.getInOutTypeId());
            if (!StringUtils.isEmpty(inouttype)) {
                mesWmsStockinout.setInOutTypeCode(inouttype.getInOutTypeCode());
                mesWmsStockinout.setInOutTypeName(inouttype.getInOutTypeName());
                mesWmsStockinout.setBillCode(inouttype.getBillFlag());
            }
            //供应商信息
            if (dto.getSuppliarId() != null) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getSuppliarId());
                List<StockOtherVo> stockOtherVos = otherMapper.querySuppliar(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setSuppliarId(stockOtherVos.get(0).getId());
                    mesWmsStockinout.setSuppliarCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setSuppliarName(stockOtherVos.get(0).getName());
                }
            }
            //查询仓库信息
            if (!StringUtils.isEmpty(stock)) {
                mesWmsStockinout.setStockId(stock.getId());
                mesWmsStockinout.setStockCode(stock.getStockCode());
                mesWmsStockinout.setStockName(stock.getStockName());
            }
            //部门信息
            if (dto.getDepartmentId() != null && !(CommonConstantUtils.INOUTTYPE_XOUT.equals(inouttype.getBillFlag()))) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getDepartmentId());
                List<StockOtherVo> stockOtherVos = otherMapper.queryDepartment(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setDepartmentId(stockOtherVos.get(0).getId());
                    mesWmsStockinout.setDepartmentCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setDepartmentName(stockOtherVos.get(0).getName());
                }
            }
            //客户信息
            if (dto.getClientId() != null && CommonConstantUtils.INOUTTYPE_XOUT.equals(inouttype.getBillFlag())) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getClientId());
                List<StockOtherVo> stockOtherVos = otherMapper.queryCustomer(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setClientId(stockOtherVos.get(0).getId());
                    mesWmsStockinout.setClientCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setClientName(stockOtherVos.get(0).getName());
                }
            }

            mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_ONE);
            mesWmsStockinout.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockinout.setCreateId(dto.getCurrentloginId());
            mesWmsStockinout.setCreateName(dto.getCurrentloginName());
            mesWmsStockinout.setCreateTime(LocalDateTime.now());

            mesWmsStockinoutMapper.insert(mesWmsStockinout);
        } else {
            MesWmsStockinout mesWmsStockinout1 = mesWmsStockinoutMapper.queryById(dto.getId());
            BeanUtils.copyProperties(mesWmsStockinout1, mesWmsStockinout);
            BeanUtils.copyProperties(dto, mesWmsStockinout);
            mesWmsStockinout.setFrob(CommonConstantUtils.STOCKINOUT_FROB_BLUE);
            //查询当前登录人基本信息：如公司等
//            UserVo userVos = otherMapper.queryCompany(dto.getCurrentloginId());
            //出入库类型
            MesWmsInouttype inouttype = typeMapper.queryById(dto.getInOutTypeId());
            if (!StringUtils.isEmpty(inouttype)) {
                mesWmsStockinout.setInOutTypeCode(inouttype.getInOutTypeCode());
                mesWmsStockinout.setInOutTypeName(inouttype.getInOutTypeName());
                mesWmsStockinout.setBillCode(inouttype.getBillFlag());
            }
            //供应商信息
            if (dto.getSuppliarId() != null) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getSuppliarId());
                List<StockOtherVo> stockOtherVos = otherMapper.querySuppliar(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setSuppliarCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setSuppliarName(stockOtherVos.get(0).getName());
                }
            }
            //查询仓库信息
            if (!StringUtils.isEmpty(stock)) {
                mesWmsStockinout.setStockCode(stock.getStockCode());
                mesWmsStockinout.setStockName(stock.getStockName());
            }

            //部门信息
            if (dto.getDepartmentId() != null && !(CommonConstantUtils.INOUTTYPE_XOUT.equals(inouttype.getBillFlag()))) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getDepartmentId());
                List<StockOtherVo> stockOtherVos = otherMapper.queryDepartment(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setDepartmentId(stockOtherVos.get(0).getId());
                    mesWmsStockinout.setDepartmentCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setDepartmentName(stockOtherVos.get(0).getName());
                }
            }
            //客户信息
            if (dto.getClientId() != null && CommonConstantUtils.INOUTTYPE_XOUT.equals(inouttype.getBillFlag())) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(dto.getClientId());
                List<StockOtherVo> stockOtherVos = otherMapper.queryCustomer(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    mesWmsStockinout.setClientId(stockOtherVos.get(0).getId());
                    mesWmsStockinout.setClientCode(stockOtherVos.get(0).getCode());
                    mesWmsStockinout.setClientName(stockOtherVos.get(0).getName());
                }
            }
            mesWmsStockinout.setStatus(CommonConstantUtils.STOCKINOUT_STATE_ONE);
            mesWmsStockinout.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockinout.setUpdateId(dto.getCurrentloginId());
            mesWmsStockinout.setUpdateName(dto.getCurrentloginName());
            mesWmsStockinout.setUpdateTime(LocalDateTime.now());
            mesWmsStockinoutMapper.edit(mesWmsStockinout);
            extMapper.deleteInOutList(mesWmsStockinout.getId());
        }

        dto.getListDtos().forEach(listDto -> {
            //查询库位信息
            MesWmsStockplace place = placeMapper.queryById(listDto.getStockPlaceId());
            //物料信息
            List<MesWmsStockplacebindMaterialVo> materialVos = placeExtMapper.selectMaterial(listDto.getMaterialId());

            MesWmsStockinoutlist list = new MesWmsStockinoutlist();
            BeanUtils.copyProperties(listDto, list);
            list.setStockInOutId(mesWmsStockinout.getId());

            //查询仓库信息
            if (!StringUtils.isEmpty(stock)) {
                list.setStockId(stock.getId());
                list.setStockCode(stock.getStockCode());
                list.setStockName(stock.getStockName());
            }

            //查询仓库库位信息
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
            BeanUtils.copyProperties(userVo, list);
            list.setFFinished(listDto.getFPallet());
            list.setIsValid(CommonConstantUtils.NOT_DELETE);
            list.setStatus(CommonConstantUtils.STOCKINOUT_STATE_ONE);
            list.setCreateId(dto.getCurrentloginId());
            list.setCreateName(dto.getCurrentloginName());
            list.setCreateTime(LocalDateTime.now());
            listMapper.insert(list);
        });
        return ResultVO.create().success("出库数据编辑成功!");
    }

    /**
     * 查询采购订单信息
     *
     * @param mesWmsStockinoutVo
     * @return
     */
    @Override
    public ResultVO queryPurchase(MesWmsStockinoutVo mesWmsStockinoutVo) {
        List<MesWmsStockinoutVo> vos = extMapper.queryPurchase(mesWmsStockinoutVo);
//        vos.forEach(vo -> {
//            InoutPurchaseDto dto = new InoutPurchaseDto();
//            dto.setBuyAcceptId(vo.getBuyAcceptId());
//            List<MesWmsStockinoutListVo> listVos = extMapper.queryPurchaseList(dto);
//            vo.setListVos(listVos);
//        });
        return ResultVO.create().success(vos);
    }
}

package com.bpm.server.service.impl;

import com.bpm.common.constant.CommonConstant;
import com.bpm.common.domain.DayPlanningDetail;
import com.bpm.common.dto.DayPlanningDTO;
import com.bpm.common.dto.DayPlanningInserOrUpdateDTO;
import com.bpm.common.dto.DayPlanningProductionReport;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.DayPlanningDetailVO;
import com.bpm.common.vo.DayPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.mes.stock.client.StockInClient;
import com.bpm.mes.stock.common.dto.StockInPurchaseDto;
import com.bpm.mes.stock.common.dto.StockInPurchaseListDto;
import com.bpm.mes.stock.common.dto.StockOutDto;
import com.bpm.mes.stock.common.dto.StockOutList;
import com.bpm.server.mapper.DayPlanningDetailMapper;
import com.bpm.server.mapper.DayPlanningMapper;
import com.bpm.server.service.DayPlanningService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 日生产计划 服务实现类
 * @author wangpeng
 * @since 2022-05-06 09:52:25
 */
@Service
public class DayPlanningServiceImpl implements DayPlanningService {
    @Resource
    private DayPlanningMapper dayPlanningMapper;

    @Resource
    private DayPlanningDetailMapper dayPlanningDetailMapper;

    @Resource
    private NumberUtil numberUtil;

    @Resource
    private StockInClient stockInClient;
        
    @Override
    public List<DayPlanningVO> queryAll(DayPlanningDTO dayPlanning) {
        return  this.dayPlanningMapper.queryAll(dayPlanning);
    }



    private List<DayPlanningVO> swichOne (DayPlanningDTO dayPlanning) {
        List<DayPlanningVO> dayPlanningList = new ArrayList<>();
        switch (dayPlanning.getProductType()) {
            case  CommonConstant.DAY_BROKEN_PLANNING :
                  dayPlanningList = listDayBrokenPlanning(dayPlanning);
                  break;

            case  CommonConstant.DAY_DOSING_TRANSPORT_PLANNING :
                  dayPlanningList = listDayDosingTransportPlanning(dayPlanning);
                  break;
                case  CommonConstant.DAY_VERTICAL_MILL_PRODUCT_PLANNING :
                  dayPlanningList = listDayVerticalMillProductPlanning(dayPlanning);
              break;

            case  CommonConstant.PRE_HOMOGENIZE_RECORD:
                 break;

            case  CommonConstant.POWDER_DOSING_PLANNING :
                dayPlanningList = listPowderDosingPlanning(dayPlanning);
                break;
            case  CommonConstant.HOMOGENIZE_RECORD:
                break;
            case  CommonConstant.PNEUMATIC_TRANSPORT_PLANNING:
                dayPlanningList = listPneumaticTransportPlanning(dayPlanning);
                break;
            case  CommonConstant.BUFFER_WAREHOUSE_GRANT_PLANNING:
                // TODO ;暂时不做
                break;
        }
        return dayPlanningList;
    }



    /**
     * 日破碎计划
     * @return
     */
    private  List<DayPlanningVO> listDayBrokenPlanning(DayPlanningDTO dayPlanning) {
        List<DayPlanningVO> list = dayPlanningMapper.queryAll(dayPlanning);
        if (list != null && list.size() > 0) {
            list.stream().forEach(f -> {
                f.setProcesseName("破碎计划");
                f.setDetailList(dayPlanningDetailMapper.listByDayplaningId(f.getId()));
            });
        }
        return list;
    }




    /**
     * 日配料输送计划
     * @return
     */
    private  List<DayPlanningVO> listDayDosingTransportPlanning(DayPlanningDTO dayPlanning) {
        List<DayPlanningVO> list = dayPlanningMapper.listDayDosingTransportPlanning(dayPlanning);
        if (list != null && list.size() > 0) {
            list.stream().forEach(f -> {
                f.setProcesseName("日配料输送计划");
                f.setDetailList(dayPlanningDetailMapper.listDayDosingTransportPlanningDetail(f.getId()));
            });
        }
        return list;
    }

    /**
     * 日立磨生产计划
     * @param dayPlanning
     * @return
     */
    private List<DayPlanningVO> listDayVerticalMillProductPlanning(DayPlanningDTO dayPlanning) {
        List<DayPlanningVO> list = dayPlanningMapper.listDayVerticalMillProductPlanning(dayPlanning);
        if (list != null && list.size() > 0) {
            list.stream().forEach(f -> {
                f.setProcesseName("日立磨生产计划");
                f.setDetailList(dayPlanningDetailMapper.listDayVerticalMillProductPlanning(f.getId()));
            });
        }
        return list;
    }


    /**
     * 粉料配料计划
     * @param dayPlanning
     * @return
     */
    private List<DayPlanningVO> listPowderDosingPlanning(DayPlanningDTO dayPlanning) {
        List<DayPlanningVO> list = dayPlanningMapper.listPowderDosingPlanning(dayPlanning);
        if (list != null && list.size() > 0) {
            list.stream().forEach(f -> {
                f.setProcesseName("粉料配料");
                f.setDetailList(dayPlanningDetailMapper.listPowderDosingPlanning(f.getId()));
            });
        }
        return list;
    }

    /**
     * 气力输送计划
     * @param dayPlanning
     * @return
     */
    private List<DayPlanningVO> listPneumaticTransportPlanning(DayPlanningDTO dayPlanning) {
        List<DayPlanningVO> list = dayPlanningMapper.listPneumaticTransportPlanning(dayPlanning);
        if (list != null && list.size() > 0) {
            list.stream().forEach(f -> {
                f.setProcesseName("粉料出库");
                f.setDetailList(dayPlanningDetailMapper.listPneumaticTransportPlanning(f.getId()));
            });
        }
        return list;
    }

 
    @Override
    public DayPlanningVO queryById(Integer id) {
        DayPlanningVO dayPlanningVO = this.dayPlanningMapper.queryById(id);
        if (dayPlanningVO != null) {
            List<DayPlanningDetailVO> detailList = dayPlanningDetailMapper.listByDayplaningId(id);
            if (detailList != null && detailList.size() > 0) {
                dayPlanningVO.setDetailList(detailList);
            }else{
                dayPlanningVO.setDetailList(new ArrayList<>());
            }
        }
        return dayPlanningVO;
    }

 
    @Override
    public PageInfoVO<DayPlanningVO> queryByPage(DayPlanningDTO dayPlanning) {
        PageHelper.startPage(dayPlanning.getPageNum(),dayPlanning.getPageSize());

        List<DayPlanningVO> dayPlanningList = swichOne(dayPlanning);
        PageInfo<DayPlanningVO> pageInfo = new PageInfo<>(dayPlanningList);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(DayPlanningInserOrUpdateDTO dayPlanning) {
        String planCode = numberUtil.contextLoads("DP");
        dayPlanning.setPlanCode(planCode);
        dayPlanning.setStatus(1);
        List<DayPlanningDetail> detailList = dayPlanning.getDetailList();
        boolean result = this.dayPlanningMapper.insert(dayPlanning) > 0;
        if (result) {
            if (detailList != null && detailList.size() > 0) {
                detailList.stream().forEach(element -> {
                    element.setDayPlanningId(dayPlanning.getId());
                    element.setStatus(0);
                ;});
                return dayPlanningDetailMapper.insertBatch(detailList) > 0;
            }
            return true;
        }
        return true;
    }

    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(DayPlanningInserOrUpdateDTO dayPlanning) {
        dayPlanning.setUpdateTime(LocalDateTime.now());
        boolean result =  this.dayPlanningMapper.updateSelective(dayPlanning) > 0;

        List<DayPlanningDetail> detailList = dayPlanning.getDetailList();
        if (result) {
            // 删除旧数据
            dayPlanningDetailMapper.deleteByDayPlanningId(dayPlanning.getId());
            if (detailList != null && !detailList.isEmpty()) {

                detailList.stream().forEach(f -> f.setDayPlanningId(dayPlanning.getId()));
               return  dayPlanningDetailMapper.insertBatch(detailList) >0 ;
           }
        }
        return result;
    }



    private void delete (DayPlanningInserOrUpdateDTO dayPlanning) {
        boolean result =  this.dayPlanningMapper.updateSelective(dayPlanning) > 0;

        List<DayPlanningDetail> detailList = dayPlanning.getDetailList();
        List<Integer> deleteList = new ArrayList<>();
        List<DayPlanningDetailVO> olderInfo = dayPlanningDetailMapper.listByDayplaningId(dayPlanning.getId());

        List<Integer> olderIdList = olderInfo.stream().map(DayPlanningDetail::getId).collect(Collectors.toList());
        List<Integer> newIdList = detailList.stream().map(DayPlanningDetail::getId).collect(Collectors.toList());

        if (result) {
            if (detailList != null && detailList.size() > 0) {
                detailList.stream().forEach(element -> {
                    if (element.getId() == null) {
                        dayPlanningDetailMapper.insert(element);
                    }else{
                        dayPlanningDetailMapper.update(element);
                    }
                });

                olderIdList.forEach(f ->{
                    if (!newIdList.contains(f)) {
                        deleteList.add(f);
                    }
                });
                deleteList.forEach(e -> dayPlanningDetailMapper.deleteById(e));
            }else{
                if (olderInfo != null && olderInfo.size() > 0) {
                    olderInfo.forEach(e -> dayPlanningDetailMapper.deleteById(e.getId()));
                }
            }
        }
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.dayPlanningMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.dayPlanningMapper.removeById(id) > 0;
    }

    @Override
    public ResultVO commonProductionReport(DayPlanningInserOrUpdateDTO dayPlanning) {
        // 主表
        StockOutDto stock = new StockOutDto();
        // 明细表
        StockOutList detail = new StockOutList();
        List<StockOutList> detailList = new ArrayList<>();
        dayPlanning.getDetailList().forEach(f ->{
            stock.setInOutTypePropert("1");
            stock.setInOutTypeId(1);
            stock.setStockId(1);
            stock.setSourceType("2");
            stock.setSourceId(dayPlanning.getId());
            stock.setSourceCode(dayPlanning.getPlanCode());
            stock.setCreateId(Integer.valueOf(dayPlanning.getCreateId()));
            stock.setCreateName(dayPlanning.getCreateName());
            stock.setRemark(f.getRemark());
            stock.setInoutDate(String.valueOf(LocalDate.now()));

            BigDecimal qty = dayPlanning.getDetailList().stream()
                    .map(currentList ->
                            currentList.getPlannedQuantity() == null ? new BigDecimal(0) : currentList.getPlannedQuantity())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            stock.setQty(qty);

            stock.setBillCode(CommonConstant.BIN);
            stock.setStockPlaceId(f.getBrokenStoneWarehouseId());
                detail.setMaterialId(f.getProductionId());
                detail.setStockId(f.getBrokenStoneWarehouseId());
                detail.setImportQty(f.getPlannedQuantity());
                detail.setFPallet(f.getPlannedQuantity());
                detail.setFFinished(f.getPlannedQuantity());
                detail.setStockQty(f.getPlannedQuantity());
                detail.setInvoiceQty(f.getPlannedQuantity());
                detail.setSourceType("2");
                detail.setSourceId(dayPlanning.getId());
                detail.setSourceCode(dayPlanning.getPlanCode());
                detail.setSourceListId(f.getId());
                detail.setCreateId(Integer.valueOf(f.getCreateId()));
                detail.setCreateName(f.getCreateName());
                detail.setRemark(f.getRemark());
                detail.setStockPlaceId(f.getBrokenStoneWarehouseId());
            detailList.add(detail);

        });
        stock.setOutLists(detailList);
        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionOut(stock);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());
    }

    @Override
    public ResultVO brokenOutStock(DayPlanningProductionReport productionReport) {
        if (productionReport == null || productionReport.getDayPlanningDetail() == null) {
            return ResultUtil.error("参数不能为空!");
        }
        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getDayPlanningId());
        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        StockOutDto stockOutDto =  commonOutStock(dayPlanningVO, dayPlanningDetail);
            if (dayPlanningDetail.getBrokenStoneWarehouseId() == null ) {
                return  ResultVO.create().error("碎石头仓不能为空!");
            }
            stockOutDto.setStockPlaceId(dayPlanningDetail.getBrokenStoneWarehouseId());
//            stockOutDto.setStockId(dayPlanningDetail.getBrokenStoneWarehouseId());
            stockOutDto.getOutLists().forEach(children -> {
                children.setStockPlaceId(dayPlanningDetail.getBrokenStoneWarehouseId());
//                children.setStockId(dayPlanningDetail.getBrokenStoneWarehouseId());
            });
        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionOut(stockOutDto);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());
    }

    @Override
    public ResultVO brokenInStock(DayPlanningProductionReport productionReport) {
        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getProductionId());
        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        StockInPurchaseDto purchaseDto= commonInStock(dayPlanningVO, dayPlanningDetail);
        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionIn(purchaseDto);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());
    }


    // new 出库
    private StockOutDto commonOutStock (DayPlanningVO dayPlanningVO,DayPlanningDetail dayPlanningDetail) {
        // 主表
        StockOutDto stock = new StockOutDto();
        // 明细表
        StockOutList detail = new StockOutList();
        List<StockOutList> detailList = new ArrayList<>();
            detail.setMaterialId(dayPlanningDetail.getProductionId());
    //      detail.setStockId(f.getBrokenStoneWarehouseId());
    //      detail.setStockPlaceId(f.getBrokenStoneWarehouseId());
            detail.setImportQty(dayPlanningDetail.getPlannedQuantity());
            detail.setFPallet(dayPlanningDetail.getPlannedQuantity());
            detail.setFFinished(dayPlanningDetail.getPlannedQuantity());
            detail.setStockQty(dayPlanningDetail.getPlannedQuantity());
            detail.setInvoiceQty(dayPlanningDetail.getPlannedQuantity());
            detail.setSourceType("2");
            detail.setSourceId(dayPlanningVO.getId());
            detail.setSourceCode(dayPlanningVO.getPlanCode());
            detail.setSourceListId(dayPlanningDetail.getId());
            detail.setCreateId(Integer.valueOf(dayPlanningDetail.getCreateId()));
            detail.setCreateName(dayPlanningDetail.getCreateName());
            detail.setRemark(dayPlanningDetail.getRemark());
        detailList.add(detail);
        stock.setInOutTypePropert("1");
            stock.setInOutTypeId(1);

            stock.setSourceType("2");
            stock.setSourceId(dayPlanningVO.getId());
            stock.setSourceCode(dayPlanningVO.getPlanCode());
            stock.setInoutDate(String.valueOf(LocalDate.now()));
            stock.setInoutPostingDate(String.valueOf(LocalDate.now()));
            stock.setCreateId(Integer.valueOf(dayPlanningVO.getCreateId()));

            stock.setCreateName(dayPlanningVO.getCreateName());
            stock.setRemark(dayPlanningDetail.getRemark());
            stock.setInoutPostingDate(String.valueOf(LocalDate.now()));

            BigDecimal qty = dayPlanningVO.getDetailList().stream()
                    .map(currentList ->
                            currentList.getPlannedQuantity() == null ? new BigDecimal(0) : currentList.getPlannedQuantity())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            stock.setQty(qty);
            stock.setBillCode(CommonConstant.BIN);
//          stock.setStockPlaceId(f.getBrokenStoneWarehouseId());
//          stock.setStockId(f.getBrokenStoneWarehouseId());
            stock.setOutLists(detailList);
        return stock;
    }

    // new 入库
    private StockInPurchaseDto commonInStock (DayPlanningVO dayPlanningVO,DayPlanningDetail dayPlanningDetail) {
        // 主表
        StockInPurchaseDto purchaseDto = new StockInPurchaseDto();
        // 明细表
        StockInPurchaseListDto detail = new StockInPurchaseListDto();
        List<StockInPurchaseListDto> detailList = new ArrayList<>();
            purchaseDto.setBillCode(CommonConstant.BIN);
            purchaseDto.setStockId(dayPlanningDetail.getPreGrindingBinId());
            purchaseDto.setSourceType("3");
            purchaseDto.setSourceId(dayPlanningVO.getId());
            purchaseDto.setSourceCode(dayPlanningVO.getPlanCode());
            purchaseDto.setCreateId(Integer.valueOf(dayPlanningVO.getCreateId()));
            purchaseDto.setCreateName(dayPlanningVO.getCreateName());
            purchaseDto.setCreateTime(LocalDateTime.now());
            purchaseDto.setRemark(dayPlanningVO.getRemark());
            purchaseDto.setInoutDate(String.valueOf(LocalDateTime.now()));
            purchaseDto.setInoutPostingDate(String.valueOf(LocalDateTime.now()));
            purchaseDto.setQty(dayPlanningDetail.getPlannedQuantity());
            purchaseDto.setInoutPostingDate(String.valueOf(LocalDate.now()));
                detail.setMaterialId(dayPlanningDetail.getProductionId());
                detail.setStockId(dayPlanningDetail.getPreGrindingBinId());
                detail.setImportQty(dayPlanningDetail.getPlannedQuantity());
                detail.setFPallet(dayPlanningDetail.getPlannedQuantity());
                detail.setStockQty(dayPlanningDetail.getPlannedQuantity());
                detail.setSourceType("2");
                detail.setSourceId(dayPlanningVO.getId());
                detail.setSourceCode(dayPlanningVO.getPlanCode());
                detail.setSourceListId(dayPlanningDetail.getId());
                detail.setCreateId(Integer.valueOf(dayPlanningDetail.getCreateId()));
                detail.setStockPlaceId(dayPlanningDetail.getPreGrindingBinId());
            detailList.add(detail);

        purchaseDto.setListDtos(detailList);
        return purchaseDto;
    }


    private StockOutDto buidlCommonOutStockPoductionReport (DayPlanningInserOrUpdateDTO dayPlanning) {
        // 主表
        StockOutDto stock = new StockOutDto();
        // 明细表
        StockOutList detail = new StockOutList();
        List<StockOutList> detailList = new ArrayList<>();
        dayPlanning.getDetailList().forEach(f ->{
            stock.setInOutTypePropert("1");
            stock.setInOutTypeId(1);
            stock.setStockId(1);
            stock.setSourceType("2");
            stock.setSourceId(dayPlanning.getId());
            stock.setSourceCode(dayPlanning.getPlanCode());
            stock.setCreateId(Integer.valueOf(dayPlanning.getCreateId()));
            stock.setCreateName(dayPlanning.getCreateName());
            stock.setRemark(f.getRemark());
            stock.setInoutDate(String.valueOf(LocalDate.now()));

            BigDecimal qty = dayPlanning.getDetailList().stream()
                    .map(currentList ->
                            currentList.getPlannedQuantity() == null ? new BigDecimal(0) : currentList.getPlannedQuantity())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            stock.setQty(qty);

            stock.setBillCode(CommonConstant.SOUT);
//            stock.setStockPlaceId(f.getBrokenStoneWarehouseId());
//            stock.setStockId(f.getBrokenStoneWarehouseId());
                detail.setMaterialId(f.getProductionId());
//                detail.setStockId(f.getBrokenStoneWarehouseId());
//                detail.setStockPlaceId(f.getBrokenStoneWarehouseId());
                detail.setImportQty(f.getPlannedQuantity());
                detail.setFPallet(f.getPlannedQuantity());
                detail.setFFinished(f.getPlannedQuantity());
                detail.setStockQty(f.getPlannedQuantity());
                detail.setInvoiceQty(f.getPlannedQuantity());
                detail.setSourceType("2");
                detail.setSourceId(dayPlanning.getId());
                detail.setSourceCode(dayPlanning.getPlanCode());
                detail.setSourceListId(f.getId());
                detail.setCreateId(Integer.valueOf(f.getCreateId()));
                detail.setCreateName(f.getCreateName());
                detail.setRemark(f.getRemark());

            detailList.add(detail);

        });
        stock.setOutLists(detailList);
        return stock;
    }
    private StockInPurchaseDto buidlCommonInStockPoductionReport (DayPlanningInserOrUpdateDTO dayPlanning) {
        // 主表
        StockInPurchaseDto purchaseDto = new StockInPurchaseDto();
        // 明细表
        StockInPurchaseListDto detail = new StockInPurchaseListDto();
        List<StockInPurchaseListDto> detailList = new ArrayList<>();
        dayPlanning.getDetailList().forEach(f ->{

            purchaseDto.setBillCode(CommonConstant.BIN);
            purchaseDto.setStockId(f.getPreGrindingBinId());
            purchaseDto.setSourceType("3");
            purchaseDto.setSourceId(dayPlanning.getId());
            purchaseDto.setSourceCode(dayPlanning.getPlanCode());
            purchaseDto.setCreateId(Integer.valueOf(dayPlanning.getCreateId()));
            purchaseDto.setCreateName(dayPlanning.getCreateName());
            purchaseDto.setCreateTime(LocalDateTime.now());
            purchaseDto.setRemark(dayPlanning.getRemark());
            purchaseDto.setInoutDate(String.valueOf(LocalDateTime.now()));
            purchaseDto.setInoutPostingDate(String.valueOf(LocalDateTime.now()));

            purchaseDto.setQty(f.getPlannedQuantity());
                detail.setMaterialId(f.getProductionId());
                detail.setStockId(f.getPreGrindingBinId());
                detail.setImportQty(f.getPlannedQuantity());
                detail.setFPallet(f.getPlannedQuantity());
                detail.setStockQty(f.getPlannedQuantity());
                detail.setSourceType("2");
                detail.setSourceId(dayPlanning.getId());
                detail.setSourceCode(dayPlanning.getPlanCode());
                detail.setSourceListId(f.getId());
                detail.setCreateId(Integer.valueOf(f.getCreateId()));
                detail.setStockPlaceId(f.getPreGrindingBinId());
            detailList.add(detail);
        });
        purchaseDto.setListDtos(detailList);
        return purchaseDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO dosingTransportOutStock(DayPlanningProductionReport productionReport) {
        if (productionReport == null || productionReport.getDayPlanningDetail() == null) {
            return ResultUtil.error("参数不能为空!");
        }
        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getDayPlanningId());
        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        StockOutDto stockOutDto =  commonOutStock(dayPlanningVO, dayPlanningDetail);
        if (dayPlanningDetail.getBrokenStoneWarehouseId() == null ) {
            return  ResultVO.create().error("碎石头仓不能为空!");
        }
        stockOutDto.setStockPlaceId(dayPlanningDetail.getBrokenStoneWarehouseId());
//            stockOutDto.setStockId(dayPlanningDetail.getBrokenStoneWarehouseId());
        stockOutDto.getOutLists().forEach(children -> {
            children.setStockPlaceId(dayPlanningDetail.getBrokenStoneWarehouseId());
//                children.setStockId(dayPlanningDetail.getBrokenStoneWarehouseId());
        });
        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionOut(stockOutDto);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO dosingTransportInStock(DayPlanningProductionReport productionReport) {
        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getDayPlanningId());
        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        StockInPurchaseDto purchaseDto =  commonInStock(dayPlanningVO, dayPlanningDetail);
            if (dayPlanningDetail.getPreGrindingBinId() == null ) {
                return  ResultVO.create().error("磨前仓不能为空!");
            }
            purchaseDto.setStockPlaceId(dayPlanningDetail.getSemiFinishedProductWarehouseId());
            purchaseDto.getListDtos().forEach(children -> {
                children.setStockPlaceId(dayPlanningDetail.getPreGrindingBinId());
            });

        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionIn(purchaseDto);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO dayVerticalMillProductPlanningOutStock(DayPlanningProductionReport productionReport) {

        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getDayPlanningId());
        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        if (productionReport == null || productionReport.getDayPlanningDetail() == null) {
            return ResultUtil.error("参数不能为空!");
        }

        StockOutDto stockOutDto =  commonOutStock(dayPlanningVO, dayPlanningDetail);
        if (dayPlanningDetail.getPreGrindingBinId() == null ) {
            return  ResultVO.create().error("磨前仓不能为空!");
        }
        stockOutDto.setStockPlaceId(dayPlanningDetail.getPreGrindingBinId());
//            stockOutDto.setStockId(dayPlanningDetail.getBrokenStoneWarehouseId());
        stockOutDto.getOutLists().forEach(children -> {
            children.setStockPlaceId(dayPlanningDetail.getPreGrindingBinId());
//                children.setStockId(dayPlanningDetail.getBrokenStoneWarehouseId());
        });
        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionOut(stockOutDto);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO dayVerticalMillProductPlanningIntStock(DayPlanningProductionReport productionReport) {
        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getDayPlanningId());
        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        if (productionReport == null || productionReport.getDayPlanningDetail() == null) {
            return ResultUtil.error("参数不能为空!");
        }
        StockOutDto stockOutDto =  commonOutStock(dayPlanningVO, dayPlanningDetail);
        if (dayPlanningDetail.getSemiFinishedProductWarehouseId() == null ) {
            return  ResultVO.create().error("半成品仓不能为空!");
        }
        stockOutDto.setStockPlaceId(dayPlanningDetail.getSemiFinishedProductWarehouseId());
        stockOutDto.getOutLists().forEach(children -> {
            children.setStockPlaceId(dayPlanningDetail.getSemiFinishedProductWarehouseId());
        });
        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionOut(stockOutDto);
        boolean result = resultVO.getCode().equals(200);

        return result ? ResultUtil.success() :  ResultUtil.error(resultVO.getMsg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO powderDosingProductionInStock(DayPlanningProductionReport productionReport) {
        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getDayPlanningId());
        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        StockInPurchaseDto purchaseDto =  commonInStock(dayPlanningVO, dayPlanningDetail);
        if (dayPlanningDetail.getPreGrindingBinId() == null ) {
            return  ResultVO.create().error("成品仓不能为空!");
        }
        purchaseDto.setStockPlaceId(dayPlanningDetail.getSemiFinishedProductWarehouseId());
        purchaseDto.getListDtos().forEach(children -> {
            children.setStockPlaceId(dayPlanningDetail.getPreGrindingBinId());
        });

        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionIn(purchaseDto);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO powderDosingProductionOutStock(DayPlanningProductionReport productionReport) {
//

        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getDayPlanningId());
        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        if (productionReport == null || productionReport.getDayPlanningDetail() == null) {
            return ResultUtil.error("参数不能为空!");
        }

        StockOutDto stockOutDto =  commonOutStock(dayPlanningVO, dayPlanningDetail);
        if (dayPlanningDetail.getFinishedProductWarehouseId() == null ) {
            return  ResultVO.create().error("半品仓不能为空!");
        }
        stockOutDto.setStockPlaceId(dayPlanningDetail.getSemiFinishedProductWarehouseId());
            stockOutDto.setStockId(dayPlanningDetail.getSemiFinishedProductWarehouseId());
        stockOutDto.getOutLists().forEach(children -> {
            children.setStockPlaceId(dayPlanningDetail.getSemiFinishedProductWarehouseId());
                children.setStockId(dayPlanningDetail.getSemiFinishedProductWarehouseId());
        });
        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionOut(stockOutDto);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO pneumaticTransportInStock(DayPlanningProductionReport productionReport) {
        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getDayPlanningId());
        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        StockInPurchaseDto purchaseDto =  commonInStock(dayPlanningVO, dayPlanningDetail);
        if (dayPlanningDetail.getReceivingWarehouseId() == null ) {
            return  ResultVO.create().error("接收仓不能为空!");
        }
        purchaseDto.setStockPlaceId(dayPlanningDetail.getReceivingWarehouseId());
        purchaseDto.getListDtos().forEach(children -> {
            children.setStockPlaceId(dayPlanningDetail.getReceivingWarehouseId());
        });
        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionIn(purchaseDto);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO pneumaticTransportOutStock(DayPlanningProductionReport productionReport) {
        DayPlanningVO dayPlanningVO = dayPlanningMapper.queryById(productionReport.getDayPlanningDetail().getId());



        DayPlanningDetail dayPlanningDetail = productionReport.getDayPlanningDetail();
        if (productionReport == null || productionReport.getDayPlanningDetail() == null) {
            return ResultUtil.error("参数不能为空!");
        }
        StockOutDto stockOutDto =  commonOutStock(dayPlanningVO, dayPlanningDetail);
        if (dayPlanningDetail.getSendOutWarehouseId() == null ) {
            return  ResultVO.create().error("发出仓不能为空!");
        }
        stockOutDto.setStockPlaceId(dayPlanningDetail.getSendOutWarehouseId());

        stockOutDto.getOutLists().forEach(children -> {
            children.setStockPlaceId(dayPlanningDetail.getSendOutWarehouseId());

        });
        com.bpm.mes.stock.common.vo.ResultVO resultVO = stockInClient.addProductionOut(stockOutDto);
        boolean result = resultVO.getCode().equals(200);
        return result ? ResultUtil.success() : ResultUtil.error(resultVO.getMsg());

    }

}

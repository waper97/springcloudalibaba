package com.bpm.server.service.impl;

import com.bpm.common.domain.DayMasterProductionPlaning;
import com.bpm.common.domain.DayMaterialRequirementsPlanning;
import com.bpm.common.domain.MasterProductionPlan;
import com.bpm.common.domain.MaterialRequirementsPlanning;
import com.bpm.common.dto.MaterialRequirementsPlanningDTO;
import com.bpm.common.dto.MrpDTO;
import com.bpm.common.vo.BillOfMaterialDetailVO;
import com.bpm.common.vo.BillOfMaterialVO;
import com.bpm.common.vo.MaterialRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.mes.purchase.dto.MesPurchaseBuyRequestInsertDTO;
import com.bpm.mes.purchase.dto.MesPurchaseBuyRequestListInsertDTO;
import com.bpm.mes.purchase.feign.PurchaseClient;
import com.bpm.server.mapper.*;
import com.bpm.server.service.MaterialRequirementsPlanningService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 物料需求计划 服务实现类
 *
 * @author wangpeng
 * @since 2022-04-25 11:36:58
 */
@Service
public class MaterialRequirementsPlanningServiceImpl implements MaterialRequirementsPlanningService {
    @Resource
    private MaterialRequirementsPlanningMapper materialRequirementsPlanningMapper;

    @Resource
    private NumberUtil numberUtil;

    @Resource
    private BillOfMaterialMapper billOfMaterialMapper;
    @Resource
    private BillOfMaterialDetailMapper billOfMaterialDetailMapper;
    @Resource
    private DayMasterProductionPlaningMapper dayMasterProductionPlaningMapper;
    @Resource
    private DayMaterialRequirementsPlanningMapper dayMaterialRequirementsPlanningMapper;


    @Autowired
    private PurchaseClient purchaseClient;

    @Override
    public List<MaterialRequirementsPlanningVO> queryAll(MaterialRequirementsPlanningDTO materialRequirementsPlanningDTO) {
        return this.materialRequirementsPlanningMapper.listMaterialRequirementsPlanning(materialRequirementsPlanningDTO);
    }
        
 
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MaterialRequirementsPlanning queryById(Integer id) {
        return this.materialRequirementsPlanningMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param materialRequirementsPlanningDTO 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<MaterialRequirementsPlanningVO> queryByPage(MaterialRequirementsPlanningDTO materialRequirementsPlanningDTO) {
        PageHelper.startPage(materialRequirementsPlanningDTO.getPageNum(),materialRequirementsPlanningDTO.getPageSize());

        List<MaterialRequirementsPlanningVO> materialRequirementsPlanningList = this.materialRequirementsPlanningMapper.listMaterialRequirementsPlanning(materialRequirementsPlanningDTO);
        PageInfo<MaterialRequirementsPlanningVO> pageInfo = new PageInfo<>(materialRequirementsPlanningList);
        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

    /**
     * 新增数据
     *
     * @param materialRequirementsPlanning 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(MaterialRequirementsPlanning materialRequirementsPlanning) {
        String planCode = numberUtil.contextLoads("QPR");
        materialRequirementsPlanning.setPlanCode(planCode);
        materialRequirementsPlanning.setCreateTime(LocalDateTime.now());
        materialRequirementsPlanning.setStatus(1);
        return this.materialRequirementsPlanningMapper.insert(materialRequirementsPlanning) > 0;
    }

    /**
     * 修改数据
     *
     * @param materialRequirementsPlanning 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(MaterialRequirementsPlanning materialRequirementsPlanning) {
        return this.materialRequirementsPlanningMapper.update(materialRequirementsPlanning) > 0 ;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.materialRequirementsPlanningMapper.deleteById(id) > 0;
    }
    
      /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.materialRequirementsPlanningMapper.removeById(id) > 0;
    }

    @Override
    public boolean updateStatusById(List<Integer> ids, Integer status) {
        for (Integer id : ids) {
            MaterialRequirementsPlanning plan = new MaterialRequirementsPlanning();
            plan.setId(id);
            plan.setStatus(status);
            materialRequirementsPlanningMapper.updateSelective(plan);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean issued(MaterialRequirementsPlanningDTO masterProductionPlan) {
        masterProductionPlan.getMaterialRequirementsPlanningList().forEach(f ->{
            MaterialRequirementsPlanning plan = new MaterialRequirementsPlanning();
            plan.setId(f.getId());
            plan.setStatus(3);
            materialRequirementsPlanningMapper.updateSelective(plan);
            addPurchaseNew(f);
        });
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean mrp(MrpDTO mrpDTO) {
        List<MasterProductionPlan> planList = mrpDTO.getMasterProductionPlanList();
        planList.stream().forEach(masterPlan ->{
            // bom
            BillOfMaterialVO bomByProductId = billOfMaterialMapper.getBomByProductId(masterPlan.getProductId());
            if (bomByProductId != null) {
                // bom详情
                List<BillOfMaterialDetailVO> billOfMaterialDetail = billOfMaterialDetailMapper.listProductBillOfMaterialDetailByProductBillOfMaterialId(bomByProductId.getId());
                    MaterialRequirementsPlanning materialRequirementsplanning = new MaterialRequirementsPlanning();
                    billOfMaterialDetail.forEach(f ->{
                        /**
                         * 公式：净需求量 = 毛需求/（1-损耗率[%]）- 现有库存 + 安全库存 - 预计入库量 + 已分配量
                         * immediatestock 现有库存
                         * safeStock 安全库存
                         * expectedReceipt 预计入库量
                         */
                        BigDecimal immediatestock = materialRequirementsPlanningMapper.sumImmediatestock(f.getProductId());
                        BigDecimal safeStock = materialRequirementsPlanningMapper.sumSafeStockByMaterialId(f.getProductId());
                        BigDecimal expectedReceipt = materialRequirementsPlanningMapper.sumExpectedReceiptMaterialId(f.getProductId());
                        BigDecimal one = new BigDecimal(1);
                        BigDecimal onehundred = new BigDecimal(100);

                        // 毛需求
                        BigDecimal netDemand = masterPlan.getQuantityGross();
                        //  考虑损耗率
                        if (mrpDTO.getIsRatioscrap().equals(1)) {
                            BigDecimal attritionRate = (one.subtract(f.getAttritionRate())).divide(onehundred);
                            if (attritionRate.compareTo(BigDecimal.ZERO) != 0) {
                                netDemand.divide(attritionRate);
                            }
                        }
                        // 考虑现有库存
                        if (mrpDTO.getIsConsiderNowInventory().equals(1)) {
                            if (immediatestock.compareTo(BigDecimal.ZERO) != 0) {
                                netDemand.subtract(immediatestock);
                            }
                        }
                        // 过滤掉为0的物料
                        if (mrpDTO.getIsFilterZeroMaterials().equals(1)) {}
                        // 考虑安全库存
                        if (mrpDTO.getIsConsiderSafeInventory().equals(1)) {
                            netDemand.add(safeStock);
                        }
                        netDemand.subtract(expectedReceipt);
                        materialRequirementsplanning.setDocumentType(String.valueOf(f.getMaterialPropertiesId()));
                        materialRequirementsplanning.setStockQuantity(immediatestock);
                        materialRequirementsplanning.setProductId(f.getProductId());
                    // 新增季度物料需求计划
                    boolean result = addMasterProductPlaning(materialRequirementsplanning, masterPlan, netDemand);
                    if (result) {
//                        MesPurchaseBuyRequestInsertDTO insertDTO = new MesPurchaseBuyRequestInsertDTO();
//                        // 新增采购申请单
//                        addPurchase(insertDTO, materialRequirementsplanning);
                    }
                });
            }
            if (planList != null && planList.size() > 0) {
                // 新增日主生产计划
//                addDayMasterProductionPlaning(planList);
            }
        });
        return true;
    }

    /**
     * 新增季度主生产计划
     * @param materialRequirementsplanning 季度物料需求计划
     * @param masterProductPlaning  季度主生产计划
     * @param planIntoQuantity 计划投入量
     * @return
     */
    public boolean addMasterProductPlaning (MaterialRequirementsPlanning materialRequirementsplanning, MasterProductionPlan masterProductPlaning, BigDecimal planIntoQuantity) {
        materialRequirementsplanning.setOperationCode(numberUtil.contextLoads("MRP"));
        materialRequirementsplanning.setOperationDate(LocalDateTime.now());
        materialRequirementsplanning.setProductId(materialRequirementsplanning.getProductId());
        materialRequirementsplanning.setMasterProductionPlanId(masterProductPlaning.getId());
        materialRequirementsplanning.setCreateTime(LocalDateTime.now());
        materialRequirementsplanning.setStatus(1);
        materialRequirementsplanning.setStartWorkingDate(masterProductPlaning.getStartWorkingDate());
        materialRequirementsplanning.setCompleteWorkingDate(masterProductPlaning.getCompleteWorkingDate());
        materialRequirementsplanning.setQuantityGross(planIntoQuantity);
        materialRequirementsplanning.setPlanIntoQuantity(planIntoQuantity);
        materialRequirementsplanning.setNetDemand(planIntoQuantity);
        materialRequirementsplanning.setDemandDate(LocalDateTime.now());
       return  materialRequirementsPlanningMapper.insert(materialRequirementsplanning) > 0;
    }



    /**
     * 新增采购申请单
     * @param insertDTO 采购申请单DTO
     * @param planning 物料需求计划实体类
     * @return
     */
    public boolean addPurchase (MesPurchaseBuyRequestInsertDTO insertDTO,MaterialRequirementsPlanning planning) {
        MesPurchaseBuyRequestListInsertDTO purchaseDetail = new MesPurchaseBuyRequestListInsertDTO();
        List<MesPurchaseBuyRequestListInsertDTO> list = new ArrayList<>();
        insertDTO.setBussinessType(1);
        insertDTO.setSourceType(2);
        insertDTO.setMrp(2);
        // 供应商信息
        Map<String, Object> supplierInfo = materialRequirementsPlanningMapper.getSupplierInfoByProductId(planning.getProductId());
            String supplierName = String.valueOf(supplierInfo.get("suppliername"));
            Integer supplierId = (Integer) supplierInfo.get("supplierid");
            String supplierCode = String.valueOf(supplierInfo.get("suppliercode"));

            if (supplierInfo != null) {
                insertDTO.setSupplierFullName(supplierName);
                insertDTO.setSupplierCode(supplierCode);
                insertDTO.setSupplierId(supplierId);
            }
            /*
             *采购订单详情
             */

            // localDateTime转date
            LocalDateTime instant = planning.getStartWorkingDate().plusDays(-2);
            Date startWorkingDate = Date.from(instant.atZone(ZoneId.systemDefault()).toInstant());
                purchaseDetail.setFetchDate(startWorkingDate);
                purchaseDetail.setQty(planning.getPlanIntoQuantity().doubleValue());
                purchaseDetail.setMaterialId(planning.getProductId());
                purchaseDetail.setPurchDate(startWorkingDate);
                // TODO：备货天数
                purchaseDetail.setChangeLeadTime("2");
                purchaseDetail.setSupplierFullName(supplierName);
                purchaseDetail.setSupplierId(supplierId);

            list.add(purchaseDetail);
        insertDTO.setList(list);
        purchaseClient.add(insertDTO);
        return true;
    }

    /**
     * 添加采购订单
     * @param planning
     * @return
     */
    public boolean addPurchaseNew (MaterialRequirementsPlanning planning) {
        MesPurchaseBuyRequestInsertDTO insertDTO = new MesPurchaseBuyRequestInsertDTO();
        MesPurchaseBuyRequestListInsertDTO purchaseDetail = new MesPurchaseBuyRequestListInsertDTO();
        List<MesPurchaseBuyRequestListInsertDTO> list = new ArrayList<>();
        insertDTO.setBussinessType(1);
        insertDTO.setSourceType(2);
        insertDTO.setMrp(2);
        // 供应商信息
        Map<String, Object> supplierInfo = materialRequirementsPlanningMapper.getSupplierInfoByProductId(planning.getProductId());
        String supplierName = String.valueOf(supplierInfo.get("suppliername"));
        Integer supplierId = (Integer) supplierInfo.get("supplierid");
        String supplierCode = String.valueOf(supplierInfo.get("suppliercode"));

        if (supplierInfo != null) {
            insertDTO.setSupplierFullName(supplierName);
            insertDTO.setSupplierCode(supplierCode);
            insertDTO.setSupplierId(supplierId);
        }
        /*
         *采购订单详情
         */

        // localDateTime转date
        LocalDateTime instant = planning.getStartWorkingDate().plusDays(-2);
        Date startWorkingDate = Date.from(instant.atZone(ZoneId.systemDefault()).toInstant());
        purchaseDetail.setFetchDate(startWorkingDate);
        purchaseDetail.setQty(planning.getPlanIntoQuantity().doubleValue());
        purchaseDetail.setMaterialId(planning.getProductId());
        purchaseDetail.setPurchDate(startWorkingDate);
        // TODO：备货天数
        purchaseDetail.setChangeLeadTime("2");
        purchaseDetail.setSupplierFullName(supplierName);
        purchaseDetail.setSupplierId(supplierId);

        list.add(purchaseDetail);
        insertDTO.setList(list);
        purchaseClient.add(insertDTO);
        return true;
    }

    /**
     * 获取当前月所有日期 eg: 5月的1到30号
     * @return
     */
    private  static  List<LocalDateTime> getMonthAllDate () {

        List<LocalDateTime> monthALLDate = new ArrayList<>();
        // 获取当月的总天数
        int currentMonthLength = LocalDate.now().lengthOfMonth();
        LocalDateTime nowTime = LocalDateTime.now();


        for (int i = 1; i <= currentMonthLength; i ++) {
            LocalDate now = LocalDate.now().withDayOfMonth(i);

            monthALLDate.add(now.atTime(LocalTime.from(nowTime)));
        }
        monthALLDate.forEach(System.out::println);
        return monthALLDate;
    }

    /**
     * 日主生产计划
     * @param planList
     * @return
     */
    public boolean addDayMasterProductionPlaning(List<MasterProductionPlan> planList) {
        List<DayMasterProductionPlaning> dayMasterProductionPlaningList = new ArrayList<>();
        DayMasterProductionPlaning day = new DayMasterProductionPlaning();

        planList.stream().forEach(masterPlan ->{
            LocalDate now = LocalDate.now();
            // 获取当月的总天数
            int currentMonthLength = LocalDate.now().lengthOfMonth();
            List<LocalDateTime> monthAllDate = getMonthAllDate();
            monthAllDate.stream().forEach(everyDay ->{
                now.with(TemporalAdjusters.firstDayOfMonth());
                day.setDocumentType("1");
                day.setProductId(masterPlan.getProductId());
                BigDecimal planIntoQuantity = masterPlan.getPlanIntoQuantity().divide(BigDecimal.valueOf(currentMonthLength),2, RoundingMode.HALF_UP);
                day.setPlanIntoQuantity(masterPlan.getPlanIntoQuantity().divide(BigDecimal.valueOf(currentMonthLength),2, RoundingMode.HALF_UP));
                day.setNetDemand(planIntoQuantity);
                day.setQuantityGross(planIntoQuantity);
                day.setOperationDate(LocalDateTime.now());
                day.setOperationCode(numberUtil.contextLoads("MPS"));
                day.setProductId(masterPlan.getProductId());
                day.setQuantitiesReceived(planIntoQuantity);
                day.setStartWorkingDate(everyDay);
                day.setCompleteWorkingDate(everyDay);
                day.setStatus(1);
                day.setCreateTime(LocalDateTime.now());
                day.setDemandDate(everyDay);
                boolean result = dayMasterProductionPlaningMapper.insert(day) > 0;
                if (result) {
                    addDayMaterialRequirementsPlanning(day);
                }
            });
        });
        return true;
    }

    /**
     * 新增日物料需求计划
     * @param dayMasterProductionPlaning
     * @return
     */
    public boolean addDayMaterialRequirementsPlanning (DayMasterProductionPlaning dayMasterProductionPlaning) {
        DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning = new DayMaterialRequirementsPlanning();
            dayMaterialRequirementsPlanning.setCode(numberUtil.contextLoads("DRP"));
            dayMaterialRequirementsPlanning.setDayMasterProductionPlaningId(dayMasterProductionPlaning.getId());
            dayMaterialRequirementsPlanning.setOperationCode(numberUtil.contextLoads("MRP"));
            dayMaterialRequirementsPlanning.setOperationDate(LocalDateTime.now());
            dayMaterialRequirementsPlanning.setProductId(dayMasterProductionPlaning.getProductId());
            dayMaterialRequirementsPlanning.setStartWorkingDate(dayMasterProductionPlaning.getStartWorkingDate());
            dayMaterialRequirementsPlanning.setCompleteWorkingDate(dayMasterProductionPlaning.getCompleteWorkingDate());
            dayMaterialRequirementsPlanning.setPlanIntoQuantity(dayMasterProductionPlaning.getPlanIntoQuantity());
            dayMaterialRequirementsPlanning.setQuantityGross(dayMasterProductionPlaning.getQuantityGross());
            // TODO:需求日期是什么
            dayMaterialRequirementsPlanning.setNetDemand(dayMasterProductionPlaning.getNetDemand());
            dayMaterialRequirementsPlanning.setPutDocumentType(dayMasterProductionPlaning.getDocumentType());
            dayMaterialRequirementsPlanning.setStartWorkingDate(LocalDateTime.now());
            dayMaterialRequirementsPlanning.setCreateTime(LocalDateTime.now());
            dayMaterialRequirementsPlanning.setStatus(1);
        return dayMaterialRequirementsPlanningMapper.insert(dayMaterialRequirementsPlanning) > 0;
    }

}




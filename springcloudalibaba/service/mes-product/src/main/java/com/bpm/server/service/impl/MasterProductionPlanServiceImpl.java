package com.bpm.server.service.impl;

import com.bpm.common.constant.CommonConstant;
import com.bpm.common.domain.*;
import com.bpm.common.dto.*;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.*;
import com.bpm.server.mapper.*;
import com.bpm.server.service.MasterProductionPlanService;
import com.bpm.server.service.ProcessRouteService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 主生产计划 服务实现类
 *
 * @author wangpeng
 * @since 2022-04-24 16:41:28
 */
@Service
public class MasterProductionPlanServiceImpl implements MasterProductionPlanService {
    @Resource
    private MasterProductionPlanMapper masterProductionPlanMapper;
    @Resource
    private BillOfMaterialMapper billOfMaterialMapper;
    @Resource
    private BillOfMaterialDetailMapper billOfMaterialDetailMapper;

    public static String PLAN_CODE = "MP";

    @Resource
    private DayMasterProductionPlaningMapper dayMasterProductionPlaningMapper;


    @Resource
    private DayMaterialRequirementsPlanningMapper dayMaterialRequirementsPlanningMapper;

    @Resource
    private MaterialRequirementsPlanningMapper materialRequirementsPlanningMapper;

    @Resource
    private MineralPowderRequirementsPlanningDetailMapper mineralPowderRequirementsPlanningDetailMapper;
    @Resource
    private MineralPowderRequirementsPlanningMapper mineralPowderRequirementsPlanningMapper;
    @Resource
    private DayMaterialRequirementsPlanningDetailMapper dayMaterialRequirementsPlanningDetailMapper;

    @Resource
    private ProcessRouteService processRouteService;
    @Resource
    private ProcessRouteMapper processRouteMapper;
    @Resource
    private ProcessRouteDetailMapper processRouteDetailMapper;

    @Resource
    private DayPlanningMapper dayPlanningMapper;

    @Resource
    private DayPlanningDetailMapper dayPlanningDetailMapper;

    @Resource
    private MesProductPrehomogenizationRecordMapper mesProductPrehomogenizationRecordMapper;

    @Resource
    private MesProductDayMineralArrivalOfTheDemandPlanningMapper dayMineralArrivalOfTheDemandPlanningMapper;


    @Resource
    private MesProductHomogenizationRecordMapper homogenizationRecordMapper;
    @Resource
    private MesProductPrehomogenizationRecordMapper prehomogenizationRecordMapper;
//    @Autowired
//    private PurchaseClient purchaseClient;

    @Autowired
    private NumberUtil numberUtil;

    @Override
    public List<MasterProductionPlanVO> queryAll(MasterProductionPlanDTO masterProductionPlanDTO) {
        return this.masterProductionPlanMapper.queryAll(masterProductionPlanDTO);
    }



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MasterProductionPlanVO queryById(Integer id) {
        return this.masterProductionPlanMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param masterProductionPlanDTO 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<MasterProductionPlanVO> queryByPage(MasterProductionPlanDTO masterProductionPlanDTO) {
        PageHelper.startPage(masterProductionPlanDTO.getPageNum(),masterProductionPlanDTO.getPageSize());

        List<MasterProductionPlanVO> masterProductionPlanList = this.masterProductionPlanMapper.queryAll(masterProductionPlanDTO);

        PageInfo<MasterProductionPlanVO> pageInfo = new PageInfo<>(masterProductionPlanList);
        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;

    }

    /**
     * 新增数据
     *
     * @param masterProductionPlan 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(MasterProductionPlanSaveOrUpdateDTO masterProductionPlan) {
        String planCode = numberUtil.contextLoads(PLAN_CODE);
        masterProductionPlan.setPlanCode(planCode);
        masterProductionPlan.setCreateTime(LocalDateTime.now());
        masterProductionPlan.setStatus(1);
        return this.masterProductionPlanMapper.insert(masterProductionPlan) > 0;
    }

    /**
     * 修改数据
     *
     * @param masterProductionPlan 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(MasterProductionPlanSaveOrUpdateDTO masterProductionPlan) {
        masterProductionPlan.setUpdateTime(LocalDateTime.now());
        return this.masterProductionPlanMapper.update(masterProductionPlan) > 0 ;
    }

    @Override
    public boolean updateStatusById(List<Integer> ids, Integer status) {

        for (Integer id : ids) {
            MasterProductionPlan plan = new MasterProductionPlan();
            plan.setId(id);
            plan.setStatus(status);
            masterProductionPlanMapper.updateStatusById(plan);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO issued(List<MasterProductionPlan> masterProductionPlanList) {

        for (MasterProductionPlan masterProductionPlan : masterProductionPlanList) {
            MasterProductionPlanVO older = masterProductionPlanMapper.queryById(masterProductionPlan.getId());
            if (older == null ) {
                return ResultUtil.error("主生产计划不存在!");
            }
            if (older.getStatus() == 1 ) {
                return ResultUtil.error("当前数据尚未审核，无法下发!");
            }
            if (older.getStatus() == 3 ) {
                return ResultUtil.error("当前数据已下发!");
            }

            MasterProductionPlan plan = new MasterProductionPlan();
            plan.setId(masterProductionPlan.getId());
            plan.setStatus(3);
            masterProductionPlanMapper.updateStatusById(plan);
        }
        // 新增日主生产计划
        boolean result = addDayMasterProductionPlaning(masterProductionPlanList);

        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.masterProductionPlanMapper.deleteById(id) > 0;
    }

      /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.masterProductionPlanMapper.deleteById(id) > 0;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO mps(PlanSchemeCalculateDTO planSchemeCalculate) {
        List<MineralPowderRequirementsPlanningToInsertOrUpdateDTO> mprPlanningList = planSchemeCalculate.getMineralPowderRequirementsPlanningList();
        List<BillOfMaterial> bomList = new ArrayList<>();


        // 已生成主生产计划的集合
        List<MineralPowderRequirementsPlanningDetail> alreadGenerateList = new ArrayList<>();
        // 将要生成主生产计划的集合
        List<MineralPowderRequirementsPlanningDetail> willGenerateList = new ArrayList<>();

        List<MineralPowderRequirementsPlanningDetail> mprInsertOrUpdateList = new ArrayList<>();
        if (mprPlanningList != null && mprPlanningList.size() > 0) {
            // 物料需求计划
            for (MineralPowderRequirementsPlanningToInsertOrUpdateDTO mprInsertOrUpdate: mprPlanningList) {
                // 物料需求计划详情
                for (MineralPowderRequirementsPlanningDetail mprPlanningDetail : mprInsertOrUpdate.getPlanningDetailList()) {
                    // 根据产品id获取bom数据
                    BillOfMaterial bom = billOfMaterialMapper.getBomByProductId(mprPlanningDetail.getProductId());
                    if (bom != null) {
                        bomList.add(bom);
                    }else{
                        ResultUtil.error("季度矿粉需求计划详情中的矿粉编号，在bom中不存在");
                    }

                    if (mprPlanningDetail != null && mprPlanningDetail.getIsMps().equals(0)) {
                        mprInsertOrUpdateList.add(mprPlanningDetail);
                        willGenerateList.add(mprPlanningDetail);
                    }else{
                        alreadGenerateList.add(mprPlanningDetail);
                    }

                }
            }
            if (bomList != null && bomList.size() >0) {
                if (bomList.size()  != mprInsertOrUpdateList.size()) {
                    return ResultUtil.error("该季度矿粉需求计划已经mps计算过了");
                }
            }else{
                return ResultUtil.error("bom清单中不包含物料需求计划详情的矿粉");
            }
            boolean result = addMasterProductPlan(mprInsertOrUpdateList);
            if (result) {
                MaterialRequirementsPlanning materialRequirementsPlanning = new MaterialRequirementsPlanning();
                // 修改季度矿粉需求计划状态为已生成
                mprPlanningList.forEach(f ->{
                    MineralPowderRequirementsPlanning mineralPowderRequirementsPlanning = new MineralPowderRequirementsPlanning();
                    mineralPowderRequirementsPlanning.setId(f.getId());
                    mineralPowderRequirementsPlanning.setStatus(3);
                    mineralPowderRequirementsPlanningMapper.update(mineralPowderRequirementsPlanning);

                });

            }
        }


        return ResultUtil.success();
    }

    /**
     * 添加主生产计划数据
     */

    private boolean addMasterProductPlan (List<MineralPowderRequirementsPlanningDetail> planningDetailList) {
        List<MasterProductionPlan>listMasterProductionPlan = new ArrayList<>();
        if (planningDetailList != null && planningDetailList.size() > 0) {
            planningDetailList.stream().forEach(f ->{
                // 生成主生产计划
                MasterProductionPlan  masterProductionPlan = new MasterProductionPlan();
                    String operationCode = numberUtil.contextLoads("MPS");
                    masterProductionPlan.setOperationCode(operationCode);
                    masterProductionPlan.setPlanCode(numberUtil.contextLoads(PLAN_CODE));
                    masterProductionPlan.setOperationDate(LocalDateTime.now());
                    masterProductionPlan.setCreateTime(LocalDateTime.now());
                    masterProductionPlan.setStatus(1);

                    masterProductionPlan.setProductId(f.getProductId());
                    masterProductionPlan.setPlanIntoQuantity(f.getPlanQuantity());
                    masterProductionPlan.setNetDemand(f.getPlanQuantity());
                    masterProductionPlan.setDemandDate(LocalDateTime.now());
                    masterProductionPlan.setQuantityGross(f.getPlanQuantity());
                    masterProductionPlan.setStartWorkingDate(f.getPlanDateBegin());
                    masterProductionPlan.setCompleteWorkingDate(f.getPlanDateEnd());
                    // 投放单据类型 数据字典，1生产
                    masterProductionPlan.setDocumentType("1");
                    // 库存量
                    masterProductionPlan.setStockQuantity(masterProductionPlanMapper.getInventoryByProductId(f.getProductId()));
                    masterProductionPlan.setMesProductMineralPowderRequirementsPlanningId(f.getMesProductMineralPowderRequirementsPlanningId());
                MineralPowderRequirementsPlanningDetail olderDetail = mineralPowderRequirementsPlanningDetailMapper.queryById(f.getId());
                boolean result = false;
                if (olderDetail != null && olderDetail.getIsMps().equals(0)) {
                     result = this.masterProductionPlanMapper.insert(masterProductionPlan) > 0;
                }
                // 修改状态为已生成
                if (result) {
                    MineralPowderRequirementsPlanningDetail detail = new MineralPowderRequirementsPlanningDetail();
                    detail.setId(f.getId());
                    detail.setIsMps(1);
                    mineralPowderRequirementsPlanningDetailMapper.update(detail);
                }
//                listMasterProductionPlan.add(masterProductionPlan);
//                addDayMasterProductionPlaning(listMasterProductionPlan);
            });
        }
       return true;
    }




    /**
     * 日主生产计划
     * @param planList
     * @return
     */
    public boolean addDayMasterProductionPlaning(List<MasterProductionPlan> planList) {
        DayMasterProductionPlaning day = new DayMasterProductionPlaning();
        planList.stream().forEach(masterPlan ->{
            LocalDate now = LocalDate.now();
            // 获取当月的总天数
            int currentMonthLength = LocalDate.now().lengthOfMonth();
            List<LocalDateTime> monthAllDate = numberUtil.getMonthAllDate();
            monthAllDate.stream().forEach(everyDay ->{
                now.with(TemporalAdjusters.firstDayOfMonth());
                day.setCode(numberUtil.contextLoads("ms"));
                day.setDocumentType("1");
                day.setProductId(masterPlan.getProductId());
                BigDecimal planIntoQuantity = masterPlan.getPlanIntoQuantity().divide(BigDecimal.valueOf(currentMonthLength),2,BigDecimal.ROUND_HALF_UP);
                day.setPlanIntoQuantity(masterPlan.getPlanIntoQuantity().divide(BigDecimal.valueOf(currentMonthLength),2,BigDecimal.ROUND_HALF_UP));
                day.setNetDemand(planIntoQuantity);
                day.setQuantityGross(planIntoQuantity);
                day.setProductId(masterPlan.getProductId());
                day.setQuantitiesReceived(planIntoQuantity);
                day.setStartWorkingDate(everyDay);
                day.setCompleteWorkingDate(everyDay);
                day.setStatus(1);
                day.setCreateTime(LocalDateTime.now());
                if (masterPlan.getOperationDate() != null) {
                    day.setOperationDate(masterPlan.getOperationDate());
                }
                if (masterPlan.getOperationCode() != null) {
                    day.setOperationCode(masterPlan.getOperationCode());
                }
                if (masterPlan.getCreateId() != null) {
                    day.setCreateId(masterPlan.getCreateId());
                }
                if (masterPlan.getCreateName() != null) {
                    day.setCreateName(masterPlan.getCreateName());
                }
                day.setDemandDate(everyDay);
                boolean result = dayMasterProductionPlaningMapper.insert(day) > 0;
                if (result) {
                    // 新增日计划
                    addDayPlanning(day);
                    // 新增日物料需求计划
                    addDayMaterialRequirementsPlanning(day,everyDay);
                    addDayMineralArrivalOfTheDemandPlanning(day,everyDay);
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
    public boolean addDayMaterialRequirementsPlanning (DayMasterProductionPlaning dayMasterProductionPlaning,LocalDateTime nowDay) {
        BillOfMaterialVO bomInfo = billOfMaterialMapper.getBomByProductId(dayMasterProductionPlaning.getProductId());
        List<BillOfMaterialDetailVO> detail = new ArrayList<>();
        if (bomInfo != null) {
            detail = billOfMaterialDetailMapper.listProductBillOfMaterialDetailByProductBillOfMaterialId(bomInfo.getId());
        }
        DayMaterialRequirementsPlanning dayMaterialRequirementsPlanning = new DayMaterialRequirementsPlanning();
        if (!CollectionUtils.isEmpty(detail)) {
            detail.forEach(f -> {
                dayMaterialRequirementsPlanning.setCode(numberUtil.contextLoads("DRP"));
                dayMaterialRequirementsPlanning.setDayMasterProductionPlaningId(dayMasterProductionPlaning.getId());
                dayMaterialRequirementsPlanning.setOperationCode(numberUtil.contextLoads("MRP"));
                dayMaterialRequirementsPlanning.setOperationDate(LocalDateTime.now());
                dayMaterialRequirementsPlanning.setProductId(dayMasterProductionPlaning.getProductId());
                dayMaterialRequirementsPlanning.setStartWorkingDate(dayMasterProductionPlaning.getStartWorkingDate());
                dayMaterialRequirementsPlanning.setCompleteWorkingDate(dayMasterProductionPlaning.getCompleteWorkingDate());
                dayMaterialRequirementsPlanning.setNeedDate(nowDay);
                BigDecimal one = new BigDecimal(1);
                BigDecimal attritionRate = f.getAttritionRate() !=null ? f.getAttritionRate().multiply(one) : new BigDecimal(0);
                //公式：  计划投入量/可制基数 x 比例
                dayMaterialRequirementsPlanning.setPlanIntoQuantity(
                        dayMasterProductionPlaning.getPlanIntoQuantity()
                                .divide(bomInfo.getCardinality(),BigDecimal.ROUND_HALF_UP)
                                .multiply(one.subtract(attritionRate))
                );
                dayMaterialRequirementsPlanning.setQuantityGross(dayMasterProductionPlaning.getQuantityGross());
                // TODO:需求日期是什么
                dayMaterialRequirementsPlanning.setNetDemand(dayMasterProductionPlaning.getNetDemand());
                dayMaterialRequirementsPlanning.setPutDocumentType(dayMasterProductionPlaning.getDocumentType());
                dayMaterialRequirementsPlanning.setStartWorkingDate(LocalDateTime.now());
                dayMaterialRequirementsPlanning.setCreateTime(LocalDateTime.now());
                dayMaterialRequirementsPlanning.setStatus(1);
                boolean result = dayMaterialRequirementsPlanningMapper.insert(dayMaterialRequirementsPlanning) > 0;
            });
        }else{
            System.out.println("bom详情为空!");
        }
       return true;
    }

    /**
     * 新增日矿石到到货需求计划
     * @return
     */
    public boolean addDayMineralArrivalOfTheDemandPlanning (DayMasterProductionPlaning dayMasterProductionPlaning,LocalDateTime nowDay) {
        //设置计划号
        MesProductDayMineralArrivalOfTheDemandPlanning arrivalOfTheDemandPlanning = new MesProductDayMineralArrivalOfTheDemandPlanning();
            arrivalOfTheDemandPlanning.setPlanCode("DRP" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
            arrivalOfTheDemandPlanning.setDayMasterProductPlaningId(dayMasterProductionPlaning.getId());
            arrivalOfTheDemandPlanning.setMaterialsId(dayMasterProductionPlaning.getProductId());
            arrivalOfTheDemandPlanning.setPlanArrivalQuantity(dayMasterProductionPlaning.getPlanIntoQuantity());
            arrivalOfTheDemandPlanning.setStatus(1);
            arrivalOfTheDemandPlanning.setCreateTime(new Date());
            arrivalOfTheDemandPlanning.setPlanType(1);
            arrivalOfTheDemandPlanning.setPlanCycle(1);
            if (dayMasterProductionPlaning.getCreateId() != null) {
                arrivalOfTheDemandPlanning.setCreateId(Integer.valueOf(dayMasterProductionPlaning.getCreateId()));
            }
            if (dayMasterProductionPlaning.getCreateName() != null) {
                arrivalOfTheDemandPlanning.setCreateName(dayMasterProductionPlaning.getCreateName());
            }
        // localDateTime转date
            LocalDateTime instant = nowDay;
            Date arriveTime = Date.from(instant.atZone(ZoneId.systemDefault()).toInstant());
            arrivalOfTheDemandPlanning.setArrivalTime(arriveTime);
            arrivalOfTheDemandPlanning.setArrivalOfTheDemandBeginDate(arriveTime);
            arrivalOfTheDemandPlanning.setArrivalOfTheDemandEndDate(arriveTime);
        return dayMineralArrivalOfTheDemandPlanningMapper.insert(arrivalOfTheDemandPlanning) > 0;
    }

    public boolean addDayPlanning (DayMasterProductionPlaning dayMasterProductPlaning) {
        ProcessRouteVO processRoute = processRouteMapper.getByProductId(dayMasterProductPlaning.getProductId());
        if (processRoute != null) {
            List<ProcessRouteDetail> detailList = processRouteDetailMapper.listByproductProcessRouteId(processRoute.getId());
            if (CollectionUtils.isNotEmpty(detailList)) {
                detailList.forEach(detail -> {
                    String processCoding = detail.getProcessCoding();
                    DayPlanningInserOrUpdateDTO dayPlanning = new DayPlanningInserOrUpdateDTO();
                    DayPlanningDetail dayPlanningDetail = new DayPlanningDetail();
                    dayPlanning.setCreateTime(LocalDateTime.now());
                    dayPlanning.setStatus(1);
                    dayPlanning.setPlanCode(numberUtil.contextLoads("DP"));
                    dayPlanning.setProductId(dayMasterProductPlaning.getProductId());
                    dayPlanning.setPlanDate(LocalDateTime.now());
                    dayPlanning.setPlanBeginTime(LocalDateTime.now());
                    dayPlanning.setPlanEndTime(LocalDateTime.now());
                        dayPlanningDetail.setPlannedQuantity(dayMasterProductPlaning.getPlanIntoQuantity());
                        dayPlanningDetail.setProductionId(dayPlanning.getProductId());
                        dayPlanning.setCreateTime(LocalDateTime.now());
                        dayPlanning.setStatus(1);
                    if (processCoding.equals(CommonConstant.BROKEN)) {
                        dayPlanning.setProductType(CommonConstant.BROKEN);
                        dayPlanningMapper.insert(dayPlanning);
                        dayPlanningDetail.setDayPlanningId(dayPlanning.getId());
                        dayPlanningDetailMapper.insert(dayPlanningDetail);
                    }  if (processCoding.equals(CommonConstant.DOSING_TRANSPORT)) {
                        dayPlanning.setProductType(CommonConstant.DOSING_TRANSPORT);
                        dayPlanningMapper.insert(dayPlanning);
                        dayPlanningDetail.setDayPlanningId(dayPlanning.getId());
                        dayPlanningDetailMapper.insert(dayPlanningDetail);
                    }  if (processCoding.equals(CommonConstant.VERTICAL_MILL_PRODUCT)) {
                        dayPlanning.setProductType(CommonConstant.VERTICAL_MILL_PRODUCT);
                        dayPlanningMapper.insert(dayPlanning);
                        dayPlanningDetail.setDayPlanningId(dayPlanning.getId());
                        dayPlanningDetailMapper.insert(dayPlanningDetail);
                    }  if (processCoding.equals(CommonConstant.PRE_HOMOGENIZE_RECORD_TYPE)) {
                        // 预均化
                        MesProductPrehomogenizationRecord record1 = new MesProductPrehomogenizationRecord();
                            record1.setCreateTime(new Date());
                            record1.setStatus(1);
                            //设置预均化记录记录号
                            record1.setPlanCode("Re" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
                            //设置预均化记录批次
                            record1.setBatch(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())));
                            record1.setMaterialId(dayMasterProductPlaning.getProductId());
                            record1.setProductionId(dayMasterProductPlaning.getProductId());
                            record1.setProcess(Integer.valueOf(CommonConstant.PRE_HOMOGENIZE_RECORD));
                        prehomogenizationRecordMapper.insert(record1);
                    }  if (processCoding.equals(CommonConstant.POWDER_DOSING)) {
                        dayPlanning.setProductType(CommonConstant.POWDER_DOSING);
                        dayPlanningMapper.insert(dayPlanning);
                        dayPlanningDetail.setDayPlanningId(dayPlanning.getId());
                        dayPlanningDetailMapper.insert(dayPlanningDetail);
                    }  if (processCoding.equals(CommonConstant.HOMOGENIZATION_BIN_HOMOGENIZATION)) {
                        //新增均化记录
                        MesProductHomogenizationRecord record = new MesProductHomogenizationRecord();
                        //设置均化记录记录号
                            record.setPlanCode("Re" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
                            //设置均化记录批次
                            record.setBatch(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())));
                            //设置均化记录状态 0已关闭 1新增
                            record.setStatus(1);
                            record.setProcess(Integer.valueOf(CommonConstant.HOMOGENIZE_RECORD));
                            record.setProductId(dayMasterProductPlaning.getProductId());
                        homogenizationRecordMapper.insert(record);
                    }  if (processCoding.equals(CommonConstant.PNEUMATIC_TRANSPORT)) {
                        dayPlanning.setProductType(CommonConstant.PNEUMATIC_TRANSPORT);
                        dayPlanningMapper.insert(dayPlanning);
                        dayPlanningDetail.setDayPlanningId(dayPlanning.getId());
                        dayPlanningDetailMapper.insert(dayPlanningDetail);
                    }  if (processCoding.equals(CommonConstant.LOADING_AND_DELIVERY)) {
                        dayPlanning.setProductType(CommonConstant.LOADING_AND_DELIVERY);
                        dayPlanningMapper.insert(dayPlanning);
                        dayPlanningDetail.setDayPlanningId(dayPlanning.getId());
                        dayPlanningDetailMapper.insert(dayPlanningDetail);
                    }
                });
            }
        }
//        DayPlanningInserOrUpdateDTO dayPlanning = new DayPlanningInserOrUpdateDTO();
//            dayPlanning.setCreateTime(LocalDateTime.now());
//            dayPlanning.setStatus(1);
//        dayPlanningMapper.insert(dayPlanning);
        return true;
    }

}


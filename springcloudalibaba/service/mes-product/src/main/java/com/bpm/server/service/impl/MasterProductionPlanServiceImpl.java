package com.bpm.server.service.impl;

import com.bpm.common.domain.*;
import com.bpm.common.dto.*;
import com.bpm.common.vo.BillOfMaterialVO;
import com.bpm.common.vo.MasterProductionPlanVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.BillOfMaterialMapper;
import com.bpm.server.mapper.MasterProductionPlanMapper;
import com.bpm.server.mapper.MaterialRequirementsPlanningMapper;
import com.bpm.server.mapper.MineralPowderRequirementsPlanningDetailMapper;
import com.bpm.server.service.MasterProductionPlanService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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

    public static String PLAN_CODE = "MP";

    @Resource
    private MaterialRequirementsPlanningMapper materialRequirementsPlanningMapper;

    @Resource
    private MineralPowderRequirementsPlanningDetailMapper mineralPowderRequirementsPlanningDetailMapper;

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
    public boolean mps(PlanSchemeCalculateDTO planSchemeCalculate) {
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
                        throw new RuntimeException("季度矿粉需求计划详情中的矿粉编号，在bom中不存在");
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
//                if (bomList.size()  != mprInsertOrUpdateList.size()) {
//                    throw new RuntimeException("季度矿粉需求计划详情中的矿粉编号，在bom中不存在");
//                }
            }else{
                throw new RuntimeException("bom清单中不包含物料需求计划详情的矿粉");
            }
            return mpsInsert(mprInsertOrUpdateList);
        }


        return true;
    }

    /**
     * 添加主生产计划数据
     */

    private boolean mpsInsert (List<MineralPowderRequirementsPlanningDetail> planningDetailList) {
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
                    masterProductionPlan.setQuantityGross(f.getPlanQuantity());
                    masterProductionPlan.setStartWorkingDate(f.getPlanDateBegin());
                    masterProductionPlan.setCompleteWorkingDate(f.getPlanDateEnd());
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
            });
        }
       return true;
    }

}


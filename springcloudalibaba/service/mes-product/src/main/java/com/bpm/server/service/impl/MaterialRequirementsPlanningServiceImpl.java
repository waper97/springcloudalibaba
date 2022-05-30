package com.bpm.server.service.impl;

import com.bpm.common.domain.MasterProductionPlan;
import com.bpm.common.domain.MaterialRequirementsPlanning;
import com.bpm.common.dto.MaterialRequirementsPlanningDTO;
import com.bpm.common.dto.MrpDTO;
import com.bpm.common.dto.PlanSchemeCalculateDTO;
import com.bpm.common.vo.BillOfMaterialDetailVO;
import com.bpm.common.vo.BillOfMaterialVO;
import com.bpm.common.vo.MaterialRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.BillOfMaterialDetailMapper;
import com.bpm.server.mapper.BillOfMaterialMapper;
import com.bpm.server.mapper.MaterialRequirementsPlanningMapper;
import com.bpm.server.service.MaterialRequirementsPlanningService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    public boolean mrp(MrpDTO mrpDTO) {
        List<MasterProductionPlan> planList = mrpDTO.getMasterProductionPlanList();

        planList.stream().forEach(plan ->{
            // bom
            BillOfMaterialVO bomByProductId = billOfMaterialMapper.getBomByProductId(plan.getProductId());
            if (bomByProductId != null) {
                // bom详情
                List<BillOfMaterialDetailVO> billOfMaterialDetail = billOfMaterialDetailMapper.listProductBillOfMaterialDetailByProductBillOfMaterialId(bomByProductId.getId());
                    MaterialRequirementsPlanning planning = new MaterialRequirementsPlanning();


                billOfMaterialDetail.forEach(f ->{
                    planning.setOperationCode(numberUtil.contextLoads("MRP"));
                    planning.setOperationDate(LocalDateTime.now());
                    planning.setProductId(plan.getProductId());
                    //  考虑损耗率
                    if (mrpDTO.getIsConsiderLoss().equals(1)) {

                    }
                    // 考虑现有库存
                    if (mrpDTO.getIsConsiderNowInventory().equals(1)) {

                    }
                    // 过滤掉为0的物料
                    if (mrpDTO.getIsFilterZeroMaterials().equals(1)) {

                    }
                    // 考虑安全库存
                    if (mrpDTO.getIsConsiderSafeInventory().equals(1)) {

                    }
                    //
                    BigDecimal one = new BigDecimal(1);


                    plan.getQuantityGross().divide(  (one.subtract(f.getAttritionRate()))  );


//                    planning.setPlanIntoQuantity();
//                    mprInsert(planning, plan);
                    // 即时库存
                    BigDecimal immediatestock = materialRequirementsPlanningMapper.sumImmediatestock(f.getProductId());
                    BigDecimal safeStock = materialRequirementsPlanningMapper.sumSafeStockBymaterialId(f.getProductId());

                    materialRequirementsPlanningMapper.insert(planning);
                });


            }


        });
        return false;
    }

    /**
     * 新增物料需求计划
     * @param planning 物料需求计划
     * @param masterProductionPlan 主生产计划
     * @return
     */
    public boolean mprInsert (MaterialRequirementsPlanning planning, MasterProductionPlan masterProductionPlan) {

        if (masterProductionPlan.getProductId() == 1) {
            planning.setStatus(1);
        }
       return true;

    }

}

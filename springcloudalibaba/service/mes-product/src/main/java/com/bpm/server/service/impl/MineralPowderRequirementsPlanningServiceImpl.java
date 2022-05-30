package com.bpm.server.service.impl;

import com.bpm.common.domain.MineralPowderRequirementsPlanning;
import com.bpm.common.domain.MineralPowderRequirementsPlanningDetail;
import com.bpm.common.dto.MineralPowderRequirementsPlanningDTO;
import com.bpm.common.dto.MineralPowderRequirementsPlanningToInsertOrUpdateDTO;
import com.bpm.common.vo.MineralPowderRequirementsPlanningDetailVO;
import com.bpm.common.vo.MineralPowderRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.MineralPowderRequirementsPlanningDetailMapper;
import com.bpm.server.mapper.MineralPowderRequirementsPlanningMapper;
import com.bpm.server.service.MineralPowderRequirementsPlanningService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 矿粉需求计划(MineralPowderRequirementsPlanning)表服务实现类
 *
 * @author wangpeng
 * @since 2022-04-24 09:39:00
 */
@Service
public class MineralPowderRequirementsPlanningServiceImpl implements MineralPowderRequirementsPlanningService {
    @Resource
    private MineralPowderRequirementsPlanningMapper mineralPowderRequirementsPlanningMapper;
    @Resource
    private MineralPowderRequirementsPlanningDetailMapper mineralPowderRequirementsPlanningDetailMapper;

    @Autowired
    private NumberUtil numberUtil;

    @Override
    public List<MineralPowderRequirementsPlanningVO> queryAll(MineralPowderRequirementsPlanningDTO mineralPowderRequirementsPlanningDTO) {
        List<MineralPowderRequirementsPlanningVO> list = this.mineralPowderRequirementsPlanningMapper.queryAll(mineralPowderRequirementsPlanningDTO);
        if (list != null && list.size() > 0) {
            list.stream().forEach(f ->{
                f.setPlanningDetailList(mineralPowderRequirementsPlanningDetailMapper.getByMineralPowderRequirementsPlanningId(f.getId()));
            });
        }
        return list;
    }
        
 
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MineralPowderRequirementsPlanning queryById(Integer id) {
        return this.mineralPowderRequirementsPlanningMapper.queryById(id);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MineralPowderRequirementsPlanningVO getById(Integer id) {
        MineralPowderRequirementsPlanning mineralPowderRequirementsPlanning = mineralPowderRequirementsPlanningMapper.queryById(id);
        MineralPowderRequirementsPlanningVO mineralPowderRequirementsPlanningVO = new MineralPowderRequirementsPlanningVO();
        if (mineralPowderRequirementsPlanning != null) {
            BeanUtils.copyProperties(mineralPowderRequirementsPlanning, mineralPowderRequirementsPlanningVO);
            List<MineralPowderRequirementsPlanningDetailVO> planningDetailList =   mineralPowderRequirementsPlanningDetailMapper.getByMineralPowderRequirementsPlanningId(id);
            mineralPowderRequirementsPlanningVO.setPlanningDetailList(planningDetailList);
        }
        return mineralPowderRequirementsPlanningVO;
    }


    /**
     * 分页查询
     *
     * @param mineralPowderRequirementsPlanningDTO 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<MineralPowderRequirementsPlanningVO> queryByPage(MineralPowderRequirementsPlanningDTO mineralPowderRequirementsPlanningDTO) {
        PageHelper.startPage(mineralPowderRequirementsPlanningDTO.getPageNum(),mineralPowderRequirementsPlanningDTO.getPageSize());


        List<MineralPowderRequirementsPlanningVO> mineralPowderRequirementsPlanningList = this.mineralPowderRequirementsPlanningMapper.queryAll(mineralPowderRequirementsPlanningDTO);
        mineralPowderRequirementsPlanningList.stream().forEach(f -> {
            List<MineralPowderRequirementsPlanningDetailVO> detailList = mineralPowderRequirementsPlanningDetailMapper.getByMineralPowderRequirementsPlanningId(f.getId());
            f.setPlanningDetailList(detailList);
        });
        PageInfo<MineralPowderRequirementsPlanningVO> pageInfo = new PageInfo<>(mineralPowderRequirementsPlanningList);
        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

    /**
     * 新增数据
     *
     * @param mineralPowderRequirementsPlanning 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(MineralPowderRequirementsPlanningToInsertOrUpdateDTO mineralPowderRequirementsPlanning) {
        String code = numberUtil.contextLoads("QRP");
        mineralPowderRequirementsPlanning.setPlanCode(code);
        boolean result = this.mineralPowderRequirementsPlanningMapper.insert(mineralPowderRequirementsPlanning) > 0;
        if (result) {
            List<MineralPowderRequirementsPlanningDetail> planningDetailList = mineralPowderRequirementsPlanning.getPlanningDetailList();

            if (planningDetailList !=null && planningDetailList.size() > 0) {
                planningDetailList.stream().forEach(element -> {
                    element.setMesProductMineralPowderRequirementsPlanningId(mineralPowderRequirementsPlanning.getId());
                });
                return  mineralPowderRequirementsPlanningDetailMapper.insertBatch(planningDetailList) > 0;
            }
        }
        return false;
    }

    /**
     * 修改数据
     *
     * @param mineralPowderRequirementsPlanning 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(MineralPowderRequirementsPlanningToInsertOrUpdateDTO mineralPowderRequirementsPlanning) {
       boolean result = this.mineralPowderRequirementsPlanningMapper.update(mineralPowderRequirementsPlanning) > 0;
       if (result) {
           List<MineralPowderRequirementsPlanningDetail> planningDetailList = mineralPowderRequirementsPlanning.getPlanningDetailList();
           List<Integer> newIdList = planningDetailList.stream().map(MineralPowderRequirementsPlanningDetail::getId).collect(Collectors.toList());
           List<MineralPowderRequirementsPlanningDetailVO> olderList = mineralPowderRequirementsPlanningDetailMapper.getByMineralPowderRequirementsPlanningId(mineralPowderRequirementsPlanning.getId());

           List<Integer> deleteList = new ArrayList<>();

           if (planningDetailList != null && planningDetailList.size() > 0) {
               planningDetailList.stream().forEach(element -> {
                   if (element.getId() != null) {
                       mineralPowderRequirementsPlanningDetailMapper.update(element);
                   }else{
                       element.setMesProductMineralPowderRequirementsPlanningId(mineralPowderRequirementsPlanning.getId());
                       mineralPowderRequirementsPlanningDetailMapper.insert(element);
                   }
               });
           }
           if (newIdList != null && newIdList.size() > 0) {
               for (MineralPowderRequirementsPlanningDetailVO older : olderList) {
                   if (!newIdList.contains(older.getId())) {
                       deleteList.add(older.getId());
                   }
                   deleteList.forEach(f ->  mineralPowderRequirementsPlanningDetailMapper.deleteById(older.getId()));
               }

           }else{
               olderList.forEach(f -> mineralPowderRequirementsPlanningDetailMapper.deleteById(f.getId()));
           }
       }

        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.mineralPowderRequirementsPlanningMapper.deleteById(id) > 0;
    }
    
      /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.mineralPowderRequirementsPlanningMapper.removeById(id) > 0;
    }
    
}

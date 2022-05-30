package com.bpm.server.service.impl;

import com.bpm.common.domain.DayMineralPowderRequirementsPlanning;
import com.bpm.common.domain.DayMineralPowderRequirementsPlanningDetail;
import com.bpm.common.dto.DayMineralPowderRequirementsPlanningDTO;
import com.bpm.common.dto.DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO;
import com.bpm.common.vo.DayMineralPowderRequirementsPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.DayMineralPowderRequirementsPlanningDetailMapper;
import com.bpm.server.mapper.DayMineralPowderRequirementsPlanningMapper;
import com.bpm.server.service.DayMineralPowderRequirementsPlanningService;
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
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 日矿粉需求计划 服务实现类
 *
 * @author wangpeng
 * @since 2022-04-26 09:45:14
 */
@Service
public class DayMineralPowderRequirementsPlanningServiceImpl implements DayMineralPowderRequirementsPlanningService {
    @Resource
    private DayMineralPowderRequirementsPlanningMapper dayMineralPowderRequirementsPlanningMapper;
    @Resource
    private DayMineralPowderRequirementsPlanningDetailMapper dayMineralPowderRequirementsPlanningDetailMapper;
    @Autowired
    private NumberUtil numberUtil;

    @Override
    public List<DayMineralPowderRequirementsPlanningVO> queryAll(DayMineralPowderRequirementsPlanningDTO dayMineralPowderRequirementsPlanningDTO) {
        List<DayMineralPowderRequirementsPlanningVO> list = this.dayMineralPowderRequirementsPlanningMapper.queryAll(dayMineralPowderRequirementsPlanningDTO);

        if (list != null && list.size() > 0) {
            list.forEach(f ->{
                f.setDayMineralPowderRequirementsPlanningDetailList(dayMineralPowderRequirementsPlanningDetailMapper.listByPowderRequirementsPlanningId(f.getId()));
            });
        }
        return this.dayMineralPowderRequirementsPlanningMapper.queryAll(dayMineralPowderRequirementsPlanningDTO);
    }
        
 
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DayMineralPowderRequirementsPlanning queryById(Integer id) {
        return this.dayMineralPowderRequirementsPlanningMapper.queryById(id);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DayMineralPowderRequirementsPlanningVO getById(Integer id) {
        DayMineralPowderRequirementsPlanningVO byId = this.dayMineralPowderRequirementsPlanningMapper.getById(id);
        if (byId != null) {
            final List<DayMineralPowderRequirementsPlanningDetail> detailList = dayMineralPowderRequirementsPlanningDetailMapper.listByPowderRequirementsPlanningId(id);
            boolean result = detailList != null && detailList.size() > 0;
            byId.setDayMineralPowderRequirementsPlanningDetailList(result ? detailList : new ArrayList<>());
        }
        return byId;

    }

    /**
     * 分页查询
     *
     * @param dayMineralPowderRequirementsPlanningDTO 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<DayMineralPowderRequirementsPlanningVO> queryByPage(DayMineralPowderRequirementsPlanningDTO dayMineralPowderRequirementsPlanningDTO) {
        PageHelper.startPage(dayMineralPowderRequirementsPlanningDTO.getPageNum(),dayMineralPowderRequirementsPlanningDTO.getPageSize());
        List<DayMineralPowderRequirementsPlanningVO> list = this.dayMineralPowderRequirementsPlanningMapper.queryAll(dayMineralPowderRequirementsPlanningDTO);

        if (list != null && list.size() > 0) {
            list.forEach(f ->{
                f.setDayMineralPowderRequirementsPlanningDetailList(dayMineralPowderRequirementsPlanningDetailMapper.listByPowderRequirementsPlanningId(f.getId()));
            });
        }

        PageInfo<DayMineralPowderRequirementsPlanningVO> pageInfo = new PageInfo<>(list);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

    /**
     * 新增数据
     *
     * @param planning 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO planning) {
        String planCode = numberUtil.contextLoads("DRP");
        planning.setPlanCode(planCode);
         boolean result = this.dayMineralPowderRequirementsPlanningMapper.insert(planning) > 0;
         if (result) {
             List<DayMineralPowderRequirementsPlanningDetail> detailList = planning.getDayMineralPowderRequirementsPlanningDetailList();
             boolean isEmpty = detailList != null && detailList.size() > 0;
             if (isEmpty) {
                 detailList.stream().forEach(f -> f.setDayMineralPowderRequirementsPlanningId(planning.getId()));
                 return dayMineralPowderRequirementsPlanningDetailMapper.insertBatch(detailList) > 0;
             }
             return true;
         }
         return false;
    }

    /**
     * 修改数据
     *
     * @param dayMineralPowderRequirementsPlanning 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(DayMineralPowderRequirementsPlanningToInsertOrUpdateDTO dayMineralPowderRequirementsPlanning) {
        boolean result = this.dayMineralPowderRequirementsPlanningMapper.update(dayMineralPowderRequirementsPlanning) > 0;
        List<DayMineralPowderRequirementsPlanningDetail> olderData = dayMineralPowderRequirementsPlanningDetailMapper.listByPowderRequirementsPlanningId(dayMineralPowderRequirementsPlanning.getId());

        if (result) {
            // 详情
            List<DayMineralPowderRequirementsPlanningDetail> detailList = dayMineralPowderRequirementsPlanning.getDayMineralPowderRequirementsPlanningDetailList();
            boolean isEmpty = detailList != null && detailList.size() > 0;
            if (isEmpty) {
                return insertOrUpdateBatch(detailList, dayMineralPowderRequirementsPlanning.getId());
            }else{
                if (olderData != null && olderData.size() > 0) {
                    olderData.stream().forEach(element -> dayMineralPowderRequirementsPlanningDetailMapper.deleteById(element.getId()));
                }
            }
            return true;
        }
        return false;
    }
    /**
     * 批量新增或修改
     * @param detailList 子集
     * @param planId 计划id
      */
    private boolean  insertOrUpdateBatch (List<DayMineralPowderRequirementsPlanningDetail> detailList, Integer planId) {
        List<DayMineralPowderRequirementsPlanningDetail> olderData = dayMineralPowderRequirementsPlanningDetailMapper.listByPowderRequirementsPlanningId(planId);
        List<Integer> oldIdList = olderData.stream().map(DayMineralPowderRequirementsPlanningDetail::getId).collect(Collectors.toList());
        List<Integer> newerIdList =  detailList.stream().map(DayMineralPowderRequirementsPlanningDetail::getId).collect(Collectors.toList());
        List<Integer> deleteList =  new ArrayList<>();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,10,100, TimeUnit.SECONDS,new LinkedBlockingDeque<>()
        );
//        threadPoolExecutor.execute(() ->{
            System.out.println("线程名称:"+Thread.currentThread().getName());
            oldIdList.stream().forEach(older ->{
                if (!newerIdList.contains(older)) {
                    deleteList.add(older);
                }
            });
            if (deleteList != null && detailList.size() > 0) {
                deleteList.stream().forEach(f ->dayMineralPowderRequirementsPlanningDetailMapper.deleteById(f) );
            }
            for (DayMineralPowderRequirementsPlanningDetail detail : detailList) {
                if (detail.getId() == null) {
                    dayMineralPowderRequirementsPlanningDetailMapper.insert(detail);
                }else{
                    dayMineralPowderRequirementsPlanningDetailMapper.update(detail);
                }
            }

//        });

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
        return this.dayMineralPowderRequirementsPlanningMapper.deleteById(id) > 0;
    }
    
      /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.dayMineralPowderRequirementsPlanningMapper.removeById(id) > 0;
    }
    
}

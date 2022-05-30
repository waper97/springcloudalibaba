package com.bpm.server.service.impl;

import com.bpm.common.constant.CommonConstant;
import com.bpm.common.domain.DayPlanning;
import com.bpm.common.domain.DayPlanningDetail;
import com.bpm.common.dto.DayPlanningDTO;
import com.bpm.common.dto.DayPlanningDetailDTO;
import com.bpm.common.dto.DayPlanningInserOrUpdateDTO;
import com.bpm.common.vo.DayPlanningDetailVO;
import com.bpm.common.vo.DayPlanningVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.DayPlanningDetailMapper;
import com.bpm.server.mapper.DayPlanningMapper;
import com.bpm.server.service.DayPlanningService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    @Autowired
    private NumberUtil numberUtil;
        
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
                    element.setStatus(1);
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
    
}

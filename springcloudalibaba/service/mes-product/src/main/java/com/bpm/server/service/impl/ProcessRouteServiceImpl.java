package com.bpm.server.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.bpm.common.domain.ProcessRoute;
import com.bpm.common.domain.ProcessRouteDetail;
import com.bpm.common.domain.ProcessRouteTypeEnum;
import com.bpm.common.dto.ProcessRouteDTO;
import com.bpm.common.dto.ProcessRouteDetailDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ProcessRouteDetailVO;
import com.bpm.common.vo.ProcessRouteProcceTypeVO;
import com.bpm.common.vo.ProcessRouteVO;
import com.bpm.server.mapper.ProcessRouteDetailMapper;
import com.bpm.server.mapper.ProcessRouteMapper;
import com.bpm.server.service.ProcessRouteService;
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
import java.util.stream.Stream;

/**
 * 工艺路线主表
 * (ProcessRouteDTO)表服务实现类
 *
 * @author wangpeng
 * @since 2022-04-18 15:31:13
 */
@Service
public class ProcessRouteServiceImpl implements ProcessRouteService {
    @Resource
    private ProcessRouteMapper processRouteMapper;

    @Resource
    private ProcessRouteDetailMapper processRouteDetailMapper;


    @Autowired
    NumberUtil numberUtil;

    @Override
    public List<ProcessRouteVO> queryAll(ProcessRouteDTO mesProductProcessRoute) {
        return this.processRouteMapper.queryAll(mesProductProcessRoute);
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProcessRoute queryById(Integer id) {
        return this.processRouteMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param mesProductProcessRoute 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<ProcessRouteVO> queryByPage(ProcessRouteDTO mesProductProcessRoute) {
        PageHelper.startPage(mesProductProcessRoute.getPageNum(), mesProductProcessRoute.getPageSize());
        List<ProcessRouteVO> processRouteList = this.processRouteMapper.queryAll(mesProductProcessRoute);
        processRouteList.forEach( f -> {
           f.setProductProcessRouteDetailList( processRouteDetailMapper.listByProcessRouteId(f.getId()));
        });
        PageInfo<ProcessRouteVO> pageInfo = new PageInfo<>(processRouteList);
        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;

    }

    /**
     * 新增数据
     *
     * @param processRoute 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(ProcessRouteVO processRoute) {

        String tileText = "1000";
        String code =  numberUtil.contextLoads(tileText)+ "_"+processRoute.getVersionNumber();
        processRoute.setProcessCode(code);
        boolean result = this.processRouteMapper.insert(processRoute) > 0;
        List<ProcessRouteDetailVO> detailList = processRoute.getProductProcessRouteDetailList();
        boolean  isEmpty = processRoute.getProductProcessRouteDetailList() != null && processRoute.getProductProcessRouteDetailList().size() > 0;
        if (result) {
            if (isEmpty) {
                detailList.forEach(f -> {
                    f.setMesProductProcessRouteId(processRoute.getId());});
                return processRouteDetailMapper.insertBatch(detailList) > 0;
            }
            return true;
        }
        return false;
    }

    /**
     * 修改数据
     *
     * @param processRoute 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(ProcessRouteVO processRoute) {
        boolean result = this.processRouteMapper.update(processRoute) > 0;


        List<ProcessRouteDetailVO> newDetailList = processRoute.getProductProcessRouteDetailList();
        List<ProcessRouteDetail> deleteList = new ArrayList<>();

        // 获取工艺路线详情 子集
        ProcessRouteDetailDTO detailDTO = new ProcessRouteDetailDTO();
        detailDTO.setMesProductProcessRouteId(processRoute.getId());
        //
        List<ProcessRouteDetail> olderDetailList = processRouteDetailMapper.queryAll(detailDTO);;
        List<Integer> newIdList = newDetailList.stream().map(ProcessRouteDetail::getId).collect(Collectors.toList());


        if (result) {

            newDetailList.stream().forEach(f -> {
                if (f.getId() == null){
                    // 新增
                    f.setMesProductProcessRouteId(processRoute.getId());
                    processRouteDetailMapper.insert(f);
                }else{
                    // 修改
                    processRouteDetailMapper.update(f);
                }
            });
            for ( ProcessRouteDetail old : olderDetailList) {
                if (!newIdList.contains(old.getId())) {
                    deleteList.add(old);
                }
            }
            // 删除
            deleteList.forEach(f -> {
                processRouteDetailMapper.deleteById(f.getId());
            });


            return true;
        }
        return false;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.processRouteMapper.deleteById(id) > 0;
    }

    /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.processRouteMapper.removeById(id) > 0;
    }

//    /**
//     * 根据工艺路线id获取工艺路线详情
//     *
//     * @param processRouteId
//     * @return
//     */
//    @Override
//    public List<ProcessRouteDetail> listProcessRouteDetailByProcessRouteId(String processRouteId) {
//        return processRouteMapper.listProcessRouteDetailByProcessRouteId(processRouteId);
//    }

    /**
     * 根据工艺路线id获取工艺路线详情(分页)
     *
     * @param mesProductProcessRouteDetail
     * @return
     */
    @Override
    public PageInfo<ProcessRouteDetailVO> listProcessRouteDetailByProcessRouteId(ProcessRouteDetailDTO mesProductProcessRouteDetail) {
        PageHelper.startPage(mesProductProcessRouteDetail.getPageNum(), mesProductProcessRouteDetail.getPageSize());
        List<ProcessRouteDetailVO> list = processRouteMapper.listProcessRouteDetailByProcessRouteId(mesProductProcessRouteDetail.getMesProductProcessRouteId());
        PageInfo<ProcessRouteDetailVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 根据工艺路线id获取工艺路线详情
     *
     * @param productProcessRouteId
     * @return
     */
    @Override
    public ProcessRouteVO listProcessRouteDetailByProcessRouteId(Integer productProcessRouteId) {
        ProcessRouteVO productProcessRouteVO = new ProcessRouteVO();
        // 工艺路线主表信息
        ProcessRoute productProcessRoute = processRouteMapper.queryById(productProcessRouteId);

        if (productProcessRoute != null) {
            BeanUtil.copyProperties(productProcessRoute, productProcessRouteVO);
            // 工艺路线从表信息
            List<ProcessRouteDetailVO> processRouteDetailList = processRouteMapper.listProcessRouteDetailByProcessRouteId(productProcessRouteId);
            if (processRouteDetailList != null && !processRouteDetailList.isEmpty()) {
                productProcessRouteVO.setProductProcessRouteDetailList(new ArrayList<>());
                 productProcessRouteVO.getProductProcessRouteDetailList().addAll(processRouteDetailList);
            }else{
                productProcessRouteVO.setProductProcessRouteDetailList(new ArrayList<>());
            }
            return productProcessRouteVO;
        }
        return null;
    }

    /**
     * 批量新增 批量添加工艺路线详情信息
     *
     * @param processRouteDetailList
     * @return
     */
    @Override
    public boolean batchSaveProceessRouteDetail(List<ProcessRouteDetailVO> processRouteDetailList) {
        return processRouteDetailMapper.insertBatch(processRouteDetailList) > 0;

    }

    @Override
    public List<ProcessRouteProcceTypeVO> listProceessRouteType() {
        List<ProcessRouteProcceTypeVO> collect = Stream.of(
            new ProcessRouteProcceTypeVO().setName(ProcessRouteTypeEnum.BROKEN.getName()).setValue(ProcessRouteTypeEnum.BROKEN.getValue()),
            new ProcessRouteProcceTypeVO().setName(ProcessRouteTypeEnum.DOSING_TRANSPORT.getName()).setValue(ProcessRouteTypeEnum.DOSING_TRANSPORT.getValue()),
            new ProcessRouteProcceTypeVO().setName(ProcessRouteTypeEnum.VERTICAL_MILL_PRODUCT.getName()).setValue(ProcessRouteTypeEnum.VERTICAL_MILL_PRODUCT.getValue()),
            new ProcessRouteProcceTypeVO().setName(ProcessRouteTypeEnum.PRE_HOMOGENIZE_RECORD_TYPE.getName()).setValue(ProcessRouteTypeEnum.PRE_HOMOGENIZE_RECORD_TYPE.getValue()),
            new ProcessRouteProcceTypeVO().setName(ProcessRouteTypeEnum.POWDER_DOSING.getName()).setValue(ProcessRouteTypeEnum.POWDER_DOSING.getValue()),
            new ProcessRouteProcceTypeVO().setName(ProcessRouteTypeEnum.HOMOGENIZATION_BIN_HOMOGENIZATION.getName()).setValue(ProcessRouteTypeEnum.HOMOGENIZATION_BIN_HOMOGENIZATION.getValue()),
            new ProcessRouteProcceTypeVO().setName(ProcessRouteTypeEnum.PNEUMATIC_TRANSPORT.getName()).setValue(ProcessRouteTypeEnum.PNEUMATIC_TRANSPORT.getValue()),
            new ProcessRouteProcceTypeVO().setName(ProcessRouteTypeEnum.LOADING_AND_DELIVERY.getName()).setValue(ProcessRouteTypeEnum.LOADING_AND_DELIVERY.getValue())
        ).collect(Collectors.toList());
        return collect;
    }

}

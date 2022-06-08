package com.bpm.server.service.impl;

import com.bpm.common.domain.MonthlyProductionOrder;
import com.bpm.common.dto.MonthlyProductionOrderQueryDTO;
import com.bpm.common.dto.MonthlyProductionOrderTwoDto;
import com.bpm.common.vo.BomMaterialVo;
import com.bpm.common.vo.MonthlyProductionOrderVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.UserVo;
import com.bpm.server.mapper.MonthlyProductionOrderExtMapper;
import com.bpm.server.mapper.MonthlyProductionOrderMapper;
import com.bpm.server.mapper.ProductInWorkReportExtMapper;
import com.bpm.server.service.MonthlyProductionOrderService;
import com.bpm.server.util.CommonConstantUtils;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 月生产订单 服务实现类
 * @author wangpeng
 * @since 2022-05-17 17:21:07
 */
@Service
public class MonthlyProductionOrderServiceImpl implements MonthlyProductionOrderService {
    @Resource
    private MonthlyProductionOrderMapper monthlyProductionOrderMapper;

    @Resource
    private MonthlyProductionOrderExtMapper extMapper;

    @Resource
    private ProductInWorkReportExtMapper inWorkReportExtMapper;

    @Autowired
    private NumberUtil numberUtil;
        
    @Override
    public List<MonthlyProductionOrderVO> queryAll(MonthlyProductionOrderQueryDTO dto) {
        dto.setIsDeleted(0);
        return this.extMapper.queryAll(dto);
    }
        
 
    @Override
    public MonthlyProductionOrder queryById(Integer id) {
        return this.monthlyProductionOrderMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<MonthlyProductionOrderVO> queryByPage(MonthlyProductionOrderQueryDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
//        List<MonthlyProductionOrder> vos = this.monthlyProductionOrderMapper.queryAll(monthlyProductionOrder);
        dto.setIsDeleted(0);
        List<MonthlyProductionOrderVO> vos = this.extMapper.queryAll(dto);

        PageInfo<MonthlyProductionOrderVO> pageInfo = new PageInfo<>(vos);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    public boolean insert(MonthlyProductionOrderTwoDto dto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //查询bom信息
        BomMaterialVo vo = extMapper.queryBomMaterial(dto.getBomId());

        //查询用户信息
        UserVo userVo = inWorkReportExtMapper.queryCompany(dto.getCurrentloginId());

        MonthlyProductionOrder monthlyProductionOrder = new MonthlyProductionOrder();
        BeanUtils.copyProperties(dto,monthlyProductionOrder);
        BeanUtils.copyProperties(vo,monthlyProductionOrder);
        BeanUtils.copyProperties(userVo,monthlyProductionOrder);
        String code = numberUtil.getContextLoadsTwo("YSO","00");
        monthlyProductionOrder.setDocumentCode(code);
        monthlyProductionOrder.setDocumentDate(sdf.format(new Date()));
        monthlyProductionOrder.setCreateId(dto.getCurrentloginId());
        monthlyProductionOrder.setCreateName(dto.getCurrentloginName());
        monthlyProductionOrder.setCreateTime(LocalDateTime.now());
        monthlyProductionOrder.setStatus(CommonConstantUtils.MONTHLY_STATUS_ONE);
        monthlyProductionOrder.setIsDeleted(0);
        return this.monthlyProductionOrderMapper.insert(monthlyProductionOrder) > 0;
    }

    
    @Override
    public boolean update(MonthlyProductionOrderTwoDto dto) {
        //查询bom信息
        BomMaterialVo vo = extMapper.queryBomMaterial(dto.getBomId());

        //查询用户信息
        UserVo userVo = inWorkReportExtMapper.queryCompany(dto.getCurrentloginId());

        MonthlyProductionOrder monthlyProductionOrder = monthlyProductionOrderMapper.queryById(dto.getId());
        BeanUtils.copyProperties(vo,monthlyProductionOrder);
        BeanUtils.copyProperties(userVo,monthlyProductionOrder);
        monthlyProductionOrder.setWorkEnterId(dto.getWorkEnterId());
//        monthlyProductionOrder.setDocumentDate(dto.getDocumentDate());
        monthlyProductionOrder.setGroupNumber(dto.getGroupNumber());
        monthlyProductionOrder.setStatus(CommonConstantUtils.MONTHLY_STATUS_ONE);
        monthlyProductionOrder.setUpdateId(dto.getCurrentloginId());
        monthlyProductionOrder.setUpdateName(dto.getCurrentloginName());
        monthlyProductionOrder.setUpdateTime(LocalDateTime.now());
        monthlyProductionOrder.setIsDeleted(0);
        return this.monthlyProductionOrderMapper.update(monthlyProductionOrder) > 0 ;
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.monthlyProductionOrderMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.monthlyProductionOrderMapper.removeById(id) > 0;
    }
    
}

package com.bpm.server.service.impl;

import com.bpm.common.domain.ProductInWorkReport;
import com.bpm.common.dto.ProductInWorkReportDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.ProductInWorkReportMapper;
import com.bpm.server.service.ProductInWorkReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生成入库报工 服务实现类
 * @author wangpeng
 * @since 2022-05-23 14:53:17
 */
@Service
public class ProductInWorkReportServiceImpl implements ProductInWorkReportService {
    @Resource
    private ProductInWorkReportMapper productInWorkReportMapper;
        
    @Override
    public List<ProductInWorkReport> queryAll(ProductInWorkReportDTO productInWorkReport) {
 
        return this.productInWorkReportMapper.queryAll(productInWorkReport);
    }
        
 
    @Override
    public ProductInWorkReport queryById(Integer id) {
        return this.productInWorkReportMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<ProductInWorkReport> queryByPage(ProductInWorkReportDTO productInWorkReport) {
        PageHelper.startPage(productInWorkReport.getPageNum(),productInWorkReport.getPageSize());
        List<ProductInWorkReport> productInWorkReportList = this.productInWorkReportMapper.queryAll(productInWorkReport);
         
        PageInfo<ProductInWorkReport> pageInfo = new PageInfo<>(productInWorkReportList);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    public boolean insert(ProductInWorkReport productInWorkReport) {
        return this.productInWorkReportMapper.insert(productInWorkReport) > 0;
    }

    
    @Override
    public boolean update(ProductInWorkReport productInWorkReport) {
        return this.productInWorkReportMapper.update(productInWorkReport) > 0 ;
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.productInWorkReportMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.productInWorkReportMapper.removeById(id) > 0;
    }
    
}

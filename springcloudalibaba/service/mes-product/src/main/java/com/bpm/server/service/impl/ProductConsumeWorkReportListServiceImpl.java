package com.bpm.server.service.impl;

import com.bpm.common.domain.ProductConsumeWorkReportList;
import com.bpm.common.dto.ProductConsumeWorkReportListDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.ProductConsumeWorkReportListMapper;
import com.bpm.server.service.ProductConsumeWorkReportListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消耗报工明细表 服务实现类
 * @author wangpeng
 * @since 2022-05-25 14:14:43
 */
@Service
public class ProductConsumeWorkReportListServiceImpl implements ProductConsumeWorkReportListService {
    @Resource
    private ProductConsumeWorkReportListMapper productConsumeWorkReportListMapper;
        
    @Override
    public List<ProductConsumeWorkReportList> queryAll(ProductConsumeWorkReportListDTO productConsumeWorkReportList) {
 
        return this.productConsumeWorkReportListMapper.queryAll(productConsumeWorkReportList);
    }
        
 
    @Override
    public ProductConsumeWorkReportList queryById(Integer id) {
        return this.productConsumeWorkReportListMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<ProductConsumeWorkReportList> queryByPage(ProductConsumeWorkReportListDTO productConsumeWorkReportList) {
        PageHelper.startPage(productConsumeWorkReportList.getPageNum(),productConsumeWorkReportList.getPageSize());
        List<ProductConsumeWorkReportList> productConsumeWorkReportListList = this.productConsumeWorkReportListMapper.queryAll(productConsumeWorkReportList);
         
        PageInfo<ProductConsumeWorkReportList> pageInfo = new PageInfo<>(productConsumeWorkReportListList);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    public boolean insert(ProductConsumeWorkReportList productConsumeWorkReportList) {
        return this.productConsumeWorkReportListMapper.insert(productConsumeWorkReportList) > 0;
    }

    
    @Override
    public boolean update(ProductConsumeWorkReportList productConsumeWorkReportList) {
        return this.productConsumeWorkReportListMapper.update(productConsumeWorkReportList) > 0 ;
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.productConsumeWorkReportListMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.productConsumeWorkReportListMapper.removeById(id) > 0;
    }
    
}

package com.bpm.server.service;

import com.bpm.common.domain.ProductConsumeWorkReportList;
import com.bpm.common.dto.ProductConsumeWorkReportListDTO;
import com.bpm.common.vo.PageInfoVO;

import java.util.List;
/**
 * 消耗报工明细表 表服务接口
 * @author wangpeng
 * @since 2022-05-25 14:14:43
 */
public interface ProductConsumeWorkReportListService {
       
     /**
     * 条件查询 消耗报工明细表
     * @param productConsumeWorkReportList
     * @param 
     * @return 
     */     
    List<ProductConsumeWorkReportList> queryAll(ProductConsumeWorkReportListDTO productConsumeWorkReportList);
       
     /**
     * 分页查询 消耗报工明细表
     * @param productConsumeWorkReportList
     * @return 
     */ 
    PageInfoVO<ProductConsumeWorkReportList> queryByPage(ProductConsumeWorkReportListDTO productConsumeWorkReportList);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    ProductConsumeWorkReportList queryById(Integer id);

    
    /**
     * 新增数据
     * @param productConsumeWorkReportList 实例对象
     * @return 实例对象
     */
    boolean insert(ProductConsumeWorkReportList productConsumeWorkReportList);

    /**
     * 修改数据
     * @param productConsumeWorkReportList 实例对象
     * @return 实例对象
     */
    boolean update(ProductConsumeWorkReportList productConsumeWorkReportList);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
     /**
     * 根据id逻辑删除
     * @param id  id
     * @return
     */
    boolean removeById(Integer id);

}

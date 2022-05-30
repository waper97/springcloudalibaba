package com.bpm.server.service;

import com.bpm.common.domain.ProductInWorkReport;
import com.bpm.common.dto.ProductInWorkReportDTO;
import java.util.List;
import com.bpm.common.vo.PageInfoVO;
/**
 * 生成入库报工 表服务接口
 * @author wangpeng
 * @since 2022-05-23 14:53:17
 */
public interface ProductInWorkReportService {
       
     /**
     * 条件查询 生成入库报工
     * @param productInWorkReport
     * @param 
     * @return 
     */     
    List<ProductInWorkReport> queryAll(ProductInWorkReportDTO productInWorkReport);
       
     /**
     * 分页查询 生成入库报工
     * @param productInWorkReport
     * @return 
     */ 
    PageInfoVO<ProductInWorkReport> queryByPage(ProductInWorkReportDTO productInWorkReport);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    ProductInWorkReport queryById(Integer id);

    
    /**
     * 新增数据
     * @param productInWorkReport 实例对象
     * @return 实例对象
     */
    boolean insert(ProductInWorkReport productInWorkReport);

    /**
     * 修改数据
     * @param productInWorkReport 实例对象
     * @return 实例对象
     */
    boolean update(ProductInWorkReport productInWorkReport);

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

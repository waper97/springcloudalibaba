package com.bpm.server.service;

import com.bpm.common.domain.ProductInWorkReport;
import com.bpm.common.dto.InStockDTO;
import com.bpm.common.dto.ProductInWorkReportDTO;
import com.bpm.common.dto.ProductInWorkReportQueryDTO;
import com.bpm.common.vo.InStockVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ProductInWorkReportVO;
import com.bpm.common.vo.ResultVO;

import java.math.BigDecimal;
import java.util.List;
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
    List<ProductInWorkReportVO> queryAll(ProductInWorkReportQueryDTO productInWorkReport);
       
     /**
     * 分页查询 生成入库报工
     * @param queryDTO
     * @return 
     */ 
    PageInfoVO<ProductInWorkReportVO> queryByPage(ProductInWorkReportQueryDTO queryDTO);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    ProductInWorkReport queryById(Integer id);

    
    /**
     * 新增数据
     * @param dto 实例对象
     * @return 实例对象
     */
    ResultVO insert(ProductInWorkReportDTO dto);

    /**
     * 修改数据
     * @param dto 实例对象
     * @return 实例对象
     */
    ResultVO update(ProductInWorkReportDTO dto);

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

    //查询最新批次数据
    String queryBatchNo(String workReportDate);

    //查询仓库物料入库信息
    List<InStockVo> queryInStock(InStockDTO dto);

    //数量
    BigDecimal queryAty(InStockDTO dto);

    //上传Sap
    ResultVO uploadSap(List<Integer> ids);

    //取消上传Sap
    ResultVO cancelUploadSap(List<Integer> ids);
}

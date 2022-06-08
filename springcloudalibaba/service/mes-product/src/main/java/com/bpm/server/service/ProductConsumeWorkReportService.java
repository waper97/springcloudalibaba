package com.bpm.server.service;

import com.bpm.common.domain.ProductConsumeWorkReport;
import com.bpm.common.dto.OutStockDTO;
import com.bpm.common.dto.ProductConsumeWorkReportDTO;
import com.bpm.common.dto.ProductConsumeWorkReportQueryDto;
import com.bpm.common.dto.ProductConsumeWorkReportTwoDto;
import com.bpm.common.vo.*;

import java.util.List;
/**
 * 消耗报工 表服务接口
 * @author wangpeng
 * @since 2022-05-25 14:12:56
 */
public interface ProductConsumeWorkReportService {
       
     /**
     * 条件查询 消耗报工
     * @param productConsumeWorkReport
     * @param 
     * @return 
     */     
    List<ProductConsumeWorkReport> queryAll(ProductConsumeWorkReportDTO productConsumeWorkReport);
       
     /**
     * 分页查询 消耗报工
     * @param dto
     * @return 
     */ 
    PageInfoVO<ProductConsumeWorkReportVO> queryByPage(ProductConsumeWorkReportQueryDto dto);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    ProductConsumeWorkReport queryById(Integer id);

    
    /**
     * 新增数据
     * @param  dto 实例对象
     * @return 实例对象
     */
    ResultVO insert(ProductConsumeWorkReportTwoDto dto);

    /**
     * 修改数据
     * @param dto 实例对象
     * @return 实例对象
     */
    ResultVO update(ProductConsumeWorkReportTwoDto dto);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    ResultVO deleteById(Integer id);
    
     /**
     * 根据id逻辑删除
     * @param id  id
     * @return
     */
    boolean removeById(Integer id);

    //查询仓库物料出库信息
    List<OutStockVo> queryOutStock(OutStockDTO dto);

    //查询明细
    List<ProductConsumeWorkReportListVO> queryAty(OutStockDTO dto);

    //上传Sap
    ResultVO uploadSap(List<Integer> ids);

    //取消上传Sap
    ResultVO cancelUploadSap(List<Integer> ids);
}

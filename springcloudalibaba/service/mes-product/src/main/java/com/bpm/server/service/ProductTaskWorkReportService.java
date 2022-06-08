package com.bpm.server.service;

import com.bpm.common.domain.ProductTaskWorkReport;
import com.bpm.common.dto.ProductTaskWorkReportDTO;
import com.bpm.common.dto.ProductTaskWorkReportQueryDto;
import com.bpm.common.dto.ProductTaskWorkReportTwoDto;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ProductTaskWorkReportVO;
import com.bpm.common.vo.ResultVO;

import java.util.List;

/**
 * 作业报工 表服务接口
 * @author wangpeng
 * @since 2022-05-25 14:15:44
 */
public interface ProductTaskWorkReportService {
       
     /**
     * 条件查询 作业报工
     * @param productTaskWorkReport
     * @param 
     * @return 
     */     
    List<ProductTaskWorkReport> queryAll(ProductTaskWorkReportDTO productTaskWorkReport);
       
     /**
     * 分页查询 作业报工
     * @param dto
     * @return 
     */ 
    PageInfoVO<ProductTaskWorkReportVO> queryByPage(ProductTaskWorkReportQueryDto dto);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    ProductTaskWorkReport queryById(Integer id);

    
    /**
     * 新增数据
     * @param dto 实例对象
     * @return 实例对象
     */
    boolean insert(ProductTaskWorkReportTwoDto dto);

    /**
     * 修改数据
     * @param dto 实例对象
     * @return 实例对象
     */
    boolean update(ProductTaskWorkReportTwoDto dto);

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

    //上传Sap
    ResultVO uploadSap(List<Integer> ids);

    //取消上传Sap
    ResultVO cancelUploadSap(List<Integer> ids);

}

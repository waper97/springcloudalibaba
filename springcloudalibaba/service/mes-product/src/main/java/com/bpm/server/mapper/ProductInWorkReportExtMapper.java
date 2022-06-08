package com.bpm.server.mapper;


import com.bpm.common.dto.InStockDTO;
import com.bpm.common.dto.InStockTwoDto;
import com.bpm.common.dto.ProductInWorkReportQueryDTO;
import com.bpm.common.vo.InStockVo;
import com.bpm.common.vo.ProductInWorkReportVO;
import com.bpm.common.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 生成入库报工 数据库访问层
 * @author wangpeng
 * @since 2022-05-23 14:53:17
 */
@Mapper
public interface ProductInWorkReportExtMapper {

    //查询所有
    List<ProductInWorkReportVO> queryAll(ProductInWorkReportQueryDTO queryDTO);

    //查询最新批次数据
    String queryBatchNo(@Param("workReportDate") String workReportDate);

    //查询仓库物料入库信息
    List<InStockVo> queryInStock(InStockDTO dto);

    //数量
    BigDecimal queryAty(InStockDTO dto);

    List<Integer> queryWorkReportIds(@Param("id") Integer id);

    //新增出入库报工信息
    int updateInStock(InStockTwoDto inStockTwoDto);

    UserVo queryCompany(@Param("currentloginId") Integer currentloginId);

    List<InStockVo> queryWorkReports(@Param("id") Integer id);
}


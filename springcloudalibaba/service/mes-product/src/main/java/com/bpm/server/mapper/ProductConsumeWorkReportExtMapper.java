package com.bpm.server.mapper;


import com.bpm.common.dto.OutStockDTO;
import com.bpm.common.dto.ProductConsumeWorkReportQueryDto;
import com.bpm.common.vo.OutStockVo;
import com.bpm.common.vo.ProductConsumeWorkReportListVO;
import com.bpm.common.vo.ProductConsumeWorkReportVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 消耗报工 数据库访问层
 * @author wangpeng
 * @since 2022-05-25 14:12:56
 */
public interface ProductConsumeWorkReportExtMapper {

    //查询所有
    List<ProductConsumeWorkReportVO> queryAll(ProductConsumeWorkReportQueryDto dto);

    //查询所有明细
    List<ProductConsumeWorkReportListVO> queryAllList(@Param("consumeId") Integer consumeId);
    //查询仓库物料出库信息
    List<OutStockVo> queryOutStock(OutStockDTO dto);
    //查询bom明细数据
    List<ProductConsumeWorkReportListVO> queryBomAty(@Param("bomId") Integer bomId);

    //查询出库数量
    BigDecimal queryOutQty(@Param("materialId") Integer materialId, @Param("stockInOutIds") List<Integer> stockInOutIds);
}


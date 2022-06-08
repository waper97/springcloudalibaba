package com.bpm.server.mapper;


import com.bpm.common.dto.ProductTaskWorkReportQueryDto;
import com.bpm.common.vo.ProductTaskWorkReportVO;

import java.util.List;

/**
 * 作业报工 数据库访问层
 * @author wangpeng
 * @since 2022-05-25 14:15:44
 */
public interface ProductTaskWorkReportExtMapper {

    //查询所有作业报工
    List<ProductTaskWorkReportVO> queryAll(ProductTaskWorkReportQueryDto dto);
}


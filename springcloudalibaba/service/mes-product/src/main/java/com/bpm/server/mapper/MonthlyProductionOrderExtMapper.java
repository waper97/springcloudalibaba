package com.bpm.server.mapper;


import com.bpm.common.dto.MonthlyProductionOrderQueryDTO;
import com.bpm.common.vo.BomMaterialVo;
import com.bpm.common.vo.MonthlyProductionOrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 月生产订单 数据库访问层
 * @author wangpeng
 * @since 2022-05-17 17:21:07
 */
public interface MonthlyProductionOrderExtMapper {

    //查询所有月生产订单
    List<MonthlyProductionOrderVO> queryAll(MonthlyProductionOrderQueryDTO dto);

    //查询所有月生产订单
    MonthlyProductionOrderVO queryBuyId(@Param("id") Integer id);

    BomMaterialVo queryBomMaterial(@Param("bomId") Integer bomId);
}


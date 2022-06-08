package com.bpm.server.service;

import com.bpm.common.domain.MonthlyProductionOrder;
import com.bpm.common.dto.MonthlyProductionOrderQueryDTO;
import com.bpm.common.dto.MonthlyProductionOrderTwoDto;
import com.bpm.common.vo.MonthlyProductionOrderVO;
import com.bpm.common.vo.PageInfoVO;

import java.util.List;
/**
 * 月生产订单 表服务接口
 * @author wangpeng
 * @since 2022-05-17 17:21:07
 */
public interface MonthlyProductionOrderService {
       
     /**
     * 条件查询 月生产订单
     * @param dto
     * @param 
     * @return 
     */     
    List<MonthlyProductionOrderVO> queryAll(MonthlyProductionOrderQueryDTO dto);
       
     /**
     * 分页查询 月生产订单
     * @param dto
     * @return 
     */ 
    PageInfoVO<MonthlyProductionOrderVO> queryByPage(MonthlyProductionOrderQueryDTO dto);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    MonthlyProductionOrder queryById(Integer id);

    
    /**
     * 新增数据
     * @param dto 实例对象
     * @return 实例对象
     */
    boolean insert(MonthlyProductionOrderTwoDto dto);

    /**
     * 修改数据
     * @param dto 实例对象
     * @return 实例对象
     */
    boolean update(MonthlyProductionOrderTwoDto dto);

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

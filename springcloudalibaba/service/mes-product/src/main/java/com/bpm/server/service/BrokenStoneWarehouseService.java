package com.bpm.server.service;

import com.bpm.common.domain.BrokenStoneWarehouse;
import com.bpm.common.dto.BrokenStoneWarehouseDTO;
import java.util.List;

import com.bpm.common.dto.BrokenStoneWarehouseInsertOrUpdateDTO;
import com.bpm.common.vo.BrokenStoneWarehouseVO;
import com.bpm.common.vo.PageInfoVO;
/**
 * 碎石仓 表服务接口
 * @author wangpeng
 * @since 2022-04-29 10:24:45
 */
public interface BrokenStoneWarehouseService {
       
     /**
     * 条件查询 碎石仓
     * @param brokenStoneWarehouse
     * @param 
     * @return 
     */     
    List<BrokenStoneWarehouseVO> queryAll(BrokenStoneWarehouseDTO brokenStoneWarehouse);
       
     /**
     * 分页查询 碎石仓
     * @param brokenStoneWarehouseDTO
     * @return 
     */ 
    PageInfoVO<BrokenStoneWarehouseVO> queryByPage(BrokenStoneWarehouseDTO brokenStoneWarehouseDTO);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    BrokenStoneWarehouse queryById(Integer id);

    
    /**
     * 新增数据
     * @param brokenStoneWarehouse 实例对象
     * @return 实例对象
     */
    boolean insert(BrokenStoneWarehouse brokenStoneWarehouse);

    /**
     * 修改数据
     * @param brokenStoneWarehouse 实例对象
     * @return 实例对象
     */
    boolean update(BrokenStoneWarehouseInsertOrUpdateDTO brokenStoneWarehouse);

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

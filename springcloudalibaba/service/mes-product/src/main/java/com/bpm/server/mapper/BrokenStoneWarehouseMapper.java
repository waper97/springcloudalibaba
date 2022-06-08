package com.bpm.server.mapper;
import com.bpm.common.domain.BrokenStoneWarehouse;
import com.bpm.common.dto.BrokenStoneWarehouseDTO;
import com.bpm.common.vo.BrokenStoneWarehouseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 碎石仓 数据库访问层
 * @author wangpeng
 * @since 2022-04-29 10:24:45
 */
public interface BrokenStoneWarehouseMapper {
    
     /**
     * 条件查询 碎石仓
     * @param brokenStoneWarehouse
     * @return 
     */
   List<BrokenStoneWarehouseVO> queryAll(BrokenStoneWarehouseDTO brokenStoneWarehouse);
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BrokenStoneWarehouse queryById(Integer id);


    /**
     * 新增数据
     *
     * @param brokenStoneWarehouse 实例对象
     * @return 影响行数
     */
    int insert(BrokenStoneWarehouse brokenStoneWarehouse);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BrokenStoneWarehouse> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BrokenStoneWarehouse> entities);


    /**
     * 修改数据
     * @param brokenStoneWarehouse 实例对象
     * @return 影响行数
     */
    int update(BrokenStoneWarehouse brokenStoneWarehouse);

    /**
     * 通过主键 选择性 修改数据
     * @param brokenStoneWarehouse 实例对象
     * @return 影响行数
     */
    int updateSelective(BrokenStoneWarehouse brokenStoneWarehouse);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    
  /**
   * 根据id逻辑删除
   * @param id
   * @return
   */
  int removeById(Integer id);

}


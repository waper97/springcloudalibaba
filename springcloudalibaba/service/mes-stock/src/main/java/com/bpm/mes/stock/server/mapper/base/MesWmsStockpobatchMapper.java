package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockpobatch;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * 仓库调拨批次表(MesWmsStockpobatch)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-22 09:45:37
 */
public interface MesWmsStockpobatchMapper {
    
   //条件查询 
   List<MesWmsStockpobatch> queryAll(MesWmsStockpobatch mesWmsStockpobatch);
    
   //通过ID查询单条数据
    MesWmsStockpobatch queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockpobatch> queryAllByLimit(MesWmsStockpobatch mesWmsStockpobatch, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockpobatch mesWmsStockpobatch);

    //新增数据
    int insert(MesWmsStockpobatch mesWmsStockpobatch);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockpobatch> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockpobatch> entities);

    //修改数据
    int update(MesWmsStockpobatch mesWmsStockpobatch);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockcheck;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 仓库盘点主表(MesWmsStockcheck)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-28 19:16:22
 */
public interface MesWmsStockcheckMapper {
    
   //条件查询 
   List<MesWmsStockcheck> queryAll(MesWmsStockcheck mesWmsStockcheck);
    
   //通过ID查询单条数据
    MesWmsStockcheck queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockcheck> queryAllByLimit(MesWmsStockcheck mesWmsStockcheck, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockcheck mesWmsStockcheck);

    //新增数据
    int insert(MesWmsStockcheck mesWmsStockcheck);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockcheck> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockcheck> entities);

    //修改数据
    int update(MesWmsStockcheck mesWmsStockcheck);

    //修改数据
    int edit(MesWmsStockcheck mesWmsStockcheck);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockpo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 仓库调拨单主表(MesWmsStockpo)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-20 18:10:42
 */
public interface MesWmsStockpoMapper {
    
   //条件查询 
   List<MesWmsStockpo> queryAll(MesWmsStockpo mesWmsStockpo);
    
   //通过ID查询单条数据
    MesWmsStockpo queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockpo> queryAllByLimit(MesWmsStockpo mesWmsStockpo, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockpo mesWmsStockpo);

    //新增数据
    int insert(MesWmsStockpo mesWmsStockpo);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockpo> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockpo> entities);

    //修改数据
    int update(MesWmsStockpo mesWmsStockpo);

    //修改数据
    int edit(MesWmsStockpo mesWmsStockpo);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


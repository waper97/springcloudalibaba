package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockpolist;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 仓库调拨明细表(MesWmsStockpolist)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-21 14:29:12
 */
public interface MesWmsStockpolistMapper {
    
   //条件查询 
   List<MesWmsStockpolist> queryAll(MesWmsStockpolist mesWmsStockpolist);
    
   //通过ID查询单条数据
    MesWmsStockpolist queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockpolist> queryAllByLimit(MesWmsStockpolist mesWmsStockpolist, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockpolist mesWmsStockpolist);

    //新增数据
    int insert(MesWmsStockpolist mesWmsStockpolist);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockpolist> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockpolist> entities);

    //修改数据
    int update(MesWmsStockpolist mesWmsStockpolist);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * 仓库库位表(MesWmsStockplace)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-14 16:51:23
 */
public interface MesWmsStockplaceMapper {
    
   //条件查询 
   List<MesWmsStockplace> queryAll(MesWmsStockplace mesWmsStockplace);
    
   //通过ID查询单条数据
    MesWmsStockplace queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockplace> queryAllByLimit(MesWmsStockplace mesWmsStockplace, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockplace mesWmsStockplace);

    //新增数据
    int insert(MesWmsStockplace mesWmsStockplace);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockplace> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockplace> entities);

    //修改数据
    int update(MesWmsStockplace mesWmsStockplace);

    //修改数据
    int edit(MesWmsStockplace mesWmsStockplace);

    //通过主键删除数据
    int deleteById(Integer id);

    //通过主键逻辑删除数据
    int updateById(Integer id);
}


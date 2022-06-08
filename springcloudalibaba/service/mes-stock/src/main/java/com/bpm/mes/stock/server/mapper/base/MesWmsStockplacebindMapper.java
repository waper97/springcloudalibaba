package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockplacebind;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * 库位绑定物料表(MesWmsStockplacebind)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-15 15:29:56
 */
public interface MesWmsStockplacebindMapper {
    
   //条件查询 
   List<MesWmsStockplacebind> queryAll(MesWmsStockplacebind mesWmsStockplacebind);
    
   //通过ID查询单条数据
    MesWmsStockplacebind queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockplacebind> queryAllByLimit(MesWmsStockplacebind mesWmsStockplacebind, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockplacebind mesWmsStockplacebind);

    //新增数据
    int insert(MesWmsStockplacebind mesWmsStockplacebind);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockplacebind> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockplacebind> entities);

    //修改数据
    int update(MesWmsStockplacebind mesWmsStockplacebind);
    //修改数据
    int edit(MesWmsStockplacebind mesWmsStockplacebind);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


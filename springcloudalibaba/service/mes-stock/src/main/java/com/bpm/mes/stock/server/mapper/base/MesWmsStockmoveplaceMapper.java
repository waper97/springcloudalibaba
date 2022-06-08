package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockmoveplace;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 仓库库位转移表(MesWmsStockmoveplace)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 17:38:46
 */
public interface MesWmsStockmoveplaceMapper {
    
   //条件查询 
   List<MesWmsStockmoveplace> queryAll(MesWmsStockmoveplace mesWmsStockmoveplace);
    
   //通过ID查询单条数据
    MesWmsStockmoveplace queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockmoveplace> queryAllByLimit(MesWmsStockmoveplace mesWmsStockmoveplace, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockmoveplace mesWmsStockmoveplace);

    //新增数据
    int insert(MesWmsStockmoveplace mesWmsStockmoveplace);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockmoveplace> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockmoveplace> entities);

    //修改数据
    int update(MesWmsStockmoveplace mesWmsStockmoveplace);

    //修改数据
    int edit(MesWmsStockmoveplace mesWmsStockmoveplace);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


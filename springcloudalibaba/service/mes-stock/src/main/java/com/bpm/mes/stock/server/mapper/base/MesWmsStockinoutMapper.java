package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockinout;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 仓库出入库主表(MesWmsStockinout)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-22 16:08:22
 */
public interface MesWmsStockinoutMapper {
    
   //条件查询 
   List<MesWmsStockinout> queryAll(MesWmsStockinout mesWmsStockinout);
    
   //通过ID查询单条数据
    MesWmsStockinout queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockinout> queryAllByLimit(MesWmsStockinout mesWmsStockinout, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockinout mesWmsStockinout);

    //新增数据
    int insert(MesWmsStockinout mesWmsStockinout);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockinout> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockinout> entities);

    //修改数据
    int update(MesWmsStockinout mesWmsStockinout);

    //修改数据
    int edit(MesWmsStockinout mesWmsStockinout);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


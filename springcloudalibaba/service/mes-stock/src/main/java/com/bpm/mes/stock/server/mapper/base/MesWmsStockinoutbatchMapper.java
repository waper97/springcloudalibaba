package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockinoutbatch;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * 出入库批次记录表(MesWmsStockinoutbatch)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-25 15:20:30
 */
public interface MesWmsStockinoutbatchMapper {
    
   //条件查询 
   List<MesWmsStockinoutbatch> queryAll(MesWmsStockinoutbatch mesWmsStockinoutbatch);
    
   //通过ID查询单条数据
    MesWmsStockinoutbatch queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockinoutbatch> queryAllByLimit(MesWmsStockinoutbatch mesWmsStockinoutbatch, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockinoutbatch mesWmsStockinoutbatch);

    //新增数据
    int insert(MesWmsStockinoutbatch mesWmsStockinoutbatch);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockinoutbatch> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockinoutbatch> entities);

    //修改数据
    int update(MesWmsStockinoutbatch mesWmsStockinoutbatch);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


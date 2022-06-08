package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockinoutlist;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 仓库出入库明细表(MesWmsStockinoutlist)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-22 17:58:18
 */
public interface MesWmsStockinoutlistMapper {
    
   //条件查询 
   List<MesWmsStockinoutlist> queryAll(MesWmsStockinoutlist mesWmsStockinoutlist);
    
   //通过ID查询单条数据
    MesWmsStockinoutlist queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockinoutlist> queryAllByLimit(MesWmsStockinoutlist mesWmsStockinoutlist, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockinoutlist mesWmsStockinoutlist);

    //新增数据
    int insert(MesWmsStockinoutlist mesWmsStockinoutlist);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockinoutlist> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockinoutlist> entities);

    //修改数据
    int update(MesWmsStockinoutlist mesWmsStockinoutlist);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


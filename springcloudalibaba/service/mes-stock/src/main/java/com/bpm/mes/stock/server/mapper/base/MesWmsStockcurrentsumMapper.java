package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockcurrentsum;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * 仓库即时库存主表(MesWmsStockcurrentsum)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 14:00:33
 */
public interface MesWmsStockcurrentsumMapper {
    
   //条件查询 
   List<MesWmsStockcurrentsum> queryAll(MesWmsStockcurrentsum mesWmsStockcurrentsum);
    
   //通过ID查询单条数据
    MesWmsStockcurrentsum queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockcurrentsum> queryAllByLimit(MesWmsStockcurrentsum mesWmsStockcurrentsum, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockcurrentsum mesWmsStockcurrentsum);

    //新增数据
    int insert(MesWmsStockcurrentsum mesWmsStockcurrentsum);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockcurrentsum> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockcurrentsum> entities);

    //修改数据
    int update(MesWmsStockcurrentsum mesWmsStockcurrentsum);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


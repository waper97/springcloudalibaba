package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockcurrent;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * 仓库即时库存明细表(MesWmsStockcurrent)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-20 13:47:30
 */
public interface MesWmsStockcurrentMapper {
    
   //条件查询 
   List<MesWmsStockcurrent> queryAll(MesWmsStockcurrent mesWmsStockcurrent);
    
   //通过ID查询单条数据
    MesWmsStockcurrent queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockcurrent> queryAllByLimit(MesWmsStockcurrent mesWmsStockcurrent, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockcurrent mesWmsStockcurrent);

    //新增数据
    int insert(MesWmsStockcurrent mesWmsStockcurrent);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockcurrent> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockcurrent> entities);

    //修改数据
    int update(MesWmsStockcurrent mesWmsStockcurrent);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


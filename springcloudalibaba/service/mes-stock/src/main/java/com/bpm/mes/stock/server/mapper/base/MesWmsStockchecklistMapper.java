package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockchecklist;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 仓库盘点明细表(MesWmsStockchecklist)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-29 11:41:38
 */
public interface MesWmsStockchecklistMapper {
    
   //条件查询 
   List<MesWmsStockchecklist> queryAll(MesWmsStockchecklist mesWmsStockchecklist);
    
   //通过ID查询单条数据
    MesWmsStockchecklist queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockchecklist> queryAllByLimit(MesWmsStockchecklist mesWmsStockchecklist, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockchecklist mesWmsStockchecklist);

    //新增数据
    int insert(MesWmsStockchecklist mesWmsStockchecklist);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockchecklist> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockchecklist> entities);

    //修改数据
    int update(MesWmsStockchecklist mesWmsStockchecklist);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


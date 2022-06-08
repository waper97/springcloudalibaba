package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStock;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * 仓库信息表(MesWmsStock)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-14 09:59:16
 */
public interface MesWmsStockMapper {
    
   //条件查询 
   List<MesWmsStock> queryAll(MesWmsStock mesWmsStock);
    
   //通过ID查询单条数据
    MesWmsStock queryById(Integer id);

    //查询指定行数据
    List<MesWmsStock> queryAllByLimit(MesWmsStock mesWmsStock, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStock mesWmsStock);

    //新增数据
    int insert(MesWmsStock mesWmsStock);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStock> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStock> entities);

    //修改数据
    int update(MesWmsStock mesWmsStock);

    //修改数据
    int edit(MesWmsStock mesWmsStock);

    //通过主键删除数据
    int deleteById(Integer id);

    //通过主键逻辑删除数据
    int updateById(Integer id);
}


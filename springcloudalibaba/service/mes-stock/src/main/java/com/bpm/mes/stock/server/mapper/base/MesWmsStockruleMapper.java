package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsStockrule;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * 仓库出入库规则(MesWmsStockrule)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-15 17:46:48
 */
public interface MesWmsStockruleMapper {
    
   //条件查询 
   List<MesWmsStockrule> queryAll(MesWmsStockrule mesWmsStockrule);
    
   //通过ID查询单条数据
    MesWmsStockrule queryById(Integer id);

    //查询指定行数据
    List<MesWmsStockrule> queryAllByLimit(MesWmsStockrule mesWmsStockrule, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsStockrule mesWmsStockrule);

    //新增数据
    int insert(MesWmsStockrule mesWmsStockrule);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsStockrule> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsStockrule> entities);

    //修改数据
    int update(MesWmsStockrule mesWmsStockrule);

    //修改数据
    int edit(MesWmsStockrule mesWmsStockrule);

    //通过主键删除数据
    int deleteById(Integer id);
    
    //通过主键逻辑删除数据
    int updateById(Integer id);

}


package com.bpm.mes.stock.server.mapper.base;

import com.bpm.mes.stock.server.domain.MesWmsInouttype;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * 仓库出入库类型表(MesWmsInouttype)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-14 10:35:29
 */
public interface MesWmsInouttypeMapper {
    
   //条件查询 
   List<MesWmsInouttype> queryAll(MesWmsInouttype mesWmsInouttype);
    
   //通过ID查询单条数据
    MesWmsInouttype queryById(Integer id);

    //查询指定行数据
    List<MesWmsInouttype> queryAllByLimit(MesWmsInouttype mesWmsInouttype, @Param("pageable") Pageable pageable);

    //统计总行数
    long count(MesWmsInouttype mesWmsInouttype);

    //新增数据
    int insert(MesWmsInouttype mesWmsInouttype);

    //批量新增数据（MyBatis原生foreach方法）
    int insertBatch(@Param("entities") List<MesWmsInouttype> entities);

    //批量新增或按主键更新数据（MyBatis原生foreach方法）
    int insertOrUpdateBatch(@Param("entities") List<MesWmsInouttype> entities);

    //修改数据
    int update(MesWmsInouttype mesWmsInouttype);

    //修改数据（全局）
    int edit(MesWmsInouttype mesWmsInouttype);

    //通过主键删除数据
    int deleteById(Integer id);

    //通过主键逻辑删除数据
    int updateById(Integer id);
}


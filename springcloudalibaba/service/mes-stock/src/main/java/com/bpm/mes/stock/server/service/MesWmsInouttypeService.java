package com.bpm.mes.stock.server.service;

import com.bpm.mes.stock.server.domain.MesWmsInouttype;
import com.bpm.mes.stock.server.dto.MesWmsInouttypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.common.dto.PageDTO;
import java.util.List;
import com.github.pagehelper.PageInfo;
/**
 * 仓库出入库类型表(MesWmsInouttype)表服务接口
 *
 * @author makejava
 * @since 2022-04-14 10:35:29
 */
public interface MesWmsInouttypeService {
       
     //条件查询  
    List<MesWmsInouttype> queryAll(MesWmsInouttype mesWmsInouttype);
       
    //分页查询
    PageInfo<MesWmsInouttype> queryByPage(MesWmsInouttype mesWmsInouttype);
 
    //通过ID查询单条数据
    MesWmsInouttype queryById(Integer id);

    //新增数据
    ResultVO insert(MesWmsInouttype mesWmsInouttype);

    //修改数据
    ResultVO update(MesWmsInouttype mesWmsInouttype);

    //通过主键删除数据
    ResultVO deleteById(Integer id);

    //逻辑删除数据(假删)
    ResultVO updateById(Integer id);

    //仓库出入库类型新增和编辑接口
    ResultVO addAndEdit(MesWmsInouttypeDto inouttypeDto);

}

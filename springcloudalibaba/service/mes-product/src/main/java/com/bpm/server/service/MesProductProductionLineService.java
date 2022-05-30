package com.bpm.server.service;

import com.bpm.common.domain.MesProductProductionLine;
import com.bpm.common.dto.MesProductProductionLineDto;
import com.bpm.common.vo.MesProductProductionLineVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;

import java.util.List;

/**
 * 生产线表(MesProductProductionLine)表服务接口
 *
 * @author zhangzheming
 * @since 2022-04-25 09:50:19
 */
public interface MesProductProductionLineService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO queryAll();

    /**
     * 分页查询
     *
     * @param mesProductProductionLineDto 查询条件
     * @return
     */
    ResultVO<PageInfoVO<List<MesProductProductionLineVo>>> queryByPage(MesProductProductionLineDto mesProductProductionLineDto);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 查询结果
     */
    ResultVO queryById(Integer id);


    /**
     * 新增数据
     *
     * @param mesProductProductionLine 实例对象
     * @return 新增结果
     */
    ResultVO insert(MesProductProductionLine mesProductProductionLine);

    /**
     * 修改数据
     *
     * @param mesProductProductionLine 实例对象
     * @return 实例对象
     */
    ResultVO update(MesProductProductionLine mesProductProductionLine);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    ResultVO deleteById(Integer id);

    /**
     * 根据id逻辑删除
     *
     * @param id id
     * @return
     */
    boolean removeById(Integer id);

    /**
     * 查询所有生产线编号
     *
     * @return 查询结果
     */
    ResultVO queryAllLineNumbers();

    /**
     * 查询所有公司名称
     *
     * @return 查询结果
     */
    ResultVO queryAllCompanyNames();
}

package com.bpm.server.service;

import com.bpm.common.domain.MesProductWorkCenter;
import com.bpm.common.dto.MesProductWorkCenterDto;
import com.bpm.common.vo.MesProductWorkCenterVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;

import java.util.List;

/**
 * 工作中心表(MesProductWorkCenter)表服务接口
 *
 * @author zhangzheming
 * @since 2022-04-27 18:00:03
 */
public interface MesProductWorkCenterService {

    /**
     * 查全部
     *
     * @return 查询结果
     */
    ResultVO queryAll();

    /**
     * 查全部
     *mesProductWorkCenter
     * @return 查询结果
     */
    ResultVO<List<MesProductWorkCenter>> queryByParam(MesProductWorkCenter mesProductWorkCenter);

    /**
     * 分页查询
     *
     * @param mesProductWorkCenterDto 查询条件
     * @return 查询结果
     */
    ResultVO<PageInfoVO<List<MesProductWorkCenterVo>>> queryByPage(MesProductWorkCenterDto mesProductWorkCenterDto);

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
     * @param mesProductWorkCenter 实例对象
     * @return 新增结果
     */
    ResultVO insert(MesProductWorkCenter mesProductWorkCenter);

    /**
     * 修改数据
     *
     * @param mesProductWorkCenter 实例对象
     * @return 修改结果
     */
    ResultVO update(MesProductWorkCenter mesProductWorkCenter);

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
     * 查询所有资源类别
     *
     * @return 查询结果
     */
    ResultVO queryAllResourceCategories();
}

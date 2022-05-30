package com.bpm.server.service;

import com.bpm.common.domain.PlanScheme;
import com.bpm.common.dto.PlanSchemeDTO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.PlanSchemeVO;

import java.util.List;
/**
 *  计划方案 表服务接口
 * @author wangpeng
 * @since 2022-05-18 14:53:11
 */
public interface PlanSchemeService {
       
     /**
     * 条件查询  计划方案
     * @param planScheme
     * @param 
     * @return 
     */     
    List<PlanSchemeVO> queryAll(PlanSchemeDTO planScheme);
       
     /**
     * 分页查询  计划方案
     * @param planScheme
     * @return 
     */ 
    PageInfoVO<PlanSchemeVO> queryByPage(PlanSchemeDTO planScheme);
 
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    PlanScheme queryById(Integer id);

    
    /**
     * 新增数据
     * @param planScheme 实例对象
     * @return 实例对象
     */
    boolean insert(PlanScheme planScheme);

    /**
     * 修改数据
     * @param planScheme 实例对象
     * @return 实例对象
     */
    boolean update(PlanScheme planScheme);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
     /**
     * 根据id逻辑删除
     * @param id  id
     * @return
     */
    boolean removeById(Integer id);

}

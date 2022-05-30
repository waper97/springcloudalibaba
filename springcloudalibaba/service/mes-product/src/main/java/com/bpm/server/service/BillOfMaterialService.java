package com.bpm.server.service;

import com.bpm.common.domain.BillOfMaterial;
import com.bpm.common.dto.BillOfMaterialDTO;
import com.bpm.common.dto.BillOfMaterialInsertOrUpdateDTO;
import com.bpm.common.vo.BillOfMaterialVO;
import com.bpm.common.vo.PageInfoVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * bom(物料清单)主表(BillOfMaterialDTO)表服务接口
 *
 * @author wangpeng
 * @since 2022-04-18 17:46:31
 */
public interface BillOfMaterialService {

    /**
     * 条件查询
     *
     * @param mesProductBillOfMaterial
     * @param
     * @return
     */
    List<BillOfMaterialVO> queryAll(BillOfMaterialDTO mesProductBillOfMaterial);

    /**
     * 分页查询
     *
     * @param mesProductBillOfMaterial
     * @return
     */
    PageInfoVO<BillOfMaterialVO> queryByPage(BillOfMaterialDTO mesProductBillOfMaterial);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BillOfMaterial queryById(Integer id);

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    BillOfMaterialVO getById(Integer id);


    /**
     * 新增数据
     *
     * @param mesProductBillOfMaterial 实例对象
     * @return 实例对象
     */
    boolean insert(BillOfMaterialInsertOrUpdateDTO mesProductBillOfMaterial);

    /**
     * 修改数据
     *
     * @param billOfMaterial 实例对象
     * @return 实例对象
     */
    boolean update(BillOfMaterialInsertOrUpdateDTO billOfMaterial);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据id逻辑删除
     *
     * @param id id
     * @return
     */
    boolean removeById(Integer id);

}

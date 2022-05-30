package com.bpm.server.mapper;

import com.bpm.common.domain.BillOfMaterial;
import com.bpm.common.dto.BillOfMaterialDTO;
import com.bpm.common.dto.BillOfMaterialInsertOrUpdateDTO;
import com.bpm.common.vo.BillOfMaterialVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * bom(物料清单)主表(BillOfMaterialDTO)表数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-18 17:46:31
 */
public interface BillOfMaterialMapper {

    /**
     * 条件查询
     *
     * @param mesProductBillOfMaterial
     * @return
     */
    List<BillOfMaterialVO> queryAll(BillOfMaterialDTO mesProductBillOfMaterial);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BillOfMaterial queryById(Integer id);

    /**
     * 根据产品（物料/矿粉）id获取bom清单
     * @param productId 产品id （矿粉/物料）
     * @return
     */
    BillOfMaterialVO getBomByProductId(Integer productId);



    /**
     * 新增数据
     *
     * @param mesProductBillOfMaterial 实例对象
     * @return 影响行数
     */
    int insert(BillOfMaterialInsertOrUpdateDTO mesProductBillOfMaterial);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BillOfMaterialDTO> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BillOfMaterial> entities);


    /**
     * 修改数据
     *
     * @param billOfMaterial 实例对象
     * @return 影响行数
     */
    int update(BillOfMaterialInsertOrUpdateDTO billOfMaterial);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 根据id逻辑删除
     *
     * @param id
     * @return
     */
    int removeById(Integer id);


}


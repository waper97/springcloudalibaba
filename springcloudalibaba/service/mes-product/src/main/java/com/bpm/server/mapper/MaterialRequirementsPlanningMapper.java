package com.bpm.server.mapper;
import com.bpm.common.domain.MaterialRequirementsPlanning;
import com.bpm.common.dto.MaterialRequirementsPlanningDTO;
import com.bpm.common.vo.MaterialRequirementsPlanningVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * 物料需求计划 数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-25 14:15:42
 */
public interface MaterialRequirementsPlanningMapper {

     /**
     * 条件查询 物料需求计划
     * @param materialRequirementsPlanning
     * @return
     */
   List<MaterialRequirementsPlanning> queryAll(MaterialRequirementsPlanning materialRequirementsPlanning);

    /**
     * 条件查询物料需求计划
     * @param materialRequirementsPlanning
     * @return
     */
   List<MaterialRequirementsPlanningVO> listMaterialRequirementsPlanning(MaterialRequirementsPlanningDTO materialRequirementsPlanning);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MaterialRequirementsPlanning queryById(Integer id);


    /**
     * 新增数据
     *
     * @param materialRequirementsPlanning 实例对象
     * @return 影响行数
     */
    int insert(MaterialRequirementsPlanning materialRequirementsPlanning);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaterialRequirementsPlanning> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MaterialRequirementsPlanning> entities);


    /**
     * 修改数据
     *
     * @param materialRequirementsPlanning 实例对象
     * @return 影响行数
     */
    int update(MaterialRequirementsPlanning materialRequirementsPlanning);

    /**
     * 动态修改
     * @param materialRequirementsPlanning
     * @return
     */
    int updateSelective(MaterialRequirementsPlanning materialRequirementsPlanning);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


      /**
   * 根据id逻辑删除
   * @param id
   * @return
   */
  int removeById(Integer id);

    /**
     * 根据物料id获取即时库存
     * @param productId
     * @return
     */
  BigDecimal sumImmediatestock(Integer productId);

    /**
     * 根据物料id获取安全库存
     * @param productId
     * @return
     */
  BigDecimal sumSafeStockByMaterialId(Integer productId);

    /**
     * 根据物料id获取预计入库量
     * @param productId
     * @return
     */
  BigDecimal sumExpectedReceiptMaterialId(Integer productId);

    /**
     * 根据物料id获取物料的供应商
     * @param productId
     * @return
     */
  Map<String,Object> getSupplierInfoByProductId(Integer productId);

}


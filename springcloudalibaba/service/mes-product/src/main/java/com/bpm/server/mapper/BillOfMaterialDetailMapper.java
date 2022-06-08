package com.bpm.server.mapper;

import com.bpm.common.domain.BillOfMaterialDetail;
import com.bpm.common.dto.BillOfMaterialDetailDTO;
import com.bpm.common.vo.BillOfMaterialDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * bom(物料清单)明细表(BillOfMaterialDetail)表数据库访问层
 *
 * @author wangpeng
 * @since 2022-04-19 10:38:23
 */
public interface BillOfMaterialDetailMapper {

    /**
     * 条件查询
     *
     * @param mesProductBillOfMaterialDetail
     * @return
     */
    List<BillOfMaterialDetail> queryAll(BillOfMaterialDetailDTO mesProductBillOfMaterialDetail);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BillOfMaterialDetail queryById(Integer id);





    /**
     * 新增数据
     *
     * @param billOfMaterialDetail 实例对象
     * @return 影响行数
     */
    int insert(BillOfMaterialDetail billOfMaterialDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BillOfMaterialDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BillOfMaterialDetail> entities);


    /**
     * 修改数据
     *
     * @param billOfMaterialDetail 实例对象
     * @return 影响行数
     */
    int update(BillOfMaterialDetail billOfMaterialDetail);

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

    /**
     * 根据bom清单id获取bom清单详情
     * @return
     */
    List<BillOfMaterialDetailVO> listProductBillOfMaterialDetailByProductBillOfMaterialId (Integer bomId);

}


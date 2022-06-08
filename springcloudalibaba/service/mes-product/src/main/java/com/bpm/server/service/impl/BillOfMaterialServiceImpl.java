package com.bpm.server.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.bpm.common.domain.BillOfMaterial;
import com.bpm.common.domain.BillOfMaterialDetail;
import com.bpm.common.dto.BillOfMaterialDTO;
import com.bpm.common.dto.BillOfMaterialInsertOrUpdateDTO;
import com.bpm.common.vo.BillOfMaterialDetailVO;
import com.bpm.common.vo.BillOfMaterialVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.server.mapper.BillOfMaterialDetailMapper;
import com.bpm.server.mapper.BillOfMaterialMapper;
import com.bpm.server.service.BillOfMaterialService;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * bom(物料清单)主表(BillOfMaterialDTO)表服务实现类
 *
 * @author wangpeng
 * @since 2022-04-18 17:46:31
 */
@Service
public class BillOfMaterialServiceImpl implements BillOfMaterialService {
    @Resource
    private BillOfMaterialMapper billOfMaterialMapper;

    @Resource
    private BillOfMaterialDetailMapper billOfMaterialDetailMapper;

    @Autowired
    NumberUtil numberUtil;

    private final static String  PRE_FIX = "1000";

    @Override
    public List<BillOfMaterialVO> queryAll(BillOfMaterialDTO mesProductBillOfMaterial) {
        return this.billOfMaterialMapper.queryAll(mesProductBillOfMaterial);
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BillOfMaterial queryById(Integer id) {
        return this.billOfMaterialMapper.queryById(id);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BillOfMaterialVO getById(Integer id) {
        BillOfMaterial billOfMaterial = billOfMaterialMapper.queryById(id);
        BillOfMaterialVO billOfMaterialVO = new BillOfMaterialVO();
        // 复制
        BeanUtil.copyProperties(billOfMaterial,billOfMaterialVO);

        if (billOfMaterialVO != null) {
            List<BillOfMaterialDetailVO> detailList = billOfMaterialDetailMapper.listProductBillOfMaterialDetailByProductBillOfMaterialId(id);
            if (detailList != null && detailList.size() > 0) {
                billOfMaterialVO.setBillOfMaterialDetailList(detailList);
            }
        }
        return billOfMaterialVO;
    }

    /**
     * 分页查询
     *
     * @param mesProductBillOfMaterial 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfoVO<BillOfMaterialVO> queryByPage(BillOfMaterialDTO mesProductBillOfMaterial) {
        PageHelper.startPage(mesProductBillOfMaterial.getPageNum(), mesProductBillOfMaterial.getPageSize());

        List<BillOfMaterialVO> billOfMaterialList = this.billOfMaterialMapper.queryAll(mesProductBillOfMaterial);

        billOfMaterialList.stream().forEach(f -> {
            f.setBillOfMaterialDetailList(billOfMaterialDetailMapper.listProductBillOfMaterialDetailByProductBillOfMaterialId(f.getId()));
        });
        PageInfo<BillOfMaterialVO> pageInfo = new PageInfo<>(billOfMaterialList);

        PageInfoVO pageInfoVO = new PageInfoVO<>();
        BeanUtil.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;

    }

    /**
     * 新增数据
     * @param mesProductBillOfMaterial 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(BillOfMaterialInsertOrUpdateDTO mesProductBillOfMaterial) {
        mesProductBillOfMaterial.setCode(numberUtil.contextLoads(PRE_FIX));
        mesProductBillOfMaterial.setIsDeleted(0);
        boolean result = this.billOfMaterialMapper.insert(mesProductBillOfMaterial) > 0;
        List<BillOfMaterialDetail> detailList = mesProductBillOfMaterial.getBillOfMaterialDetailList();

        if (result) {
            boolean isHasData = detailList != null && detailList.size() > 0;
            if (isHasData) {
                // 添加明细
                detailList.forEach(f -> f.setMesProductBillOfMaterialId(mesProductBillOfMaterial.getId()));
                return billOfMaterialDetailMapper.insertBatch(mesProductBillOfMaterial.getBillOfMaterialDetailList()) > 0;
            }
            return true;
        }
        return true;
    }

    /**
     * 修改数据
     *
     * @param billOfMaterial 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(BillOfMaterialInsertOrUpdateDTO billOfMaterial) {
        // 新增参数 中的子集
        List<BillOfMaterialDetail> detailList = billOfMaterial.getBillOfMaterialDetailList();
        List<Integer> newIdList = detailList.stream().map(BillOfMaterialDetail::getId).collect(Collectors.toList());
        // 已存在数据
        List<BillOfMaterialDetailVO> oldList = billOfMaterialDetailMapper.listProductBillOfMaterialDetailByProductBillOfMaterialId(billOfMaterial.getId());


        boolean result = this.billOfMaterialMapper.update(billOfMaterial) > 0;
        if (result) {
            // 数据是否存在
            boolean isHasData = detailList != null && detailList.size() > 0;
            if (isHasData) {
                detailList.forEach(f ->{
                    if (f.getId() == null) {
                        f.setMesProductBillOfMaterialId(billOfMaterial.getId());
                        billOfMaterialDetailMapper.insert(f);
                    }else{
                        billOfMaterialDetailMapper.update(f);
                    }
                });
                // 删除
                List<BillOfMaterialDetail> deleteList = new ArrayList<>();
                for (BillOfMaterialDetail older : oldList) {
                    if (!newIdList.contains(older.getId())) {
                        deleteList.add(older);
                    }

                }
                deleteList.forEach(f-> billOfMaterialDetailMapper.deleteById(f.getId()));
            }
            return true;
        }

        return true;
    }

    @Override
    public boolean updateSelective(BillOfMaterial billOfMaterial) {
        return  billOfMaterialMapper.updateSelective(billOfMaterial) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.billOfMaterialMapper.deleteById(id) > 0;
    }

    /**
     * 根据id逻辑删除
     *
     * @param id 主键
     * @return
     */
    @Override
    public boolean removeById(Integer id) {
        return this.billOfMaterialMapper.removeById(id) > 0;
    }

}

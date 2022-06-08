package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.domain.MesWmsStockplacebind;
import com.bpm.mes.stock.server.dto.MesWmsStockplacebindDto;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplaceMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplacebindMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockplaceExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockplacebindService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.vo.MesWmsStockplacebindMaterialVo;
import com.bpm.mes.stock.server.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 库位绑定物料表(MesWmsStockplacebind)表服务实现类
 *
 * @author makejava
 * @since 2022-04-15 15:30:45
 */
@Service
public class MesWmsStockplacebindServiceImpl implements MesWmsStockplacebindService {
    @Resource
    private MesWmsStockplacebindMapper mesWmsStockplacebindMapper;

    @Resource
    private MesWmsStockplaceMapper stockplaceMapper;

    @Resource
    private MesWmsStockMapper stockMapper;

    @Resource
    private MesWmsStockplaceExtMapper extMapper;

    @Resource
    private MesWmsOtherMapper otherMapper;
        
    /**
     * 条件查询
     *
     * @param mesWmsStockplacebind 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MesWmsStockplacebind> queryAll(MesWmsStockplacebind mesWmsStockplacebind) {
        return this.mesWmsStockplacebindMapper.queryAll(mesWmsStockplacebind);
    }
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResultVO queryById(Integer id) {
       return ResultVO.create().success(this.mesWmsStockplacebindMapper.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param mesWmsStockplacebind 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfo<MesWmsStockplacebind> queryByPage(MesWmsStockplacebind mesWmsStockplacebind) {
         PageHelper.startPage(mesWmsStockplacebind.getPageNum(),mesWmsStockplacebind.getPageSize());
        List<MesWmsStockplacebind> mesWmsStockplacebindList = this.mesWmsStockplacebindMapper.queryAll(mesWmsStockplacebind);
        PageInfo<MesWmsStockplacebind> pageInfo = new PageInfo<>(mesWmsStockplacebindList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockplacebind 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO insert(MesWmsStockplacebind mesWmsStockplacebind) {
        if (this.mesWmsStockplacebindMapper.insert(mesWmsStockplacebind) > 0){
            return ResultVO.create().success("新增数据成功!");
        }
        return ResultVO.create().error("新增数据失败!");
    }

    /**
     * 修改数据
     *
     * @param mesWmsStockplacebind 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO update(MesWmsStockplacebind mesWmsStockplacebind) {
        if (this.mesWmsStockplacebindMapper.update(mesWmsStockplacebind) > 0){
            return ResultVO.create().success("数据编辑成功!");
        }
        return ResultVO.create().error("数据编辑失败!");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public ResultVO deleteById(Integer id) {
        if(this.mesWmsStockplacebindMapper.deleteById(id) > 0){
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }
    
    /**
     * 通过主键逻辑删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public ResultVO updateById(Integer id) {
        if(this.mesWmsStockplacebindMapper.updateById(id) > 0){
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 库位绑定物料表新增和编辑接口
     * @param stockplacebindDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEdit(MesWmsStockplacebindDto stockplacebindDto) {
        if (stockplacebindDto.getId() == null){
            MesWmsStockplacebind stockplacebind= new MesWmsStockplacebind();
            BeanUtils.copyProperties(stockplacebindDto, stockplacebind);
            //当前登录人信息
            UserVo userVo = otherMapper.queryCompany(stockplacebindDto.getCurrentloginId());
            BeanUtils.copyProperties(userVo,stockplacebind);
            //仓库信息
            if (stockplacebindDto.getStockId() != null){
                MesWmsStock stock = stockMapper.queryById(stockplacebindDto.getStockId());
                stockplacebind.setStockId(stock.getId());
                stockplacebind.setStockName(stock.getStockName());
                stockplacebind.setStockCode(stock.getStockCode());
            }

            //库区库位信息
            if (stockplacebindDto.getStockPlaceId() != null){
                MesWmsStockplace stockplace = stockplaceMapper.queryById(stockplacebindDto.getStockPlaceId());
                stockplacebind.setStockPlaceId(stockplace.getId());
                stockplacebind.setStockPlaceName(stockplace.getStockPlaceName());
                stockplacebind.setStockPlaceCode(stockplace.getStockPlaceCode());
            }

            //物料信息
            List<MesWmsStockplacebindMaterialVo> materialVos = extMapper.selectMaterial(stockplacebindDto.getMaterialId());
            MesWmsStockplacebindMaterialVo vo = materialVos.get(0);
//            stockplacebind.setMaterialTrId(vo.getMaterialTrId());
            stockplacebind.setMaterialCode(vo.getMaterialCode());
            stockplacebind.setMaterialId(vo.getMaterialId());
            stockplacebind.setMaterialShortName(vo.getMaterialShortName());
            stockplacebind.setMaterialSpec(vo.getMaterialSpec());
            stockplacebind.setUnitsId(vo.getUnitsId());
            stockplacebind.setUnitsName(vo.getUnitsName());
            stockplacebind.setWeight(vo.getWeight());
            stockplacebind.setWeightProduct(vo.getWeightProduct());

            stockplacebind.setCreateId(stockplacebindDto.getCurrentloginId());
            stockplacebind.setCreateName(stockplacebindDto.getCurrentloginName());
            stockplacebind.setCreateTime(LocalDateTime.now());
            stockplacebind.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockplacebindMapper.insert(stockplacebind);
            return ResultVO.create().success("库位绑定物料新增成功！");
        }else {
            MesWmsStockplacebind stockplacebind = mesWmsStockplacebindMapper.queryById(stockplacebindDto.getId());
            BeanUtils.copyProperties(stockplacebindDto, stockplacebind);
            //仓库信息
            if (stockplacebindDto.getStockId() != null){
                MesWmsStock stock = stockMapper.queryById(stockplacebindDto.getStockId());
                stockplacebind.setStockId(stock.getId());
                stockplacebind.setStockName(stock.getStockName());
                stockplacebind.setStockCode(stock.getStockCode());
            }

            //库区库位信息
            if (stockplacebindDto.getStockPlaceId() != null){
                MesWmsStockplace stockplace = stockplaceMapper.queryById(stockplacebindDto.getStockPlaceId());
                stockplacebind.setStockPlaceId(stockplace.getId());
                stockplacebind.setStockPlaceName(stockplace.getStockPlaceName());
                stockplacebind.setStockPlaceCode(stockplace.getStockPlaceCode());
            }

            //物料信息
            List<MesWmsStockplacebindMaterialVo> materialVos = extMapper.selectMaterial(stockplacebindDto.getMaterialId());
            MesWmsStockplacebindMaterialVo vo = materialVos.get(0);
//            stockplacebind.setMaterialTrId(vo.getMaterialTrId());
            stockplacebind.setMaterialCode(vo.getMaterialCode());
            stockplacebind.setMaterialId(vo.getMaterialId());
            stockplacebind.setMaterialShortName(vo.getMaterialShortName());
            stockplacebind.setMaterialSpec(vo.getMaterialSpec());
            stockplacebind.setUnitsId(vo.getUnitsId());
            stockplacebind.setUnitsName(vo.getUnitsName());
            stockplacebind.setWeight(vo.getWeight());
            stockplacebind.setWeightProduct(vo.getWeightProduct());

            stockplacebind.setUpdateId(stockplacebindDto.getCurrentloginId());
            stockplacebind.setUpdateName(stockplacebindDto.getCurrentloginName());
            stockplacebind.setUpdateTime(LocalDateTime.now());
            mesWmsStockplacebindMapper.edit(stockplacebind);
            return ResultVO.create().success("库位绑定物料编辑成功！");
        }
    }

    /**
     * 库位绑定物料表获取物料信息
     * @return
     */
    @Override
    public ResultVO selectMaterial() {
        List<MesWmsStockplacebindMaterialVo> stockplacebindMaterialVo = extMapper.selectMaterial(null);
        return ResultVO.create().success(stockplacebindMaterialVo);
    }
}

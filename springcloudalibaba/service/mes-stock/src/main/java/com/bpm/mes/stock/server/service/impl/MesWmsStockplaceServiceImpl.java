package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.domain.MesWmsStockplacebind;
import com.bpm.mes.stock.server.dto.MesWmsStockplaceDto;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplaceMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplacebindMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockplaceExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockplaceService;
import com.bpm.mes.stock.server.tree.MesWmsStockplaceTree;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库库位表(MesWmsStockplace)表服务实现类
 *
 * @author makejava
 * @since 2022-04-14 16:51:23
 */
@Service
public class MesWmsStockplaceServiceImpl implements MesWmsStockplaceService {

    @Resource
    private MesWmsStockplaceMapper mesWmsStockplaceMapper;

    @Resource
    private MesWmsStockplaceExtMapper extMapper;

    @Resource
    private MesWmsStockMapper stockMapper;

    @Resource
    private MesWmsOtherMapper otherMapper;

    @Resource
    private MesWmsStockplacebindMapper mesWmsStockplacebindMapper;

    /**
     * 条件查询
     *
     * @param mesWmsStockplace 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MesWmsStockplace> queryAll(MesWmsStockplace mesWmsStockplace) {
            
        return this.mesWmsStockplaceMapper.queryAll(mesWmsStockplace);
    }
        
 
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResultVO queryById(Integer id) {
        MesWmsStockplace mesWmsStockplace = this.mesWmsStockplaceMapper.queryById(id);
        return ResultVO.create().success(mesWmsStockplace);
    }

    /**
     * 分页查询
     *
     * @param mesWmsStockplace 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfo<MesWmsStockplace> queryByPage(MesWmsStockplace mesWmsStockplace) {
         PageHelper.startPage(mesWmsStockplace.getPageNum(),mesWmsStockplace.getPageSize());
        List<MesWmsStockplace> mesWmsStockplaceList = this.mesWmsStockplaceMapper.queryAll(mesWmsStockplace);
        PageInfo<MesWmsStockplace> pageInfo = new PageInfo<>(mesWmsStockplaceList);
        return pageInfo;
       
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockplace 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO insert(MesWmsStockplace mesWmsStockplace) {
        if (this.mesWmsStockplaceMapper.insert(mesWmsStockplace) > 0){
            return ResultVO.create().success("新增数据成功!");
        }
        return ResultVO.create().error("新增数据失败!");
    }

    /**
     * 修改数据
     *
     * @param mesWmsStockplace 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO update(MesWmsStockplace mesWmsStockplace) {
        if (this.mesWmsStockplaceMapper.update(mesWmsStockplace) > 0){
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
        if(this.mesWmsStockplaceMapper.deleteById(id) > 0){
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
        MesWmsStockplacebind stockplacebind = new MesWmsStockplacebind();
        stockplacebind.setStockPlaceId(id);
        stockplacebind.setIsValid(CommonConstantUtils.NOT_DELETE);
        List<MesWmsStockplacebind> mesWmsStockplacebinds = mesWmsStockplacebindMapper.queryAll(stockplacebind);
        if (mesWmsStockplacebinds.size()>0){
            return ResultVO.create().error("此库存下面存在安全库存，不允许删除!");
        }
        if(this.mesWmsStockplaceMapper.updateById(id) > 0){
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 树状查询
     * @return
     */
    @Override
    public ResultVO queryTree(String stockType) {
        //查询所有树节点
        List<MesWmsStockplaceTree> stockplaceTrees = extMapper.queryTree(stockType);
        if(stockplaceTrees.size() == 0 || stockplaceTrees == null){
            return ResultVO.create().success(stockplaceTrees);
        }
        Map<String,MesWmsStockplaceTree> map = new HashMap<>();
        //数据组装以id为key对象为value
        for (MesWmsStockplaceTree stockplaceTree : stockplaceTrees)
        {
            map.put(stockplaceTree.getStockPlaceCode(),stockplaceTree);
        }
        List<MesWmsStockplaceTree> stockplaceTreeList = new ArrayList<>();
        for (MesWmsStockplaceTree stockplaceTree : stockplaceTrees)
        {
            //组装父节点
            if(stockplaceTree.getParentId() == null){
                stockplaceTree.setLayerNum(0);
                stockplaceTreeList.add(stockplaceTree);
            }else{//组装子节点
                MesWmsStockplaceTree node = map.get(stockplaceTree.getParentStockPlacenCode());
                if(node!=null){
                    List<MesWmsStockplaceTree> children = node.getChildren();
                    children.add(stockplaceTree);
                }
            }
        }
        return ResultVO.create().success(stockplaceTreeList);
    }

    /**
     * 仓库库位新增和编辑接口
     * @param stockplaceDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEdit(MesWmsStockplaceDto stockplaceDto) {
        if (stockplaceDto.getId() == null){
            MesWmsStockplace stockplace= new MesWmsStockplace();
            stockplace.setStockPlaceCode(stockplaceDto.getStockPlaceCode());
            long count = mesWmsStockplaceMapper.count(stockplace);
            if (count>0){
                return ResultVO.create().error("仓库库位编码已存在！");
            }
            BeanUtils.copyProperties(stockplaceDto, stockplace);
            if (stockplaceDto.getLayerNum() == CommonConstantUtils.STOCKPLACE_LAYERNUM){
                MesWmsStock stock = stockMapper.queryById(stockplaceDto.getParentId());
                stockplace.setStockId(stock.getId());
                stockplace.setStockCode(stock.getStockCode());
                stockplace.setStockName(stock.getStockName());
                stockplace.setParentId(stock.getId());
                stockplace.setParentStockPlacenCode(stock.getStockCode());
                stockplace.setParentStockPlacenName(stock.getStockName());
            }else {
                MesWmsStockplace place = mesWmsStockplaceMapper.queryById(stockplaceDto.getParentId());
                //仓库信息
                stockplace.setStockId(place.getStockId());
                stockplace.setStockCode(place.getStockCode());
                stockplace.setStockName(place.getStockName());
                //父节信息 库区库位
                stockplace.setParentId(place.getId());
                stockplace.setParentStockPlacenCode(place.getStockPlaceCode());
                stockplace.setParentStockPlacenName(place.getStockPlaceName());
            }
            //当前登录人信息
            UserVo userVo = otherMapper.queryCompany(stockplaceDto.getCurrentloginId());
            BeanUtils.copyProperties(userVo,stockplace);
            stockplace.setLayerNum(stockplaceDto.getLayerNum()+1);
            stockplace.setCreateId(stockplaceDto.getCurrentloginId());
            stockplace.setCreateName(stockplaceDto.getCurrentloginName());
            stockplace.setCreateTime(LocalDateTime.now());
//            stockplace.setState(CommonConstantUtils.STOCKPLACE_TYPE_OCCUPY);
            stockplace.setIsLeaf(CommonConstantUtils.IS_LEAF_YES);
            stockplace.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockplaceMapper.insert(stockplace);
            return ResultVO.create().success("仓库库位新增成功！");
        }else {
            MesWmsStockplace stockplace = mesWmsStockplaceMapper.queryById(stockplaceDto.getId());
            if (!stockplaceDto.getStockPlaceCode().equals(stockplace.getStockPlaceCode())){
                return ResultVO.create().error("仓库库位编码不能修改！");
            }
            BeanUtils.copyProperties(stockplaceDto, stockplace);
            if (stockplaceDto.getLayerNum() == CommonConstantUtils.STOCKPLACE_LAYERNUM){
                MesWmsStock stock = stockMapper.queryById(stockplaceDto.getParentId());
                stockplace.setStockId(stock.getId());
                stockplace.setStockCode(stock.getStockCode());
                stockplace.setStockName(stock.getStockName());
                stockplace.setParentId(stock.getId());
                stockplace.setParentStockPlacenCode(stock.getStockCode());
                stockplace.setParentStockPlacenName(stock.getStockName());
            }else {
                MesWmsStockplace place = mesWmsStockplaceMapper.queryById(stockplaceDto.getParentId());
                //仓库信息
                stockplace.setStockId(place.getStockId());
                stockplace.setStockCode(place.getStockCode());
                stockplace.setStockName(place.getStockName());
                //父节信息 库区库位
                stockplace.setParentId(place.getId());
                stockplace.setParentStockPlacenCode(place.getStockPlaceCode());
                stockplace.setParentStockPlacenName(place.getStockPlaceName());
            }
            stockplace.setLayerNum(stockplaceDto.getLayerNum()+1);
            stockplace.setUpdateId(stockplaceDto.getCurrentloginId());
            stockplace.setUpdateName(stockplaceDto.getCurrentloginName());
            stockplace.setUpdateTime(LocalDateTime.now());
            stockplace.setIsLeaf(CommonConstantUtils.IS_LEAF_YES);
            stockplace.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockplaceMapper.edit(stockplace);
            return ResultVO.create().success("仓库库位编码编辑成功！");
        }
    }

}

package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.dto.MesWmsStockDto;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplaceMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.vo.StockDepartMentUserVo;
import com.bpm.mes.stock.server.vo.StockManagerUserVo;
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
 * 仓库信息表(MesWmsStock)表服务实现类
 *
 * @author makejava
 * @since 2022-04-14 09:59:16
 */
@Service
public class MesWmsStockServiceImpl implements MesWmsStockService {
    @Resource
    private MesWmsStockMapper mesWmsStockMapper;

    @Resource
    private MesWmsStockExtMapper mesWmsStockExtMapper;

    @Resource
    private MesWmsOtherMapper otherMapper;

    @Resource
    private MesWmsStockplaceMapper placeMapper;

    /**
     * 条件查询
     *
     * @param mesWmsStock 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MesWmsStock> queryAll(MesWmsStock mesWmsStock) {
        return this.mesWmsStockMapper.queryAll(mesWmsStock);
    }
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MesWmsStock queryById(Integer id) {
        return this.mesWmsStockMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param mesWmsStock 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfo<MesWmsStock> queryByPage(MesWmsStock mesWmsStock) {
        PageHelper.startPage(mesWmsStock.getPageNum(),mesWmsStock.getPageSize());
//        List<MesWmsStock> mesWmsStockList = this.mesWmsStockMapper.queryAll(mesWmsStock);
        List<MesWmsStock> mesWmsStockList = this.mesWmsStockExtMapper.queryAll(mesWmsStock);
        PageInfo<MesWmsStock> pageInfo = new PageInfo<>(mesWmsStockList);
        return pageInfo;
       
    }

    /**
     * 新增数据
     *
     * @param mesWmsStock 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO insert(MesWmsStock mesWmsStock) {
        if (this.mesWmsStockMapper.insert(mesWmsStock) > 0){
            return ResultVO.create().success("新增数据成功");
        }
        return ResultVO.create().error("新增数据失败");
    }

    /**
     * 修改数据
     *
     * @param mesWmsStock 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO update(MesWmsStock mesWmsStock) {
        if (this.mesWmsStockMapper.update(mesWmsStock) > 0){
            return ResultVO.create().success("编辑成功");
        }
        return ResultVO.create().error("编辑失败");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public ResultVO deleteById(Integer id) {
        if (this.mesWmsStockMapper.deleteById(id) > 0){
            return ResultVO.create().success("数据删除成功");
        }
        return ResultVO.create().error("数据删除成功");
    }

    /**
     * 通过主键逻辑删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public ResultVO updateById(Integer id) {
        MesWmsStockplace stockplace = new MesWmsStockplace();
        stockplace.setStockId(id);
        stockplace.setIsValid(CommonConstantUtils.NOT_DELETE);
        List<MesWmsStockplace> mesWmsStockplaces = placeMapper.queryAll(stockplace);
        if (mesWmsStockplaces.size()>0){
            return ResultUtil.error("该仓库下面存在库区库位，不能删除");
        }
        if(this.mesWmsStockMapper.updateById(id) > 0){
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 查询库管员信息
     * @return
     */
    @Override
    public ResultVO queryManager() {
        List<StockManagerUserVo> stockManagerUserResultVO = mesWmsStockExtMapper.queryManager();
        return ResultVO.create().success(stockManagerUserResultVO);
    }

    /**
     * 查询部门信息
     * @return
     */
    @Override
    public ResultVO queryDepartment() {
        List<StockDepartMentUserVo> stockDepartMentUserVos = mesWmsStockExtMapper.queryDepartment();
        return ResultVO.create().success(stockDepartMentUserVos);
    }

    /**
     * 仓库信息新增和编辑接口
     * @param mesWmsStockDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEdit(MesWmsStockDto mesWmsStockDto) {
        if (mesWmsStockDto.getId() == null){
            MesWmsStock stock = new MesWmsStock();

            stock.setStockCode(mesWmsStockDto.getStockCode());
            long count = mesWmsStockMapper.count(stock);
            if (count>0){
                return ResultVO.create().error("仓库编码已存在！");
            }
            BeanUtils.copyProperties(mesWmsStockDto, stock);
            //当前登录人信息
            UserVo userVo = otherMapper.queryCompany(mesWmsStockDto.getCurrentloginId());
            BeanUtils.copyProperties(userVo,stock);
            stock.setCreateId(mesWmsStockDto.getCurrentloginId());
            stock.setCreateName(mesWmsStockDto.getCurrentloginName());
            stock.setCreateTime(LocalDateTime.now());
            stock.setState(CommonConstantUtils.CTOCK_STATE_ISUSE);
            stock.setIsLeaf(CommonConstantUtils.IS_LEAF_NO);
            stock.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockMapper.insert(stock);
            return ResultVO.create().success("仓库信息新增成功！");
        }else {
            MesWmsStock stock = mesWmsStockMapper.queryById(mesWmsStockDto.getId());
            if (!mesWmsStockDto.getStockCode().equals(stock.getStockCode())){
                return ResultVO.create().error("仓库编码不允许修改！");
            }
            BeanUtils.copyProperties(mesWmsStockDto, stock);
            stock.setUpdateId(mesWmsStockDto.getCurrentloginId());
            stock.setUpdateName(mesWmsStockDto.getCurrentloginName());
            stock.setUpdateTime(LocalDateTime.now());
            stock.setState(CommonConstantUtils.CTOCK_STATE_ISUSE);
            stock.setIsLeaf(CommonConstantUtils.IS_LEAF_NO);
            stock.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockMapper.edit(stock);
            return ResultVO.create().success("仓库信息编辑成功！");
        }
    }

    /**
     * 仓库信息盘点
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO inventoryEdit(Integer id) {
        if (id==null){
            return ResultVO.create().error("盘点数据不存在！");
        }
        MesWmsStock stock = mesWmsStockMapper.queryById(id);
        if (CommonConstantUtils.CHECK_STATE_INVENTORY.equals(stock.getState())){
            stock.setId(id);
            stock.setState(CommonConstantUtils.CTOCK_STATE_ISUSE);
            mesWmsStockMapper.update(stock);
            return ResultVO.create().success("数据已恢复为在用状态！");
        }else {
            stock.setId(id);
            stock.setState(CommonConstantUtils.CHECK_STATE_INVENTORY);
            mesWmsStockMapper.update(stock);
            return ResultVO.create().success("数据已改为盘点状态！");
        }
    }
}

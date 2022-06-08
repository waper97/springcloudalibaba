package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrent;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrentsum;
import com.bpm.mes.stock.server.domain.MesWmsStockmoveplace;
import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.dto.MesWmsStockcurrentDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcurrentQueryDto;
import com.bpm.mes.stock.server.dto.MesWmsStockmoveplaceNewstDto;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentsumMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockmoveplaceMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplaceMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockcurrentExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockmoveplaceExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockcurrentService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.util.NumAddUtil;
import com.bpm.mes.stock.server.vo.MesWmsStockcurrentStockVo;
import com.bpm.mes.stock.server.vo.StockOtherVo;
import com.bpm.mes.stock.server.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 仓库即时库存明细表(MesWmsStockcurrent)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 14:55:55
 */
@Service
public class MesWmsStockcurrentServiceImpl implements MesWmsStockcurrentService {
    @Resource
    private MesWmsStockcurrentMapper mesWmsStockcurrentMapper;
    @Resource
    private MesWmsStockplaceMapper stockplaceMapper;
    @Resource
    private MesWmsStockMapper stockMapper;
    @Resource
    private MesWmsStockcurrentExtMapper extMapper;
    @Resource
    private MesWmsStockcurrentsumMapper sumMapper;
    @Resource
    private MesWmsStockmoveplaceMapper moveplaceMapper;
    @Resource
    private MesWmsStockmoveplaceExtMapper placeExtMapper;
    @Resource
    private MesWmsOtherMapper otherMapper;


    /**
     * 条件查询
     *
     * @param mesWmsStockcurrentQueryDto 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MesWmsStockcurrent> queryAll(MesWmsStockcurrentQueryDto mesWmsStockcurrentQueryDto) {
        MesWmsStockcurrent mesWmsStockcurrent = new MesWmsStockcurrent();
        BeanUtils.copyProperties(mesWmsStockcurrentQueryDto,mesWmsStockcurrent);
        return this.mesWmsStockcurrentMapper.queryAll(mesWmsStockcurrent);
    }
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResultVO queryById(Integer id) {
       return ResultVO.create().success(this.mesWmsStockcurrentMapper.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param mesWmsStockcurrentQueryDto 筛选条件
     * @return 查询结果
     */
    @Override
    public ResultVO<PageInfoVO<List<MesWmsStockcurrent>>> queryByPage(MesWmsStockcurrentQueryDto mesWmsStockcurrentQueryDto) {
        MesWmsStockcurrent mesWmsStockcurrent = new MesWmsStockcurrent();
        BeanUtils.copyProperties(mesWmsStockcurrentQueryDto,mesWmsStockcurrent);
        PageHelper.startPage(mesWmsStockcurrentQueryDto.getPageNum(),mesWmsStockcurrentQueryDto.getPageSize());
        List<MesWmsStockcurrent> mesWmsStockcurrentList = this.mesWmsStockcurrentMapper.queryAll(mesWmsStockcurrent);
        PageInfo<MesWmsStockcurrent> pageInfo = new PageInfo<>(mesWmsStockcurrentList);
        PageInfoVO pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockcurrent 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO insert(MesWmsStockcurrent mesWmsStockcurrent) {
        if (this.mesWmsStockcurrentMapper.insert(mesWmsStockcurrent) > 0){
            return ResultVO.create().success("新增数据成功!");
        }
        return ResultVO.create().error("新增数据失败!");
    }

    /**
     * 修改数据
     *
     * @param mesWmsStockcurrent 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO update(MesWmsStockcurrent mesWmsStockcurrent) {
        if (this.mesWmsStockcurrentMapper.update(mesWmsStockcurrent) > 0){
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
        if(this.mesWmsStockcurrentMapper.deleteById(id) > 0){
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
        if(this.mesWmsStockcurrentMapper.updateById(id) > 0){
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 查询仓库信息-用于查询条件
     * @return
     */
    @Override
    public ResultVO selectStock() {
        List<MesWmsStockcurrentStockVo> stockVo = extMapper.selectStock();
        return ResultVO.create().success(stockVo);
    }

    /**
     * 库位转移
     * @param mesWmsStockcurrentDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO stockMovePlace(MesWmsStockcurrentDto mesWmsStockcurrentDto) {
        MesWmsStockcurrent mesWmsStockcurrent = mesWmsStockcurrentMapper.queryById(mesWmsStockcurrentDto.getId());
        if(mesWmsStockcurrent != null){
            if (mesWmsStockcurrentDto.getMoveQty().compareTo(mesWmsStockcurrent.getQty()) < 1){
                //修改即时库存主表信息
                MesWmsStockcurrentsum mesWmsStockcurrentsums1 = sumMapper.queryById(mesWmsStockcurrent.getStockCurrentSumId());
                MesWmsStock stock = stockMapper.queryById(mesWmsStockcurrentsums1.getStockId());
                if (CommonConstantUtils.CHECK_STATE_INVENTORY.equals(stock.getState())){
                    return ResultVO.create().error("移除仓库正在盘点中无法转移！");
                }
                //获取新的库区库位信息
                MesWmsStockplace stockplace = stockplaceMapper.queryById(mesWmsStockcurrentDto.getStockPlaceIdNew());
                stock = stockMapper.queryById(stockplace.getStockId());
                if (CommonConstantUtils.CHECK_STATE_INVENTORY.equals(stock.getState())){
                    return ResultVO.create().error("移入仓库正在盘点中无法转移！");
                }

                MesWmsStockcurrentsum sum = new MesWmsStockcurrentsum();
                BigDecimal qty = mesWmsStockcurrentsums1.getQty().subtract(mesWmsStockcurrentDto.getMoveQty());
                if (qty.compareTo(new BigDecimal("0")) == -1){
//                    sum.setIsValid(CommonConstantUtils.DELETE);
                    return ResultVO.create().error("仓库库存数量不足，无法转移！");
                }
                if (qty.compareTo(new BigDecimal("0")) == 0){
                    sum.setIsValid(CommonConstantUtils.DELETE);
                }
                sum.setId(mesWmsStockcurrent.getStockCurrentSumId());
                sum.setQty(qty);
                sum.setQtyUseable(qty);
                sum.setUpdateId(mesWmsStockcurrentDto.getCurrentloginId());
                sum.setUpdateName(mesWmsStockcurrentDto.getCurrentloginName());
                sum.setUpdateTime(LocalDateTime.now());
                sumMapper.update(sum);

                //修改即时库存明细表信息
                MesWmsStockcurrent current = new MesWmsStockcurrent();
                qty = mesWmsStockcurrent.getQty().subtract(mesWmsStockcurrentDto.getMoveQty());
                if (qty.compareTo(new BigDecimal("0")) == -1){
//                    current.setIsValid(CommonConstantUtils.DELETE);
                    return ResultVO.create().error("库位库存数量不足，无法转移！");
                }
                if (qty.compareTo(new BigDecimal("0")) == 0){
                    current.setIsValid(CommonConstantUtils.DELETE);
                }
                current.setId(mesWmsStockcurrent.getId());
                current.setQty(qty);
                current.setQtyUseable(qty);
                current.setUpdateId(mesWmsStockcurrentDto.getCurrentloginId());
                current.setUpdateName(mesWmsStockcurrentDto.getCurrentloginName());
                current.setUpdateTime(LocalDateTime.now());
                mesWmsStockcurrentMapper.update(current);

                //即时库存主表信息存在修改，不存在新增
                MesWmsStockcurrentsum sum2 = new MesWmsStockcurrentsum();
                sum2.setStockCode(stockplace.getStockCode());
                sum2.setMaterialCode(mesWmsStockcurrent.getMaterialCode());
                List<MesWmsStockcurrentsum> mesWmsStockcurrentsums = sumMapper.queryAll(sum2);
                MesWmsStockcurrentsum sum1 =new MesWmsStockcurrentsum();
                if (mesWmsStockcurrentsums.size() < 1){
                    sum1.setStockCode(stockplace.getStockCode());
                    sum1.setStockId(stockplace.getStockId());
                    sum1.setStockName(stockplace.getStockName());
                    sum1.setMaterialId(mesWmsStockcurrent.getMaterialId());
                    sum1.setMaterialCode(mesWmsStockcurrent.getMaterialCode());
                    sum1.setMaterialShortName(mesWmsStockcurrent.getMaterialShortName());
                    sum1.setMaterialSpec(mesWmsStockcurrent.getMaterialSpec());
                    sum1.setMaterialTrId(mesWmsStockcurrent.getMaterialTrId());
                    sum1.setUnitsId(mesWmsStockcurrent.getUnitsId());
                    sum1.setUnitsName(mesWmsStockcurrent.getUnitsName());
                    sum1.setQty(mesWmsStockcurrentDto.getMoveQty());
                    sum1.setQtyUseable(mesWmsStockcurrentDto.getMoveQty());
                    sum1.setQtyAllot(mesWmsStockcurrentDto.getMoveQty());
                    sum1.setQtyFreeze(mesWmsStockcurrentDto.getMoveQty());
                    sum1.setStockQty(mesWmsStockcurrentDto.getMoveQty());
                    sum1.setRemark(mesWmsStockcurrentDto.getRemark());
                    sum1.setCreateId(mesWmsStockcurrentDto.getCurrentloginId());
                    sum1.setCreateName(mesWmsStockcurrentDto.getCurrentloginName());
                    sum1.setCreateTime(LocalDateTime.now());
                    sum1.setIsValid(CommonConstantUtils.NOT_DELETE);
                    sumMapper.insert(sum1);
                }else{
                    sum1 = mesWmsStockcurrentsums.get(0);
                    qty = sum1.getQty().add(mesWmsStockcurrentDto.getMoveQty());
                    sum1.setQty(qty);
                    sum1.setQtyUseable(qty);
                    sum1.setUpdateId(mesWmsStockcurrentDto.getCurrentloginId());
                    sum1.setUpdateName(mesWmsStockcurrentDto.getCurrentloginName());
                    sum1.setUpdateTime(LocalDateTime.now());
                    sumMapper.update(sum1);
                }
                //新增即时库存明细表信息
                //修改即时库存明细表信息
                MesWmsStockcurrent current2 = new MesWmsStockcurrent();
                current2.setStockCurrentSumId(sum1.getId());
                current2.setStockCode(sum1.getStockCode());
                current2.setStockPlaceCode(stockplace.getStockPlaceCode());
                current2.setMaterialCode(mesWmsStockcurrent.getMaterialCode());
                current2.setInBatchNo(mesWmsStockcurrent.getInBatchNo());
                List<MesWmsStockcurrent> mesWmsStockcurrents = mesWmsStockcurrentMapper.queryAll(current2);
                MesWmsStockcurrent current1 = new MesWmsStockcurrent();
                if (mesWmsStockcurrents.size()<1){
                    BeanUtils.copyProperties(mesWmsStockcurrent,current1);
                    current1.setId(null);
                    current1.setStockId(stockplace.getStockId());
                    current1.setStockCode(stockplace.getStockCode());
                    current1.setStockName(stockplace.getStockName());
                    current1.setStockCurrentSumId(sum1.getId());
                    current1.setStockPlaceId(stockplace.getId());
                    current1.setStockPlaceCode(stockplace.getStockPlaceCode());
                    current1.setStockPlaceName(stockplace.getStockPlaceName());
                    current1.setCreateId(mesWmsStockcurrentDto.getCurrentloginId());
                    current1.setCreateName(mesWmsStockcurrentDto.getCurrentloginName());
                    current1.setCreateTime(LocalDateTime.now());
                    current1.setQty(mesWmsStockcurrentDto.getMoveQty());
                    current1.setQtyUseable(mesWmsStockcurrentDto.getMoveQty());
                    current1.setQtyAllot(mesWmsStockcurrentDto.getMoveQty());
                    current1.setQtyFreeze(mesWmsStockcurrentDto.getMoveQty());
                    current1.setStockQty(mesWmsStockcurrentDto.getMoveQty());
                    current1.setRemark(mesWmsStockcurrentDto.getRemark());
                    current1.setIsValid(CommonConstantUtils.NOT_DELETE);
                    current1.setUpdateId(null);
                    current1.setUpdateName(null);
                    current1.setUpdateTime(null);
                    mesWmsStockcurrentMapper.insert(current1);
                }else {
                    current1 = mesWmsStockcurrents.get(0);
                    qty = current1.getQty().add(mesWmsStockcurrentDto.getMoveQty());
                    current1.setQty(qty);
                    current1.setQtyUseable(qty);
                    current1.setUpdateId(mesWmsStockcurrentDto.getCurrentloginId());
                    current1.setUpdateName(mesWmsStockcurrentDto.getCurrentloginName());
                    current1.setUpdateTime(LocalDateTime.now());
                    mesWmsStockcurrentMapper.update(current1);
                }


                //新增库位转移信息
                MesWmsStockmoveplace moveplace = new MesWmsStockmoveplace();
                BeanUtils.copyProperties(mesWmsStockcurrent,moveplace);
                UserVo userVo = otherMapper.queryCompany(mesWmsStockcurrentDto.getCurrentloginId());
                BeanUtils.copyProperties(userVo,moveplace);
                //查询移除单据编码
                String recordCode = placeExtMapper.queryMoveCode();
                if (StringUtils.isEmpty(recordCode)) {
                    moveplace.setMoveCode(CommonConstantUtils.STOCKMOVEPLACE_CODE);
                } else {
                    moveplace.setMoveCode(NumAddUtil.addOrderNum(recordCode,9));
                }
                moveplace.setMovePlaceDate(mesWmsStockcurrentDto.getMovePlaceDate());
                moveplace.setPostingPlaceDate(mesWmsStockcurrentDto.getPostingPlaceDate());
                moveplace.setStockPlaceIdSource(mesWmsStockcurrent.getStockPlaceId());
                moveplace.setStockPlaceCodeSource(mesWmsStockcurrent.getStockPlaceCode());
                moveplace.setStockPlaceNameSource(mesWmsStockcurrent.getStockPlaceName());
                moveplace.setStockPlaceIdNew(current1.getStockPlaceId());
                moveplace.setStockPlaceCodeNew(current1.getStockPlaceCode());
                moveplace.setStockPlaceNameNew(current1.getStockPlaceName());
                moveplace.setId(null);

                moveplace.setRemark(mesWmsStockcurrentDto.getRemark());
                moveplace.setMoveType(mesWmsStockcurrentDto.getMoveType());
                //经办人
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(mesWmsStockcurrentDto.getDisposerId());
                List<StockOtherVo> stockOtherVos = otherMapper.queryUser(stockOtherVo);
                if (stockOtherVos != null && stockOtherVos.size() > 0){
                    moveplace.setDisposerId(stockOtherVos.get(0).getId());
                    moveplace.setDisposer(stockOtherVos.get(0).getName());
                }
                moveplace.setIsValid(CommonConstantUtils.NOT_DELETE);
                moveplace.setState(CommonConstantUtils.STOCKMOVENPLACE_STATE_ADD);
                moveplace.setStockCurrentId(mesWmsStockcurrent.getId());
                moveplace.setCreateId(mesWmsStockcurrentDto.getCurrentloginId());
                moveplace.setCreateName(mesWmsStockcurrentDto.getCurrentloginName());
                moveplace.setCreateTime(LocalDateTime.now());
                moveplace.setQty(mesWmsStockcurrentDto.getMoveQty());
                moveplace.setQtyUseable(mesWmsStockcurrentDto.getMoveQty());
                moveplaceMapper.insert(moveplace);
                return ResultVO.create().success("库存转移成功!");
            }
            return ResultVO.create().error("库存转移数量不能大于实际数量!");
        }
        return ResultVO.create().error("数据错误,数据可能不存在!");
    }

    /**
     * 查询仓库库位信息-用于库位转移查询条件
     * @return
     */
    @Override
    public ResultVO selectStockPlace(Integer stockId) {
        List<MesWmsStockmoveplaceNewstDto> newstDtos = extMapper.selectStockPlace(stockId);
        return ResultVO.create().success(newstDtos);
    }
}

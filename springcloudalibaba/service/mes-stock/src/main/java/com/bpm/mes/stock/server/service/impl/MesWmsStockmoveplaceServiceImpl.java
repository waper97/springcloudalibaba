package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrent;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrentsum;
import com.bpm.mes.stock.server.domain.MesWmsStockmoveplace;
import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.dto.MesWmsStockListDto;
import com.bpm.mes.stock.server.dto.MesWmsStockPlaceListDto;
import com.bpm.mes.stock.server.dto.MesWmsStockPlaceMaterialListDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcurrentDto;
import com.bpm.mes.stock.server.dto.MesWmsStockmoveplaceQueryDto;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentsumMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockmoveplaceMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplaceMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockmoveplaceExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockmoveplaceService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.util.NumAddUtil;
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
 * 仓库库位转移表(MesWmsStockmoveplace)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 17:38:48
 */
@Service
public class MesWmsStockmoveplaceServiceImpl implements MesWmsStockmoveplaceService {
    @Resource
    private MesWmsStockmoveplaceMapper mesWmsStockmoveplaceMapper;
    @Resource
    private MesWmsStockmoveplaceExtMapper placeExtMapper;
    @Resource
    private MesWmsStockcurrentMapper mesWmsStockcurrentMapper;
    @Resource
    private MesWmsStockplaceMapper stockplaceMapper;
    @Resource
    private MesWmsStockMapper stockMapper;
    @Resource
    private MesWmsStockcurrentsumMapper sumMapper;
    @Resource
    private MesWmsOtherMapper otherMapper;

    /**
     * 条件查询
     *
     * @param mesWmsStockmoveplaceQueryDto 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MesWmsStockmoveplace> queryAll(MesWmsStockmoveplaceQueryDto mesWmsStockmoveplaceQueryDto) {
        MesWmsStockmoveplace mesWmsStockmoveplace = new MesWmsStockmoveplace();
        BeanUtils.copyProperties(mesWmsStockmoveplaceQueryDto,mesWmsStockmoveplace);
        return this.mesWmsStockmoveplaceMapper.queryAll(mesWmsStockmoveplace);
    }
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResultVO queryById(Integer id) {
       return ResultVO.create().success(this.mesWmsStockmoveplaceMapper.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param mesWmsStockmoveplaceQueryDto 筛选条件
     * @return 查询结果
     */
    @Override
    public ResultVO<PageInfoVO<List<MesWmsStockmoveplace>>> queryByPage(MesWmsStockmoveplaceQueryDto mesWmsStockmoveplaceQueryDto) {
//        MesWmsStockmoveplace mesWmsStockmoveplace = new MesWmsStockmoveplace();
//        BeanUtils.copyProperties(mesWmsStockmoveplaceQueryDto,mesWmsStockmoveplace);
        PageHelper.startPage(mesWmsStockmoveplaceQueryDto.getPageNum(),mesWmsStockmoveplaceQueryDto.getPageSize());
//        List<MesWmsStockmoveplace> mesWmsStockmoveplaceList = this.mesWmsStockmoveplaceMapper.queryAll(mesWmsStockmoveplace);
        List<MesWmsStockmoveplace> mesWmsStockmoveplaceList = this.placeExtMapper.queryAll(mesWmsStockmoveplaceQueryDto);
        PageInfo<MesWmsStockmoveplace> pageInfo = new PageInfo<>(mesWmsStockmoveplaceList);
        PageInfoVO pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockmoveplace 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO insert(MesWmsStockmoveplace mesWmsStockmoveplace) {
        if (this.mesWmsStockmoveplaceMapper.insert(mesWmsStockmoveplace) > 0){
            return ResultVO.create().success("新增数据成功!");
        }
        return ResultVO.create().error("新增数据失败!");
    }

    /**
     * 修改数据
     *
     * @param mesWmsStockmoveplace 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO update(MesWmsStockmoveplace mesWmsStockmoveplace) {
        if (this.mesWmsStockmoveplaceMapper.update(mesWmsStockmoveplace) > 0){
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
        if(this.mesWmsStockmoveplaceMapper.deleteById(id) > 0){
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
        if(this.mesWmsStockmoveplaceMapper.updateById(id) > 0){
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 查询仓库-库区库位-物料
     * @return
     */
    @Override
    public ResultVO selectMaterial(Integer stockId,Integer stockPlaceId) {
        //获取仓库信息
        List<MesWmsStockListDto>  stockListDtos = placeExtMapper.selectStock(stockId);
        stockListDtos.forEach(stockListDto ->{
            //查询库区库位信息
            List<MesWmsStockPlaceListDto> stockPlaceListDtos = placeExtMapper.selectStockPlace(stockListDto.getStockId(),stockPlaceId);
            stockPlaceListDtos.forEach(PlaceListDto ->{
                //查询物料信息
                List<MesWmsStockPlaceMaterialListDto> materialListDtos = placeExtMapper.selectStockPlaceMaterial(PlaceListDto.getStockPlaceId());
                PlaceListDto.setMaterialListDtos(materialListDtos);
            });
            stockListDto.setStockPlaceListDtos(stockPlaceListDtos);
        });
        return ResultVO.create().success(stockListDtos);
    }

    /**
     * 仓库库位转移新增和编辑接口
     * @param mesWmsStockcurrentDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEdit(MesWmsStockcurrentDto mesWmsStockcurrentDto) {
        //及时库存明细表数据
        MesWmsStockcurrent mesWmsStockcurrent = mesWmsStockcurrentMapper.queryById(mesWmsStockcurrentDto.getStockCurrentId());
        //修改即时库存主表信息
        MesWmsStockcurrentsum sum1 = sumMapper.queryById(mesWmsStockcurrent.getStockCurrentSumId());
        if(mesWmsStockcurrent != null){
            if (mesWmsStockcurrentDto.getMoveQty().compareTo(mesWmsStockcurrent.getQty()) < 1){
                UserVo userVo = otherMapper.queryCompany(mesWmsStockcurrentDto.getCurrentloginId());
                MesWmsStock stock = stockMapper.queryById(sum1.getStockId());
                if (CommonConstantUtils.CHECK_STATE_INVENTORY.equals(stock.getState())){
                    return ResultVO.create().error("移除仓库正在盘点中无法转移！");
                }
                //获取新的库区库位信息
                MesWmsStockplace stockplace = stockplaceMapper.queryById(mesWmsStockcurrentDto.getStockPlaceIdNew());
                stock = stockMapper.queryById(stockplace.getStockId());
                if (CommonConstantUtils.CHECK_STATE_INVENTORY.equals(stock.getState())){
                    return ResultVO.create().error("移入仓库正在盘点中无法转移！");
                }

                //修改即时库存明细表信息
                MesWmsStockcurrent current = new MesWmsStockcurrent();
                BigDecimal qty = mesWmsStockcurrent.getQty().subtract(mesWmsStockcurrentDto.getMoveQty());
                if (qty.compareTo(new BigDecimal("0")) == -1){
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

                //新增即时库存明细表信息
                //修改即时库存明细表信息
                MesWmsStockcurrent current2 = new MesWmsStockcurrent();
                current2.setStockCurrentSumId(sum1.getId());
                current2.setStockCode(sum1.getStockCode());
                current2.setStockPlaceCode(stockplace.getStockPlaceCode());
                current2.setInBatchNo(mesWmsStockcurrent.getInBatchNo());
                current2.setMaterialCode(stockplace.getMaterialCode());
                List<MesWmsStockcurrent> mesWmsStockcurrents = mesWmsStockcurrentMapper.queryAll(current2);
                MesWmsStockcurrent current1 = new MesWmsStockcurrent();
                if (mesWmsStockcurrents.size()<1){
                    BeanUtils.copyProperties(mesWmsStockcurrent,current1);

                    current1.setId(null);
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
                    current1.setIsValid(CommonConstantUtils.NOT_DELETE);
                    mesWmsStockcurrentMapper.insert(current1);
                }else {
                    current1 = mesWmsStockcurrents.get(0);
                    qty = current1.getQty().add(mesWmsStockcurrentDto.getMoveQty());
                    current1.setIsValid(CommonConstantUtils.NOT_DELETE);
                    current1.setQty(qty);
                    current1.setQtyUseable(qty);
                    current1.setUpdateId(mesWmsStockcurrentDto.getCurrentloginId());
                    current1.setUpdateName(mesWmsStockcurrentDto.getCurrentloginName());
                    current1.setUpdateTime(LocalDateTime.now());
                    mesWmsStockcurrentMapper.update(current1);
                }

                //新增库位转移信息
                if (mesWmsStockcurrentDto.getId() == null){
                    MesWmsStockmoveplace moveplace = new MesWmsStockmoveplace();
                    BeanUtils.copyProperties(mesWmsStockcurrent,moveplace);
                    BeanUtils.copyProperties(userVo,moveplace);
                    moveplace.setId(null);
                    //查询移除单据编码
                    String recordCode = placeExtMapper.queryMoveCode();
                    if (StringUtils.isEmpty(recordCode)) {
                        moveplace.setMoveCode(CommonConstantUtils.STOCKMOVEPLACE_CODE);
                    } else {
                        moveplace.setMoveCode(NumAddUtil.addOrderNum(recordCode,9));
                    }
                    //移除库位
                    moveplace.setStockPlaceIdSource(mesWmsStockcurrent.getStockPlaceId());
                    moveplace.setStockPlaceCodeSource(mesWmsStockcurrent.getStockPlaceCode());
                    moveplace.setStockPlaceNameSource(mesWmsStockcurrent.getStockPlaceName());
                    //移入库位
                    moveplace.setStockPlaceIdNew(stockplace.getId());
                    moveplace.setStockPlaceCodeNew(stockplace.getStockPlaceCode());
                    moveplace.setStockPlaceNameNew(stockplace.getStockPlaceName());

                    //数量
                    moveplace.setQty(mesWmsStockcurrentDto.getMoveQty());
                    moveplace.setQtyUseable(mesWmsStockcurrentDto.getMoveQty());
                    moveplace.setQtyAllot(mesWmsStockcurrentDto.getMoveQty());
                    moveplace.setQtyFreeze(mesWmsStockcurrentDto.getMoveQty());

                    //经办人
                    StockOtherVo stockOtherVo = new StockOtherVo();
                    stockOtherVo.setId(mesWmsStockcurrentDto.getDisposerId());
                    List<StockOtherVo> stockOtherVos = otherMapper.queryUser(stockOtherVo);
                    if (stockOtherVos != null && stockOtherVos.size() > 0){
                        moveplace.setDisposerId(stockOtherVos.get(0).getId());
                        moveplace.setDisposer(stockOtherVos.get(0).getName());
                    }

                    moveplace.setRemark(mesWmsStockcurrentDto.getRemark());
                    moveplace.setMoveType(mesWmsStockcurrentDto.getMoveType());
                    moveplace.setMovePlaceDate(mesWmsStockcurrentDto.getMovePlaceDate());
                    moveplace.setPostingPlaceDate(mesWmsStockcurrentDto.getPostingPlaceDate());
                    moveplace.setIsValid(CommonConstantUtils.NOT_DELETE);
                    moveplace.setState(CommonConstantUtils.STOCKMOVENPLACE_STATE_ADD);
                    moveplace.setStockCurrentId(mesWmsStockcurrent.getId());
                    moveplace.setCreateId(mesWmsStockcurrentDto.getCurrentloginId());
                    moveplace.setCreateName(mesWmsStockcurrentDto.getCurrentloginName());
                    moveplace.setCreateTime(LocalDateTime.now());
                    moveplace.setUpdateId(null);
                    moveplace.setUpdateName(null);
                    moveplace.setUpdateTime(null);
                    moveplace.setIsValid(CommonConstantUtils.NOT_DELETE);
                    mesWmsStockmoveplaceMapper.insert(moveplace);
                }else {
                    MesWmsStockmoveplace moveplace = mesWmsStockmoveplaceMapper.queryById(mesWmsStockcurrentDto.getId());
                    BeanUtils.copyProperties(mesWmsStockcurrentDto,moveplace);

                    //数量
                    moveplace.setQty(mesWmsStockcurrentDto.getMoveQty());
                    moveplace.setQtyUseable(mesWmsStockcurrentDto.getMoveQty());
                    moveplace.setQtyAllot(mesWmsStockcurrentDto.getMoveQty());
                    moveplace.setQtyFreeze(mesWmsStockcurrentDto.getMoveQty());

                    //移入库位
                    moveplace.setStockPlaceIdNew(stockplace.getId());
                    moveplace.setStockPlaceCodeNew(stockplace.getStockPlaceCode());
                    moveplace.setStockPlaceNameNew(stockplace.getStockPlaceName());

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
                    moveplace.setUpdateId(mesWmsStockcurrentDto.getCurrentloginId());
                    moveplace.setUpdateName(mesWmsStockcurrentDto.getCurrentloginName());
                    moveplace.setUpdateTime(LocalDateTime.now());
                    mesWmsStockmoveplaceMapper.edit(moveplace);
                }
                return ResultVO.create().success("库位转移成功!");
            }
            return ResultVO.create().error("库存转移数量不能大于实际数量!");
        }
        return ResultVO.create().error("数据错误,数据可能不存在!");
    }

    /**
     * 审核
     * @param id
     * @return
     */
    @Override
    public ResultVO isCheck(Integer id) {
        MesWmsStockmoveplace mesWmsStockmoveplace = new MesWmsStockmoveplace();
        mesWmsStockmoveplace.setState(CommonConstantUtils.STOCKMOVENPLACE_STATE_CHECK);
        mesWmsStockmoveplace.setId(id);
        if (this.mesWmsStockmoveplaceMapper.update(mesWmsStockmoveplace) > 0){
            return ResultVO.create().success("开始审核！！");
        }
        return ResultVO.create().error("审核失败！");
    }
}

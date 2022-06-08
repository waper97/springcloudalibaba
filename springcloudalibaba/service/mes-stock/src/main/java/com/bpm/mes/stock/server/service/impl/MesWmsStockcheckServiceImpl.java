package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsInouttype;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.domain.MesWmsStockcheck;
import com.bpm.mes.stock.server.domain.MesWmsStockchecklist;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrent;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrentsum;
import com.bpm.mes.stock.server.domain.MesWmsStockinout;
import com.bpm.mes.stock.server.domain.MesWmsStockinoutbatch;
import com.bpm.mes.stock.server.domain.MesWmsStockinoutlist;
import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.dto.CheckDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcheckDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcheckQueryDto;
import com.bpm.mes.stock.server.dto.MesWmsStockinoutQueryDto;
import com.bpm.mes.stock.server.excel.StockCheeckExcel;
import com.bpm.mes.stock.server.mapper.base.MesWmsInouttypeMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcheckMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockchecklistMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockcurrentsumMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutbatchMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutlistMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockplaceMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockcheckExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockinoutExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockplaceExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockpoExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockOutService;
import com.bpm.mes.stock.server.service.MesWmsStockcheckService;
import com.bpm.mes.stock.server.service.MesWmsStockinoutService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.util.NumAddUtil;
import com.bpm.mes.stock.server.vo.MaterialVo;
import com.bpm.mes.stock.server.vo.MesWmsStockPoListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockPoPlaceListVo;
import com.bpm.mes.stock.server.vo.MesWmsStockcheckVo;
import com.bpm.mes.stock.server.vo.MesWmsStockplacebindMaterialVo;
import com.bpm.mes.stock.server.vo.StockOtherVo;
import com.bpm.mes.stock.server.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 仓库盘点主表(MesWmsStockcheck)表服务实现类
 *
 * @author makejava
 * @since 2022-04-28 19:16:22
 */
@Service
public class MesWmsStockcheckServiceImpl implements MesWmsStockcheckService {
    @Resource
    private MesWmsStockcheckMapper mesWmsStockcheckMapper;
    @Resource
    private MesWmsStockcheckExtMapper extMapper;
    @Resource
    private MesWmsStockchecklistMapper listMapper;
    @Resource
    private MesWmsStockMapper stockMapper;
    @Resource
    private MesWmsStockplaceMapper placeMapper;
    @Resource
    private MesWmsStockcurrentsumMapper sumMapper;
    @Resource
    private MesWmsStockcurrentMapper currentMapper;
    @Resource
    private MesWmsStockinoutService inoutService;
    @Resource
    private MesWmsStockinoutMapper inoutMapper;
    @Resource
    private MesWmsStockinoutlistMapper inoutlistMapper;
    @Resource
    private MesWmsStockinoutbatchMapper batchMapper;
    @Resource
    private MesWmsStockOutService outService;
    @Resource
    private MesWmsInouttypeMapper inouttypeMapper;
    @Resource
    private MesWmsOtherMapper otherMapper;
    @Resource
    private MesWmsStockpoExtMapper poExtMapper;

    @Resource
    private MesWmsStockinoutExtMapper inoutExtMapper;
    @Resource
    private MesWmsStockplaceExtMapper placeExtMapper;

    /**
     * 条件查询
     *
     * @param mesWmsStockcheckQueryDto 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MesWmsStockcheck> queryAll(MesWmsStockcheckQueryDto mesWmsStockcheckQueryDto) {
        MesWmsStockcheck mesWmsStockcheck = new MesWmsStockcheck();
        BeanUtils.copyProperties(mesWmsStockcheckQueryDto, mesWmsStockcheck);
        return this.mesWmsStockcheckMapper.queryAll(mesWmsStockcheck);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResultVO queryById(Integer id) {
        return ResultVO.create().success(this.mesWmsStockcheckMapper.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param dto 筛选条件
     * @return 查询结果
     */
    @Override
    public ResultVO<PageInfoVO<List<MesWmsStockcheckVo>>> queryByPage(MesWmsStockcheckQueryDto dto) {
//        MesWmsStockcheck mesWmsStockcheck = new MesWmsStockcheck();
//        BeanUtils.copyProperties(mesWmsStockcheckQueryDto,mesWmsStockcheck);
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
//        List<MesWmsStockcheck> mesWmsStockcheckList = this.mesWmsStockcheckMapper.queryAll(mesWmsStockcheck);
        List<MesWmsStockcheckVo> vos = this.extMapper.queryAll(dto);
        vos.forEach(vo -> {
            MesWmsStockchecklist mesWmsStockchecklist = new MesWmsStockchecklist();
            mesWmsStockchecklist.setStockCheckId(vo.getId());
            List<MesWmsStockchecklist> mesWmsStockchecklists = listMapper.queryAll(mesWmsStockchecklist);
            vo.setLists(mesWmsStockchecklists);
        });
        PageInfo<MesWmsStockcheckVo> pageInfo = new PageInfo<>(vos);
        PageInfoVO pageInfoVO = ResultUtil.successPageInfo();
        BeanUtils.copyProperties(pageInfo, pageInfoVO);
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockcheck 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO insert(MesWmsStockcheck mesWmsStockcheck) {
        if (this.mesWmsStockcheckMapper.insert(mesWmsStockcheck) > 0) {
            return ResultVO.create().success("新增数据成功!");
        }
        return ResultVO.create().error("新增数据失败!");
    }

    /**
     * 修改数据
     *
     * @param mesWmsStockcheck 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO update(MesWmsStockcheck mesWmsStockcheck) {
        if (this.mesWmsStockcheckMapper.update(mesWmsStockcheck) > 0) {
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
    @Transactional(rollbackFor = Exception.class)
    public ResultVO deleteById(Integer id) {
        if (this.mesWmsStockcheckMapper.deleteById(id) > 0) {
            MesWmsStockchecklist mesWmsStockchecklist = new MesWmsStockchecklist();
            mesWmsStockchecklist.setStockCheckId(id);
            List<MesWmsStockchecklist> mesWmsStockchecklists = listMapper.queryAll(mesWmsStockchecklist);
            mesWmsStockchecklists.forEach(list -> {
                listMapper.deleteById(list.getId());
            });
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
        if (this.mesWmsStockcheckMapper.updateById(id) > 0) {
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 自动生成每日递增编号
     *
     * @param titleText (编码头部默认字符 如：PO20220101001 则为PO)
     * @return 生成编码
     */
    public String contextLoads(String titleText, String zeroText) {

        RedisAtomicLong entityIdCounter = new RedisAtomicLong(titleText, redisTemplate.getConnectionFactory());
        Long counter = entityIdCounter.incrementAndGet();
        DecimalFormat format = new DecimalFormat(zeroText);
        entityIdCounter.expire(1, TimeUnit.DAYS);

        return titleText + new SimpleDateFormat("yyyyMMdd").format(new Date()) + format.format(counter);
    }

    /**
     * 新增和编辑数据
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEdit(MesWmsStockcheckDto dto) {
        MesWmsStockcheck check = new MesWmsStockcheck();
        //查询仓库信息
        MesWmsStock stock = stockMapper.queryById(dto.getStockId());
        //库位信息
        MesWmsStockplace place = placeMapper.queryById(dto.getStockPlaceId());
        //查询库位信息
        if (dto.getId() == null) {
            BeanUtils.copyProperties(dto, check);
            UserVo userVo = otherMapper.queryCompany(dto.getCurrentloginId());
            BeanUtils.copyProperties(userVo, check);
            if (StringUtils.isEmpty(stock)) {
                return ResultVO.create().error("未选择需要进行盘点的仓库！");
            }
//            if (CommonConstantUtils.CHECK_STATE_INVENTORY.equals(stock.getState())) {
//                return ResultVO.create().error("仓库正在盘点中，不能进行重复盘点！");
//            }
            check.setStockId(stock.getId());
            check.setStockCode(stock.getStockCode());
            check.setStockName(stock.getStockName());
            if (!StringUtils.isEmpty(place)) {
                check.setStockPlaceId(place.getId());
                check.setStockPlaceCode(place.getStockPlaceCode());
                check.setStockPlaceName(place.getStockPlaceName());
            }
            check.setCheckCode(contextLoads("PO", "0000"));
            check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_ONE);
            check.setChecker(dto.getCurrentloginId().toString());
            check.setCheckName(dto.getCheckName());
            check.setCreateId(dto.getCurrentloginId());
            check.setCreateName(dto.getCurrentloginName());
            check.setCreateTime(LocalDateTime.now());
            check.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockcheckMapper.insert(check);

        } else {
            check = mesWmsStockcheckMapper.queryById(dto.getId());
            if (!CommonConstantUtils.STOCKCHECK_STATE_ONE.equals(check.getCheckState())) {
                return ResultVO.create().error("只有新建状态才能编辑！");
            }
            BeanUtils.copyProperties(dto, check);
            if (StringUtils.isEmpty(stock)) {
                return ResultVO.create().error("未选择需要进行盘点的仓库！");
            }
//            if (CommonConstantUtils.CHECK_STATE_INVENTORY.equals(stock.getState())) {
//                return ResultVO.create().error("仓库正在盘点中，不能进行重复盘点！");
//            }
            check.setStockId(stock.getId());
            check.setStockCode(stock.getStockCode());
            check.setStockName(stock.getStockName());
            if (!StringUtils.isEmpty(place)) {
                check.setStockPlaceId(place.getId());
                check.setStockPlaceCode(place.getStockPlaceCode());
                check.setStockPlaceName(place.getStockPlaceName());
            }
            check.setChecker(dto.getCurrentloginId().toString());
            check.setCheckName(dto.getCheckName());
            check.setUpdateId(dto.getCurrentloginId());
            check.setUpdateName(dto.getCurrentloginName());
            check.setUpdateTime(LocalDateTime.now());
            check.setIsValid(CommonConstantUtils.NOT_DELETE);
            check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_ONE);
            mesWmsStockcheckMapper.edit(check);
            extMapper.deleteChecklist(check.getId());
        }

        //编辑盘点明细表
        MesWmsStockcheck finalCheck = check;
        dto.getListDtos().forEach(listDto -> {
            MesWmsStockcurrent current = new MesWmsStockcurrent();
            if(listDto.getStockCurrentId() == null){
                current = currentMapper.queryById(listDto.getId());
            }else {
                current = currentMapper.queryById(listDto.getStockCurrentId());
            }
            MesWmsStockchecklist checklist = new MesWmsStockchecklist();
            checklist.setStockCheckId(finalCheck.getId());

            BeanUtils.copyProperties(current, checklist);
            checklist.setStockCurrentId(current.getId());
            checklist.setStockCurrentSumId(current.getStockCurrentSumId());
            UserVo userVo = otherMapper.queryCompany(dto.getCurrentloginId());
            BeanUtils.copyProperties(userVo, checklist);
            checklist.setId(null);
            checklist.setInBatchNo(listDto.getInBatchNo());
            //供应商信息
            if (listDto.getSuppliarId() != null) {
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(listDto.getSuppliarId());
                List<StockOtherVo> stockOtherVos = otherMapper.querySuppliar(stockOtherVo);
                if (stockOtherVos.size() > 0 & stockOtherVos.size() == 1) {
                    checklist.setSuppliarId(stockOtherVos.get(0).getId());
                    checklist.setSuppliarName(stockOtherVos.get(0).getName());
                }
            }
            checklist.setCheckerId(current.getId());
            checklist.setCreateId(dto.getCurrentloginId());
            checklist.setCreateName(dto.getCurrentloginName());
            checklist.setCreateTime(LocalDateTime.now());
            checklist.setUpdateId(null);
            checklist.setUpdateName(null);
            checklist.setUpdateTime(null);
            checklist.setIsValid(CommonConstantUtils.NOT_DELETE);
            checklist.setAccountNum(current.getQtyUseable());
            listMapper.insert(checklist);
        });
        return ResultUtil.successPageInfo();
    }

    /**
     * 盘点
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO inventory(MesWmsStockcheckDto dto) {
        //修改盘点主表数据
        MesWmsStockcheck check = mesWmsStockcheckMapper.queryById(dto.getId());
//        check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_TWO);

        //修改仓库状态为盘点
        MesWmsStock stock = stockMapper.queryById(check.getStockId());
        stock.setState(CommonConstantUtils.CHECK_STATE_INVENTORY);
        stockMapper.update(stock);

        dto.getListDtos().forEach(listDto -> {
            //库位信息
            MesWmsStockplace stockplace = placeMapper.queryById(listDto.getStockPlaceId());
            //修改盘点明细数据
            if (listDto.getId() == null) {
                MesWmsStockchecklist checklist = new MesWmsStockchecklist();
                MaterialVo materialVo = new MaterialVo();

                checklist.setStockPlaceId(stockplace.getId());
                checklist.setStockPlaceCode(stockplace.getStockPlaceCode());
                checklist.setStockPlaceName(stockplace.getStockPlaceName());

                materialVo.setMaterialId(listDto.getMaterialId());
                List<MaterialVo> materialVos = otherMapper.queryMaterial(materialVo);
                BeanUtils.copyProperties(materialVos.get(0), checklist);
                UserVo userVo = otherMapper.queryCompany(dto.getCurrentloginId());
                BeanUtils.copyProperties(userVo, checklist);
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(listDto.getSuppliarId());
                List<StockOtherVo> stockOtherVos = otherMapper.querySuppliar(stockOtherVo);
                if (stockOtherVos != null && stockOtherVos.size()>0){
                    checklist.setSuppliarId(stockOtherVos.get(0).getId());
                    checklist.setSuppliarName(stockOtherVos.get(0).getName());
                }
                if (stockplace!=null){
                    checklist.setStockPlaceId(stockplace.getId());
                    checklist.setStockPlaceCode(stockplace.getStockPlaceCode());
                    checklist.setStockPlaceName(stockplace.getStockPlaceName());
                }
                checklist.setInBatchNo(listDto.getInBatchNo());
                checklist.setAccountNum(listDto.getAccountNum());
                checklist.setCheckNum(listDto.getCheckNum());
                checklist.setDifferentNum(listDto.getDifferentNum());
                checklist.setIsValid(CommonConstantUtils.NOT_DELETE);
                checklist.setStockCheckId(dto.getId());
                listMapper.insert(checklist);
            } else {
                MesWmsStockchecklist checklist = listMapper.queryById(listDto.getId());
                StockOtherVo stockOtherVo = new StockOtherVo();
                stockOtherVo.setId(listDto.getSuppliarId());
                List<StockOtherVo> stockOtherVos = otherMapper.querySuppliar(stockOtherVo);
                if (stockOtherVos != null && stockOtherVos.size()>0){
                    checklist.setSuppliarId(stockOtherVos.get(0).getId());
                    checklist.setSuppliarName(stockOtherVos.get(0).getName());
                }
                if (stockplace!=null){
                    checklist.setStockPlaceId(stockplace.getId());
                    checklist.setStockPlaceCode(stockplace.getStockPlaceCode());
                    checklist.setStockPlaceName(stockplace.getStockPlaceName());
                }
                checklist.setInBatchNo(listDto.getInBatchNo());
                checklist.setStockPlaceId(stockplace.getId());
                checklist.setStockPlaceCode(stockplace.getStockPlaceCode());
                checklist.setStockPlaceName(stockplace.getStockPlaceName());
                checklist.setAccountNum(listDto.getAccountNum());
                checklist.setCheckNum(listDto.getCheckNum());
                checklist.setDifferentNum(listDto.getDifferentNum());
                listMapper.update(checklist);
            }
        });

        List<MesWmsStockchecklist> mesWmsStockchecklists = extMapper.queryState(check.getId());
        if (mesWmsStockchecklists != null && mesWmsStockchecklists.size()>0){
            check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_TWO);
        }else {
            check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_THREE);
        }
        mesWmsStockcheckMapper.update(check);
        return ResultUtil.successPageInfo();
    }

    /**
     * 调账
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO account(CheckDto dto) {
        dto.getStockCheckIds().forEach(stockCheckId -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //修改盘点主表状态为已调账
            MesWmsStockcheck check = mesWmsStockcheckMapper.queryById(stockCheckId);
//            check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_THREE);
            check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_FOUR);
            check.setCheckAccountDate(sdf.format(new Date()));
            mesWmsStockcheckMapper.update(check);
            //修改仓库状态为在用
            MesWmsStock stock = stockMapper.queryById(check.getStockId());
            stock.setState(CommonConstantUtils.CTOCK_STATE_ISUSE);
            stockMapper.update(stock);
            MesWmsStockchecklist checklist = new MesWmsStockchecklist();
            checklist.setStockCheckId(stockCheckId);
            List<MesWmsStockchecklist> lists = listMapper.queryAll(checklist);
            lists.forEach(list -> {
                //库存数量是否相等
                if (!(list.getCheckNum().compareTo(list.getAccountNum()) == 0)) {
//                    //修改即时库存明细数据
                    MesWmsStockcurrent current = currentMapper.queryById(list.getStockCurrentId());
                    //差异数量小于0，出库
                    if (list.getDifferentNum().compareTo(new BigDecimal(0)) == -1) {
                        BigDecimal qtyBatch = new BigDecimal(0).subtract(list.getDifferentNum());
                        //修改出库记录主表
                        if (current != null && current.getStockOutId() != null && current.getStockOutDetialId() != null) {
                            String state = CommonConstantUtils.STOCKINOUT_OUT;
                            Integer inOutId = current.getStockOutId();
                            Integer inOutListId = current.getStockOutDetialId();
                            getInOutEdit(dto, list, state, inOutId, inOutListId);
                        }else {
                            //出库
                            String inOutPropert = CommonConstantUtils.PROPERT_OUT;
                            //出入库类型
                            String inOutType = CommonConstantUtils.INOUTTYPE_POUT;

                            //查询出入库编码
                            String recordCode = inoutExtMapper.queryInOutCode(inOutPropert);
                            if (StringUtils.isEmpty(recordCode)) {
                                recordCode = CommonConstantUtils.STOCKINOUTCODE_OUT;
                            } else {
                                recordCode = NumAddUtil.addOrderNum(recordCode, 11);
                            }

                            //查询入库批次
                            String inBatchNo = list.getInBatchNo();

                            String status = CommonConstantUtils.STOCKINOUT_STATE_TEN;
                            BigDecimal differentNum = list.getDifferentNum();

                            //新增出库主表
                            getStockoInOutAdd(dto, sdf, check, stock, list, current, inOutPropert, inOutType, recordCode, inBatchNo, status, differentNum);
                        }
                    } else if (list.getDifferentNum().compareTo(new BigDecimal(0)) == 1) {//差异数量大于0，入库
                        //修改入库记录主表
                        if (current != null && current.getStockOutId() != null && current.getStockOutDetialId() != null) {
                            String state = CommonConstantUtils.STOCKINOUT_IN;
                            Integer inOutId = current.getStockInId();
                            Integer inOutListId = current.getStockInDetialId();
                            getInOutEdit(dto, list, state, inOutId, inOutListId);
                        } else {
                            //出库
                            String inOutPropert = CommonConstantUtils.PROPERT_IN;
                            //出入库类型
                            String inOutType = CommonConstantUtils.INOUTTYPE_PIN;

                            //查询出入库编码
                            String recordCode = inoutExtMapper.queryInOutCode(inOutPropert);
                            if (StringUtils.isEmpty(recordCode)) {
                                recordCode = CommonConstantUtils.STOCKINOUTCODE_IN;
                            } else {
                                recordCode = NumAddUtil.addOrderNum(recordCode, 10);
                            }

                            //查询入库批次
                            String inBatchNo = list.getInBatchNo();

                            String status = CommonConstantUtils.STOCKINOUT_STATE_THREE;
                            BigDecimal differentNum = list.getDifferentNum();

                            //新增出库主表
                            getStockoInOutAdd(dto, sdf, check, stock, list, current, inOutPropert, inOutType, recordCode, inBatchNo, status, differentNum);
                        }
                    }
                }

            });
        });
        return ResultUtil.successPageInfo();
    }

    private void getStockoInOutAdd(CheckDto dto, SimpleDateFormat sdf, MesWmsStockcheck check, MesWmsStock stock, MesWmsStockchecklist list, MesWmsStockcurrent current, String inOutPropert, String inOutType, String recordCode, String inBatchNo, String status, BigDecimal differentNum) {
        MesWmsStockinout stockinout = new MesWmsStockinout();
        stockinout.setFrob(CommonConstantUtils.STOCKINOUT_FROB_BLUE);
        stockinout.setInOutTypePropert(inOutPropert);
        stockinout.setStatus(status);
        //查询当前登录人基本信息：如公司等
        UserVo userVo = otherMapper.queryCompany(dto.getCurrentloginId());
        BeanUtils.copyProperties(userVo, stockinout);
        MesWmsInouttype inouttype = new MesWmsInouttype();
        inouttype.setBillFlag(inOutType);
        List<MesWmsInouttype> mesWmsInouttypes = inouttypeMapper.queryAll(inouttype);
        if (mesWmsInouttypes.size() > 0) {
            stockinout.setInOutTypeId(mesWmsInouttypes.get(0).getId());
            stockinout.setInOutTypeCode(mesWmsInouttypes.get(0).getInOutTypeCode());
            stockinout.setInOutTypeName(mesWmsInouttypes.get(0).getInOutTypeName());
            stockinout.setBillCode(mesWmsInouttypes.get(0).getBillFlag());
        }
        stockinout.setStockInOutCode(recordCode);
        //查询库位信息
        MesWmsStockplace place = placeMapper.queryById(list.getStockPlaceId());
        if (!StringUtils.isEmpty(place)) {
            stockinout.setStockId(place.getStockId());
            stockinout.setStockName(place.getStockName());
            stockinout.setStockCode(place.getStockCode());
        }
        stockinout.setSourceId(list.getStockCheckId());
        stockinout.setSourceCode(check.getCheckCode());
        stockinout.setSourceType(CommonConstantUtils.STOCKINOUT_SOURCETYPE_SIX);
        stockinout.setInoutDate(sdf.format(new Date()));
        stockinout.setInoutPostingDate(sdf.format(new Date()));
        stockinout.setIsValid(CommonConstantUtils.NOT_DELETE);
        stockinout.setCreateId(dto.getCurrentloginId());
        stockinout.setCreateName(dto.getCurrentloginName());
        stockinout.setCreateTime(LocalDateTime.now());
        inoutMapper.insert(stockinout);

        //新增出库明细数据
        MesWmsStockinoutlist inOutList = new MesWmsStockinoutlist();
        inOutList.setStockInOutId(stockinout.getId());
        if (!StringUtils.isEmpty(place)) {
            inOutList.setStockPlaceId(place.getId());
            inOutList.setStockPlaceCode(place.getStockPlaceCode());
            inOutList.setStockPlaceName(place.getStockPlaceName());
            inOutList.setStockId(place.getStockId());
            inOutList.setStockName(place.getStockName());
            inOutList.setStockCode(place.getStockCode());
        }

        //物料信息
        List<MesWmsStockplacebindMaterialVo> materialVos = placeExtMapper.selectMaterial(list.getMaterialId());
        if (materialVos.size() > 0) {
            MesWmsStockplacebindMaterialVo vo = materialVos.get(0);
            inOutList.setMaterialCode(vo.getMaterialCode());
            inOutList.setMaterialId(vo.getMaterialId());
            inOutList.setMaterialShortName(vo.getMaterialShortName());
            inOutList.setMaterialSpec(vo.getMaterialSpec());
            inOutList.setUnitsId(vo.getUnitsId());
            inOutList.setUnitsName(vo.getUnitsName());
        }

        inOutList.setSuppliarId(list.getSuppliarId());
        inOutList.setSuppliarName(list.getSuppliarName());
        inOutList.setStockInOutId(stockinout.getId());
        BigDecimal PalletNub = new BigDecimal(0);
        if (differentNum.compareTo(new BigDecimal(0))==-1){
            PalletNub = new BigDecimal(0).subtract(differentNum);
        }else {
            PalletNub = differentNum;
        }
        inOutList.setFPallet(PalletNub);
        inOutList.setFFinished(PalletNub);
        inOutList.setIsValid(CommonConstantUtils.NOT_DELETE);
        inOutList.setStatus(status);
        inOutList.setInBatchNo(inBatchNo);
        inOutList.setCreateId(dto.getCurrentloginId());
        inOutList.setCreateName(dto.getCurrentloginName());
        inOutList.setCreateTime(LocalDateTime.now());
        BeanUtils.copyProperties(userVo, inOutList);
        inoutlistMapper.insert(inOutList);

        //出入库批次
        MesWmsStockinoutbatch batch = new MesWmsStockinoutbatch();
        BeanUtils.copyProperties(stockinout, batch);
        BeanUtils.copyProperties(inOutList, batch);
        BeanUtils.copyProperties(userVo, batch);
        batch.setQty(differentNum);
        batch.setStockInOutDetailId(inOutList.getId());
        batch.setIsValid(CommonConstantUtils.NOT_DELETE);
        batch.setCreateId(dto.getCurrentloginId());
        batch.setCreateName(dto.getCurrentloginName());
        batch.setCreateTime(LocalDateTime.now());
        batch.setUpdateId(null);
        batch.setUpdateName(null);
        batch.setUpdateTime(null);
        batch.setState(inOutPropert);
        batchMapper.insert(batch);

        //即时库存主表信息存在修改，不存在新增
        MesWmsStockcurrentsum sum2 = new MesWmsStockcurrentsum();
        sum2.setStockCode(inOutList.getStockCode());
        sum2.setMaterialCode(list.getMaterialCode());
        sum2.setIsValid(CommonConstantUtils.NOT_DELETE);
        List<MesWmsStockcurrentsum> mesWmsStockcurrentsums = sumMapper.queryAll(sum2);
        MesWmsStockcurrentsum sum1 = new MesWmsStockcurrentsum();
        if (mesWmsStockcurrentsums.size() < 1) {
            sum1.setStockCode(inOutList.getStockCode());
            sum1.setStockId(inOutList.getStockId());
            sum1.setStockName(inOutList.getStockName());
            if (materialVos.size() > 0) {
                MesWmsStockplacebindMaterialVo vo = materialVos.get(0);
                sum1.setMaterialId(vo.getMaterialId());
                sum1.setMaterialCode(vo.getMaterialCode());
                sum1.setMaterialShortName(vo.getMaterialShortName());
                sum1.setMaterialSpec(vo.getMaterialSpec());
                sum1.setMaterialTrId(vo.getMaterialTrId());
                sum1.setUnitsId(vo.getUnitsId());
                sum1.setUnitsName(vo.getUnitsName());
            }

            sum1.setQty(batch.getQty());
            sum1.setQtyUseable(differentNum);
            sum1.setQtyAllot(differentNum);
            sum1.setQtyFreeze(differentNum);
            sum1.setStockQty(differentNum);
            sum1.setCreateId(dto.getCurrentloginId());
            sum1.setCreateName(dto.getCurrentloginName());
            sum1.setCreateTime(LocalDateTime.now());
            sum1.setIsValid(CommonConstantUtils.NOT_DELETE);
            sumMapper.insert(sum1);
        } else {
            sum1 = mesWmsStockcurrentsums.get(0);
            BigDecimal qty = sum1.getQty().add(differentNum);
            sum1.setQty(qty);
            sum1.setQtyUseable(qty);
            sum1.setUpdateId(dto.getCurrentloginId());
            sum1.setUpdateName(dto.getCurrentloginName());
            sum1.setUpdateTime(LocalDateTime.now());
            sumMapper.update(sum1);
        }
        //新增即时库存明细表信息
        //修改即时库存明细表信息
        MesWmsStockcurrent stockcurrent = new MesWmsStockcurrent();
        stockcurrent.setStockCurrentSumId(sum1.getId());
        stockcurrent.setStockCode(sum1.getStockCode());
        stockcurrent.setStockPlaceCode(list.getStockPlaceCode());
        stockcurrent.setMaterialCode(list.getMaterialCode());
        stockcurrent.setIsValid(CommonConstantUtils.NOT_DELETE);
        List<MesWmsStockcurrent> wmsStockcurrents = currentMapper.queryAll(stockcurrent);
        if (wmsStockcurrents.size() < 1){
            MesWmsStockcurrent current1 = new MesWmsStockcurrent();
            current1.setStockType(stock.getStockType());
            current1.setStockCode(inOutList.getStockCode());
            current1.setStockId(inOutList.getStockId());
            current1.setStockName(inOutList.getStockName());
            current1.setStockCurrentSumId(sum1.getId());
            current1.setStockPlaceId(inOutList.getId());
            current1.setStockPlaceCode(inOutList.getStockPlaceCode());
            current1.setStockPlaceName(inOutList.getStockPlaceName());
            current1.setCreateId(dto.getCurrentloginId());
            current1.setCreateName(dto.getCurrentloginName());
            current1.setCreateTime(LocalDateTime.now());
            current1.setQty(differentNum);
            current1.setQtyUseable(differentNum);
            current1.setQtyAllot(differentNum);
            current1.setQtyFreeze(differentNum);
            current1.setStockQty(differentNum);
            current1.setIsValid(CommonConstantUtils.NOT_DELETE);
            if (materialVos.size() > 0) {
                MesWmsStockplacebindMaterialVo vo = materialVos.get(0);
                current1.setMaterialId(vo.getMaterialId());
                current1.setMaterialCode(vo.getMaterialCode());
                current1.setMaterialShortName(vo.getMaterialShortName());
                current1.setMaterialSpec(vo.getMaterialSpec());
                current1.setMaterialTrId(vo.getMaterialTrId());
                current1.setUnitsId(vo.getUnitsId());
                current1.setUnitsName(vo.getUnitsName());
            }
            current1.setFkDate(sdf.format(new Date()));
            current1.setInBatchNo(inBatchNo);
            currentMapper.insert(current1);
        }else {
            MesWmsStockcurrent wmsStockcurrent = wmsStockcurrents.get(0);
            BigDecimal qty = wmsStockcurrent.getQty().add(differentNum);
            wmsStockcurrent.setIsValid(CommonConstantUtils.NOT_DELETE);
            wmsStockcurrent.setQty(qty);
            wmsStockcurrent.setQtyUseable(qty);
            wmsStockcurrent.setUpdateId(dto.getCurrentloginId());
            wmsStockcurrent.setUpdateName(dto.getCurrentloginName());
            wmsStockcurrent.setUpdateTime(LocalDateTime.now());
            currentMapper.update(wmsStockcurrent);
        }
    }

    private void getInOutEdit(CheckDto dto, MesWmsStockchecklist list, String state, Integer inOutId, Integer inOutListId) {
        MesWmsStockcurrent current = currentMapper.queryById(list.getStockCurrentId());
        current.setQtyUseable(list.getCheckNum());
        current.setQty(list.getCheckNum());
        currentMapper.update(current);
        //修改即时库存主表数据
        MesWmsStockcurrentsum sum = sumMapper.queryById(current.getStockCurrentSumId());
        BigDecimal qty = sum.getQty().add(list.getDifferentNum());
        sum.setQty(qty);
        sum.setQtyUseable(qty);
        sumMapper.update(sum);

        MesWmsStockinout inout = inoutMapper.queryById(inOutId);
        inout.setQty(inout.getQty().add(list.getDifferentNum()));
        inoutMapper.update(inout);
        MesWmsStockinoutlist inoutlist = inoutlistMapper.queryById(inOutListId);
        inoutlist.setFPallet(inoutlist.getFPallet().add(list.getDifferentNum()));
        inoutlist.setFFinished(inoutlist.getFFinished().add(list.getDifferentNum()));
        inoutlistMapper.update(inoutlist);

        MesWmsStockinoutbatch batch = new MesWmsStockinoutbatch();
        BeanUtils.copyProperties(inout, batch);
        BeanUtils.copyProperties(list, batch);
        batch.setId(null);
        batch.setQty(list.getDifferentNum());
        batch.setStockInOutDetailId(list.getId());
        batch.setIsValid(CommonConstantUtils.NOT_DELETE);
        batch.setCreateId(dto.getCurrentloginId());
        batch.setCreateName(dto.getCurrentloginName());
        batch.setCreateTime(LocalDateTime.now());
        batch.setUpdateId(null);
        batch.setUpdateName(null);
        batch.setUpdateTime(null);
        batch.setState(state);
        batchMapper.insert(batch);
    }


    /**
     * 仓库信息
     *
     * @return
     */
    @Override
    public ResultVO queryStock() {
        //仓库信息列表
        List<MesWmsStockPoListVo> stockListVos = extMapper.queryStock();
        stockListVos.forEach(stockListVo -> {
            //库区库位
            List<MesWmsStockPoPlaceListVo> stockPoPlaceListVos = extMapper.queryStockPlace(stockListVo.getStockId());
            stockListVo.setStockPoPlaceListVos(stockPoPlaceListVos);
        });
        return ResultVO.create().success(stockListVos);
    }

    /**
     * 导出
     * @param queryDto
     * @return
     */
    @Override
    public List<StockCheeckExcel> exportExample(MesWmsStockinoutQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNum(),queryDto.getPageSize());
        List<StockCheeckExcel> excels = extMapper.exportExample(queryDto);
        return excels;
    }

    /**
     * 盘点表导入excel数据
     * @param excels
     * @return
     */
    @Override
    public ResultVO importExcel(List<StockCheeckExcel> excels) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (StockCheeckExcel excel:excels) {
            //盘点主表是否存在
            MesWmsStockcheck Stockcheck = new MesWmsStockcheck();
            Stockcheck.setCheckCode(excel.getCheckCode());
            Stockcheck.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_ONE);
            List<MesWmsStockcheck> mesWmsStockchecks = mesWmsStockcheckMapper.queryAll(Stockcheck);
            if (mesWmsStockchecks == null || mesWmsStockchecks.size() < 0){
                return ResultUtil.error("盘点单错误"+excel.getCheckCode());
            }
            if (excel.getCheckNum() == null){
                return ResultUtil.error("盘点数量不能为空！");
            }
//            MesWmsStock mesWmsStock = new MesWmsStock();
//            mesWmsStock.setStockCode(mesWmsStockchecks.get(0).getStockCode());
//            mesWmsStock.setState(CommonConstantUtils.CTOCK_STATE_ISUSE);
            MesWmsStock mesWmsStock = stockMapper.queryById(mesWmsStockchecks.get(0).getStockId());
            if (mesWmsStock == null){
                return ResultUtil.error("仓库正在盘点中，或者仓库不存在！");
            }
            MesWmsStockchecklist checklist = listMapper.queryById(excel.getStockCheckListId());
            if (checklist == null){
                return ResultUtil.error("盘点明细表不存在！");
            }
        }
        for (StockCheeckExcel excel:excels) {
            //编辑盘点明细表
//            MesWmsStockchecklist list = new MesWmsStockchecklist();
//            list.setStockCheckId(check.getId());
//            list.setStockPlaceCode(excel.getStockPlaceCode());
//            list.setMaterialCode(excel.getMaterialCode());
//            list.setId(excel.getStockCheckListId());
//            list.setIsValid(CommonConstantUtils.NOT_DELETE);
//            List<MesWmsStockchecklist> checklists = listMapper.queryAll(list);
//            MesWmsStockchecklist checklist = checklists.get(0);
            MesWmsStockchecklist checklist = listMapper.queryById(excel.getStockCheckListId());
            checklist.setCheckNum(excel.getCheckNum());
            checklist.setDifferentNum(excel.getCheckNum().subtract(checklist.getCheckNum()));
            listMapper.update(checklist);

            //盘点主表是否存在
//            MesWmsStockcheck Stockcheck = new MesWmsStockcheck();
//            Stockcheck.setCheckCode(excel.getCheckCode());
//            Stockcheck.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_ONE);
//            List<MesWmsStockcheck> checks = mesWmsStockcheckMapper.queryAll(Stockcheck);
//            MesWmsStockcheck check = checks.get(0);

            MesWmsStockcheck check = mesWmsStockcheckMapper.queryById(checklist.getStockCheckId());
            List<MesWmsStockchecklist> mesWmsStockchecklists = extMapper.queryState(check.getId());
            if (mesWmsStockchecklists !=null && mesWmsStockchecklists.size()>0){
                check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_TWO);
            }else {
                check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_THREE);
            }
            mesWmsStockcheckMapper.update(check);

            //修改仓库表
            MesWmsStock stock = stockMapper.queryById(check.getStockId());
            stock.setState(CommonConstantUtils.CHECK_STATE_INVENTORY);
            stockMapper.update(stock);

        }
        return ResultUtil.success("导入成功");
    }

    /**
     * 上传Sap
     * @param id
     * @return
     */
    @Override
    public ResultVO uploadSap(Integer id) {
        MesWmsStockcheck check = mesWmsStockcheckMapper.queryById(id);
        if (!CommonConstantUtils.STOCKCHECK_STATE_FOUR.equals(check.getCheckState())){
            return ResultUtil.error("只有已调账的才能上传！");
        }
        check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_FIVE);
        mesWmsStockcheckMapper.update(check);
        return ResultUtil.success("上传成功！");
    }

    /**
     * 取消上传Sap
     * @param id
     * @return
     */
    @Override
    public ResultVO cancelUploadSap(Integer id) {
        MesWmsStockcheck check = mesWmsStockcheckMapper.queryById(id);
        if (CommonConstantUtils.STOCKCHECK_STATE_FIVE.equals(check.getCheckState())){
            check.setCheckState(CommonConstantUtils.STOCKCHECK_STATE_SIX);
            mesWmsStockcheckMapper.update(check);
            return ResultUtil.success("取消上传成功！");
        }
        return ResultUtil.error("只有已上传Sap的才能取消上传！");
    }
}

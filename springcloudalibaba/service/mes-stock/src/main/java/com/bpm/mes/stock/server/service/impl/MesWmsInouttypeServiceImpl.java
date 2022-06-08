package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.util.ResultUtil;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsInouttype;
import com.bpm.mes.stock.server.domain.MesWmsStockinout;
import com.bpm.mes.stock.server.dto.MesWmsInouttypeDto;
import com.bpm.mes.stock.server.mapper.base.MesWmsInouttypeMapper;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockinoutMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsInouttypeExtMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.service.MesWmsInouttypeService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.util.NumberUtil;
import com.bpm.mes.stock.server.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 仓库出入库类型表(MesWmsInouttype)表服务实现类
 *
 * @author makejava
 * @since 2022-04-14 10:35:29
 */
@Service
public class MesWmsInouttypeServiceImpl implements MesWmsInouttypeService {
    @Resource
    private MesWmsInouttypeMapper mesWmsInouttypeMapper;

    @Resource
    private MesWmsInouttypeExtMapper inouttypeExtMapper;

    @Resource
    private MesWmsOtherMapper otherMapper;

    @Resource
    private MesWmsStockinoutMapper stockinoutMapper;

    @Resource
    private NumberUtil numberUtil;

    /**
     * 条件查询
     *
     * @param mesWmsInouttype 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MesWmsInouttype> queryAll(MesWmsInouttype mesWmsInouttype) {
        return this.mesWmsInouttypeMapper.queryAll(mesWmsInouttype);
    }
        
 
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MesWmsInouttype queryById(Integer id) {
        return this.mesWmsInouttypeMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param mesWmsInouttype 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfo<MesWmsInouttype> queryByPage(MesWmsInouttype mesWmsInouttype) {
         PageHelper.startPage(mesWmsInouttype.getPageNum(),mesWmsInouttype.getPageSize());
//        List<MesWmsInouttype> mesWmsInouttypeList = this.mesWmsInouttypeMapper.queryAll(mesWmsInouttype);
        List<MesWmsInouttype> mesWmsInouttypeList = inouttypeExtMapper.queryAll(mesWmsInouttype);
        PageInfo<MesWmsInouttype> pageInfo = new PageInfo<>(mesWmsInouttypeList);
        return pageInfo;
       
    }

    /**
     * 新增数据
     *
     * @param mesWmsInouttype 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO insert(MesWmsInouttype mesWmsInouttype) {
        if (this.mesWmsInouttypeMapper.insert(mesWmsInouttype) > 0){
            return ResultVO.create().success("新增数据成功");
        }
        return ResultVO.create().error("新增数据失败");
    }

    /**
     * 修改数据
     *
     * @param mesWmsInouttype 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO update(MesWmsInouttype mesWmsInouttype) {
        if (this.mesWmsInouttypeMapper.update(mesWmsInouttype) > 0){
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
        if (this.mesWmsInouttypeMapper.deleteById(id) > 0){
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
    public ResultVO updateById(Integer id) {
        MesWmsStockinout mesWmsStockinout = new MesWmsStockinout();
        mesWmsStockinout.setInOutTypeId(id);
        List<MesWmsStockinout> mesWmsStockinouts = stockinoutMapper.queryAll(mesWmsStockinout);
        if (mesWmsStockinouts != null && mesWmsStockinouts.size()>0){
            return ResultUtil.error("此仓库类型已经使用，不允许删除！");
        }
        if(this.mesWmsInouttypeMapper.updateById(id) > 0){
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 仓库出入库类型新增和编辑接口
     * @param inouttypeDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEdit(MesWmsInouttypeDto inouttypeDto) {
        if (inouttypeDto.getId() == null){
            MesWmsInouttype inouttype = new MesWmsInouttype();
            BeanUtils.copyProperties(inouttypeDto, inouttype);
            //当前登录人信息
            UserVo userVo = otherMapper.queryCompany(inouttypeDto.getCurrentloginId());
            BeanUtils.copyProperties(userVo,inouttype);
            inouttype.setCreateId(inouttypeDto.getCurrentloginId());
            inouttype.setCreateName(inouttypeDto.getCurrentloginName());
            inouttype.setCreateTime(LocalDateTime.now());
            //查询最新出入库类型编码
            if(StringUtils.isEmpty(inouttypeDto.getBillFlag())){
                return ResultVO.create().error("单据标识不能为空！");
            }
            String billFlag = inouttypeDto.getBillFlag();
//            String nub = billFlag + new SimpleDateFormat("yyyyMMdd").format(new Date());
//            String recordCode = inouttypeExtMapper.queryTypeCode(billFlag);
//            if (StringUtils.isEmpty(recordCode)) {
//                recordCode = nub + "01";
//                inouttype.setInOutTypeCode(recordCode);
//            } else {
//                inouttype.setInOutTypeCode(NumAddUtil.addOrderNum(recordCode,nub.length()));
//            }
            if(inouttypeDto.getInOutPropert().equals(CommonConstantUtils.STOCKINOUT_IN)){
                inouttype.setInOutTypeCode(numberUtil.getContextLoads("IN","000"));
            } else {
                inouttype.setInOutTypeCode(numberUtil.getContextLoads("OUT","000"));
            }
            inouttype.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsInouttypeMapper.insert(inouttype);
            return ResultVO.create().success("仓库出入库类型新增成功！");
        }else {
            MesWmsInouttype inouttype = mesWmsInouttypeMapper.queryById(inouttypeDto.getId());
            String recordCode = inouttype.getInOutTypeCode();
            BeanUtils.copyProperties(inouttypeDto, inouttype);
            inouttype.setInOutTypeCode(recordCode);
            inouttype.setUpdateId(inouttypeDto.getCurrentloginId());
            inouttype.setUpdateName(inouttypeDto.getCurrentloginName());
            inouttype.setUpdateTime(LocalDateTime.now());
            inouttype.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsInouttypeMapper.edit(inouttype);
            return ResultVO.create().success("仓库出入库类型编辑成功！");
        }
    }
}

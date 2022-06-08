package com.bpm.mes.stock.server.service.impl;

import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockrule;
import com.bpm.mes.stock.server.dto.MesWmsStockruleDto;
import com.bpm.mes.stock.server.mapper.base.MesWmsStockruleMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsOtherMapper;
import com.bpm.mes.stock.server.mapper.ext.MesWmsStockruleExtMapper;
import com.bpm.mes.stock.server.service.MesWmsStockruleService;
import com.bpm.mes.stock.server.util.CommonConstantUtils;
import com.bpm.mes.stock.server.util.NumAddUtil;
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
 * 仓库出入库规则(MesWmsStockrule)表服务实现类
 *
 * @author makejava
 * @since 2022-04-15 17:46:48
 */
@Service
public class MesWmsStockruleServiceImpl implements MesWmsStockruleService {
    @Resource
    private MesWmsStockruleMapper mesWmsStockruleMapper;
    @Resource
    private MesWmsStockruleExtMapper stockruleExtMapper;
    @Resource
    private MesWmsOtherMapper otherMapper;

    /**
     * 条件查询
     *
     * @param mesWmsStockrule 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MesWmsStockrule> queryAll(MesWmsStockrule mesWmsStockrule) {
        return this.mesWmsStockruleMapper.queryAll(mesWmsStockrule);
    }
        
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResultVO queryById(Integer id) {
       return ResultVO.create().success(this.mesWmsStockruleMapper.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param mesWmsStockrule 筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfo<MesWmsStockrule> queryByPage(MesWmsStockrule mesWmsStockrule) {
         PageHelper.startPage(mesWmsStockrule.getPageNum(),mesWmsStockrule.getPageSize());
//        List<MesWmsStockrule> mesWmsStockruleList = this.mesWmsStockruleMapper.queryAll(mesWmsStockrule);
        List<MesWmsStockrule> mesWmsStockruleList = this.stockruleExtMapper.queryAll(mesWmsStockrule);
        PageInfo<MesWmsStockrule> pageInfo = new PageInfo<>(mesWmsStockruleList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockrule 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO insert(MesWmsStockrule mesWmsStockrule) {
        if (this.mesWmsStockruleMapper.insert(mesWmsStockrule) > 0){
            return ResultVO.create().success("新增数据成功!");
        }
        return ResultVO.create().error("新增数据失败!");
    }

    /**
     * 修改数据
     *
     * @param mesWmsStockrule 实例对象
     * @return 实例对象
     */
    @Override
    public ResultVO update(MesWmsStockrule mesWmsStockrule) {
        if (this.mesWmsStockruleMapper.update(mesWmsStockrule) > 0){
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
        if(this.mesWmsStockruleMapper.deleteById(id) > 0){
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
        if(this.mesWmsStockruleMapper.updateById(id) > 0){
            return ResultVO.create().success("数据删除成功!");
        }
        return ResultVO.create().error("数据删除失败!");
    }

    /**
     * 仓库出入库规则新增和编辑接口
     * @param stockruleDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO addAndEdit(MesWmsStockruleDto stockruleDto) {
        if (stockruleDto.getId() == null){
            MesWmsStockrule stockrule = new MesWmsStockrule();
//            stockrule.setRuleCode(stockruleDto.getRuleCode());
//            long count = mesWmsStockruleMapper.count(stockrule);
//            if (count>0){
//                return ResultVO.create().error("仓库出入库规则编码已存在！");
//            }

            BeanUtils.copyProperties(stockruleDto, stockrule);
            //当前登录人信息
            UserVo userVo = otherMapper.queryCompany(stockruleDto.getCurrentloginId());
            BeanUtils.copyProperties(userVo,stockrule);
            //查询最新出入库编码
            String inOutPropert = stockruleDto.getInOutPropert();
            String recordCode = stockruleExtMapper.queryTypeCode(inOutPropert);
            if (CommonConstantUtils.PROPERT_IN.equals(inOutPropert)){
                if (StringUtils.isEmpty(recordCode)) {
                    stockrule.setRuleCode(CommonConstantUtils.STOCKRULE_RULECODE_IN);
                } else {
                    stockrule.setRuleCode(NumAddUtil.addOrderNum(recordCode,2));
                }
            } else {
                if (StringUtils.isEmpty(recordCode)) {
                    stockrule.setRuleCode(CommonConstantUtils.STOCKRULE_RULECODE_OUT);
                } else {
                    stockrule.setRuleCode(NumAddUtil.addOrderNum(recordCode,2));
                }
            }

            stockrule.setCreateId(stockruleDto.getCurrentloginId());
            stockrule.setCreateName(stockruleDto.getCurrentloginName());
            stockrule.setCreateTime(LocalDateTime.now());
            stockrule.setIsValid(CommonConstantUtils.NOT_DELETE);
            mesWmsStockruleMapper.insert(stockrule);
            return ResultVO.create().success("仓库出入库规则新增成功！");
        }else {
            MesWmsStockrule stockrule = mesWmsStockruleMapper.queryById(stockruleDto.getId());
//            if (!stockruleDto.getRuleCode().equals(stockrule.getRuleCode())){
//                return ResultVO.create().error("仓库出入库规则编码不允许修改！");
//            }
            String code = stockrule.getRuleCode();
            BeanUtils.copyProperties(stockruleDto, stockrule);
            stockrule.setRuleCode(code);
            stockrule.setUpdateId(stockruleDto.getCurrentloginId());
            stockrule.setUpdateName(stockruleDto.getCurrentloginName());
            stockrule.setUpdateTime(LocalDateTime.now());
            mesWmsStockruleMapper.edit(stockrule);
            return ResultVO.create().success("仓库出入库规则编辑成功！");
        }
    }
}

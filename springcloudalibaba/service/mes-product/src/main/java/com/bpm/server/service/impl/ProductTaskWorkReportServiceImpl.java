package com.bpm.server.service.impl;

import com.bpm.common.domain.MonthlyProductionOrder;
import com.bpm.common.domain.ProductInWorkReport;
import com.bpm.common.domain.ProductTaskWorkReport;
import com.bpm.common.dto.ProductTaskWorkReportDTO;
import com.bpm.common.dto.ProductTaskWorkReportQueryDto;
import com.bpm.common.dto.ProductTaskWorkReportTwoDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ProductTaskWorkReportVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.common.vo.UserVo;
import com.bpm.server.mapper.*;
import com.bpm.server.service.ProductTaskWorkReportService;
import com.bpm.server.util.CommonConstantUtils;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 作业报工 服务实现类
 * @author wangpeng
 * @since 2022-05-25 14:15:44
 */
@Service
public class ProductTaskWorkReportServiceImpl implements ProductTaskWorkReportService {
    @Resource
    private ProductTaskWorkReportMapper productTaskWorkReportMapper;

    @Resource
    private ProductTaskWorkReportExtMapper extMapper;

    @Resource
    private ProductInWorkReportMapper inWorkReportMapper;

    @Resource
    private ProductInWorkReportExtMapper inExtMapper;

    @Autowired
    NumberUtil numberUtil;

    @Resource
    private MonthlyProductionOrderMapper monthlyMapper;

    @Override
    public List<ProductTaskWorkReport> queryAll(ProductTaskWorkReportDTO productTaskWorkReport) {
 
        return this.productTaskWorkReportMapper.queryAll(productTaskWorkReport);
    }
        
 
    @Override
    public ProductTaskWorkReport queryById(Integer id) {
        return this.productTaskWorkReportMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<ProductTaskWorkReportVO> queryByPage(ProductTaskWorkReportQueryDto dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
//        List<ProductTaskWorkReport> productTaskWorkReportList = this.productTaskWorkReportMapper.queryAll(productTaskWorkReport);
        List<ProductTaskWorkReportVO> productTaskWorkReportList = this.extMapper.queryAll(dto);

        PageInfo<ProductTaskWorkReportVO> pageInfo = new PageInfo<>(productTaskWorkReportList);
        PageInfoVO pageInfoVO = new PageInfoVO();

        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    public boolean insert(ProductTaskWorkReportTwoDto dto) {
        //当前登录人信息
        UserVo userVo = inExtMapper.queryCompany(dto.getCurrentloginId());

        //入库报工
        ProductInWorkReport inWorkReport = inWorkReportMapper.queryById(dto.getInWorkReportId());

        ProductTaskWorkReport productTaskWorkReport = new ProductTaskWorkReport();
        BeanUtils.copyProperties(dto,productTaskWorkReport);
        BeanUtils.copyProperties(userVo,productTaskWorkReport);
        productTaskWorkReport.setInWorkReportCode(inWorkReport.getWorkReportCode());
        productTaskWorkReport.setIsValid(CommonConstantUtils.NOT_DELETE);
        productTaskWorkReport.setStatus(CommonConstantUtils.TASKWORKREPORT_STATUS_ONE);
        productTaskWorkReport.setCreateId(dto.getCurrentloginId());
        productTaskWorkReport.setCreateName(dto.getCurrentloginName());
        productTaskWorkReport.setCreateTime(LocalDateTime.now());
        productTaskWorkReport.setTaskCode(numberUtil.getContextLoads("ZIN","'00'"));

        MonthlyProductionOrder monthly = monthlyMapper.queryById(dto.getSourceId());
        productTaskWorkReport.setMaterialId(monthly.getMaterialId());
        productTaskWorkReport.setSourceCode(monthly.getDocumentCode());
        productTaskWorkReport.setBomId(monthly.getBomId());

        return this.productTaskWorkReportMapper.insert(productTaskWorkReport) > 0;
    }

    
    @Override
    public boolean update(ProductTaskWorkReportTwoDto dto) {
        //当前登录人信息
        UserVo userVo = inExtMapper.queryCompany(dto.getCurrentloginId());

        //入库报工
        ProductInWorkReport inWorkReport = inWorkReportMapper.queryById(dto.getInWorkReportId());

        ProductTaskWorkReport productTaskWorkReport = new ProductTaskWorkReport();
        BeanUtils.copyProperties(dto,productTaskWorkReport);
        BeanUtils.copyProperties(userVo,productTaskWorkReport);
        productTaskWorkReport.setInWorkReportCode(inWorkReport.getWorkReportCode());
        productTaskWorkReport.setIsValid(CommonConstantUtils.NOT_DELETE);
        productTaskWorkReport.setStatus(CommonConstantUtils.TASKWORKREPORT_STATUS_ONE);
        productTaskWorkReport.setUpdateId(dto.getCurrentloginId());
        productTaskWorkReport.setUpdateName(dto.getCurrentloginName());
        productTaskWorkReport.setUpdateTime(LocalDateTime.now());
        return this.productTaskWorkReportMapper.update(productTaskWorkReport) > 0 ;
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.productTaskWorkReportMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.productTaskWorkReportMapper.removeById(id) > 0;
    }

    /**
     * 上传Sap
     * @param  ids
     * @return
     */
    @Override
    public ResultVO uploadSap(List<Integer> ids) {
        for (Integer id: ids) {
            ProductTaskWorkReport taskWorkReport = productTaskWorkReportMapper.queryById(id);
            if (!CommonConstantUtils.TASKWORKREPORT_STATUS_ONE.equals(taskWorkReport.getStatus()) && !CommonConstantUtils.TASKWORKREPORT_STATUS_THREE.equals(taskWorkReport.getStatus())){
                return ResultUtil.error("只有新建状态才能上传！");
            }
        }
        ids.forEach(id -> {
            ProductTaskWorkReport taskWorkReport = productTaskWorkReportMapper.queryById(id);
            taskWorkReport.setStatus(CommonConstantUtils.TASKWORKREPORT_STATUS_TWO);
            productTaskWorkReportMapper.updateSelective(taskWorkReport);
        });
        return ResultUtil.success("上传成功！");
    }

    /**
     * 取消上传Sap
     * @param ids
     * @return
     */
    @Override
    public ResultVO cancelUploadSap(List<Integer> ids) {
        for (Integer id: ids) {
            ProductTaskWorkReport taskWorkReport = productTaskWorkReportMapper.queryById(id);
            if (!CommonConstantUtils.TASKWORKREPORT_STATUS_TWO.equals(taskWorkReport.getStatus())){
                return ResultUtil.error("只有已上传Sap的才能取消上传！");
            }
        }
        ids.forEach(id -> {
            ProductTaskWorkReport taskWorkReport = productTaskWorkReportMapper.queryById(id);
            taskWorkReport.setStatus(CommonConstantUtils.TASKWORKREPORT_STATUS_THREE);
            productTaskWorkReportMapper.updateSelective(taskWorkReport);
        });
        return ResultUtil.error("取消上传成功！");
    }
}

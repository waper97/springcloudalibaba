package com.bpm.server.service.impl;

import com.bpm.common.domain.MonthlyProductionOrder;
import com.bpm.common.domain.ProductInWorkReport;
import com.bpm.common.dto.*;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.*;
import com.bpm.server.mapper.MonthlyProductionOrderMapper;
import com.bpm.server.mapper.ProductInWorkReportExtMapper;
import com.bpm.server.mapper.ProductInWorkReportMapper;
import com.bpm.server.service.ProductInWorkReportService;
import com.bpm.server.util.CommonConstantUtils;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 生成入库报工 服务实现类
 * @author wangpeng
 * @since 2022-05-23 14:53:17
 */
@Service
public class ProductInWorkReportServiceImpl implements ProductInWorkReportService {
    @Resource
    private ProductInWorkReportMapper productInWorkReportMapper;

    @Resource
    private ProductInWorkReportExtMapper extMapper;

    @Resource
    private MonthlyProductionOrderMapper monthlyMapper;

    @Autowired
    NumberUtil numberUtil;

    @Override
    public List<ProductInWorkReportVO> queryAll(ProductInWorkReportQueryDTO productInWorkReport) {
 
        return this.extMapper.queryAll(productInWorkReport);
    }
        
 
    @Override
    public ProductInWorkReport queryById(Integer id) {
        return this.productInWorkReportMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<ProductInWorkReportVO> queryByPage(ProductInWorkReportQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<ProductInWorkReportVO> vos = this.extMapper.queryAll(queryDTO);

        vos.forEach(vo -> {
            List<Integer> ids = extMapper.queryWorkReportIds(vo.getId());
            vo.setStockInOutIds(ids);
            List<InStockVo> voList = extMapper.queryWorkReports(vo.getId());
            vo.setStockVos(voList);
        });
         
        PageInfo<ProductInWorkReportVO> pageInfo = new PageInfo<>(vos);
        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
    }

   
    @Override
    public ResultVO insert(ProductInWorkReportDTO dto) {
        MonthlyProductionOrderDTO orderDTO = new MonthlyProductionOrderDTO();
        orderDTO.setDocumentCode(dto.getSourceCode());
        List<MonthlyProductionOrder> monthly = monthlyMapper.queryAll(orderDTO);

        UserVo userVo = extMapper.queryCompany(dto.getCurrentloginId());
        ProductInWorkReport inWorkReport = new ProductInWorkReport();
        BeanUtils.copyProperties(userVo,inWorkReport);
        BeanUtils.copyProperties(dto,inWorkReport);
        if (monthly.size()>0){
            inWorkReport.setSourceId(monthly.get(0).getId());
        }
        inWorkReport.setSourceCode(monthly.get(0).getDocumentCode());
        inWorkReport.setIsValid(CommonConstantUtils.NOT_DELETE);
        inWorkReport.setStatus(CommonConstantUtils.INWORKREPORT_STATUS_ONE);
        inWorkReport.setCreateId(dto.getCurrentloginId());
        inWorkReport.setCreateName(dto.getCurrentloginName());
        inWorkReport.setCreateTime(LocalDateTime.now());
        inWorkReport.setWorkReportCode(numberUtil.getContextLoads("GIn","'00'"));
//        String workReportDate = dto.getWorkReportDate();
//        workReportDate = workReportDate.replace("-","");
//        workReportDate = workReportDate.substring(2,workReportDate.length());
//        inWorkReport.setBatchNo(numberUtil.getContextLoadsThree("MD"+workReportDate,"'00'"));
        this.productInWorkReportMapper.insert(inWorkReport);

        //新增出入库报工信息
        InStockTwoDto inStockTwoDto = new InStockTwoDto();
        inStockTwoDto.setWorkReportId(inWorkReport.getId());
        inStockTwoDto.setWorkReportTime(LocalDateTime.now());
        inStockTwoDto.setWorkReportCode(inWorkReport.getWorkReportCode());
        inStockTwoDto.setStockInOutIds(dto.getStockInOutIds());
        inStockTwoDto.setMaterialId(dto.getMaterialId());
        extMapper.updateInStock(inStockTwoDto);

        return ResultUtil.success("新增成功！");
    }

    
    @Override
    public ResultVO update(ProductInWorkReportDTO dto) {
        MonthlyProductionOrderDTO orderDTO = new MonthlyProductionOrderDTO();
        orderDTO.setDocumentCode(dto.getSourceCode());
        List<MonthlyProductionOrder> monthly = monthlyMapper.queryAll(orderDTO);

        UserVo userVo = extMapper.queryCompany(dto.getCurrentloginId());
        ProductInWorkReportQueryDTO queryDTO = new ProductInWorkReportQueryDTO();
        queryDTO.setIsValid(CommonConstantUtils.NOT_DELETE);
        queryDTO.setBatchNo(dto.getBatchNo());
        List<ProductInWorkReportVO> reports = this.extMapper.queryAll(queryDTO);
        if (!((reports.size()==1 && reports.get(0).getId()==dto.getId()) || reports.size() < 1)){
            return ResultUtil.error("批次重复！");
        }

        SimpleDateFormat sdf =  new  SimpleDateFormat( "yyMMdd" );
        String format = sdf.format(new Date());
        if (dto.getBatchNo().length()!=10){
            return ResultUtil.error("批次长度为10！");
        }
        String substring = dto.getBatchNo().substring(2, 8);
//        Pattern pattern = Pattern.compile("^-?\\d{6}(\\.\\d+)?$");
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        boolean matches = pattern.matcher(substring).matches();
        if (!matches){
            return ResultUtil.error("批次格式不正确！");
        }
        if (format.compareTo(substring) == -1){
            return ResultUtil.error("批次时间不能大于当前时间！");
        }

        ProductInWorkReport inWorkReport = productInWorkReportMapper.queryById(dto.getId());
        //修改出入库报工信息
        InStockTwoDto inStockTwoDto = new InStockTwoDto();
        inStockTwoDto.setWorkReportId(null);
        inStockTwoDto.setWorkReportTime(null);
        inStockTwoDto.setWorkReportCode(null);
        inStockTwoDto.setMaterialId(inWorkReport.getMaterialId());
        inStockTwoDto.setUpdateWorkReportId(inWorkReport.getId());
        extMapper.updateInStock(inStockTwoDto);

        BeanUtils.copyProperties(userVo,inWorkReport);
        BeanUtils.copyProperties(dto,inWorkReport);
        if (monthly.size()>0){
            inWorkReport.setSourceId(monthly.get(0).getId());
        }
        inWorkReport.setIsValid(CommonConstantUtils.NOT_DELETE);
        inWorkReport.setStatus(CommonConstantUtils.INWORKREPORT_STATUS_ONE);
        inWorkReport.setUpdateId(dto.getCurrentloginId());
        inWorkReport.setUpdateName(dto.getCurrentloginName());
        inWorkReport.setUpdateTime(LocalDateTime.now());
        this.productInWorkReportMapper.update(inWorkReport);

        //新增出入库报工信息
        inStockTwoDto.setWorkReportId(inWorkReport.getId());
        inStockTwoDto.setWorkReportTime(LocalDateTime.now());
        inStockTwoDto.setWorkReportCode(inWorkReport.getWorkReportCode());
        inStockTwoDto.setStockInOutIds(dto.getStockInOutIds());
        inStockTwoDto.setMaterialId(dto.getMaterialId());
        extMapper.updateInStock(inStockTwoDto);
        return ResultUtil.success("编辑成功！");
    }

 
    @Override
    public boolean deleteById(Integer id) {
        return this.productInWorkReportMapper.deleteById(id) > 0;
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.productInWorkReportMapper.removeById(id) > 0;
    }

    /**
     * 查询最新批次数据
     * @param workReportDate
     * @return
     */
    @Override
    public String queryBatchNo(String workReportDate) {
        String queryBatchNo = extMapper.queryBatchNo(workReportDate);
        if (StringUtils.isEmpty(queryBatchNo)){
            workReportDate = workReportDate.replace("-","");
            workReportDate = workReportDate.substring(2);
            queryBatchNo = "MD"+workReportDate+"01";
        } else {
            queryBatchNo = NumberUtil.addOrderNum(queryBatchNo,8);
        }
        return queryBatchNo;
    }

    /**
     * 查询仓库物料入库信息
     * @param dto
     * @return
     */
    @Override
    public List<InStockVo> queryInStock(InStockDTO dto) {
        List<InStockVo> inCode = extMapper.queryInStock(dto);
        return inCode;
    }

    /**
     * 数量
     * @param dto
     * @return
     */
    @Override
    public BigDecimal queryAty(InStockDTO dto) {
        BigDecimal qty = extMapper.queryAty(dto);
        return qty;
    }

    /**
     * 上传Sap
     * @param ids
     * @return
     */
    @Override
    public ResultVO uploadSap(List<Integer> ids) {
        for (Integer id: ids) {
            ProductInWorkReport inWorkReport = productInWorkReportMapper.queryById(id);
            if (!CommonConstantUtils.INWORKREPORT_STATUS_ONE.equals(inWorkReport.getStatus())
            && !CommonConstantUtils.INWORKREPORT_STATUS_THREE.equals(inWorkReport.getStatus())){
                return ResultUtil.error("只有新建状态才能上传！");
            }
        }
        for (Integer id: ids) {
            ProductInWorkReport inWorkReport = productInWorkReportMapper.queryById(id);
            inWorkReport.setStatus(CommonConstantUtils.INWORKREPORT_STATUS_TWO);
            productInWorkReportMapper.updateSelective(inWorkReport);
        }
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
            ProductInWorkReport inWorkReport = productInWorkReportMapper.queryById(id);
            if (!CommonConstantUtils.INWORKREPORT_STATUS_TWO.equals(inWorkReport.getStatus())){
                return ResultUtil.error("只有已上传Sap的才能取消上传！");
            }
        }
        for (Integer id: ids) {
            ProductInWorkReport inWorkReport = productInWorkReportMapper.queryById(id);
            inWorkReport.setStatus(CommonConstantUtils.INWORKREPORT_STATUS_THREE);
            productInWorkReportMapper.updateSelective(inWorkReport);
        }
        return ResultUtil.success("取消上传成功！");
    }

}

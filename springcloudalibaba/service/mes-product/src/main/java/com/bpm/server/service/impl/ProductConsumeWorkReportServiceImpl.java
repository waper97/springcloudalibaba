package com.bpm.server.service.impl;

import com.bpm.common.domain.MonthlyProductionOrder;
import com.bpm.common.domain.ProductConsumeWorkReport;
import com.bpm.common.domain.ProductConsumeWorkReportList;
import com.bpm.common.domain.ProductInWorkReport;
import com.bpm.common.dto.*;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.*;
import com.bpm.server.mapper.*;
import com.bpm.server.service.ProductConsumeWorkReportService;
import com.bpm.server.util.CommonConstantUtils;
import com.bpm.server.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 消耗报工 服务实现类
 * @author wangpeng
 * @since 2022-05-25 14:12:56
 */
@Service
public class ProductConsumeWorkReportServiceImpl implements ProductConsumeWorkReportService {
    @Resource
    private ProductConsumeWorkReportMapper productConsumeWorkReportMapper;
    @Resource
    private ProductConsumeWorkReportListMapper listMapper;
    @Resource
    private ProductConsumeWorkReportExtMapper extMapper;

    @Resource
    private MonthlyProductionOrderMapper monthlyMapper;

    @Resource
    private ProductInWorkReportMapper inWorkReportMapper;
    @Resource
    private ProductInWorkReportExtMapper inExtMapper;

    @Autowired
    NumberUtil numberUtil;

    @Override
    public List<ProductConsumeWorkReport> queryAll(ProductConsumeWorkReportDTO productConsumeWorkReport) {
 
        return this.productConsumeWorkReportMapper.queryAll(productConsumeWorkReport);
    }
        
 
    @Override
    public ProductConsumeWorkReport queryById(Integer id) {
        return this.productConsumeWorkReportMapper.queryById(id);
    }

 
    @Override
    public PageInfoVO<ProductConsumeWorkReportVO> queryByPage(ProductConsumeWorkReportQueryDto dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
//        List<ProductConsumeWorkReport> productConsumeWorkReportList = this.productConsumeWorkReportMapper.queryAll(productConsumeWorkReport);
        List<ProductConsumeWorkReportVO> vos = this.extMapper.queryAll(dto);

        vos.forEach(vo -> {
            List<ProductConsumeWorkReportListVO> listVOS = extMapper.queryAllList(vo.getId());
            vo.setListVOS(listVOS);
        });

        PageInfo<ProductConsumeWorkReportVO> pageInfo = new PageInfo<>(vos);
        PageInfoVO pageInfoVO = new PageInfoVO();
        BeanUtils.copyProperties(pageInfo,pageInfoVO);
        // 引用数据类型 浅拷贝无法复制
        pageInfoVO.setData(pageInfo.getList());
        return pageInfoVO;
       
    }

   
    @Override
    public ResultVO insert(ProductConsumeWorkReportTwoDto dto) {
        UserVo userVo = inExtMapper.queryCompany(dto.getCurrentloginId());
        ProductConsumeWorkReport productConsumeWorkReport = new ProductConsumeWorkReport();
        BeanUtils.copyProperties(dto,productConsumeWorkReport);
        BeanUtils.copyProperties(userVo,productConsumeWorkReport);
        productConsumeWorkReport.setIsValid(CommonConstantUtils.NOT_DELETE);
        productConsumeWorkReport.setStatus(CommonConstantUtils.CONSUMEWORKREPORT_STATUS_ONE);
        productConsumeWorkReport.setCreateId(dto.getCurrentloginId());
        productConsumeWorkReport.setCreateName(dto.getCurrentloginName());
        productConsumeWorkReport.setCreateTime(LocalDateTime.now());
        productConsumeWorkReport.setWorkReportCode(numberUtil.getContextLoads("GOUT","'00'"));
//        productConsumeWorkReport.setOutId(dto.getStockInOutIds().toString());
        BigDecimal qty = dto.getListTwoDtos().stream().map(listDto -> listDto.getActualQty()==null?new BigDecimal(0):listDto.getActualQty()).reduce(BigDecimal.ZERO, BigDecimal::add);
        productConsumeWorkReport.setQty(qty);


        MonthlyProductionOrder monthly = monthlyMapper.queryById(dto.getSourceId());
        productConsumeWorkReport.setMaterialId(monthly.getMaterialId());
        productConsumeWorkReport.setSourceCode(monthly.getDocumentCode());

        ProductInWorkReport inWorkReport = inWorkReportMapper.queryById(dto.getInWorkReportId());
        productConsumeWorkReport.setStockId(inWorkReport.getStockId());
        productConsumeWorkReport.setBatchNo(inWorkReport.getBatchNo());
        this.productConsumeWorkReportMapper.insert(productConsumeWorkReport);

        //消耗报工新增第二级表
        getConsumeList(dto, userVo, productConsumeWorkReport);
        return ResultUtil.successPageInfo();
    }

    @Override
    public ResultVO update(ProductConsumeWorkReportTwoDto dto) {
        UserVo userVo = inExtMapper.queryCompany(dto.getCurrentloginId());
        ProductConsumeWorkReport productConsumeWorkReport = productConsumeWorkReportMapper.queryById(dto.getId());
        ProductConsumeWorkReportListDTO consumeWorkReportListDTO = new ProductConsumeWorkReportListDTO();
        consumeWorkReportListDTO.setConsumeId(productConsumeWorkReport.getId());
        List<ProductConsumeWorkReportList> consumeWorkReportLists = listMapper.queryAll(consumeWorkReportListDTO);
        consumeWorkReportLists.forEach(list -> {
            //修改出入库报工信息
            InStockTwoDto inStockTwoDto = new InStockTwoDto();
            inStockTwoDto.setWorkReportId(null);
            inStockTwoDto.setWorkReportTime(null);
            inStockTwoDto.setWorkReportCode(null);
            inStockTwoDto.setMaterialId(productConsumeWorkReport.getMaterialId());
            inStockTwoDto.setUpdateWorkReportId(productConsumeWorkReport.getId());
            inExtMapper.updateInStock(inStockTwoDto);
            //删除明细数据
            listMapper.deleteById(list.getId());
        });

        BeanUtils.copyProperties(dto,productConsumeWorkReport);
        BeanUtils.copyProperties(userVo,productConsumeWorkReport);
        productConsumeWorkReport.setIsValid(CommonConstantUtils.NOT_DELETE);
        productConsumeWorkReport.setStatus(CommonConstantUtils.CONSUMEWORKREPORT_STATUS_ONE);
        productConsumeWorkReport.setUpdateId(dto.getCurrentloginId());
        productConsumeWorkReport.setUpdateName(dto.getCurrentloginName());
        productConsumeWorkReport.setUpdateTime(LocalDateTime.now());
//        productConsumeWorkReport.setOutId(dto.getStockInOutIds().toString());
        BigDecimal qty = dto.getListTwoDtos().stream().map(listDto -> listDto.getActualQty()==null?new BigDecimal(0):listDto.getActualQty()).reduce(BigDecimal.ZERO, BigDecimal::add);
        productConsumeWorkReport.setQty(qty);

        MonthlyProductionOrder monthly = monthlyMapper.queryById(dto.getSourceId());
        productConsumeWorkReport.setMaterialId(monthly.getMaterialId());
        productConsumeWorkReport.setSourceCode(monthly.getDocumentCode());

        ProductInWorkReport inWorkReport = inWorkReportMapper.queryById(dto.getInWorkReportId());
        productConsumeWorkReport.setStockId(inWorkReport.getStockId());
        productConsumeWorkReport.setBatchNo(inWorkReport.getBatchNo());
        this.productConsumeWorkReportMapper.update(productConsumeWorkReport);

        //消耗报工新增第二级表
        getConsumeList(dto, userVo, productConsumeWorkReport);
        return ResultUtil.successPageInfo();
    }

    /**
     * 消耗报工新增第二级表
     * @param dto
     * @param userVo
     * @param productConsumeWorkReport
     */
    private void getConsumeList(ProductConsumeWorkReportTwoDto dto, UserVo userVo, ProductConsumeWorkReport productConsumeWorkReport) {
        dto.getListTwoDtos().forEach(listDto -> {
            ProductConsumeWorkReportList consumeWorkReportList = new ProductConsumeWorkReportList();
            BeanUtils.copyProperties(userVo,consumeWorkReportList);
            BeanUtils.copyProperties(listDto,consumeWorkReportList);
            consumeWorkReportList.setConsumeId(productConsumeWorkReport.getId());
            consumeWorkReportList.setWorkReportCode(productConsumeWorkReport.getWorkReportCode());
            consumeWorkReportList.setConsumeId(productConsumeWorkReport.getId());
            consumeWorkReportList.setIsValid(CommonConstantUtils.NOT_DELETE);
            consumeWorkReportList.setCreateId(dto.getCurrentloginId());
            consumeWorkReportList.setCreateName(dto.getCurrentloginName());
            consumeWorkReportList.setCreateTime(LocalDateTime.now());
            listMapper.insert(consumeWorkReportList);

            //新增出入库报工信息
            InStockTwoDto inStockTwoDto = new InStockTwoDto();
            inStockTwoDto.setWorkReportId(productConsumeWorkReport.getId());
            inStockTwoDto.setWorkReportTime(LocalDateTime.now());
            inStockTwoDto.setWorkReportCode(productConsumeWorkReport.getWorkReportCode());
            inStockTwoDto.setStockInOutIds(dto.getStockInOutIds());
            inStockTwoDto.setMaterialId(listDto.getMaterialId());
            inExtMapper.updateInStock(inStockTwoDto);
        });
    }

 
    @Override
    public ResultVO deleteById(Integer id) {
        ProductConsumeWorkReport productConsumeWorkReport = productConsumeWorkReportMapper.queryById(id);
        if (!CommonConstantUtils.CONSUMEWORKREPORT_STATUS_ONE.equals(productConsumeWorkReport.getStatus())){
            return ResultUtil.error("只有新增状态才能删除！");
        }
        ProductConsumeWorkReportListDTO consumeWorkReportListDTO = new ProductConsumeWorkReportListDTO();
        consumeWorkReportListDTO.setConsumeId(productConsumeWorkReport.getId());
        List<ProductConsumeWorkReportList> consumeWorkReportLists = listMapper.queryAll(consumeWorkReportListDTO);
        consumeWorkReportLists.forEach(list -> {
            listMapper.deleteById(list.getId());
        });
        this.productConsumeWorkReportMapper.deleteById(id);
        return  ResultUtil.successPageInfo();
    }
    
 
    @Override
    public boolean removeById(Integer id) {
        return this.productConsumeWorkReportMapper.removeById(id) > 0;
    }

    /**
     * 查询仓库物料出库信息
     * @param dto
     * @return
     */
    @Override
    public List<OutStockVo> queryOutStock(OutStockDTO dto) {
        List<OutStockVo> vos = extMapper.queryOutStock(dto);
        return vos;
    }

    /**
     * 查询明细
     * @param dto
     * @return
     */
    @Override
    public List<ProductConsumeWorkReportListVO> queryAty(OutStockDTO dto) {
        //查询bom明细数据
        List<ProductConsumeWorkReportListVO> vos = extMapper.queryBomAty(dto.getBomId());
        vos.forEach(vo -> {
            //查询出库数量
            BigDecimal actualQty = extMapper.queryOutQty(vo.getMaterialId(),dto.getOutIds());
            vo.setActualQty(actualQty);
        });
        return vos;
    }

    /**
     * 上传Sap
     * @param ids
     * @return
     */
    @Override
    public ResultVO uploadSap(List<Integer> ids) {
        for (Integer id: ids) {
            ProductConsumeWorkReport consumeWorkReport = productConsumeWorkReportMapper.queryById(id);
            if (!CommonConstantUtils.CONSUMEWORKREPORT_STATUS_ONE.equals(consumeWorkReport.getStatus())
            && !CommonConstantUtils.CONSUMEWORKREPORT_STATUS_THREE.equals(consumeWorkReport.getStatus())){
                return ResultUtil.error("只有新建状态才能上传！");
            }
        }
        for (Integer id: ids) {
            ProductConsumeWorkReport consumeWorkReport = productConsumeWorkReportMapper.queryById(id);
            consumeWorkReport.setStatus(CommonConstantUtils.CONSUMEWORKREPORT_STATUS_TWO);
            productConsumeWorkReportMapper.updateSelective(consumeWorkReport);
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
            ProductConsumeWorkReport consumeWorkReport = productConsumeWorkReportMapper.queryById(id);
            if (!CommonConstantUtils.CONSUMEWORKREPORT_STATUS_TWO.equals(consumeWorkReport.getStatus())){
                return ResultUtil.error("只有已上传Sap的才能取消上传！");
            }
        }
        for (Integer id: ids) {
            ProductConsumeWorkReport consumeWorkReport = productConsumeWorkReportMapper.queryById(id);
            consumeWorkReport.setStatus(CommonConstantUtils.CONSUMEWORKREPORT_STATUS_THREE);
            productConsumeWorkReportMapper.updateSelective(consumeWorkReport);
        }
        return ResultUtil.success("取消上传成功！");
    }

}

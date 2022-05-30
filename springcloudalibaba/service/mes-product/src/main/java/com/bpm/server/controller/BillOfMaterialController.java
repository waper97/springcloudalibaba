package com.bpm.server.controller;

import com.bpm.common.dto.BillOfMaterialDTO;
import com.bpm.common.dto.BillOfMaterialInsertOrUpdateDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.BillOfMaterialVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.common.vo.BillOfMaterialVO;
import com.bpm.server.service.BillOfMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * bom(物料清单) 控制层
 * @author wangpeng
 * @since 2022-04-18 17:46:31
 */
@Api(tags = "bom(物料清单) ")
@RestController
@RequestMapping("mesProductBillOfMaterial")

public class BillOfMaterialController {
    /**
     * 服务对象
     */
    @Resource
    private BillOfMaterialService billOfMaterialService;


    /**
     * 条件查询
     *
     * @param mesProductBillOfMaterial 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value = "条件查询")
    public ResultVO<List<BillOfMaterialVO>> queryAll(@RequestBody BillOfMaterialDTO mesProductBillOfMaterial) {
        return ResultUtil.success(this.billOfMaterialService.queryAll(mesProductBillOfMaterial));
    }

    /**
     * 分页查询
     *
     * @param mesProductBillOfMaterial 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value = "分页查询")
    public ResultVO<PageInfoVO<BillOfMaterialVO>> Page(@RequestBody BillOfMaterialDTO mesProductBillOfMaterial) {
        return ResultUtil.success(this.billOfMaterialService.queryByPage(mesProductBillOfMaterial));
    }


    /**
     * 新增/修改
     * @param materialDTO
     * @return
     */
    @PostMapping("insertOrUpdate")
    @ApiOperation(value = "新增/修改")
    public ResultVO insertOrUpdate(@RequestBody BillOfMaterialInsertOrUpdateDTO materialDTO) {
        boolean result ;
        if (materialDTO.getId() == null) {
            result =  this.billOfMaterialService.insert(materialDTO);
        }else{
            result = this.billOfMaterialService.update(materialDTO);
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }



    /**
     * 新增数据
     * @param billOfMaterialDTO 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody BillOfMaterialInsertOrUpdateDTO billOfMaterialDTO) {
        if (StringUtils.isEmpty(billOfMaterialDTO.getVersion())) {
            return ResultUtil.error("bom版本号不能为空!");
        }
        if (StringUtils.isEmpty(billOfMaterialDTO.getVersion())) {
            return ResultUtil.error("bom版本号不能为空!");
        }
        boolean result = this.billOfMaterialService.insert(billOfMaterialDTO);
        return result ? ResultUtil.success(): ResultUtil.error();
    }

    /**
     * 编辑数据
     * @param billOfMaterial 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO edit(@RequestBody BillOfMaterialInsertOrUpdateDTO billOfMaterial) {
        boolean result = this.billOfMaterialService.update(billOfMaterial);
        return result ? ResultUtil.success(): ResultUtil.error();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("removeById")
    @ApiOperation(value = "删除")
    public ResultVO removeById(Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
        boolean result = this.billOfMaterialService.deleteById(id);
        return result  ? ResultUtil.success(): ResultUtil.error();
    }

    /**
     * 详情
     * @param bomId
     * @return
     */
    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    @ApiImplicitParam(name = "bomId",value = "bom清单id",required = true)
    public ResultVO<BillOfMaterialVO> listProductBillOfMaterialDetailByProductBillOfMaterialId ( Integer bomId) {
        if (bomId == null) {
            return ResultUtil.error("bom清单id不能为空");
        }
        return ResultUtil.success(billOfMaterialService.getById(bomId));
    }
}


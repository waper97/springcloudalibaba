package com.bpm.mes.stock.server.controller;

import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.service.MesWmsOtherService;
import com.bpm.mes.stock.server.vo.MaterialVo;
import com.bpm.mes.stock.server.vo.StockOtherVo;
import com.bpm.mes.stock.server.vo.StockVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 其他信息表表控制层
 *
 * @author makejava
 * @since 2022-04-14 10:01:14
 */
@RestController
@RequestMapping("/other")
@Api(value = "其他信息管理相关接口",tags = "其他信息管理相关接口")
//@CrossOrigin
public class MesWmsOtherController {
    /**
     * 其他信息
     */
    @Resource
    private MesWmsOtherService otherService;

    /**
     * 查询当前登录人公司信息
     *
     * @return 查询结果
     */
    @GetMapping("/queryCompany")
    @ApiOperation("查询当前登录人公司信息")
    public ResultVO queryCompany( Integer currentloginId) {
        return otherService.queryCompany(currentloginId);
    }
   
    /**
     * 查询部门信息
     *
     * @return 查询结果
     */
    @PostMapping("/queryDepartment")
    @ApiOperation("查询部门信息")
    public ResultVO queryByPage(@RequestBody StockOtherVo stockOtherVo) {
        return otherService.queryDepartment(stockOtherVo);
    }

    /**
     * 查询用户信息
     *
     * @return 查询结果
     */
    @PostMapping("/queryUser")
    @ApiOperation("查询用户信息")
    public ResultVO queryUser(@RequestBody StockOtherVo stockOtherVo) {
        return otherService.queryUser(stockOtherVo);
    }

    /**
     * 数据字典
     *
     * @return 数据字典结果
     */
    @GetMapping("/querydataDict")
    @ApiOperation("数据字典")
    public ResultVO querydataDict(String dictType) {
        return otherService.querydataDict(dictType);
    }

    /**
     * 查询供应商信息
     *
     * @return 查询结果
     */
    @PostMapping("/querySuppliar")
    @ApiOperation("查询供应商信息")
    public ResultVO querySuppliar(@RequestBody StockOtherVo stockOtherVo) {
        return otherService.querySuppliar(stockOtherVo);
    }

    /**
     * 查询客户信息
     *
     * @return 查询结果
     */
    @PostMapping("/queryCustomer")
    @ApiOperation("查询客户信息")
    public ResultVO queryCustomer(@RequestBody StockOtherVo stockOtherVo) {
        return otherService.queryCustomer(stockOtherVo);
    }

    /**
     * 查询物料信息
     *
     * @return 查询物料信息是否成功
     */
    @PostMapping("/queryMaterial")
    @ApiOperation(value = "查询物料信息")
    public ResultVO<PageInfoVO<List<MaterialVo>>> queryMaterial(@RequestBody MaterialVo vo) {
        return this.otherService.queryMaterial(vo);
    }
    /**
     * 查询仓库信息
     *
     * @return 查询仓库信息是否成功
     */
    @PostMapping("/queryStock")
    @ApiOperation(value = "查询仓库信息")
    public ResultVO queryStock(@RequestBody StockVo vo) {
        return this.otherService.queryStock(vo);
    }

    /**
     * 查询仓库信息
     *
     * @return 查询仓库信息是否成功
     */
    @GetMapping("/queryStockTree")
    @ApiOperation(value = "查询仓库树-三级")
    public ResultVO queryStockTree(String dictLabel) {
        return this.otherService.queryStockTree(dictLabel);
    }

}


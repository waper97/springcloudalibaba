package com.bpm.mes.stock.server.controller;

import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStock;
import com.bpm.mes.stock.server.dto.MesWmsStockDto;
import com.bpm.mes.stock.server.dto.MesWmsStockQueryDto;
import com.bpm.mes.stock.server.service.MesWmsStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 仓库信息表(MesWmsStock)表控制层
 *
 * @author makejava
 * @since 2022-04-14 10:01:14
 */
@RestController
@RequestMapping("/mesWmsStock")
@Api(value = "仓库信息管理相关接口",tags = "仓库信息管理相关接口")
//@CrossOrigin
public class MesWmsStockController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockService mesWmsStockService;
    
   
     /**
     * 条件查询
     *
     * @param dto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockQueryDto dto) {
        MesWmsStock stock = new MesWmsStock();
        BeanUtils.copyProperties(dto, stock);
        return ResultVO.create().success(this.mesWmsStockService.queryAll(stock));
    }
      /**
     * 分页查询
     *
     * @param dto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO queryByPage(@RequestBody MesWmsStockQueryDto dto){
        MesWmsStock mesWmsStock = new MesWmsStock();
        BeanUtils.copyProperties(dto, mesWmsStock);
        return ResultVO.create().success(mesWmsStockService.queryByPage(mesWmsStock));
    }


    /**
     * 新增数据
     *
     * @param mesWmsStock 实体
     * @return 新增结果
     */
//    @PostMapping("/add")
//    @ApiOperation(value ="新增")
//    public ResultVO add(MesWmsStock mesWmsStock) {
//        return this.mesWmsStockService.insert(mesWmsStock);
//    }

    /**
     * 编辑数据
     *
     * @param mesWmsStock 实体
     * @return 编辑结果
     */
//    @PutMapping("/edit")
//    @ApiOperation(value= "修改")
//    public ResultVO edit(MesWmsStock mesWmsStock) {
//       return this.mesWmsStockService.update(mesWmsStock);
//    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
//    @DeleteMapping("/removeById")
//    @ApiOperation(value = "删除")
//    public ResultVO removeById(Integer id) {
//        return this.mesWmsStockService.deleteById(id);
//    }

    /**
     * 逻辑删除数据(假删)
     *
     * @param id 主键
     * @return 辑删除是否成功
     */
    @GetMapping("/updateById")
    @ApiOperation(value = "逻辑删除")
    public ResultVO updateById(Integer id) {
        return this.mesWmsStockService.updateById(id);
    }


    /**
     * 查询库管员信息
     *
     * @return 查询结果
     */
    @ApiOperation("查询库管员信息")
    @RequestMapping(value = {"/queryManager"},method = {RequestMethod.GET})
    public ResultVO queryManager() {
        return mesWmsStockService.queryManager();
    }

    /**
     * 查询部门信息
     *
     * @return 查询结果
     */
    @ApiOperation("查询部门信息")
    @RequestMapping(value = {"/queryDepartment"},method = {RequestMethod.GET})
    public ResultVO queryByPage() {
        return mesWmsStockService.queryDepartment();
    }

    /**
     * 仓库信息新增和编辑接口
     *
     * @param mesWmsStockDto 实体
     * @return 编辑结果
     */
    @ApiOperation("仓库信息新增和编辑接口")
    @RequestMapping(value = {"/addAndEdit"}, method = {RequestMethod.POST} )
    public ResultVO addAndEdit(@RequestBody MesWmsStockDto mesWmsStockDto) {
        return mesWmsStockService.addAndEdit(mesWmsStockDto);
    }

    /**
     * 仓库信息盘点
     *
     * @param id 实体
     * @return 编辑结果
     */
    @ApiOperation("仓库信息盘点和恢复")
    @RequestMapping(value = {"/inventoryEdit"}, method = {RequestMethod.GET} )
    public ResultVO inventoryEdit(Integer id) {
        return mesWmsStockService.inventoryEdit(id);
    }

}


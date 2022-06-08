package com.bpm.mes.stock.server.controller;
import com.bpm.mes.stock.common.vo.ResultVO;

import com.bpm.mes.stock.server.domain.MesWmsStockplacebind;
import com.bpm.mes.stock.server.dto.MesWmsStockplacebindDto;
import com.bpm.mes.stock.server.dto.MesWmsStockplacebindQueryDto;
import com.bpm.mes.stock.server.service.MesWmsStockplaceService;
import com.bpm.mes.stock.server.service.MesWmsStockplacebindService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

/**
 * 库位绑定物料表(MesWmsStockplacebind)表控制层
 *
 * @author makejava
 * @since 2022-04-15 15:29:56
 */
@RestController
@RequestMapping("/mesWmsStockplacebind")
@Api(value = "库位绑定物料表管理相关接口",tags = "库位绑定物料表管理相关接口")
//@CrossOrigin
public class MesWmsStockplacebindController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockplacebindService mesWmsStockplacebindService;

    /**
     * 条件查询
     *
     * @param queryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockplacebindQueryDto queryDto) {
        MesWmsStockplacebind mesWmsStockplacebind = new MesWmsStockplacebind();
        BeanUtils.copyProperties(queryDto,mesWmsStockplacebind);
        return ResultVO.create().success(this.mesWmsStockplacebindService.queryAll(mesWmsStockplacebind));
    }
    
    /**
     * 分页查询
     *
     * @param queryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO queryByPage(@RequestBody MesWmsStockplacebindQueryDto queryDto){
        MesWmsStockplacebind mesWmsStockplacebind = new MesWmsStockplacebind();
        BeanUtils.copyProperties(queryDto,mesWmsStockplacebind);
        return ResultVO.create().success(this.mesWmsStockplacebindService.queryByPage(mesWmsStockplacebind));
    }
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @RequestMapping(value = {"/queryById"},method = {RequestMethod.GET})
    public ResultVO queryById(@PathVariable("id") Integer id) {
        return this.mesWmsStockplacebindService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockplacebind 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation(value ="新增")
    public ResultVO add(MesWmsStockplacebind mesWmsStockplacebind) {
        return this.mesWmsStockplacebindService.insert(mesWmsStockplacebind);
    }

    /**
     * 编辑数据
     *
     * @param mesWmsStockplacebind 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    @ApiOperation(value= "修改")
    public ResultVO edit(MesWmsStockplacebind mesWmsStockplacebind) {
       return this.mesWmsStockplacebindService.update(mesWmsStockplacebind);
    }
    
    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/removeById")
    @ApiOperation(value = "删除")
    public ResultVO removeById(Integer id) {
        return this.mesWmsStockplacebindService.deleteById(id);
    }
    
     /**
     * 逻辑删除数据(假删)
     *
     * @param id 主键
     * @return 辑删除是否成功
     */
    @GetMapping("/updateById")
    @ApiOperation(value = "逻辑删除")
    public ResultVO updateById(Integer id) {
        return this.mesWmsStockplacebindService.updateById(id);
    }

    /**
     * 库位绑定物料表新增和编辑接口
     *
     * @param stockplacebindDto 实体
     * @return 编辑结果
     */
    @ApiOperation("库位绑定物料表新增和编辑接口")
    @RequestMapping(value = {"/addAndEdit"}, method = {RequestMethod.POST} )
    public ResultVO addAndEdit(@RequestBody MesWmsStockplacebindDto stockplacebindDto) {
        return mesWmsStockplacebindService.addAndEdit(stockplacebindDto);
    }

    /**
     * 库位绑定物料表获取物料信息
     *
     * @return 库位绑定物料表获取物料信息是否成功
     */
    @GetMapping("/selectMaterial")
    @ApiOperation(value = "库位绑定物料表获取物料信息")
    public ResultVO selectMaterial() {
        return mesWmsStockplacebindService.selectMaterial();
    }


}


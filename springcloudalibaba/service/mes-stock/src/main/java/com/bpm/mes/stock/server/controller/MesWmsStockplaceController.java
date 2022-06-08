package com.bpm.mes.stock.server.controller;
import com.bpm.mes.stock.common.vo.ResultVO;

import com.bpm.mes.stock.server.domain.MesWmsStockplace;
import com.bpm.mes.stock.server.dto.MesWmsStockplaceDto;
import com.bpm.mes.stock.server.dto.MesWmsStockplaceQueryDto;
import com.bpm.mes.stock.server.service.MesWmsStockplaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

/**
 * 仓库库位表(MesWmsStockplace)表控制层
 *
 * @author makejava
 * @since 2022-04-14 16:51:23
 */
@RestController
@RequestMapping("/mesWmsStockplace")
@Api(value = "仓库库位表管理相关接口",tags = "仓库库位表管理相关接口")
//@CrossOrigin
public class MesWmsStockplaceController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockplaceService mesWmsStockplaceService;
    
   
    /**
     * 条件查询
     *
     * @param mesWmsStockplaceQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockplaceQueryDto mesWmsStockplaceQueryDto) {
        MesWmsStockplace stockplace = new MesWmsStockplace();
        BeanUtils.copyProperties(mesWmsStockplaceQueryDto,stockplace);
        return ResultVO.create().success(this.mesWmsStockplaceService.queryAll(stockplace));
    }

    /**
     * 分页查询
     *
     * @param mesWmsStockplaceQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO queryByPage(@RequestBody MesWmsStockplaceQueryDto mesWmsStockplaceQueryDto){
        MesWmsStockplace mesWmsStockplace = new MesWmsStockplace();
        BeanUtils.copyProperties(mesWmsStockplaceQueryDto,mesWmsStockplace);
        return ResultVO.create().success(this.mesWmsStockplaceService.queryByPage(mesWmsStockplace));
    }

    /**
     * 树状查询
     *
     * @return 查询结果
     */
    @GetMapping("/queryTree")
    @ApiOperation(value="树状查询")
    public ResultVO queryTree(String stockType){
        return this.mesWmsStockplaceService.queryTree(stockType);
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
        return this.mesWmsStockplaceService.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param mesWmsStockplace 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation(value ="新增")
    public ResultVO add(MesWmsStockplace mesWmsStockplace) {
        return this.mesWmsStockplaceService.insert(mesWmsStockplace);
    }

    /**
     * 编辑数据
     *
     * @param mesWmsStockplace 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    @ApiOperation(value= "修改")
    public ResultVO edit(MesWmsStockplace mesWmsStockplace) {
       return this.mesWmsStockplaceService.update(mesWmsStockplace);
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
        return this.mesWmsStockplaceService.deleteById(id);
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
        return this.mesWmsStockplaceService.updateById(id);
    }


    /**
     * 仓库库位新增和编辑接口
     *
     * @param stockplaceDto 实体
     * @return 编辑结果
     */
    @ApiOperation("仓库库位新增和编辑接口")
    @RequestMapping(value = {"/addAndEdit"}, method = {RequestMethod.POST} )
    public ResultVO addAndEdit(@RequestBody MesWmsStockplaceDto stockplaceDto) {
        return mesWmsStockplaceService.addAndEdit(stockplaceDto);
    }

}


package com.bpm.mes.stock.server.controller;

import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockcurrent;
import com.bpm.mes.stock.server.dto.MesWmsStockcurrentDto;
import com.bpm.mes.stock.server.dto.MesWmsStockcurrentQueryDto;
import com.bpm.mes.stock.server.service.MesWmsStockcurrentService;
import com.bpm.mes.stock.server.service.MesWmsStockplaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 仓库即时库存明细表(MesWmsStockcurrent)表控制层
 *
 * @author makejava
 * @since 2022-04-18 14:55:55
 */
@RestController
@RequestMapping("mesWmsStockcurrent")
@Api(value = "/仓库即时库存明细表管理相关接口",tags = "仓库即时库存明细表管理相关接口")
//@CrossOrigin
public class MesWmsStockcurrentController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockcurrentService mesWmsStockcurrentService;

    @Resource
    private MesWmsStockplaceService mesWmsStockplaceService;
    
    /**
     * 条件查询
     *
     * @param mesWmsStockcurrentQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockcurrentQueryDto mesWmsStockcurrentQueryDto) {
        return ResultVO.create().success(this.mesWmsStockcurrentService.queryAll(mesWmsStockcurrentQueryDto));
    }
    
    /**
     * 分页查询
     *
     * @param mesWmsStockcurrentQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<List<MesWmsStockcurrent>>> queryByPage(@RequestBody MesWmsStockcurrentQueryDto mesWmsStockcurrentQueryDto){
        return this.mesWmsStockcurrentService.queryByPage(mesWmsStockcurrentQueryDto);
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
        return this.mesWmsStockcurrentService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockcurrent 实体
     * @return 新增结果
     */
//    @PostMapping("/add")
//    @ApiOperation(value ="新增")
//    public ResultVO add(MesWmsStockcurrent mesWmsStockcurrent) {
//        return this.mesWmsStockcurrentService.insert(mesWmsStockcurrent);
//    }

    /**
     * 编辑数据
     *
     * @param mesWmsStockcurrent 实体
     * @return 编辑结果
     */
//    @PutMapping("/edit")
//    @ApiOperation(value= "修改")
//    public ResultVO edit(MesWmsStockcurrent mesWmsStockcurrent) {
//       return this.mesWmsStockcurrentService.update(mesWmsStockcurrent);
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
//        return this.mesWmsStockcurrentService.deleteById(id);
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
        return this.mesWmsStockcurrentService.updateById(id);
    }

    /**
     * 查询仓库信息-用于查询条件
     *
     * @return 查询结果
     */
    @GetMapping("/selectStock")
    @ApiOperation(value= "查询仓库信息-用于查询条件")
    public ResultVO selectStock() {
        return this.mesWmsStockcurrentService.selectStock();
    }

    /**
     * 查询仓库库位信息-用于查询条件
     *
     * @return 查询结果
     */
    @GetMapping("/selectStockPlace")
    @ApiOperation(value= "查询仓库库位信息-用于库位转移查询条件")
    public ResultVO selectStockPlace(Integer stockId) {
        return this.mesWmsStockcurrentService.selectStockPlace(stockId);
    }

    /**
     * 库位转移
     *
     * @param mesWmsStockcurrentDto 实体
     * @return 库位转移结果
     */
    @PutMapping("/stockMovePlace")
    @ApiOperation(value= "库位转移")
    public ResultVO stockMovePlace(@RequestBody MesWmsStockcurrentDto mesWmsStockcurrentDto) {
        return this.mesWmsStockcurrentService.stockMovePlace(mesWmsStockcurrentDto);
    }

}


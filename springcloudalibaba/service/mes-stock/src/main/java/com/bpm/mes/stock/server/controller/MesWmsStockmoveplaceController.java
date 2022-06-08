package com.bpm.mes.stock.server.controller;

import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockmoveplace;
import com.bpm.mes.stock.server.dto.MesWmsStockcurrentDto;
import com.bpm.mes.stock.server.dto.MesWmsStockmoveplaceQueryDto;
import com.bpm.mes.stock.server.service.MesWmsStockcurrentService;
import com.bpm.mes.stock.server.service.MesWmsStockmoveplaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 仓库库位转移表(MesWmsStockmoveplace)表控制层
 *
 * @author makejava
 * @since 2022-04-18 17:38:46
 */
@RestController
@RequestMapping("mesWmsStockmoveplace")
@Api(value = "/仓库库位转移表管理相关接口",tags = "仓库库位转移表管理相关接口")
//@CrossOrigin
public class MesWmsStockmoveplaceController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockmoveplaceService mesWmsStockmoveplaceService;

    @Resource
    private MesWmsStockcurrentService mesWmsStockcurrentService;

    /**
     * 条件查询
     *
     * @param mesWmsStockmoveplaceQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockmoveplaceQueryDto mesWmsStockmoveplaceQueryDto) {
        return ResultVO.create().success(this.mesWmsStockmoveplaceService.queryAll(mesWmsStockmoveplaceQueryDto));
    }
    
    /**
     * 分页查询
     *
     * @param mesWmsStockmoveplaceQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<List<MesWmsStockmoveplace>>> queryByPage(@RequestBody MesWmsStockmoveplaceQueryDto mesWmsStockmoveplaceQueryDto){

        return this.mesWmsStockmoveplaceService.queryByPage(mesWmsStockmoveplaceQueryDto);
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
        return this.mesWmsStockmoveplaceService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockmoveplace 实体
     * @return 新增结果
     */
//    @PostMapping("/add")
//    @ApiOperation(value ="新增")
//    public ResultVO add(MesWmsStockmoveplace mesWmsStockmoveplace) {
//        return this.mesWmsStockmoveplaceService.insert(mesWmsStockmoveplace);
//    }

    /**
     * 编辑数据
     *
     * @param mesWmsStockmoveplace 实体
     * @return 编辑结果
     */
//    @PutMapping("/edit")
//    @ApiOperation(value= "修改")
//    public ResultVO edit(MesWmsStockmoveplace mesWmsStockmoveplace) {
//       return this.mesWmsStockmoveplaceService.update(mesWmsStockmoveplace);
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
//        return this.mesWmsStockmoveplaceService.deleteById(id);
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
        return this.mesWmsStockmoveplaceService.updateById(id);
    }

    /**
     * 查询仓库-库区库位-物料
     *
     * @return 编辑结果
     */
    @ApiOperation("查询仓库-库区库位-物料")
    @GetMapping("/selectMaterial")
    public ResultVO selectMaterial(Integer stockId,Integer stockPlaceId) {
        return mesWmsStockmoveplaceService.selectMaterial(stockId,stockPlaceId);
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
     * 仓库库位转移新增和编辑接口
     *
     * @param mesWmsStockcurrentDto 实体
     * @return 编辑结果
     */
    @ApiOperation("仓库库位转移新增和编辑接口")
    @RequestMapping(value = {"/addAndEdit"}, method = {RequestMethod.POST} )
    public ResultVO addAndEdit(@RequestBody MesWmsStockcurrentDto mesWmsStockcurrentDto) {
        return mesWmsStockmoveplaceService.addAndEdit(mesWmsStockcurrentDto);
    }

    /**
     * 审核
     *
     * @param id 实体
     * @return 编辑结果
     */
    @ApiOperation("审核")
    @GetMapping("/isCheck")
    public ResultVO isCheck(Integer id) {
        return mesWmsStockmoveplaceService.isCheck(id);
    }

}


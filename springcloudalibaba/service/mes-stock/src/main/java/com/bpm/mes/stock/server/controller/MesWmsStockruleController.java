package com.bpm.mes.stock.server.controller;
import com.bpm.mes.stock.common.vo.ResultVO;
import com.bpm.mes.stock.server.domain.MesWmsStockrule;
import com.bpm.mes.stock.server.dto.MesWmsStockruleDto;
import com.bpm.mes.stock.server.dto.MesWmsStockruleQueryDto;
import com.bpm.mes.stock.server.service.MesWmsStockruleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 仓库出入库规则(MesWmsStockrule)表控制层
 *
 * @author makejava
 * @since 2022-04-15 17:46:48
 */
@RestController
@RequestMapping("/mesWmsStockrule")
@Api(value = "仓库出入库规则管理相关接口",tags = "仓库出入库规则管理相关接口")
//@CrossOrigin
public class MesWmsStockruleController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsStockruleService mesWmsStockruleService;
    
    /**
     * 条件查询
     *
     * @param mesWmsStockruleQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsStockruleQueryDto mesWmsStockruleQueryDto) {
        MesWmsStockrule stockrule = new MesWmsStockrule();
        BeanUtils.copyProperties(mesWmsStockruleQueryDto,stockrule);
        return ResultVO.create().success(this.mesWmsStockruleService.queryAll(stockrule));
    }
    
    /**
     * 分页查询
     *
     * @param mesWmsStockruleQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO queryByPage(@RequestBody MesWmsStockruleQueryDto mesWmsStockruleQueryDto){
        MesWmsStockrule stockrule = new MesWmsStockrule();
        BeanUtils.copyProperties(mesWmsStockruleQueryDto,stockrule);
        return ResultVO.create().success(this.mesWmsStockruleService.queryByPage(stockrule));
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
        return this.mesWmsStockruleService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param mesWmsStockrule 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation(value ="新增")
    public ResultVO add(MesWmsStockrule mesWmsStockrule) {
        return this.mesWmsStockruleService.insert(mesWmsStockrule);
    }

    /**
     * 编辑数据
     *
     * @param mesWmsStockrule 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    @ApiOperation(value= "修改")
    public ResultVO edit(MesWmsStockrule mesWmsStockrule) {
       return this.mesWmsStockruleService.update(mesWmsStockrule);
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
        return this.mesWmsStockruleService.deleteById(id);
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
        return this.mesWmsStockruleService.updateById(id);
    }

    /**
     * 仓库出入库规则新增和编辑接口
     *
     * @param stockruleDto 实体
     * @return 编辑结果
     */
    @ApiOperation("仓库出入库规则新增和编辑接口")
    @RequestMapping(value = {"/addAndEdit"}, method = {RequestMethod.POST} )
    public ResultVO addAndEdit(@RequestBody MesWmsStockruleDto stockruleDto) {
        return mesWmsStockruleService.addAndEdit(stockruleDto);
    }

}


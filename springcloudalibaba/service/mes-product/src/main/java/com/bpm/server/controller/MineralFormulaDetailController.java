package com.bpm.server.controller;

import com.bpm.common.domain.MineralFormulaDetail;
import com.bpm.common.vo.MineralFormulaDetailVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MineralFormulaDetailService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import java.util.List;

/**
 * 矿石配方明细
 *
 * @author zhangzheming
 * @since 2022-05-09 19:55:36
 */
@RestController
@RequestMapping("mineralFormulaDetail")
@Api(tags = "矿石配方明细")

public class MineralFormulaDetailController {
    /**
     * 服务对象
     */
    @Resource
    private MineralFormulaDetailService mineralFormulaDetailService;

    /**
     * 新增数据
     *
     * @param mineralFormulaDetail 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MineralFormulaDetail mineralFormulaDetail) {
        return this.mineralFormulaDetailService.insert(mineralFormulaDetail);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("deleteById")
    @ApiOperation(value = "删除")
    public ResultVO deleteById(Integer id) {
        return this.mineralFormulaDetailService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param mineralFormulaDetail 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO update(@RequestBody MineralFormulaDetail mineralFormulaDetail) {
        return this.mineralFormulaDetailService.update(mineralFormulaDetail);
    }

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @GetMapping("queryById")
    @ApiOperation(value = "查单个")
    public ResultVO queryById(Integer id) {
        return this.mineralFormulaDetailService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO queryAll() {
        return this.mineralFormulaDetailService.queryAll();
    }

    /**
     * 根据矿石配方id查询所有矿石配方详情
     *
     * @param mineralFormulaId 矿石配方id
     * @return 查询结果
     */
    @GetMapping("queryByMineralFormulaId")
    @ApiOperation(value = "根据矿石配方id查询所有矿石配方详情")
    public ResultVO<List<MineralFormulaDetailVo>> queryByMineralFormulaId(Integer mineralFormulaId) {
        return this.mineralFormulaDetailService.queryByMineralFormulaId(mineralFormulaId);
    }
}
package com.bpm.server.controller;


import com.bpm.common.dto.MineralFormulaAddUpdateDto;
import com.bpm.common.dto.MineralFormulaQueryDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MineralFormulaQueryVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MineralFormulaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 矿石配方
 *
 * @author zhangzheming
 * @since 2022-05-09 15:15:56
 */
@RestController
@RequestMapping("mineralFormula")
@Api(tags = "矿石配方")

////todo 测试代码
//@CrossOrigin(
//        allowCredentials = "true",
//        allowedHeaders = {"*"},
//        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH},
//        originPatterns = {"*"}
//)


public class MineralFormulaController {
    /**
     * 服务对象
     */
    @Resource
    private MineralFormulaService mineralFormulaService;

    /**
     * 新增数据
     *
     * @param mineralFormulaAddUpdateDto 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO<Object> add(@RequestBody MineralFormulaAddUpdateDto mineralFormulaAddUpdateDto) {
        if (mineralFormulaAddUpdateDto == null
                || mineralFormulaAddUpdateDto.getMineralFormula() == null
                || mineralFormulaAddUpdateDto.getMineralFormulaDetailList() == null
                || mineralFormulaAddUpdateDto.getMineralFormulaDetailList().isEmpty()) {
            return ResultUtil.error("矿石配方、矿石配方详情不能为空");
        }
        if (mineralFormulaAddUpdateDto.getMineralFormula().getFormulaName() == null) {
            return ResultUtil.error("矿石配方名称不能为空");
        }
        return this.mineralFormulaService.insert(mineralFormulaAddUpdateDto);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("deleteById")
    @ApiOperation(value = "删除")
    public ResultVO<Object> deleteById(Integer id) {
        return this.mineralFormulaService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param mineralFormulaAddUpdateDto 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO<Object> update(@RequestBody MineralFormulaAddUpdateDto mineralFormulaAddUpdateDto) {
        if (mineralFormulaAddUpdateDto == null
                || mineralFormulaAddUpdateDto.getMineralFormula() == null
                || mineralFormulaAddUpdateDto.getMineralFormulaDetailList() == null
                || mineralFormulaAddUpdateDto.getMineralFormulaDetailList().isEmpty()) {
            return ResultUtil.error("矿石配方、矿石配方详情不能为空");
        }
        if (mineralFormulaAddUpdateDto.getMineralFormula().getId() == null) {
            return ResultUtil.error("矿石配方id不能为空");
        }
        return this.mineralFormulaService.update(mineralFormulaAddUpdateDto);
    }

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @GetMapping("queryById")
    @ApiOperation(value = "查单个")
    public ResultVO<MineralFormulaQueryVo> queryById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        return this.mineralFormulaService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO<Object> queryAll() {
        return this.mineralFormulaService.queryAll();
    }

    /**
     * 分页查
     *
     * @param mineralFormulaQueryDto 查询条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value = "分页查")
    public ResultVO<Object> queryByPage(@RequestBody MineralFormulaQueryDto mineralFormulaQueryDto) {
        return this.mineralFormulaService.queryByPage(mineralFormulaQueryDto);
    }
}
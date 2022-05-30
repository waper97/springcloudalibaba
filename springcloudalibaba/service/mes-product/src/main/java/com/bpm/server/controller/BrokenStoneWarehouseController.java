package com.bpm.server.controller;

import java.util.List;

import com.bpm.common.dto.BrokenStoneWarehouseInsertOrUpdateDTO;
import com.bpm.common.vo.BrokenStoneWarehouseVO;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.dto.BrokenStoneWarehouseDTO;
import com.bpm.common.domain.BrokenStoneWarehouse;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.BrokenStoneWarehouseService;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

/**
 * 碎石仓 控制层
 *
 * @author wangpeng
 * @since 2022-04-29 10:24:45
 */
@Api(tags = "碎石仓")
@RestController
@RequestMapping("brokenStoneWarehouse")

////todo 测试代码
//@CrossOrigin(
//        allowCredentials = "true",
//        allowedHeaders = {"*"},
//        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH},
//        originPatterns = {"*"}
//)

public class BrokenStoneWarehouseController {
    /**
     * 服务对象
     */
    @Resource
    private BrokenStoneWarehouseService brokenStoneWarehouseService;


    /**
     * 条件查询 碎石仓
     *
     * @param brokenStoneWarehouse 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value = "条件查询")
    public ResultVO<List<BrokenStoneWarehouseVO>> queryAll(@RequestBody BrokenStoneWarehouseDTO brokenStoneWarehouse) {
        return ResultUtil.success(this.brokenStoneWarehouseService.queryAll(brokenStoneWarehouse));
    }

    /**
     * 分页查询 碎石仓
     *
     * @param brokenStoneWarehouse 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value = "分页查询")
    public ResultVO<PageInfoVO<BrokenStoneWarehouseVO>> Page(@RequestBody BrokenStoneWarehouseDTO brokenStoneWarehouse) {
        return ResultUtil.success(this.brokenStoneWarehouseService.queryByPage(brokenStoneWarehouse));
    }

    /**
     * 新增或修改
     *
     * @param brokenStoneWarehouse 实体
     * @return 新增或修改结果
     */
    @PostMapping("insertOrUpdate")
    @ApiOperation(value = "新增或修改")
    public ResultVO insertOrUpdate(@RequestBody BrokenStoneWarehouseInsertOrUpdateDTO brokenStoneWarehouse) {
        boolean result;
        if (brokenStoneWarehouse.getId() == null) {
            result = this.brokenStoneWarehouseService.insert(brokenStoneWarehouse);
        } else {
            result = this.brokenStoneWarehouseService.update(brokenStoneWarehouse);
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 新增数据
     *
     * @param brokenStoneWarehouse 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody BrokenStoneWarehouse brokenStoneWarehouse) {
        if (brokenStoneWarehouse == null || brokenStoneWarehouse.getWarehouseId() == null) {
            return ResultUtil.error("仓库id不能为空");
        }
        boolean result = this.brokenStoneWarehouseService.insert(brokenStoneWarehouse);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 详情
     *
     * @param id 主键id
     * @return 详情结果
     */
    @GetMapping("/detail")
    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO<BrokenStoneWarehouse> detail(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空！");
        }
        return ResultUtil.success(this.brokenStoneWarehouseService.queryById(id));
    }

    /**
     * 编辑数据
     *
     * @param brokenStoneWarehouse 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO edit(@RequestBody BrokenStoneWarehouseInsertOrUpdateDTO brokenStoneWarehouse) {
        boolean result = this.brokenStoneWarehouseService.update(brokenStoneWarehouse);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("removeById")
    @ApiOperation(value = "删除")
//    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO removeById(Integer id) {
        boolean result = this.brokenStoneWarehouseService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

}


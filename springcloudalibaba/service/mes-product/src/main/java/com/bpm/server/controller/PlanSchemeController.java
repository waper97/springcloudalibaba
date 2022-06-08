package com.bpm.server.controller;

import com.bpm.common.domain.PlanScheme;
import com.bpm.common.dto.PlanSchemeDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.PlanSchemeVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.PlanSchemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *  计划方案 表控制层
 * @author wangpeng
 * @since 2022-05-18 14:53:11
 */
@Api(tags = " 计划方案")
@RestController
@RequestMapping("planScheme")
public class PlanSchemeController {
    /**
     * 服务对象
     */
    @Resource
    private PlanSchemeService planSchemeService;


   
     /**
     * 条件查询  计划方案
     * @param planScheme 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO<List<PlanSchemeVO>> queryAll(@RequestBody PlanSchemeDTO planScheme) {
        return ResultUtil.success(this.planSchemeService.queryAll(planScheme));
    }
      /**
     * 分页查询  计划方案
     * @param planScheme 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO<PageInfoVO<PlanSchemeVO>> Page(@RequestBody PlanSchemeDTO planScheme){
        return ResultUtil.success(this.planSchemeService.queryByPage(planScheme));
    }


  /**
     * 新增或修改
     * @param planScheme 实体
     * @return 新增或修改结果
     */
    @PostMapping("insertOrUpdate")
    @ApiOperation(value = "新增或修改")
    public ResultVO insertOrUpdate(@RequestBody PlanScheme planScheme) {
        boolean result;
        if (planScheme.getId() == null) {
             result = this.planSchemeService.insert(planScheme);
        }else{
             result = this.planSchemeService.update(planScheme);
        }
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 新增数据
     * @param planScheme 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value ="新增")
    public ResultVO add(@RequestBody PlanScheme planScheme) {
        boolean result = this.planSchemeService.insert(planScheme);
        return result ? ResultUtil.success() : ResultUtil.error();
    }
    
     /**
     * 详情
     * @param id 主键id
     * @return 详情结果
     */
    @GetMapping("/detail")
    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO<PlanScheme> detail (Integer id) {
        if (id == null) {
            return  ResultUtil.error("id不能为空！");
        }
       return ResultUtil.success(this.planSchemeService.queryById(id));
    }

    /**
     * 编辑数据
     * @param planScheme 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    @ApiOperation(value= "修改" )
    public ResultVO edit(@RequestBody PlanScheme planScheme) {
       boolean result = this.planSchemeService.update(planScheme);
       return  result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("deleteById")
    @ApiOperation(value = "删除" )
    @ApiImplicitParam(name = "id", value = "主键id", required = true)
    public ResultVO removeById(Integer id) {
        boolean result = this.planSchemeService.deleteById(id);
        return result ? ResultUtil.success() : ResultUtil.error();
    }

    /**
     * 根据计划类型获取 计划方案信息
     * @param schemeType
     * @return
     */
    @GetMapping("getSchemeTypeByType")
    @ApiOperation(value = "根据计划类型 获取计划方案信息" )
    @ApiImplicitParam(name = "schemeType", value = "计划类型", required = true)
    public ResultVO<PlanSchemeVO> getSchemeTypeByType (String schemeType) {
        if (StringUtils.isEmpty(schemeType)) {
            return ResultUtil.error("计划类型不能为空!");
        }
        return ResultUtil.success(planSchemeService.getSchemeTypeByType(schemeType));
    }

}


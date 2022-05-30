package com.bpm.server.controller;

import com.bpm.common.dto.MesProductProductionLineDto;
import com.bpm.common.vo.MesProductProductionLineVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;

import com.bpm.common.domain.MesProductProductionLine;
import com.bpm.server.service.MesProductProductionLineService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生产线
 *
 * @author zhangzheming
 * @since 2022-04-25 09:50:18
 */
@RestController
@RequestMapping("mesProductProductionLine")
@Api(tags = "生产线")

////todo 测试代码
//@CrossOrigin(
//        allowCredentials = "true",
//        allowedHeaders = {"*"},
//        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH},
//        originPatterns = {"*"}
//)


public class MesProductProductionLineController {
    /**
     * 服务对象
     */
    @Resource
    private MesProductProductionLineService mesProductProductionLineService;

    /**
     * 新增数据
     *
     * @param mesProductProductionLine 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MesProductProductionLine mesProductProductionLine) {
        return this.mesProductProductionLineService.insert(mesProductProductionLine);
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
        return this.mesProductProductionLineService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param mesProductProductionLine 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO update(@RequestBody MesProductProductionLine mesProductProductionLine) {
        return this.mesProductProductionLineService.update(mesProductProductionLine);
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
        return this.mesProductProductionLineService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO queryAll() {
        return this.mesProductProductionLineService.queryAll();
    }

    /**
     * 分页查询
     *
     * @param mesProductProductionLineDto 查询条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value = "分页查询")
    public ResultVO<PageInfoVO<List<MesProductProductionLineVo>>> queryByPage(@RequestBody MesProductProductionLineDto mesProductProductionLineDto) {
        return this.mesProductProductionLineService.queryByPage(mesProductProductionLineDto);
    }

    /**
     * 查询所有生产线编号
     *
     * @return 查询结果
     */
    @GetMapping("queryAllLineNumbers")
    @ApiOperation(value = "查询所有生产线编号")
    public ResultVO queryAllLineNumbers() {
        return this.mesProductProductionLineService.queryAllLineNumbers();
    }

    /**
     * 查询所有公司名称
     *
     * @return 查询结果
     */
    @GetMapping("queryAllCompanyNames")
    @ApiOperation(value = "查询所有公司名称")
    public ResultVO queryAllCompanyNames() {
        return this.mesProductProductionLineService.queryAllCompanyNames();
    }

}
package com.bpm.server.controller;

import com.bpm.common.domain.MesProductHomogenizationRecordDetail;
import com.bpm.common.vo.MesProductHomogenizationRecordDetailVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MesProductHomogenizationRecordDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 均化记录详情
 *
 * @author zhangzheming
 * @since 2022-05-06 18:25:21
 */
@RestController
@RequestMapping("mesProductHomogenizationRecordDetail")
@Api(tags = "均化记录详情")

public class MesProductHomogenizationRecordDetailController {
    /**
     * 服务对象
     */
    @Resource
    private MesProductHomogenizationRecordDetailService mesProductHomogenizationRecordDetailService;

    /**
     * 新增数据
     *
     * @param mesProductHomogenizationRecordDetail 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail) {
        return this.mesProductHomogenizationRecordDetailService.insert(mesProductHomogenizationRecordDetail);
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
        return this.mesProductHomogenizationRecordDetailService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param mesProductHomogenizationRecordDetail 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO update(@RequestBody MesProductHomogenizationRecordDetail mesProductHomogenizationRecordDetail) {
        return this.mesProductHomogenizationRecordDetailService.update(mesProductHomogenizationRecordDetail);
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
        return this.mesProductHomogenizationRecordDetailService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO queryAll() {
        return this.mesProductHomogenizationRecordDetailService.queryAll();
    }

    /**
     * 根据均化记录id查询所有均化记录详情
     *
     * @param homogenizationRecordId 均化记录id
     * @return 查询结果
     */
    @GetMapping("queryByHomogenizationRecordId")
    @ApiOperation(value = "根据均化记录id查询所有均化记录详情")
    public ResultVO<List<MesProductHomogenizationRecordDetailVo>> queryByHomogenizationRecordId(Integer homogenizationRecordId) {
        return this.mesProductHomogenizationRecordDetailService.queryByHomogenizationRecordId(homogenizationRecordId);
    }
}
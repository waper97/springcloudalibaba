package com.bpm.server.controller;

import com.bpm.common.domain.MesProductPrehomogenizationRecordDetail;
import com.bpm.common.vo.MesProductPreHomogenizationRecordDetailVo;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MesProductPrehomogenizationRecordDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 预均化记录详情
 *
 * @author zhangzheming
 * @since 2022-05-06 19:06:53
 */
@RestController
@RequestMapping("mesProductPrehomogenizationRecordDetail")
@Api(tags = "预均化记录详情")
public class MesProductPrehomogenizationRecordDetailController {
    /**
     * 服务对象
     */
    @Resource
    private MesProductPrehomogenizationRecordDetailService mesProductPrehomogenizationRecordDetailService;

    /**
     * 新增数据
     *
     * @param mesProductPrehomogenizationRecordDetail 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail) {
        return this.mesProductPrehomogenizationRecordDetailService.insert(mesProductPrehomogenizationRecordDetail);
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
        return this.mesProductPrehomogenizationRecordDetailService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param mesProductPrehomogenizationRecordDetail 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO edit(@RequestBody MesProductPrehomogenizationRecordDetail mesProductPrehomogenizationRecordDetail) {
        return this.mesProductPrehomogenizationRecordDetailService.update(mesProductPrehomogenizationRecordDetail);
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
        return this.mesProductPrehomogenizationRecordDetailService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO queryAll() {
        return this.mesProductPrehomogenizationRecordDetailService.queryAll();
    }

    /**
     * 根据预均化记录id查询所有预均化记录详情
     *
     * @param preHomogenizationRecordId 预均化记录id
     * @return 查询结果
     */
    @GetMapping("queryByPreHomogenizationRecordId")
    @ApiOperation(value = "根据预均化记录id查询所有预均化记录详情")
    public ResultVO<List<MesProductPreHomogenizationRecordDetailVo>> queryByPreHomogenizationRecordId(Integer preHomogenizationRecordId) {
        return this.mesProductPrehomogenizationRecordDetailService.queryByPreHomogenizationRecordId(preHomogenizationRecordId);
    }
}
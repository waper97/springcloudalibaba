package com.bpm.server.controller;

import com.bpm.common.dto.MesProductPreHomogenizationRecordAddUpdateDto;
import com.bpm.common.dto.MesProductPrehomogenizationRecordPageQueryDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductPreHomogenizationRecordQueryVo;
import com.bpm.common.vo.MesProductPreHomogenizationRecordVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MesProductPrehomogenizationRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 预均化记录
 *
 * @author zhangzheming
 * @since 2022-05-06 11:16:36
 */
@RestController
@RequestMapping("mesProductPrehomogenizationRecord")
@Api(tags = "预均化记录")
public class MesProductPrehomogenizationRecordController {
    /**
     * 服务对象
     */
    @Resource
    private MesProductPrehomogenizationRecordService mesProductPrehomogenizationRecordService;

    /**
     * 新增数据
     *
     * @param addDto 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MesProductPreHomogenizationRecordAddUpdateDto addDto) {
        if (addDto == null
                || addDto.getRecord() == null
                || addDto.getRecordDetailList() == null) {
            return ResultUtil.error("预均化记录、预均化记录详情不能为空");
        }
        return this.mesProductPrehomogenizationRecordService.insert(addDto);
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
        return this.mesProductPrehomogenizationRecordService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param updateDto 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO update(@RequestBody MesProductPreHomogenizationRecordAddUpdateDto updateDto) {
        if (updateDto == null
                || updateDto.getRecord() == null
                || updateDto.getRecordDetailList() == null) {
            return ResultUtil.error("预均化记录、预均化记录详情不能为空");
        }
        return this.mesProductPrehomogenizationRecordService.update(updateDto);
    }

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @GetMapping("queryById")
    @ApiOperation(value = "查单个")
    public ResultVO<MesProductPreHomogenizationRecordQueryVo> queryById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        return this.mesProductPrehomogenizationRecordService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO queryAll() {
        return this.mesProductPrehomogenizationRecordService.queryAll();
    }

    /**
     * 分页查
     *
     * @param mesProductPrehomogenizationRecordPageQueryDto 查询条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value = "分页查")
    public ResultVO<PageInfoVO<List<MesProductPreHomogenizationRecordVo>>> queryByPage(@RequestBody MesProductPrehomogenizationRecordPageQueryDto mesProductPrehomogenizationRecordPageQueryDto) {
        return this.mesProductPrehomogenizationRecordService.queryByPage(mesProductPrehomogenizationRecordPageQueryDto);
    }
}
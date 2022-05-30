package com.bpm.server.controller;

import com.bpm.common.dto.MesProductHomogenizationRecordAddUpdateDto;
import com.bpm.common.dto.MesProductHomogenizationRecordPageQueryDto;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.MesProductHomogenizationRecordQueryVo;
import com.bpm.common.vo.MesProductHomogenizationRecordVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MesProductHomogenizationRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 均化记录controller
 *
 * @author zhangzheming
 * @since 2022-05-05 17:14:57
 */
@RestController
@RequestMapping("mesProductHomogenizationRecord")
@Api(tags = "均化记录")
public class MesProductHomogenizationRecordController {
    /**
     * 服务对象
     */
    @Resource
    private MesProductHomogenizationRecordService mesProductHomogenizationRecordService;

    /**
     * 新增数据
     *
     * @param recordAddDto 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MesProductHomogenizationRecordAddUpdateDto recordAddDto) {
        if (recordAddDto == null
                || recordAddDto.getRecord() == null
                || recordAddDto.getRecordDetailList() == null) {
            return ResultUtil.error("均化记录、均化记录详情不能为空");
        }
        return this.mesProductHomogenizationRecordService.insert(recordAddDto);
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
        return this.mesProductHomogenizationRecordService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param updateDto 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO update(@RequestBody MesProductHomogenizationRecordAddUpdateDto updateDto) {
        if (updateDto == null
                || updateDto.getRecord() == null
                || updateDto.getRecordDetailList() == null) {
            return ResultUtil.error("均化记录、均化记录详情不能为空");
        }
        return this.mesProductHomogenizationRecordService.update(updateDto);
    }

    /**
     * 查单个
     *
     * @param id 主键
     * @return 查询结果
     */
    @GetMapping("queryById")
    @ApiOperation(value = "查单个")
    public ResultVO<MesProductHomogenizationRecordQueryVo> queryById(Integer id) {
        if (id == null) {
            return ResultUtil.error("id不能为空");
        }
        return this.mesProductHomogenizationRecordService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO queryAll() {
        return this.mesProductHomogenizationRecordService.queryAll();
    }

    /**
     * 分页查
     *
     * @param mesProductHomogenizationRecordPageQueryDto 查询条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value = "分页查")
    public ResultVO<PageInfoVO<List<MesProductHomogenizationRecordVo>>> queryByPage(@RequestBody MesProductHomogenizationRecordPageQueryDto mesProductHomogenizationRecordPageQueryDto) {
        return this.mesProductHomogenizationRecordService.queryByPage(mesProductHomogenizationRecordPageQueryDto);
    }
}
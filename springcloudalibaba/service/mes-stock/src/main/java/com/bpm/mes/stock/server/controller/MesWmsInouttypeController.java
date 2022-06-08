package com.bpm.mes.stock.server.controller;
import com.bpm.mes.stock.common.vo.ResultVO;

import com.bpm.mes.stock.server.dto.MesWmsInouttypeDto;
import com.bpm.mes.stock.server.dto.MesWmsInouttypeQueryDto;
import com.bpm.mes.stock.server.domain.MesWmsInouttype;
import com.bpm.mes.stock.server.service.MesWmsInouttypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

/**
 * 仓库出入库类型表(MesWmsInouttype)表控制层
 *
 * @author makejava
 * @since 2022-04-14 10:35:29
 */
@RestController
@RequestMapping("/mesWmsInouttype")
@Api(value = "仓库出入库类型管理相关接口",tags = "仓库出入库类型管理相关接口")
//@CrossOrigin
public class MesWmsInouttypeController {
    /**
     * 服务对象
     */
    @Resource
    private MesWmsInouttypeService mesWmsInouttypeService;
    
   
    /**
     * 条件查询
     *
     * @param dto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryAll")
    @ApiOperation(value="条件查询")
    public ResultVO queryAll(@RequestBody MesWmsInouttypeQueryDto dto) {
        MesWmsInouttype mesWmsInouttype = new MesWmsInouttype();
        BeanUtils.copyProperties(dto,mesWmsInouttype);
        return ResultVO.create().success(this.mesWmsInouttypeService.queryAll(mesWmsInouttype));
    }

    /**
     * 分页查询
     *
     * @param mesWmsInouttypeQueryDto 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value="分页查询")
    public ResultVO queryByPage(@RequestBody MesWmsInouttypeQueryDto mesWmsInouttypeQueryDto){
        MesWmsInouttype mesWmsInouttype = new MesWmsInouttype();
        BeanUtils.copyProperties(mesWmsInouttypeQueryDto,mesWmsInouttype);
        return ResultVO.create().success(this.mesWmsInouttypeService.queryByPage(mesWmsInouttype));
    }


    /**
     * 新增数据
     *
     * @param mesWmsInouttype 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation(value ="新增")
    public ResultVO add(MesWmsInouttype mesWmsInouttype) {
        return this.mesWmsInouttypeService.insert(mesWmsInouttype);
    }

    /**
     * 编辑数据
     *
     * @param mesWmsInouttype 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    @ApiOperation(value= "修改")
    public ResultVO edit(MesWmsInouttype mesWmsInouttype) {
       return this.mesWmsInouttypeService.update(mesWmsInouttype);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public ResultVO removeById(Integer id) {
        return this.mesWmsInouttypeService.deleteById(id);
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
        return this.mesWmsInouttypeService.updateById(id);
    }


    /**
     * 仓库出入库类型新增和编辑接口
     *
     * @param inouttypeDto 实体
     * @return 编辑结果
     */
    @ApiOperation("仓库出入库类型新增和编辑接口")
    @RequestMapping(value = {"/addAndEdit"}, method = {RequestMethod.POST} )
    public ResultVO addAndEdit(@RequestBody MesWmsInouttypeDto inouttypeDto) {
        return mesWmsInouttypeService.addAndEdit(inouttypeDto);
    }

}


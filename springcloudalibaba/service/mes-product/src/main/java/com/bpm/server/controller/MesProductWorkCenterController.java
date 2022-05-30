package com.bpm.server.controller;

import com.bpm.common.domain.MesProductWorkCenter;
import com.bpm.common.dto.MesProductWorkCenterDto;
import com.bpm.common.vo.MesProductWorkCenterVo;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.MesProductWorkCenterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作中心表(MesProductWorkCenter)表控制层
 *
 * @author zhangzheming
 * @since 2022-04-27 18:00:02
 */
@RestController
@RequestMapping("mesProductWorkCenter")
@Api(tags = "工作中心")

////todo 测试代码
//@CrossOrigin(
//        allowCredentials = "true",
//        allowedHeaders = {"*"},
//        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH},
//        originPatterns = {"*"}
//)


public class MesProductWorkCenterController {
    /**
     * 服务对象
     */
    @Resource
    private MesProductWorkCenterService mesProductWorkCenterService;

    /**
     * 新增数据
     *
     * @param mesProductWorkCenter 实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation(value = "新增")
    public ResultVO add(@RequestBody MesProductWorkCenter mesProductWorkCenter) {
        return this.mesProductWorkCenterService.insert(mesProductWorkCenter);
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
        return this.mesProductWorkCenterService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param mesProductWorkCenter 实体
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation(value = "修改")
    public ResultVO update(@RequestBody MesProductWorkCenter mesProductWorkCenter) {
        return this.mesProductWorkCenterService.update(mesProductWorkCenter);
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
        return this.mesProductWorkCenterService.queryById(id);
    }

    /**
     * 查全部
     *
     * @return 查询结果
     */
    @GetMapping("queryAll")
    @ApiOperation(value = "查全部")
    public ResultVO queryAll() {
        return this.mesProductWorkCenterService.queryAll();
    }

    /**
     * 分页查询
     *
     * @param mesProductWorkCenterDto 查询条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    @ApiOperation(value = "分页查")
    public ResultVO<PageInfoVO<List<MesProductWorkCenterVo>>> queryByPage(@RequestBody MesProductWorkCenterDto mesProductWorkCenterDto) {
        return this.mesProductWorkCenterService.queryByPage(mesProductWorkCenterDto);
    }

    /**
     * 查询所有资源类别
     *
     * @return 查询结果
     */
    @GetMapping("queryAllResourceCategories")
    @ApiOperation(value = "查询所有资源类别")
    public ResultVO queryAllResourceCategories() {
        return this.mesProductWorkCenterService.queryAllResourceCategories();
    }

}

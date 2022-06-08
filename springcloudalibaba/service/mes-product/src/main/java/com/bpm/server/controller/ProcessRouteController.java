package com.bpm.server.controller;

import com.bpm.common.dto.ProcessRouteDTO;
import com.bpm.common.util.ResultUtil;
import com.bpm.common.vo.PageInfoVO;
import com.bpm.common.vo.ProcessRouteVO;
import com.bpm.common.vo.ResultVO;
import com.bpm.server.service.ProcessRouteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工艺路线主 控制层
 * @author wangpeng
 * @since 2022-04-18 15:31:12
 */
@RestController
@RequestMapping("mesProductProcessRoute")
@Api(tags = "工艺路线 ")
public class ProcessRouteController {
        /**
         * 服务对象
         */
        @Resource
        private ProcessRouteService processRouteService;



        /**
         * 条件查询 工艺路线
         * @param mesProductProcessRoute 筛选条件
         * @return 查询结果
        */
        @PostMapping("queryAll")
        @ApiOperation(value = "条件查询")
        public ResultVO<List<ProcessRouteVO>> queryAll(@RequestBody ProcessRouteDTO mesProductProcessRoute){
            List<ProcessRouteVO> processRouteList = this.processRouteService.queryAll(mesProductProcessRoute);
            return ResultUtil.success(processRouteList);
        }
        /**
         * 分页查询
         * @param mesProductProcessRoute 筛选条件
         * @return 查询结果
         */
        @PostMapping("queryByPage")
        @ApiOperation(value = "分页查询")
        public ResultVO<PageInfoVO<ProcessRouteVO>> Page(@RequestBody ProcessRouteDTO mesProductProcessRoute){
            return ResultUtil.success(this.processRouteService.queryByPage(mesProductProcessRoute));
        }


        /**
         * 新增
         * @param processRoute 实体
         * @return 新增结果
         */
        @PostMapping("add")
        @ApiOperation(value = "新增")
        public ResultVO add(@RequestBody ProcessRouteVO processRoute){

            // TODO： 新增是，应该是选取产品id(物料id)
          if (StringUtils.isEmpty(processRoute.getProcessCode())) {
              return ResultUtil.error("流程卡号不能为空!");
          }
          if (StringUtils.isEmpty(processRoute.getProcessType())) {
                return ResultUtil.error("流程类型不能为空!");
          }
//          if (StringUtils.isEmpty(processRoute.getMineralPowderCode())) {
//                return ResultUtil.error("矿粉编号不能为空!");
//          }
          if (StringUtils.isEmpty(processRoute.getMineralPowderName())) {
                return ResultUtil.error("矿粉名称不能为空!");
          }
          boolean result = this.processRouteService.insert(processRoute);
          return result ? ResultUtil.success() : ResultUtil.error();
        }

        /**
         * 编辑
         * @param processRoute 实体
         * @return 编辑结果
         */
        @PostMapping("update")
        @ApiOperation(value = "修改")
        public ResultVO edit(@RequestBody ProcessRouteVO processRoute){
            if (StringUtils.isEmpty(processRoute.getProcessCode())) {
                return ResultUtil.error("流程卡号不能为空!");
            }
            if (StringUtils.isEmpty(processRoute.getProcessType())) {
                return ResultUtil.error("流程类型不能为空!");
            }
            if (StringUtils.isEmpty(processRoute.getMineralPowderCode())) {
                return ResultUtil.error("矿粉编号不能为空!");
            }
            if (StringUtils.isEmpty(processRoute.getMineralPowderName())) {
                return ResultUtil.error("矿粉名称不能为空!");
            }
           boolean result = this.processRouteService.update(processRoute);
           return result ? ResultUtil.success() : ResultUtil.error();
        }

    /**
     * 新增或修改
     * @param processRoute 实体
     * @return 编辑结果
     */
    @PostMapping("insertOrUpdate")
    @ApiOperation(value = "新增或修改")
        public ResultVO insertOrUpdate(@RequestBody ProcessRouteVO processRoute) {
            if (StringUtils.isEmpty(processRoute.getVersionNumber())) {
                return ResultUtil.error("版本号不能为空!");
            }
            if (StringUtils.isEmpty(processRoute.getProcessType())) {
                return ResultUtil.error("流程类型不能为空!");
            }
//            if (StringUtils.isEmpty(processRoute.getMineralPowderCode())) {
//                return ResultUtil.error("矿粉编号不能为空!");
//            }
//            if (StringUtils.isEmpty(processRoute.getMineralPowderName())) {
//                return ResultUtil.error("矿粉名称不能为空!");
//            }
            boolean result;
            if (processRoute.getId() == null) {
                 result = this.processRouteService.insert(processRoute);
            }else{
                 result = this.processRouteService.update(processRoute);
            }
            return result ? ResultUtil.success() : ResultUtil.error();
        }

        /**
         * 删除数据
         * @param id 主键
         * @return 删除是否成功
         */
        @DeleteMapping("removeById")
        @ApiOperation(value = "删除")
        @ApiImplicitParam(name = "id",value = "工艺路线id",required = true)
        public ResultVO removeById(Integer id){
            if (id == null) {
                return  ResultUtil.error("id不能为空！");
            }
            boolean result = this.processRouteService.deleteById(id);
            return result ? ResultUtil.success() : ResultUtil.error();
        }

//        /**
//         * 批量添加工艺路线详情
//         * @param processRouteDetailList
//         * @return
//         */
//        @PostMapping("batchSaveProceessRouteDetail")
//        @ApiOperation(value = "批量添加工艺路线详情信息")
//        public ResultVO batchSaveProceessRouteDetail(@RequestBody List<ProcessRouteDetail> processRouteDetailList) {
//             if (processRouteDetailList == null || processRouteDetailList.size() < 0) {
//                 return ResultVO.create().error("参数不能为空!");
//             }
//             boolean result = processRouteService.batchSaveProceessRouteDetail(processRouteDetailList);
//             return result ? ResultUtil.success() : ResultUtil.error();
//        }

        /**
         * 根据工艺路线id获取工艺路线详情
         * @param productProcessRouteId
         * @return
         */
        @GetMapping("listProcessRouteDetailByProcessRouteId")
        @ApiOperation(value = "根据工艺路线id获取工艺路线详情")
        public ResultVO<ProcessRouteVO> listProcessRouteDetailByProcessRouteId (Integer productProcessRouteId) {
            if (productProcessRouteId == null ) {
                return ResultUtil.error("工艺路线id不能为空!");
            }
            return ResultUtil.success(processRouteService.listProcessRouteDetailByProcessRouteId(productProcessRouteId));
        }

    /**
     * 工艺路线分类 列表
     * @return
     */
    @GetMapping(value = "/listProcessRouteType")
    @ApiOperation(value = "工艺路线分类")
    public  ResultVO listProcessRouteType () {
        return ResultUtil.success(processRouteService.listProceessRouteType());
    }
}


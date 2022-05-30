package com.bpm.common.vo;

import com.bpm.common.domain.MesProductHomogenizationRecordDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 均化记录详情vo
 *
 * @author zhangzheming
 * @since 2022-05-11
 */
@Data
@ApiModel(value = "均化记录详情vo")
public class MesProductHomogenizationRecordDetailVo extends MesProductHomogenizationRecordDetail {
    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String materialCode1;
    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materialName1;
    /**
     * 物料来源
     */
    @ApiModelProperty(value = "物料来源")
    private String materialSource1;
    /**
     * 碎石仓库
     */
    @ApiModelProperty(value = "碎石仓库")
    private String gravelWarehouse1;
}
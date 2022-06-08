package com.bpm.mes.purchase.common.struct;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(description = "Tree对象")
public class TreeNode {

    @ApiModelProperty(value = "节点id")
    protected Integer id;

    @ApiModelProperty(value = "节点父id")
    protected Integer parentId;

    @ApiModelProperty(value = "节点名称")
    protected String name;

    @ApiModelProperty(value = "子节点集合")
    protected List<TreeNode> children = new ArrayList<TreeNode>();
}
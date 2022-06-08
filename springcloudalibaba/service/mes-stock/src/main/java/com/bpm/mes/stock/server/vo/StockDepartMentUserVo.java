package com.bpm.mes.stock.server.vo;

import lombok.Data;

/**
 * 仓库信息表(MesWmsStock)实体类
 *
 * @author makejava
 * @since 2022-04-13 12:08:33
 */
@Data
public class StockDepartMentUserVo {
    /**
     * 所属部门ID（外键）
     */
    private Integer departmentId;
    /**
     * 所属部门编码
     */
    private String departmentCode;
    /**
     * 所属部门名称
     */
    private String departmentName;
}


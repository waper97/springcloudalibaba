package com.bpm.mes.stock.server.vo;

import lombok.Data;

/**
 * 仓库信息表(MesWmsStock)实体类
 *
 * @author makejava
 * @since 2022-04-13 12:08:33
 */
@Data
public class StockOtherVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
}


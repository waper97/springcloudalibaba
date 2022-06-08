package com.bpm.mes.stock.server.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 仓库信息表(MesWmsStock)实体类
 *
 * @author makejava
 * @since 2022-04-13 12:08:33
 */
@Data
public class StockManagerUserVo {
    /**
     * 库管员ID（EMPID），多个用“，”分隔
     */
    private String stockManagerId;
    /**
     * 库管员编号，多个用“，”分隔
     */
    private String stockManagerCode;
    /**
     * 库管员姓名多个用“，”分隔
     */
    private String stockManagerName;
}


package com.waper.dataanalysis.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @ClassName Log
 * @Description 日志
 * @Author wangpeng
 * @Date 2022/4/2 11:02
 */
@Data
@Entity

public class Log {

    @Id
    private String id;

    /**
     * 模块
     */
    private String module;

    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}

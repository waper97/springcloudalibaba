package com.waper.dataanalysis.model;

import lombok.Data;

/**
 * @ClassName BaseInfo
 * @Description 基础信息
 * @Author wangpeng
 * @Date 2020/8/18 17:22
 */
@Data
public class BaseInfo {


    public static final int  SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "操作成功!";
    public static final int  FAILURE_CODE = 499;
    public static final String FAILURE_MESSAGE = "操作失败!";
    // 成功标识
    private boolean success = true;
    // 信息
    private String message;
    // 状态
    private Integer status;
    // 数据
    private Object data;
    // 其他信息
    private Object other;

    public BaseInfo(boolean success, String message, Integer status) {
        this();
        this.success = success;
        this.message = message;
        this.status = status;
    }

    public BaseInfo(boolean success, String message, Integer status, Object data) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public BaseInfo(boolean success, String message, Integer status, Object data, Object other) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.data = data;
        this.other = other;
    }
    public BaseInfo(){
        System.out.println("fuck");
    }

}



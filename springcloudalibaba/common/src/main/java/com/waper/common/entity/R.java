package com.waper.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName R
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/11/7 16:08
 */

@Data
public class R<T> implements Serializable {

    public static Integer SUCCESS_CODE = 200;
    public static Integer FAIL_CODE = 400;

    private static String SUCCESS_MSG = "操作成功!";
    private static String FAIL_MSG = "操作失败!";
    private Integer code;
    private Boolean status;
    private String msg;
    private T data;
    private LocalDateTime date;

    public R() {
    }

    public R(Integer code, Boolean status, String msg, T data, LocalDateTime date) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.date = LocalDateTime.now();
    }

    public  R(Integer code, String msg) {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
        date = LocalDateTime.now();
    }

    public R(Integer code, String msg, Boolean status,T data) {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
        this.data = data;
        this.status = status;
        date = LocalDateTime.now();
    }

    public R(T data) {
        this.data = data;
    }

    public R(String msg) {
        this.msg = msg;
    }

    public static<T> R<T> success () {
        return new R<>(SUCCESS_CODE,R.SUCCESS_MSG);
    }


    public static<T> R<T> success (T data) {
        return new R<>(SUCCESS_CODE,R.SUCCESS_MSG,true,data);
    }



    public static<T> R<T> fail () {
        return new R<>(FAIL_CODE,R.FAIL_MSG);
    }
    public static<T> R<T> fail (String msg) {
        return new R<>(FAIL_CODE,msg);
    }




}

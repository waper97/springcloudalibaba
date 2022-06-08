package com.bpm.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "返回数据底层对象")
public class ResultVO<T>  implements Serializable {

    @ApiModelProperty("请求成功返回的值")
    public static final Integer SUCCESS = 200;

    @ApiModelProperty("请求错误返回的值")
    public static final Integer ERROR = 300;

    @ApiModelProperty("请求成功返回的消息")
    public static final String SUCCESS_MSG = "请求成功";

    @ApiModelProperty("请求错误返回的消息")
    public static final String ERROR_MSG = "请求失败";

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("消息")
    private String msg;

    /**
     * 创建返回对象
     *
     * @param <T> T
     * @return ResponseVO
     */
    public static <T> ResultVO<T> create() {
        return new ResultVO<>();
    }

    public ResultVO<T> success() {
        this.setCode(SUCCESS);
        this.setMsg(SUCCESS_MSG);
        return this;
    }

    public ResultVO<T> success(String msg) {
        this.setCode(SUCCESS);
        this.setMsg(msg);
        return this;
    }

    public ResultVO<T> success(T data) {
        this.setCode(SUCCESS);
        this.setMsg(SUCCESS_MSG);
        this.setData(data);
        return this;
    }

    public ResultVO<T> error() {
        this.setCode(ERROR);
        this.setMsg(ERROR_MSG);
        return this;
    }

    public ResultVO<T> error(String msg) {
        this.setCode(ERROR);
        this.setMsg(msg);
        return this;
    }

    public ResultVO<T> error(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }


}

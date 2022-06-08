package com.bpm.mes.stock.common.util;

import com.bpm.mes.stock.common.vo.PageInfoVO;
import com.bpm.mes.stock.common.vo.ResultVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "返回对象工具类")
public class ResultUtil {

    /**
     * 分页成功对象
     *
     * @param <T> 泛型对象
     * @return PageInfoVO
     */
    public static <T> PageInfoVO<T> successPageInfo() {
        return PageInfoVO.<T>createPageInfo().successPageInfo();
    }

    /**
     * 成功
     *
     * @param <T> 泛型对象
     * @param pageInfoVO
     * @return ResultVO
     */
//    public static <T> ResultVO<T> success(PageInfoVO<Object> pageInfoVO) {
//        return ResultVO.<T>create().success();
//    }

    /**
     * 成功
     *
     * @param message 成功消息
     * @param <T>     泛型对象
     * @return ResultVO
     */
    public static <T> ResultVO<T> success(String message) {
        return ResultVO.<T>create().success(message);
    }

    /**
     * 成功
     *
     * @param data 数据data
     * @param <T>  泛型对象
     * @return ResultVO
     */
    public static <T> ResultVO<T> success(T data) {
        return ResultVO.<T>create().success(data);
    }

    /**
     * 失败
     *
     * @param <T> 泛型对象
     * @return ResultVO
     */
    public static <T> ResultVO<T> error() {
        return ResultVO.<T>create().error();
    }

    /**
     * 失败
     *
     * @param message 失败消息
     * @param <T>     泛型对象
     * @return ResultVO
     */
    public static <T> ResultVO<T> error(String message) {
        return ResultVO.<T>create().error(message);
    }

    /**
     * 失败
     *
     * @param code    失败code
     * @param message 失败消息
     * @param <T>     泛型对象
     * @return ResultVO
     */
    public static <T> ResultVO<T> error(Integer code, String message) {
        return ResultVO.<T>create().error(code, message);
    }
}

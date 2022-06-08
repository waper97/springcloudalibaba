package com.bpm.common.util;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/5/30 15:44
 */
public class BusinessException extends RuntimeException{

    private String code;

    public BusinessException() {
        super();
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code='" + code + '\'' +":"+this.getMessage()+
                '}';
    }
}

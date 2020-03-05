package com.geekjc.server.modules.common.exception;

/**
 * @author ll
 * @date 2020年02月10日 3:14 PM
 *
 * 自定义异常类
 */
public class MyException extends Exception {
    /**
     * 异常状态码
     */
    private Integer code;

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getCode() {
        return code;
    }
}

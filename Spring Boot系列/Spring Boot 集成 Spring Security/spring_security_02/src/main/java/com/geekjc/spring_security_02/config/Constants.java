package com.geekjc.spring_security_02.config;

/**
 *  <p> 全局常用变量 </p>
 *
 * @description :
 * @author : ll
 * @date : 2019/10/12 14:47
 */
public class Constants {
    /**
     * 密码加密相关
     */
    public static String SALT = "ll";
    public static final int HASH_ITERATIONS = 1;

    /**
     * 请求头类型：
     * application/x-www-form-urlencoded ： form表单格式
     * application/json ： json格式
     */
    public static final String REQUEST_HEADERS_CONTENT_TYPE = "application/json";
}

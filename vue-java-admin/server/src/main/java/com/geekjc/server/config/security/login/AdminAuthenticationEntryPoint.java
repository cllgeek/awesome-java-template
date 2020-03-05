package com.geekjc.server.config.security.login;

import com.geekjc.server.modules.common.dto.output.ApiResult;
import com.geekjc.server.utils.ResponseUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ll
 * @date 2020年02月11日 4:11 PM
 *
 * 认证权限入口 - 未登录的情况下访问所有接口都会拦截到此
 * 前后端分离情况下返回json格式数据
 */
@Component
public class AdminAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        // 未登陆 或 token过期
        if(e!=null) {
            ResponseUtils.out(response, ApiResult.expired(e.getMessage()));
        } else {
            ResponseUtils.out(response, ApiResult.expired("Token过期!"));
        }
    }
}

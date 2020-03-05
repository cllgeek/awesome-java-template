package com.geekjc.server.config.security.login;

import com.geekjc.server.config.security.dto.SecurityUser;
import com.geekjc.server.modules.common.dto.output.ApiResult;
import com.geekjc.server.modules.system.entity.User;
import com.geekjc.server.utils.ResponseUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ll
 * @date 2020年02月15日 2:39 PM
 *
 * 认证成功处理
 */
@Component
public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        User user = new User();
        SecurityUser securityUser = ((SecurityUser) auth.getPrincipal());
        user.setToken(securityUser.getCurrentUserInfo().getToken());
        ResponseUtils.out(response, new ApiResult().ok("登录成功!", user));
    }
}

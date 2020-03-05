package com.geekjc.server.config.security.login;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author ll
 * @date 2020年02月15日 1:44 PM
 *
 * 自定义认证管理器
 */
@Component
public class CusAuthenticationManager implements AuthenticationManager {

    private final AdminAuthenticaitonProvider adminAuthenticaitonProvider;

    public CusAuthenticationManager(AdminAuthenticaitonProvider adminAuthenticaitonProvider) {
        this.adminAuthenticaitonProvider = adminAuthenticaitonProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication result = adminAuthenticaitonProvider.authenticate(authentication);
        if(Objects.nonNull(result)) {
            return result;
        }
        throw new ProviderNotFoundException("Authentication failed!");
    }
}

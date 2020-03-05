package com.geekjc.server.config.security.login;

import com.geekjc.server.config.Constants;
import com.geekjc.server.config.security.dto.SecurityUser;
import com.geekjc.server.config.security.service.impl.UserDetailsServiceImpl;
import com.geekjc.server.modules.system.entity.User;
import com.geekjc.server.modules.system.mapper.UserMapper;
import com.geekjc.server.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author ll
 * @date 2020年02月15日 1:46 PM
 *
 * 自定义认证处理
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // 解决@Autowired 引入mapper报红的原因
public class AdminAuthenticaitonProvider implements AuthenticationProvider {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    private final UserMapper userMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SecurityUser userInfo = (SecurityUser) userDetailsService.loadUserByUsername(userName);

        boolean isValid = PasswordUtils.isValidPassword(password, userInfo.getPassword(), userInfo.getCurrentUserInfo().getSalt());
        // 验证密码
        if(!isValid) {
            throw new BadCredentialsException("密码错误！");
        }

        // 前后端分离情况下 处理逻辑...
        // 更新登录令牌
        String token = PasswordUtils.encodePassword(String.valueOf(System.currentTimeMillis()), Constants.SALT);
        // 当前用户所拥有角色代码
        String roleCodes = userInfo.getRoleCodes();
        // 生成jwt访问令牌
//        String jwt = Jwts.builder()
//                // 用户角色
//                .claim(Constants.ROLE_LOGIN, roleCodes)
//                // 主题 - 存用户名
//                .setSubject(authentication.getName())
//                // 过期时间 - 30分钟
////                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
//                // 加密算法和密钥
//                .signWith(SignatureAlgorithm.HS512, Constants.SALT)
//                .compact();
        User user = userMapper.selectById(userInfo.getCurrentUserInfo().getId());
        user.setToken(token);
        userMapper.updateById(user);
        userInfo.getCurrentUserInfo().setToken(token);
        return new UsernamePasswordAuthenticationToken(userInfo, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

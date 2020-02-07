package com.geekjc.spring_security_04.config.security.login;

import com.geekjc.spring_security_04.config.Constants;
import com.geekjc.spring_security_04.config.security.service.impl.UserDetailsServiceImpl;
import com.geekjc.spring_security_04.config.security.dto.SecurityUser;
import com.geekjc.spring_security_04.modules.system.entity.Role;
import com.geekjc.spring_security_04.utils.PasswordUtils;
import com.geekjc.spring_security_04.modules.system.entity.User;
import com.geekjc.spring_security_04.modules.system.mapper.UserMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 *  <p> 自定义认证处理 </p>
 *
 * @description :
 * @author : ll
 * @date : 2019/10/12 14:49
 */
@Component
public class AdminAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SecurityUser userInfo = (SecurityUser) userDetailsService.loadUserByUsername(userName);

        boolean isValid = PasswordUtils.isValidPassword(password, userInfo.getPassword(), userInfo.getCurrentUserInfo().getSalt());
        // 验证密码
        if (!isValid) {
            throw new BadCredentialsException("密码错误！");
        }

        // 前后端分离情况下 处理逻辑...
        // 更新登录令牌
//        String token = PasswordUtils.encodePassword(String.valueOf(System.currentTimeMillis()), userInfo.getCurrentUserInfo().getSalt());
        // 当前用户所拥有角色代码
        String roleCodes = userInfo.getRoleCodes();
        // 生成jwt访问令牌
        String jwt = Jwts.builder()
                // 用户角色
                .claim(Constants.ROLE_LOGIN, roleCodes)
                // 主题 - 存用户名
                .setSubject(authentication.getName())
                // 过期时间 - 30分钟
//                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                // 加密算法和密钥
                .signWith(SignatureAlgorithm.HS512, Constants.SALT)
                .compact();


        User user = userMapper.selectById(userInfo.getCurrentUserInfo().getId());
        user.setToken(jwt);
        userMapper.updateById(user);
        userInfo.getCurrentUserInfo().setToken(jwt);
        return new UsernamePasswordAuthenticationToken(userInfo, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

package com.geekjc.server.config.security.dto;

import com.geekjc.server.modules.system.entity.Role;
import com.geekjc.server.modules.system.entity.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author ll
 * @date 2020年02月10日 11:00 AM
 *
 * 安全认证用户详情
 */
@Data
@Slf4j
public class SecurityUser implements UserDetails {
    /**
     * 当前登录用户
     */
    private transient User currentUserInfo;
    /**
     * 角色
     */
    private transient List<Role> roleList;
    /**
     * 当前用户所拥有角色代码
     */
    private transient String roleCodes;

    public SecurityUser() {}

    public SecurityUser(User user) {
        if(user != null) {
            this.currentUserInfo = user;
        }
    }

    public SecurityUser(User user, List<Role> roleList) {
        if(user != null) {
            this.currentUserInfo = user;
            this.roleList = roleList;
            if(!CollectionUtils.isEmpty(roleList)) {
                StringJoiner roleCodes = new StringJoiner(",", "[", "]"); // java.util包中StringJoiner类是java8新增功能。主要实现字符串连接，使用间隔符、前缀和后缀。
                roleList.forEach(e -> roleCodes.add(e.getCode()));
                this.roleCodes = roleCodes.toString();
            }
        }
    }

    /**
     * 获取当前用户所具有的角色
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if(!CollectionUtils.isEmpty(this.roleList)) {
            for(Role role : this.roleList) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority((role.getCode()));
                authorities.add(authority);
            }
        }
        //        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        //        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return currentUserInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return currentUserInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

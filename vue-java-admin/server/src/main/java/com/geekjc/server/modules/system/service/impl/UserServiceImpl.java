package com.geekjc.server.modules.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geekjc.server.config.Constants;
import com.geekjc.server.modules.system.dto.input.UserQueryPara;
import com.geekjc.server.modules.system.dto.model.ButtonVO;
import com.geekjc.server.modules.system.dto.model.MenuVO;
import com.geekjc.server.modules.system.dto.model.UserInfoVO;
import com.geekjc.server.modules.system.entity.Menu;
import com.geekjc.server.modules.system.entity.Role;
import com.geekjc.server.modules.system.entity.User;
import com.geekjc.server.modules.system.mapper.RoleMenuMapper;
import com.geekjc.server.modules.system.mapper.UserMapper;
import com.geekjc.server.modules.system.mapper.UserRoleMapper;
import com.geekjc.server.modules.system.service.IUserService;
import com.geekjc.server.utils.PasswordUtils;
import com.geekjc.server.utils.TreeBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author ll
 * @date 2020年02月28日 11:27 AM
 *
 * 系统管理-用户基础信息表 服务实现类
 */
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // 解决@Autowired 引入mapper报红的原因
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    private final UserRoleMapper userRoleMapper;

    private final RoleMenuMapper roleMenuMapper;

    @Override
    public void listPage(Page<User> page, UserQueryPara filter) {
        page.setRecords(userMapper.selectUsers(page, filter));
    }

    @Override
    public UserInfoVO getCurrentUserInfo(String token) {
        User user = userMapper.getUserInfoByToken(token);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtil.copyProperties(user, userInfoVO);

        Set<String> roles = new HashSet();
        Set<MenuVO> menuVOS = new HashSet();
        Set<ButtonVO> buttonVOS = new HashSet();

        // 查询某个用户角色
        List<Role> roleList = userRoleMapper.selectRoleByUserId(user.getId());
        if(roleList != null && !roleList.isEmpty()) {
            roles.add(roleList.get(0).getCode());
            log.info(roles.toString());
            // 查询某个角色的菜单
            List<Menu> menuList = roleMenuMapper.selectMenusByRoleId(roleList.get(0).getId());
            log.info(menuList.toString());
            if(menuList != null && !menuList.isEmpty()) {
                menuList.stream().filter(Objects::nonNull).forEach(menu -> {
                    if("button".equals(menu.getType().toLowerCase())) {
                        // 如果权限是按钮, 就添加到按钮里面
                        ButtonVO buttonVO = new ButtonVO();
                        BeanUtil.copyProperties(menu, buttonVO);
                        buttonVOS.add(buttonVO);
                    }
                    if("menu".equals(menu.getType().toLowerCase())) {
                        // 如果权限是菜单， 就添加到菜单里面
                        MenuVO menuVO = new MenuVO();
                        BeanUtil.copyProperties(menu, menuVO);
                        menuVOS.add(menuVO);
                    }
                });
            }
        }
        userInfoVO.getRoles().addAll(roles);
        userInfoVO.getButtons().addAll(buttonVOS);
        userInfoVO.getMenus().addAll(TreeBuilder.buildTree(menuVOS));
        return userInfoVO;
    }

    @Override
    public boolean save(User para) {
        if(para.getId() != null) {
            User user = userMapper.selectById(para.getId());
            para.setPassword(PasswordUtils.encodePassword(para.getPwd(), user.getSalt()));
            userMapper.updateById(para);
        } else {
            para.setSalt(Constants.SALT);
            para.setPassword(PasswordUtils.encodePassword(para.getPwd(), Constants.SALT));
            userMapper.insert(para);
        }
        return true;
    }
}

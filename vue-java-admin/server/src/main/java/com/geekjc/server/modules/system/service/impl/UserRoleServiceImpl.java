package com.geekjc.server.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geekjc.server.modules.system.dto.input.UserRoleQueryPara;
import com.geekjc.server.modules.system.entity.UserRole;
import com.geekjc.server.modules.system.mapper.UserRoleMapper;
import com.geekjc.server.modules.system.service.IUserRoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ll
 * @date 2020年02月29日 5:16 PM
 *
 * 系统管理 - 用户角色关联表  服务实现类
 */
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // 解决@Autowired 引入mapper报红的原因
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    private final UserRoleMapper userRoleMapper;

    @Override
    public void listPage(Page<UserRole> page, UserRoleQueryPara filter) {
        page.setRecords(userRoleMapper.selectUserRoles(page, filter));
    }

    @Override
    public List<UserRole> list(UserRoleQueryPara filter) {
        return userRoleMapper.selectUserRoles(filter);
    }

    @Override
    public boolean save(UserRole para) {
        if (para.getId()!=null) {
            userRoleMapper.updateById(para);
        } else {
            userRoleMapper.insert(para);
        }
        return true;
    }

    @Override
    public void saveUserRole(UserRoleQueryPara para) {
        Integer roleId = para.getRoleId();
        String userIds = para.getUserIds();
        userRoleMapper.deleteByRoleId( roleId );
        if( StringUtils.isNotBlank( userIds ) ){
            String[] userIdArrays = userIds.split( "," );
            if( userIdArrays.length > 0 ){
                for (String userId : userIdArrays) {
                    UserRole userRole = new UserRole();
                    userRole.setRoleId( roleId );
                    userRole.setUserId( Integer.parseInt( userId ) );
                    userRoleMapper.insert( userRole );
                }
            }
        }
    }

}

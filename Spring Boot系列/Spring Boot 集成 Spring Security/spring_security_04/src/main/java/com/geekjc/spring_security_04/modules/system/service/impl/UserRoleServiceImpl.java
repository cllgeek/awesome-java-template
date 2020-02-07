package com.geekjc.spring_security_04.modules.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.geekjc.spring_security_04.modules.system.dto.input.UserRoleQueryPara;
import com.geekjc.spring_security_04.modules.system.entity.UserRole;
import com.geekjc.spring_security_04.modules.system.mapper.UserRoleMapper;
import com.geekjc.spring_security_04.modules.system.service.IUserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> 系统管理 - 用户角色关联表  服务实现类 </p>
 *
 * @author: ll
 * @date: 2019-08-20
 */
@Service
@Transactional
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public void listPage(Page<UserRole> page, UserRoleQueryPara filter) {
        page.setRecords(userRoleMapper.selectUserRoles(page, filter));
    }

    @Override
    public List<UserRole> list(UserRoleQueryPara filter) {
        return userRoleMapper.selectUserRoles(filter);
    }

    @Override
    public Integer save(UserRole para) {
        if (para.getId()!=null) {
            userRoleMapper.updateById(para);
        } else {
            userRoleMapper.insert(para);
        }
        return para.getId();
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

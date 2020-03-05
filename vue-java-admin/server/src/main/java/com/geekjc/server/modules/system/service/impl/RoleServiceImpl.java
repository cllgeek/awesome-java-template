package com.geekjc.server.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geekjc.server.modules.system.dto.input.RoleQueryPara;
import com.geekjc.server.modules.system.entity.Role;
import com.geekjc.server.modules.system.mapper.RoleMapper;
import com.geekjc.server.modules.system.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ll
 * @date 2020年02月29日 3:12 PM
 *
 * 系统管理-角色表  服务实现类
 */
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // 解决@Autowired 引入mapper报红的原因
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    private final RoleMapper roleMapper;

    @Override
    public void listPage(Page<Role> page, RoleQueryPara filter) {
        page.setRecords(roleMapper.selectRoles(page, filter));
    }

    @Override
    public List<Role> list(RoleQueryPara filter) {
        return roleMapper.selectRoles(filter);
    }

    @Override
    public boolean save(Role para) {
        if(para.getId() != null) {
            roleMapper.updateById(para);
        } else {
            roleMapper.insert(para);
        }
        return true;
    }
}

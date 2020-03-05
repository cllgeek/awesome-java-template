package com.geekjc.server.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geekjc.server.modules.system.dto.input.RoleMenuQueryPara;
import com.geekjc.server.modules.system.entity.RoleMenu;
import com.geekjc.server.modules.system.mapper.RoleMenuMapper;
import com.geekjc.server.modules.system.service.IRoleMenuService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ll
 * @date 2020年02月29日 4:17 PM
 *
 * 系统管理 - 角色-菜单关联表  服务实现类
 */
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // 解决@Autowired 引入mapper报红的原因
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    private final RoleMenuMapper roleMenuMapper;

    @Override
    public void listPage(Page<RoleMenu> page, RoleMenuQueryPara filter) {
        page.setRecords(roleMenuMapper.selectRoleMenus(page, filter));
    }

    @Override
    public List<RoleMenu> list(RoleMenuQueryPara filter) {
        return roleMenuMapper.selectRoleMenus(filter);
    }

    @Override
    public void saveRoleMenu(RoleMenuQueryPara para) {
        Integer roleId = para.getRoleId();
        String menuIds = para.getMenuIds();
        roleMenuMapper.deleteByRoleId(roleId);
        if(StringUtils.isNotBlank(menuIds)) {
            String[] menuIdArrays = menuIds.split(",");
            if(menuIdArrays.length > 0) {
                for(String menuId : menuIdArrays) {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setRoleId(roleId);
                    roleMenu.setMenuId(Integer.parseInt(menuId));
                    roleMenuMapper.insert(roleMenu);
                }
            }
        }
    }

    @Override
    public boolean save(RoleMenu para) {
        if (para.getId()!=null) {
            roleMenuMapper.updateById(para);
        } else {
            roleMenuMapper.insert(para);
        }
        return true;
    }
}

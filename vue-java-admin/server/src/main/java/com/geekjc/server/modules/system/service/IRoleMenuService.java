package com.geekjc.server.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.geekjc.server.modules.system.dto.input.RoleMenuQueryPara;
import com.geekjc.server.modules.system.entity.RoleMenu;

import java.util.List;

/**
 * @author ll
 * @date 2020/2/29 4:11 PM
 *
 * 系统管理 - 角色-菜单关联表  服务类
 */
public interface IRoleMenuService extends IService<RoleMenu> {
    /**
     * 系统管理 - 角色-菜单关联表 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<RoleMenu> page, RoleMenuQueryPara filter);

    /**
     * 保存系统管理 - 角色-菜单关联表
     *
     * @param input
     * @return
     */
    boolean save(RoleMenu input);

    /**
     * 系统管理 - 角色-菜单关联表 列表
     *
     * @param filter
     * @return
     */
    List<RoleMenu> list(RoleMenuQueryPara filter);

    /**
     * 保存角色相关联菜单
     *
     * @param filter:
     * @return: void
     */
    void saveRoleMenu(RoleMenuQueryPara filter);
}

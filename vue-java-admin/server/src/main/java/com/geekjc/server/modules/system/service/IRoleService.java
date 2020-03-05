package com.geekjc.server.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.geekjc.server.modules.system.dto.input.RoleQueryPara;
import com.geekjc.server.modules.system.entity.Role;

import java.util.List;

/**
 *
 * @author ll
 * @date 2020/2/29 3:07 PM
 *
 * 系统管理-角色表  服务类
 */
public interface IRoleService extends IService<Role> {

    /**
     * 系统管理-角色表 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<Role> page, RoleQueryPara filter);

    /**
     * 保存系统管理-角色表
     *
     * @param input
     * @return
     */
    boolean save(Role input);

    /**
     * 系统管理-角色表 列表
     *
     * @param filter
     * @return
     */
    List<Role> list(RoleQueryPara filter);
}

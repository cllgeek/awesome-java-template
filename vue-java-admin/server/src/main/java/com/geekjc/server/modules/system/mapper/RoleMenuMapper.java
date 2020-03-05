package com.geekjc.server.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geekjc.server.modules.system.dto.input.RoleMenuQueryPara;
import com.geekjc.server.modules.system.entity.Menu;
import com.geekjc.server.modules.system.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author ll
 * @date 2020/2/21 11:03 AM
 * 系统管理 - 角色-菜单关联表  Mapper 接口
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<RoleMenu> selectRoleMenus(Page page, @Param("filter") RoleMenuQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<RoleMenu> selectRoleMenus(@Param("filter") RoleMenuQueryPara filter);

    /**
     * 根据角色Id删除用户与菜单相关联数据
     *
     * @param roleId:
     * @return: void
     */
    void deleteByRoleId(@Param("roleId") Integer roleId);

    /**
     * 根据角色ID查询关联菜单
     *
     * @param roleId:
     * @return: java.util.List<com.geekjc.server.modules.system.entity.Menu>
     */
    List<Menu> selectMenusByRoleId(@Param("roleId") Integer roleId);
}

package com.geekjc.server.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geekjc.server.modules.system.dto.input.RoleQueryPara;
import com.geekjc.server.modules.system.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ll
 * @date 2020年02月11日 9:43 PM
 *
 * 系统管理-角色表  Mapper 接口
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<Role> selectRoles(Page page, @Param("filter") RoleQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<Role> selectRoles(@Param("filter") RoleQueryPara filter);

    /**
     * 通过用户ID查询角色集合
     *
     * @param userId:
     * @return: java.util.List<Role>
     */
    List<Role> selectRoleByUserId(@Param("userId") Integer userId);

    /**
     * 通过菜单ID查询角色集合
     *
     * @param menuId:
     * @return: java.util.List<Role>
     */
    List<Role> selectRoleByMenuId(@Param("menuId") Integer menuId);
}

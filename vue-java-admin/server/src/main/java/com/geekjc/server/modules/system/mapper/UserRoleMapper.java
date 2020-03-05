package com.geekjc.server.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geekjc.server.modules.system.dto.input.UserRoleQueryPara;
import com.geekjc.server.modules.system.entity.Role;
import com.geekjc.server.modules.system.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author ll
 * @date 2020/2/12 11:08 AM
 *
 * 系统管理 - 用户角色关联表  Mapper 接口
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<UserRole> selectUserRoles(Page page, @Param("filter")UserRoleQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<UserRole> selectUserRoles(@Param("filter") UserRoleQueryPara filter);

    /**
     * 根据角色Id删除用户与角色相关联数据
     *
     * @param roleId:
     * @return: void
     */
    void deleteByRoleId(@Param("roleId") Integer roleId);

    /**
     * 根据用户Id查询关联角色
     *
     * @param userId:
     * @return: java.util.List<com.geekjc.server.modules.system.entity.Role>
     */
    List<Role> selectRoleByUserId(@Param("userId") Integer userId);
}

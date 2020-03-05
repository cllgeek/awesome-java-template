package com.geekjc.server.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geekjc.server.modules.system.dto.input.MenuQueryPara;
import com.geekjc.server.modules.system.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author ll
 * @date 2020/2/20 11:59 AM
 * 系统管理-菜单表  Mapper 接口
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<Menu> selectMenus(Page page, @Param("filter") MenuQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<Menu> selectMenus(@Param("filter") MenuQueryPara filter);

    /**
     * 通过菜单编码获取信息
     *
     * @param resources:
     * @return: com.geekjc.server.modules.system.entity.Menu
     */
    Menu findByResources(@Param("resources") String resources);

    /**
     * 根据角色查询用户权限
     *
     * @param roleId:
     * @return: java.util.List<com.geekjc.server.modules.system.entity.Menu>
     */
    List<Menu> selectMenuByRoleId(@Param("roleId") Integer roleId);
}

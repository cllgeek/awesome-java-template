package com.geekjc.server.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.geekjc.server.modules.system.dto.input.MenuQueryPara;
import com.geekjc.server.modules.system.entity.Menu;

import java.util.List;

/**
 *
 * @author ll
 * @date 2020/2/29 6:35 PM
 *
 * 系统管理-菜单表  服务类
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 菜单树
     *
     * @param :
     * @return: java.util.List<com.geekjc.server.modules.system.entity.Menu>
     */
    List<Menu> listTreeMenu();

    /**
     * 系统管理-菜单表 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<Menu> page, MenuQueryPara filter);

    /**
     * 保存系统管理-菜单表
     *
     * @param input
     */
    boolean save(Menu input);

    /**
     * 系统管理-菜单表 列表
     *
     * @param filter
     * @return
     */
    List<Menu> list(MenuQueryPara filter);
}

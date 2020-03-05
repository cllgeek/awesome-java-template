package com.geekjc.server.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geekjc.server.modules.system.dto.input.MenuQueryPara;
import com.geekjc.server.modules.system.entity.Menu;
import com.geekjc.server.modules.system.mapper.MenuMapper;
import com.geekjc.server.modules.system.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ll
 * @date 2020年02月29日 6:40 PM
 *
 * 系统管理-菜单表  服务实现类
 */
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // 解决@Autowired 引入mapper报红的原因
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    private final MenuMapper menuMapper;

    @Override
    public List<Menu> listTreeMenu() {
        return menuMapper.selectList(null);
    }

    @Override
    public void listPage(Page<Menu> page, MenuQueryPara filter) {
        page.setRecords(menuMapper.selectMenus(page, filter));
    }

    @Override
    public List<Menu> list(MenuQueryPara filter) {
        return menuMapper.selectMenus(filter);
    }

    @Override
    public boolean save(Menu para) {
        if(para.getId()!=null) {
            menuMapper.updateById(para);
        } else {
            menuMapper.insert(para);
        }
        return true;
    }
}

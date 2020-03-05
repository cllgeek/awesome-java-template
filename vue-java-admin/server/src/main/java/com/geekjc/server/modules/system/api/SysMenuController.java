package com.geekjc.server.modules.system.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geekjc.server.modules.common.api.BaseController;
import com.geekjc.server.modules.common.dto.output.ApiResult;
import com.geekjc.server.modules.system.dto.input.MenuQueryPara;
import com.geekjc.server.modules.system.dto.output.MenuTreeNode;
import com.geekjc.server.modules.system.entity.Menu;
import com.geekjc.server.modules.system.service.IMenuService;
import com.geekjc.server.utils.TreeBuilder;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ll
 * @date 2020年02月29日 6:32 PM
 *
 * 系统管理-菜单表  接口
 */
@RestController
@RequestMapping("/api/system/menu")
@Api(value = "系统管理 - 菜单表 接口")
public class SysMenuController extends BaseController {

    @Autowired
    IMenuService menuService;

    @PostMapping(value = "/treeMenu")
    @ApiOperation(value = "获取菜单树", httpMethod = "POST")
    public ApiResult treeMenu() {
        List<Menu> list = menuService.listTreeMenu();
        List<MenuTreeNode> menuTreeNodeList = Lists.newArrayList();
        if(list != null && !list.isEmpty()) {
            list.forEach(temp -> {
                MenuTreeNode menuTreeNode = new MenuTreeNode();
                BeanUtil.copyProperties(temp, menuTreeNode);
                menuTreeNodeList.add(menuTreeNode);
            });
        }
        List<MenuTreeNode> menuTreeNodeList2 = TreeBuilder.buildMenuTree(menuTreeNodeList);

        menuTreeNodeList2.stream().sorted(Comparator.comparing(MenuTreeNode::getSortNo)).collect(Collectors.toList());
        JSONObject json = new JSONObject();
        json.put("menuList", list);
        json.put("menuTree", menuTreeNodeList2);
        return ApiResult.ok("获取菜单树成功", json);
    }

    // 下面暂时不用 ================================================

    @PostMapping(value = "/listPage", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取系统管理-菜单表 列表分页", httpMethod = "POST")
    public ApiResult listPage(@RequestBody MenuQueryPara filter) {
        Page<Menu> page = new Page<>(filter.getPage(),filter.getLimit());
        menuService.listPage(page, filter);
        return ApiResult.ok("获取系统管理-菜单表 列表分页成功", page);
    }

    @PostMapping(value = "/list", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取系统管理-菜单表 列表", httpMethod = "POST")
    public ApiResult list(@RequestBody MenuQueryPara filter) {
        List<Menu> result = menuService.list(filter);
        return ApiResult.ok("获取系统管理-菜单表 列表成功",result);
    }

    @PostMapping(value = "/getById", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取系统管理-菜单表 信息", httpMethod = "POST")
    public ApiResult getById(@RequestBody MenuQueryPara input) {
        Menu entity = menuService.getById(input.getId());
        return ApiResult.ok("获取系统管理-菜单表 信息成功", entity);
    }
}

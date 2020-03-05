package com.geekjc.server.modules.system.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geekjc.server.modules.common.api.BaseController;
import com.geekjc.server.modules.common.dto.output.ApiResult;
import com.geekjc.server.modules.system.dto.input.RoleMenuQueryPara;
import com.geekjc.server.modules.system.entity.RoleMenu;
import com.geekjc.server.modules.system.service.IRoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ll
 * @date 2020年02月29日 4:05 PM
 *
 * 系统管理 - 角色-菜单关联表  接口
 */
@RestController
@RequestMapping("/api/system/roleMenu")
@Api(value = "系统管理 - 角色-菜单关联表 接口")
public class SysRoleMenuController extends BaseController {

    @Autowired
    IRoleMenuService roleMenuService;

    @PostMapping(value = "/listPage")
    @ApiOperation(value = "获取系统管理 - 角色-菜单关联表 列表分页", httpMethod = "POST")
    public ApiResult listPage(@RequestBody RoleMenuQueryPara filter) {
        Page<RoleMenu> page = new Page<>(filter.getPage(),filter.getLimit());
        roleMenuService.listPage(page, filter);
        return ApiResult.ok("获取系统管理 - 角色-菜单关联表 列表分页成功", page);
    }

    @PostMapping(value = "/list")
    @ApiOperation(value = "获取系统管理 - 角色-菜单关联表 列表", httpMethod = "POST")
    public ApiResult list(@RequestBody RoleMenuQueryPara filter) {
        List<RoleMenu> result = roleMenuService.list(filter);
        return ApiResult.ok("获取系统管理 - 角色-菜单关联表 列表成功", result);
    }

    @PostMapping(value = "saveOrUpdate")
    @ApiOperation(value = "保存或更新系统管理 - 角色-菜单关联表", httpMethod = "POST")
    public ApiResult saveOrUpdate(@RequestBody RoleMenu input) {
        boolean id = roleMenuService.save(input);
        return ApiResult.ok("保存系统管理 - 角色-菜单关联表 成功", id);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "删除系统管理 - 角色-菜单关联表 ", httpMethod = "POST", response = ApiResult.class)
    public ApiResult delete(@RequestBody RoleMenuQueryPara input) {
        roleMenuService.removeById(input.getId());
        return ApiResult.ok("删除系统管理 - 角色-菜单关联表 成功");
    }

    @PostMapping(value = "/detail", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "根据ID获取系统管理 - 角色-菜单关联表 信息", httpMethod = "POST", response = ApiResult.class)
    public ApiResult detail(@RequestBody RoleMenuQueryPara input) {
        RoleMenu entity = roleMenuService.getById(input.getId());
        return ApiResult.ok("根据ID获取系统管理 - 角色-菜单关联表 信息成功", entity);
    }

    @PostMapping(value = "/saveRoleMenu", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "保存角色相关联菜单", httpMethod = "POST", response = ApiResult.class)
    public ApiResult saveRoleMenu(@RequestBody RoleMenuQueryPara input) {
        roleMenuService.saveRoleMenu( input );
        return ApiResult.ok("保存角色相关联菜单成功");
    }
}

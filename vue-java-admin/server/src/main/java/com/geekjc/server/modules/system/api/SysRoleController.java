package com.geekjc.server.modules.system.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geekjc.server.modules.common.api.BaseController;
import com.geekjc.server.modules.common.dto.output.ApiResult;
import com.geekjc.server.modules.system.dto.input.RoleQueryPara;
import com.geekjc.server.modules.system.entity.Role;
import com.geekjc.server.modules.system.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ll
 * @date 2020年02月29日 3:00 PM
 *
 * 系统管理-角色表  接口
 */
@RestController
@RequestMapping("/api/system/role")
@Api(value = "系统管理-角色表 接口")
public class SysRoleController extends BaseController {

    @Autowired
    IRoleService roleService;

    @PostMapping(value = "listPage")
    @ApiOperation(value = "获取系统管理-角色表 列表分页", httpMethod = "POST")
    public ApiResult<Page<Role>> listPage(@RequestBody RoleQueryPara filter) {
        Page<Role> page = new Page<>(filter.getPage(), filter.getLimit());
        roleService.listPage(page, filter);
        return ApiResult.ok("获取系统管理-角色表 列表分页成功", page);
    }

    @PostMapping(value = "/saveOrUpdate")
    @ApiOperation(value = "保存或更新角色", httpMethod = "POST")
    public ApiResult saveOrUpdate(@RequestBody @Validated Role input) {
        boolean id = roleService.save(input);
        return ApiResult.ok("保存角色成功", id);
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除角色", httpMethod = "POST")
    public ApiResult delete(@RequestBody RoleQueryPara input) {
        roleService.removeById(input.getId());
        return ApiResult.ok("删除角色成功");
    }

    @PostMapping(value = "/detail")
    @ApiOperation(value = "获取角色信息", httpMethod = "POST")
    public ApiResult detail(@RequestBody RoleQueryPara input) {
        Role entity = roleService.getById(input.getId());
        return ApiResult.ok("获取角色信息成功", entity);
    }
}

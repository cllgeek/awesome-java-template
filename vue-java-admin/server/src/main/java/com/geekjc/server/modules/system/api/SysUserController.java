package com.geekjc.server.modules.system.api;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geekjc.server.modules.common.api.BaseController;
import com.geekjc.server.modules.common.dto.output.ApiResult;
import com.geekjc.server.modules.system.dto.input.UserQueryPara;
import com.geekjc.server.modules.system.dto.model.UserInfoVO;
import com.geekjc.server.modules.system.dto.output.UserTreeNode;
import com.geekjc.server.modules.system.entity.User;
import com.geekjc.server.modules.system.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ll
 * @date 2020年02月28日 2:20 PM
 *
 * 系统管理-用户基础信息表 接口
 */
@RestController
@RequestMapping("/api/system/user")
@Api(value = "系统管理-用户基础信息表接口")
public class SysUserController extends BaseController {

    @Autowired
    IUserService userService;

    @PostMapping(value = "/getCurrentUserInfo")
    @ApiOperation(value = "获取当前登录用户信息", httpMethod = "POST", notes = "获取当前登录用户信息")
    public ApiResult<UserInfoVO> getCurrentUserInfo(@RequestHeader(name = "X-Token") String token) {
        UserInfoVO info = userService.getCurrentUserInfo(token);
        return ApiResult.ok(200, "获取当前登录用户信息成功", info);
    }

    @PostMapping(value = "/listPage")
    @ApiOperation(value = "获取系统管理-用户基础信息表列表分页", httpMethod = "POST")
    public ApiResult<Page> listPage(@RequestBody UserQueryPara filter) {
        Page<User> page = new Page<>(filter.getPage(), filter.getLimit());
        userService.listPage(page, filter);
        return ApiResult.ok("获取系统管理-用户基础信息表列表分页成功", page);
    }

    @PostMapping(value = "/treeUser")
    @ApiOperation(value = "获取用户树", httpMethod = "POST")
    public ApiResult treeUser() {
        List<User> list = userService.list(null);
        List<UserTreeNode> userTreeNodeList = new ArrayList<>();
        list.forEach(temp -> {
            UserTreeNode userTreeNode = new UserTreeNode();
            BeanUtil.copyProperties(temp, userTreeNode);
            userTreeNodeList.add(userTreeNode);
        });
        JSONObject json = new JSONObject();
        json.put("userList", list);
        json.put("userTree", userTreeNodeList);
        return ApiResult.ok("获取用户树成功", json);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存系统管理-用户基础信息表", httpMethod = "POST")
    // groups和默认校验同时应用 - 没有groups的属性和有groups的属性要想同时校验，则必须在value数组中同时指明，启动没有groups的属性通过Default.class来指定
    public ApiResult save(@RequestBody @Validated User input) {
        Boolean id = userService.save(input);
        return ApiResult.ok("保存系统管理-用户基础信息表成功", id);
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除系统管理-用户基础信息表", httpMethod = "POST")
    public ApiResult delete(@RequestBody UserQueryPara input) {
        userService.removeById(input.getId());
        return ApiResult.ok("删除系统管理-用户基础信息表成功");
    }
}

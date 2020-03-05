package com.geekjc.server.modules.system.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geekjc.server.modules.common.api.BaseController;
import com.geekjc.server.modules.common.dto.output.ApiResult;
import com.geekjc.server.modules.system.dto.input.LogQueryPara;
import com.geekjc.server.modules.system.entity.SysLog;
import com.geekjc.server.modules.system.service.ILogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ll
 * @date 2020年03月02日 11:27 AM
 *
 * 系统管理 - 日志表 接口
 */
@RestController
@RequestMapping("/api/system/log")
@Api(value = "系统管理 - 日志表接口")
public class SysLogController extends BaseController {

    @Autowired
    ILogService logService;

    @PostMapping(value = "/listPage", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取系统管理 - 日志表列表分页", httpMethod = "POST", response = ApiResult.class)
    public ApiResult listPage(@RequestBody LogQueryPara filter) {
        Page<SysLog> page = new Page<>(filter.getPage(),filter.getLimit());
        logService.listPage(page, filter);
        return ApiResult.ok("获取系统管理 - 日志表列表分页成功", page);
    }
}

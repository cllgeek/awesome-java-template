package com.geekjc.server.modules.basic.api;

import com.geekjc.server.modules.common.api.BaseController;
import com.geekjc.server.modules.common.dto.output.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ll
 * @date 2020年02月27日 10:48 AM
 *
 * 首页
 */
@RestController
@Api(value = "首页-接口")
public class IndexController extends BaseController {

    @GetMapping(value = "/login", produces = "applicaiton/json;charset=utf-8")
    @ApiOperation(value = "登录系统", httpMethod = "GET", response = ApiResult.class)
    public ApiResult login() {
        return new ApiResult().ok("登录系统成功", null);
    };
}

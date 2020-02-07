package com.geekjc.spring_security_04.modules.basic.api;

import com.geekjc.spring_security_04.modules.common.api.BaseController;
import com.geekjc.spring_security_04.modules.common.dto.output.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  <p> 首页 </p>
 *
 * @description :
 * @author : ll
 * @date : 2019/8/19 13:49
 */
@RestController
@Api(description = "首页-接口")
public class IndexController extends BaseController {

    @GetMapping(value = "/login", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "登录系统", httpMethod = "GET", response = ApiResult.class)
    public ApiResult login() {
        return ApiResult.ok("登录系统成功", null);
    }

}

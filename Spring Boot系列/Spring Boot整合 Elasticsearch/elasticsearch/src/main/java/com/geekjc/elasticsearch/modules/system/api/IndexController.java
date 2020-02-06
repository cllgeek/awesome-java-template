package com.geekjc.elasticsearch.modules.system.api;

import com.geekjc.elasticsearch.modules.common.api.BaseController;
import com.geekjc.elasticsearch.modules.common.dto.output.ApiResult;
import com.geekjc.elasticsearch.modules.common.validator.response.ResponseResult;
import com.geekjc.elasticsearch.modules.system.entity.SysLog;
import com.geekjc.elasticsearch.modules.system.service.ILogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p> 测试 - 控制层 </p>
 *
 * @author : ll
 * @description :
 * @date : 2019/11/27 12:44
 */
@RestController
@RequestMapping("/api")
@Api(description = "测试-接口")
//@ResponseResult
public class IndexController extends BaseController {

    @Autowired
    private ILogService logService;

    @PostMapping(value = "/saveData", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "保存数据", httpMethod = "POST", response = ApiResult.class)
    public ApiResult saveData(@RequestBody SysLog sysLog) {
        SysLog result = logService.saveOrUpdate(sysLog);
        return ApiResult.ok();
    }

    @GetMapping(value = "/getData", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取数据", httpMethod = "GET", response = ApiResult.class)
    public ApiResult getData() {
        List<SysLog> result = logService.selectList(null);
        return ApiResult.ok("SUCCESS", result);
    }

    @GetMapping(value = "/index", produces = "application/json;charset=utf-8")
    public ApiResult index() {
        return ApiResult.ok("Hello World ~ ");
    }

}

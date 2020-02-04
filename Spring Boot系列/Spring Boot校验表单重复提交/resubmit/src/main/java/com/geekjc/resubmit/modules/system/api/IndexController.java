package com.geekjc.resubmit.modules.system.api;

import com.geekjc.resubmit.modules.common.api.BaseController;
import com.geekjc.resubmit.modules.common.dto.output.ApiResult;
import com.geekjc.resubmit.modules.common.validator.NoRepeatSubmit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ll
 * @date 2020年02月04日 1:57 PM
 */
@RestController
public class IndexController extends BaseController {

    @NoRepeatSubmit
    @GetMapping(value = "/index", produces = "application/json;charset=utf-8")
    public ApiResult index() {
        return ApiResult.ok("Hello World ~ ");
    }

}

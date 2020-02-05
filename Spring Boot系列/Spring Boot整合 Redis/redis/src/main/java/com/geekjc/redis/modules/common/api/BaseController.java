package com.geekjc.redis.modules.common.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ll
 * @date 2020年02月04日 9:02 PM
 * 基类
 */
@Slf4j
@RestController
public class BaseController {

    public Logger logger = LoggerFactory.getLogger(getClass());

}

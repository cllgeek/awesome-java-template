package com.geekjc.server.modules.common.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ll
 * @date 2020年02月27日 10:55 AM
 *
 * 基类
 */
@RestController
@Slf4j
public class BaseController {
    public Logger LOG = LoggerFactory.getLogger( getClass() );
}

package com.geekjc.rabbitmq.modules.rabbitmq.controller;

import com.geekjc.rabbitmq.modules.common.dto.output.ApiResult;
import com.geekjc.rabbitmq.modules.rabbitmq.producer.MsgSender;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ll
 * @date 2020年02月06日 3:39 PM
 */
@RestController
public class RabbitController {

    @Autowired
    private MsgSender msgSender;

    @GetMapping(value = "/sendMsg", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "发送消息", httpMethod = "GET", response = ApiResult.class)
    public ApiResult sendMsg() {
        msgSender.send();
        return ApiResult.ok();
    }

}

package com.geekjc.resubmit.modules.common.dto.input;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ll
 * @date 2020年02月04日 2:04 PM
 * 应用基础传入参数
 */
@ApiModel(description = "应用基础传入参数")
@Data
public class BaseInput {
    @ApiModelProperty(value = "令牌")
    @JSONField(name = "token")
    private String token;
}
